package model.data_structures;

import model.logic.Extras;

public class TablaHashLinearProbing < K extends Comparable<K>, V extends Comparable<V>> implements TablaSimbolos<K, V> 
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

	private ArregloDinamico<NodoHash<K,V>> mapa;

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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TablaHashLinearProbing( int size ) 
	{
		m = Extras.getNextPrime(2*size);
		p = Extras.getNextPrime(m);
		a  = (int) (Math.random() * (p-1)+1);
		b  = (int) (Math.random() * (p-1)+1);
		mapa = new ArregloDinamico<NodoHash<K,V>> (m);

	}


	public void put(K key, V value) 
	{
		int pos = getPos(key);
		NodoHash<K,V> act = mapa.getElement(pos);
		if(act == null)
		{
			ArregloDinamico<V> arr = new ArregloDinamico<>(2);
			arr.addLast(value);
			NodoHash<K,V> nuevo = new NodoHash<K,V>(key, (V) arr);
			mapa.changeInfo(pos, nuevo);
		}
		else
		{
			if(act.getKey().equals(key))
			{
				ArregloDinamico<V> datos = (ArregloDinamico<V>) act.getValue();
				datos.addLast(value);
			}
			else
				putRecursiveVersion(pos + 1, key, value);

		}
		verificarInvariante();
	}

	private void putRecursiveVersion(int pos, K key, V value)
	{
		if(pos >= (m - 1))
			pos = 0;
		NodoHash<K,V> act = mapa.getElement(pos);
		if(act == null)
		{
			ArregloDinamico<V> arr = new ArregloDinamico<>(2);
			arr.addLast(value);
			NodoHash<K,V> nuevo = new NodoHash<K,V>(key, (V) arr);
			mapa.changeInfo(pos, nuevo);
		}
		else if(act.getKey().equals(key))
		{
			ArregloDinamico<V> datos = (ArregloDinamico<V>) act.getValue();
			datos.addLast(value);
		}
		else
			putRecursiveVersion(pos + 1, key, value);
	}


	@Override
	public V get( K key ) 
	{
		int pos = getPos(key);
		NodoHash<K,V> act = mapa.getElement(pos);
		if(key.equals(act.getKey()))
			return act.getValue();
		else 
			return getRecursiveVersion(pos + 1, key);
	}

	private V getRecursiveVersion(int pos, K key) 
	{
		if(pos >= (m-1))
			pos = 0;
		NodoHash<K,V> act = mapa.getElement(pos);
		if(key.equals(act.getKey()))
			return act.getValue();
		else if(key.equals("EMPTY") || act.getKey() != null)
			return getRecursiveVersion(pos + 1, key);
		else
			return null; 
	}


	@Override
	public V remove( K key) 
	{
		int pos = getPos(key);
		V retorno = null;
		NodoHash<K,V> act = mapa.getElement(pos);
		if(key.equals(act.getKey()))
		{
			retorno = act.getValue();
			act.deleteLP();
		}
		else 
			return deleteRecursiveVersion(pos + 1, key);
		
		verificarInvariante();
		return retorno;
	}

	private V deleteRecursiveVersion(int pos, K key) 
	{
		if(pos >= (m-1))
			pos = 0;
		NodoHash<K,V> act = mapa.getElement(pos);
		if(key.equals(act.getKey()))
		{
			V retorno = act.getValue();
			act.deleteLP();
			return retorno;
		}
		else if(key.equals("EMPTY") || act.getKey() != null)
			return getRecursiveVersion(pos + 1, key);
		else
			return null; 
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
			NodoHash<K,V> temp = mapa.getElement(i);
			if(temp != null)
				result.addLast(temp.getKey());
			i++;
		}
		return result;
	}

	/**
	 * Retorna una lista con todas los valores almacenados en la Tabla.
	 * @return Todas los valores almacenados en la Tabla.
	 */
	public Lista<V> valueSet( )
	{
		ArregloDinamico<V> result = new ArregloDinamico<V>(totalElementos);
		int i = 0;
		while(i < m)
		{
			NodoHash<K,V> temp = mapa.getElement(i);
			if(temp != null)
			{
				int j = 0;
				while(j < m)
				{
					ArregloDinamico<V> arr = (ArregloDinamico<V>) temp.getValue();
					V act = arr.getElement(j);
					if(act != null)
						result.addLast(arr.getElement(j));
				}
				j++;
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
		assert factorDeCarga < 0.75;
		assert factorDeCarga >= 0;
	}
}
