package logica;


import java.util.LinkedList;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class ValidadorDeComandos{
	
	
	private String comando;
	private String ingreso_de_comandos;
	private int ID_COMANDO = -1;
	
	private String ruta;
	private int parametro1;
	private int parametro2;
	private int parametro3;
	private int tipo_parametro = 0; //cantidad de parametros numéricos
	
	public static final int ID_UBICAR= 0;
	public static final int ID_AVANZAR = 1;
	public static final int ID_GIRAR = 2;
	public static final int ID_PINCEL = 3;
	public static final int ID_COLOR = 4;
	public static final int ID_BORRAR = 5;
	public static final int ID_PINTAR = 6;
	public static final int ID_FONDO = 7;
	public static final int ID_AYUDA = 8;
	public static final int ID_NUEVO = 9;
	public static final int ID_DIBUJAR = 10;
	public static final int ID_GUARDAR = 11;
	public static final int ID_ABRIR = 12;
	public static final int ID_INSERTAR = 13;
	public static final int COMANDO_NO_ENCONTRADO = -1;
	
	
    public ValidadorDeComandos(String comando_entrada){
	
		
		this.ingreso_de_comandos = comando_entrada;
		
		procesarIngresoComandos();
		
	}
	
	public String getComando() {
		return comando;
	}
	

	public void setComando(String comando) {
		this.comando = comando;
	}

	
	
	public int getID_COMANDO() {
		return ID_COMANDO;
	}

	public void setID_COMANDO(int iD_COMANDO) {
		ID_COMANDO = iD_COMANDO;
	}
	
	

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public int getParametro1() {
		return parametro1;
	}

	public void setParametro1(int parametro1) {
		this.parametro1 = parametro1;
	}

	public int getParametro2() {
		return parametro2;
	}

	public void setParametro2(int parametro2) {
		this.parametro2 = parametro2;
	}

	public int getParametro3() {
		return parametro3;
	}

	public void setParametro3(int parametro3) {
		this.parametro3 = parametro3;
	}

	public int getTipo_parametro() {
		return tipo_parametro;
	}

	public void setTipo_parametro(int tipo_parametro) {
		this.tipo_parametro = tipo_parametro;
	}

	public LinkedList<String> separaEnTokens(String comando){//************Bien!!
		
		comando = comando.toLowerCase();
		
		LinkedList<String> resultado = new LinkedList<>();
		
		StringTokenizer miSt = new StringTokenizer(comando, " ,[];<>()");
		
		while(miSt.hasMoreTokens()){
			
			resultado.addLast(miSt.nextToken());
			
		}
	
		return resultado;
	}
	
	public LinkedList<String> devuelveComandoYRuta(LinkedList<String> lista){//*******************************
		
		LinkedList<String> comandoYRuta = new LinkedList<>();
			
		if(lista.get(0).toLowerCase().startsWith("ubicar")){
			
			comandoYRuta.add("ubicar");
			
			setID_COMANDO(ID_UBICAR);

		}
		else if (lista.get(0).toLowerCase().startsWith("avanzar")) {

			comandoYRuta.add("avanzar");
			setID_COMANDO(ID_AVANZAR);

		}
		else if (lista.get(0).toLowerCase().startsWith("girar")) {

			comandoYRuta.add("girar");
			setID_COMANDO(ID_GIRAR);

		}
		else if (lista.get(0).toLowerCase().startsWith("pincel")) {

			comandoYRuta.add("pincel");
			setID_COMANDO(ID_PINCEL);

		}
		else if (lista.get(0).toLowerCase().startsWith("color")) {

			comandoYRuta.add("color");
			setID_COMANDO(ID_COLOR);

		}
		else if (lista.get(0).toLowerCase().startsWith("borrar")) {

			comandoYRuta.add("borrar");
			setID_COMANDO(ID_BORRAR);

		}
		else if (lista.get(0).toLowerCase().startsWith("pintar")) {

			comandoYRuta.add("pintar");
			setID_COMANDO(ID_PINTAR);

		}
		else if (lista.get(0).toLowerCase().startsWith("fondo")) {

			comandoYRuta.add("fondo");
			setID_COMANDO(ID_FONDO);

		}
		else if (lista.get(0).toLowerCase().startsWith("ayuda")) {

			comandoYRuta.add("ayuda");
			setID_COMANDO(ID_AYUDA);

		}
		else if (lista.get(0).toLowerCase().startsWith("nuevo")) {

			comandoYRuta.add("nuevo");
			setID_COMANDO(ID_NUEVO);

		}
		else if (lista.get(0).toLowerCase().startsWith("dibujar")) {

			comandoYRuta.add("dibujar");
			setID_COMANDO(ID_DIBUJAR);

		}
		else if (lista.get(0).toLowerCase().startsWith("guardar")) {

			comandoYRuta.add("guardar");
			setID_COMANDO(ID_GUARDAR);

		}
		else if (lista.get(0).toLowerCase().startsWith("abrir")) {

			comandoYRuta.add("abrir");
			setID_COMANDO(ID_ABRIR);

		}
		else if (lista.get(0).toLowerCase().startsWith("insertar")) {

			comandoYRuta.add("insertar");
			setID_COMANDO(ID_INSERTAR);

		}else{
			
			comandoYRuta.add("nada");
			setID_COMANDO(COMANDO_NO_ENCONTRADO);
		}
		
		//*******guardar la ruta
		try {
			
			@SuppressWarnings("unused")
			int probar_si_es_num = Integer.parseInt(lista.get(1));
		
		} catch (NumberFormatException e) {
			
			if(lista.get(1)!= null)
			comandoYRuta.add(lista.get(1));
			
		}catch (IndexOutOfBoundsException e) {
			
			
		}
		
			return comandoYRuta;
		
	}//****************************************************************************************
	
	public LinkedList<Integer> devuelveValores(LinkedList<String> lista){//*****************************
		
		LinkedList<Integer> valores_enteros = new LinkedList<>();
		for(String  s: lista){
			
			try {
				
				int entero = Integer.parseInt(s);
				
				valores_enteros.addLast(entero);
			
			} catch (NumberFormatException e) {
				
				System.out.println("No es un entero valido");
			}
			
		}//***
		
		return valores_enteros;
	}//****************************************************************************************************

	public void generaComandoYRuta(){//******probando
		
		LinkedList<String>mis_strings = separaEnTokens(this.ingreso_de_comandos);
		LinkedList<String>mi_comando_y_ruta = new LinkedList<>();
		mi_comando_y_ruta = devuelveComandoYRuta(mis_strings);
		
		if (mi_comando_y_ruta.size() == 1) {

			this.comando = mi_comando_y_ruta.get(0);

		} else if (mi_comando_y_ruta.size() == 2) {

			this.comando = mi_comando_y_ruta.get(0);
			this.ruta = mi_comando_y_ruta.get(1);

		} else {

			JOptionPane.showInternalMessageDialog(null, "No ingresó un comando válido... Ingrese: <ayuda>");

		}
		
		
		
	}//***********probarlo

	public void generaParametros() {//****probando!
		
		LinkedList<String>mis_strings = separaEnTokens(this.ingreso_de_comandos);
		LinkedList<Integer>mis_parametros = new LinkedList<>();
		mis_parametros =devuelveValores(mis_strings);

		if (mis_parametros.size() == 1) {

			parametro1 = mis_parametros.get(0);
			tipo_parametro = 1;

		} else if (mis_parametros.size() == 2) {

			parametro1 = mis_parametros.get(0);
			parametro2 = mis_parametros.get(1);
			tipo_parametro = 2;

		} else if (mis_parametros.size() == 3) {

			parametro1 = mis_parametros.get(0);
			parametro2 = mis_parametros.get(1);
			parametro3 = mis_parametros.get(2);
			tipo_parametro = 3;

		} else {

			tipo_parametro = 0;

		}
		
	}//****probando
	
	public void procesarIngresoComandos(){//***probando
		
		generaComandoYRuta();
		generaParametros();
		
	}//***********probando
	
	public static void main(String[] args){
		
		
		ValidadorDeComandos mi_validador = new ValidadorDeComandos("avanzar 17");
		
		System.out.println("Comando: "+mi_validador.getComando()+" \nID_COMANDO: "+mi_validador.getID_COMANDO()+
				" \nRuta: "+mi_validador.getRuta()+" \nParam1: "+mi_validador.getParametro1()+
				"\nParam2: "+mi_validador.getParametro2()+"\nParam3: "+mi_validador.getParametro3()+
				"\nTipo de parámetro: "+mi_validador.getTipo_parametro());
		
		
		
	}
	
}

