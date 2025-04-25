package slidingwindow;

public class SlidingWindowPrint {
    public static int slidingWindow(int arr[], int w) {
        int i=0, j=w;
        int sum =0;
        for (int k=0 ;k<w;k++) {
            sum += arr[k];
        }
        int max = sum;
        while (j<=arr.length-1) {
            sum = sum -arr[i++] + arr[j++];
            if(sum > max) {
                max = sum;
            }
        }
        return max;
    }
    public static void main(String[] args) {

        int arr[] = {400, 400, 300, 200};
        System.out.println(slidingWindow(arr, 4));
    }
}
