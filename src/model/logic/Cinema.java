package model.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import controller.Controller;
import model.data_structures.ArregloDinamico;
import model.data_structures.Lista;
import model.data_structures.ListaEncadenada;


/**
 * Definicion del modelo del mundo
 *
 */
public class Cinema {
	/**
	 * Atributos del modelo del mundo
	 */
	private Lista datos;
	
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public static final String SEPARATOR=";";
	
	private ArregloDinamico<Pelicula> peliculas; 
	
	private ArregloDinamico<Director> directores;
	
	private ListaEncadenada<Pelicula> lasPeliculas;
	
	private ListaEncadenada<Director> losDirectores;
	
	private ArregloDinamico<Pelicula> ranking; 
	

	public Cinema()
	{
		
	}

	public Cinema(int tamano, int tamR)
	{
		peliculas = new ArregloDinamico<Pelicula>(tamano);
		lasPeliculas = new ListaEncadenada<Pelicula>();
		ranking = new ArregloDinamico<Pelicula>(tamR);
	}
	public ArregloDinamico<Pelicula> darPeliculas()
	{
		return peliculas;
	}

	
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return peliculas.size();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(Pelicula dato)
	{	
		peliculas.agregar(dato);
	}
	
	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public Comparable buscar(int pos)
	{
		return  peliculas.getElement(pos);
	}
	
	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public Comparable eliminar(int pos)
	{
		return peliculas.deleteElement(pos);
	}

	public ArregloDinamico<Pelicula> darBuenasPeliculas(String director)
	{
		
		ArregloDinamico<Pelicula> buenas = new ArregloDinamico<Pelicula>(50);
		for(int i = 0; i < peliculas.size(); i++)
		{
			
			Pelicula act = peliculas.getElement(i);
			//System.out.println(act.darVote_average());
		//System.out.println(act.darCasting().directorName());
			if(act.darCasting().directorName().equals(director) && act.darVote_average() >=6.0)
				buenas.addLast(act);
			
		}
		return buenas;
	}
	
	public ArregloDinamico<Pelicula> darRankingPeliculasVotos()
	{
		ArregloDinamico<Pelicula> top = new ArregloDinamico<Pelicula>(20);
		for(int i = 0; i < peliculas.size(); i++)
		{
			
			Pelicula r = peliculas.getElement(i);
			if(r.darVote_average() >= 8.0)
			{
				top.addLast(r);
			}
		}
		for(int i = 0; i < top.size(); i++)
		{
			Pelicula primera = top.darElemento(i);
			for(int j = i + 1; j < top.size() ; i++)
			{
				Pelicula comparar = top.darElemento(j);
				if(comparar.darVote_average() >= primera.darVote_average())
				{
					top.changeInfo(i, top.darElemento(j)); 
					top.changeInfo(j, primera);
				}
			}
		}
		return top;
	}
	
	public ArregloDinamico<Pelicula> darRankingPeliculasPromedio()
	{
		ArregloDinamico<Pelicula> top = new ArregloDinamico<Pelicula>(20);
		for(int i = 0; i < peliculas.size(); i++)
		{
			
			Pelicula r = peliculas.getElement(i);
			if(r.darVote_count() >= 2500)
			{
				top.addLast(r);
			}
		}
		for(int i = 0; i < top.size(); i++)
		{
			Pelicula primera = top.darElemento(i);
			for(int j = i + 1; j < top.size() ; i++)
			{
				Pelicula comparar = top.darElemento(j);
				if(comparar.darVote_count() >= primera.darVote_count())
				{
					top.changeInfo(i, top.darElemento(j)); 
					top.changeInfo(j, primera);
				}
			}
		}	
		return top;
	}
	
