package maquest;

public class MaquinaEstados <EV> {
	// EV � uma  macro
	// Quando criado � necess�rio colocar o tipo de EV
	
	private Estado<EV> estado;
	
	public MaquinaEstados (Estado<EV> estado) {
		this.estado = estado;
	}
	
	public Estado<EV> getEstado () {
		return estado;
	}
	
	public void processar (EV evento) {
		estado = (estado.processar(evento)!=null) ? 
				estado.processar(evento) : estado;
	}
}
