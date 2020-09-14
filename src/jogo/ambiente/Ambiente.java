package jogo.ambiente;

import java.util.HashMap;
import java.util.Scanner;

public class Ambiente {
	
	private EventoAmb evento;
	private HashMap<String, EventoAmb> eventos;
	Scanner s;
	
	public Ambiente () {
		s = new Scanner (System.in);
		eventos = new HashMap<String, EventoAmb>();
		eventos.put("D", EventoAmb.DERROTA);
		eventos.put("V", EventoAmb.VITORIA);
		eventos.put("R", EventoAmb.RUIDO);
		eventos.put("I", EventoAmb.INIMIGO);
		eventos.put("S", EventoAmb.SILENCIO);
		eventos.put("F", EventoAmb.FUGA);
		eventos.put("T", EventoAmb.TERMINAR);
	}
	
	public void evoluir () {
		evento = gerarEvento ();
		mostrar ();
	}
	
	private EventoAmb gerarEvento() {
		System.out.println("Insira o evento: ");
		return eventos.get(s.next());
	}

	private void mostrar() {
		System.out.println("Evento: " + evento);
	}

	public EventoAmb getEvento () {
		return evento;
	}
	
}
