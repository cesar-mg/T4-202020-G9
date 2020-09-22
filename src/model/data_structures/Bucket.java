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
	
	public void addToKey(NodoHash<K,V> nodo)
	{
		int i = 0;
		boolean done = false;
		while(i < nodos.size( ) && !done)
		{
			NodoHash<K,V> temp = nodos.getElement(i);
			if(nodo.getKey( ).equals(temp.getKey()))
			{
				V valor = temp.getValue();
				if(valor instanceof ArregloDinamico)
				{
					ArregloDinamico t = (ArregloDinamico) valor;
					t.addLast(nodo.getValue());
				}
				else
				{
					ArregloDinamico t = new ArregloDinamico(2);
					t.addLast(temp);
					t.addLast(nodo.getValue());
					temp.changeValue((V) t);
				}
				done = true;
			}
			i++;
		}
		if(i < nodos.size())
			nodos.addLast(nodo);
		
	}
	
	
	/**
	 * No hace nada.
	 */
	@Override
	public int compareTo(Bucket o) 
	{
		
		return 0;
	}
}
