package Backend.PatronMVC.model.service;

import javax.swing.JOptionPane;

import Backend.PatronMVC.controller.VideoController;
import Backend.PatronMVC.model.dao.VideoDao;
import Backend.PatronMVC.model.dto.Video;


public class VideoServ {
	
	private VideoController videoController;
	public static boolean consultaVideo = false;
	public static boolean modificaVideo = false;

	// Metodo de vinculación con el controller principal
	public void setvideoController(VideoController videoController) {
		this.setController(videoController);
	}

	// Metodo que valida los datos de Registro antes de pasar estos al DAO
	public void validarRegistro(Video miVideo) {
		VideoDao miVideoDao;
		if (miVideo.getTitle().length() > 3) {
			miVideoDao = new VideoDao();
			miVideoDao.registrarVideo(miVideo);
		} else {
			JOptionPane.showMessageDialog(null, "El nombre del video debe ser mayor a 3 digitos", "Advertencia",
			JOptionPane.WARNING_MESSAGE);
		}

	}

	// Metodo que valida los datos de consulta antes de pasar estos al DAO
	public Video validarConsulta(String codigoVideo) {
		VideoDao miVideoDao;

		try {
			int codigo = Integer.parseInt(codigoVideo);
			if (codigo > 0) {
				miVideoDao = new VideoDao();
				consultaVideo = true;
				return miVideoDao.buscarVideo(codigo);
			} else {
				JOptionPane.showMessageDialog(null, "El codigo del video debe ser mas de 0 digitos", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
				consultaVideo = false;
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Debe ingresar un dato numerico", "Error", JOptionPane.ERROR_MESSAGE);
			consultaVideo = false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha presentado un Error", "Error", JOptionPane.ERROR_MESSAGE);
			consultaVideo = false;
		}

		return null;
	}

	// Metodo que valida los datos de Modificación antes de pasar estos al DAO
	public void validarModificacion(Video miVideo) {
		VideoDao miVideoDao;
		if (miVideo.getTitle().length() > 3) {
			miVideoDao = new VideoDao();
			miVideoDao.modificarVideo(miVideo);
			modificaVideo = true;
		} else {
			if (miVideo.getTitle().length() <= 3) {
				JOptionPane.showMessageDialog(null, "El nombre del video debe ser mayor a 3 digitos", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
				modificaVideo = false;
			}
		}
	}

	// Metodo que valida los datos de Eliminación antes de pasar estos al DAO
	public void validarEliminacion(String codigo) {
		VideoDao miVideoDao = new VideoDao();
		miVideoDao.eliminarVideo(codigo);
	}

	public VideoController getPersonaController() {
		return videoController;
	}

	public void setController(VideoController videoController) {
		this.videoController = videoController;
	}

}
