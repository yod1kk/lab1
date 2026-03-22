public class CountingSort {

    public static void sort(int[] theArray) {
        if (theArray == null || theArray.length <= 1) return;

        int maxValue = theArray[0];
        for (int i = 1; i < theArray.length; i++) {
            if (theArray[i] > maxValue) {
                maxValue = theArray[i];
            }
        }

        int[] numCounts = new int[maxValue + 1];

        for (int num : theArray) {
            numCounts[num]++;
        }
        int currentSortedIndex = 0;

        for (int n = 0; n < numCounts.length; n++) {
            int count = numCounts[n];
            for (int k = 0; k < count; k++) {
                theArray[currentSortedIndex] = n;
                currentSortedIndex++;
            }
        }
    }
}