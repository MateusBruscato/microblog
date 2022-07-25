package callers;

import entidades.Administrador;
import entidades.Usuario;

public class Principal {

	public static void main(String[] args) {

		// OBSERVAÇÂO: Alguns métodos dão retorno void e simplesmente
		// Executar o comando System.out.println();
		// É uma alteração simples de ser feita

		// Usuários criados com 2 ou mais Pruus cada
		Usuario mateus = CriandoUsers.criarMateus();
		Usuario matias = CriandoUsers.criarMatias();
		Usuario larissa = CriandoUsers.criarLarissa();
		Administrador jorge = CriandoUsers.criarJorge();

		// Método static de classe usuário para ver todos os Pruus
		Usuario.verTodosPruus();
		CriandoUsers.printLine();
		
		// Maneiras de ver todos os pruus de um usuário
		// 1 - O usuário vê todos os seus Pruus
		mateus.verMeusPruus();
		CriandoUsers.printLine();
		
		// 2 - O usuário busca pelo usuário através do username
		// Note que o método verPruusDe não necessita do nome completo do usuário (ver
		// implementação)
		matias.verPruusDe("lari");
		CriandoUsers.printLine();

		// O usuário pode dar like selecionando um pruu ou ao listar os pruus, dar like
		// através do user Id
		mateus.like(matias.getPruus().get(0));
		mateus.like(10);

		// O usuário pode bloquear um pruu selecionando manualmente ou ao listar os
		// pruus, bloquear através do user Id
		jorge.blockPruu(mateus.getPruus().get(0));
		jorge.blockPruu(4);

		matias.verPruu(4);
		jorge.verPruu(4);
		larissa.verPruu(10);
		larissa.verPruu(3);
		CriandoUsers.printLine();

	}

}
