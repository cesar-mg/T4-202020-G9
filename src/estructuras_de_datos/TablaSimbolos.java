package estructuras_de_datos;

public interface TablaSimbolos <K extends Comparable<K>, V extends Comparable<V>> 
{
	/**
	 * Agregar una dupla (K, V) a la tabla. Si la llave K existe, se reemplaza su valor asociado. K es unica.
	 * @pre V != null.
	 * @param K key, llave del elemento a agregar.
	 * @param V value, valor del elemento a agregar.
	 */
	void put(K key, V value);

	/**
	 * Retorna el valor V asociado a la llave K.
	 * @param K key, llave del elemento a agregar.
	 * @return V value, valor del elemento con la llave K, null si no existe.
	 */
	V get( K key );

	/**
	 * Elimina el valor V asociado a la llave K.
	 * @param K key, llave del elemento a agregar.
	 * @return V value, valor del elemento con la llave K a eliminar, null si no existe.
	 */
	V remove( K key );

	/**
	 * Informa si la llave k esta almacenada.
	 * @param key, llave a verificar.
	 * @return True si esta almacenada, false de lo contrario.
	 */
	boolean contains(K key);

	/**
	 * Revisa si la tabla se encuentra vacia.
	 * @return True si esta vacia, false de lo contrario.
	 */
	boolean isEmpty( );
	
	/**
	 * Retorna el numero de tuplas presentes en la tabla de simobolos.
	 * @return numero de tuplas presentes en la tabla de simobolos.
	 */
	int size( );
	
	/**
	 * Retorna una lista con todas las llaves almacenadas en la Tabla.
	 * @return Todas las llaves almacenadas en la Tabla.
	 */
	Lista<K> keySet( );
	
	/**
	 * Retorna una lista con todas los valores almacenados en la Tabla.
	 * @return Todas los valores almacenados en la Tabla.
	 */
	Lista<V> valueSet( );

}
