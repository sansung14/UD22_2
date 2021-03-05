package Backend.PatronMVC.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Backend.PatronMVC.controller.PersonaController;
import Backend.PatronMVC.model.dto.Persona;


public class VentanaRegistro extends JFrame implements ActionListener{

	
	private static final long serialVersionUID = 1L;
	private PersonaController personaController; //objeto personaController que permite la relacion entre esta clase y la clase PersonaController
	private JLabel labelTitulo;
	private JTextField textCod,textNombre,textApellido, textDireccion, textDni, textFecha;
	private JLabel cod,nombre,apellido,direccion,dni,fecha;
	private JButton botonGuardar,botonCancelar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de registro
	 */
	public VentanaRegistro() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(110, 220, 120, 25);
		botonGuardar.setText("Registrar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(250, 220, 120, 25);
		botonCancelar.setText("Cancelar");

		labelTitulo = new JLabel();
		labelTitulo.setText("REGISTRO DE PERSONAS");
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

		dni=new JLabel();
		dni.setText("DNI");
		dni.setBounds(280, 150, 80, 25);
		add(dni);
		
		apellido=new JLabel();
		apellido.setText("Apellido");
		apellido.setBounds(230, 110, 80, 25);
		add(apellido);
		
		direccion=new JLabel();
		direccion.setText("Direccion");
		direccion.setBounds(20, 150, 80, 25);
		add(direccion);
		
		fecha=new JLabel();
		fecha.setText("Fecha");
		fecha.setBounds(20, 180, 80, 25);
		add(fecha);
		
		textCod=new JTextField();
		textCod.setBounds(80, 70, 80, 25);
		add(textCod);
		
		textNombre=new JTextField();
		textNombre.setBounds(80, 110, 130, 25);
		add(textNombre);

		textDni=new JTextField();
		textDni.setBounds(310, 150, 120, 25);
		add(textDni);
		
		textApellido=new JTextField();
		textApellido.setBounds(290, 110, 140, 25);
		add(textApellido);
		
		textDireccion=new JTextField();
		textDireccion.setBounds(80, 150, 190, 25);
		add(textDireccion);
		
		textFecha=new JTextField();
		textFecha.setBounds(80, 180, 190, 25);
		add(textFecha);
		
		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);
		add(botonCancelar);
		add(botonGuardar);
		add(labelTitulo);
		
		
		limpiar();
		setSize(480, 300);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

	}


	private void limpiar() 
	{
		textCod.setText("");
		textNombre.setText("");
		textApellido.setText("");
		textDireccion.setText("");
		textDni.setText("");
		textFecha.setText("");

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
				miPersona.setFechaPersona(textFecha.getText());

				personaController.registrarPersona(miPersona);	
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
				System.out.println(ex);
			}
		}
		if (e.getSource()==botonCancelar)
		{
			this.dispose();
		}
	}
	
	

}
