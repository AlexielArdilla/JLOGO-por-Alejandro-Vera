package logica;
import java.util.Random;


public class Imagen {
	
	private int alto;
	private int ancho;
	private Pixel[][] fondo;
	int ancho_pincel;
	
	public Imagen(){
		
		
		alto = 512;
		ancho = 512;
		fondo = new Pixel[alto][ancho];
		llenarDeBlanco();
		
	}
	
	
	
	public int getAncho_pincel() {
		return ancho_pincel;
	}



	public void setAncho_pincel(int ancho_pincel) {
		this.ancho_pincel = ancho_pincel;
	}



	public int getAlto() {
		return alto;
	}
	public void setAlto(int alto) {
		this.alto = alto;
	}
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	public Pixel[][] getFondo() {
		return fondo;
	}
	public void setFondo(Pixel[][] fondo) {
		this.fondo = fondo;
	}
	
	public void llenarDeBlanco(){
		
		for(int i =0; i<alto; i++){
			for(int j = 0; j< ancho; j++){
				
				fondo[i][j]= new Pixel(255, 255, 255);

			}			
		}//****
		
	}
	
	public void pintarPixel(int x, int y, Pixel color){
		
		for(int i = 0; i< getAncho_pincel(); i++){
		for(int j = 0; j < getAncho_pincel(); j++){
			fondo[x+i][y+j] = color;}
		
		}
	}
	
	public void pintarPixelPincelado(int x, int y, Pixel color){
		
		Random mi_otro_random = new Random();
		Pixel mi_pixel_rojo = new Pixel(250, 1, 0);
		Pixel mi_pixel_verde = new Pixel(0, 200, 196);
		
		for(int i = 0; i< getAncho_pincel(); i+=2){
		for(int j = 0; j < getAncho_pincel(); j++){
			
			int aleatorio = mi_otro_random.nextInt(3);
			
			if(aleatorio== 0){
				
			fondo[x+i][y+j] = color;}
			
			else if(aleatorio==1){
				
				fondo[x+i][y+j] = mi_pixel_rojo;
				
			}else{
				
				fondo[x+i][y+j] = mi_pixel_verde;
				
				}
			
			}
			
		}
	}
	
	public void pintarPixelAleatorio(int x, int y, Pixel color) {//probando!!!

		Random genera_aleatorios = new Random();
		
		for (int i = 0; i < getAncho_pincel(); i++) {
			for (int j = 0; j < getAncho_pincel(); j++) {
				int aleatorio1 = genera_aleatorios.nextInt(3);
				int aleatorio2 =genera_aleatorios.nextInt(3);
				
				fondo[x + i+ aleatorio1][y + j+aleatorio2] = color;
				if(j%3==0){
					
					fondo[x + i+ aleatorio1][y + j+aleatorio2] = new Pixel(255, 255, 0);
				}
			}

		}
	}//***
	
	public void pintarPixelBiselado(int x, int y, Pixel color) {//*********

		
		
		for (int i = 0; i < getAncho_pincel(); i++) {
		
				fondo[x + i][y + i + 1] = color;
				
		}
	}//*****************************************************
	
	public void borrar(int x, int y, Pixel[][] mat_fondo) {//// :-D A ver!!!!

		for (int i = 0; i < getAncho_pincel(); i++) {
			for (int j = 0; j < getAncho_pincel(); j++) {
				fondo[x + i][y + j] = mat_fondo[x + i][y + j];
			}

		}
	}//****************************************************
	
	

}