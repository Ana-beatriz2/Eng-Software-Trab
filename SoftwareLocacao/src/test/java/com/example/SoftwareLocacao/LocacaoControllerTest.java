package com.example.SoftwareLocacao;

import com.example.SoftwareLocacao.controllers.LocacaoController;
import com.example.SoftwareLocacao.models.*;
import com.example.SoftwareLocacao.services.FilialService;
import com.example.SoftwareLocacao.services.GrupoService;
import com.example.SoftwareLocacao.services.MotoristaService;
import com.example.SoftwareLocacao.services.UsuarioClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LocacaoControllerTest {

    @InjectMocks
    private LocacaoController locacaoController;

    private Locacao locacao;

    @Mock
    private UsuarioClienteService usuarioClienteService;

    @Mock
    private MotoristaService motoristaService;

    @Mock
    private FilialService filalService;

    @Mock
    private GrupoService grupoService;

    @BeforeEach
    void setup(){
        Filial filialRetirada = this.filalService.findFilialById(4L);
        Filial filialDevolucao = this.filalService.findFilialById(3L);
        Filial filialEntregaReal = this.filalService.findFilialById(3L);
        Grupo grupo = this.grupoService.findGrupoById(2L);
        UsuarioCliente usuario = this.usuarioClienteService.findById(1L);
        Motorista motorista = this.motoristaService.findMotoristaById(1L);

        locacao = new Locacao(40L, "29/12/2023 as 13:00", "31/12/2023 as 08:00", filialEntregaReal, usuario, motorista, grupo, filialRetirada, filialDevolucao, 400f);
    }

    @Test
    void deveSalvarLocacao(){
        locacaoController.createLocacao(locacao);
    }
}
