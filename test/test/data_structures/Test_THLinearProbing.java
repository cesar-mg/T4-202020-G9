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

	@Test
	public void Vremove( )
	{
		NodoHash<String,String> verificar = new  NodoHash<String,String>("p","Revisar");
		NodoHash<String,String> act = new NodoHash<String,String>("A10","Revisar1");
		prueba.put("A10",act);
		prueba.remove("A10");
		assertNull(prueba.get("A10"));
		
	}

	@Test
	public void contains( ) 
	{
		NodoHash<String,String> verificar = new  NodoHash<String,String>("p","Revisar");
		NodoHash<String,String> act = new NodoHash<String,String>("A10","Revisar1");
		prueba.put("A10",act);
		prueba.remove("A10");
		assertFalse(prueba.contains("A10"));
	}

	@Test
	public void isEmpty() 
	{
		NodoHash<String,String> act = new NodoHash<String,String>("A10","Revisar1");
		prueba.put("A10",act);
		assertFalse(prueba.isEmpty());	
		prueba.remove("A10");
		assertTrue(prueba.isEmpty());		
	}

	@Test
	public void size() 
	{
		NodoHash<String,String> act = new NodoHash<String,String>("A10","Revisar1");
		prueba.put("A10",act);
		assertTrue(prueba.size()==1);	
		prueba.remove("A10");
		assertTrue(prueba.size() ==0);		
	}
	@Test
	public void rehash()
	{
		NodoHash<String,String> act = new NodoHash<String,String>("A10","Revisar1");
		prueba.put("A10",act);
		prueba.rehash();
		assertTrue(prueba.contains("A10"));
		assertTrue(prueba.size() == 1 );
	}
}
