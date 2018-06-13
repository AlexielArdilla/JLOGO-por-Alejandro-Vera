package logica;


import java.util.Stack;

//import presentacion.*;

public class Tortuga {
	
	private Punto posicion;
	double angulo;
	int angulo_mostrar = 0;
	Imagen dibujo;
	Imagen dibujo_puro;//sirve para cambiar el fondo cuando hay un dibujo!!!
	Imagen fondo = new Imagen();
	Historial mi_historial;//aca se guardan los comandos!!!
	LecturaEscrituraBMP mi_gestorBMP;
	Pincel mi_pincel;
	private double angulo_ant = 0;
	

	public Tortuga(){
		this.dibujo_puro = new Imagen();
		this.angulo = 0;
		this.posicion = new Punto(250, 250);
		this.dibujo = new Imagen();
		mi_historial = new Historial("De la tortuga");
		mi_gestorBMP = new LecturaEscrituraBMP();
		mi_pincel = new Pincel();
		
	}

	
	public double getAngulo_ant() {
		return angulo_ant;
	}



	public void setAngulo_ant(double angulo_ant) {
		this.angulo_ant = angulo_ant;
	}
	
	
	public void setAngulo_mostrar(int angulo_mostrar) {
		
		this.angulo_mostrar = angulo_mostrar;
	}

	public int getAngulo_mostrar() {
		return angulo_mostrar;
	}

	public Imagen getDibujo_puro() {
		return dibujo_puro;
	}


	public void setDibujo_puro(Imagen dibujo_puro) {
		this.dibujo_puro = dibujo_puro;
	}


	public Punto getPosicion() {//*************************
		return posicion;
	}

	public void setPosicion(Punto posicion) {//**********************
		this.posicion = posicion;
	}

	public double getAngulo() {//******************************
		return angulo;
	}

	public void setAngulo(double direccion) {//*****maso
		
		
		if (direccion + angulo >= (360 * Math.PI / 180)) {
			this.angulo = direccion + angulo - (360 * Math.PI / 180);
		} else {
			this.angulo = angulo + direccion;
		}
		if (direccion == (360 * Math.PI / 180)) {
			this.angulo = 0; 
		}
		if (direccion == 0) {
			this.angulo = 0;
		}
	}

	public Imagen getDibujo() {//**************************
		return dibujo;
	}

	public void setDibujo(Imagen dibujo) {//*********************
		this.dibujo = dibujo;
	}

	public Imagen getFondo() {//*******************************
		return fondo;
	}

	public void setFondo(Imagen fondo) {//**********************
		this.fondo = fondo;
	}

	

	public Historial getMi_historial() {
		return mi_historial;
	}


	public void setMi_historial(Historial mi_historial) {
		this.mi_historial = mi_historial;
	}


	public LecturaEscrituraBMP getMi_gestorBMP() {//**************************
		return mi_gestorBMP;
	}

	public void setMi_gestorBMP(LecturaEscrituraBMP mi_gestorBMP) {//************************
		this.mi_gestorBMP = mi_gestorBMP;
	}

	public Pincel getMi_pincel() {//*************************
		return mi_pincel;
	}

	public void setMi_pincel(Pincel mi_pincel) {//***************************
		this.mi_pincel = mi_pincel;
	}

	public void avanzar(int q){//*******bien!!!*****************************
		
		double x2 = getPosicion().getX() + q * Math.cos(getAngulo());
		double y2 = getPosicion().getY() + q * Math.sin(getAngulo());
		if (x2 > 512) {
			x2 = 511;
		}
		if (y2 > 512) {
			y2 = 511;
		}
		if (x2 < 0) {
			x2 = 0;
		}
		if (y2 < 0) {
			y2 = 0;
		}
		
		
		 dibujarLinea(getPosicion().getX(), getPosicion().getY(),(int) x2, (int)y2);
		
		
	}//*********************************************************
	
	
	public void avanzarPincelado(int q){//*******bien!!!*****************************
		
		double x2 = getPosicion().getX() + q * Math.cos(getAngulo());
		double y2 = getPosicion().getY() + q * Math.sin(getAngulo());
		if (x2 > 512) {
			x2 = 511;
		}
		if (y2 > 512) {
			y2 = 511;
		}
		if (x2 < 0) {
			x2 = 0;
		}
		if (y2 < 0) {
			y2 = 0;
		}
		
		
		 dibujarLineaPincelada(getPosicion().getX(), getPosicion().getY(),(int) x2, (int)y2);
		
		
	}//*********************************************************
	
