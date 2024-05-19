package com.bank.clienteapi.controller;

import com.bank.clienteapi.dto.ClienteDto;
import com.bank.clienteapi.model.Cliente;
import com.bank.clienteapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> registrarCliente(@RequestBody ClienteDto clienteDto) {
        Cliente cliente = clienteService.registrarCliente(clienteDto);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    @GetMapping("/{numeroCuenta}")
    public ResponseEntity<Cliente> obtenerClientePorNumeroCuenta(@PathVariable String numeroCuenta) {
        Cliente cliente = clienteService.obtenerClientePorNumeroCuenta(numeroCuenta);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<Cliente> obtenerClientePorDni(@PathVariable String dni) {
        Cliente cliente = clienteService.obtenerClientePorDni(dni);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }
}