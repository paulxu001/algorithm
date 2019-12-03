package com.pingwolf.algorithm.geekbang.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        int[] a = {6, 3, 7, 9, 22, 34, 14};
        bubbleSort(Arrays.copyOf(a, a.length));
        int[] aC = Arrays.copyOf(a, a.length);
        bubbleSort1(aC);
        System.out.println(Arrays.toString(aC));

        int[] b = {9,3, 4,1,6,2, 7,8};
        insertionSort(Arrays.copyOf(b, b.length));

        int[] c = {8,4, 22, 12, 21, 33, 9};
        selectionSort(Arrays.copyOf(c, c.length));

        int[] d = {2, 4, 1, 21, 6, 12, 11};
        selectionSort1(Arrays.copyOf(d, d.length));


    }

    public static void insertionSort(int[] a) {
        for(int i = 1; i < a.length; i++) {
            int value = a[i];
            int j = i - 1;
            for(; j >= 0; j--) {
                if(a[j] > value){
                    a[j+1] = a[j];
                } else{
                    break;
                }
            }
            a[j+1] = value;
        }

        print(a);
    }

    // 实现有问题,每次循环中去交换数据，而应该只是保持下标，最后再进行数据交换，请参考下面的方法。
    public static void selectionSort(int[] a) {
        for(int i=0; i < a.length; i++){
            for(int j = i+1; j < a.length; j++) {
                if(a[j] < a[i]){
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }

        print(a);
    }

    public static void selectionSort1(int[] a) {
        for(int i=0; i < a.length-1; i++){
            int minIndex = i;
            for(int j = i+1; j < a.length; j++) {
                if(a[j] < a[minIndex]){
                    minIndex = j;
                }
            }
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }

        print(a);
    }

    public static void bubbleSort(int[] a){
        for(int i = 0; i < a.length; i++) {
            boolean flag = false;
            for(int j = 0; j < a.length - i - 1; j++){
                if(a[j] > a[j+1]) {
                    int tmp = a[j] ;
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;
                }
            }

            if(!flag){
                break;
            }
        }

        print(a);
    }

    public static void bubbleSort1(int[] a){
        for(int i = 0; i < a.length; i++) {
            boolean isExchanged = false;
            int lastExchangedIndex = a.length -1;
            for(int j = i; j < lastExchangedIndex; j++) {
                if(a[j] > a[j+1]) {
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    isExchanged = true;
                    lastExchangedIndex = j;
                }
            }
        }
    }

    public static void print(int[] a){
        for(int v : a){
            System.out.print(v + " ");
        }
        System.out.println("");
    }
}
