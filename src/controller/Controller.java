package controller;

import java.util.Scanner;

import model.data_structures.ArregloDinamico;
import model.data_structures.Lista;
import model.data_structures.ListaEncadenada;
import model.logic.Cinema;
import model.logic.Director;
import model.logic.Pelicula;
import sun.awt.RepaintArea;
import view.View;
import model.logic.Extras;

public class Controller {

	/* Instancia del Modelo*/
	private Cinema modelo;

	/* Instancia de la Vista*/
	private  View view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		int dato = -1;
		String respuesta = "";
		modelo = new Cinema(4000); 
		modelo.CargarArchivosArreglo();

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:

				view.printMessage("Bienvenido, los datos iniciales son:");
				view.printMessage("Datos primera pelicula: " + modelo.darPeliculasLista().firstElement().datosBasicos());
				view.printMessage("Datos ultima pelicula: " + modelo.darPeliculasLista().lastElement().datosBasicos());
				view.printMessage("La cantidad total de peliculas es: " + modelo.darTamano());
				break;



			case 2:

				view.printMessage("Bienvenido, los datos iniciales son:");
				view.printMessage("Datos primera pelicula: " + modelo.darPeliculas().firstElement().datosBasicos());
				view.printMessage("Datos ultima pelicula: " + modelo.darPeliculas().lastElement().datosBasicos());
				view.printMessage("La cantidad total de peliculas es: " + modelo.darTamano());
				break;


			case 3:

				view.printMessage("Hola, seleccione el numero de peliculas a rankear");
				int num = lector.nextInt();
				view.printMessage("Hola, seleccione la opcion para rankear");
				view.printMessage("Opcion 1: Peores, por promedio de votos.");
				view.printMessage("Opcion 2: Mejores, por promedio de votos.");
				view.printMessage("Opcion 3: Peores, por total de votos.");
				view.printMessage("Opcion 4: Mejores, por total de votos.");
				int forma = lector.nextInt() -1;
				Lista<Pelicula> ranking = modelo.darRankPeliculas(num, forma );
				if(num < 3)
				{
					for(int i=0; i < ranking.size();i++)
					{
						Pelicula actual = ranking.getElement(i);
						String laInfo = "Id: " + actual.darId() + "     Promedio Votación:    " + actual.darVote_average() + "     Titulo: " + actual.darTitle() + "    Generos: " + actual.darGeneros() + "    Fecha de salida:  " + actual.darRelease_date() + actual.darCasting().castingNombres();
						view.printMessage(laInfo);
					}
				}
				else
				{
					for(int i=0; i < ranking.size();i++)
					{
						Pelicula actual = ranking.getElement(i);
						String laInfo = "Id: " + actual.darId() + "     Total Votos:    " + actual.darVote_count() + "     Titulo: " + actual.darTitle() + "    Generos: " + actual.darGeneros() + "    Fecha de salida:  " + actual.darRelease_date() + actual.darCasting().castingNombres();
						view.printMessage(laInfo);
					}
				}
	
				
			case 4:
				view.printMessage("Bienvenido, por favor ingrese el nombre del director a buscar: ");
				lector.nextLine();
				respuesta = lector.nextLine();
				ArregloDinamico<Pelicula> a = modelo.conocerUnDirector(respuesta);
				for(int i=0; i < a.size();i++)
				view.printMessage("Lista de peliculas de el director: " + a.getElement(i).datosBasicos());
				view.printMessage("El numero de peliculas del director es: " + a.size());
				Director t = modelo.buscarDirector(respuesta);
				if( t != null)
				view.printMessage("El promedio calificacion de las peliculas del director es : " + t.promedioCalificacionPeliculas());
				
			case 6:
				view.printMessage("Bienvenido, por favor ingrese el nombre del genero a buscar: ");
				lector.nextLine();
				respuesta = lector.nextLine();
				view.printMessage("Lista de peliculas de el director: " + modelo.entenderUnGenero(respuesta));
				

			case 7:
				view.printMessage("Hola, ingrese el genero a rankear");
				lector.nextLine();
				String gen = lector.nextLine();
				view.printMessage("Ahora, ingrese el numero de peliculas a rankear");
				int num2 = lector.nextInt();
				view.printMessage("Hola, seleccione la opcion para rankear");
				view.printMessage("Opcion 1: Peores, por promedio de votos.");
				view.printMessage("Opcion 2: Mejores, por promedio de votos.");
				view.printMessage("Opcion 3: Peores, por total de votos.");
				view.printMessage("Opcion 4: Mejores, por total de votos.");
				int forma2 = lector.nextInt() -1;
				Lista<Pelicula> ranking2 = modelo.darRankGenero(num2, forma2, gen);
				if(num2 < 3)
					for(int i=0; i < ranking2.size();i++)
					{
						Pelicula actual = ranking2.getElement(i);
						String laInfo = "Id: " + actual.darId() + "     Promedio Votación:    " + actual.darVote_average() + "     Titulo: " + actual.darTitle() + "    Generos: " + actual.darGeneros() + "    Fecha de salida:  " + actual.darRelease_date() + actual.darCasting().castingNombres();
						view.printMessage(laInfo);
					}
				else
				{
					for(int i=0; i < ranking2.size();i++)
					{
						Pelicula actual = ranking2.getElement(i);
						String laInfo = "Id: " + actual.darId() + "     Total Votos:    " + actual.darVote_count() + "     Titulo: " + actual.darTitle() + "    Generos: " + actual.darGeneros() + "    Fecha de salida:  " + actual.darRelease_date() + actual.darCasting().castingNombres();
						view.printMessage(laInfo);
					}
				}


				//case 4:
				//view.printMessage("Hola, ingrese el nombre del director a analizar.");
				//lector.nextLine();
				//respuesta = lector.nextLine();
				//ArregloDinamico<Pelicula> buenas = modelo.darBuenasPeliculas(respuesta);

				//System.out.println(buenas.size());
				//for(int i= 0; i< modelo.darBuenasPeliculas(respuesta).size();i++)
				//{

				//Pelicula actual = modelo.darBuenasPeliculas(respuesta).darElemento(i);
				//String loBasico = "Los peliculas son: " + "   Id: " +actual.darId() + "   Titulo: " + actual.darTitle() + "   Generos: " + actual.darGeneros() + "    Fecha de salida: " + actual.darRelease_date() + actual.darCasting().castingNombres();
				//view.printMessage(loBasico);
				//}
				//break;



			default: 
				view.printMessage("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}

	}

}
