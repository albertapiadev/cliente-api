package com.bank.clienteapi.service;

import com.bank.clienteapi.dto.ClienteDto;
import com.bank.clienteapi.model.Cliente;

public interface ClienteService {
    Cliente registrarCliente(ClienteDto clienteDto);
    Cliente obtenerClientePorNumeroCuenta(String numeroCuenta);
    Cliente obtenerClientePorDni(String dni);
}