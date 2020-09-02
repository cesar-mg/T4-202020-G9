package model.data_structures;

public class NodoEncadenado <T extends Comparable<T>> 
{
	/**
	 * Siguiente nodo.
	 */
	private NodoEncadenado nodoSiguiente;
	
	/**
	 * Informacion almacenada en el nodo.
	 */
	private T informacion;
	
	/**
	 * Constructor del nodo, con la informacion dada por parametro.
	 */
	public NodoEncadenado(T pInformacion)
	{
		nodoSiguiente = null;
		informacion = pInformacion;
	}
	
	/**
	 * Cambia el siguiente nodo con el dado por parametro.
	 */
	public void cambiarSiguiente(NodoEncadenado sig)
	{
		nodoSiguiente = sig;
	}
	
	/**
	 * Cambia el siguiente nodo con el dado por parametro.
	 */
	public NodoEncadenado darSiguiente( )
	{
		return nodoSiguiente;
	}
	
	/**
	 * Retorna la informacion almacenada.
	 */
	public T darInformacion( )
	{
		return informacion;
	}
	
	/**
	 * Cambia la informacion almacenada.
	 */
	public void cambiarInformacion(T info )
	{
		informacion = info;
	}

	/**
	 * Hace la busqueda recursiva de la informacion dada por parametro.
	 */
	public int existe(T info, int act)
	{
		return informacion.equals(info) ? act : nodoSiguiente == null? -1: nodoSiguiente.existe(info, (act+1));
	}

	/**
	 * Hace el proceso recursivo para cambiar la informacion dada por parametro, por el elemento en la posicion dada.
	 */
	public void changeInfo(T element, int i) 
	{
		if(i == 0)
			informacion = element;
		else if(nodoSiguiente != null)
			nodoSiguiente.changeInfo(element, (i-1));
	}
	
	/**
	 * Retornar el elemento en la posicion i
	 * @param i posicion de consulta
	 * @return elemento de consulta. null si no hay elemento en esa posicion.
	 */
	public T getElement( int i )
	{
		return i == 0? informacion: (nodoSiguiente == null? null : (T) nodoSiguiente.getElement(i-1));
	}
	
	/**
	 * Retornar el nodo en la posicion i
	 * @param i posicion de consulta
	 * @return nodo de consulta. null si no hay elemento en esa posicion.
	 */
	public NodoEncadenado<T> getNodo( int i )
	{
		return i == 0? this: (nodoSiguiente == null? null :(NodoEncadenado<T>) nodoSiguiente.getNodo(i-1));
	}

	/**
	 * Utiliza recursion para eliminar un elemento en pos.
	 * @param pos posicion del elemento a eliminar. 
	 * @return elemento eliminado. null si no hay elemento en esa posicion.
	 */
	public T deleteElement(int pos) 
	{
		T retorno = null;
		if(pos > 1)
			retorno = (T) nodoSiguiente.deleteElement(pos-1);
		
		else if(pos == 1)
		{
			retorno = (T) nodoSiguiente.darInformacion( );
			nodoSiguiente = nodoSiguiente != null? nodoSiguiente.darSiguiente():null;
		}
		return retorno;
	}
	
	/**
	 * Utiliza recursion para insertar un elemento en pos.
	 * @param nuevo, nodo a enlazar.
	 * @param pos posicion del elemento a insertar. 
	 */
	public void insertElement(NodoEncadenado<T> nuevo, int pos) 
	{
		if(pos > 1)
			 nodoSiguiente.insertElement(nuevo,(pos-1));
		
		else if(pos == 1)
		{
			nuevo.cambiarSiguiente(nodoSiguiente);
			nodoSiguiente = nuevo;
		}
	}

}
