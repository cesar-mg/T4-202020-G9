package modeloMundo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import estructuras_de_datos.ArregloDinamico;
import estructuras_de_datos.BST;
import estructuras_de_datos.Lista;



public class Central 
{

	private BST<Date, ArregloDinamico<Accidente>> arbol;

	private int total;

	public Central()
	{
		arbol = new BST<Date, ArregloDinamico<Accidente>>();
		total = 0;
	}

	public int darTotal( )
	{
		return total;
	}

	public BST<Date, ArregloDinamico<Accidente>>  darArbol( )
	{
		return arbol;
	}

	public Lista<Accidente> accidentesEnFecha(Date fecha)
	{
		return arbol.get(fecha);
	}
	public Lista<Double> accidentesPorSeveridad( Lista<Accidente> accidentes)
	{
		ArregloDinamico<Double> resp = new ArregloDinamico<>(4);
		for(int i = 1; i < 5; i++)
			resp.changeInfo(i, 0.0);
		for(int i = 1; i <= accidentes.size(); i++)
		{
			double severity = (double) accidentes.getElement(i).getSeverity( );
			switch((int) severity)
			{
			case 1:
				resp.changeInfo(1, resp.getElement(1) + 1 );
				break;
			case 2:
				resp.changeInfo(2, resp.getElement(2) + 1 );
				break;
			case 3:
				resp.changeInfo(3, resp.getElement(3) + 1 );
				break;
			case 4:
				resp.changeInfo(4, resp.getElement(4) + 1 );
				break;
			}
		}

		return resp; 
	}


	public void cargarDatos( )
	{
		BufferedReader bufferLectura = null;

		try{
			bufferLectura = new BufferedReader(new FileReader("./data/us_accidents_small.csv"));

			String linea = bufferLectura.readLine();
			linea = bufferLectura.readLine();
			while (linea!= null)
			{
				String[] campos = linea.split(",");
				Accidente actual = new Accidente(campos[0], campos[1], campos[2], Double.parseDouble(campos[3]), campos[4], campos[5], Double.parseDouble(campos[6]), Double.parseDouble(campos[7]), campos[8], campos[9], Double.parseDouble(campos[10]), campos[11], campos[12], campos[13], campos[14], campos[15], campos[16], campos[17], campos[18], campos[19], campos[20], campos[21], campos[22], campos[23], campos[24], campos[25], campos[26], campos[27], campos[28], campos[29], campos[30], campos[31], Boolean.parseBoolean(campos[32]), Boolean.parseBoolean(campos[33]), Boolean.parseBoolean(campos[34]), Boolean.parseBoolean(campos[35]), Boolean.parseBoolean(campos[36]), Boolean.parseBoolean(campos[37]), Boolean.parseBoolean(campos[38]), Boolean.parseBoolean(campos[39]), Boolean.parseBoolean(campos[40]), Boolean.parseBoolean(campos[41]), Boolean.parseBoolean(campos[42]), Boolean.parseBoolean(campos[43]), Boolean.parseBoolean(campos[44]), campos[45], campos[46], campos[47], campos[48]);
				SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
				Date temp = formato.parse(campos[4].substring(0,10));


				if(!arbol.contains(temp))
				{
					ArregloDinamico<Accidente> arr = new ArregloDinamico<Accidente>(5);
					arr.addLast(actual);
					arbol.put(temp, arr);
				}
				else
					arbol.get(temp).addLast(actual);
				total++;
				linea = bufferLectura.readLine( );
			}
			bufferLectura.close();

		}
		catch(IOException e)
		{
			e.printStackTrace();
		} 
		catch (ParseException e) 
		{
			System.out.println("AAAA");
			e.printStackTrace();
		}
	}
}
