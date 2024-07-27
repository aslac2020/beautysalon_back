package com.salaohair.api.mapper;

import com.salaohair.api.dto.request.ClienteRequest;
import com.salaohair.api.dto.response.ClienteResponse;
import com.salaohair.api.enums.TipoUsuario;
import com.salaohair.api.models.Cliente;
import com.salaohair.api.models.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ClienteMapperTest {

    @Autowired
    private ModelMapper modelMapper;

    @BeforeEach
    public void setUp(){
        modelMapper = new ModelMapper();
    }

    @Test
    public void testToCliente() {
        var dataCriacao = new Date();

        var usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Andre");
        usuario.setEmail("teste@teste.com");
        usuario.setTipoUsuario(TipoUsuario.USER);
        usuario.setDataCriacao(dataCriacao);

        ClienteRequest request = new ClienteRequest("Andre", "teste@teste.com", "1144425678", "11987654563", usuario.getId());
        Cliente cliente = modelMapper.map(request, Cliente.class);

        assertEquals(request.getNome(), cliente.getNome());
        assertEquals(request.getEmail(), cliente.getEmail());
        assertEquals(request.getTelefone(), cliente.getTelefone());
        assertEquals(request.getCelular(), cliente.getCelular());
        assertEquals(request.getUsuarioId(), cliente.getUsuario().getId());

    }

    @Test
    public void testToClienteRequest() {
        var dataCriacao = new Date();

        var usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Andre");
        usuario.setEmail("teste@teste.com");
        usuario.setTipoUsuario(TipoUsuario.USER);
        usuario.setDataCriacao(dataCriacao);

        Cliente cliente = new Cliente(1L, "Joice", "teste@teste.com", "112343433", "11212121", usuario);
        ClienteRequest request = modelMapper.map(cliente, ClienteRequest.class);


        assertEquals(cliente.getNome(), request.getNome());
        assertEquals(cliente.getTelefone(), request.getTelefone());
        assertEquals(cliente.getCelular(), request.getCelular());
        assertEquals(cliente.getEmail(), request.getEmail());
        assertEquals(cliente.getUsuario().getId(), request.getUsuarioId());


    }

    @Test
    public void testToClienteResponse() {
        var dataCriacao = new Date();

        var usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Andre");
        usuario.setEmail("teste@teste.com");
        usuario.setTipoUsuario(TipoUsuario.USER);
        usuario.setDataCriacao(dataCriacao);

        Cliente cliente = new Cliente(1L, "Joice", "teste@teste.com", "112343433", "11212121", usuario);
        ClienteResponse response = modelMapper.map(cliente, ClienteResponse.class);


        assertEquals(cliente.getNome(), response.getNome());
        assertEquals(cliente.getTelefone(), response.getTelefone());
        assertEquals(cliente.getCelular(), response.getCelular());
        assertEquals(cliente.getEmail(), response.getEmail());
        assertEquals(cliente.getUsuario().getId(), response.getUsuarioId());


    }

}
