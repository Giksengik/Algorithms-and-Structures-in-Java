public class ArrayComparator {
    public static void compareAndPrintResults (int [] first, int [] second) {
        if(first.length != second.length) System.out.println("Wrong input!");
        else {
            for (int j : first) {
                if (binarySearch(second, j) != -1) System.out.println(j);
            }
        }
    }
    private static int binarySearch(int[] sortedArray, int key) {
        int index = -1;
        int low, high;
        low = 0;
        high = sortedArray.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] < key) {
                low = mid + 1;
            } else if (sortedArray[mid] > key) {
                high = mid - 1;
            } else if (sortedArray[mid] == key) {
                index = mid;
                break;
            }
        }
        return index;
    }
}
