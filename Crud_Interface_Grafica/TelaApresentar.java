package Crud_Interface_Grafica;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
public class TelaApresentar extends JFrame{
	
	private JTextField idField;
	
	TelaApresentar(){
		super("Pesquisar cliente");
		formularioApresentar();
	}
	
	private void formularioApresentar() {
		
		
		setLayout(new BorderLayout());
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(new FlowLayout());
		
		JLabel titulo = new JLabel("Pesquisar Cliente");
		titulo.setFont(new Font("Verdana", Font.PLAIN, 16));
		
		panelTitulo.add(titulo);
		
		JPanel panelCadastro = new JPanel();
		panelCadastro.setLayout(new FlowLayout());
		
		JLabel idLabel = new JLabel("ID: ");
		idField = new JTextField(20);
		
		panelCadastro.add(idLabel);
		panelCadastro.add(idField);
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setLayout(new FlowLayout());
		JButton pesquisarButton = new JButton("Pesquisar");
		pesquisarButton.addActionListener(new pesquisarAction());
		panelBotoes.add(pesquisarButton);
		
		add(panelTitulo, BorderLayout.NORTH);
		add(panelCadastro, BorderLayout.CENTER);
		add(panelBotoes, BorderLayout.SOUTH);
		
		
		
		
	}
	
	private class pesquisarAction implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			ConexaoDAO con = new ConexaoDAO();
			ResultSet resposta = con.apresentarSQL(idField);
			try {
				while(resposta.next()) {
					int id = resposta.getInt("id");
					String nome = resposta.getString("nome");
					String email = resposta.getString("email");
					long telefone = resposta.getLong("telefone");
					String[] nomeColunas = {"ID","NOME","EMAIL","TELEFONE"};
					Object[][] dados = {{id,nome,email,telefone}};
					JTable jtable = new JTable(dados,nomeColunas);
					JFrame jframe = new JFrame();
					jframe.setSize(550,70);
					jframe.add(jtable);
					jframe.setVisible(true);
					System.out.println(id + " - " + nome + " - " + email + " - " + telefone);}
			}catch(Exception erro) {
				erro.printStackTrace();
			}
		}
	}
}
