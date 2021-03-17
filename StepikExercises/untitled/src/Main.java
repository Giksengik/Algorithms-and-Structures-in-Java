import java.util.Scanner;

class Main{
    void main(){
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int queries = in.nextInt();
        int l = -1;
        int mid = 0;
        for (int i = 0;i < queries; i++) {
            int current = in.nextInt();
            if(current == 1) r = current;
            else l = current;
            mid =(r+l)/2;
        }
        System.out.println(mid);
    }
}
