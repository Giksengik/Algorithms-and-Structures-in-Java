import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        long sum = 0;
        long max = Long.MIN_VALUE;
        for (int  i = 1; i <= n; ++i) {
            sum += in.nextInt();
            if (sum > max) max = sum;
            if(sum < 0) sum = 0;
        }
        System.out.println(max);
    }
}
