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

public class TelaAtualizar extends JFrame{
		//private JTextField nomeAtrField;
		private JTextField nomeNovoField;
		private JTextField idField;
		//private JTextField nomeAtrCondicaoField;
		TelaAtualizar(){
			super("Atualize Cadastro");
			formularioAtualizacao();
		}
		
		private void formularioAtualizacao(){
			
			setLayout(new BorderLayout());
			JPanel panelTitulo = new JPanel();
			panelTitulo.setLayout(new FlowLayout());
			JLabel titulo = new JLabel("Atualizar Cliente");
			titulo.setFont(new Font("Verdana", Font.PLAIN, 16));
			panelTitulo.add(titulo);
			
			JPanel panelCadastro = new JPanel();
			panelCadastro.setLayout(new FlowLayout());
			
			//JLabel nomeAtrLabel = new JLabel("Nome atributo: ");
			//nomeAtrField = new JTextField(20);
			
			JLabel nomeNovoLabel = new JLabel("Novo nome: ");
			nomeNovoField = new JTextField(20);
			
			//JLabel nomeAtrCondicaoLabel = new JLabel("Nome atributo Cond.");
			//nomeAtrCondicaoField = new JTextField(20);
			
			JLabel idLabel = new JLabel("ID do cliente: ");
			idField = new JTextField(20);
			
		
			panelCadastro.add(nomeNovoLabel);
			panelCadastro.add(nomeNovoField);
			panelCadastro.add(idLabel);
			panelCadastro.add(idField);
			
			JPanel panelBotoes = new JPanel();
			panelBotoes.setLayout(new FlowLayout());
			JButton atualizarButton = new JButton("Atualizar");
			atualizarAction atualizar = new atualizarAction();
			atualizarButton.addActionListener(atualizar);
			
			panelBotoes.add(atualizarButton);
			
			add(panelTitulo, BorderLayout.NORTH);
			add(panelCadastro, BorderLayout.CENTER);
			add(panelBotoes, BorderLayout.SOUTH);
			
			
		}
		
		private class atualizarAction implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				ConexaoDAO conn = new ConexaoDAO();
				String adicionarSQL = "UPDATE cliente set nome = ? WHERE id = ?";
				int resposta = conn.updateSQL(adicionarSQL,nomeNovoField,idField);
				if(resposta == 1) {
					JOptionPane.showMessageDialog(null, "Update realizado com sucesso!", "Atualizar Cadastro", JOptionPane.PLAIN_MESSAGE);
				}else {
					
					JOptionPane.showMessageDialog(null, "Erro durante a atualização!", "Atualizar Cadastro", JOptionPane.PLAIN_MESSAGE);
					
				}
				
			}
		}
}
