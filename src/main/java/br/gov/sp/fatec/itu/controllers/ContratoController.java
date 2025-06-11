package br.gov.sp.fatec.itu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.itu.entities.Contato;
import br.gov.sp.fatec.itu.services.ContatoService;

@CrossOrigin // permite a conexão com o front [Angular]
@RestController
@RequestMapping("contatos")
public class ContratoController {
    @Autowired
    private ContatoService service;

    @GetMapping  
    public ResponseEntity<List<Contato>> getAll() {  
        return ResponseEntity.ok(service.getAll());  
    }  

    @PostMapping  
    public ResponseEntity<Contato> save(@RequestBody Contato contato) {  
        return ResponseEntity.created(null).body(service.save(contato));  
    }  
}