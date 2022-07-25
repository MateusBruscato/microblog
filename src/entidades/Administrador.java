package entidades;

public class Administrador extends Usuario {

	public Administrador(String nome, String email, String cpf) {
		super(nome, email, cpf);
	}

	public void blockPruu(Pruu pruu) {
		if (pruu.isBlocked() == false) {
			pruu.setBlocked(true);
			System.out.println("Pruu bloqueado.");
		} else {
			System.out.println("Este Pruu já está bloqueado.");
		}
	}

	public void blockPruu(int id) {
		Pruu pruuBlock = this.findPruuId(id);
		if (pruuBlock.isBlocked() == false) {
			pruuBlock.setBlocked(true);
			System.out.println("Pruu bloqueado.");
		} else {
			System.out.println("Este Pruu já está bloqueado.");
		}
	}
	
	public void verPruu(int id) {
		System.out.println(findPruuId(id).toStringAdm());
	}
}
