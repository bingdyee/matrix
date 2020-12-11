package io.github.matrix.codewars.others;

import java.util.Arrays;

/**
 *
 *  Sorting algorithm
 *
 * @author Noa Swartz
 * @date 2020/12/11
 */
public class Sorts {

    private static final int MIN_SIZE = 2;

    /**
     * bubble sort
     *  timeComplexity = O(n^2)
     *  spaceComplexity = O(1)
     *  is stable
     * @param data target array
     */
    public static void bubbleSort(int[] data) {
        if (data == null || data.length < MIN_SIZE) {
            return;
        }
        for (int i = 0; i < data.length - 1; ++i) {
            for (int j = 0; j < data.length - 1; ++j) {
                if (data[j] > data[j + 1]) {
                    swap(data, j, j + 1);
                }
            }
        }
    }

    /**
     * quick sort
     *  timeComplexity = O(nlogn)
     *  spaceComplexity = O(logn)
     *  is not stable
     *
     * @param data target array
     */
    public static void quickSort(int[] data) {
        if (data == null || data.length < MIN_SIZE) {
            return;
        }
        quickSort(data, 0, data.length - 1);
    }

    /**
     * insert sort
     *  timeComplexity = O(n^2)
     *  spaceComplexity = O(1)
     *  is stable
     *
     * @param data target array
     */
    public static void insertionSort(int[] data) {
        if (data == null || data.length < MIN_SIZE) {
            return;
        }
        int j;
        for(int i = 1; i < data.length; ++i) {
            j = i;
            int target = data[i];
            while(j > 0 && target < data[j - 1]) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = target;
        }
    }

    /**
     * shell sort (Gap sequences: N/2^k)
     *  timeComplexity = O(nlogn)
     *  spaceComplexity = O(1)
     *  is not stable
     *
     * @param data target array
     */
    public static void shellSort(int[] data) {
        int j;
        for (int gap = data.length >> 1; gap > 0; gap >>= 1) {
            for (int i = gap; i < data.length; ++i) {
                int target = data[i];
                for (j = i; j >= gap && target< data[j - gap]; j -= gap) {
                    data[j] = data[j - gap];
                }
                data[j] = target;
            }
        }
    }

    /**
     * selection sort
     * timeComplexity = O(n^2)
     *  spaceComplexity = O(1)
     *  is not stable
     *
     * @param data target array
     */
    public static void selectionSort(int[] data) {
        if (data == null || data.length < MIN_SIZE) {
            return;
        }
        int minIndex = 0;
        for (int i = 0; i< data.length; ++i) {
            minIndex = i;
            for(int j = i+1;j < data.length; ++j) {
                if(data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            swap(data, i, minIndex);
        }
    }

    /**
     * heap sort
     *  timeComplexity = O(nlogn)
     *  spaceComplexity = O(1)
     *  is not stable
     *
     * @param data target array
     */
    public static void heapSort(int[] data) {
        int i;
        for (i = data.length / 2 - 1; i >= 0; --i) {
            maxHeapify(data, i, data.length - 1);
        }
        for (i = data.length - 1; i > 0; --i) {
            swap(data, 0, i);
            maxHeapify(data, 0, i - 1);
        }
    }

    /**
     * merge sort
     *  timeComplexity = O(nlogn)
     *  spaceComplexity = O(n)
     *  is stable
     *
     * @param data target array
     */
    public static void mergeSort(int[] data, int left, int right) {
        if (data == null || data.length < MIN_SIZE || left == right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(data, left, mid);
        mergeSort(data, mid + 1, right);
        merge(data, left, mid + 1, right);
    }

    private static void quickSort(int[] data, int left, int right) {
        if(left >= right) {
            return;
        }
        int first = left;
        int last = right;
        int key = data[first];
        while(first < last) {
            while(first < last && data[last] >= key) {
                --last;
            }
            data[first] = data[last];
            while(first < last && data[first] <= key) {
                ++first;
            }
            data[last] = data[first];
        }
        data[first] = key;
        quickSort(data, left, first - 1);
        quickSort(data, first + 1, right);
    }

    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private static void merge(int[] data, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(data, left, mid);
        int[] rightArr = Arrays.copyOfRange(data, mid, right + 1);
        int i = 0, j = 0, k = left;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] < rightArr[j]) {
                data[k] = leftArr[i++];
            } else {
                data[k] = rightArr[j++];
            }
            ++k;
        }
        while (i < leftArr.length) {
            data[k++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            data[k++] = rightArr[j++];
        }
    }

    private static void maxHeapify(int[] data, int start, int end) {
        int dad = start;
        int son = dad * 2 + 1;
        while (son <= end) {
            if (son + 1 <= end && data[son] < data[son + 1]) {
                ++son;
            }
            if (data[dad] > data[son]) {
                return;
            } else {
                swap(data, dad, son);
                dad = son;
                son = dad * 2 + 1;
            }
        }
    }

}
