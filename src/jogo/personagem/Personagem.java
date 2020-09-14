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
	 * 		Parâmetro necessário de modo a saber o evento em execução
	 */
	public Personagem (Ambiente ambiente) {
		this.ambiente = ambiente;
		this.comport = new ComportPersonagem ();
	}
	
	public void executar () {
		estimulo = precepcionar (); // Recolhe o estímulo/evento do ambiente (precepciona)
		resposta = processar (estimulo); // Gera uma suposta ação para o estímulo
		actuar (resposta); // Atua com a determinada ação
		mostrar ();
	}

	/**
	 * Retorna o evento em questão
	 */
	private Estimulo precepcionar() {
		return ambiente.getEvento();		
	}
	
	/**
	 * Retorna a ação correspondente ao estimulo
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
