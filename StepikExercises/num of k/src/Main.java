import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int queries = in.nextInt();
        int l = -1;
        int mid = 0;
        for (int i = 0;i < queries; i++) {
            mid =(r+l)/2;
            int current = in.nextInt();
            if(current == 0) l = mid;
            else r = mid;
        }
        System.out.println(r);
    }
}