	public void avanzarBiselado(int q){//******PROBANDOOO*************
		
		double x2 = getPosicion().getX() + q * Math.cos(getAngulo());
		double y2 = getPosicion().getY() + q * Math.sin(getAngulo());
		if (x2 > 512) {
			x2 = 511;
		}
		if (y2 > 512) {
			y2 = 511;
		}
		if (x2 < 0) {
			x2 = 0;
		}
		if (y2 < 0) {
			y2 = 0;
		}
		
		
		 dibujarLineaBiselado(getPosicion().getX(), getPosicion().getY(),(int) x2, (int)y2);
		
		
	}//****************
	
	public void avanzarAleatorio(int q){//******PROBANDO********************
		
		double x2 = getPosicion().getX() + q * Math.cos(getAngulo());
		double y2 = getPosicion().getY() + q * Math.sin(getAngulo());
		if (x2 > 512) {
			x2 = 511;
		}
		if (y2 > 512) {
			y2 = 511;
		}
		if (x2 < 0) {
			x2 = 0;
		}
		if (y2 < 0) {
			y2 = 0;
		}
		
		
		 dibujarLineaAleatoria(getPosicion().getX(), getPosicion().getY(),(int) x2, (int)y2);
		
		
	}//***********
	
	
	public void girar(double angulo1) {//***************bien!!!******************
	   
		this.angulo_mostrar += (int)angulo1;
		
		if(angulo_mostrar>360){
			
			angulo_mostrar = angulo_mostrar-360;
			
		}else if(angulo_mostrar<0){
			
			angulo_mostrar = angulo_mostrar + 360;
			
		}
				
		angulo =angulo_ant+ angulo1 * Math.PI / 360;
		angulo_ant = angulo;
		setAngulo(angulo);
	}
	
	public void ubicar(Punto pos){//********************************************
		
		setPosicion(pos);
	}//***************

public void borrar(int q){//*************************************************************
		
		double x2 = getPosicion().getX() + q * Math.cos(getAngulo());
		double y2 = getPosicion().getY() + q * Math.sin(getAngulo());
		if (x2 > 512) {
			x2 = 511;
		}
		if (y2 > 512) {
			y2 = 511;
		}
		if (x2 < 0) {
			x2 = 0;
		}
		if (y2 < 0) {
			y2 = 0;
		}
		
		
		 borrarLinea(getPosicion().getX(), getPosicion().getY(),(int) x2, (int)y2);
		
		
	}//*******************************


	public void pintar(int x, int y, Pixel color) {//********************

		Stack<Punto> s = new Stack<Punto>();
		
		Pixel colorViejo = dibujo_puro.getFondo()[x][y];
		Punto p = new Punto(x, y);// es posicion

		s.push(p);

		while (!s.isEmpty()) {
			Punto a = s.pop();// a es referencia

			if (this.dibujo_puro.getFondo()[(int) a.getX()][(int) a.getY()].equals(colorViejo)) {
				
				dibujo_puro.getFondo()[(int) a.getX()][(int) a.getY()] = color;
				dibujo.getFondo()[(int) a.getX()][(int) a.getY()] = color;// **********

				if ((int) a.getY() < 511) {
					if (this.dibujo_puro.getFondo()[(int) a.getX()][(int) a.getY() + 1].equals(colorViejo)
							&& this.dibujo_puro.getFondo()[(int) a.getX()][(int) a.getY() + 1] != null) {

						p = new Punto((int) a.getX(), (int) a.getY() + 1);
						s.push(p);

					}
				}

				if ((int) a.getY() >= 1) {
					if (this.dibujo_puro.getFondo()[(int) a.getX()][(int) a.getY() - 1].equals(colorViejo)
							&& this.dibujo_puro.getFondo()[(int) a.getX()][(int) a.getY() - 1] != null) {
						p = new Punto((int) a.getX(), (int) a.getY() - 1);
						s.push(p);

					}
				}

				if ((int) a.getX() < 511) {
					if (this.dibujo_puro.getFondo()[(int) a.getX() + 1][(int) a.getY()].equals(colorViejo)
							&& this.dibujo_puro.getFondo()[(int) a.getX() + 1][(int) a.getY()] != null) {
						p = new Punto((int) a.getX() + 1, (int) a.getY());
						s.push(p);

					}
				}
				if ((int) a.getX() >= 1) {
					if (this.dibujo_puro.getFondo()[(int) a.getX() - 1][(int) a.getY()].equals(colorViejo)
							&& this.dibujo_puro.getFondo()[(int) a.getX() - 1][(int) a.getY()] != null) {
						p = new Punto((int) a.getX() - 1, (int) a.getY());
						s.push(p);

					}
				}
			}

		}

	}// ************
	
	
	public void cargarUnfondoAlDibujo(){//***********andaa!!!
		
		mezclarUnFondoYDibujo();
		
	}//***
	
