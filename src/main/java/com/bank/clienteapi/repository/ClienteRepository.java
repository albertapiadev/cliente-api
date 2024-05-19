package com.bank.clienteapi.repository;

import com.bank.clienteapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByNumeroCuenta(String numeroCuenta);
    Optional<Cliente> findByNumeroCuenta(String numeroCuenta);
}