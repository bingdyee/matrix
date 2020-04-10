package io.hikari.labs.gof23.behavioral.strategy;

/**
 * Strategy Pattern
 *
 * @author Noa Swartz
 * @date 2018-06-15
 */
public class StrategyPattern {

    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 3, 2, 10, 22, 19, 14, 12, 16, 17};
        SortContext context = new SortContext(new QuickSort());
        context.sort(arr);
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
        context.setSorter(new BubbleSort());
        context.sort(arr);
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }

}

interface Sorter {
    void sort(int[] arr);
}

class QuickSort implements Sorter {

    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] a, int left, int right) {
        if (right <= left) {
            return;
        }
        int i = part(a, left, right);
        sort(a, left, i - 1);
        sort(a, i + 1, right);
    }

    private int part(int[] a, int left, int right) {
        int i = left;
        int j = right;
        while (true) {
            while (a[i]< a[right]) {
                i++;
            }
            while (a[right] < a[--j]) {
                if (j == left) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, i, right);
        return i;
    }

    private void swap(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

}

class BubbleSort implements Sorter {

    @Override
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            for (int j = 0; j < arr.length - i; ++j) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}

class SortContext {

    private Sorter sorter;

    public SortContext(Sorter sorter) {
        this.sorter = sorter;
    }

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    public void sort(int[] arr) {
        sorter.sort(arr);
    }

}

