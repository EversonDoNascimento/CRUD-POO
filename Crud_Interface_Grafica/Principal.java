package Crud_Interface_Grafica;

import javax.swing.JFrame;

//import InterfaceGui.InterfacePrincipal;

public class Principal {

	public static void main(String[] args) {
		
		
		/*
	TelaCadastro telaCadastro = new TelaCadastro();
		
		//Para que a janela criada feche ao clicarmos no local para fecha-la
		  telaCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Definindo o tamanho da tela
		  telaCadastro.setSize(600,400);
	    //Definindo que a tela esteja visivel
		  telaCadastro.setVisible(true);
		
		
		String variavel = "Everson";
		Integer number = 1;
		*/
		
		InterfacePrincipal interfacePrincipal = new InterfacePrincipal();
		interfacePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		interfacePrincipal.setSize(400,400);
		interfacePrincipal.setVisible(true);
		
		/*
		InterfacePrincipal interfaceprincipal = new InterfacePrincipal();
		
		//Para que a janela criada feche ao clicarmos no local para fecha-la
		  interfaceprincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Definindo o tamanho da tela
		  interfaceprincipal.setSize(430,200);
	    //Definindo que a tela esteja visivel
		  interfaceprincipal.setVisible(true);
		*/
		
	    /*
		String nome = "Everton";
		String email = "everson@hotmail";
		long telefone = 95956057579L;
		int id = 10;
		ConexaoDAO conn = new ConexaoDAO();
		String adicionarSQL = "INSERT INTO cliente (id,nome,email,telefone) "
			+ "VALUES(?,?,?,?)";
		
		System.out.println(adicionarSQL);
		int resultado = conn.criarSQL(adicionarSQL);
		if(resultado > 0) {
			System.out.println("Cadastrado com sucesso!");
		}else {
			System.err.println("Erro durante o cadastro!");
		}*/
		/*
		ConexaoDAO conn = new ConexaoDAO();
		String sql = "update cliente set nome='Roberto Silva' where nome = 'Michael Sam'";
		int resultado = conn.updateSQL(sql);
		if(resultado > 0) {
			System.out.println("Update realizado com sucesso!");
		}else {
			System.err.println("Erro durante o Update!");
			}
		
		
	}
		
		ConexaoDAO conn = new ConexaoDAO();
		String sql = "DELETE FROM cliente WHERE id = 3";
		int resultado = conn.updateSQL(sql);
		if(resultado > 0) {
			System.out.println("Deletado com sucesso!");
		}else {
			System.err.println("Erro durante a remoção");
			}
		
		
	}
		
		ConexaoDAO con = new ConexaoDAO();
		String sql = "SELECT * FROM cliente";
		ResultSet resposta = con.apresentarSQL(sql);
		try {
			while(resposta.next()) {
				int id = resposta.getInt("id");
				String nome = resposta.getString("nome");
				String email = resposta.getString("email");
				long telefone = resposta.getLong("telefone");
				System.out.println(id + " - " + nome + " - " + email + " - " + telefone);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
	}	

}
