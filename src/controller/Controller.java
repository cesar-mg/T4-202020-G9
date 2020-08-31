package controller;

import java.util.Scanner;

import model.data_structures.ArregloDinamico;
import model.logic.Cinema;
import model.logic.Pelicula;
import sun.awt.RepaintArea;
import view.View;

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
		modelo = new Cinema();
	}
		
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		int dato = -1;
		String respuesta = "";
		modelo = new Cinema(4000); 
		modelo.CargarArchivos();

		while( !fin ){
			view.printMenu();
			
			int option = lector.nextInt();
			switch(option){
				case 1:
				    
					view.printMessage("Bienvenido, los datos iniciales son:");
				    view.printMessage("Datos primera pelicula: " + modelo.darPeliculas().firstElement().datosBasicos());
				    view.printMessage("Datos ultima pelicula: " + modelo.darPeliculas().lastElement().datosBasicos());
				    view.printMessage("La cantidad total de peliculas es: " + modelo.darTamano());
					break;

				case 2:
					view.printMessage("Hola, ingrese el nombre del director a analizar.");
					lector.nextLine();
					respuesta = lector.nextLine();
					ArregloDinamico<Pelicula> buenas = modelo.darBuenasPeliculas(respuesta);

					System.out.println(buenas.size());
					for(int i= 0; i< modelo.darBuenasPeliculas(respuesta).size();i++)
					{
					
					Pelicula actual = modelo.darBuenasPeliculas(respuesta).darElemento(i);
					String loBasico = "Los peliculas son: " + "   Id: " +actual.darId() + "   Titulo: " + actual.darTitle() + "   Generos: " + actual.darGeneros() + "    Fecha de salida: " + actual.darRelease_date() + actual.darCasting().castingNombres();
					view.printMessage(loBasico);
					}
					break;

			

				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
		
	}
	
}
