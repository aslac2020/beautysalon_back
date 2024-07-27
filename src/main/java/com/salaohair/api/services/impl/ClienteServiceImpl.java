package com.salaohair.api.services.impl;

import com.salaohair.api.dto.request.ClienteRequest;
import com.salaohair.api.dto.response.ClienteResponse;
import com.salaohair.api.models.Cliente;
import com.salaohair.api.models.Usuario;
import com.salaohair.api.repository.ClienteRepository;
import com.salaohair.api.repository.UsuarioRepository;
import com.salaohair.api.services.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

   private final ClienteRepository repository;
   private final ModelMapper mapper;
   private final UsuarioRepository usuarioRepository;

   public ClienteServiceImpl(ClienteRepository repository, ModelMapper mapper, UsuarioRepository usuarioRepository){
       this.repository = repository;
       this.mapper = mapper;
       this.usuarioRepository = usuarioRepository;
   }


    @Override
    public ClienteResponse findClienteById(Long clienteId) {
        Cliente cliente = repository.findById(clienteId).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return mapper.map(cliente, ClienteResponse.class);
    }

    @Override
    public List<ClienteResponse> findAllClientes() {
        List<Cliente> clientes = repository.findAll();
        return clientes.stream()
                        .map(cliente ->mapper.map(cliente, ClienteResponse.class)).toList();
    }

    @Override
    public ClienteResponse createCliente(ClienteRequest request) {
        Cliente cliente = mapper.map(request, Cliente.class);
        Usuario usuario = usuarioRepository.findById(request.getUsuarioId()).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        cliente.setUsuario(usuario);
        cliente = repository.save(cliente);
        return mapper.map(cliente, ClienteResponse.class);
    }

    @Override
    public ClienteResponse updateCliente(Long idCliente, ClienteRequest request) {
        Cliente cliente = repository.findById(idCliente).orElseThrow(() -> new RuntimeException(String.valueOf(idCliente)));

        cliente.setNome(request.getNome());
        cliente.setEmail(request.getEmail());
        cliente.setTelefone(request.getTelefone());
        cliente.setCelular(request.getCelular());

        if(request.getUsuarioId() != null){
            Usuario usuario = usuarioRepository.findById(request.getUsuarioId()).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
            cliente.setUsuario(usuario);
        }

        cliente = repository.save(cliente);
        return mapper.map(cliente, ClienteResponse.class);

    }

    @Override
    public void deleteCliente(Long clienteId) {
        if(!repository.existsById(clienteId)){
           throw new RuntimeException("Cliente não encontrado !");
        }

        repository.deleteById(clienteId);
    }
}
