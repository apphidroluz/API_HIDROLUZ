package br.com.hidroluz.api.security.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import br.com.hidroluz.api.security.entity.XML_TAB;

public interface XML_TabService {
	
	XML_TAB findByNumHidrometroAndData(String numHidrometro, Date data);

}
