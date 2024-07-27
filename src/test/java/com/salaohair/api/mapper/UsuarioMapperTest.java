package com.salaohair.api.mapper;

import com.salaohair.api.dto.request.UsuarioRequest;
import com.salaohair.api.dto.response.UsuarioResponse;
import com.salaohair.api.enums.TipoUsuario;
import com.salaohair.api.models.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UsuarioMapperTest {

    @Autowired
    private ModelMapper modelMapper;

    @BeforeEach
    public void setUp(){
        modelMapper = new ModelMapper();
    }

    @Test
    public void testToUsuario() {
        var dataCriacao = new Date();
        UsuarioRequest request = new UsuarioRequest("Andre", "teste@teste.com", "1234", TipoUsuario.ADMIN, dataCriacao);
        Usuario usuario = modelMapper.map(request, Usuario.class);

        assertEquals(request.getNome(), usuario.getNome());
        assertEquals(request.getTipoUsuario(), usuario.getTipoUsuario());
        assertEquals(request.getEmail(), usuario.getEmail());
        assertEquals(request.getSenha(), usuario.getSenha());
        assertEquals(request.getDataCriacao(), usuario.getDataCriacao());
    }

    @Test
    public void testToUsuarioRequest() {
        var dataCriacao = new Date();
        Usuario usuario = new Usuario(1L,"Andre", "teste@teste.com", "1234", TipoUsuario.ADMIN, dataCriacao);
        UsuarioRequest request = modelMapper.map(usuario, UsuarioRequest.class);


        assertEquals(usuario.getNome(), request.getNome());
        assertEquals( usuario.getTipoUsuario(), request.getTipoUsuario());
        assertEquals(usuario.getSenha(), request.getSenha());
        assertEquals(usuario.getEmail(), request.getEmail());
        assertEquals(usuario.getDataCriacao(), request.getDataCriacao());
    }

    @Test
    public void testToUsuarioResponse() {
        var dataCriacao = new Date();
        Usuario usuario = new Usuario(1L,"Andre", "teste@teste.com", "1234", TipoUsuario.ADMIN, dataCriacao);
        UsuarioResponse response = modelMapper.map(usuario, UsuarioResponse.class);


        assertEquals(usuario.getNome(), response.getNome());
        assertEquals( usuario.getTipoUsuario(), response.getTipoUsuario());
        assertEquals(usuario.getSenha(), response.getSenha());
        assertEquals(usuario.getEmail(), response.getEmail());
        assertEquals(usuario.getDataCriacao(), response.getDataCriacao());
    }

}
