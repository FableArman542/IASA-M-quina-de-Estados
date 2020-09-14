package jogo.personagem.comport;

import jogo.Comportamento;
import jogo.ambiente.AccaoAmb;
import jogo.ambiente.EventoAmb;
import reaccao.Reaccao;

public class Combater extends ComportHierarq{
	
	public Combater () {
		super (new Comportamento[] {new Reaccao (EventoAmb.INIMIGO, AccaoAmb.ATACAR),
									new Reaccao (EventoAmb.DERROTA, AccaoAmb.INICIAR)});
	}
	
}
