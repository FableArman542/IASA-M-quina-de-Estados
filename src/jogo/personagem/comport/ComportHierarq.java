package jogo.personagem.comport;

import jogo.Comportamento;
import reaccao.Accao;
import reaccao.Estimulo;

public class ComportHierarq implements Comportamento {

	private Comportamento comportamentos[];
	
	public ComportHierarq (Comportamento comportamentos[]) {
		this.comportamentos = comportamentos;
	}
	
	/**
	 * Ativa os comportamentos de forma hierárquica
	 * (O que está primeiro no array tem mais prioridade)
	 */
	public Accao activar (Estimulo estimulo) {
		for (int i = 0; i < comportamentos.length; ++i) {
			if (comportamentos[i].activar(estimulo) != null)
				return comportamentos[i].activar(estimulo);
		}
		return null;
	}
	
}
