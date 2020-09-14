package jogo;

import jogo.ambiente.Ambiente;
import jogo.ambiente.EventoAmb;
import jogo.personagem.Personagem;

public class Jogo {
	
	private static Ambiente ambiente = new Ambiente ();
	private static Personagem personagem = new Personagem (ambiente);
	private static EventoAmb evento;
	
	/*
	 * .Ciclo inicial do jogo
	 * 	Primeiramente a personagem é executada
	 * 	e, de seguida é evoluido o ambiente
	 * 
	 * .Conforme o evento no ambiente, o personagem reage com uma ação
	 */
	private static void executar () {
		do {
			personagem.executar();
			ambiente.evoluir();
			evento = ambiente.getEvento();
		} while (evento != EventoAmb.TERMINAR);
	}
	
	public static void main (String args[]) {
		executar (); // Executar o jogo
	}
	
}
