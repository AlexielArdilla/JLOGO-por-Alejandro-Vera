package logica;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class LecturaEscrituraBMP {

	DataInputStream data_stream;
	FileOutputStream salida_stream;
	public static int ancho = 512;
	public static int alto = 512;
	 int offset;
	static Pixel pixeles_entrada[][];
	Pixel pixeles_para_escribir[][];
	
	public LecturaEscrituraBMP(){}
	
	
	public void cargarPixelesParaEscribir(Pixel[][] matriz){//*****
		
		pixeles_para_escribir = matriz;
		
	}
	
	public Pixel[][] loadImage(String arg0) {//para cargar escribir la extension
		try {
			FileInputStream fi_stream = new FileInputStream(arg0);
			this.data_stream = new DataInputStream(fi_stream);

			read_file_header();
			read_info_header();
			boolean es_menor = esImagenMenorAlTamanio();
			
			
			pixeles_entrada = new Pixel[alto][ancho];
			for (int i = alto - 1; i >= 0; i--) {
				for (int j = 0; j < ancho; j++) {
					int blue = data_stream.read();
					int green = data_stream.read();
					int red = data_stream.read();
					pixeles_entrada[i][j] = new Pixel(red, green, blue);

				}
				for (int x = 0; x < padding(ancho); x++) {
					data_stream.read();// lee basura

				}
			}
			if (es_menor) {

				JOptionPane.showMessageDialog(null, "La imagen es de menor tamanio que el permitido");
				return crearMosaico();
				
			} // ***fin del if!!!
			
			return pixeles_entrada;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return pixeles_entrada;
	}

	public int padding(int ancho) {

		int padding = ancho % 4;

		return padding;
	}

	public void read_file_header() throws IOException {

		char mi_byte1 = (char) data_stream.read();
		char mi_byte2 = (char) data_stream.read();

		if (mi_byte1 == 'B' && mi_byte2 == 'M') {// chequea que sea un BITMAP!!!

			readInt();// tamanio archivo
			readShort();// reservado
			readShort();// reservado
			offset = readInt();// posicicion de arranque info pixeles
		} else {

			JOptionPane.showMessageDialog(null, "Error al leer");

		}
	}

	public void read_info_header() throws IOException {// **lectura de cabecera

		readInt();// tamaño tiene que ser 40
		ancho = readInt();
		alto = readInt();
		readShort();// 24------> cotejar esto
		readShort();// bytes_pixeles
		readInt();// tipo de compresion =0
		readInt();// tamanio imagen
		readInt();// basura
		readInt();// basura
		readInt();// basura
		readInt();// basura

	}

	public int readInt() throws IOException {// **********listo
		byte[] bytes = new byte[4];
		this.data_stream.read(bytes);
		return (bytes[3] & 0xFF) << 24 | (bytes[2] & 0xFF) << 16 | (bytes[1] & 0xFF) << 8 | bytes[0] & 0xFF;
	}

	public short readShort() throws IOException {
		byte[] bytes = new byte[2];
		this.data_stream.read(bytes);
		return (short) (((short) bytes[1] & 0xFF) << 8 | (short) bytes[0] & 0xFF);
	}
	
	
	
	public void saveResult(String arg0) {// ************************ANDA!!!

		try {

			this.salida_stream = new FileOutputStream(arg0 + ".bmp");//para guardar no escribir la extension!!!
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		int imagen_pura = 0;
		
		int tamanio_imagen = 0;

		try {
			salida_stream.write((byte) 'B');
			
			salida_stream.write((byte) 'M');

			// normal*************************************
				
				//pixeles_para_escribir = new Pixel[ancho][alto];
				
				imagen_pura = (alto * ancho * 3) + padding(ancho);
				
				//pixeles_para_escribir = pixeles_entrada;//********cambio acá
				
				tamanio_imagen = imagen_pura + offset;
			
			write(tamanio_imagen);
			write((short) 0);
			write((short) 0);
			write((int) offset);
			write((int) 40);
			write((int) 512);//alto
			write((int) 512);//ancho
			write((short) 1);
			write((short) 24);
			write((int) 0);
			write((int) imagen_pura);
			write((int) 0);
			write((int) 0);
			write((int) 0);
			write((int) 0);

			for (int i = 0; i < 512; i++) {
				for (int j = 0; j < 512; j++) {

					int blue = (int) pixeles_para_escribir[512 - i - 1][j].getB();
					
					this.salida_stream.write((byte) (blue));
					
					int green = (int) pixeles_para_escribir[512 - i - 1][j].getG();
					
					this.salida_stream.write((byte) (green));
					
					int red = (int) pixeles_para_escribir[512 - i - 1][j].getR();
					
					this.salida_stream.write((byte) (red));
				}
				for (int x = 0; x < padding(512); ++x) {
					
					this.salida_stream.write((byte) 0);
				}
			}
			
			this.salida_stream.close();
		
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	private void write(int entero) throws IOException {
		
		byte[] bytes = new byte[4];
		
		bytes[0] = ((byte) (entero & 0xFF));
		bytes[1] = ((byte) (entero >> 8 & 0xFF));
		bytes[2] = ((byte) (entero >> 16 & 0xFF));
		bytes[3] = ((byte) (entero >> 24 & 0xFF));
		
		this.salida_stream.write(bytes);
	}

	private void write(short s) throws IOException {
		
		byte[] bytes = new byte[2];
		bytes[0] = ((byte) (s & 0xFF));
		bytes[1] = ((byte) (s >> 8 & 0xFF));
		
		this.salida_stream.write(bytes);
	}

	public boolean esImagenMenorAlTamanio(){//****************************
		
		if(ancho<512){
			return true;
		}
		if(alto<512){
			
			return true;
			
		}
		
		return false;
	}//****************************************************************
	
	
	
	// ***probando mosaico*****
	public Pixel[][] crearMosaico() {

		Pixel[][] matriz_nueva = new Pixel[512][512];

		for (int i = 0; i < 512; i++) {
			for (int j = 0; j < 512; j++) {

				if (j < pixeles_entrada.length - 1 && i < pixeles_entrada[0].length - 1) {
					matriz_nueva[j][i] = new Pixel(pixeles_entrada[j][i].getR(), pixeles_entrada[j][i].getG(),
							pixeles_entrada[j][i].getB());

				} else {
					
					matriz_nueva[j][i] = pixeles_entrada[pixeles_entrada.length/2][pixeles_entrada[0].length/2];
				
				}
			}
		}
		//**************************
		
		
		return matriz_nueva;
	}// *******************************

	public int tamanioRecalculado(int tamanio){//**************************
		
		int recalculado;
		
		for(int i = 1; i <200; i++){
			
			recalculado = tamanio*i;
			
			if(recalculado>=512){
				
				return i;
				
			}
			
		}
		
		
		return 0;
	}//*****************************************************************
	
	
	
	public boolean sonEnterosPositivos(LinkedList<String> lista) {

		for (String s : lista) {

			try {

				Integer.parseInt(s);

				if (Integer.parseInt(s) < 0) {

					return false;

				}

			} catch (NumberFormatException e) {

				return false;
			}
		}

		return true;
	}

}
