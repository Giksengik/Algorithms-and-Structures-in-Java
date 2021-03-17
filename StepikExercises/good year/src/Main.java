import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int [] digits = new int[10];
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int cur = -1;
        for(int i = n + 1; i < 100000000; i++ ){
            String s = i + "";
            for(int j = 0; j < s.length(); j++){
                digits[s.charAt(j)-'0']++;
            }
            if(digits[0] == 0 && digits[2] == 0) {
                boolean isOk = true;
                for (int j = 0; j < 10; j++) {
                    if(digits[j] > 1) isOk = false;
                }
                if(isOk) {
                    cur =  i;
                    break;
                }
            }
            digits = new int[10];
        }
        System.out.println(cur);
    }
}
