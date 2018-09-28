package br.com.hidroluz.api.security.repositories;

import java.util.Date;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hidroluz.api.security.entity.XML_TAB;

@Repository
@ComponentScan(basePackages = "br.com.hidroluz.api")
/*@NamedQueries({
	@NamedQuery(name = "XML_TABRepository.findByConcentradorAndData", 
			query = "SELECT x FROM XML_TAB x WHERE x.date between :dataDe  AND :dataAte") })*/
public interface XML_TABRepository extends JpaRepository<XML_TAB, Integer> {
	
	Page<XML_TAB> findByConcentrador(String concentrador,Pageable pageable);
	
	Page<XML_TAB> findByConcentradorAndDataBetween(String concentrador, Date dataDe, Date dataAte, Pageable pageable);
	
	Page<XML_TAB> findByNumHidrometro(String numHidrometro, Pageable pageable);
	
	Page<XML_TAB> findByNumHidrometroAndDataBetween(String numHidrometro, Date dataDe, Date dataAte, Pageable pageable);
	

}
