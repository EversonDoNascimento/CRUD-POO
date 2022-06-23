package Crud_Interface_Grafica;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;


public class ConexaoDAO { 
	private String url;
	private String usuario;
	private String senha;
	private Connection con;
	
	
	
	ConexaoDAO(){
		url = "jdbc:postgresql://localhost:5432/BancoPOO";
		usuario = "postgres";
		senha = "postgres";
		
		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url,usuario,senha);
			System.out.println("Conexão realizada com sucesso!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int criarSQL(String sql, JTextField nome, JTextField email, JTextField telefone) {
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			//int idConvert = Integer.parseInt(id.getText());
			String nomeConvert = nome.getText();
			String emailConvert = email.getText();
			long telefoneConvert = Long.parseLong(telefone.getText());
			//pstm.setInt(1,idConvert );
			pstm.setString(1,nomeConvert);
			pstm.setString(2,emailConvert);
			pstm.setLong(3,telefoneConvert);
			
			pstm.execute();
			pstm.close();
            return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
			
		}
		
	}
	
	public int updateSQL(String sql, JTextField nomeNovoField, JTextField idField  ) {
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			
			//int nomeAtrConvert = Integer.parseInt(nomeAtrField.getText());
			//String nomeAtrConvert = nomeAtrField.getText();
			String nomeNovoConvert = nomeNovoField.getText();
			//String nomeAtrCondConvert = nomeAtrCondField.getText();
			int idConvert = Integer.parseInt(idField.getText());
			//long telefoneConvert = Long.parseLong(telefone.getText());
			//pstm.setString(1,nomeAtrConvert );
			pstm.setString(1,nomeNovoConvert);
			//pstm.setString(3,nomeAtrCondConvert);
			pstm.setInt(2,idConvert);
			
			pstm.execute();
			pstm.close();
            return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int deleteSQL(String sql, JTextField id) {
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			int idConvert = Integer.parseInt(id.getText());
			pstm.setInt(1,idConvert );
			pstm.execute();
			pstm.close();
            return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
			
		}
	}
	
	public ResultSet apresentarSQL( JTextField idText) {
		
		try {
			
			int idConvert = Integer.parseInt(idText.getText());
			String sql = "SELECT id, nome , email, telefone "
					   + "FROM cliente "
					   + "WHERE id = " + idConvert;
			Statement stm = con.createStatement();
			ResultSet resposta = stm.executeQuery(sql);
			con.close();
			return resposta;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}




