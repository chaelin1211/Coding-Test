import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

class Main {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int p = sc.nextInt();
        int n = sc.nextInt();
        int h = sc.nextInt();

        int[] pcTimes = new int[p + 1];
        int x, y;

        HashMap<Integer, ArrayList<Integer>> pcOrder = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            x = sc.nextInt();
            y = sc.nextInt();

            if(pcOrder.get(x)==null){
                pcOrder.put(x, new ArrayList<Integer>());
            }

            if (y > h) {
                continue;
            }
            pcOrder.get(x).add(y);
        }

        for(int num : pcOrder.keySet()){
            ArrayList<Integer> list = pcOrder.get(num);
            Collections.reverse(list);
            for(int time:list ){
                if(pcTimes[num]+time>h){
                    continue;
                }
                pcTimes[num]+=time;
            }
        }
        for(int i = 1;i<=p;i++){
            System.out.println(i+" "+pcTimes[i]*1000);
        }
    }
}