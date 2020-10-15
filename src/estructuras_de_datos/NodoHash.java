package estructuras_de_datos;

public class NodoHash <K extends Comparable<K>, V > implements Comparable<NodoHash<K,V>>
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
	
	public void changeValue( V nValue )
	{
		value = nValue;
	}

	
	public int compareTo(NodoHash<K, V> o) 
	{
		return 0;
	}

	@SuppressWarnings("unchecked")
	public void deleteLP() 
	{
		key = (K) "EMPTY";
		value = null;
	}
	
}
