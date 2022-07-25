package entidades;

import java.util.ArrayList;

public class Usuario {

	// Atributos
	private String nome;
	private String email;
	private String cpf;
	private int id;
	static int nextId = 0;
	private ArrayList<Pruu> pruus;
	static private ArrayList<Usuario> users = new ArrayList<Usuario>();

	@SuppressWarnings("static-access")
	public Usuario(String nome, String email, String cpf) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.id = nextId;
		nextId++;
		this.pruus = new ArrayList<Pruu>();
		this.users.add(this);
	}

	public static ArrayList<Usuario> getUsers() {
		return users;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getId() {
		return id;
	}

	public ArrayList<Pruu> getPruus() {
		return pruus;
	}

	public void setPruus(ArrayList<Pruu> pruus) {
		this.pruus = pruus;
	}

	// M�todo em que usu�rio cria um Pruu
	public void pruuzar(String text) {
		if (text == null || text.length() > 300 || text.trim().length() < 1) {
			System.out.println("Pruu inv�lido.");
			return;
		} else {
			Pruu pruu = new Pruu(text);
			pruu.setUsuario(this);
			pruus.add(pruu);
		}
	}

	// Sobrecarga
	// O usu�rio d� like selecionando um objeto pruu
	public void like(Pruu pruu) {
		if (pruu.isBlocked() == true) {
			System.out.println("Este Pruu est� bloqueado e n�o pode receber likes.");
		} else {
			pruu.addLike();
		}
	}

	// Sobrecarga
	// O usu�rio d� like selecionando o id do pruu
	public void like(int id) {
		Pruu pruuLike = this.findPruuId(id);
		
		if (pruuLike.isBlocked() == true) {
			System.out.println("Este Pruu est� bloqueado e n�o pode receber likes.");
		} else if (pruuLike.isBlocked() == false) {
			pruuLike.addLike();
		} else {
			System.out.println("Pruu n�o encontrado.");
		}
	}

	@Override
	public String toString() {
		return nome + ". IdUser: " + id + ".";
	}

	public void verMeusPruus() {
		for (int i = 0; i < pruus.size(); i++) {
			System.out.println(pruus.get(i).toString());
		}

	}

	/*
	 * Procura os pruus de um usu�rio pelo userName Pensado para fazer busca quando
	 * n�o se sabe ao certo o nome do usu�rio ou se quer saber do id do usu�rio
	 * desejado
	 */

	public void verPruusDe(String userName) {
		ArrayList<Integer> index = new ArrayList<Integer>(); // Cria uma lista de users Id onde foi encontrado userName
		userName = userName.toLowerCase();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getNome().toLowerCase().indexOf(userName) != -1) {
				index.add(users.get(i).getId());
			}
		}
		if (index.size() == 1) // Aqui est� o Id, se apenas um usu�rio foi encontrado
		{

			int j = 0;
			while (users.get(j).getId() != index.get(0) && j < users.size()) // Procurar o �ndice de qual usu�rio tem
																				// esse id
			{
				j++;
			}

			System.out.println("1 Usu�rio encontrado. Nome: " + users.get(j).getNome());

			for (int i = 0; i < users.get(j).getPruus().size(); i++) {
				System.out.println(users.get(j).getPruus().get(i).toString());
			}
		} else if (index.size() > 1) // Mostra nome dos usu�rios (por Id) cujo nome cont�m userName
		{
			System.out.println("Esta � a lista de usu�rio encontrados com: " + userName);
			for (int k = 0; k < index.size(); k++) {
				int i = 0;
				while (users.get(i).getId() != index.get(k) && i < users.size()) {
					i++;
				}
				System.out.println("Usu�rio:" + users.get(i).getNome());
			}
		} else {
			System.out.println("Nenhum usu�rio encontrado com o nome de " + userName + ".");
		}
	}

	public void verPruusDe(int id) {
		int i = 0;
		while (users.get(i).getId() != id && i < users.size()) {
			i++;
		}
		for (int j = 0; j < users.get(i).getPruus().size(); j++) {
			System.out.println(users.get(i).getPruus().get(j).toString());
		}
	}

	public static void verTodosPruus() {
		for (int i = 0; i < users.size(); i++) {
			for (int j = 0; j < users.get(i).getPruus().size(); j++) {
				System.out.println(users.get(i).getPruus().get(j).toString());
			}
		}
	}

	public void verPruu(int id) {
		System.out.println(findPruuId(id).toString());
	}

	public Pruu findPruuId(int id) {
		for (int i = 0; i < Usuario.getUsers().size(); i++) {
			for (int j = 0; j < Usuario.getUsers().get(i).getPruus().size(); j++) {
				Pruu Pruu = Usuario.getUsers().get(i).getPruus().get(j);
				if (Pruu.getId() == id) {
					return Pruu;
				}
			}
		}
		return null;
	}

}
