package model.data_structures;

public class Bucket< K extends Comparable<K>, V extends Comparable<V>> implements Comparable<Bucket<K,V>>
{
	private ArregloDinamico<NodoHash<K,V>> nodos;
	
	public Bucket(int size)
	{
		nodos = new ArregloDinamico<NodoHash<K,V>>(size);
	}
	
	public void addToBucket(NodoHash<K,V> nodo)
	{
		int i = 0;
		while(i < nodos.size( ) && nodos.getElement(i) != null)
		{
			if(nodo.getKey( ).equals(nodos.getElement(i).getKey()))
			{
				nodos.getElement(i).changeValue(nodo.getValue());
				i = nodos.size( );
			}
			i++;
		}
		if(i < nodos.size())
			nodos.addLast(nodo);
		
	}
	
	public NodoHash<K, V> get(K key) 
	{
		int i = 0;
		NodoHash<K, V> buscado = null;
		while(i < nodos.size() && buscado == null)
		{
			NodoHash<K,V> act = nodos.getElement(i);
			if(act != null && act.getKey().equals(key))
				buscado = act;
		}
		return buscado;
	}
	
	public NodoHash<K, V> remove(K key) 
	{
		int i = 0;
		NodoHash<K, V> buscado = null;
		while(i < nodos.size() && buscado == null)
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
