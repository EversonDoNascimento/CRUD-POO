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
public class TelaExcluir extends JFrame {
		private JTextField idField;

		TelaExcluir(){
			super("Excluir cliente");
			formularioExclusao();
			
		}
		
		private void formularioExclusao() {
			
			setLayout(new BorderLayout());
			JPanel panelTitulo = new JPanel();
			panelTitulo.setLayout(new FlowLayout());
			JLabel titulo = new JLabel("Excluir Cliente");
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
			JButton excluirButton = new JButton("Excluir");
			deletarAction delete = new deletarAction();
			excluirButton.addActionListener(delete);
			
			panelBotoes.add(excluirButton);
			
			
			add(panelTitulo, BorderLayout.NORTH);
			add(panelCadastro, BorderLayout.CENTER);
			add(panelBotoes, BorderLayout.SOUTH);
			
		}
		
		private class deletarAction implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				ConexaoDAO conn = new ConexaoDAO();
				String sql = "DELETE FROM cliente WHERE id = ?";
				int resultado = conn.deleteSQL(sql, idField);
				if(resultado == 1) {
					JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!", "Excluir Cliente", JOptionPane.PLAIN_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Erro durante a exclusão!", "Excluir Cliente", JOptionPane.PLAIN_MESSAGE);
				}
			} 
			
		}
		
		
	
}
