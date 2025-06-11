package br.gov.sp.fatec.itu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.gov.sp.fatec.itu.entities.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

    // pensar... [filtro, etc]

}
