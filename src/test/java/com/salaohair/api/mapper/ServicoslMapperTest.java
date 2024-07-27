package com.salaohair.api.mapper;

import com.salaohair.api.dto.request.ServicosRequest;
import com.salaohair.api.dto.response.ServicosResponse;
import com.salaohair.api.models.Servicos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ServicoslMapperTest {

    @Autowired
    private ModelMapper modelMapper;

    @BeforeEach
    public void setUp(){
        modelMapper = new ModelMapper();
    }



    @Test
    public void testToServices() {
        ServicosRequest request = new ServicosRequest( "Corte Cabelo", "cortou o cabelo", 60, 25.00);
        Servicos services = modelMapper.map(request, Servicos.class);

        assertEquals(request.getNome(), services.getNome());
        assertEquals(request.getDescricao(), services.getDescricao());
        assertEquals(request.getDuracaoMinutos(), services.getDuracaoMinutos());
        assertEquals(request.getValor(), services.getValor());

    }

    @Test
    public void testToServicesRequest() {
        Servicos services = new Servicos(1L, "Corte Cabelo", "cortou o cabelo", 60, 25.00);
        ServicosRequest request = modelMapper.map(services, ServicosRequest.class);

        assertEquals(request.getNome(), services.getNome());
        assertEquals(request.getDescricao(), services.getDescricao());
        assertEquals(request.getDuracaoMinutos(), services.getDuracaoMinutos());
        assertEquals(request.getValor(), services.getValor());

    }

    @Test
    public void testToServicesResponse() {
        Servicos services = new Servicos(1L, "Corte Cabelo", "cortou o cabelo", 60, 25.00);
        ServicosResponse response = modelMapper.map(services, ServicosResponse.class);

        assertEquals(response.getNome(), services.getNome());
        assertEquals(response.getDescricao(), services.getDescricao());
        assertEquals(response.getDuracaoMinutos(), services.getDuracaoMinutos());
        assertEquals(response.getValor(), services.getValor());

    }



}
