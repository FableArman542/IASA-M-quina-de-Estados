package jogo.personagem.comport;

import java.util.HashMap;

import jogo.Comportamento;
import maquest.Estado;
import maquest.MaquinaEstados;
import reaccao.Accao;
import reaccao.Estimulo;

public abstract class ComportMaqEst implements Comportamento {
	
	private MaquinaEstados<Estimulo> maqEst;
	private HashMap <Estado<Estimulo>, Comportamento> comportamentos;
	
	public ComportMaqEst () {
		comportamentos = new HashMap <Estado<Estimulo>, Comportamento>();
		maqEst = iniciar();
	}
	
	public Estado<Estimulo> getEstado () {
		return maqEst.getEstado();
	}
	
	abstract protected MaquinaEstados<Estimulo> iniciar ();
	
	public Accao activar (Estimulo estimulo) {
		// Receber a reação atual COM O ESTADO ATUAL
		Comportamento compAtual = comportamentos.get(this.getEstado());
		// Ativar o estimulo recolhendo a ação
		Accao accaoAtual = compAtual.activar(estimulo);
		// Processa o estimulo transicionando de estado
		maqEst.processar(estimulo);
		return accaoAtual;
	}
	
	
	/**
	 * Método com o intuito de relacionar comportamentos com estados
	 * através de um dicionário
	 * @param estado
	 * @param comport
	 * @return
	 */
	public ComportMaqEst comport (Estado<Estimulo> estado,
									Comportamento comport) {
		comportamentos.put(estado, comport);
		return this;
	}
	
	
}
