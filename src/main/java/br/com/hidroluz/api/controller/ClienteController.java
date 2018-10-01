package br.com.hidroluz.api.controller;

import java.text.SimpleDateFormat;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hidroluz.api.dtos.ClienteDTO;
import br.com.hidroluz.api.dtos.XML_TAB_RET;
import br.com.hidroluz.api.responses.Response;
import br.com.hidroluz.api.security.entity.Cliente;
import br.com.hidroluz.api.security.entity.XML_TAB;
import br.com.hidroluz.api.security.repositories.ClienteRepository;
import br.com.hidroluz.api.security.repositories.XML_TABRepository;
import br.com.hidroluz.api.utils.SenhaUtil;

@RestController
@RequestMapping("/auth/api/cliente")
@CrossOrigin(origins = "*")
public class ClienteController {
	

	private final SimpleDateFormat dateFormatida = new SimpleDateFormat("yyyy-MM-dd");
	private final SimpleDateFormat dateFormatvolta = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private XML_TABRepository xmlRepository;

	@PostMapping(value = "/v1/cadastrar")
	public ResponseEntity<Response<Cliente>> cadastrar1(
			@PathParam("cadastrar") @Valid @RequestBody ClienteDTO clienteDto, BindingResult result) {
		Response<Cliente> response = new Response<Cliente>();

		if (result.hasErrors()) {

			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		String senhaEncode = SenhaUtil.gerarBCrypt(clienteDto.getSenha());

		Cliente cliente = new Cliente(null, clienteDto.getLogin(), senhaEncode, clienteDto.getPerfil());
		this.clienteRepository.save(cliente);

		clienteDto.setId_Cliente(cliente.getId_Cliente());
		response.setData(cliente);

		return ResponseEntity.ok(response);

	}

	@PostMapping(value = "/v1/logar")
	public ResponseEntity<Response<Page<XML_TAB_RET>>> cadastrar2(@PathParam("logar") @Valid @RequestBody ClienteDTO clienteDto,
			BindingResult result) {
		Response<Page<XML_TAB_RET>> response = new Response<Page<XML_TAB_RET>>();

		Page<XML_TAB> xmlDto= null;

		Cliente cliente = this.clienteRepository.findByLogin(clienteDto.getLogin());
		
		//System.out.println(cliente);
		
		for(int i = 0; i < cliente.getConcentradores().size(); i++) {
			
			xmlDto = this.xmlRepository.findByConcentrador(cliente.getConcentradores().get(i).getNumConcentrador(),
					PageRequest.of(0, 25));	
			
		}
		
		
		
		
		Page<XML_TAB_RET> listadto = xmlDto.map(

				xmlDto2 -> this.converterXMLDTO(xmlDto2)

		);

		System.out.println(listadto);
		
		response.setData(listadto);

		return ResponseEntity.ok(response);

	}
	
	private XML_TAB_RET converterXMLDTO(XML_TAB tab) {
		XML_TAB_RET dto = new XML_TAB_RET();

		dto.setIdXML_TAB(tab.getIdXML_TAB());
		dto.setData(this.dateFormatvolta.format(tab.getData()));
		dto.setConcentrador(tab.getConcentrador());
		dto.setNumHidrometro(tab.getNumHidrometro());
		dto.setAlarmes(tab.getAlarmes());
		dto.setIndice_atual(tab.getIndice_atual());
		dto.setUnit(tab.getUnit());

		return dto;

	}

}