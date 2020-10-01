package model.logic;

import java.util.ArrayList;

import model.data_structures.ArregloDinamico;

public class Actor implements Comparable <Actor>
{
	private ArregloDinamico<Pelicula> participacion;
	private String nombreActor;
	private int numeroPeliculasParticipo;
	private int promedioPeliculasCalificacion;
	private String nombreDirectorMasColaboraciones; 
	private ArregloDinamico<Pelicula> cpelicula; 


	/**
	 * 
	 */
	public Actor(String nNombre)
	{ 
		nombreActor = nNombre;
		
	}

	/**
	 * 
	 */
	public ArregloDinamico<Pelicula> darPeliculasParticipo(String nActor)
	{
		participacion = new ArregloDinamico<Pelicula>(10000);
		for(int i=0; i< cpelicula.size(); i++)
		{
			Pelicula r = cpelicula.getElement(i);
			if( r.darCasting().actorName1().equals(nActor) || r.darCasting().actorName2().equals(nActor) || r.darCasting().actorName3().equals(nActor) || r.darCasting().actorName4().equals(nActor) || r.darCasting().actorName5().equals(nActor))
			{
				participacion.addLast(r);
			}
		}
		return participacion;
	}
	public String darActor()
	{
		return nombreActor;
	}
	public void agregarPelicula(Pelicula n)
	{
		participacion.addLast(n);
	}
	public int darNumeroParticipaciones()
	{
		return numeroPeliculasParticipo = participacion.darTamano();
	}
	public int darPromedioCalificacion()
	{
		int cantidad = 0;
		double calificacion = 0;
		for(int i=0; i<participacion.size(); i++)
		{
			Pelicula r = participacion.getElement(i+1);
			if(r.darVote_average() >= 0)
			{
				calificacion += r.darVote_average();
				cantidad++;
			}
		}


		return promedioPeliculasCalificacion = (int) (calificacion/cantidad);
	}
	public String darDirectorMasColaboraciones()
	{
	
		ArrayList<String> director = new ArrayList<>();
		for(int i=0; i<director.size();i++)
		{
			Pelicula temp = participacion.getElement(i+1);
			if(temp.darCasting().directorName() != null)
			{
				director.add(temp.darCasting().directorName());
			}
		}
	
		for(int i=1;i<director.size();i++)
		{
			String respuesta = director.get(i);
			int mayorNum = 0;
			int numeroPeliculasComparar=1;
			String actual= director.get(i);
			
			for(int j=i+1;j<director.size();j++)
			{
				String comparar = director.get(j);
				if(actual.equals(comparar))
				{
					numeroPeliculasComparar++;
				}
			}
			String comparar = director.get(i+1);
			if (numeroPeliculasComparar > mayorNum)
			{
				mayorNum=numeroPeliculasComparar;
				respuesta = comparar; 
				nombreDirectorMasColaboraciones = respuesta;
			} 
		}
		return nombreDirectorMasColaboraciones;
	}




	@Override
	public int compareTo(Actor arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
