package Cadastros;

public class DuracaoHoras {

	private final Viagem _viagem;
	private int duracaoHoras;

	private final boolean horaTerminoIgualInicio;
	private final boolean horaTerminoIgualInicioMaisUm;
	private final boolean horaTerminoMaiorQueInicio;
	private final boolean horaTerminoMenorQueInicio;
	private final boolean minutosTerminoMenorQueInicio;
	private final int horaTerminoMenosInicio;
	
	public DuracaoHoras(Viagem viagem) {
		_viagem = viagem;

		horaTerminoIgualInicio = _viagem.getHoraTermino() == _viagem.getHoraInicio();
		horaTerminoIgualInicioMaisUm = _viagem.getHoraTermino() == _viagem.getHoraInicio() + 1;
		horaTerminoMaiorQueInicio = _viagem.getHoraTermino() > _viagem.getHoraInicio();
		horaTerminoMenorQueInicio = _viagem.getHoraTermino() < _viagem.getHoraInicio();
		minutosTerminoMenorQueInicio = _viagem.getMinutosTermino() < _viagem.getMinutoInicio();
		horaTerminoMenosInicio = viagem.getHoraTermino() - _viagem.getHoraInicio();
	}
	
	public int calcularDuracao() {
		if (horaTerminoIgualInicio)
			duracaoHoras = 0;
		if (horaTerminoMaiorQueInicio)
			duracaoHoras = calcularDuracaoHoraTerminoMaiorQueInicio();
		if (horaTerminoMenorQueInicio)
			duracaoHoras = -1; // Para casos em que a hora de término nao foi registrada
		return duracaoHoras;
	}

	private int calcularDuracaoHoraTerminoMaiorQueInicio() {
		if (horaTerminoIgualInicioMaisUm) {
			duracaoHoras = calcularDuracaoHoraTerminoIgualInicioMaisUm();
		} else {
			duracaoHoras = calcularDuracaoHoraPossivelmenteMaiorQueDois();
		}
		return duracaoHoras;
	}

	private int calcularDuracaoHoraTerminoIgualInicioMaisUm() {
		if (minutosTerminoMenorQueInicio)  // Não chegou a uma hora
			duracaoHoras = 0;
		else // Durou pelo menos uma hora
			duracaoHoras = 1;
		return duracaoHoras;
	}

	private int calcularDuracaoHoraPossivelmenteMaiorQueDois() {
		if (horaTerminoMenosInicio > 2)
			duracaoHoras = horaTerminoMenosInicio;
		else if (horaTerminoMenosInicio == 2 && // Certamente menos de duas horas 
				minutosTerminoMenorQueInicio)   // e mais de uma hora
			duracaoHoras = 1;
		else // Duração de duas horas, certamente
			duracaoHoras = 2;
		return duracaoHoras;
	}
}
