package br.com.hidroluz.api.controller;

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

import br.com.hidroluz.api.dtos.XML_TABDto;
import br.com.hidroluz.api.responses.Response;
import br.com.hidroluz.api.security.entity.XML_TAB;
import br.com.hidroluz.api.security.repositories.XML_TABRepository;

@RestController
@RequestMapping("auth/api/medicoes")
@CrossOrigin(origins = "*")
public class XML_TABController {
	
	@Autowired
	private XML_TABRepository xmlRepository;
	
	/*@PostMapping(value = "/cadastrarxml")
	public ResponseEntity<Response<XML_TAB>> cadastrar1(
			@PathParam("cadastrar") @Valid @RequestBody XML_TABDto xmlDto, BindingResult result) {
		Response<XML_TAB> response = new Response<XML_TAB>();

		if (result.hasErrors()) {

			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		XML_TAB xml = new XML_TAB(null, xmlDto.getConcentrador(), xmlDto.getData_Hora_leitura(), xmlDto.getNum_Hidrometro());
		this.xmlRepository.save(xml);

		xmlDto.setIdXML_TAB(xml.getIdXML_TAB());
		response.setData(xml);

		return ResponseEntity.ok(response);

	}*/
	
	@PostMapping(value = "/vcon/buscarxml")
	public ResponseEntity<Response<XML_TAB>> buscarConce(
			@PathParam("buscar") @Valid @RequestBody XML_TABDto xmlDto, BindingResult result) {
		Response<XML_TAB> response = new Response<XML_TAB>();

		if (result.hasErrors()) {

			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		XML_TAB xml = this.xmlRepository.findByConcentrador(xmlDto.getConcentrador());
		xmlDto.setIdXML_TAB(xml.getIdXML_TAB());
		response.setData(xml);
		
		return ResponseEntity.ok(response);
		
	}
	
	@PostMapping(value = "/vconedate/buscarxml")
	public ResponseEntity<Response<XML_TAB>> buscarConceAndData(
			@PathParam("buscar") @Valid @RequestBody XML_TABDto xmlDto, BindingResult result) {
		Response<XML_TAB> response = new Response<XML_TAB>();

		if (result.hasErrors()) {

			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		XML_TAB xml = this.xmlRepository.findByConcentradorAndData(xmlDto.getConcentrador(), xmlDto.getData_Hora_leitura());
		xmlDto.setIdXML_TAB(xml.getIdXML_TAB());
		response.setData(xml);
		
		return ResponseEntity.ok(response);

		
	}
	
	@PostMapping(value = "/vnumhidro/buscarxml")
	public ResponseEntity<Response<XML_TAB>> buscarNumHidro(
			@PathParam("buscar") @Valid @RequestBody XML_TABDto xmlDto, BindingResult result) {
		Response<XML_TAB> response = new Response<XML_TAB>();

		if (result.hasErrors()) {

			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		XML_TAB xml = this.xmlRepository.findByNumHidrometro(xmlDto.getNum_Hidrometro());
		xmlDto.setIdXML_TAB(xml.getIdXML_TAB());
		response.setData(xml);
		
		return ResponseEntity.ok(response);

		
	}
	
	@PostMapping(value = "/vnumhidroedata/buscarxml")
	public ResponseEntity<Response<XML_TAB>> buscarNumHidroAndData(
			@PathParam("buscar") @Valid @RequestBody XML_TABDto xmlDto, BindingResult result) {
		Response<XML_TAB> response = new Response<XML_TAB>();

		if (result.hasErrors()) {

			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		XML_TAB xml = this.xmlRepository.findByNumHidrometroAndData(xmlDto.getNum_Hidrometro(), xmlDto.getData_Hora_leitura());
		xmlDto.setIdXML_TAB(xml.getIdXML_TAB());
		response.setData(xml);
		
		return ResponseEntity.ok(response);

		
	}

}
