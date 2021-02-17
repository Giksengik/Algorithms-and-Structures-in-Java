import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int count = 0;
        Scanner in =  new Scanner(System.in);
        int  N = in.nextInt();
        for (int i = 0 ;i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    count++;
                }
            }
        }
        System.out.println("N*(N-1)*(N-2)/6 = "+( N * (N - 1) * (N - 2) / 6));
        System.out.println("Count = "+count);
    }
}