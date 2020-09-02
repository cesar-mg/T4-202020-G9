package model.logic;

public class ShellSort {
	
	

	
	
	
	public static void sort(Comparable[] array) {
		 
		  
		  int N = array.length;
		  int h = 1;
		  while (h < N / 3)
		   h = 3 * h + 1;
		   
		
		  while (h >= 1) { 
		   for (int i = h; i < N; i++) { 
		    for (int j = i; j >= h && (array[j].compareTo(array[j - h]) < 0); j -= h) {
		     Comparable temp = array[j];
		     array[j] = array[j - h];
		     array[j - h] = temp;
		    }
		   }
		   h = h / 3;
		  }
		 
		 }
		 

}
