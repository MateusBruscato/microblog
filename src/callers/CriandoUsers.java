package callers;

import entidades.Administrador;
import entidades.Usuario;

public class CriandoUsers {

	public static Usuario criarMateus() {
		Usuario mateus = new Usuario("Mateus", "Mateus@gmail.com", "123");
		mateus.pruuzar("Este � o primeiro pruu");
		mateus.pruuzar("Sei que nada sei.");
		mateus.pruuzar("Se era rua fosse minha...");

		return  mateus;
	}
	
	public static Usuario criarMatias() {
		Usuario matias = new Usuario("Matias", "matias@gmail.com", "456");
		matias.pruuzar("#sextou");
		matias.pruuzar("Dia lindo pra passear");
		matias.pruuzar("� hoje que eu s� volto amanh�");
		
		return  matias;
	}
	
	public static Usuario criarLarissa() {
		Usuario larissa = new Usuario("Larissa", "larissa@gmail.com", "789");

		larissa.pruuzar("Hoje � um novo dia, de um novo tempo que come�ou...");
		larissa.pruuzar("Voc�s t�o assistindo Pantanal?");
		larissa.pruuzar("Gente, que s�rie � essa da netflix??");
		
		return  larissa;
	}
	
	public static Administrador criarJorge() {
		Administrador jorge = new Administrador("Jorge", "jorge@pruu.com", "678");
		jorge.pruuzar("Tem uma galera a� se passando nos pruus");
		jorge.pruuzar("Cada um sabe onde o sapato aperta...");
		
		return jorge;
	}
	
	public static void printLine() {
		System.out.println("--------------------------");
	}
	
}

