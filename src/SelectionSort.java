public class SelectionSort {
    public static void sort(int[] arr) {
        for (int left = 0; left < arr.length; left++) {
            int minIndex = left;
            for (int i = left +1; i < arr.length; i++) {
                if (arr[i] < arr[minIndex]) {
                    minIndex = i;
                }
            }
            int temp = arr[left];
            arr[left] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
