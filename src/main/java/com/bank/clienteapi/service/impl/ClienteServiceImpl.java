package com.bank.clienteapi.service.impl;

import com.bank.clienteapi.dto.ClienteDto;
import com.bank.clienteapi.exception.ClienteNotFoundException;
import com.bank.clienteapi.model.Cliente;
import com.bank.clienteapi.repository.ClienteRepository;
import com.bank.clienteapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente registrarCliente(ClienteDto clienteDto) {
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteDto.getNombre());
        cliente.setDni(clienteDto.getDni());
        cliente.setNumeroCuenta(generarNumeroCuentaUnico());
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente obtenerClientePorNumeroCuenta(String numeroCuenta) {
        return clienteRepository.findByNumeroCuenta(numeroCuenta)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente no encontrado"));
    }

    @Override
    public Cliente obtenerClientePorDni(String dni) {
        return clienteRepository.findByDni(dni)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente no encontrado"));
    }

    private String generarNumeroCuentaUnico() {
        return ThreadLocalRandom.current().ints(0, 10)
                .limit(10)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}