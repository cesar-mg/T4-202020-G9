package estructuras_de_datos;

public class BST<K extends Comparable<K>, V extends Comparable <V>> implements TablaSimbolosOrdenada<K, V> 
{

	/**
	 * Representa el tamanio actual del arbol.
	 */
	private int tamanoActual;

	/**
	 * Representa el nodo de raiz.
	 */
	private NodoArbol<K, V> raiz;

	/**
	 * Metodo constructor.
	 */
	public BST() 
	{
		raiz = null;
		tamanoActual = 0;
	}

	/**
	 * Retornar el n�mero de parejas [Llave,Valor] del �rbol
	 * @return n�mero de parejas [Llave,Valor] del �rbol.
	 */
	public int size() 
	{
		return tamanoActual;
	}

	/**
	 * Informa si el �rbol es vac�o
	 * @return true si esta vacio, false de lo contrario.
	 */
	public boolean isEmpty()
	{
		return tamanoActual == 0? true: false;
	}

	/**
	 * Retorna el valor V asociado a la llave key dada.
	 * @param key llave del valor V a buscar.
	 * @return Retorna el valor V asociado a la llave key dada. Si la llave no se encuentra se retorna el valor null
	 */
	public V get(K key) 
	{
		return raiz == null? null: raiz.get(key);
	}

	@Override
	public int getHeight(K key) 
	{
		return raiz == null? -1: raiz.getHeight(key);
	}

	/**
	 * Indica si la llave key se encuentra en el �rbol
	 * @param key de la llave a buscar
	 * @return True si la llave esta en el arbol, false de lo contrario.
	 */
	public boolean contains(K key) 
	{
		return get(key) != null? true : false;
	}

	/**
	 * Inserta la pareja [key, val] en el �rbol. Si la llave ya existe se reemplaza el valor. 
	 * @param key de la llave a meter.
	 * @param Value valor a introducir al arbol.
	 */
	public void put(K pKey, V pValue) 
	{
		tamanoActual++;
		if(raiz == null)
			raiz = new NodoArbol<K,V>(pKey, pValue);
		else
			raiz.put(pKey, pValue);

	}

	@Override
	public int height() 
	{
		return raiz == null? -1:raiz.height();
	}

	/**
	 * Llave m�s peque�a del �rbol.
	 * @return Retorna la llave m�s peque�a del �rbol. null si el �rbol esta vac�o.
	 */
	public K min() 
	{
		return raiz == null? null: raiz.min();
	}

	/**
	 * Llave m�s grande del �rbol.
	 * @return Retorna la llave m�s grande del �rbol. null si el �rbol esta vac�o.
	 */
	public K max() {
		// TODO Auto-generated method stub
		return raiz == null? null: raiz.max();
	}

	/**
	 * Retorna una lista de las llaves en el arbol.
	 * @return Lista de las llaves en el arbol.
	 */
	public Lista<K> keySet() 
	{
		ArregloDinamico<K> llaves = new ArregloDinamico<K>(tamanoActual);
		if(raiz != null)
			raiz.keySet(llaves);
		return llaves;
	}

	/**
	 * Retorna las llaves en el rango dado.
	 * @param init llave del rango inicial.
	 * @param end llave del rango final.
	 * @return las llaves en el rango dado.
	 */
	public Lista<K> keysInRange(K init, K end) 
	{
		ArregloDinamico<K> llaves = new ArregloDinamico<K>(tamanoActual);
		if(raiz != null)
			raiz.keysInRange(llaves, init, end);
		return llaves;
	}

	/**
	 * Retorna las llaves en el valor dado.
	 * @param init valor del rango inicial.
	 * @param end valor del rango final.
	 * @return las valor en el rango dado.
	 */
	public Lista<V> valuesInRange(K init, K end) 
	{
		ArregloDinamico<V> llaves = new ArregloDinamico<V>(tamanoActual);
		if(raiz != null)
			raiz.valuesInRange(llaves, init, end);
		return llaves;
	}



}
