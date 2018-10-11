package br.com.hidroluz.api.security.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hidroluz.api.security.entity.XML_TAB;

@Repository
@ComponentScan(basePackages = "br.com.hidroluz.api")
public interface XML_TABRepository extends JpaRepository<XML_TAB, Integer> {
	
	List<XML_TAB> findByConcentradorOrderByNumHidrometro(String concentrador);
	
	List<XML_TAB> findByConcentradorAndDataBetween(String concentrador, Date dataDe, Date dataAte);
	
	List<XML_TAB> findByConcentradorAndDataOrderByData(String concentrador, Date dataDe);
	
	List<XML_TAB> findByNumHidrometro(String numHidrometro);
	
	List<XML_TAB> findByNumHidrometroAndDataBetweenOrderByData(String numHidrometro, Date dataDe, Date dataAte);
	
	List<XML_TAB> findByNumHidrometroAndDataOrderByData(String numHidrometro, Date dataDe);
	

}
