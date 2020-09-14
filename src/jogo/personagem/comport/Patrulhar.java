package jogo.personagem.comport;

import jogo.Comportamento;
import jogo.ambiente.AccaoAmb;
import jogo.ambiente.EventoAmb;
import reaccao.Reaccao;

public class Patrulhar extends ComportHierarq {
	
	public Patrulhar () {
		super (new Comportamento[] {
									new Reaccao (EventoAmb.RUIDO, AccaoAmb.APROXIMAR),
									new Reaccao (EventoAmb.SILENCIO, AccaoAmb.PATRULHAR),
									new Reaccao (EventoAmb.INIMIGO, AccaoAmb.APROXIMAR)
									});
	}
	
}
