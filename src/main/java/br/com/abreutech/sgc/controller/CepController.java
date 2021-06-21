package br.com.abreutech.sgc.controller;

import br.com.abreutech.sgc.controller.dto.EnderecoDto;
import br.com.abreutech.sgc.service.CepService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/ceps")
public class CepController {

	private CepService service;

	public CepController(
			CepService service
	) {
		this.service = service;
	}

	@GetMapping("/{cep}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<EnderecoDto> findByCep(@PathVariable String cep) {
		EnderecoDto endereco = service.findByCep(cep);
		return ResponseEntity.ok(endereco);
	}

}
