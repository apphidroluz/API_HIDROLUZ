package br.com.hidroluz.api.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import br.com.hidroluz.api.dtos.ConcentradorDTO;
import br.com.hidroluz.api.dtos.ConcentradorDataDTO;
import br.com.hidroluz.api.dtos.NumHidrometroDTO;
import br.com.hidroluz.api.dtos.NumHidrometroDataDTO;
import br.com.hidroluz.api.dtos.XML_TABDto;
import br.com.hidroluz.api.dtos.XML_TAB_CONC;
import br.com.hidroluz.api.dtos.XML_TAB_RET;
import br.com.hidroluz.api.responses.Response;
import br.com.hidroluz.api.security.entity.XML_TAB;
import br.com.hidroluz.api.security.repositories.XML_TABRepository;

@RestController
@RequestMapping("auth/api/medicoes")
@CrossOrigin(origins = "*")
public class XML_TABController {

	private final SimpleDateFormat dateFormatida = new SimpleDateFormat("yyyy-MM-dd");
	private final SimpleDateFormat dateFormatretorno = new SimpleDateFormat("dd-MM-yyyy");
	private final SimpleDateFormat dateFormatvolta = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	private final SimpleDateFormat dateFormatconsulta = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Autowired
	private XML_TABRepository xmlRepository;

//	@Autowired
//	private XML_TabService xml_TabService;

