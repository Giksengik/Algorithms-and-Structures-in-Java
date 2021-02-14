import java.util.ArrayList;
import java.util.Scanner;

public class Interval1D {
    double leftBorder;
    double rightBorder;

    public Interval1D(double leftBorder, double rightBorder) {
        this.leftBorder = leftBorder;
        this.rightBorder = rightBorder;
    }
    public static ArrayList<Interval1D> generateNIntervals(int N) {
        int i = 0;
        ArrayList<Interval1D> intervals = new ArrayList<>();
        printInstructionToIntroduceNIntervals(N);
        if(N <= 0){
        informWrongInputAmountOfIntervals();
        }else {
            while (i < N) {
                if (introduceIntervalByConsole(intervals)) {
                    i++;
                }
            }
        }
        return intervals;
    }
    private static void informWrongInputAmountOfIntervals () {
        System.out.println(" The number of intervals must be greater than 0");
    }
    private static void informWrongInputIntervals () {
        System.out.println("Wrong input!Left border should be less than right");
    }
    private static void printInstructionToIntroduceNIntervals(int N){
        System.out.println("First enter the coordinate of the left border and then the right " + N + " times");
    }
    private static boolean introduceIntervalByConsole(ArrayList<Interval1D> intervals){
        Scanner in =  new Scanner(System.in);
        double left = in.nextDouble();
        double right = in.nextDouble();
        if(right >= left) {
            intervals.add(new Interval1D(left, right));
            return true;
        }
        else {
            informWrongInputIntervals();
            return false;
        }
    }
    private static String intervalToString(Interval1D interval){
        return "["+interval.getLeftBorder()+"; "+interval.getRightBorder()+"]";
    }
    private static void printCrossingOfIntervals(Interval1D firstInterval, Interval1D secondInterval){
        System.out.println("Interval  "+ intervalToString(firstInterval) + " crossing " + intervalToString(secondInterval));
    }
    public static void getCrossingOfIntervals (ArrayList<Interval1D> intervals){
        for (int  i = 0; i < intervals.size(); i ++) {
            for(int j = i + 1; j < intervals.size(); j++){
                if( intervals.get(i).getLeftBorder() >=  intervals.get(j).getLeftBorder() &&
                        intervals.get(i).getLeftBorder() <=  intervals.get(j).getRightBorder()){
                    printCrossingOfIntervals(intervals.get(i),  intervals.get(j));
                }else if(intervals.get(j).getLeftBorder() >=  intervals.get(i).getLeftBorder() &&
                        intervals.get(j).getLeftBorder() <=  intervals.get(i).getRightBorder()){
                    printCrossingOfIntervals(intervals.get(i),  intervals.get(j));
                }
            }
        }

    }
    public double getLeftBorder() {
        return leftBorder;
    }

    public void setLeftBorder(double leftBorder) {
        this.leftBorder = leftBorder;
    }

    public double getRightBorder() {
        return rightBorder;
    }

    public void setRightBorder(double rightBorder) {
        this.rightBorder = rightBorder;
    }
}
