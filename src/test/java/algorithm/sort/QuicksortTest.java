package algorithm.sort;

import algorithm.sort.Quicksort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuicksortTest {

    @Test
    @DisplayName("퀵소트후 제대로 정렬되었는지 확인")
    void sort() {
        int[] arr = {3,9,4,7,0,5,1,6,8,2};

        Quicksort sort = new Quicksort();
        sort.printArray(arr);
        sort.quickSort(arr);
        sort.printArray(arr);
        for (int i=0; i < arr.length; i++) {
            assertEquals(i, arr[i]);
        }
    }

}