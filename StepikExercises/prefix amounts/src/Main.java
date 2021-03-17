import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer tokenizer = null;
    private static BufferedReader in = null;
    private static String getNextToken() {
        try {
            if (in == null) {
                in = new BufferedReader(new InputStreamReader(System.in));
            }
            if (tokenizer == null || !tokenizer.hasMoreElements()) {
                tokenizer = new StringTokenizer(in.readLine());
                return tokenizer.nextToken();
            }
            return tokenizer.nextToken();
        } catch (IOException ignore) {
            //ignore
        }
        return "";
    }
    public static void main(String[] args) throws IOException {
        final int MAX = 300500;
        int [] a = new int[MAX];
        long [] partSum = new long[MAX];

        Scanner in = new Scanner(System.in);
        long n = in.nextInt();
        int q = in.nextInt();
        partSum[0] = 0;
        for (int  i = 1; i <= n; ++i) {
            int b = Integer.parseInt(getNextToken());
            a[i] = b;
            partSum[i] = partSum[i - 1] + a[i];
        }

        for (int query = 0; query < q; ++query) {
            int l,r;
            l = in.nextInt();
            r = in.nextInt();
            System.out.println(partSum[r] - partSum[l - 1]);
        }
    }
}