	public void CargarArchivosArreglo()
	{

		BufferedReader bufferLectura = null;

		try{
			bufferLectura = new BufferedReader(new FileReader("./data/SmallMoviesDetailsCleaned.csv"));

			String linea = bufferLectura.readLine();
			linea = bufferLectura.readLine();
			while (linea!= null)
			{
				String[] campos = linea.split(SEPARATOR);
				Pelicula temp = new Pelicula(Integer.parseInt(campos[0].trim()), campos[1], campos[2], campos[3], campos[4], campos[5], campos[6], campos[7], campos[8], campos[9], campos[10], campos[11], campos[12], campos[13], campos[14], campos[15], campos[16], Double.parseDouble(campos[17].trim()), Double.parseDouble(campos[18].trim()), campos[19], campos[20], null);
				peliculas.agregar(temp);
				linea = bufferLectura.readLine();
			}
			bufferLectura.close();

		}
		catch(IOException e)
		{
			e.printStackTrace();
		}


		try{
			bufferLectura = new BufferedReader(new FileReader("./data\\MoviesCastingRaw-small.csv"));

			String linea = bufferLectura.readLine();
			linea = bufferLectura.readLine();
			int i = 0;
			while (linea!= null)
			{
				String[] campos = linea.split(SEPARATOR);
				
				Casting temp = new Casting (Integer.parseInt(campos[0]), campos[1],Integer.parseInt(campos[2]), campos[3], Integer.parseInt(campos[4]), campos[5], Integer.parseInt(campos[6]), campos[7], Integer.parseInt(campos[8]), campos[9], Integer.parseInt(campos[10]), Integer.parseInt(campos[11]), campos[12].trim(), Integer.parseInt(campos[13]), Integer.parseInt(campos[14]), campos[15], Integer.parseInt(campos[16]), campos[17], campos[18]);
				peliculas.getElement(i).cambiarCast(temp);
				i++;
				linea = bufferLectura.readLine();
			}
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			if( bufferLectura != null)
			{
				try
				{
					bufferLectura.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public void CargarArchivosLista()
	{

		BufferedReader bufferLectura = null;

		try{
			bufferLectura = new BufferedReader(new FileReader("./data/SmallMoviesDetailsCleaned.csv"));

			String linea = bufferLectura.readLine();
			linea = bufferLectura.readLine();
			while (linea!= null)
			{
				String[] campos = linea.split(SEPARATOR);
				Pelicula temp = new Pelicula(Integer.parseInt(campos[0].trim()), campos[1], campos[2], campos[3], campos[4], campos[5], campos[6], campos[7], campos[8], campos[9], campos[10], campos[11], campos[12], campos[13], campos[14], campos[15], campos[16], Double.parseDouble(campos[17].trim()), Double.parseDouble(campos[18].trim()), campos[19], campos[20], null);
				lasPeliculas.addLast(temp);
				linea = bufferLectura.readLine();
			}
			bufferLectura.close();

		}
		catch(IOException e)
		{
			e.printStackTrace();
		}


		try{
			bufferLectura = new BufferedReader(new FileReader("./data\\MoviesCastingRaw-small.csv"));

			String linea = bufferLectura.readLine();
			linea = bufferLectura.readLine();
			int i = 0;
			while (linea!= null)
			{
				String[] campos = linea.split(SEPARATOR);
				
				Casting temp = new Casting (Integer.parseInt(campos[0]), campos[1],Integer.parseInt(campos[2]), campos[3], Integer.parseInt(campos[4]), campos[5], Integer.parseInt(campos[6]), campos[7], Integer.parseInt(campos[8]), campos[9], Integer.parseInt(campos[10]), Integer.parseInt(campos[11]), campos[12].trim(), Integer.parseInt(campos[13]), Integer.parseInt(campos[14]), campos[15], Integer.parseInt(campos[16]), campos[17], campos[18]);
				lasPeliculas.getElement(i).cambiarCast(temp);
				i++;
				linea = bufferLectura.readLine();
			}
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			if( bufferLectura != null)
			{
				try
				{
					bufferLectura.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

}
