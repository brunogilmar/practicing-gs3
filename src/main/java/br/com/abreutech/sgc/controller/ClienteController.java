package br.com.abreutech.sgc.controller;

import br.com.abreutech.sgc.controller.dto.ClienteDto;
import br.com.abreutech.sgc.controller.filter.ClienteFilter;
import br.com.abreutech.sgc.controller.form.ClienteForm;
import br.com.abreutech.sgc.controller.mapper.ClienteFormMapper;
import br.com.abreutech.sgc.controller.mapper.ClienteMapper;
import br.com.abreutech.sgc.modelo.Cliente;
import br.com.abreutech.sgc.service.ClienteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

	private ClienteService service;
	private ClienteMapper mapper;
	private ClienteFormMapper mapperForm;

	public ClienteController(
			ClienteService service,
			ClienteMapper mapper,
			ClienteFormMapper mapperForm
	) {
		this.service = service;
		this.mapper = mapper;
		this.mapperForm = mapperForm;
	}


	@PostMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<ClienteDto> save(@RequestBody @Valid ClienteForm form) {
		Cliente save = service.save(mapperForm.toEntity(form));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/clientes/{id}")
				.buildAndExpand(save.getId()).toUri();
		return ResponseEntity.created(uri).body(mapper.toDto(save));
	}

	@GetMapping
	public ResponseEntity<Page<ClienteDto>> search(ClienteFilter filtro,
			   @PageableDefault(
				   sort = "nome",
				   direction = Sort.Direction.ASC,
				   page = 0, size = 10) Pageable paginacao) {

		Page<Cliente> patios = service.search(filtro, paginacao);
		return ResponseEntity.ok(patios.map(mapper::toDto));
	}

	@GetMapping("/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<ClienteDto> findById(@PathVariable Long id) {
		Cliente cliente = service.findById(id);
		return ResponseEntity.ok(mapper.toDto(cliente));
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<ClienteDto> update(@RequestBody @Valid ClienteForm form) {
		Cliente update = service.update(mapperForm.toEntity(form));
		return ResponseEntity.ok(mapper.toDto(update));
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}

}
