package Crud_Interface_Grafica;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class InterfacePrincipal extends JFrame{
	
	private JTextField nome;
	private JTextField id;
	private JTextField email;
	private JTextField telefone;
	
	InterfacePrincipal(){
		super("Sistema de Cadastro");
		criarMenu();
		opcoesMenu();
	}
	
	private void criarMenu() {
		JMenu arquivoMenu = new JMenu("Arquivo");
		JMenuItem novoItemMenu = new JMenuItem("Novo");
		arquivoMenu.add(novoItemMenu);
		JMenuItem salvarItemMenu = new JMenuItem("Salvar");
		arquivoMenu.add(salvarItemMenu);
		JMenuItem fecharItemMenu = new JMenuItem("Fechar");
		arquivoMenu.add(fecharItemMenu);
		
		JMenu sobreMenu = new JMenu("Sobre");
		JMenuItem contatoItemMenu = new JMenuItem("Contatos");
		sobreMenu.add(contatoItemMenu);
		JMenuItem quemSomosItemMenu = new JMenuItem("Quem somos?");
		sobreMenu.add(quemSomosItemMenu);
		
		JMenuBar barra = new JMenuBar();
		setJMenuBar(barra);
		barra.add(arquivoMenu);
		barra.add(sobreMenu);
	}
	
	private void opcoesMenu() {
		
		setLayout(new BorderLayout());
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(new FlowLayout());
		JLabel titulo = new JLabel("Seleciona a opção que deseja");
		titulo.setFont(new Font("Verdana", Font.PLAIN, 16));
		panelTitulo.add(titulo);
		
		JPanel panelBotoes = new JPanel();
		JButton cadastrarButton = new JButton("Cadastrar cliente");
		cadastrarAction cadastrar = new cadastrarAction();
		cadastrarButton.addActionListener(cadastrar);
		JButton atualizarButton = new JButton("Atualizar cliente");
		atualizarAction atualizar = new atualizarAction();
		atualizarButton.addActionListener(atualizar);
		JButton visualizarButton = new JButton("Visualizar clientes");
		visualizarButton.addActionListener(new apresentarAction());
		JButton excluirButton = new JButton("Excluir cliente");
		excluirAction excluir = new excluirAction();
		excluirButton.addActionListener(excluir);
		
		panelBotoes.add(cadastrarButton);
		panelBotoes.add(atualizarButton);
		panelBotoes.add(visualizarButton);
		panelBotoes.add(excluirButton);
		add(panelTitulo, BorderLayout.NORTH);
		add(panelBotoes, BorderLayout.CENTER);
		
		
		
	}
	
	private class cadastrarAction implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			 TelaCadastro telaCadastro = new TelaCadastro();
			
			//Para que a janela criada feche ao clicarmos no local para fecha-la
			  telaCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//Definindo o tamanho da tela
			  telaCadastro.setSize(415,250);
		    //Definindo que a tela esteja visivel
			  telaCadastro.setVisible(true);
			
		}
		
	} 
	
	
	private class excluirAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			TelaExcluir telaExcluir = new TelaExcluir();
			telaExcluir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			telaExcluir.setSize(230,170);
			telaExcluir.setVisible(true);
		}
	}
	
	private class atualizarAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			TelaAtualizar telaAtualizar = new TelaAtualizar();
			telaAtualizar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			telaAtualizar.setSize(400,250);
			telaAtualizar.setVisible(true);
		}
	}
	
	private class apresentarAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			TelaApresentar telaApresentar = new TelaApresentar();
			telaApresentar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			telaApresentar.setSize(250,250);
			telaApresentar.setVisible(true);
		}
	}


}
