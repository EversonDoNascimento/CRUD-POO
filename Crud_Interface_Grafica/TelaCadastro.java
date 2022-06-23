package Crud_Interface_Grafica;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastro extends JFrame {
	
	private JTextField nomeField;
	//private JTextField idField;
	private JTextField emailField;
	private JTextField telefoneField;
	

	TelaCadastro(){
		super("Cadastrar Cliente");
		formularioCadastro();
	}
	
	private void formularioCadastro() {
		
		setLayout(new BorderLayout());
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(new FlowLayout());
		
		JLabel titulo = new JLabel("Cadastro de Contato");
		titulo.setFont(new Font("Verdana", Font.PLAIN, 16));
		
		panelTitulo.add(titulo);
		

		JPanel panelCadastro = new JPanel();
		panelCadastro.setLayout(new FlowLayout());
		
		//JLabel idLabel = new JLabel("Id: ");
		//idField = new JTextField(30);
		
		
		JLabel nomeLabel = new JLabel("Nome: ");
		nomeField = new JTextField(30);
		
		JLabel emailLabel = new JLabel("Email: ");
		emailField = new JTextField(30);
		
		JLabel telefoneLabel = new JLabel("Telefone: ");
		telefoneField = new JTextField(30);
		
		//panelCadastro.add(idLabel);
		//panelCadastro.add(idField);
		panelCadastro.add(nomeLabel);
		panelCadastro.add(nomeField);
		panelCadastro.add(emailLabel);
		panelCadastro.add(emailField);
		panelCadastro.add(telefoneLabel);
		panelCadastro.add(telefoneField);
		
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setLayout(new FlowLayout());
		
		JButton botaoSalvar = new JButton("Salvar");
		cadastrarAction cadastrar = new cadastrarAction();
		botaoSalvar.addActionListener(cadastrar);
		
		panelBotoes.add(botaoSalvar);
		
		
		add(panelTitulo, BorderLayout.NORTH);
		add(panelCadastro, BorderLayout.CENTER);
		add(panelBotoes, BorderLayout.SOUTH);
		
		
		
	}
	
	public class cadastrarAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ConexaoDAO conn = new ConexaoDAO();
			String adicionarSQL = "SELECT nextval('sequence_id'); INSERT INTO cliente (id,nome,email,telefone)" 
					+ "VALUES(nextval('sequence_id'),?,?,?)";
			
			int resultado = conn.criarSQL(adicionarSQL,nomeField,emailField,telefoneField);
			if(resultado == 1) {
				JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso", "Cadastro", JOptionPane.PLAIN_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "Erro durante o Cadastro!!", "Cadastro", JOptionPane.PLAIN_MESSAGE);
			}
		} 
	}
	

}
