package model.data_structures;

public class ListaEncadenada <T extends Comparable<T>> implements Lista<T> {

	
	public ListaEncadenada( )
	{
		
	}
	/**
	 * Retornar el numero de elementos presentes en el arreglo
	 * @return el tamanio 
	 */
	public int size( )
	{
		
		return 0;
	}
	
	/**
	 * Agrega el elemento en la primera posicion.
	 * @param T element, element a agregar.
	 */
	public void addFirst(T element)
	{
		
	}
	
	/**
	 * Agrega el elemento en la ultima posicion.
	 * @param T element, element a agregar.
	 */
	public void addLast(T element)
	{
		
	}
	
	/**
	 * Inserta el elemento por parametro en la posicion indicada.
	 * @param element, elemento a insertar.
	 * @param pos, posicion en la que insertar.
	 */
	public void insertElement(T element, int pos)
	{
		
	}
	
	/**
	 * Elimina el primer elemento.
	 * @return elemento eliminado.
	 */
	public T removeFirst( )
	{
		return null;	
	}
	
	/** 
	 * Elminina el ultimo elemento.
	 * @return elemento eliminado.
	 */
	public T removeLast( )
	{
		return null;
	}
	
	/**
	 * Elimina el elemento en la posicion dada por parametro.
	 * @param pos, posicion del elemento a eliminar.
	 * @return elemento eliminado.
	 */
	public T deleteElement( int pos )
	{
		return null;
	}
	
	/**
	 * Retorna el primer elemento de la lista.
	 * @return Primer elemento de la lista.
	 */
	public T firstElement( )
	{
		return null;
	}
	
	/**
	 * Retorna el ultimo elemento de la lista.
	 * @return Ultimo elemento de la lista. 
	 */
	public T lastElement( )
	{
		return null;
	}
	
	
	/**
	 * Retorna la posicion del elemento dado por parametro, si este se encuentra en la lista.
	 * @param element, elemento a ubicar.
	 * @return Posicion del elemento buscado.
	 */
	public int isPresent(T element )
	{
		return 0;
	}
	
	
	/**
	 * Intercambia los elementos en las posiciones dadas por parametro.
	 * @param pos1, posicion del primer elemento.
	 * @param pos2, posicion del segundo elemento.
	 */
	public void exchange(int pos1, int pos2)
	{
			
	}
	
	/**
	 * Cambia la informacion del elemento en la posicion dada.
	 * @param pos, posicion del elemento a actualizar.
	 * @param element, nueva informacion.
	 */
	public void changeInfo(int pos, T element )
	{
		
	}
	
	/**
	 * Revisa si la estructura se encuentra vacia.
	 * @return True si esta vacia, false de lo contrario.
	 */
	public boolean isEmpty( )
	{
		return false;
		
	}
	
	/**
	 * Retornar el elemento en la posicion i
	 * @param i posicion de consulta
	 * @return elemento de consulta. null si no hay elemento en posicion.
	 */
	public T getElement( int i )
	{
		return null;
	}


}
