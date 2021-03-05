package Backend.PatronMVC;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Backend.PatronMVC.controller.PersonaController;
import Backend.PatronMVC.controller.VideoController;
import Backend.PatronMVC.model.service.PersonaServ;
import Backend.PatronMVC.model.service.VideoServ;
import Backend.PatronMVC.view.VentanaBuscar;
import Backend.PatronMVC.view.VentanaBuscarVideo;
import Backend.PatronMVC.view.VentanaPrincipal;
import Backend.PatronMVC.view.VentanaRegistro;
import Backend.PatronMVC.view.VentanaRegistroVideo;

public class mainApp extends JFrame {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PersonaServ mipersonaServ;
	VideoServ mivideoServ;
	VentanaPrincipal miVentanaPrincipal;
	VentanaBuscar miVentanaBuscar;
	VentanaBuscarVideo miVentanaBuscarVideo;
	VentanaRegistro miVentanaRegistro;
	VentanaRegistroVideo miVentanaRegistroVideo;
	PersonaController personaController;
	VideoController videoController;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				mainApp miPrincipal = new mainApp();
				miPrincipal.iniciar();
			}
		});
	}

	/**
	 * Permite instanciar todas las clases con las que trabaja el sistema
	 */
	private void iniciar() {
		/* Se instancian las clases */
		miVentanaPrincipal = new VentanaPrincipal();
		miVentanaRegistro = new VentanaRegistro();
		miVentanaBuscar = new VentanaBuscar();
		mipersonaServ = new PersonaServ();
		personaController = new PersonaController();
		miVentanaRegistroVideo = new VentanaRegistroVideo();
		miVentanaBuscarVideo = new VentanaBuscarVideo();
		mivideoServ = new VideoServ();
		videoController = new VideoController();


		/* Se establecen las relaciones entre clases */
		miVentanaPrincipal.setCoordinador(personaController);
		miVentanaRegistro.setCoordinador(personaController);
		miVentanaBuscar.setCoordinador(personaController);
		mipersonaServ.setpersonaController(personaController);
		miVentanaPrincipal.setCoordinadorVideo(videoController);
		miVentanaBuscarVideo.setCoordinador(videoController);
		miVentanaRegistroVideo.setCoordinador(videoController);
		mivideoServ.setvideoController(videoController);


		/* Se establecen relaciones con la clase coordinador */
		personaController.setMiVentanaPrincipal(miVentanaPrincipal);
		personaController.setMiVentanaRegistro(miVentanaRegistro);
		personaController.setMiVentanaBuscar(miVentanaBuscar);
		personaController.setPersonaServ(mipersonaServ);
		videoController.setMiVentanaBuscarVideo(miVentanaBuscarVideo);
		videoController.setMiVentanaRegistroVideo(miVentanaRegistroVideo);
		videoController.setVideoServ(mivideoServ);
		
		miVentanaPrincipal.setVisible(true);
	}


}
