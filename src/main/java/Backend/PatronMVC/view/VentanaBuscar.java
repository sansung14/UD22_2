package Backend.PatronMVC.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Backend.PatronMVC.model.dto.Persona;
import Backend.PatronMVC.model.service.PersonaServ;
import Backend.PatronMVC.controller.PersonaController;

public class VentanaBuscar  extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private PersonaController personaController; //objeto personaController que permite la relacion entre esta clase y la clase personaController
	private JLabel labelTitulo;
	private JTextField textCod,textNombre,textApellido,textDireccion,textDni,textFecha;
	private JLabel cod,nombre,apellido,direccion,dni,fecha;
	private JButton botonGuardar,botonCancelar,botonBuscar,botonModificar,botonEliminar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de busqueda
	 */
	public VentanaBuscar() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(50, 220, 120, 25);
		botonGuardar.setText("Guardar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(190, 250, 120, 25);
		botonCancelar.setText("Cancelar");
		
		botonBuscar = new JButton();
		botonBuscar.setBounds(170, 70, 50, 25);
		botonBuscar.setText("Ok");
		
		botonEliminar = new JButton();
		botonEliminar.setBounds(330, 220, 120, 25);
		botonEliminar.setText("Eliminar");
		
		botonModificar = new JButton();
		botonModificar.setBounds(190, 220, 120, 25);
		botonModificar.setText("Modificar");

		labelTitulo = new JLabel();
		labelTitulo.setText("ADMINISTRAR Cliente");
		labelTitulo.setBounds(120, 20, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		cod=new JLabel();
		cod.setText("Codigo");
		cod.setBounds(20, 70, 80, 25);
		add(cod);
		
		nombre=new JLabel();
		nombre.setText("Nombre");
		nombre.setBounds(20, 110, 80, 25);
		add(nombre);

		apellido=new JLabel();
		apellido.setText("Apellido");
		apellido.setBounds(290, 145, 80, 25);
		add(apellido);
		
		direccion=new JLabel();
		direccion.setText("direccion");
		direccion.setBounds(20, 145, 80, 25);
		add(direccion);
		
		dni=new JLabel();
		dni.setText("dni");
		dni.setBounds(290, 110, 80, 25);
		add(dni);
		
		fecha=new JLabel();
		fecha.setText("fecha");
		fecha.setBounds(20, 180, 80, 25);
		add(fecha);
		
		textCod=new JTextField();
		textCod.setBounds(80, 70, 80, 25);
		add(textCod);
		
		textNombre=new JTextField();
		textNombre.setBounds(80, 110, 190, 25);
		add(textNombre);

		textApellido=new JTextField();
		textApellido.setBounds(340, 145, 80, 25);
		add(textApellido);
		
		textDireccion=new JTextField();
		textDireccion.setBounds(80, 145, 190, 25);
		add(textDireccion);
		
		textDni=new JTextField();
		textDni.setBounds(340, 110, 80, 25);
		add(textDni);
		
		textFecha=new JTextField();
		textFecha.setBounds(80, 180, 190, 25);
		textFecha.setEditable(false);
		add(textFecha);
		
		botonModificar.addActionListener(this);
		botonEliminar.addActionListener(this);
		botonBuscar.addActionListener(this);
		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);

		add(botonCancelar);
		add(botonBuscar);
		add(botonModificar);
		add(botonEliminar);
		add(botonGuardar);
		add(labelTitulo);
		limpiar();
				
		setSize(480, 320);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

	}


	public void setCoordinador(PersonaController personaController) {
		this.personaController=personaController;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				Persona miPersona=new Persona();
				miPersona.setIdPersona(Integer.parseInt(textCod.getText()));
				miPersona.setNombrePersona(textNombre.getText());
				miPersona.setApellidoPersona(textApellido.getText());
				miPersona.setDireccionPersona(textDireccion.getText());
				miPersona.setDniPersona(Integer.parseInt(textDni.getText()));

				personaController.modificarPersona(miPersona);
				
				if (PersonaServ.modificaPersona==true) {
					habilita(true, false, false, false, false, true, false, true, true);	
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if (e.getSource()==botonBuscar)
		{
			Persona miPersona=personaController.buscarPersona(textCod.getText());
			if (miPersona!=null)
			{
				muestraPersona(miPersona);
			}
			else if(PersonaServ.consultaPersona==true){
				JOptionPane.showMessageDialog(null, "La persona no Existe","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource()==botonModificar)
		{
			habilita(false, true, true, true, true, false, true, false, false);
			
		}
		
		if (e.getSource()==botonEliminar)
		{
			if (!textCod.getText().equals(""))
			{
				int respuesta = JOptionPane.showConfirmDialog(this,
						"Esta seguro de eliminar la Persona?", "Confirmación",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION)
				{
					personaController.eliminarPersona(textCod.getText());
					limpiar();
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Ingrese un numero de Documento", "Información",JOptionPane.WARNING_MESSAGE);
			}
			
		}
		if (e.getSource()==botonCancelar)
		{
			this.dispose();
		}

	}



	/**
	 * permite cargar los datos de la persona consultada
	 * @param miPersona
	 */
	private void muestraPersona(Persona miPersona) {
		textNombre.setText(miPersona.getNombrePersona());
		textApellido.setText(miPersona.getApellidoPersona()+"");
		textDireccion.setText(miPersona.getDireccionPersona()+"");
		textDni.setText(miPersona.getDniPersona()+"");
		textFecha.setText(miPersona.getFechaPersona());
		habilita(true, false, false, false, false, true, false, true, true);
	}


	/**
	 * Permite limpiar los componentes
	 */
	public void limpiar()
	{
		textCod.setText("");
		textNombre.setText("");
		textApellido.setText("");
		textDireccion.setText("");
		textDni.setText("");
		textFecha.setText("");
		habilita(true, false, false, false, false, true, false, true, true);
	}


	/**
	 * Permite habilitar los componentes para establecer una modificacion
	 * @param codigo
	 * @param nombre
	 * @param apellido
	 * @param direccion
	 * @param dni
	 * @param bBuscar
	 * @param bGuardar
	 * @param bModificar
	 * @param bEliminar
	 */
	public void habilita(boolean codigo, boolean nombre, boolean apellido, boolean direccion, boolean dni, boolean bBuscar, boolean bGuardar, boolean bModificar, boolean bEliminar)
	{
		textCod.setEditable(codigo);
		textNombre.setEditable(nombre);
		textApellido.setEditable(apellido);
		textDireccion.setEditable(direccion);
		textDni.setEditable(dni);
		botonBuscar.setEnabled(bBuscar);
		botonGuardar.setEnabled(bGuardar);
		botonModificar.setEnabled(bModificar);
		botonEliminar.setEnabled(bEliminar);
	}
}
