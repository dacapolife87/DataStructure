package algorithm.sort;

public class Quicksort {

    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int start, int end) {
        int part2 = partition(arr, start, end);
        if(start < part2 - 1) {
            quickSort(arr, start, part2 - 1);
        }
        if(part2 < end) {
            quickSort(arr, part2, end);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[(start+end) / 2];
        while (start <= end) {
            while (arr[start] < pivot ) start++;
            while (arr[end] > pivot ) end--;

            if(start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    private void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public void printArray(int[] arr) {
        for (int data : arr) {
            System.out.print(data + ", ");
        }
        System.out.println("");
    }

}
