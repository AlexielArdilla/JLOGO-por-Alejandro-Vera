package principal;

import presentacion.UI;
import presentacion.ImagenArranque;
import logica.Tortuga;

public class MiLogo {

	public static void main(String[] args) throws InterruptedException {
		
		
		Tortuga una_tortuga = new Tortuga();
		UI mi_interfaz = new UI(una_tortuga);
		
		new ImagenArranque();
		mi_interfaz.abrirGUI();
		boolean andando = true;
	
		while(andando){
			Thread.sleep(1_000);
			mi_interfaz.actualizarLabelImagen(una_tortuga.getDibujo().getFondo());
			mi_interfaz.actualizarPosLabelTortuga();
			
		}
		
	}

}
