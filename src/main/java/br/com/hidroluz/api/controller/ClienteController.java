package br.com.hidroluz.api.controller;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hidroluz.api.dtos.ClienteDTO;
import br.com.hidroluz.api.responses.Response;
import br.com.hidroluz.api.security.entity.Cliente;
import br.com.hidroluz.api.security.repositories.ClienteRepository;
import br.com.hidroluz.api.utils.SenhaUtils;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@PostMapping(value = "/v1/cadastrar")
	public ResponseEntity<Response<Cliente>> cadastrar1(
			@PathParam("cadastrar") @Valid @RequestBody ClienteDTO clienteDto, BindingResult result) {
		Response<Cliente> response = new Response<Cliente>();

		if (result.hasErrors()) {

			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		String senhaEncode = SenhaUtils.gerarBCrypt(clienteDto.getSenha());

		Cliente cliente = new Cliente(null, clienteDto.getLogin(), senhaEncode);
		this.clienteRepository.save(cliente);

		clienteDto.setId_Cliente(1);
		response.setData(cliente);

		return ResponseEntity.ok(response);

	}

	@PostMapping(value = "/v1/logar")
	public ResponseEntity<Response<Cliente>> cadastrar2(@PathParam("logar") @Valid @RequestBody ClienteDTO clienteDto,
			BindingResult result) {
		Response<Cliente> response = new Response<Cliente>();

	
		if (result.hasErrors()) {
			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		Cliente cliente = this.clienteRepository.findByLoginAndSenha(clienteDto.getLogin(), clienteDto.getSenha());

		response.setData(cliente);

		return ResponseEntity.ok(response);

	}

}