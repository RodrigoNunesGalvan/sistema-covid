package br.com.projetoDesafioZup.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoDesafioZup.dto.PacienteDto;
import br.com.projetoDesafioZup.entity.PacienteEntity;
import br.com.projetoDesafioZup.errorHandler.CpfDuplicado;
import br.com.projetoDesafioZup.errorHandler.EmailDuplicado;
import br.com.projetoDesafioZup.repository.PacienteRepository;
import br.com.projetoDesafioZup.service.PacienteService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PacienteController {

	private EmailDuplicado emailDuplicado;
	private CpfDuplicado cpfDuplicado;
	private PacienteService pacienteService;
	
	@Autowired
	private PacienteRepository pacienteRepository;

	public PacienteController(EmailDuplicado emailDuplicado, CpfDuplicado cpfDuplicado,
			PacienteService pacienteService) {
		this.emailDuplicado = emailDuplicado;
		this.cpfDuplicado = cpfDuplicado;
		this.pacienteService = pacienteService;
	}

	@InitBinder
	public void init(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(emailDuplicado, cpfDuplicado);
	}

	@PostMapping(value = "/createPaciente", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String salvar(@Valid @RequestBody PacienteDto pacienteDto) {

		pacienteService.salvar(pacienteDto.toEntity());
		return pacienteDto.toString();
	}
	
	@GetMapping(value = "/consultaPaciente/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String salvar(@PathVariable("id") Long id) {
		
		PacienteEntity pacienteEncontrado = pacienteRepository.getOne(id);
		return pacienteEncontrado.toString();
	}

	@GetMapping(value = "/consultaPaciente", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PacienteEntity> consultar() {
		return pacienteRepository.findAll();
	}

}