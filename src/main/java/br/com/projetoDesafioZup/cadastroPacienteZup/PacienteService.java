package br.com.projetoDesafioZup.cadastroPacienteZup;

import org.springframework.stereotype.Service;

@Service
public class PacienteService {
	
	private PacienteRepository pacienteRepository;

	public PacienteService(PacienteRepository pacienteRepository) {
		this.pacienteRepository = pacienteRepository;
	}
	
	public void salvar(Paciente paciente) {
		pacienteRepository.save(paciente);
	}

	public void consultar(Paciente paciente) {
		pacienteRepository.save(paciente);
		
	}

	public void getPacienteRepository(PacienteRepository pacienteRepository) {
		this.pacienteRepository = pacienteRepository;
	}

	public void setPacienteRepository(PacienteRepository pacienteRepository) {
		this.pacienteRepository = pacienteRepository;
	}

	
}
