import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Point2D {
    private int x;
    private int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public static ArrayList<Point2D> getNRandomPoints(int N){
        Random rand = new Random();
        ArrayList <Point2D> points = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            points.add(new Point2D(rand.nextInt(1000), rand.nextInt(1000)));
        }
        return points;
    }
    public static double getDistance(Point2D firstPoint, Point2D secondPoint) {
        return Math.sqrt( Math.pow(Math.abs(firstPoint.getX() - secondPoint.getX()),2)  +
                Math.pow(Math.abs(firstPoint.getY() - secondPoint.getY()),2) );
    }
    public static double getShortestDistance(ArrayList<Point2D> points){
        double min = 100000;
        for (int i = 0; i < points.size(); i++) {
            for(int j = i+1; j < points.size(); j++){
                if(getDistance(points.get(i), points.get(j)) < min) min =getDistance(points.get(i), points.get(j));
            }
        }
        if(min == 100000) return -1;
        else return min;
    }
}
