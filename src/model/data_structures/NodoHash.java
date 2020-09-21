package model.data_structures;

public class NodoHash <K extends Comparable<K>, V extends Comparable<V>> implements Comparable<NodoHash<K,V>>
{
	/**
	 * Representa la llave del nodo.
	 */
	private K key;
	
	/**
	 * Representa el valor del nodo.
	 */
	private V value;
	
	public NodoHash(K pKey,V pValue)
	{
		key = pKey;
		value = pValue;
	}
	
	public K getKey( )
	{
		return key;
	}
	
	public V getValue( )
	{
		return value;
	}

	
	public int compareTo(NodoHash o) 
	{
		return 0;
	}

	public void deleteLP() 
	{
		key = (K) "EMPTY";
		value = null;
	}
	
}
