package br.com.hidroluz.api.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.hidroluz.api.dtos.XML_TABDto;
import br.com.hidroluz.api.responses.Response;
import br.com.hidroluz.api.security.entity.XML_TAB;
import br.com.hidroluz.api.security.repositories.XML_TABRepository;

@RestController
@RequestMapping("auth/api/medicoes")
@CrossOrigin(origins = "*")
public class XML_TABController {
	
	private static final Logger log = LoggerFactory.getLogger(XML_TABController.class);
	private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	private XML_TABRepository xmlRepository;
	
//	@Autowired
//	private XML_TabService xml_TabService;
	
	
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
		
		//XML_TAB xml = this.xmlRepository.findByConcentradorAndData(xmlDto.getConcentrador(), xmlDto.getData_Hora_leitura());
		//xmlDto.setIdXML_TAB(xml.getIdXML_TAB());
		//response.setData(xml);
		
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
		
		List<XML_TAB> xml = this.xmlRepository.findByNumHidrometro(xmlDto.getHidrometro());
		xmlDto.setIdXML_TAB(xml.get(0).getIdXML_TAB());
		response.setData(xml.get(0));
		
		return ResponseEntity.ok(response);

		
	}
	
	
	@PostMapping(value = "/vnumhidroedata/buscarxml")
	public ResponseEntity<Response<XML_TABDto>> buscarNumHidroAndData(
			@Valid @RequestBody XML_TABDto xml_TABDto,
			BindingResult result) throws ParseException{
		Response<XML_TABDto> response = new Response<XML_TABDto>();
		
		Date date_info = this.dateFormat.parse(xml_TABDto.getData());
		
		XML_TAB xmlDto  =  this.xmlRepository.findByNumHidrometroAndData(xml_TABDto.getHidrometro(), date_info);
		
		

		if (result.hasErrors()) {

			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(this.converterXMLDTO(xmlDto));
		

			
		
		return ResponseEntity.ok(response);
		
	}
	
	
	private XML_TABDto converterXMLDTO(XML_TAB tab) {
		XML_TABDto dto = new XML_TABDto();
		dto.setId(Optional.of(tab.getIdXML_TAB()));
		dto.setData(this.dateFormat.format(tab.getData()));
		dto.setConcentrador(tab.getConcentrador());
		dto.setHidrometro(tab.getNumHidrometro());
		
	
		return dto;
		
	}
	
	
	private XML_TAB converterDTOparaXMl(XML_TABDto dto,BindingResult result) throws ParseException{
		XML_TAB tab = new XML_TAB();
	    tab.setConcentrador(dto.getConcentrador());
	    tab.setData(this.dateFormat.parse(dto.getData()));
	    tab.setNumHidrometro(dto.getHidrometro());
	    
	    	
		return tab;
		
	}

}
