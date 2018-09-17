package br.com.hidroluz.api.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hidroluz.api.security.entity.Concentrador;

public interface ConcentradorRepository extends JpaRepository<Concentrador, Integer> {

}
