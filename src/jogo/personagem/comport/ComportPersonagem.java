package jogo.personagem.comport;


import jogo.ambiente.EventoAmb;
import maquest.Estado;
import maquest.MaquinaEstados;
import reaccao.Estimulo;

public class ComportPersonagem extends ComportMaqEst {
	
	protected MaquinaEstados<Estimulo> iniciar () {

		Estado<Estimulo> patrulha = new Estado<Estimulo> ("Patrulha");
		Estado<Estimulo> inspeccao = new Estado<Estimulo> ("Inspeccionar");
		Estado<Estimulo> defesa = new Estado<Estimulo> ("Defesa");
		Estado<Estimulo> combate = new Estado<Estimulo> ("Combate");
		
		patrulha
				.transicao(EventoAmb.RUIDO, inspeccao)
				.transicao(EventoAmb.SILENCIO, patrulha)
				.transicao(EventoAmb.INIMIGO, defesa);
		
		inspeccao
				.transicao(EventoAmb.RUIDO, inspeccao)
				.transicao(EventoAmb.INIMIGO, defesa);
		
		defesa
				.transicao(EventoAmb.FUGA, inspeccao)
				.transicao(EventoAmb.INIMIGO, combate);
		
		combate
				.transicao(EventoAmb.INIMIGO, combate)
				.transicao(EventoAmb.FUGA, patrulha)
				.transicao(EventoAmb.VITORIA, patrulha)
				.transicao(EventoAmb.DERROTA, patrulha);
		
		comport (patrulha, new Patrulhar());
		comport (inspeccao, new Inspeccionar());
		comport (defesa, new Defender());
		comport (combate, new Combater());
		
		return new MaquinaEstados<Estimulo>(patrulha);
	}
}
