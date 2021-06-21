package br.com.abreutech.sgc.controller;

import br.com.abreutech.sgc.modelo.TipoTelefone;
import br.com.abreutech.sgc.service.TipoTelefoneService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/telefones/tipos")
public class TipoTelefoneController {

	private TipoTelefoneService service;

	public TipoTelefoneController(
			TipoTelefoneService service
	) {
		this.service = service;
	}

	@GetMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<TipoTelefone>> findAll() {
		List<TipoTelefone> tipoTelefoneList = service.findAll();
		return ResponseEntity.ok(tipoTelefoneList);
	}

}
