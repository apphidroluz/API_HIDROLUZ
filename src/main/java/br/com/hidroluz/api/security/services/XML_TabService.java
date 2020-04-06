package br.com.hidroluz.api.security.services;



import org.springframework.data.domain.Page;

import br.com.hidroluz.api.security.entity.XML_TAB;

public interface XML_TabService {
	
	Page<XML_TAB> findByNumHidrometroAndData(String numHidrometro, String data);

}
