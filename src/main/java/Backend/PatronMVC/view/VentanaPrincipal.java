package Backend.PatronMVC.view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import Backend.PatronMVC.controller.VideoController;
import Backend.PatronMVC.controller.PersonaController;

public class VentanaPrincipal extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	public VideoController videoController;
	private PersonaController personaController; //objeto PersonaController que permite la relacion entre esta clase y la clase PersonaController
	private JTextArea areaIntroduccion;
	private JLabel labelTitulo, labelSeleccion, labelVideo;
	private JButton botonRegistrar,botonBuscar,botonRegistrarVideo,botonBuscarVideo;
	

	/**
	 * Establece la informacion que se presentara como introduccion del sistema
	 */
	public String textoIntroduccion = "";

	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana principal
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		botonRegistrar = new JButton();
		botonRegistrar.setBounds(100, 180, 120, 25);
		botonRegistrar.setText("Registrar Persona");
		
		botonBuscar = new JButton();
		botonBuscar.setBounds(240, 180, 120, 25);
		botonBuscar.setText("Buscar Persona");

		
		botonRegistrarVideo = new JButton();
		botonRegistrarVideo.setBounds(100, 240, 120, 25);
		botonRegistrarVideo.setText("Registrar Video");
		
		botonBuscarVideo = new JButton();
		botonBuscarVideo.setBounds(240, 240, 120, 25);
		botonBuscarVideo.setText("Buscar Video");
		
		
		
		labelTitulo = new JLabel();
		labelTitulo.setText("PATRON MODELO VISTA CONTROLADOR");
		labelTitulo.setBounds(60, 40, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 15));

		labelSeleccion = new JLabel();
		labelSeleccion.setText("Escoja que operacion desea realizar para Cliente:");
		labelSeleccion.setBounds(75, 150, 300, 25);

		labelVideo = new JLabel();
		labelVideo.setText("Escoja que operacion desea realizar para Video:");
		labelVideo.setBounds(75, 210, 300, 25);
		
		textoIntroduccion = "La aplicación permite registrar, actualizar, buscar y eliminar registros de una tabla Cliente i Video.";

		areaIntroduccion = new JTextArea();
		areaIntroduccion.setBounds(50, 90, 380, 60);
		areaIntroduccion.setEditable(false);
		areaIntroduccion.setFont(new java.awt.Font("Verdana", 0, 14));
		areaIntroduccion.setLineWrap(true);
		areaIntroduccion.setText(textoIntroduccion);
		areaIntroduccion.setWrapStyleWord(true);
		areaIntroduccion.setBorder(javax.swing.BorderFactory.createBevelBorder(
				javax.swing.border.BevelBorder.LOWERED, null, null, null,
				new java.awt.Color(0, 0, 0)));

		botonRegistrar.addActionListener(this);
		botonBuscar.addActionListener(this);
		botonRegistrarVideo.addActionListener(this);
		botonBuscarVideo.addActionListener(this);
		add(botonBuscar);
		add(botonRegistrar);
		add(botonBuscarVideo);
		add(botonRegistrarVideo);
		add(labelSeleccion);
		add(labelVideo);
		add(labelTitulo);
		add(areaIntroduccion);
	
		setSize(480, 350);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

	}


	public void setCoordinador(PersonaController personaController) {
		this.personaController=personaController;
	}

	public void setCoordinadorVideo(VideoController videoController) {
		this.videoController=videoController;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==botonRegistrar) {
			personaController.mostrarVentanaRegistro();			
		}
		if (e.getSource()==botonBuscar) {
			personaController.mostrarVentanaConsulta();			
		}
		if (e.getSource()==botonRegistrarVideo) {
			videoController.mostrarVentanaRegistroVideo();			
		}
		if (e.getSource()==botonBuscarVideo) {
			videoController.mostrarVentanaConsultaVideo();			
		}
	}
}
