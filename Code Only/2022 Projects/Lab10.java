/*
course: CSC210
project: Lab 10
date: April 22nd, 2022
author: Chris Ball
purpose: Rewrite mergeSort to recursively sort without creating new
            temporary arrays
*/
package lab10;
public class Lab10 {
    public static void mergeSort(int[] list) {
        if(list.length > 1){
            int first = 0;
            int last = list.length;
            mergeSort(list, first, last);
        }
    }
    public static void mergeSort(int[] list, int first, int last){
        if(last <= first) return;
        int mid = (first+last) / 2;
        mergeSort(list, first, mid);
        mergeSort(list, mid+1, last);
        merge(list, first, mid, last, list);
    }
    public static void merge(int[] list, int first, int mid, int last, int[] temp) {
        if(first == last) return;
        int left = first;    // Current index of the left
        int right = mid+1;   // Current index of the right
        int current = first; // Current index of the temp
        
        while (left <= mid && right < last) {
            if (list[left] < list[right]) 
                temp[current++] = list[left++];
            else 
                temp[current++] = list[right++];
        }

        while (left <= mid) 
            temp[current++] = list[left++];
        
        while (right < last) 
            temp[current++] = list[right++];
        
        
    }
    public static void main(String[] args) {
        int n = (int)(Math.random()*100);
        int[] list = new int[n];
        for(int i=0;i<n;i++)
            list[i] = (int)(Math.random()*100);
        
        for(int i=0; i<list.length;i++)
            System.out.print(list[i]+" ");
        System.out.println();
        mergeSort(list);
        for(int i=0; i<list.length; i++)
            System.out.print(list[i]+" ");
    }
}
/*
I thought this megre would work and everytime I think about what it's doing
it looks like it should work but it doesn't and I don't know why
*/