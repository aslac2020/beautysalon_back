package com.salaohair.api.mapper;

import com.salaohair.api.dto.request.ProfissionalRequest;
import com.salaohair.api.dto.response.ProfissionalResponse;
import com.salaohair.api.models.Profissional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProfissionalMapperTest {


    @Autowired
    private ModelMapper modelMapper;

    @BeforeEach
    public void setUp(){
        modelMapper = new ModelMapper();
    }


    @Test
    public void testToProfissional() {
        ProfissionalRequest request = new ProfissionalRequest( );
        request.setNome("Andre");
        request.setTelefone("111111111");
        request.setEspecialidades("teste");

        Profissional profissional = modelMapper.map(request, Profissional.class);

        assertEquals(request.getNome(), profissional.getNome());
        assertEquals(request.getTelefone(), profissional.getTelefone());
        assertEquals(request.getEspecialidades(), profissional.getEspecialidades());
    }

    @Test
    public void testToProfissionalRequest() {
        Profissional profissional = new Profissional(1L, "Teste", "1212121", "corte");
        ProfissionalRequest request = modelMapper.map(profissional, ProfissionalRequest.class);


        assertEquals(profissional.getNome(), request.getNome());
        assertEquals( profissional.getTelefone(), request.getTelefone());
        assertEquals(profissional.getEspecialidades(), request.getEspecialidades());
    }

    @Test
    public void testToProfissionalResponse() {
        Profissional profissional = new Profissional(1L, "Teste", "1212121", "corte");
        ProfissionalResponse response = modelMapper.map(profissional, ProfissionalResponse.class);

        assertEquals(profissional.getId(), response.getId());
        assertEquals(profissional.getNome(), response.getNome());
        assertEquals( profissional.getTelefone(), response.getTelefone());
        assertEquals(profissional.getEspecialidades(), response.getEspecialidades());
    }

}
