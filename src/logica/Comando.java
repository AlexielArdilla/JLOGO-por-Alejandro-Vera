package logica;

public class Comando {

	private int ID_COMANDO;
	private String ruta;
	private int parametro1;
	private int parametro2;
	private int parametro3;
	private int tipo_de_parametro;
	private String comando_para_historial;//esto se muestra en el historial
	
	public Comando(String comando_para_historial){
		
		this.comando_para_historial = comando_para_historial;
	}
	
	public Comando(int iD_COMANDO, String ruta, int parametro1, int parametro2, int parametro3, int tipo_de_parametro) {
		super();
		ID_COMANDO = iD_COMANDO;
		this.ruta = ruta;
		this.parametro1 = parametro1;
		this.parametro2 = parametro2;
		this.parametro3 = parametro3;
		this.tipo_de_parametro = tipo_de_parametro;
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

	public int getTipo_de_parametro() {
		return tipo_de_parametro;
	}

	public void setTipo_de_parametro(int tipo_de_parametro) {
		this.tipo_de_parametro = tipo_de_parametro;
	}

	public String getComando_para_historial() {
		return comando_para_historial;
	}

	public void setComando_para_historial(String comando_para_historial) {
		this.comando_para_historial = comando_para_historial;
	}
	
	
	
	
}
