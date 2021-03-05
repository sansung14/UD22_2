package Backend.PatronMVC.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Backend.PatronMVC.model.conexion.Conexion;
import Backend.PatronMVC.model.dto.Video;

public class VideoDao {

	public void registrarVideo(Video miVideo)
	{
		Conexion conex= new Conexion();
		
		try {
			Statement st = conex.getConnection().createStatement();
			String sql= "INSERT INTO videos VALUES ('"+miVideo.getIdVideo()+"', '"
					+miVideo.getTitle()+"', '"+miVideo.getDirector()+"', '"
					+miVideo.getCli_id()+"');";
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
			System.out.println(sql);
			st.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null,"El codigo del video ya existe","Advertencia",JOptionPane.WARNING_MESSAGE);

		}
	}

	public Video buscarVideo(int codigo) 
	{
		Conexion conex= new Conexion();
		Video video= new Video();
		boolean existe=false;
		try {
			String sql= "SELECT * FROM videos where id = ? ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
			consulta.setInt(1, codigo);
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				existe=true;
				video.setIdVideo(Integer.parseInt(res.getString("id")));
				video.setTitle(res.getString("title"));
				video.setDirector(res.getString(("director")));
				video.setCli_id(Integer.parseInt(res.getString("cli_id")));
			 }
			res.close();
			conex.desconectar();
			System.out.println(sql);
					
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
			}
		
			if (existe) {
				return video;
			}
			else return null;				
	}

	public void modificarVideo(Video miVideo) {
		
		Conexion conex= new Conexion();
		try{
			String consulta="UPDATE videos SET id= ? ,title = ? , director=? , cli_id=?  WHERE id= ? ";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
			
            estatuto.setInt(1, miVideo.getIdVideo());
            estatuto.setString(2, miVideo.getTitle());
            estatuto.setString(3, miVideo.getDirector());
            estatuto.setInt(4,miVideo.getCli_id());
            estatuto.setInt(5,miVideo.getIdVideo());
            estatuto.executeUpdate();
            
          JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Confirmación",JOptionPane.INFORMATION_MESSAGE);
          System.out.println(consulta);
         

        }catch(SQLException	 e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);

        }
	}

	public void eliminarVideo(String codigo)
	{
		Conexion conex= new Conexion();
		try {
			String sql= "DELETE FROM videos WHERE id='"+codigo+"'";
			Statement st = conex.getConnection().createStatement();
			st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, " Se ha Eliminado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);
            System.out.println(sql);
			st.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Elimino");
		}
	}

	
}
