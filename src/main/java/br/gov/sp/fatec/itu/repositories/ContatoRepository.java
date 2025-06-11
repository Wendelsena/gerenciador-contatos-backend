package br.gov.sp.fatec.itu.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.itu.entities.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
    
    // Pesquisa 
    @Query("SELECT c FROM Contato c WHERE " +
           "LOWER(c.nome) LIKE LOWER(CONCAT('%', :termo1, '%')) OR " +
           "LOWER(c.telefone) LIKE LOWER(CONCAT('%', :termo2, '%')) OR " +
           "LOWER(c.email) LIKE LOWER(CONCAT('%', :termo3, '%'))")
    List<Contato> findByNomeContainingOrTelefoneContainingOrEmailContaining(String termo1, String termo2, String termo3);

    // Filtro por categoria
    List<Contato> findByCategoria(String categoria);
    
    // Filtro por favoritos
    List<Contato> findByFavoritoTrue();
}
