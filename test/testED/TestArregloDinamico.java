package testED;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import estructuras_de_datos.ArregloDinamico;
public class TestArregloDinamico {

	private ArregloDinamico<String> arreglo;
	private static int TAMANO=100;
	
	@Before
	public void setUp1()
	{
		arreglo= new ArregloDinamico<String>(TAMANO);
	}

	public void setUp2() 
	{
		for(int i =1; i< TAMANO*2; i++){
			arreglo.addLast(""+i);
		}
	}
	
	@Test
	public void testGetElement( ) 
	{
		setUp2();
		assertEquals(arreglo.getElement(20),""+20);
		assertNull(arreglo.getElement(300));
	}
	
	@Test
	public void testSize( ) 
	{
		arreglo.addLast(""+0);
		assertTrue(arreglo.size()==1);
		setUp2();
		assertEquals(arreglo.size(),200);
		arreglo.deleteElement(1);
		assertEquals(arreglo.size(),199);
	}

	@Test
	public void testAddFirst( )
	{
		setUp2();
		arreglo.addFirst("-1");
		assertEquals("-1",arreglo.getElement(1));
		for(int i = 1; i < 15; i++)
			assertTrue(Integer.parseInt((String) arreglo.getElement(i+1)) > Integer.parseInt((String) arreglo.getElement(i)));
		arreglo.addFirst("a");
		assertEquals("a",arreglo.getElement(1));	
	}

	@Test
	public void testAddLast( )
	{
		
		arreglo.addLast("-1");
		assertEquals("-1",arreglo.getElement(1));
		setUp2();
		arreglo.addLast("a");
		assertEquals("a",arreglo.getElement(arreglo.size()));
	}

	@Test
	public void testInsertElement( )
	{
		arreglo.insertElement("0", 1);
		assertEquals("0",arreglo.getElement(1));
		arreglo.removeFirst();
		setUp2();
		arreglo.insertElement("a", 50);
		assertEquals("a",arreglo.getElement(50));
		assertEquals("50",arreglo.getElement(51));
	}

	@Test
	public void testRemoveFirst( )
	{
		setUp2();
		arreglo.addFirst("-1");
		assertEquals("-1",arreglo.getElement(1));
		arreglo.removeFirst();
		assertEquals("1",arreglo.getElement(1));
		for(int i = 1; i < 15; i++)
			assertTrue(Integer.parseInt((String) arreglo.getElement(i+1)) > Integer.parseInt((String) arreglo.getElement(i)));
		arreglo.removeFirst();
		assertEquals("2",arreglo.getElement(1));
	}

	@Test
	public void testRemoveLast( )
	{
		setUp2();
		arreglo.addLast("-1");
		arreglo.removeLast();
		assertEquals("185",arreglo.getElement(185));
		

	}

	@Test
	public void testDeleteElement( )
	{
	setUp2();
	assertEquals("55",arreglo.deleteElement(55));
	for(int i = 50; i < 60; i++)
		assertTrue(Integer.parseInt((String) arreglo.getElement(i)) > Integer.parseInt((String) arreglo.getElement(i-1)));
	}

	@Test
	public void testFirstElement( ) 
	{
		assertNull(arreglo.firstElement());
		setUp2( );
		assertEquals("1",arreglo.firstElement());
	}

	@Test
	public void testLastElement( )
	{
		assertNull(arreglo.lastElement());
		setUp2( );
		assertEquals("199",arreglo.lastElement());
	}

	@Test
	public void testIsEmpty()
	{
		assertTrue(arreglo.isEmpty());
		arreglo.addFirst("0");
		assertFalse(arreglo.isEmpty());
	}

	@Test
	public void testIsPresent ( ) 
	{
		assertEquals(-1,arreglo.isPresent("No existe"));
		setUp2();
		assertEquals(194, arreglo.isPresent("195"));
		assertEquals(122, arreglo.isPresent("123"));
	}
	@Test
	public void testExchange ( )
	{
		setUp2();
		arreglo.exchange(1, 199);
		assertEquals("1", arreglo.getElement(199));
		assertEquals("199", arreglo.getElement(1));
	}

	@Test
	public void testChangeInfo ( )
	{
		setUp2();
		arreglo.changeInfo(1,"a");
		assertEquals("a", arreglo.getElement(1));
		arreglo.changeInfo(17,"r");
		assertEquals("r", arreglo.getElement(17));
	}

}