	@PostMapping(value = "/vcon/buscarxml")
	public ResponseEntity<Response<List<XML_TAB_RET>>> buscarConce(
			@PathParam("buscar") @Valid @RequestBody ConcentradorDTO concentradorDto, BindingResult result) {
		Response<List<XML_TAB_RET>> response = new Response<List<XML_TAB_RET>>();

		if (result.hasErrors()) {

			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		List<XML_TAB> xml = this.xmlRepository
				.findByConcentradorOrderByNumHidrometro(concentradorDto.getConcentrador());

		List<XML_TAB_RET> listadto = new ArrayList<>();

		for (int i = 0; i < xml.size(); i++) {

			listadto.add(this.converterXMLDTO(xml.get(i)));

		}

		response.setData(listadto);

		return ResponseEntity.ok(response);

	}

	@PostMapping(value = "/vconedate/buscarxml")
	public ResponseEntity<Response<List<XML_TAB_RET>>> buscarConceAndData(
			@Valid @RequestBody ConcentradorDataDTO concentradorDataDto) throws ParseException {

		Response<List<XML_TAB_RET>> response = new Response<List<XML_TAB_RET>>();

		Date date_info = this.dateFormatida.parse(concentradorDataDto.getDataDe());

		Date date_info2;

		if (concentradorDataDto.getDataAte() == null) {

			date_info2 = this.dateFormatida.parse(concentradorDataDto.getDataDe());

		} else {

			date_info2 = this.dateFormatida.parse(concentradorDataDto.getDataAte());

		}

		Calendar c = Calendar.getInstance();
		c.setTime(date_info2);
		c.add(Calendar.DATE, 1);

		Date currentDatePlusOne = c.getTime();

		List<XML_TAB> xmlDto = this.xmlRepository
				.findByConcentradorAndDataBetween(concentradorDataDto.getConcentrador(), date_info, currentDatePlusOne);

		List<XML_TAB_RET> listadto = new ArrayList<>();

		for (int i = 0; i < xmlDto.size(); i++) {

			listadto.add(this.converterXMLDTO(xmlDto.get(i)));

		}

		response.setData(listadto);

		return ResponseEntity.ok(response);
	}

	@PostMapping(value = "/vnumhidro/buscarxml")
	public ResponseEntity<Response<List<XML_TAB_RET>>> buscarNumHidro(
			@PathParam("buscar") @Valid @RequestBody NumHidrometroDTO numHidroDto, BindingResult result) {

		Response<List<XML_TAB_RET>> response = new Response<List<XML_TAB_RET>>();

		if (result.hasErrors()) {

			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		List<XML_TAB> xml = this.xmlRepository.findByNumHidrometroOrderByDataDesc(numHidroDto.getNumHidrometro());

		List<XML_TAB_RET> listadto = new ArrayList<>();

		for (int i = 0; i < xml.size(); i++) {

			listadto.add(this.converterXMLDTO(xml.get(i)));

		}

		response.setData(listadto);

		return ResponseEntity.ok(response);

	}

	@PostMapping(value = "/vnumhidroedata/buscarxml")
	public ResponseEntity<Response<List<XML_TAB_RET>>> buscarNumHidroAndData(
			@Valid @RequestBody NumHidrometroDataDTO numHidroDataDto) throws ParseException {

		Response<List<XML_TAB_RET>> response = new Response<List<XML_TAB_RET>>();

		Date date_info = this.dateFormatida.parse(numHidroDataDto.getDataDe());

		Date date_info2;

		if (numHidroDataDto.getDataAte() == null) {

			date_info2 = this.dateFormatida.parse(numHidroDataDto.getDataDe());

		} else {

			date_info2 = this.dateFormatida.parse(numHidroDataDto.getDataAte());

		}

		Calendar c = Calendar.getInstance();
		c.setTime(date_info2);
		c.add(Calendar.DATE, 1);

		Date currentDatePlusOne = c.getTime();

		System.out.println(currentDatePlusOne);

		List<XML_TAB> xmlDto = this.xmlRepository.findByNumHidrometroAndDataBetweenOrderByData(
				numHidroDataDto.getNumHidrometro(), date_info, currentDatePlusOne);

		List<XML_TAB_RET> listadto = new ArrayList<>();

		for (int i = 0; i < xmlDto.size(); i++) {

			listadto.add(this.converterXMLDTOData(xmlDto.get(i)));

		}

		response.setData(listadto);

		return ResponseEntity.ok(response);

	}

	@PostMapping(value = "/vnumhidroedatahora/buscarxml")
	public ResponseEntity<Response<List<XML_TAB_RET>>> buscarNumHidroAndDataHora(
			@Valid @RequestBody NumHidrometroDataDTO numHidroDataDto) throws ParseException {

		Response<List<XML_TAB_RET>> response = new Response<List<XML_TAB_RET>>();

		Date date_info = this.dateFormatida.parse(numHidroDataDto.getDataDe());

		Date date_info2;

		if (numHidroDataDto.getDataAte() == null) {

			date_info2 = this.dateFormatida.parse(numHidroDataDto.getDataDe());

		} else {

			date_info2 = this.dateFormatida.parse(numHidroDataDto.getDataAte());

		}

		Calendar ca = Calendar.getInstance();
		ca.setTime(date_info);
		ca.add(Calendar.DATE, -1);

		Date currentDateLessOne = ca.getTime();

		Calendar c = Calendar.getInstance();
		c.setTime(date_info2);
		c.add(Calendar.DATE, 1);

		Date currentDatePlusOne = c.getTime();

		List<XML_TAB> xmlDto = this.xmlRepository.findByNumHidrometroAndDataBetweenOrderByData(
				numHidroDataDto.getNumHidrometro(), currentDateLessOne, currentDatePlusOne);

		List<XML_TAB_RET> listadto = new ArrayList<>();

		for (int i = 0; i < xmlDto.size(); i++) {

			listadto.add(this.converterDTOparaXMl(xmlDto.get(i)));

		}

		response.setData(listadto);

		return ResponseEntity.ok(response);

	}

	@PostMapping(value = "/vnumhidro/buscaralarmexml")
	public ResponseEntity<Response<List<XML_TAB_RET>>> buscarNumHidroalarme(
			@PathParam("buscar") @Valid @RequestBody XML_TABDto XMlDto, BindingResult result) {
		Response<List<XML_TAB_RET>> response = new Response<List<XML_TAB_RET>>();

		if (result.hasErrors()) {

			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);

		}

		try {
			Date dia1 = this.dateFormatconsulta.parse(XMlDto.getDataDe());
			Date dia2 = this.dateFormatconsulta.parse(XMlDto.getDataAte());

			System.out.println(dia1.toString() + dia2.toString());

			System.out.println();

			List<XML_TAB> xml = this.xmlRepository.findByNumHidrometroAlarme(dia1, dia2);

			List<XML_TAB_RET> listadto = new ArrayList<>();
//
			for (int i = 0; i < xml.size(); i++) {

				listadto.add(this.converterDTOparaXMl(xml.get(i)));

			}

			response.setData(listadto);

			return ResponseEntity.ok(response);

		} catch (ParseException e) {

			return ResponseEntity.ok(response);
		}

	}



	@PostMapping(value = "/vnumhidro/buscarconcentradorxml")
	public ResponseEntity<Response<List<XML_TAB_CONC>>> buscarUltimaleitura() {

		Response<List<XML_TAB_CONC>> response = new Response<List<XML_TAB_CONC>>();

		System.out.println("1");

		try {

			List<XML_TAB> xml = this.xmlRepository.listConcentradorPorDataMaxima();
			
			System.out.println("2");

			List<XML_TAB_CONC> listadto = new ArrayList<>();
			
			System.out.println("3" + xml);
			
			//
			for (int i = 0; i < xml.size(); i++) {
				
				
				listadto.add(this.converterDTOConceparaXMl(xml.get(i)));

			}
			
			System.out.println("5");

			response.setData(listadto);

			return ResponseEntity.ok(response);

		} catch (Exception e) {

			return ResponseEntity.ok(response);
		}

	}

	private XML_TAB_RET converterXMLDTO(XML_TAB tab) {
		XML_TAB_RET dto = new XML_TAB_RET();

		dto.setIdXML_TAB(tab.getIdXML_TAB());
		dto.setData(this.dateFormatretorno.format(tab.getData()));
		dto.setConcentrador(tab.getConcentrador());
		dto.setNumHidrometro(tab.getNumHidrometro());
		dto.setAlarmes(tab.getAlarmes());
		dto.setIndice_atual(tab.getIndice_atual());
		dto.setUnit(tab.getUnit());

		return dto;

	}

	private XML_TAB_RET converterXMLDTOData(XML_TAB tab) {
		XML_TAB_RET dto = new XML_TAB_RET();

		dto.setIdXML_TAB(tab.getIdXML_TAB());
		dto.setData(this.dateFormatretorno.format(tab.getData()));
		dto.setConcentrador(tab.getConcentrador());
		dto.setNumHidrometro(tab.getNumHidrometro());
		dto.setAlarmes(tab.getAlarmes());
		dto.setIndice_atual(tab.getIndice_atual());
		dto.setUnit(tab.getUnit());

		return dto;

	}

	private XML_TAB_CONC converterDTOConceparaXMl(XML_TAB dto) {
		XML_TAB_CONC tab = new XML_TAB_CONC();
		
		System.out.println("4");

		tab.setConcentrador(dto.getConcentrador());
		tab.setData(this.dateFormatvolta.format(dto.getData()));

		return tab;

	}
	private XML_TAB_RET converterDTOparaXMl(XML_TAB dto) {
		XML_TAB_RET tab = new XML_TAB_RET();

		tab.setIdXML_TAB(dto.getIdXML_TAB());
		tab.setConcentrador(dto.getConcentrador());
		tab.setNumHidrometro(dto.getNumHidrometro());
		tab.setConcentrador(dto.getConcentrador());
		tab.setIndice_atual(dto.getIndice_atual());
		tab.setAlarmes(dto.getAlarmes());
		tab.setUnit(dto.getUnit());
		tab.setData(this.dateFormatvolta.format(dto.getData()));

		return tab;

	}

}
