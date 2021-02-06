import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public String[] solution(int[][] line) {
        HashMap<Integer, ArrayList<Integer>> xys = new HashMap<Integer, ArrayList<Integer>>();

        int[] min = {1000, 1000};
        int[] max = {-1001, -1001};
        for (int i = 0; i < line.length - 1; i++) {
            int A, B, E;
            A = line[i][0];
            B = line[i][1];
            E = line[i][2];
            for (int j = i+1; j < line.length; j++) {
                int C, D, F;
                C = line[j][0];
                D = line[j][1];
                F = line[j][2];

                if (A * D - B * C == 0) {
                    continue;
                } else {
                    float x = (B * F - E * D) / (float)(A * D - B * C);
                    float y = (E * C - A * F) / (float)(A * D - B * C);

                    if (x % 1 == 0) {
                        if(xys.get((int) y) == null) 
                            xys.put((int) y, new ArrayList<Integer>());
                        xys.get((int) y).add((int) x);

                        if(x>max[0]){
                            max[0] = (int) x;
                        }else if(x<min[0]){
                            min[0] = (int) x;
                        }

                        if(y>max[1]){
                            max[1] = (int) y;
                        }else if(y<min[1]){
                            min[1] = (int) y;
                        }
                    }
                }
            }
        }
        int k=0;
        String[] answer = new String[max[1]-min[1]+1];
        for(int i = max[1];i>=min[1];i--) {
        	ArrayList<Integer> list = xys.get(i);
        	String output ="";
        	if(list!=null)
        		list.sort(null);
        	for(int j = min[0];j<=max[0];j++) {
        		if(list!=null && list.size()!=0 && j == list.get(0)) {
        			list.remove(0);
        			output+="*";
        		}else
        			output +=".";
        	}
        	answer[k] = output;
        	k++;
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
		Solution s = new Solution();

		int[][] list = { {2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12} };
		s.solution(list);
        
    }
}
