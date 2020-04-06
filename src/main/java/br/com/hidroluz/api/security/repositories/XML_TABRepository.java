package br.com.hidroluz.api.security.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.hidroluz.api.security.entity.XML_TAB;

@Repository
@ComponentScan(basePackages = "br.com.hidroluz.api")
public interface XML_TABRepository extends JpaRepository<XML_TAB, Integer> {

	List<XML_TAB> findByConcentradorOrderByNumHidrometro(String concentrador);

	List<XML_TAB> findByConcentradorAndDataBetweenOrderByData(String concentrador, Date dataDe, Date dataAte);

	List<XML_TAB> findByConcentradorAndDataBetween(String concentrador, Date dataDe, Date dataAte);

	List<XML_TAB> findByNumHidrometroOrderByDataDesc(String numHidrometro);

	List<XML_TAB> findByNumHidrometroAndDataBetweenOrderByData(String numHidrometro, Date dataDe, Date dataAte);

	@Query("select x FROM XML_TAB x WHERE SUBSTR(x.alarmes,3,1) like '%1%' and x.data between ?1 and ?2 GROUP by numHidrometro")
	List<XML_TAB> findByNumHidrometroAlarme(Date dataDe, Date dataAte);

	@Query("SELECT new br.com.hidroluz.api.security.entity.XML_TAB(x.concentrador, MAX(x.data) as data) from XML_TAB x GROUP by x.concentrador")
	List<XML_TAB> listConcentradorPorDataMaxima();
	

}
