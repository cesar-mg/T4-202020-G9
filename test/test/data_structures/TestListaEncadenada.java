package test.data_structures;


import model.data_structures.ListaEncadenada;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestListaEncadenada {

	private ListaEncadenada lista;
	
	@Before
	public void setUp1()
	{
		lista= new ListaEncadenada( );
	}

	public void setUp2() 
	{
		for(int i =0; i< 200; i++){
			lista.addLast(""+i);
		}
	}
	
	@Test
	public void testAgregar( )
	{
		lista.addLast("a");
		assertTrue(lista.getElement(lista.isPresent("a")).equals("a"));
		lista.removeFirst();
		setUp2( );
		assertEquals(lista.getElement(119),(""+119));
		
	}
	
	@Test
	public void testGetElement( ) 
	{
		setUp2();
		assertEquals(""+20, lista.getElement(20));
		assertNull(lista.getElement(300));
	}
	
	@Test
	public void testSize( ) 
	{
		lista.addLast(""+0);
		assertTrue(lista.size()==1);
		setUp2();
		assertEquals(201, lista.size());
		lista.removeFirst( );
		assertEquals(200,lista.size());
	}

	@Test
	public void testAddFirst( )
	{
		setUp2();
		lista.addFirst("-1");
		assertEquals("-1",lista.getElement(0));
		for(int i = 1; i < 15; i++)
			assertTrue(Integer.parseInt((String) lista.getElement(i)) > Integer.parseInt((String) lista.getElement(i-1)));
		lista.addFirst("a");
		assertEquals("a",lista.getElement(0));
		
		
	}

	@Test
	public void testAddLast( )
	{
		
		lista.addLast("-1");
		assertEquals("-1",lista.getElement(0));
		setUp2();
		lista.addLast("a");
		assertEquals("a",lista.getElement(lista.size()-1));
	}

	@Test
	public void testInsertElement( )
	{
		lista.insertElement("0", 0);
		assertEquals("0",lista.getElement(0));
		lista.removeFirst();
		setUp2();
		lista.insertElement("a", 50);
		assertEquals("a",lista.getElement(50));
		assertEquals("50",lista.getElement(51));
	}

	@Test
	public void testRemoveFirst( )
	{
		setUp2();
		lista.addFirst("-1");
		assertEquals("-1",lista.getElement(0));
		lista.removeFirst();
		assertEquals("0",lista.getElement(0));
		for(int i = 1; i < 15; i++)
			assertTrue(Integer.parseInt((String) lista.getElement(i)) > Integer.parseInt((String) lista.getElement(i-1)));
		lista.removeFirst();
		assertEquals("1",lista.getElement(0));
	}

	@Test
	public void testRemoveLast( )
	{
		setUp2();
		lista.addLast("-1");
		lista.removeLast();
		assertEquals("185",lista.getElement(185));
		

	}

	@Test
	public void testDeleteElement( )
	{
	setUp2();
	assertEquals("55",lista.deleteElement(55));
	for(int i = 50; i < 60; i++)
		assertTrue(Integer.parseInt((String) lista.getElement(i)) > Integer.parseInt((String) lista.getElement(i-1)));
	}

	@Test
	public void testFirstElement( ) 
	{
		assertNull(lista.firstElement());
		setUp2( );
		assertEquals("0",lista.firstElement());
	}

	@Test
	public void testLastElement( )
	{
		assertNull(lista.lastElement());
		setUp2( );
		assertEquals("199",lista.lastElement());
	}

	@Test
	public void testIsEmpty()
	{
		assertTrue(lista.isEmpty());
		lista.addFirst("0");
		assertFalse(lista.isEmpty());
	
	}
	@Test
	public void testIsPresentBinary ( ) 
	{
		
	}

	@Test
	public void testIsPresent ( ) 
	{
		assertEquals(-1,lista.isPresent("No existe"));
		setUp2();
		assertEquals(195, lista.isPresent("195"));
		assertEquals(123, lista.isPresent("123"));

	}
	@Test
	public void testExchange ( )
	{
		setUp2();
		lista.exchange(0, 199);
		assertEquals("0", lista.getElement(199));
		assertEquals("199", lista.getElement(0));
		
	}

	@Test
	public void testChangeInfo ( )
	{
		setUp2();
		lista.changeInfo(0,"a");
		assertEquals("a", lista.getElement(0));
		lista.changeInfo(16,"r");
		assertEquals("r", lista.getElement(16));
	
	}

}
