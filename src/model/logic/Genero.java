package model.logic;

import model.data_structures.ArregloDinamico;

public class Genero implements Comparable<Genero>  
{
	
	//-------------------------------------------------------------------------------
	// ATRIBUTOS
	//-------------------------------------------------------------------------------
	
	/**
	 * Representa el arreglo de peliculas del genero en cuestion.
	 */
	private ArregloDinamico<Pelicula> peliculas;
	
	/**
	 * Nombre del genero.
	 */
	private String nombre;
	
	/**
	 * Sumatoria de los votos del genero.
	 */
	private Double votos;
	
	/**
	 * Total de peliculas del genero.
	 */
	private int total;

	//-------------------------------------------------------------------------------
	// CONSTRUCTOR
	//-------------------------------------------------------------------------------
	
	/**
	 * Metodo constructor del genero. 
	 * @param pNom, Nombre del genero.
	 */
	public Genero(String pNom)
	{
		nombre = pNom;
		peliculas = new ArregloDinamico<>(750);
		votos = 0.0;
		total = 0;
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
	 * Retorna el promedio de las peliculas.
	 * @return Promedio de las peliculas.
	 */
	public Double darPromedio()
	{
		return votos / ( total + 0.0);
	}
	
	/**
	 * Retorna el total de peliculas.
	 * @return Total de peliculas.
	 */
	public int darTotal()
	{
		return total;
	}
	
	/**
	 * Agrega una pelicula al genero.
	 */
	public void agregarPelicula(Pelicula nueva)
	{
		peliculas.addLast(nueva);
		total++;
		votos += nueva.darVote_count();
	}

	@Override
	public int compareTo(Genero o) 
	{
		return nombre.compareTo(o.darNombre());
	}
	
	@Override
	public String toString()
	{
		String resp = "Las Peliculas son: ";
		for(int i = 0; i < peliculas.size(); i++)
		{
			resp += peliculas.getElement(i).datosBasicos();
			resp += "\n";
		}
		resp += " El numero total de peliculas es: " + total;
		resp += " El promedio de votos es: " + darPromedio();
		return resp;
	}
}
