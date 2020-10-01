package model.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.data_structures.ArregloDinamico;


//CLASE EN DESARROLLO 
public class Director implements Comparable<Director>
{

	private String director;
	private int id ;
	private ArregloDinamico<Pelicula>peliculas;




	public Director(int elId, String elDirector )
	{
		id = elId;
		director = elDirector;
		peliculas = new ArregloDinamico<Pelicula>(100);

	}

	public int darId(){
		return id;
	}

	public String darDirector(){
		return director;
	}

	public void agregarPelicula (Pelicula d){
		peliculas.addLast(d);
	}


	public ArregloDinamico<Pelicula> darPeliculas(){
		return peliculas;
	}

	public double promedioCalificacionPeliculas(){
		double promedio= 0;
		int contador = peliculas.size();
		for(int i=0; i < peliculas.size();i++){
			Pelicula actual = peliculas.getElement(i+1);
			promedio += actual.darVote_average();
		}
		return promedio / contador;
	}
	@Override
	public int compareTo(Director o) 
	{
		return (id - o.darId());
	}


}




