package com.example.SoftwareLocacao;

import com.example.SoftwareLocacao.models.Filial;
import com.example.SoftwareLocacao.models.Grupo;
import com.example.SoftwareLocacao.models.Locacao;
import com.example.SoftwareLocacao.models.UsuarioCliente;
import com.example.SoftwareLocacao.repositories.LocacaoRepository;
import com.example.SoftwareLocacao.services.FilialService;
import com.example.SoftwareLocacao.services.GrupoService;
import com.example.SoftwareLocacao.services.LocacaoService;
import com.example.SoftwareLocacao.services.UsuarioClienteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LocacaoServiceTest {

    @InjectMocks
    private LocacaoService locacaoService;

    @Mock
    private LocacaoRepository locacaoRepository;

    @Mock
    private UsuarioClienteService usuarioClienteService;

    @Mock
    private GrupoService grupoService;

    @Mock
    private FilialService filialService;

    @Test
    void salvarLocacaoComSucesso(){
        Filial filial = new Filial();
        filial.setEndereco("Rua das couves");
        filial.setCep("123123123");
        filial.setCnpj("121111111");
        filial.setId(1L);

        UsuarioCliente usuario = new UsuarioCliente();
        usuario.setNome("Joel");
        usuario.setSenha("123123");
        usuario.setEndereco( "Rua Roberto da Silva, 8");
        usuario.setEmail("teste7@teste.com");
        usuario.setCpf("12312312311");
        usuario.setDtNascimento("05/06/1999");
        usuario.setId(1L);

        Grupo grupo = new Grupo();
        grupo.setClassificacao("A");
        grupo.setValorGrupo(150);
        grupo.setId(1L);

        Locacao locacao = new Locacao();
        locacao.setDataHoraDevolucao("29/12/2023 as 13:00");
        locacao.setDataHoraRetirada("31/12/2023 as 08:00");
        locacao.setFilialDeEntrega(filial);
        locacao.setFilialDeRetirada(filial);
        locacao.setUsuario(usuario);
        locacao.setGrupo(grupo);
        locacao.setValorTotal(400F);

        UsuarioCliente usuarioMock = mock(UsuarioCliente.class);
        when(usuarioClienteService.findById(1L)).thenReturn(usuarioMock);

        Filial filialMock = mock(Filial.class);
        when(filialService.findFilialById(1L)).thenReturn(filialMock);

        Grupo grupoMock = mock(Grupo.class);
        when(grupoService.findGrupoById(1L)).thenReturn(grupoMock);

        when(locacaoRepository.save(locacao)).thenReturn(locacao);

        var locacaoSalva = locacaoService.createLocacao(locacao);
        assertEquals(locacao.getId(), locacaoSalva.getId());

        verify(locacaoRepository, times(1)).save(locacao);
    }
}
