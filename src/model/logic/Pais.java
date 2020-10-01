package model.logic;

import model.data_structures.ArregloDinamico;

public class Pais implements Comparable<Pais>  
{
	
	//-------------------------------------------------------------------------------
	// ATRIBUTOS
	//-------------------------------------------------------------------------------
	
	/**
	 * Representa el arreglo de peliculas del pais en cuestion.
	 */
	private ArregloDinamico<Pelicula> peliculas;
	
	/**
	 * Nombre del pais.
	 */
	private String nombre;


	//-------------------------------------------------------------------------------
	// CONSTRUCTOR
	//-------------------------------------------------------------------------------
	
	/**
	 * Metodo constructor del genero. 
	 * @param pNom, Nombre del genero.
	 */
	public Pais(String pNom)
	{
		nombre = pNom;
		peliculas = new ArregloDinamico<>(194);
	}

	//-------------------------------------------------------------------------------
	// METODOS
	//-------------------------------------------------------------------------------
	
	/**
	 * Retorna el nombre del genero.
	 * @return Nombre del genero.
	 */
	public String darNombre()
	{
		return nombre;
	}
	
	/**
	 * Retorna el arreglo de peliculas. 
	 * @return Arreglo de las peliculas.
	 */
	public ArregloDinamico<Pelicula> darPeliculas()
	{
		return peliculas;
	}
	
	/**
	 * Agrega una pelicula al pais.
	 */
	public void agregarPelicula(Pelicula nueva)
	{
		peliculas.addLast(nueva);
	}

	@Override
	public int compareTo(Pais o) 
	{
		return nombre.compareTo(o.darNombre());
	}
	
	@Override
	public String toString()
	{
		String resp = "Las Peliculas son: " + "\n";
		for(int i =1; i <= peliculas.size(); i++)
		{
			resp += peliculas.getElement(i).datosFormato2();
			resp += "\n";
		}
		return resp;
	}
}
