
import java.util.ArrayList;

class Solution {
    static int[] monthLastDay = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public int solution(String[] holidays, int k) {
        int answer = -1;
        int[][] calender = new int[13][32];
        int[][] holidaysArr = new int[400][2];

        int i = 0;
        for (String input : holidays) {
            int m = Integer.parseInt(input.split("/")[0]);
            int d = Integer.parseInt(input.split("/")[1]);
            calender[m][d] = 1;
            holidaysArr[i][0] = m;
            holidaysArr[i][1] = d;
            i++;
        }

        boolean[][] flags = new boolean[13][32];
        ArrayList<Integer> list = new ArrayList<Integer>();
        int tmp = 1;
        for (int[] holi : holidaysArr) {
            int m = holi[0];
            int d = holi[1];
            tmp = 0;
            while (true) {
                if (flags[m][d]) {
                    break;
                }
                flags[m][d] = true;
                if (calender[m][d] == 1) {
                    tmp++;
                    d++;
                    if (d > monthLastDay[m]) {
                        d = 1;
                        m++;
                    }
                } else {
                    int day = isHolyday(m, d);
                    if (day == 5 || day == 6) {
                        calender[m][d] = 1;
                    } else {
                        if(!list.contains(tmp)){
                            list.add(tmp);
                        }
                        break;
                    }
                }
            }
        }
        list.sort(null);
        answer = list.get(k);
        return answer;
    }

    public int isHolyday(int m, int d) {
        while (m > 1) {
            m--;
            d += monthLastDay[m];
        }
        // 0 ~ 6 : 월 ~ 일
        for (int i = 1; i <= 7; i++) {
            if (d % 7 == i) {
                i += 7;
                i -= 3;
                return i % 7;
            }
        }
        return 0;
    }
}