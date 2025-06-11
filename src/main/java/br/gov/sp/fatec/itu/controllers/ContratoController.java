package br.gov.sp.fatec.itu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @GetMapping("/{id}")
    public ResponseEntity<Contato> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/pesquisa")
    public ResponseEntity<List<Contato>> search(@RequestParam String termo) {
        return ResponseEntity.ok(service.search(termo));
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Contato>> getByCategoria(@PathVariable String categoria) {
        return ResponseEntity.ok(service.findByCategoria(categoria));
    }

    @GetMapping("/favoritos")
    public ResponseEntity<List<Contato>> getFavoritos() {
        return ResponseEntity.ok(service.findFavoritos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contato> update(@PathVariable Long id, @RequestBody Contato contato) {
        return ResponseEntity.ok(service.update(id, contato));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
