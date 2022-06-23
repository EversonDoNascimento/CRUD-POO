package Crud_Interface_Grafica;

public class teste {
	
	public int id;
	public String nome;
	public String email;
	public Long telefone;
	
	teste(int id, String nome, String email, Long telefone){
		setId(id);
		setNome(nome);
		setEmail(email);
		setTelefone(telefone);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}
	public static void main(String[] args) {
		
		ConexaoDAO conn = new ConexaoDAO();
		String adicionarSQL = "INSERT INTO cliente (id,nome,email,telefone) "
				+ "VALUES(?,?,?,?)";
		int resultado = conn.criarSQL(adicionarSQL);
		if(resultado == 1) {
			System.out.println("Cliente Cadastrado!!");
		}else {
			System.out.println("Erro durante o Cadastro!!");
		}
	}
	

}
