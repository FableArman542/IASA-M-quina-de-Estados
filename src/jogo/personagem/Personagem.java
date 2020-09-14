package jogo.personagem;

import jogo.ambiente.Ambiente;
import jogo.personagem.comport.ComportPersonagem;
import reaccao.Accao;
import reaccao.Estimulo;

public class Personagem {
	
	private Estimulo estimulo;
	private Accao resposta;
	private Ambiente ambiente;
	private ComportPersonagem comport;
	
	/**
	 * CONSTRUTOR
	 * @param ambiente
	 * 		Par�metro necess�rio de modo a saber o evento em execu��o
	 */
	public Personagem (Ambiente ambiente) {
		this.ambiente = ambiente;
		this.comport = new ComportPersonagem ();
	}
	
	public void executar () {
		estimulo = precepcionar (); // Recolhe o est�mulo/evento do ambiente (precepciona)
		resposta = processar (estimulo); // Gera uma suposta a��o para o est�mulo
		actuar (resposta); // Atua com a determinada a��o
		mostrar ();
	}

	/**
	 * Retorna o evento em quest�o
	 */
	private Estimulo precepcionar() {
		return ambiente.getEvento();		
	}
	
	/**
	 * Retorna a a��o correspondente ao estimulo
	 * Encontra-se na classe Reaccao
	 */
	private Accao processar (Estimulo estimulo) {
		return comport.activar(estimulo);
	}
	
	private void actuar (Accao accao) {
		if (accao != null) accao.executar();
	}
	
	private void mostrar () {
		System.out.println(comport.getEstado());
	}

}
