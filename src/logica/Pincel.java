package logica;


public class Pincel {
	
	private int ancho;
	private Pixel color;
	
	public Pincel(){
		
		ancho = 1;
		color = new Pixel(0, 0, 0);//negro
		
	}
	
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		if(!validar(ancho)){
			
			throw new RuntimeException("valores entre 1 y 255");
			
		}
		
		this.ancho = ancho;
	}
	public Pixel getColor() {
		return color;
	}
	public void setColor(Pixel color) {
		this.color = color;
	}
	
	public String colorToString() {

		int r = getColor().getR();
		int g = getColor().getG();
		int b = getColor().getB();

		return "R: " + r + " G: " + g + " B: " + b;

	}
	
	private boolean validar(int v) {
		if ((v >= 1) && (v < 256))
			return true;
		return false;
	}
		
	
	
}
