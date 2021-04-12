package com.api.minhasaudeapi.repository;

import com.api.minhasaudeapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByCpf(String cpf);

    List<Cliente> findByNome(String nome);

    List<Cliente> findByNascimentoIsAfter(String data);

    Cliente deleteByCpf(String cpf);
}