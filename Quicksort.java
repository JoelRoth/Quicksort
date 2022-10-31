package Quicksort;

import java.util.Arrays;
import java.util.Random;

public class Quicksort {

	public static void main(String[] args) {
		//System.out.println(powerOfTwo(5));
		
		//int[] nums = {-1,5,1,3,2,4,7,1,9};
		
		int[] numsBig = new int[10000];
		
		Random randI = new Random();
		for (int i = 0; i < 10000; i++) {
			numsBig[i] = randI.nextInt(10000);
		}
		
		System.out.println(Arrays.toString(numsBig));
		
		
		int[] numOfSwaps = {0};
		QuickSort(numsBig, numOfSwaps);
		
		System.out.println(Arrays.toString(numsBig));
		System.out.println(numOfSwaps[0]);
		
	}
	
	public static int powerOfTwo(int n) {
		//2^n = 2 * 2^(n-1)
		
		if (n == 0) {
			return 1;
		}
		
		return 2 * powerOfTwo(n-1);
	}
	
	public static void QuickSort(int[] numbers, int[] numOfSwaps) {
		int low = 0;
		int high = numbers.length - 1;
		
		RecursivePartition(numbers,low,high,numOfSwaps);
		
	}
	
	public static void RecursivePartition(int[] numbers, int low, int high, int[] numOfSwaps) {
		if (low >= high) {
			return;
		} else {
			int mid = Partition(numbers,low,high,numOfSwaps);
			RecursivePartition(numbers,low,mid,numOfSwaps);
			RecursivePartition(numbers,mid+1,high,numOfSwaps);
		}
	}
		
	public static int Partition(int [] numbers, int lowIndex, int highIndex, int[] numOfSwaps) {
	  int midpoint = lowIndex + (highIndex - lowIndex) / 2;
	  int pivot = numbers[midpoint];

	  boolean done = false;
	  while (!done) {
	     while (numbers[lowIndex] < pivot) {
	        lowIndex += 1;
	     }
	     while (pivot < numbers[highIndex]) {
	        highIndex -= 1;
	     }
 
	     if (lowIndex >= highIndex) {
	        done = true;
	     }
	     else {
	        int temp = numbers[lowIndex];
	        numbers[lowIndex] = numbers[highIndex];
	        numbers[highIndex] = temp;
	        
	        numOfSwaps[0]++;

	        lowIndex += 1;
	        highIndex -= 1;
	     }
	  }
	  return highIndex;
	}

}