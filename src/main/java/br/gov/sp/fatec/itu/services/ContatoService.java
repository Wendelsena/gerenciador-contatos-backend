package br.gov.sp.fatec.itu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.itu.entities.Contato;
import br.gov.sp.fatec.itu.repositories.ContatoRepository;

@Service
public class ContatoService {
    @Autowired
    private ContatoRepository repository;

    public List<Contato> getAll() {
        return repository.findAll();
    }

    public Contato save(Contato contato) {
        return repository.save(contato);
    }

    // Pensar... [update, delete, etc]
}