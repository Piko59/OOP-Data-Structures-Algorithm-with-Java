public class Algorithms{
    public static void main(String args[]) {
        // create a comparable array to hold data
        Comparable[] data = new Comparable[]{123, 12312, 31, 141, 5151, 68567, 652, 141, -123, -1231, 14, -21};
        // apply a 3 way merge sort
        mergeSort(data);

        // print the array after the sort.
        System.out.println("After the sort: ");
        for (int i = 0; i < data.length; i++)
            System.out.print(data[i] + " ");
    }

    // sort a given comparable array using a 3 way merge sort algorithm
    public static void mergeSort(Comparable[] arr) {
        if (arr == null)
            return;

        final int length = arr.length;
        Comparable[] tempList = new Comparable[length];
        // copy the data to  temporary array
        copy(arr, tempList, 0, length - 1);
        // perform the sorting process
        mergeSort(tempList, arr, 0, arr.length);
        // copy the final sorted data back to the original array
        copy(tempList, arr, 0, length - 1);
    }

    // helper method to perform the merging during merge sort
    public static <T extends Comparable<? super T>> void mergeSort(T[] arr, T[] anotArr, int low, int high) {
        if (high - low < 2)
            return;

        // calculate indexes to divide the sub array into 3 parts
        int mid1 = low + ((high - low) / 3);
        int mid2 = low + 2 * ((high - low) / 3) + 1;

        // recursively sort each sub array
        mergeSort(anotArr, arr, low, mid1);
        mergeSort(anotArr, arr, mid1, mid2);
        mergeSort(anotArr, arr, mid2, high);

        // merge the sorted sub arrays
        merge(anotArr, arr, low, mid1, mid2, high);
    }

    // merge two sub arrays
    public static <T extends Comparable<? super T>> void merge(T[] arr, T[] anotArr, int low, int mid1, int mid2, int high) {
        int i = low;
        int j = mid1;
        int k = mid2;
        int l = low;

        // compare and merge the two sub arrays
        while ((i < mid1) && (j < mid2) && (k < high)) {
            if (isLess(arr[i], arr[j])) {
                if (isLess(arr[i], arr[k]))
                    anotArr[l++] = arr[i++];
                else
                    anotArr[l++] = arr[k++];
            } else {
                if (isLess(arr[j], arr[k]))
                    anotArr[l++] = arr[j++];
                else
                    anotArr[l++] = arr[k++];
            }
        }

        // continue the merging process until the second sub array is exhausted
        while ((i < mid1) && (j < mid2)) {
            if (isLess(arr[i], arr[j]))
                anotArr[l++] = arr[i++];
            else
                anotArr[l++] = arr[j++];
        }

        while ((j < mid2) && (k < high)) {
            if (isLess(arr[j], arr[k]))
                anotArr[l++] = arr[j++];
            else
                anotArr[l++] = arr[k++];
        }

        while ((i < mid1) && (k < high)) {
            if (isLess(arr[i], arr[k]))
                anotArr[l++] = arr[i++];
            else
                anotArr[l++] = arr[k++];
        }

        // merge any remaining elements
        while (i < mid1)
            anotArr[l++] = arr[i++];
        while (j < mid2)
            anotArr[l++] = arr[j++];
        while (k < high)
            anotArr[l++] = arr[k++];
    }

    // perform comparison of two comparable objects
    private static <T extends Comparable<? super T>> boolean isLess(T c1, T c2) {
        return c1.compareTo(c2) < 0;
    }

    // copy a range of data from one array to another
    private static <T extends Comparable<? super T>> void copy(T[] arr, T[] anotArr, int low, int high) {
        for (int i = low; i <= high; i++)
            anotArr[i] = arr[i];
    }
}
