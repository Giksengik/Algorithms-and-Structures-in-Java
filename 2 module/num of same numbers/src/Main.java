import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static int getFactorial(int N){
        if(N < 2) return 1;
        else return N * getFactorial(N-1);
    }
    public static int countNumOfCombinations(int N) {
        return getFactorial(N)/(getFactorial(2)*getFactorial(N-2));
    }
    public static void main(String[] args) {
        int[] array = null;
        try (BufferedReader in = new BufferedReader(new FileReader("numbers.txt")))
        {
            array = in.lines().mapToInt(Integer::parseInt).toArray();
        }
        catch (IOException | NumberFormatException e)
        {
            e.printStackTrace();
        }
        if (array != null) {
            Arrays.sort(array);
            int currentNum = 0;
            int count = 0;
            int countOfCombinationElements = 1;
            boolean isFirstElementChecked = false;
            for (int j : array) {
                if (!isFirstElementChecked) {
                    isFirstElementChecked = true;
                    currentNum = j;
                } else {
                    if (j == currentNum) countOfCombinationElements++;
                    else {
                        count += countNumOfCombinations(countOfCombinationElements);
                        currentNum = j;
                        countOfCombinationElements = 1;
                    }
                }
            }
            System.out.println(count);
            }
        }
    }

