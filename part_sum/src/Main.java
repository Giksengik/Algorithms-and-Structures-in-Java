import java.util.Scanner;

public class Main {

    // На вход подаётся n чисел
    // Необходимо найти q сумм чисел с индексами от l до r
    // Алгоритм реализуется за O(n)!!!
    
    public static void main(String[] args) {
        final int MAX = 10000500;
        int n;
        int [] a = new int[MAX];
        int  [] partSum = new int[MAX];
	    Scanner in = new Scanner(System.in);
	    n = in.nextInt();
	    partSum[0] = 0;
	    for (int  i = 1; i <= n; ++i) {
	        a[i] = in.nextInt();
	        partSum[i] = partSum[i - 1] + a[i];
        }

	    // Обработка запросов
	    int q = in.nextInt();
	    for (int query = 0; query < q; ++query) {
	        int l,r;
	        l = in.nextInt();
	        r = in.nextInt();
	        System.out.println(partSum[r] - partSum[l - 1]);
        }
    }
}
