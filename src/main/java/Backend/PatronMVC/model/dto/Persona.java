package Backend.PatronMVC.model.dto;

public class Persona {

	private Integer idPersona;
	private String nombrePersona;
	private String apellidoPersona;
	private String direccionPersona;
	private Integer dniPersona;
	private String fechaPersona;

	/**
	 * @return the idPersona
	 */
	public Integer getIdPersona() {
		return idPersona;
	}

	/**
	 * @param idPersona the idPersona to set
	 */
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	/**
	 * @return the nombrePersona
	 */
	public String getNombrePersona() {
		return nombrePersona;
	}

	/**
	 * @param nombrePersona the nombrePersona to set
	 */
	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	/**
	 * @return the edadPersona
	 */
	public String getApellidoPersona() {
		return apellidoPersona;
	}

	public void setApellidoPersona(String apellidoPersona) {
		this.apellidoPersona = apellidoPersona;
	}

	public String getDireccionPersona() {
		return direccionPersona;
	}

	public void setDireccionPersona(String direccionPersona) {
		this.direccionPersona = direccionPersona;
	}

	public Integer getDniPersona() {
		return dniPersona;
	}

	public void setDniPersona(Integer dniPersona) {
		this.dniPersona = dniPersona;
	}

	public String getFechaPersona() {
		return fechaPersona;
	}

	public void setFechaPersona(String fechaPersona) {
		this.fechaPersona = fechaPersona;
	}

}
