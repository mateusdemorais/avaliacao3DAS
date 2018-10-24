package Cadastros;

public class DuracaoMinutos {

	private final Viagem _viagem;
	private int duracaoMinutos;
	
	private final boolean minutosTerminoMaiorQueInicio;
	private final int duracaoMinutosTerminoMaiorQueInicio;
	private final int duracaoMinutosTerminoMenorIgualQueInicio;

	public DuracaoMinutos(Viagem viagem) {
		_viagem = viagem;

		minutosTerminoMaiorQueInicio = _viagem.getMinutosTermino() > _viagem.getMinutoInicio();
		duracaoMinutosTerminoMaiorQueInicio = _viagem.getMinutosTermino() - _viagem.getMinutoInicio();
		duracaoMinutosTerminoMenorIgualQueInicio = _viagem.getMinutoInicio() + _viagem.getMinutosTermino();
	}
	
	public int calcularDuracao() {
		if (minutosTerminoMaiorQueInicio)
			duracaoMinutos = calcularDuracaoMinutosTerminoMaiorQueInicio();
		else {
			duracaoMinutos = calcularDuracaoMinutosTerminoMenorIgualQueInicio();
		}
		return duracaoMinutos;
	}

	public int calcularDuracaoMinutosTerminoMaiorQueInicio() {
		return duracaoMinutosTerminoMaiorQueInicio;
	}

	public int calcularDuracaoMinutosTerminoMenorIgualQueInicio() {
		duracaoMinutos = duracaoMinutosTerminoMenorIgualQueInicio;
		if (duracaoMinutos == 60) // Caso especial
			duracaoMinutos = 0;
		return duracaoMinutos;
	}
}
