package br.gov.sp.fatec.itu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.itu.entities.Contato;
import br.gov.sp.fatec.itu.repositories.ContatoRepository;
import jakarta.persistence.EntityNotFoundException;

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

    public Contato findById(Long id) {
        return repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Contato não encontrado :("));
    }

    public List<Contato> search(String termo) {
        return repository.findByNomeContainingOrTelefoneContainingOrEmailContaining(termo, termo, termo);
    }
    public List<Contato> findByCategoria(String categoria) {
        return repository.findByCategoria(categoria);
    }

    public List<Contato> findFavoritos() {
        return repository.findByFavoritoTrue();
    }

    public Contato update(Long id, Contato contatoAtualizado) {
        Contato contato = repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Contato não encontrado :("));
        
        contato.setNome(contatoAtualizado.getNome());
        contato.setTelefone(contatoAtualizado.getTelefone());
        contato.setEmail(contatoAtualizado.getEmail());
        // ... 
        
        return repository.save(contato);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Contato não encontrado :(");
        }
        repository.deleteById(id);
    }
}