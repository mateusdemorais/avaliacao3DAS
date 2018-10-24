package Cadastros;

public class DuracaoMinutos {

	private final Viagem _viagem;
	private int duracaoMinutos;
	
	public DuracaoMinutos(Viagem viagem) {
		_viagem = viagem;
	}
	
	public int calcularDuracao() {
		if (_viagem.getMinutosTermino() > _viagem.getMinutoInicio()) 
			duracaoMinutos = _viagem.getMinutosTermino() - _viagem.getMinutoInicio();
		else {
			duracaoMinutos = 60 - _viagem.getMinutoInicio() + _viagem.getMinutosTermino();
			if (duracaoMinutos == 60) //caso especial
				duracaoMinutos = 0;
		}
		return duracaoMinutos;
	}
}
