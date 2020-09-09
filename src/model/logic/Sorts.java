package model.logic;
import model.data_structures.Lista;

public class Sorts  <T extends Comparable<T>> {


	public Sorts()
	{
		
	}

	public static void Shellsort(Comparable[] array) 
	{

		int N = array.length;
		int h = 1;
		while (h < N / 3)
			h = 3 * h + 1;


		while (h >= 1) { 
			for (int i = h; i < N; i++)
			{ 
				for (int j = i; j >= h && (array[j].compareTo(array[j - h]) < 0); j -= h) 
				{
					Comparable temp = array[j];
					array[j] = array[j - h];
					array[j - h] = temp;
				}
			}
			h = h / 3;
		}

	}
	
	public static void quicksort(Comparable[] arreglo, int izq, int der) 
	{

		Comparable pivote= arreglo[izq]; 
		int i=izq;        
		int j=der;        
		Comparable otro;

		while(i < j)
		{                                                         
			while(arreglo[i].compareTo(pivote) <= 0 && i < j)
				i++; 
			while(arreglo[j].compareTo(pivote) > 0)
				j--;           
			if (i < j) 
			{                        
				otro= arreglo[i];                      
				arreglo[i]=arreglo[j];
				arreglo[j]=otro;
			}
		}

		arreglo[izq]=arreglo[j];                                    
		arreglo[j]=pivote;     

		if(izq < j-1)
			quicksort(arreglo,izq,j-1);  
		if(j+1 < der)
			quicksort(arreglo,j+1,der);     

	}
	
	public static Comparable[] miniSort(Comparable[] arreglo, int tam)
	{
		Comparable[] resp = new Comparable[tam];
		for(int i = 0; i < tam; i++)
			resp[i] = arreglo[i];
		quicksort(resp, 0, tam-1);
		return resp;
	}
	
}
