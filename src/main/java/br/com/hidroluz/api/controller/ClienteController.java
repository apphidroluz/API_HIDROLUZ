package br.com.hidroluz.api.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hidroluz.api.dtos.ClienteDTO;
import br.com.hidroluz.api.dtos.ConcentradorDataDTO;
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
	public ResponseEntity<Response<List<XML_TAB_RET>>> cadastrar2(
			@PathParam("logar") @Valid @RequestBody ClienteDTO clienteDto, BindingResult result) {
		Response<List<XML_TAB_RET>> response = new Response<List<XML_TAB_RET>>();

		List<XML_TAB> xmlDto = null;

		Cliente cliente = this.clienteRepository.findByLogin(clienteDto.getLogin());

		// System.out.println(cliente);


		for (int i = 0; i < cliente.getConcentradores().size(); i++) {

			xmlDto = this.xmlRepository
					.findByConcentradorOrderByNumHidrometro(cliente.getConcentradores().get(i).getNumConcentrador());

		}

		List<XML_TAB_RET> listadto = new ArrayList<>();

		for (int i = 0; i < xmlDto.size(); i++) {

			listadto.add(this.converterXMLDTO(xmlDto.get(i)));

		}

		response.setData(listadto);

		return ResponseEntity.ok(response);

	}
	
	
	@PostMapping(value = "/v2/logar")
	public ResponseEntity<Response<List<XML_TAB_RET>>> LogarComData(
			@PathParam("logar") @Valid @RequestBody ConcentradorDataDTO concentradorDataDTO, BindingResult result) throws ParseException {
		Response<List<XML_TAB_RET>> response = new Response<List<XML_TAB_RET>>();

		Calendar c = Calendar.getInstance();
		
		List<XML_TAB> xmlDto = null;
		
		Date date_info = this.dateFormatida.parse(concentradorDataDTO.getDataDe());

		Cliente cliente = this.clienteRepository.findByLogin(concentradorDataDTO.getLogin());
		
		Date date_info2;


	    date_info2 = this.dateFormatida.parse(getDateTime());

	    
	    c.setTime(date_info);
		c.add(Calendar.DATE, 1);
		
		
		Date dataDe = c.getTime();
		
		c.setTime(date_info2);
		c.add(Calendar.DATE, 1);

		Date currentDatePlusOne = c.getTime();


		for (int i = 0; i < cliente.getConcentradores().size(); i++) {

			xmlDto = this.xmlRepository
					.findByConcentradorAndDataBetweenOrderByData(cliente.getConcentradores().get(i).getNumConcentrador(), date_info ,currentDatePlusOne);

		}

		List<XML_TAB_RET> listadto = new ArrayList<>();

		for (int i = 0; i < xmlDto.size(); i++) {

			listadto.add(this.converterXMLDTO(xmlDto.get(i)));

		}

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
	
	
	private String getDateTime() {
	    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Date date = new Date();
	    return dateFormat.format(date);
	}



}