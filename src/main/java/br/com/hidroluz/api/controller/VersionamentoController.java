package br.com.hidroluz.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/versioncli")
public class VersionamentoController {
	
	@GetMapping(value= "/{nome}")
	public ResponseEntity<String> versionamento(@PathVariable("nome")String nome) {
		return ResponseEntity.ok(String.format("Teste de versionamento %s", nome));
	}

}
