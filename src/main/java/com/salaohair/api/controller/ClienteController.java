package com.salaohair.api.controller;

import com.salaohair.api.dto.request.ClienteRequest;
import com.salaohair.api.dto.response.ClienteResponse;
import com.salaohair.api.services.impl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> findAllClients(){
        return new ResponseEntity<>(clienteService.findAllClientes(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> createClient(@RequestBody ClienteRequest request){
        return new ResponseEntity<>(clienteService.createCliente(request), HttpStatus.OK);
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<ClienteResponse>  findClienteById(@PathVariable Long clienteId){
        return new ResponseEntity<>(clienteService.findClienteById(clienteId), HttpStatus.OK);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<ClienteResponse> updateCliente(@RequestBody ClienteRequest request, @PathVariable Long clienteId ){
        return new ResponseEntity<>(clienteService.updateCliente(clienteId, request), HttpStatus.OK);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long clienteId ){
        clienteService.deleteCliente(clienteId);
        return ResponseEntity.noContent().build();
    }

}
