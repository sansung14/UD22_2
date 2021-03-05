package Backend.PatronMVC.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Backend.PatronMVC.controller.VideoController;
import Backend.PatronMVC.model.dto.Video;

public class VentanaRegistroVideo extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private VideoController videoController; //objeto personaController que permite la relacion entre esta clase y la clase personaController
	private JTextField textCod,textTitle,textDirector,textCli_id;
	private JLabel labelTitulo, cod, title,director,cli_id;
	private JButton botonGuardar,botonCancelar;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistroVideo frame = new VentanaRegistroVideo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaRegistroVideo() {
	
		
		cod = new JLabel("Codigo");
		cod.setBounds(34, 73, 46, 14);
		getContentPane().add(cod);
		
		title = new JLabel("Titulo");
		title.setBounds(35, 101, 46, 14);
		getContentPane().add(title);
		
		director = new JLabel("Director");
		director.setBounds(34, 129, 46, 14);
		getContentPane().add(director);
		
		cli_id = new JLabel("Codigo Cliente");
		cli_id.setBounds(34, 157, 83, 14);
		getContentPane().add(cli_id);
		
		textCod = new JTextField();
		textCod.setBounds(120, 70, 63, 20);
		getContentPane().add(textCod);
		textCod.setColumns(10);
		
		textTitle = new JTextField();
		textTitle.setBounds(120, 98, 130, 20);
		getContentPane().add(textTitle);
		textTitle.setColumns(10);
		
		textDirector = new JTextField();
		textDirector.setBounds(121, 126, 130, 20);
		getContentPane().add(textDirector);
		textDirector.setColumns(10);
		
		textCli_id = new JTextField();
		textCli_id.setBounds(120, 154, 72, 20);
		getContentPane().add(textCli_id);
		textCli_id.setColumns(10);
		
		labelTitulo = new JLabel("Registrar Video");
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelTitulo.setBounds(34, 34, 130, 14);
		getContentPane().add(labelTitulo);
		
		botonGuardar = new JButton("Registrar");
		botonGuardar.setBounds(34, 201, 89, 23);
		getContentPane().add(botonGuardar);
		
		botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(144, 201, 89, 23);
		getContentPane().add(botonCancelar);
		
		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);
		
		limpiar();

		
		setSize(311, 278);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
	}

	

	private void limpiar() 
	{
		textCod.setText("");
		textTitle.setText("");
		textDirector.setText("");
		textCli_id.setText("");

	}

	public void setCoordinador(VideoController videoController) {
		this.videoController=videoController;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				Video miVideo=new Video();
				miVideo.setIdVideo(Integer.parseInt(textCod.getText()));
				miVideo.setTitle(textTitle.getText());
				miVideo.setDirector(textDirector.getText());
				miVideo.setCli_id(Integer.parseInt(textCli_id.getText()));

				videoController.registrarVideo(miVideo);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
				System.out.println(e2);

			}
		}
		if (e.getSource()==botonCancelar)
		{
			this.dispose();
		}
	}
	
}
