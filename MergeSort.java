public class MergeSort {
    public static void sort(int[] source) {
        if (source == null || source.length <= 1) return;
        mergeSort(source, 0, source.length - 1);
    }

    public static void mergeSort(int[] source, int left, int right) {
        int delimiter = left + ((right - left) / 2) + 1;

        if (delimiter > 0 && right > (left + 1)) {
            mergeSort(source, left, delimiter - 1);
            mergeSort(source, delimiter, right);
        }
        int[] buffer = new int[right - left + 1];
        int cursor = left;
        int rightCursor = delimiter;
        for (int i = 0; i < buffer.length; i++) {
            if (rightCursor > right || (cursor < delimiter && source[cursor] <= source[rightCursor])) {
                buffer[i] = source[cursor];
                cursor++;
            } else {
                buffer[i] = source[rightCursor];
                rightCursor++;
            }
        }
        System.arraycopy(buffer, 0, source, left, buffer.length);
    }
}

