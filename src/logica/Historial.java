package logica;


import java.util.LinkedList;


public class Historial {
	
	private String nombre;
	private LinkedList<Comando> comandos_guardados;
	
	
	public Historial(String nombre){
		
		this.nombre = nombre;
		comandos_guardados = new LinkedList<>(); 
		
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public LinkedList<Comando> getComandos_guardados() {
		return comandos_guardados;
	}


	public void setComandos_guardados(LinkedList<Comando> comandos_guardados) {
		this.comandos_guardados = comandos_guardados;
	}
	
	public void resetearHistorial(){
		
		this.comandos_guardados = new LinkedList<>();
		
	}

}
