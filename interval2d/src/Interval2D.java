import java.util.ArrayList;
import java.util.Random;
import exdu.princeton.cs.algs4.StdRandom;
public class Interval2D {
    private double topY;
    private  double botY;
    private double leftX;
    private double rightX;

    public Interval2D(double topY, double botY, double leftX, double rightX) {
        this.topY = topY;
        this.botY = botY;
        this.leftX = leftX;
        this.rightX = rightX;
    }
    private static void informWrongInput () {
        System.out.println("Wrong input. Min and max should must be in the range 0 to 2, max > min");
    }
    private static double getRandomDouble(){
        Random rand =  new Random();
        double first = rand.nextInt(1000);
        return first / 500;
    }
    private static void generateRandom2DInterval(ArrayList<Interval2D> intervals, double min, double max){
        double currentMax = -1;
        double currentMin = 3;
        while( currentMin < min && currentMin > max) currentMin = getRandomDouble();
        while( currentMax < currentMin && currentMax > max) currentMax = getRandomDouble();

    }
    public static ArrayList<Interval2D> makeNIntervalsInBordersOfMinAndMax (int N, double max, double min) {
        if( N < 1 || max < min || max > 2 || min < 0) informWrongInput();
        else{
            ArrayList<Interval2D> intervals = new ArrayList<>();
            for(int i = 0; i < N; i++) generateRandom2DInterval(intervals, min, max);
        }

    }
    public double getTopY() {
        return topY;
    }

    public void setTopY(double topY) {
        this.topY = topY;
    }

    public double getBotY() {
        return botY;
    }

    public void setBotY(double botY) {
        this.botY = botY;
    }

    public double getLeftX() {
        return leftX;
    }

    public void setLeftX(double leftX) {
        this.leftX = leftX;
    }

    public double getRightX() {
        return rightX;
    }

    public void setRightX(double rightX) {
        this.rightX = rightX;
    }
}
