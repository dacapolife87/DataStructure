package algorithm.sort;

public class MergeSort {
    public void sort(int[] arr) {
        int[] temp = new int[arr.length];
        sort(arr, temp, 0, arr.length-1);
    }

    private void sort(int[] arr, int[] temp, int start, int end) {
        if(start < end) {
            int mid = (start + end) / 2;
            sort(arr, temp, start, mid);
            sort(arr, temp, mid+1, end);
            merge(arr, temp, start, mid, end);
        }
    }

    private void merge(int[] arr, int[] temp, int start, int mid, int end) {
        for(int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }

        int part1 = start;
        int part2 = mid + 1;
        int index = start;

        while(part1 <= mid && part2 <= end) {
            if(temp[part1] <= temp[part2]) {
                arr[index] = temp[part1];
                part1++;
            }else{
                arr[index] = temp[part2];
                part2++;
            }
            index++;
        }

        for(int i = 0; i <=mid -part1; i++) {
            arr[index + i] = temp[part1 + i];
        }
    }

    private void printArray(int[] arr) {
        for (int data : arr) {
            System.out.print(data+ ", ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] arr = {3,9,4,7,5,0,1,6,8,2};

        MergeSort mergeSort = new MergeSort();
        mergeSort.printArray(arr);
        mergeSort.sort(arr);
        mergeSort.printArray(arr);
    }
}

