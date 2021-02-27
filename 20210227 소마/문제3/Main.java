
import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int E = sc.nextInt();

        int[] Peanut = new int[N];
        int minInd=0;
        int maxInd=0;
        for (int i = 0; i < N; i++) {
            Peanut[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            if(Peanut[i]<E){
                minInd = i;
            }
            if(Peanut[i]>E){
                maxInd = i;
                break;
            }
        }

        // 빨간 라인 범위
        int x = E, y = E;
        int i = 0;
        while (i < M) {
            int a ,b;
            if(minInd>0){
                a=Math.abs(Peanut[minInd]-x);
            }
            else{
                a = -1;
            }
            if(maxInd < N){
                b = Math.abs(Peanut[maxInd]-y);
            }else{
                b = -1;
            }
            if(a <= b){
                x = Peanut[minInd];
                i++;
                minInd --;
            }else{
                y = Peanut[maxInd];
                i++;
                maxInd++;
            }

        }
        System.out.println(y-x);
    }
}

