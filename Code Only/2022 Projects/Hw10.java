/*
course: CSC210
project: Hw 10
date: May 5th, 2022
author: Chris Ball
purpose: Program that obtains the execution time of different sort methods.
Selection. Merge. Quick. Heap. Radix.
*/
package hw10;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class SelectionSort {
  public static long sort(int[] list) {
    long start = System.currentTimeMillis();
    sort(list, 0, list.length - 1);
    long stop = System.currentTimeMillis();
    return stop - start;
  }
  private static void sort(int[] list, int low, int high) {
    if (low < high) {
      int indexOfMin = low;
      double min = list[low];
      for (int i = low + 1; i <= high; i++) {
        if (list[i] < min) {
          min = list[i];
          indexOfMin = i;
        }
      }

      list[indexOfMin] = list[low];
      list[low] = (int) min;

      sort(list, low + 1, high);
    }
  }
}
class MergeSort {
    public static long mergeSort(int[] list) {
        long start = System.currentTimeMillis();
        if (list.length > 1) {
            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);

            int secondHalfLength = list.length - list.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list, list.length / 2,
            secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);

            merge(firstHalf, secondHalf, list);
        }
        long stop = System.currentTimeMillis();
        return stop - start;
  }
    public static void merge(int[] list1, int[] list2, int[] temp) {
    int current1 = 0; 
    int current2 = 0; 
    int current3 = 0; 

    while (current1 < list1.length && current2 < list2.length) {
      if (list1[current1] < list2[current2])
        temp[current3++] = list1[current1++];
      else
        temp[current3++] = list2[current2++];
    }

    while (current1 < list1.length)
      temp[current3++] = list1[current1++];

    while (current2 < list2.length)
      temp[current3++] = list2[current2++];
  }
}
class QuickSort {
  public static long quickSort(int[] list) {
    long start = System.currentTimeMillis();
    quickSort(list, 0, list.length - 1);
    long stop = System.currentTimeMillis();
    return stop - start;
  }
  private static void quickSort(int[] list, int first, int last) {
    if (last > first) {
      int pivotIndex = partition(list, first, last);
      quickSort(list, first, pivotIndex - 1);
      quickSort(list, pivotIndex + 1, last);
    }
  }
  private static int partition(int[] list, int first, int last) {
    int pivot = list[first];
    int low = first + 1;
    int high = last;

    while (high > low) {
      while (low <= high && list[low] <= pivot)
        low++;

      while (low <= high && list[high] > pivot)
        high--;

      if (high > low) {
        int temp = list[high];
        list[high] = list[low];
        list[low] = temp;
      }
    }

    while (high > first && list[high] >= pivot)
      high--;

    if (pivot > list[high]) {
      list[first] = list[high];
      list[high] = pivot;
      return high;
    }
    else {
      return first;
    }
  }
}
class Heap<E extends Comparable> {
  private java.util.ArrayList<E> list = new java.util.ArrayList<E>();
  public Heap() {
  }
  public long Heap(E[] objects) {
    long start = System.currentTimeMillis();
    for (int i = 0; i < objects.length; i++)
      add(objects[i]);
    long stop = System.currentTimeMillis();
    return stop - start;
  }
  public void add(E newObject) {
    list.add(newObject);
    int currentIndex = list.size() - 1;

    while (currentIndex > 0) {
      int parentIndex = (currentIndex - 1) / 2;
      if (list.get(currentIndex).compareTo(
          list.get(parentIndex)) > 0) {
        E temp = list.get(currentIndex);
        list.set(currentIndex, list.get(parentIndex));
        list.set(parentIndex, temp);
      }
      else
        break;

      currentIndex = parentIndex;
    }
  }
  public E remove() {
    if (list.size() == 0) return null;
    
    E removedObject = list.get(0);
    list.set(0, list.get(list.size() - 1));
    list.remove(list.size() - 1);

    int currentIndex = 0;
    while (currentIndex < list.size()) {
      int leftChildIndex = 2 * currentIndex + 1;
      int rightChildIndex = 2 * currentIndex + 2;
      
      if (leftChildIndex >= list.size()) break;
      int maxIndex = leftChildIndex;
      if (rightChildIndex < list.size()) {
        if (list.get(maxIndex).compareTo(
            list.get(rightChildIndex)) < 0) {
          maxIndex = rightChildIndex;
        }
      }      
      
      if (list.get(currentIndex).compareTo(
          list.get(maxIndex)) < 0) {
        E temp = list.get(maxIndex);
        list.set(maxIndex, list.get(currentIndex));
        list.set(currentIndex, temp);
        currentIndex = maxIndex;
      }   
      else 
        break;
    }

    return removedObject;
  }
  public int getSize() {
    return list.size();
  }
}
class RadixSort {  
   static int getMax(int a[], int n) {  
   int max = a[0];  
   for(int i = 1; i<n; i++) {  
      if(a[i] > max)  
         max = a[i];  
   }  
   return max; 
} 
    static void countingSort(int a[], int n, int place) {
        int[] output = new int[n+1];  
        int[] count = new int[10];  
  
        for (int i = 0; i < n; i++)  
            count[(a[i] / place) % 10]++;  
      
        for (int i = 1; i < 10; i++)  
            count[i] += count[i - 1];  
  
        for (int i = n - 1; i >= 0; i--) {  
            output[count[(a[i] / place) % 10] - 1] = a[i];  
            count[(a[i] / place) % 10]--;  
        }  
    
        System.arraycopy(output, 0, a, 0, n);  
} 
    static long radixsort(int a[], int n) {  
        long start = System.currentTimeMillis();
        int max = getMax(a, n);

        for (int place = 1; max / place > 0; place *= 10)  
            countingSort(a, n, place);
        long stop = System.currentTimeMillis();
        return stop - start;
    }  
}

public class Hw10 {
    public static int[] randomArray(int n){
        int list[] = new int[n];
        Random random = new Random();
        for(int i=0; i<n; i++)
            list[i] = random.nextInt(100000);
        return list;
    }
    
    public static void main(String[] args) {
        
        System.out.println("Array  Selection  Merge    Quick    Heap  Radix");
        System.out.println("Size   Sort       Sort     Sort     Sort  Sort");
        for(int i = 50000; i<300000; i+=50000){
            int list[] = randomArray(i);
            long sel = SelectionSort.sort(list);
            long mer = MergeSort.mergeSort(list);
            long qui = QuickSort.quickSort(list);
            //long hea = Heap(list);
            long hea = 00;
            long rad = RadixSort.radixsort(list, i);
            System.out.printf("%-7d%-11d%-9d%-9d%-6d%-7d",i,sel,mer,qui,hea,rad);
        }
    }
}
//I kept getting a stack overflow error but I don't know why.
//Also, I couldn't figure out how to properly call the Heap.