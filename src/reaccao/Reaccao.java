package reaccao;

import jogo.Comportamento;

public class Reaccao implements Comportamento {
	
	private Estimulo estimulo;
	private Accao resposta;
	
	public Reaccao (Estimulo estimulo,
						Accao resposta) {
		this.estimulo = estimulo;
		this.resposta = resposta;
	}
	
	/**
	 * Este método ativa o comportamento apenas se o estimulo for do mesmo
	 */
	public Accao activar (Estimulo estimulo) {
		return (estimulo == this.estimulo) ? resposta : null;
	}
	
}
