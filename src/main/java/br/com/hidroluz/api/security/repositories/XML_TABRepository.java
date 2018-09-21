package br.com.hidroluz.api.security.repositories;

import java.util.Date;
import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hidroluz.api.security.entity.XML_TAB;

@Repository
@ComponentScan(basePackages = "br.com.hidroluz.api")
@NamedQueries({
	@NamedQuery(name = "XML_TABRepository.findByConcentradorAndData", 
			query = "SELECT x FROM XML_TAB x WHERE x.date between :" + " 2018-09-21" + " AND :" + "2018-09-22") })
public interface XML_TABRepository extends JpaRepository<XML_TAB, Integer> {
	
	Page<XML_TAB> findByConcentrador(String concentrador,Pageable pageableS);
	
	Page<XML_TAB> findByConcentradorAndData(String concentrador, Date data, Pageable pageable);
	
	Page<XML_TAB> findByNumHidrometro(String numHidrometro, Pageable pageable);
	
	Page<XML_TAB> findByNumHidrometroAndData(String numHidrometro, Date data, Pageable pageable);
	

}
