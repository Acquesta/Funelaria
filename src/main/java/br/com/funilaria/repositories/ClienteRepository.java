package br.com.funilaria.repositories;

import br.com.funilaria.models.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    boolean existsByCpf(String cpf);

    boolean existsByEmail(String email);

    boolean existsByNumero(String numero);

    Optional<Cliente> findByIdAndAtivoTrue(Long id);

    Page<Cliente> findAllByAtivoTrue(Pageable pageable);
}
