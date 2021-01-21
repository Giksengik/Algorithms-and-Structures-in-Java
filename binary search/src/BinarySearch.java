public class BinarySearch {
    public static int search (int [] array, int key) {
        int lo=0;
        int hi= array.length-1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (key < array[mid]) hi = mid - 1;
            else if (key > array[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
