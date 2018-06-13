package presentacion;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileNameExtensionFilter;

import logica.Comando;
import logica.Imagen;
import logica.Punto;
import logica.Tortuga;
import logica.ValidadorDeComandos;
import logica.Pixel;


public class UI extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int ANCHO_VENTANA = 1_000;
	private static final int ALTO_VENTANA = 650;

	private JPanel panelNorth;
	private JPanel panelCenter;
	private JPanel panelImage;
	private JPanel panelWest;
	private JPanel panelSouth;
	private Tortuga tortuga;
	ValidadorDeComandos mi_validador;
	
	private JMenu herramientasExtra;
	private JMenu menuVer;
	private JMenuItem pincelBiselado;
	private JMenuItem trazoAleatorio;
	private JMenuItem trazoPincelado;
	private JCheckBoxMenuItem tildeVerHistorial;
	private JCheckBoxMenuItem tildeVerBarraHerramientas;

	JToolBar barraDeHerramientas;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JButton button8;
	private JButton button9;
	private JButton button10;
	private JButton button11;
	private JButton button12;
	private JButton button13;
	private JButton button14;
	private JButton button15;
	private JButton enviar;
	
	private JTextArea areaHistory;
	private JTextField commands;
	private JLabel labelImage;
	private LabelTortuga labelTortuga;
	

	public UI(Tortuga tortuga) {
		this.tortuga = tortuga;
		setearElFrame();
		crearComponentes();
		addListenersButtons();
		
		
	}

	private void setearElFrame() {
		setSize(ANCHO_VENTANA, ALTO_VENTANA);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void crearComponentes() {
		crearMenuBar();
		crearPanelNorth();
		crearPanelCenter();
		crearPanelSouth();
		crearPanelWest();
	}

	private void crearMenuBar() {
		herramientasExtra = new JMenu("Herramientas extra");
		herramientasExtra.add(pincelBiselado = new JMenuItem("Pincel biselado"));
		herramientasExtra.add(trazoAleatorio = new JMenuItem("Trazo aleatorio"));
		herramientasExtra.add(trazoPincelado = new JMenuItem("Trazo Pincelado"));
		
		pincelBiselado.addActionListener((ActionEvent e) ->{//avanzar biselado
			//aqui va el codigo
			
			Sonido.AVANZAR.play();

			String g = JOptionPane.showInputDialog("Ejemplo 100", "Pruebe las diag con pincel grueso!");
			
			try {
			
				int g2= Integer.parseInt(g);
			
			 tortuga.avanzarBiselado(g2);
			 muestraLosComandosEnElHistorial("avanzar biselado "+g2);
			 Comando mi_comando = new Comando(1, null, g2, 0, 0, 1);
			 tortuga.getMi_historial().getComandos_guardados().add(mi_comando);
			
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				Sonido.ERROR.play();
				JOptionPane.showMessageDialog(null, "Ingresó un valor erroneo!!!");
			}
			
		});//*****************************
		
		trazoAleatorio.addActionListener((ActionEvent e) ->{//***avanzar aleatorio
			
			//Aqui va el codigo
			
			Sonido.AVANZAR.play();

			String g = JOptionPane.showInputDialog("Ejemplo 100", "Ingrese los pixeles a avanzar");
			
			try {
			
				int g2= Integer.parseInt(g);
			
			 tortuga.avanzarAleatorio(g2);
			 muestraLosComandosEnElHistorial("avanzar aleatorio "+g2);
			 Comando mi_comando = new Comando(1, null, g2, 0, 0, 1);
			 tortuga.getMi_historial().getComandos_guardados().add(mi_comando);
			
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				Sonido.ERROR.play();
				JOptionPane.showMessageDialog(null, "Ingresó un valor erroneo!!!");
			}
			
		});
		
		trazoPincelado.addActionListener((ActionEvent e) ->{//***avanzar pincelado
			
			//Aqui va el codigo
			
			Sonido.AVANZAR.play();

			String g = JOptionPane.showInputDialog("Ejemplo 100", "Ingrese los pixeles a avanzar");
			
			try {
			
				int g2= Integer.parseInt(g);
			
			 tortuga.avanzarPincelado(g2);
			 muestraLosComandosEnElHistorial("avanzar pincelado "+g2);
			 Comando mi_comando = new Comando(1, null, g2, 0, 0, 1);
			 tortuga.getMi_historial().getComandos_guardados().add(mi_comando);
			
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				Sonido.ERROR.play();
				JOptionPane.showMessageDialog(null, "Ingresó un valor erroneo!!!");
			}
			
		});//***********************************
		
		
		menuVer = new JMenu("Ver");
		menuVer.add(tildeVerHistorial = new JCheckBoxMenuItem("Mostrar Historial", true));
		tildeVerHistorial.addItemListener((ItemEvent e) -> {
			panelWest.setVisible(e.getStateChange() == ItemEvent.SELECTED);
		});
		
		menuVer.add(tildeVerBarraHerramientas = new JCheckBoxMenuItem("Mostrar barra de herramientas", true));
		tildeVerBarraHerramientas.addItemListener((ItemEvent e) -> {
			panelNorth.setVisible(e.getStateChange() == ItemEvent.SELECTED);
		});
		
		JMenuBar menubar = new JMenuBar();
		menubar.add(herramientasExtra);
		menubar.add(menuVer);
		setJMenuBar(menubar);
	}
	
	private void crearPanelNorth() {
		panelNorth = new JPanel();
		barraDeHerramientas = new JToolBar();
		barraDeHerramientas.add(button1 = new JButton("Avanzar"));
		barraDeHerramientas.add(button2 = new JButton("Girar"));
		barraDeHerramientas.add(button3 = new JButton("Ancho Pincel"));
		barraDeHerramientas.add(button4 = new JButton("Ubicar"));
		barraDeHerramientas.add(button5 = new JButton("Nuevo dibujo"));
		barraDeHerramientas.add(button6 = new JButton("Borrar"));
		barraDeHerramientas.add(button7 = new JButton("Pintar"));
		barraDeHerramientas.add(button8 = new JButton("Ayuda"));
		barraDeHerramientas.add(button9 = new JButton("Color"));
		barraDeHerramientas.add(button10 = new JButton("cargar fondo"));
		barraDeHerramientas.add(button11 = new JButton("Nuevo BMP"));
		barraDeHerramientas.add(button12 = new JButton("Dibujar"));
		barraDeHerramientas.add(button13 = new JButton("Guardar XML"));
		barraDeHerramientas.add(button14 = new JButton("Abrir LOGO"));
		barraDeHerramientas.add(button15 = new JButton("Insertar LOGO"));

		panelNorth.add(barraDeHerramientas);
		add(panelNorth, "North");
	}

	@SuppressWarnings("static-access")
	private void addListenersButtons() {
		button1.addActionListener((ActionEvent e) -> {//avanzar*******************************************
			
			Sonido.AVANZAR.play();

			String g = JOptionPane.showInputDialog("Ejemplo 100", "Ingrese los pixeles a avanzar");
			
			try {
			
				int g2= Integer.parseInt(g);
			
			 tortuga.avanzar(g2);
			 muestraLosComandosEnElHistorial("avanzar "+g2);
			 Comando mi_comando = new Comando(1, null, g2, 0, 0, 1);
			 tortuga.getMi_historial().getComandos_guardados().add(mi_comando);
			
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				Sonido.ERROR.play();
				JOptionPane.showMessageDialog(null, "Ingresó un valor erroneo!!!");
			}
			
		});
		button2.addActionListener((ActionEvent e) -> {//girar**********************************************

			Sonido.GIRAR.play();
			try {
				String entrada = JOptionPane.showInputDialog("Ingrese el angulo de giro","Ej 90");
				int entrada_int = Integer.parseInt(entrada);
				
				tortuga.girar(entrada_int);
				rotarLabelTortuga(entrada_int);
				muestraLosComandosEnElHistorial("girar "+entrada_int);
				Comando mi_comando = new Comando(2, null, entrada_int, 0, 0, 1);
				tortuga.getMi_historial().getComandos_guardados().add(mi_comando);
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				Sonido.ERROR.play();
				JOptionPane.showMessageDialog(null, "Ingresó mal el valor!");
			}
			
		});
		button3.addActionListener((ActionEvent e) -> {//ancho pincel//****************************maso
			Sonido.ANCHO_PINCEL.play();
			
			try {
				String respuesta = JOptionPane.showInputDialog("Ingrese un entero para el ancho", "por ejemplo 5");
				int resp_parseada = Integer.parseInt(respuesta);
				
				tortuga.getMi_pincel().setAncho(resp_parseada);
				muestraLosComandosEnElHistorial("pincel "+resp_parseada);
				Comando mi_comando = new Comando(3, null, resp_parseada, 0, 0, 1);
				tortuga.getMi_historial().getComandos_guardados().add(mi_comando);
				
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				Sonido.ERROR.play();
				JOptionPane.showMessageDialog(null, "Ingresó un valor incorrecto!!!");
			}
			
			
		});
		button4.addActionListener((ActionEvent e) -> {//ubicar**************************************************
			Sonido.UBICAR.play();
			
			
			String respuesta = JOptionPane.showInputDialog("Ingrese x e y para ubicar la tortuga","por ej 12,18");
			ValidadorDeComandos miValidador = new ValidadorDeComandos(respuesta);
			
			
			try {
				if(miValidador.getTipo_parametro()==2){
				
				int x = miValidador.getParametro1();
				int y= miValidador.getParametro2();
				
				tortuga.ubicar(new Punto(x, y));
				muestraLosComandosEnElHistorial("ubicar "+x+","+y);
				Comando mi_comando = new Comando(0, null, x, y, 0, 2);
				tortuga.getMi_historial().getComandos_guardados().add(mi_comando);
				}else{
					Sonido.ERROR.play();
					JOptionPane.showMessageDialog(null, "Ingresó mal los valores");
					
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				Sonido.ERROR.play();
				JOptionPane.showMessageDialog(null, "Ingresó mal los números!!!");
			}
			
		});
		button5.addActionListener((ActionEvent e) -> {//nuevo dibujo*********************************************
			Sonido.NUEVO_DIBUJO.play();
			
            int respuesta = JOptionPane.showConfirmDialog (null, "Está seguro de que quiere empezar un nuevo dibujo desde cero?");


			if(respuesta == JOptionPane.YES_OPTION){
				
				
			tortuga.setDibujo(new Imagen());
			tortuga.setDibujo_puro(new Imagen());
			tortuga.setFondo(new Imagen());
			tortuga.setPosicion(new Punto(250, 250));
			tortuga.setAngulo(0);
			tortuga.setAngulo_ant(0);
			labelTortuga.setAngulo(0);
			tortuga.setAngulo_mostrar(0);
			tortuga.getMi_pincel().setColor(new Pixel(0, 0, 0));//**********resetea el pincel
			tortuga.getMi_pincel().setAncho(1);//**********resetea el ancho tambien
			tortuga.getMi_historial().resetearHistorial();//resetea el historial de la sesión
			resetearLosComandosDelHistorial();
			
			
			
			
			
			
			
			;}else{
				
				JOptionPane.showMessageDialog(null, "Canceló el comienzo de un nuevo dibujo.");
				
			}
			

		});
		button6.addActionListener((ActionEvent e) -> {//borrar***ANDAAAA!!!!!******************************

			Sonido.BORRAR.play();
			
			String g = JOptionPane.showInputDialog("Ejemplo 100", "Ingrese los pixeles a avanzar y borrar");

			try {

				int g2 = Integer.parseInt(g);

				tortuga.borrar(g2);
				muestraLosComandosEnElHistorial("borrar "+g2);
				Comando mi_comando = new Comando(5, null, g2, 0, 0, 1);
				tortuga.getMi_historial().getComandos_guardados().add(mi_comando);

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				Sonido.ERROR.play();
				JOptionPane.showMessageDialog(null, "Ingresó un valor erroneo!!!");
			}
			
			
		});
		button7.addActionListener((ActionEvent e) -> {//Pintar

			Sonido.PINTAR.play();
		  
			  tortuga.pintar(512- tortuga.getPosicion().getY(), tortuga.getPosicion().getX(), tortuga.getMi_pincel().getColor());
			   muestraLosComandosEnElHistorial("pintar");
			   Comando mi_comando = new Comando(6, null, 0, 0, 0, 0);
			   tortuga.getMi_historial().getComandos_guardados().add(mi_comando);
			   
		});
		button8.addActionListener((ActionEvent e) -> {//Ayuda****************************************************

			Sonido.AYUDA.play();
			
			Ayuda mi_pantalla_ayuda = new Ayuda();
			mi_pantalla_ayuda.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			mi_pantalla_ayuda.setSize(550, 332);
			mi_pantalla_ayuda.setResizable(false);
			mi_pantalla_ayuda.setVisible(true);
			
			
		});
		button9.addActionListener((ActionEvent e) -> {//color****************************************************

			Sonido.SELECCIONAR_COLOR.play();
			
		   Color color= JColorChooser.showDialog(null, "Seleccione un Color", Color.gray);
		   
		   tortuga.color(color.getRed(), color.getGreen(), color.getBlue());
		   muestraLosComandosEnElHistorial("color "+color.getRed()+","+color.getGreen()+","+color.getBlue());
		   Comando mi_comando = new Comando(4, null, color.getRed(), color.getGreen(), color.getBlue(), 3);
		   tortuga.getMi_historial().getComandos_guardados().add(mi_comando);
		   
		});
		button10.addActionListener((ActionEvent e) -> {//cargar imagen fondo**************************************

			Sonido.CARGAR_UN_FONDO.play();
			
			 int respuesta = JOptionPane.showConfirmDialog (null, "Está seguro de que quiere cargar un fondo al dibujo actual?");
			
			 if(respuesta == JOptionPane.YES_OPTION){
			
				 JFileChooser file = new JFileChooser();
			
			file.setAcceptAllFileFilterUsed(false);
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"BMP Images", new String[] { "bmp" });
			file.setFileFilter(filter);
			 file.showOpenDialog(this);//showabrirGUIDialog
			
			File abre = file.getSelectedFile();
			
			tortuga.getFondo().setFondo(tortuga.getMi_gestorBMP().loadImage(abre.getPath()));//fondo intocable
			tortuga.cargarUnfondoAlDibujo();//aca dibuja
			actualizarLabelImagen(tortuga.getDibujo().getFondo());
			
			 }else{
				 
				 JOptionPane.showMessageDialog(null, "Se canceló la carga del fondo!!!");
				 
			 }
		});
		
		button11.addActionListener((ActionEvent e) -> {//nuevo BMP guarda el dibujo con el fondo!!!**Andaaaa!!!!!
			Sonido.NUEVO_BMP.play();
			
			JFileChooser mi_chooser= new JFileChooser(); 
			mi_chooser.setAcceptAllFileFilterUsed(false);
			@SuppressWarnings("unused")
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"BMP Images", new String[] { "bmp" });
			String ruta = ""; 
			
			try{ 
			if(mi_chooser.showSaveDialog(null)==mi_chooser.APPROVE_OPTION){ 
			ruta = mi_chooser.getSelectedFile().getAbsolutePath();
			
			tortuga.nuevoImagenBMP(ruta);
			
			JOptionPane.showMessageDialog(null, "Guardado con éxito!!!");
			
			} 
			}catch (Exception ex){ 
			
				Sonido.ERROR.play();
				JOptionPane.showMessageDialog(null, "No se pudo guardar...");
			} 
			
	});
			
		button12.addActionListener((ActionEvent e) -> {//dibujar

			Sonido.DIBUJAR.play();
			
			 int respuesta = JOptionPane.showConfirmDialog (null, "Está seguro de que quiere borrar el fondo del dibujo??");
				
			 if(respuesta == JOptionPane.YES_OPTION){
				 
				 Pixel[][] mi_fondo_blanco = new Imagen().getFondo();
				 
				 actualizarLabelImagen(tortuga.getDibujo().getFondo());
					tortuga.getFondo().setFondo(mi_fondo_blanco);//fondo intocable
					tortuga.cargarUnfondoAlDibujo();//aca dibuja
					actualizarLabelImagen(tortuga.getDibujo().getFondo());
				 
				 
			 }else{
				 
				 JOptionPane.showMessageDialog(null, "Se canceló el borrado del fondo");
				 
			 }
			
		});
		
		button13.addActionListener((ActionEvent e) -> {//guardar XML

			Sonido.GUARDAR_XML.play();
			
		});
		
		button14.addActionListener((ActionEvent e) -> {//abrir logo

			Sonido.ABRIR_ARCHIVO_LOGO.play();
		});
		
		button15.addActionListener((ActionEvent e) -> {//insertar logo

			Sonido.INSERTAR_DIBUJO_LOGO.play();
		});
		
		commands.addActionListener((ActionEvent e) -> {//Funciona con ENTER!!!

			enviar.doClick();
		});
		
		enviar.addActionListener((ActionEvent e) ->{//***Escucha los comandos!!!
			
			String texto = commands.getText();
			
			mi_validador = new ValidadorDeComandos(texto);
			
			String comando = mi_validador.getComando();
			int ID_COMANDO = mi_validador.getID_COMANDO();
			String ruta = mi_validador.getRuta();
			int param1 = mi_validador.getParametro1();
			int param2 = mi_validador.getParametro2();
			int param3 = mi_validador.getParametro3();
			int tipo_param = mi_validador.getTipo_parametro();//cuantos parametros numericos tiene
			Comando mi_comando = new Comando(ID_COMANDO, ruta, param1, param2, param3, tipo_param);
			
			
			if(ID_COMANDO==-1){
				
				Sonido.ERROR.play();
				JOptionPane.showMessageDialog(null, "No ingresó bien los comandos");
				
			}
			else if(ID_COMANDO==0){//ubicar
			
				if(tipo_param==0){
					
					button4.doClick();
				}else if(tipo_param==2){
					
					Sonido.UBICAR.play();
					tortuga.ubicar(new Punto(param1, param2));
					muestraLosComandosEnElHistorial("ubicar "+param1+","+param2);
					tortuga.getMi_historial().getComandos_guardados().add(mi_comando);
					
				}else{
					
					Sonido.ERROR.play();
					JOptionPane.showMessageDialog(null, "Ingresó mal los comandos");
					
				}
				
				
			}
			else if(ID_COMANDO==1){//avanzar
				
				if(tipo_param==0){
					
					button1.doClick();
					
				}else if(tipo_param==1){
					
					Sonido.AVANZAR.play();
					tortuga.avanzar(param1);
					muestraLosComandosEnElHistorial("avanzar "+param1);
					tortuga.getMi_historial().getComandos_guardados().add(mi_comando);
				}else{
					
					Sonido.ERROR.play();
					JOptionPane.showMessageDialog(null, "Ingresó mal los parámetros");
					
				}
				
			}
			else if(ID_COMANDO==2){//girar
				
				if(tipo_param==0){
					
					button2.doClick();
					
				}else if(tipo_param==1){
					
					Sonido.GIRAR.play();
					tortuga.girar(param1);
					rotarLabelTortuga(param1);
					muestraLosComandosEnElHistorial("girar "+param1);
					tortuga.getMi_historial().getComandos_guardados().add(mi_comando);
					
				}else{
					Sonido.ERROR.play();
					JOptionPane.showMessageDialog(null, "Ingresó mal los comandos");
					
				}
				
			}
			else if(ID_COMANDO==3){//pincel
				
				if(tipo_param==0){
					
					button3.doClick();
				}else if(tipo_param==1){
					
					try {
						Sonido.ANCHO_PINCEL.play();
						tortuga.getMi_pincel().setAncho(param1);
						muestraLosComandosEnElHistorial("pincel "+param1);
						tortuga.getMi_historial().getComandos_guardados().add(mi_comando);
					} catch (RuntimeException e1) {
						
						Sonido.ERROR.play();
						JOptionPane.showMessageDialog(null, "El pincel no puede ser tan grande!!!");
					}
					
				}else{
					Sonido.ERROR.play();
					JOptionPane.showMessageDialog(null, "Ingresó mal los comandos!!!");
					
				}
				
			}
			else if(ID_COMANDO==4){//color
				
				if(tipo_param==0&&ruta==null){
					
					button9.doClick();
				}
				else if(tipo_param==3&&ruta==null){
					
					try {
						
						Sonido.SELECCIONAR_COLOR.play();
						tortuga.color(param1, param2, param3);//el mambo del color
						muestraLosComandosEnElHistorial("color "+param1+","+param2+","+param3);
						tortuga.getMi_historial().getComandos_guardados().add(mi_comando);
					
					} catch (RuntimeException e1) {
						
						Sonido.ERROR.play();
						JOptionPane.showMessageDialog(null, "Cada color debe estar entre 0 y 255");
					}
					
				}else{
					
					Sonido.ERROR.play();
					JOptionPane.showMessageDialog(null, "Error en el comando");
					
				}
				
				
			}
			else if(ID_COMANDO==5){//borrar
				
				if(tipo_param==0){
					
					button6.doClick();
				}else if(tipo_param==1){
					
					Sonido.BORRAR.play();
					tortuga.borrar(param1);
					muestraLosComandosEnElHistorial("borrar "+param1);
					tortuga.getMi_historial().getComandos_guardados().add(mi_comando);
				}else{
					
					Sonido.ERROR.play();
					JOptionPane.showMessageDialog(null, "Ingresó mal los comandos");
					
				}
				
			}
			else if(ID_COMANDO==6){//**PINTAR
				
				if(ruta==null&&tipo_param==0){
					
					button7.doClick();
					
				}else{
					
					Sonido.ERROR.play();
					JOptionPane.showMessageDialog(null, "Ingresó mal los comandos");
					
				}
				
			}
			else if(ID_COMANDO==7){//fondo
				
				if(tipo_param==0&&ruta==null){
					
					button10.doClick();
					
				}else if(tipo_param==0&&ruta!=null){
					
					Sonido.CARGAR_UN_FONDO.play();
					//actualizarLabelImagen(tortuga.getMi_gestorBMP().loadImage(ruta));
					//tortuga.getDibujo().setFondo(tortuga.getMi_gestorBMP().loadImage(ruta));//aca dibuja
					//tortuga.getFondo().setFondo(tortuga.getMi_gestorBMP().loadImage(ruta));//fondo intocable
					
					actualizarLabelImagen(tortuga.getDibujo().getFondo());
					tortuga.getFondo().setFondo(tortuga.getMi_gestorBMP().loadImage(ruta));//fondo intocable
					tortuga.cargarUnfondoAlDibujo();//aca dibuja
					actualizarLabelImagen(tortuga.getDibujo().getFondo());
					
					
				}else{
					
					Sonido.ERROR.play();
					JOptionPane.showMessageDialog(null, "Ingresó mal los comandos");
					
				}
			}
			else if(ID_COMANDO==8){//**AYUDA
				
				if(tipo_param==0&&ruta==null){
				
					button8.doClick();
				}else{
					
					Sonido.ERROR.play();
					JOptionPane.showMessageDialog(null, "Ingresó mal los comandos!!!");
					
				}
				
			}
			else if(ID_COMANDO==9){//**NUEVO
				
				if(tipo_param==0&&ruta==null){
					
					button5.doClick();
					
				}else if(tipo_param==0&&ruta!=null){
					
					Sonido.NUEVO_BMP.play();
					tortuga.nuevoImagenBMP(ruta);
					muestraLosComandosEnElHistorial("nuevo "+ruta);
					
				}
				else{
					
					Sonido.ERROR.play();
					JOptionPane.showMessageDialog(null, "Ingresó mal los comandos!!!");
					
				}
				
			}
			else if(ID_COMANDO==10){//**DIBUJAR
				
				if(tipo_param==0&&ruta==null){
					
					button12.doClick();
				}else{
					
					Sonido.ERROR.play();
					JOptionPane.showMessageDialog(null, "Ingresó mal los comandos");
					
				}
				
			}
			else if(ID_COMANDO==11){//guardarLOGO
				
				if (tipo_param == 0 && ruta == null) {

					button13.doClick();

				} else if (tipo_param == 0 && ruta != null) {

					//aca van los comandos para guardar XML
					Sonido.GUARDAR_XML.play();
					JOptionPane.showMessageDialog(null, "Comando: "+comando+" ruta: "+ruta);
					
				} else {

					Sonido.ERROR.play();
					JOptionPane.showMessageDialog(null, "Ingresó mal los comandos");

				}
				
				
			}
			else if(ID_COMANDO==12){//abrirLOGO
				
				if (tipo_param == 0 && ruta == null) {

					button14.doClick();

				} else if (tipo_param == 0 && ruta != null) {

					//aca van los comandos para abrir XML
					Sonido.ABRIR_ARCHIVO_LOGO.play();
					JOptionPane.showMessageDialog(null, "Comando: "+comando+" ruta: "+ruta);

				} else {

					Sonido.ERROR.play();
					JOptionPane.showMessageDialog(null, "Ingresó mal los comandos");

				}
				
				
				
			}
			else if (ID_COMANDO == 13) {// insertarLOGO

				if (tipo_param == 0 && ruta == null) {

					button15.doClick();

				} else if (tipo_param == 2 && ruta != null) {

					Sonido.INSERTAR_DIBUJO_LOGO.play();
					//aca van las instrucciones para insertar logo
					JOptionPane.showMessageDialog(null, "Ruta: "+ruta+" X: "+param1+" Y: "+param2);
					
				} else {

					Sonido.ERROR.play();
					JOptionPane.showMessageDialog(null, "Error inesperado");
				}

			}
		});
		
		
	}

	private void crearPanelCenter() {
		panelCenter = new JPanel();
		panelCenter.setBackground(Color.BLACK);
		panelImage = new JPanel();
		panelImage.setBackground(Color.BLACK);
		panelImage.setPreferredSize(new Dimension(512, 512));
		labelImage = new JLabel();
		labelImage.setLayout(null);
		labelImage.setBounds(0, 0, 512, 512);
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/tortuga.png"));
		labelTortuga = new LabelTortuga(icon);
		labelTortuga.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());//ver esto!!!!
		labelTortuga.setIcon(icon);
		
		labelImage.add(labelTortuga); // importante!
		actualizarPosLabelTortuga(250, 250);
		panelImage.add(labelImage);
		panelCenter.add(panelImage);
		add(panelCenter, "Center");
	}

	private void crearPanelWest() {
		panelWest = new JPanel(new BorderLayout());
		panelWest.setPreferredSize(new Dimension(160, getHeight()));
		areaHistory = new JTextArea("Historial comandos");
		areaHistory.setWrapStyleWord(true);
		areaHistory.setLineWrap(true);
		areaHistory.setEditable(true);
		JScrollPane scroll = new JScrollPane(areaHistory);
		panelWest.add(scroll);
		add(panelWest, "West");
	}

	private void crearPanelSouth() {
		panelSouth = new JPanel();
		panelSouth.setBackground(Color.DARK_GRAY);
		commands= new JTextField("Ingrese comandos luego presione enter",50);
		commands.addFocusListener( new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				commands.setSelectionStart(0);
				commands.setSelectionEnd(commands.getText().length());
			}
			public void focusLost(FocusEvent e) {
				commands.setSelectionStart(0);
				commands.setSelectionEnd(0);
			}
		});
		
		panelSouth.add(commands);
		panelSouth.add(enviar= new JButton("Enter"));
		add(panelSouth, "South");
	}

	public void actualizarLabelImagen(Pixel[][] pixels) {
		actualizarLabelImagen(512, 512, pixels);
	}

	public void actualizarLabelImagen(int width, int height, Pixel[][] pixels) {
		BufferedImage buf = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int i = 0; i < height; ++i) {
			for (int j = 0; j < width; ++j) {
				int r = pixels[i][j].getR();
				int g = pixels[i][j].getG();
				int b = pixels[i][j].getB();
				buf.setRGB(j, i, (new Color(r, g, b)).getRGB());
			}
		}
		labelImage.setIcon(new ImageIcon(buf));
		labelImage.setBounds(0, 0, width, height);
	}

	public void actualizarPosLabelTortuga(int x, int y) {
		
		labelTortuga.setLocation(x, y);
	}
	
public void actualizarPosLabelTortuga() {//***********
		
		labelTortuga.setLocation(tortuga.getPosicion().getX()-13, 498-tortuga.getPosicion().getY());
		
		labelTortuga.setToolTipText("Pos X: "+tortuga.getCoordenadaXTortuga()+//la etiqueta de la tortuga
				" Pos Y: "+ (512-tortuga.getCoordenadaYTortuga())+" Ángulo: "+tortuga.getAngulo_mostrar()+
				" Color: "+tortuga.getMi_pincel().colorToString()+
				" Ancho Pincel: "+tortuga.getMi_pincel().getAncho());
	}
	
	public void rotarLabelTortuga(int grados){
		
		labelTortuga.setAngulo(tortuga.getAngulo());
	}

	public void abrirGUI() {
		setVisible(true);
		commands.requestFocus();//******
	}

	public void cerrarGUI() {
		System.exit(0);
	}
	
	public void muestraLosComandosEnElHistorial(String un_comando){
		areaHistory.append("\n");
		areaHistory.append(un_comando);
	
	}
	
	public void resetearLosComandosDelHistorial(){
		areaHistory.setText("Historial de Comandos");
		
		
	}
}
