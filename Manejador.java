/*
 * UVG
 * Hoja de trabajo 8
 * Daniel Morales 15526
 * Rodrigo Corona 15102
 * Fernando Hernandez 15476
*/	

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JOptionPane;



public class Manejador {
	private ArrayList<String> array = new ArrayList<String>();


	ArrayList<String> leerContenido(String archivo) {
		String bfRead;
		try {
			BufferedReader ar = new BufferedReader(new FileReader(archivo));
			while ((bfRead = ar.readLine()) != null) {
				array.add(bfRead);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se encontro archivo");
		}
		return array;
	}

	void hacergrafo(){
		String ciudad1="",ciudad2="",distancia="";

		for (String i:array){
			int primero =i.indexOf(" ");
			int segundo =i.indexOf(" ",primero+1);
			int tercero =i.indexOf(" ",segundo+1);

			ciudad1=i.substring(0,primero).trim();
			ciudad2=i.substring(primero,segundo).trim();
			distancia=i.substring(segundo,tercero).trim();
		}
		
	}
	
}
