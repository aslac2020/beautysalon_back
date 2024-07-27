package com.salaohair.api.mapper;

import com.salaohair.api.dto.request.ClienteRequest;
import com.salaohair.api.dto.request.FinanceiroRequest;
import com.salaohair.api.dto.response.ClienteResponse;
import com.salaohair.api.dto.response.FinanceiroResponse;
import com.salaohair.api.enums.TipoTransacao;
import com.salaohair.api.enums.TipoUsuario;
import com.salaohair.api.models.Cliente;
import com.salaohair.api.models.Financeiro;
import com.salaohair.api.models.Profissional;
import com.salaohair.api.models.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FinanceiroMapperTest {

    @Autowired
    private ModelMapper modelMapper;

    @BeforeEach
    public void setUp(){
        modelMapper = new ModelMapper();
    }

    @Test
    public void testToFinances() {

        var dataTransacao = new Date();

        var profissional = new Profissional();
        profissional.setId(1L);
        profissional.setNome("Andre");
        profissional.setTelefone("1145346787");
        profissional.setEspecialidades("Cabeleireiro");

        FinanceiroRequest request = new FinanceiroRequest(profissional.getId(), TipoTransacao.ENTRADA, dataTransacao, 100.00, "compra de material");
        Financeiro financeiro = modelMapper.map(request, Financeiro.class);

        assertEquals(request.getDescricao(), financeiro.getDescricao());
        assertEquals(request.getValor(), financeiro.getValor());
        assertEquals(request.getTipoTransacao(), financeiro.getTipoTransacao());
        assertEquals(request.getDataTransacao(), financeiro.getDataTransacao());
        assertEquals(request.getProfissionalId(), financeiro.getProfissional().getId());

    }

    @Test
    public void testToFinancesRequest() {
        var dataCriacao = new Date();

        var profissional = new Profissional();
        profissional.setId(1L);
        profissional.setNome("Andre");
        profissional.setTelefone("1145346787");
        profissional.setEspecialidades("Cabeleireiro");

        Financeiro financeiro = new Financeiro(1L, profissional, TipoTransacao.ENTRADA, dataCriacao, 100.00, "corte de cabelo");
        FinanceiroRequest request = modelMapper.map(financeiro, FinanceiroRequest.class);


        assertEquals(financeiro.getValor(), request.getValor());
        assertEquals(financeiro.getTipoTransacao(), request.getTipoTransacao());
        assertEquals(financeiro.getDataTransacao(), request.getDataTransacao());
        assertEquals(financeiro.getDescricao(),request.getDescricao());
        assertEquals(financeiro.getProfissional().getId(), request.getProfissionalId());


    }

    @Test
    public void testToFinancesResponse() {
        var dataCriacao = new Date();

        var profissional = new Profissional();
        profissional.setId(1L);
        profissional.setNome("Andre");
        profissional.setTelefone("1145346787");
        profissional.setEspecialidades("Cabeleireiro");

        Financeiro financeiro = new Financeiro(1L, profissional, TipoTransacao.ENTRADA, dataCriacao, 100.00, "corte de cabelo");
        FinanceiroResponse response = modelMapper.map(financeiro, FinanceiroResponse.class);


        assertEquals(financeiro.getValor(), response.getValor());
        assertEquals(financeiro.getTipoTransacao(), response.getTipoTransacao());
        assertEquals(financeiro.getDataTransacao(), response.getDataTransacao());
        assertEquals(financeiro.getDescricao(),response.getDescricao());
        assertEquals(financeiro.getProfissional().getId(), response.getProfissionalId());


    }

}
