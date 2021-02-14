import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        ArrayList<Point2D> points = Point2D.getNRandomPoints(N);
        System.out.println(Point2D.getShortestDistance(points));
    }
}
