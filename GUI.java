/*
 * UVG
 * Hoja de trabajo 8
 * Daniel Morales 15526
 * Rodrigo Corona 15102
 * Fernando Hernandez 15476
*/	

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;

public class GUI extends JFrame implements ActionListener{

		private Container contenedor;  
		JLabel labelTitulo;
		public JTextArea areaDeTexto;
		JButton botonAbrir,btnNewButton,btnCargar;
		JScrollPane scrollPaneArea;
		JFileChooser fileChooser; 
		String texto="";
		private ArrayList<String[]> array2 = new ArrayList<String[]>();
		public  ArrayList<String[]> array3 = new ArrayList<String[]>();
		private JTextField txtNoHayArchivo;
		

		public GUI(){
			contenedor=getContentPane();
			contenedor.setLayout(null);
			
			fileChooser=new JFileChooser();
			 
			labelTitulo= new JLabel();
			labelTitulo.setText("l Tribunal Supremo Electorial");
			labelTitulo.setBounds(110, 20, 180, 23);
			
			areaDeTexto = new JTextArea();
			areaDeTexto.setEditable(false);
			areaDeTexto.setLineWrap(true);
			areaDeTexto.setWrapStyleWord(true);
		   	scrollPaneArea = new JScrollPane();
			scrollPaneArea.setBounds(20, 50, 350, 270);
	        scrollPaneArea.setViewportView(areaDeTexto);
	       	

			botonAbrir= new JButton();
			botonAbrir.setText("Boton 1");
			botonAbrir.setBounds(474, 281, 91, 23);
			botonAbrir.addActionListener(this);
			
			contenedor.add(labelTitulo);
			contenedor.add(scrollPaneArea);
			contenedor.add(botonAbrir);
			
			btnNewButton = new JButton("Boton 2");
			btnNewButton.setBounds(620, 281, 89, 23);
			getContentPane().add(btnNewButton);
			btnNewButton.addActionListener(this);
			
			JTextPane txtpnInstruccionesnBoton = new JTextPane();
			txtpnInstruccionesnBoton.setEditable(false);
			txtpnInstruccionesnBoton.setFont(new Font("Dialog", Font.PLAIN, 14));
			txtpnInstruccionesnBoton.setBackground(SystemColor.control);
			txtpnInstruccionesnBoton.setText("Instrucciones: \r\nCargar: Cargar datos guategrafo.txt\r\nBoton 1: Preguntar el nombre de la ciudad origen y ciudad destino.\r\nBoton 2: Modificar grafo");
			txtpnInstruccionesnBoton.setBounds(440, 50, 269, 101);
			getContentPane().add(txtpnInstruccionesnBoton);
			
			txtNoHayArchivo = new JTextField();
			txtNoHayArchivo.setEditable(false);
			txtNoHayArchivo.setForeground(Color.RED);
			txtNoHayArchivo.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
			txtNoHayArchivo.setText("No hay archivo cargado.");
			txtNoHayArchivo.setBackground(Color.DARK_GRAY);
			txtNoHayArchivo.setBounds(509, 190, 204, 34);
			getContentPane().add(txtNoHayArchivo);
			txtNoHayArchivo.setColumns(10);
			
			btnCargar = new JButton("Cargar");
			btnCargar.setBounds(410, 197, 89, 23);
			getContentPane().add(btnCargar);
			btnCargar.addActionListener(this);
			setTitle("Correor");
			setSize(750,363);
			setLocationRelativeTo(null);
			
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}


		@Override
		public void actionPerformed(ActionEvent evento) {
			if (evento.getSource()==btnCargar){
				abrirArchivo();
				int conta=0;
				for (String [] i: array2){
					conta++;
					if (conta>1){
						array3.add(i);
					}
				}
				
				
			}
			if (evento.getSource()==botonAbrir){
				if (txtNoHayArchivo.getText().equals("Cargado con exito")){
		
				}
				else{
					JOptionPane.showMessageDialog(null, "Error",
							  "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			if (evento.getSource()==btnNewButton){
				if (txtNoHayArchivo.getText().equals("Cargado con exito")){
				
				}
				else{
					JOptionPane.showMessageDialog(null, "Error",
							  "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		

		private void  abrirArchivo() {
						
	 		String bfRead;
			fileChooser.showOpenDialog(this);
			File abre=fileChooser.getSelectedFile();

			if(abre!=null)
			{ 				
				txtNoHayArchivo.setText("Cargado con exito");
				try {
					BufferedReader ar = new BufferedReader(new FileReader(abre));
					while ((bfRead = ar.readLine()) != null) {
						 String array []=  bfRead.split(";");
						 array2.add(array);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "No se encontro archivo");
				}
			} 
				
		}
	}
