/*
 * Esta clase permite realizar las operaciones asociadas a la lógica de negocio como tal, desde ella realizamos las validaciones 
 * y llamadas a las operaciones CRUD del sistema.
 * 
 * En caso de que se requieran procesos adicionales asociados a la lógica de negocio, aquí será donde se creen los métodos para 
 * dichos procesos, por ejemplo el método validarRegistro determina si los datos son correctos y permite registrar la persona en
 * el Dao.
 */

package Backend.PatronMVC.model.service;

import javax.swing.JOptionPane;

import Backend.PatronMVC.model.dao.PersonaDao;
import Backend.PatronMVC.model.dto.Persona;
import Backend.PatronMVC.controller.PersonaController;

public class PersonaServ {
	
	private PersonaController personaController; 
	public static boolean consultaPersona=false;
	public static boolean modificaPersona=false;
	
	//Metodo de vinculación con el controller principal
	public void setpersonaController(PersonaController personaController) {
		this.setController(personaController);		
	}

	//Metodo que valida los datos de Registro antes de pasar estos al DAO
	public void validarRegistro(Persona miPersona) {
		PersonaDao miPersonaDao;
		if (miPersona.getNombrePersona().length()>3 && Integer.toString(miPersona.getDniPersona()).length() == 8) {
			miPersonaDao = new PersonaDao();
			miPersonaDao.registrarPersona(miPersona);						
		}else {
			if(miPersona.getNombrePersona().length()<=3) {
				JOptionPane.showMessageDialog(null,"El nombre del cliente debe ser mayor a 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
			if(Integer.toString(miPersona.getDniPersona()).length() != 8) {
				JOptionPane.showMessageDialog(null,"El Dni de la persona debe ser de 8 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		}
		
	}
	
	//Metodo que valida los datos de consulta antes de pasar estos al DAO
	public Persona validarConsulta(String codigoPersona) {
		PersonaDao miPersonaDao;
		
		try {
			int codigo=Integer.parseInt(codigoPersona);	
			if (codigo > 0) {
				miPersonaDao = new PersonaDao();
				consultaPersona=true;
				return miPersonaDao.buscarPersona(codigo);						
			}else{
				JOptionPane.showMessageDialog(null,"El codigo del cliente debe ser mas de 0 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
				consultaPersona=false;
			}
			
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
			consultaPersona=false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
			consultaPersona=false;
		}
					
		return null;
	}

	//Metodo que valida los datos de Modificación antes de pasar estos al DAO
	public void validarModificacion(Persona miPersona) {
		PersonaDao miPersonaDao;
		if (miPersona.getNombrePersona().length()>3 && Integer.toString(miPersona.getDniPersona()).length() == 8) {
			miPersonaDao = new PersonaDao();
			miPersonaDao.modificarPersona(miPersona);	
			modificaPersona=true;
		}else{
			if(miPersona.getNombrePersona().length()<=3) {
				JOptionPane.showMessageDialog(null,"El nombre de la persona debe ser mayor a 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
				modificaPersona=false;
			}
			if(Integer.toString(miPersona.getDniPersona()).length() != 8) {
				JOptionPane.showMessageDialog(null,"El Dni de la persona debe ser de 8 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
				modificaPersona=false;
			}
		}
	}
	

	//Metodo que valida los datos de Eliminación antes de pasar estos al DAO
	public void validarEliminacion(String codigo) {
		PersonaDao miPersonaDao=new PersonaDao();
		miPersonaDao.eliminarPersona(codigo);
	}

	
	
	public PersonaController getPersonaController() {
		return personaController;
	}

	public void setController(PersonaController personaController) {
		this.personaController = personaController;
	}



}
