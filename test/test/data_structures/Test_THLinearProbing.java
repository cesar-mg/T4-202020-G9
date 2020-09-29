package test.data_structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.Test;

import model.data_structures.ArregloDinamico;
import model.data_structures.NodoHash;


public class Test_THLinearProbing < K extends Comparable<K>, V extends Comparable<V>> 
{
	private ArregloDinamico<NodoHash<String,String>> prueba;
	private int m = 307;
	
	@Before
	public void setUp1()
	{
		prueba = new ArregloDinamico(m);
	}

	@Test
	public void put(String key, String value) 
	{
		//Revisa como hacer que key y value sean "A10" Y "Revisar1"
		
		NodoHash<String,String> act = new NodoHash<String,String>("A10","Revisar1");
		prueba.changeInfo(0, act);
		assertTrue(prueba.getElement(0).equals("A10"));	
	}

	@Test
	public void Vget(String key) 
	{
		NodoHash<String,String> verificar = prueba.getElement(0);
		if(verificar.equals("A10"));
		{
			assertTrue(verificar.getValue().equals("Revisar1"));
		}
	}

	@Test
	public void Vremove(String key)
	{
		NodoHash<String,String> verificar = new  NodoHash<String,String>("p","Revisar");
		prueba.changeInfo(1, verificar);
		if(prueba.getElement(1).getKey().equals("p"))
		{
			prueba.getElement(1).deleteLP();
		}
		assertTrue(prueba.getElement(1) == null);
		
	}

	@Test
	public void contains(String key) 
	{
		NodoHash<String,String> r = new  NodoHash<String,String>("r","Revisar3");
		prueba.changeInfo(24 , r);
		boolean encontrado = false;
		for(int i=0; i<prueba.size() || !encontrado; i++)
		{
			if(prueba.getElement(i).equals(r))
			{
				encontrado = true; 
			}
		}
		assertTrue(encontrado == true);
	}

	@Test
	public void isEmpty() 
	{
		assertTrue(prueba.size() == 0);		
	}

	@Test
	public void size() 
	{
		//TODO
	}


	

}
