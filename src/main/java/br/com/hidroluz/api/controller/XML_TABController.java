package br.com.hidroluz.api.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

import br.com.hidroluz.api.dtos.XML_TABDto;
import br.com.hidroluz.api.dtos.XML_TAB_RET;
import br.com.hidroluz.api.responses.Response;
import br.com.hidroluz.api.security.entity.XML_TAB;
import br.com.hidroluz.api.security.repositories.XML_TABRepository;

@RestController
@RequestMapping("auth/api/medicoes")
@CrossOrigin(origins = "*")
public class XML_TABController {

	private final SimpleDateFormat dateFormatida = new SimpleDateFormat("yyyy-MM-dd");
	private final SimpleDateFormat dateFormatvolta = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

	@Autowired
	private XML_TABRepository xmlRepository;

	/*
	 * @Value("${paginacao.qtd_por_pagna}") private int qtdPorPagina = 5;
	 */

//	@Autowired
//	private XML_TabService xml_TabService;

	@PostMapping(value = "/vcon/buscarxml")
	public ResponseEntity<Response<Page<XML_TAB_RET>>> buscarConce(
			@PathParam("buscar") @Valid @RequestBody XML_TABDto xmlDto, BindingResult result) {
		Response<Page<XML_TAB_RET>> response = new Response<Page<XML_TAB_RET>>();

		if (result.hasErrors()) {

			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Page<XML_TAB> xml = this.xmlRepository.findByConcentrador(xmlDto.getConcentrador(), PageRequest.of(0, 5));
		
		Page<XML_TAB_RET> listadto = xml.map(

				xmlDto2 -> this.converterXMLDTO(xmlDto2)

		);

		response.setData(listadto);

		return ResponseEntity.ok(response);

	}

	@PostMapping(value = "/vconedate/buscarxml")
	public ResponseEntity<Response<Page<XML_TAB_RET>>> buscarConceAndData(@Valid @RequestBody XML_TABDto xml_TABDto)
			throws ParseException {

		Response<Page<XML_TAB_RET>> response = new Response<Page<XML_TAB_RET>>();

		Date date_info = this.dateFormatida.parse(xml_TABDto.getDataDe());

		Date date_info2 ;

		if (xml_TABDto.getDataAte() == null) {
			
		date_info2 = this.dateFormatida.parse(xml_TABDto.getDataDe());

		} else {
			
		date_info2 = this.dateFormatida.parse(xml_TABDto.getDataAte());

		}

		Calendar c = Calendar.getInstance();
		c.setTime(date_info2);
		c.add(Calendar.DATE, 1);

		Date currentDatePlusOne = c.getTime();

		Page<XML_TAB> xmlDto = this.xmlRepository.findByConcentradorAndDataBetween(xml_TABDto.getConcentrador(),
				date_info, currentDatePlusOne, PageRequest.of(0, 5));

		Page<XML_TAB_RET> listadto = xmlDto.map(

				xmlDto2 -> this.converterXMLDTO(xmlDto2)

		);

		response.setData(listadto);

		return ResponseEntity.ok(response);

	}

	@PostMapping(value = "/vnumhidro/buscarxml")
	public ResponseEntity<Response<Page<XML_TAB_RET>>> buscarNumHidro(
			@PathParam("buscar") @Valid @RequestBody XML_TABDto xmlDto, BindingResult result) {
		
		Response<Page<XML_TAB_RET>> response = new Response<Page<XML_TAB_RET>>();

		if (result.hasErrors()) {

			result.getAllErrors().forEach(errors -> response.getErrors().add(errors.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Page<XML_TAB> xml = this.xmlRepository.findByNumHidrometro(xmlDto.getHidrometro(), PageRequest.of(0, 5));
		
		Page<XML_TAB_RET> listadto = xml.map(

				xmlDto2 -> this.converterXMLDTO(xmlDto2)

		);

		response.setData(listadto);

		return ResponseEntity.ok(response);

	}

	@PostMapping(value = "/vnumhidroedata/buscarxml")
	public ResponseEntity<Response<Page<XML_TAB_RET>>> buscarNumHidroAndData(@Valid @RequestBody XML_TABDto xml_TABDto)
			throws ParseException {

		Response<Page<XML_TAB_RET>> response = new Response<Page<XML_TAB_RET>>();

		Date date_info = this.dateFormatida.parse(xml_TABDto.getDataDe());

		Date date_info2;
		
		if (xml_TABDto.getDataAte() == null) {
			
			date_info2 = this.dateFormatida.parse(xml_TABDto.getDataDe());

			} else {
				
			date_info2 = this.dateFormatida.parse(xml_TABDto.getDataAte());

			}

		Calendar c = Calendar.getInstance();
		c.setTime(date_info2);
		c.add(Calendar.DATE, 1);

		Date currentDatePlusOne = c.getTime();

		System.out.println(currentDatePlusOne);

		Page<XML_TAB> xmlDto = this.xmlRepository.findByNumHidrometroAndDataBetween(xml_TABDto.getHidrometro(),
				date_info, currentDatePlusOne, PageRequest.of(0, 5));

		Page<XML_TAB_RET> listadto = xmlDto.map(

				xmlDto2 -> this.converterXMLDTO(xmlDto2)

		);

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

	private XML_TAB converterDTOparaXMl(XML_TAB_RET dto) {
		XML_TAB tab = new XML_TAB();

		tab.setConcentrador(dto.getConcentrador());
		tab.setNumHidrometro(dto.getNumHidrometro());
		tab.setConcentrador(dto.getConcentrador());

		String teste = this.dateFormatvolta.format(dto.getData());

		System.out.println(teste);

		try {
			Date teste2 = this.dateFormatvolta.parse(teste);

			System.out.println(teste2);

			tab.setData(teste2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tab;

	}

}
