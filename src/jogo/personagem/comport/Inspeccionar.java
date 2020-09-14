package jogo.personagem.comport;

import jogo.Comportamento;
import jogo.ambiente.AccaoAmb;
import jogo.ambiente.EventoAmb;
import reaccao.Reaccao;

public class Inspeccionar extends ComportHierarq {
	
	public Inspeccionar () {
		super (new Comportamento[] {new Reaccao (EventoAmb.RUIDO, AccaoAmb.PROCURAR),
									new Reaccao (EventoAmb.INIMIGO, AccaoAmb.APROXIMAR)});
	}
	
}
