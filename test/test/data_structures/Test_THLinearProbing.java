package test.data_structures;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.NodoHash;
import model.data_structures.TablaHashLinearProbing;


public class Test_THLinearProbing 
{
	private TablaHashLinearProbing<String, NodoHash<String,String>> prueba;
	private int m = 10;
	
	@Before
	public void setUp1()
	{
		prueba = new TablaHashLinearProbing<String, NodoHash<String,String>>(m);
	}

	@Test
	public void put( ) 
	{
		//Revisa como hacer que key y value sean "A10" Y "Revisar1"
		
		NodoHash<String,String> act = new NodoHash<String,String>("A10","Revisar1");
		prueba.put("A10",act);
		NodoHash<String,String> buscado = prueba.get("A10");
		assertTrue(buscado.equals(act));	
	}

	@Test
	public void Vget( ) 
	{
		NodoHash<String,String> act = new NodoHash<String,String>("A10","Revisar1");
		prueba.put("A10",act);
		NodoHash<String,String> verificar = prueba.get("A10");
		if(verificar.getKey().equals("A10"));
		{
			assertTrue(verificar.getValue().equals("Revisar1"));
		}
	}

//	@Test
//	public void Vremove( )
//	{
//		NodoHash<String,String> verificar = new  NodoHash<String,String>("p","Revisar");
//		prueba.changeInfo(1, verificar);
//		if(prueba.getElement(1).getKey().equals("p"))
//		{
//			prueba.getElement(1).deleteLP();
//		}
//		assertTrue(prueba.getElement(1) == null);
//		
//	}
//
//	@Test
//	public void contains( ) 
//	{
//		NodoHash<String,String> r = new  NodoHash<String,String>("r","Revisar3");
//		prueba.changeInfo(24 , r);
//		boolean encontrado = false;
//		for(int i=1; i<=prueba.size() || !encontrado; i++)
//		{
//			if(prueba.getElement(i).equals(r))
//			{
//				encontrado = true; 
//			}
//		}
//		assertTrue(encontrado == true);
//	}

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