	public void mezclarUnFondoYDibujo() {// anda

		for (int i = 0; i < 512; i++) {
			for (int j = 0; j < 512; j++) {

				if (this.dibujo_puro.getFondo()[i][j].equals(new Pixel(255, 255, 255))) {

					this.dibujo.getFondo()[i][j] = fondo.getFondo()[i][j];

				}

			}

		}

	}// ***********************
	
	
	public void pincel(int ancho){//**********************************************
		
		mi_pincel.setAncho(ancho);
		
	}//*********************

	public void color(int r, int g, int b){//***************************************
		
		mi_pincel.setColor(new Pixel(r, g, b));
		
	}//****************************************
	
	public Pixel[][] fondo(String ruta){//***
		
		return mi_gestorBMP.loadImage(ruta);
		
	}//***********
	
	public void ayuda(){//********************************************
		
		//está en la UI!!!***********************************
		
	}
	
	public void nuevoDibujo(){//********************************************
		
		
		dibujo = new Imagen(); 
		dibujo_puro = new Imagen();
		
	}//*******************************************
	
	public void nuevoImagenBMP(String ruta){//***********************************************
		
		getMi_gestorBMP().cargarPixelesParaEscribir(getDibujo().getFondo());
		getMi_gestorBMP().saveResult(ruta);
		
	}
	
	public void dibujar() {//********
		
		this.dibujo = this.dibujo_puro;
		fondo = new Imagen();
		
	}

	public void guardar(String ruta) {//***********************************
		
		mi_gestorBMP.saveResult(ruta);
		
	}//******************************************************************

	public void abrir(String ruta) {
		
		
	}

	public void insertar(String ruta) {
		
		
		
	}

	public void acomodarFondo() {
		
		
		
	}//*******

	public void dibujarLinea(int x0, int y0, int x1, int y1) { //*********ANDA!!!
		
		int r = mi_pincel.getColor().getR();
		int g = mi_pincel.getColor().getG();
		int b = mi_pincel.getColor().getB();
		
		int x, y, dx, dy, p, incE, incNE, stepx, stepy;
		  dx = (x1 - x0);
		  dy = (y1 - y0);

		 /* determinar que punto usar para empezar, cual para terminar */
		  if (dy < 0) { 
		    dy = -dy; 
		    stepy = -1; 
		  } 
		  else {
		    stepy = 1;
		  }

		  if (dx < 0) {  
		    dx = -dx;  
		    stepx = -1; 
		  } 
		  else {
		    stepx = 1;
		  }

		  x = x0;
		  y = y0;
		 
		  dibujo_puro.setAncho_pincel(this.getMi_pincel().getAncho());//***Siempre con fondo blanco******************
		  dibujo_puro.pintarPixel(512-y, x, new Pixel(r, g, b));
		  
		  dibujo.setAncho_pincel(this.getMi_pincel().getAncho());//**********************************
		  dibujo.pintarPixel(512-y, x, new Pixel(r, g, b));
		  
		 /* se cicla hasta llegar al extremo de la línea */
		  if(dx>dy){
		    p = 2*dy - dx;
		    incE = 2*dy;
		    incNE = 2*(dy-dx);
		    while (x != x1){
		      x = x + stepx;
		      if (p < 0){
		        p = p + incE;
		      }
		      else {
		        y = y + stepy;
		        p = p + incNE;
		      }
		      
		      dibujo_puro.setAncho_pincel(this.getMi_pincel().getAncho());//***solo dibujo
		      dibujo_puro.pintarPixel(512-y, x, new Pixel(r, g, b));
		      
		      dibujo.setAncho_pincel(this.getMi_pincel().getAncho());
		      dibujo.pintarPixel(512-y, x, new Pixel(r, g, b));
		    }
		  }
		  else{
		    p = 2*dx - dy;
		    incE = 2*dx;
		    incNE = 2*(dx-dy);
		    while (y != y1){
		      y = y + stepy;
		      if (p < 0){
		        p = p + incE;
		      }
		      else {
		        x = x + stepx;
		        p = p + incNE;
		      }
		      
		      dibujo_puro.setAncho_pincel(this.getMi_pincel().getAncho());
		      dibujo_puro.pintarPixel(512-y, x, new Pixel(r, g, b));
		      
		      dibujo.setAncho_pincel(this.getMi_pincel().getAncho());
		      dibujo.pintarPixel(512-y, x, new Pixel(r, g, b));
		    
		    }
		  }
		  
		  ubicar(new Punto(x1, y1));
		  
		  
		 }//****************************************************************
	
