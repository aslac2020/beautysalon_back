package com.salaohair.api.services;


import com.salaohair.api.dto.request.ClienteRequest;
import com.salaohair.api.dto.response.ClienteResponse;

import java.util.List;

public interface ClienteService {
    ClienteResponse findClienteById(Long clienteId);
    List<ClienteResponse> findAllClientes();
    ClienteResponse createCliente(ClienteRequest request);
    ClienteResponse updateCliente(Long clienteId, ClienteRequest request);
    void deleteCliente(Long clienteId);

}
