package model.data_structures;

import model.logic.Extras;

public class TablaHashSeparateChaining < K extends Comparable<K>, V extends Comparable<V>> implements TablaSimbolos<K, V> 
{
	/**
	 * Representa el factor de carga actual.
	 */
	private double factorDeCarga;

	/**
	 * Representa el total de elementos del mapa.
	 */
	private int totalElementos;

	/**
	 * Representa el arreglo utilizado en el mapa;
	 */

	private ArregloDinamico<Bucket<K,V>> mapa;

	/**
	 * Representa la constante a utilizada en el MAD.
	 */
	private int a;

	/**
	 * Representa la constante b utilizada en el MAD.
	 */
	private int b;

	/**
	 * Representa la constante p utilizada en el MAD.
	 */
	private int p;

	/**
	 * Representa la constante m utilizada en el MAD.
	 */
	private int m; 


	public TablaHashSeparateChaining( int size ) 
	{
		m = Extras.getNextPrime((int) size/5);
		p = Extras.getNextPrime(m);
		a  = (int) (Math.random() * (p-1)+1);
		b  = (int) (Math.random() * (p-1)+1);
		mapa = new ArregloDinamico<Bucket<K,V>> (m);
		for(int i = 0; i < mapa.size();i++)
		{
			mapa.changeInfo(i, new Bucket<K,V>(5));
		}
	}

	public void put(K key, V value) 
	{
		int pos = getPos(key);
		Bucket<K,V> act = mapa.getElement(pos);
		NodoHash<K,V> nuevo = new NodoHash<K,V>(key, value);
		act.addToBucket(nuevo);
		verificarInvariante();
	}


	@Override
	public V get( K key ) 
	{
		int pos = getPos(key);
		Bucket<K,V> bucket = mapa.getElement(pos);
		NodoHash<K,V> buscado = bucket.get(key);
		return buscado == null? null: buscado.getValue();
	}

	@Override
	public V remove( K key) 
	{
		int pos = getPos(key);
		Bucket<K,V> bucket = mapa.getElement(pos);
		NodoHash<K,V> buscado = bucket.remove(key);
		verificarInvariante();
		return buscado == null? null: buscado.getValue();
	}


	@Override
	public boolean contains( K key) 
	{
		return get(key) != null ? true:false;
	}

	/**
	 * Revisa si la tabla se encuentra vacia.
	 * @return True si esta vacia, false de lo contrario.
	 */
	public boolean isEmpty( )
	{
		return totalElementos > 0 ? false : true;
	}

	/**
	 * Retornar el numero de tuplas presentes en la tabla de simobolos.
	 * @return numero de tuplas presentes en la tabla de simobolos.
	 */
	public int size( )
	{
		return totalElementos;
	}

	public Lista<K> keySet() 
	{
		ArregloDinamico<K> result = new ArregloDinamico<K>(totalElementos);
		int i = 0;
		while(i < m)
		{
			ArregloDinamico<NodoHash<K,V>> temp = mapa.getElement(i).getAll();
			int j = 0;
			while(j < temp.size())
			{
				NodoHash<K,V> tElem = temp.getElement(j);
				if(tElem != null && tElem.getKey() != null)
					result.addLast(temp.getElement(j).getKey());	
			}
			i++;
		}
		return result;
	}

	
	/**
	 * Retorna una lista con todas los valores almacenados en la Tabla.
	 * @return Todas los valores almacenados en la Tabla.
	 */
	public Lista<V> valueSet() 
	{
		ArregloDinamico<V> result = new ArregloDinamico<V>(totalElementos);
		int i = 0;
		while(i < m)
		{
			ArregloDinamico<NodoHash<K,V>> temp = mapa.getElement(i).getAll();
			int j = 0;
			while(j < temp.size())
			{
				NodoHash<K,V> tElem = temp.getElement(j);
				if(tElem != null && tElem.getValue() != null)
					result.addLast(temp.getElement(j).getValue());	
			}
			i++;
		}
		return result;
	}

	public Lista<V> valueSet() 
	{
		ArregloDinamico<V> result = new ArregloDinamico<V>(totalElementos);
		int i = 0;
		while(i < m)
		{
			ArregloDinamico<NodoHash<K,V>> temp = mapa.getElement(i).getAll();
			int j = 0;
			while(j < temp.size())
			{
			result.addLast(temp.getElement(j).getValue());	
				NodoHash<K,V> tElem = temp.getElement(j);
				if(tElem != null && tElem.getValue() != null)
					result.addLast(temp.getElement(j).getValue());	
			}
			i++;
		}
		return result;
	}
	
	public int getPos(K key)
	{
		int hashInicial =  (a * key.hashCode( ) + b) % p ;
		int hashFinal = Math.abs(hashInicial) % m;
		return hashFinal;
	}

	private void verificarInvariante( )
	{
		assert factorDeCarga < 5.0;
		assert factorDeCarga >= 0;
	}

}