	public void dibujarLineaPincelada(int x0, int y0, int x1, int y1) { //*********ANDA!!!
		
		int r = mi_pincel.getColor().getR();
		int g = mi_pincel.getColor().getG();
		int b = mi_pincel.getColor().getB();
		
		int x, y, dx, dy, p, incE, incNE, stepx, stepy;
		  dx = (x1 - x0);
		  dy = (y1 - y0);

		 /* determinar que punto usar para empezar, cual para terminar */
		  if (dy < 0) { 
		    dy = -dy; 
		    stepy = -1; 
		  } 
		  else {
		    stepy = 1;
		  }

		  if (dx < 0) {  
		    dx = -dx;  
		    stepx = -1; 
		  } 
		  else {
		    stepx = 1;
		  }

		  x = x0;
		  y = y0;
		 
		  dibujo_puro.setAncho_pincel(this.getMi_pincel().getAncho());//***Siempre con fondo blanco******************
		  dibujo_puro.pintarPixelPincelado(512-y, x, new Pixel(r, g, b));
		  
		  dibujo.setAncho_pincel(this.getMi_pincel().getAncho());//**********************************
		  dibujo.pintarPixelPincelado(512-y, x, new Pixel(r, g, b));
		  
		 /* se cicla hasta llegar al extremo de la línea */
		  if(dx>dy){
		    p = 2*dy - dx;
		    incE = 2*dy;
		    incNE = 2*(dy-dx);
		    while (x != x1){
		      x = x + stepx;
		      if (p < 0){
		        p = p + incE;
		      }
		      else {
		        y = y + stepy; 
		        p = p + incNE; 
		      }
		      
		      dibujo_puro.setAncho_pincel(this.getMi_pincel().getAncho());//***solo dibujo
		      dibujo_puro.pintarPixelPincelado(512-y, x, new Pixel(r, g, b));
		      
		      dibujo.setAncho_pincel(this.getMi_pincel().getAncho());
		      dibujo.pintarPixelPincelado(512-y, x, new Pixel(r, g, b));
		    }
		  }
		  else{
		    p = 2*dx - dy;
		    incE = 2*dx;
		    incNE = 2*(dx-dy);
		    while (y != y1){
		      y = y + stepy;
		      if (p < 0){
		        p = p + incE;
		      }
		      else {
		        x = x + stepx; 
		        p = p + incNE;
		      }
		      
		      dibujo_puro.setAncho_pincel(this.getMi_pincel().getAncho());
		      dibujo_puro.pintarPixelPincelado(512-y, x, new Pixel(r, g, b));
		      
		      dibujo.setAncho_pincel(this.getMi_pincel().getAncho());
		      dibujo.pintarPixelPincelado(512-y, x, new Pixel(r, g, b));
		    
		    }
		  }
		  
		  ubicar(new Punto(x1, y1));
		  
		  
		 }//****************************************************************
	
	
	
