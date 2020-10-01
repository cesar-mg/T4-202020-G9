package model.data_structures;

public class Bucket< K extends Comparable<K>, V extends Comparable<V>> implements Comparable<Bucket<K,V>>
{
	private ArregloDinamico<NodoHash<K,V>> nodos;
	private int m;
	public Bucket(int size)
	{
		m = size;
		nodos = new ArregloDinamico<NodoHash<K,V>>(size);
	}
	
	public void addToBucket(NodoHash<K,V> nodo)
	{
		int i = 1;
		while(i <= m && nodos.getElement(i) != null)
		{
			if(nodo.getKey( ).equals(nodos.getElement(i).getKey()))
			{
				nodos.getElement(i).changeValue(nodo.getValue());
				i = nodos.size( );
			}
			i++;
		}
		if(i <= m)
			nodos.addLast(nodo);
		
	}
	
	public NodoHash<K, V> get(K key) 
	{
		int i = 1;
		NodoHash<K, V> buscado = null;
		while(i <= m && buscado == null)
		{
			NodoHash<K,V> act = nodos.getElement(i);
			if(act != null && act.getKey().equals(key))
				buscado = act;
		}
		return buscado;
	}
	
	public NodoHash<K, V> remove(K key) 
	{
		int i = 1;
		NodoHash<K, V> buscado = null;
		while(i <= m && buscado == null)
		{
			NodoHash<K,V> act = nodos.getElement(i);
			if(act != null && act.getKey().equals(key))
			{
				buscado = act;
				nodos.deleteElement(i);
			}
		}
		return null;

	}
	public ArregloDinamico<NodoHash<K,V>> getAll()
	{
		return nodos;
	}

	/**
	 * No hace nada.
	 */
	@Override
	public int compareTo(Bucket<K, V> o) 
	{
		
		return 0;
	}


	
}
