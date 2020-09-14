package maquest;

import java.util.HashMap;

public class Estado <EV>{
	
	private String nome;
	HashMap <EV, Estado<EV>> transicoes;
	
	public Estado (String nome) {
		this.nome = nome;
		transicoes = new HashMap<>();
	}
	
	public String getNome () {
		return nome;
	}
	
	/**
	 * Com este método deve-se declarar as transições da a máquina de estados
	 * 
	 * @param evento
	 * 		Evento
	 * @param estado
	 * 		Estado a corresponder ao evento
	 * @return
	 */
	public Estado<EV> transicao (EV evento, Estado<EV> estado) {
		transicoes.put(evento, estado);
		return this;
	}
	
	
	/**
	 * Retorna o estado através do evento
	 * @param evento
	 * @return
	 */
	public Estado<EV> processar (EV evento) {
		return transicoes.get(evento);
	}
	
	public String toString () {
		return "Estado: " + nome;
	}
	
}