	public void dibujarLineaBiselado(int x0, int y0, int x1, int y1) { //*********maso
		
		int r = mi_pincel.getColor().getR();
		int g = mi_pincel.getColor().getG();
		int b = mi_pincel.getColor().getB();
		
		int x, y, dx, dy, p, incE, incNE, stepx, stepy;
		  dx = (x1 - x0);
		  dy = (y1 - y0);

		 /* determinar que punto usar para empezar, cual para terminar */
		  if (dy < 0) { 
		    dy = -dy; 
		    stepy = -1; 
		  } 
		  else {
		    stepy = 1;
		  }

		  if (dx < 0) {  
		    dx = -dx;  
		    stepx = -1; 
		  } 
		  else {
		    stepx = 1;
		  }

		  x = x0;
		  y = y0;
		 
		  dibujo_puro.setAncho_pincel(this.getMi_pincel().getAncho());//***Siempre con fondo blanco******************
		  dibujo_puro.pintarPixelBiselado(512-y, x, new Pixel(r, g, b));
		  
		  dibujo.setAncho_pincel(this.getMi_pincel().getAncho());//**********************************
		  dibujo.pintarPixelBiselado(512-y, x, new Pixel(r, g, b));
		  
		 /* se cicla hasta llegar al extremo de la línea */
		  if(dx>dy){
		    p = 2*dy - dx;
		    incE = 2*dy;
		    incNE = 2*(dy-dx);
		    while (x != x1){
		      x = x + stepx;
		      if (p < 0){
		        p = p + incE;
		      }
		      else {
		        y = y + stepy;
		        p = p + incNE;
		      }
		      
		      dibujo_puro.setAncho_pincel(this.getMi_pincel().getAncho());//***solo dibujo
		      dibujo_puro.pintarPixelBiselado(512-y, x, new Pixel(r, g, b));
		      
		      dibujo.setAncho_pincel(this.getMi_pincel().getAncho());
		      dibujo.pintarPixelBiselado(512-y, x, new Pixel(r, g, b));
		    }
		  }
		  else{
		    p = 2*dx - dy;
		    incE = 2*dx;
		    incNE = 2*(dx-dy);
		    while (y != y1){
		      y = y + stepy;
		      if (p < 0){
		        p = p + incE;
		      }
		      else {
		        x = x + stepx;
		        p = p + incNE;
		      }
		      
		      dibujo_puro.setAncho_pincel(this.getMi_pincel().getAncho());
		      dibujo_puro.pintarPixelBiselado(512-y, x, new Pixel(r, g, b));
		      
		      dibujo.setAncho_pincel(this.getMi_pincel().getAncho());
		      dibujo.pintarPixelBiselado(512-y, x, new Pixel(r, g, b));
		    
		    }
		  }
		  
		  ubicar(new Punto(x1, y1));
		  
		  
		 }//****************************************************
	
