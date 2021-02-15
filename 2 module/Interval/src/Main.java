import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Interval1D> intervals = Interval1D.generateNIntervals(in.nextInt());
        Interval1D.getCrossingOfIntervals(intervals);
    }
}
