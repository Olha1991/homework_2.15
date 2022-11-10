package com.example.demo;

import java.util.Random;
import java.util.function.Consumer;


public class Sort {
    private static final Random RANDOM = new Random();
    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }
    public static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    public static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static int [] generateArray(int size){
        int[] array = new int[size];
        for(int i = 0; i < size; i ++){
            array[i] = RANDOM.nextInt(-100, 100);
        }
        return array;
    }

    private static double timeToSort (int iteration, Consumer< int[] > sort){
        double sum = 0;
        for(int i = 0; i < iteration; i++){
            int[] array = generateArray(100000);
            long start = System.currentTimeMillis();
            sort.accept(array);
            long end = System.currentTimeMillis() - start;
            sum +=end;
        }
        return sum / iteration;
    }


    public static void  main(String[] args){
        double timeToBubbleSort = timeToSort(5, Sort :: sortBubble);
        System.out.println("Average time for bubble sort - " + timeToBubbleSort + " milliseconds.");
        double timeToSelectionSort = timeToSort(5, Sort :: sortSelection);
        System.out.println("Average time for selection sort - " + timeToSelectionSort + " milliseconds.");
        double timeToInsertionSort = timeToSort(5, Sort :: sortInsertion);
        System.out.println("Average time for insertion sort - " + timeToInsertionSort + " milliseconds.");
    }



}