	public void dibujarLineaAleatoria(int x0, int y0, int x1, int y1) { //******PROBANDOOO!!!
		
		int r = mi_pincel.getColor().getR();
		int g = mi_pincel.getColor().getG();
		int b = mi_pincel.getColor().getB();
		
		int x, y, dx, dy, p, incE, incNE, stepx, stepy;
		  dx = (x1 - x0);
		  dy = (y1 - y0);

		 /* determinar que punto usar para empezar, cual para terminar */
		  if (dy < 0) { 
		    dy = -dy; 
		    stepy = -1; 
		  } 
		  else {
		    stepy = 1;
		  }

		  if (dx < 0) {  
		    dx = -dx;  
		    stepx = -1; 
		  } 
		  else {
		    stepx = 1;
		  }

		  x = x0;
		  y = y0;
		 
		  dibujo_puro.setAncho_pincel(this.getMi_pincel().getAncho());//***Siempre con fondo blanco******************
		  dibujo_puro.pintarPixelAleatorio(512-y, x, new Pixel(r, g, b));
		  
		  dibujo.setAncho_pincel(this.getMi_pincel().getAncho());//**********************************
		  dibujo.pintarPixelAleatorio(512-y, x, new Pixel(r, g, b));
		  
		 /* se cicla hasta llegar al extremo de la línea */
		  if(dx>dy){
		    p = 2*dy - dx;
		    incE = 2*dy;
		    incNE = 2*(dy-dx);
		    while (x != x1){
		      x = x + stepx;
		      if (p < 0){
		        p = p + incE;
		      }
		      else {
		        y = y + stepy;
		        p = p + incNE;
		      }
		      
		      dibujo_puro.setAncho_pincel(this.getMi_pincel().getAncho());//***solo dibujo
		      dibujo_puro.pintarPixelAleatorio(512-y, x, new Pixel(r, g, b));
		      
		      dibujo.setAncho_pincel(this.getMi_pincel().getAncho());
		      dibujo.pintarPixelAleatorio(512-y, x, new Pixel(r, g, b));
		    }
		  }
		  else{
		    p = 2*dx - dy;
		    incE = 2*dx;
		    incNE = 2*(dx-dy);
		    while (y != y1){
		      y = y + stepy;
		      if (p < 0){
		        p = p + incE;
		      }
		      else {
		        x = x + stepx;
		        p = p + incNE;
		      }
		      
		      dibujo_puro.setAncho_pincel(this.getMi_pincel().getAncho());
		      dibujo_puro.pintarPixelAleatorio(512-y, x, new Pixel(r, g, b));
		      
		      dibujo.setAncho_pincel(this.getMi_pincel().getAncho());
		      dibujo.pintarPixelAleatorio(512-y, x, new Pixel(r, g, b));
		    
		    }
		  }
		  
		  ubicar(new Punto(x1, y1));
		  
		  
		 }//*************
	
	public void borrarLinea(int x0, int y0, int x1, int y1) { // *********A ver!!!

		/*int r = mi_pincel.getColor().getR();
		int g = mi_pincel.getColor().getG();
		int b = mi_pincel.getColor().getB();*/

		int x, y, dx, dy, p, incE, incNE, stepx, stepy;
		dx = (x1 - x0);
		dy = (y1 - y0);

		/* determinar que punto usar para empezar, cual para terminar */
		if (dy < 0) {
			dy = -dy;
			stepy = -1;
		} else {
			stepy = 1;
		}

		if (dx < 0) {
			dx = -dx;
			stepx = -1;
		} else {
			stepx = 1;
		}

		x = x0;
		y = y0;

		
		dibujo_puro.setAncho_pincel(this.getMi_pincel().getAncho());
		dibujo_puro.pintarPixel(512 - y, x, new Pixel(255, 255, 255));
		
		dibujo.setAncho_pincel(this.getMi_pincel().getAncho());
		dibujo.borrar(512-y, x, fondo.getFondo());

		/* se cicla hasta llegar al extremo de la línea */
		if (dx > dy) {
			p = 2 * dy - dx;
			incE = 2 * dy;
			incNE = 2 * (dy - dx);
			while (x != x1) {
				x = x + stepx;
				if (p < 0) {
					p = p + incE;
				} else {
					y = y + stepy;
					p = p + incNE;
				}

				dibujo_puro.setAncho_pincel(this.getMi_pincel().getAncho());// ***solo
																			// dibujo
				dibujo_puro.pintarPixel(512 - y, x, new Pixel(255, 255, 255));

				dibujo.setAncho_pincel(this.getMi_pincel().getAncho());
				dibujo.borrar(512-y, x, fondo.getFondo());
			}
		} else {
			p = 2 * dx - dy;
			incE = 2 * dx;
			incNE = 2 * (dx - dy);
			while (y != y1) {
				y = y + stepy;
				if (p < 0) {
					p = p + incE;
				} else {
					x = x + stepx;
					p = p + incNE;
				}

				dibujo_puro.setAncho_pincel(this.getMi_pincel().getAncho());
				dibujo_puro.pintarPixel(512 - y, x, new Pixel(255, 255, 255));

				dibujo.setAncho_pincel(this.getMi_pincel().getAncho());
				dibujo.borrar(512-y, x, fondo.getFondo());
			}
		}

		ubicar(new Punto(x1, y1));

	}

	public int getCoordenadaXTortuga(){//********************
		
		
	return getPosicion().getX();	
	}
	
	public int getCoordenadaYTortuga(){//*************************
		
		
		return 512 - getPosicion().getY();
	}
}
