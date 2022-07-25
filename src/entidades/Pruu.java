package entidades;

import java.util.Date;

public class Pruu {

	// Atributos
	private String texto;
	@SuppressWarnings("unused")
	private Date dataCriacao;
	private int likes;
	private boolean blocked;
	private Usuario usuario;
	private int id;
	private static int nextId;

	public Pruu(String texto) {
		super();
		this.texto = texto;
		this.dataCriacao = new Date();
		this.blocked = false;
		this.id = nextId;
		nextId++;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTexto() {
		if (this.blocked) {
			return "Este pruu está bloqueado";
		} else {
			return texto;
		}
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public void addLike() {
		this.likes++;
	}

	public int getLikes() {
		return likes;
	}

	public int getId() {
		return id;
	}
	
	public String geTextoAdm() {
		return this.texto;
	}

	@Override
	public String toString() {
		return "Id: " + this.id + ", Pruu: " + this.getTexto() + ". Likes: " + likes + ".";
	}
	
	public String toStringAdm() {
		return "Id: " + this.id + ", Pruu: " + this.geTextoAdm() + ". Likes: " + likes + ".";
	}

}
