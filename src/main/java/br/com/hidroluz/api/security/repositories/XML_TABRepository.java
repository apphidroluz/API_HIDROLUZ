package br.com.hidroluz.api.security.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hidroluz.api.security.entity.XML_TAB;

@Repository
@ComponentScan(basePackages = "br.com.hidroluz.api")
public interface XML_TABRepository extends JpaRepository<XML_TAB, Integer> {
	
	XML_TAB findByConcentrador(String concentrador);
	
	XML_TAB findByConcentradorAndData(String concentrador, Date data);
	
	List<XML_TAB> findByNumHidrometro(String numHidrometro);
	
	Page<XML_TAB> findByNumHidrometroAndData(String numHidrometro, Date data, Pageable pageable);
	

}
