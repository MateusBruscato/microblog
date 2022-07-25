package callers;

import entidades.Administrador;
import entidades.Usuario;

public class Principal {

	public static void main(String[] args) {

		// OBSERVA��O: Alguns m�todos d�o retorno void e simplesmente
		// Executar o comando System.out.println();
		// � uma altera��o simples de ser feita

		// Usu�rios criados com 2 ou mais Pruus cada
		Usuario mateus = CriandoUsers.criarMateus();
		Usuario matias = CriandoUsers.criarMatias();
		Usuario larissa = CriandoUsers.criarLarissa();
		Administrador jorge = CriandoUsers.criarJorge();

		// M�todo static de classe usu�rio para ver todos os Pruus
		Usuario.verTodosPruus();
		CriandoUsers.printLine();
		
		// Maneiras de ver todos os pruus de um usu�rio
		// 1 - O usu�rio v� todos os seus Pruus
		mateus.verMeusPruus();
		CriandoUsers.printLine();
		
		// 2 - O usu�rio busca pelo usu�rio atrav�s do username
		// Note que o m�todo verPruusDe n�o necessita do nome completo do usu�rio (ver
		// implementa��o)
		matias.verPruusDe("lari");
		CriandoUsers.printLine();

		// O usu�rio pode dar like selecionando um pruu ou ao listar os pruus, dar like
		// atrav�s do user Id
		mateus.like(matias.getPruus().get(0));
		mateus.like(10);

		// O usu�rio pode bloquear um pruu selecionando manualmente ou ao listar os
		// pruus, bloquear atrav�s do user Id
		jorge.blockPruu(mateus.getPruus().get(0));
		jorge.blockPruu(4);

		matias.verPruu(4);
		jorge.verPruu(4);
		larissa.verPruu(10);
		larissa.verPruu(3);
		CriandoUsers.printLine();

	}

}
