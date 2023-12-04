package com.example.SoftwareLocacao;

import com.example.SoftwareLocacao.models.*;
import com.example.SoftwareLocacao.repositories.PagamentoRepository;
import com.example.SoftwareLocacao.services.LocacaoService;
import com.example.SoftwareLocacao.services.PagamentoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PagamentoServiceTest {

    @InjectMocks
    private PagamentoService pagamentoService;

    @Mock
    private PagamentoRepository pagamentoRepository;

    @Mock
    private LocacaoService locacaoService;

    @Test
    void salvarPagamentoComSucesso(){

        //Locacao locacao = this.locacaoService.findLocacaoById(2L);

       // System.out.print(locacao.getId());

        Filial filialEntrega = new Filial();
        filialEntrega.setEndereco("Rua das couves");
        filialEntrega.setCep("123123123");
        filialEntrega.setCnpj("121111111");

        Filial filialRetirada = new Filial();
        filialEntrega.setEndereco("Rua das couves 2");
        filialEntrega.setCep("123123128");
        filialEntrega.setCnpj("121111191");

        UsuarioCliente usuario = new UsuarioCliente();
        usuario.setNome("Joel");
        usuario.setSenha("123123");
        usuario.setEndereco( "Rua Roberto da Silva, 8");
        usuario.setEmail("teste7@teste.com");
        usuario.setCpf("12312312311");
        usuario.setDtNascimento("05/06/1999");

        Grupo grupo = new Grupo();
        grupo.setClassificacao("A");
        grupo.setValorGrupo(150);

        Locacao locacao = new Locacao();
        locacao.setDataHoraDevolucao("29/12/2023 as 13:00");
        locacao.setDataHoraRetirada("31/12/2023 as 08:00");
        locacao.setFilialDeEntrega(filialEntrega);
        locacao.setFilialDeRetirada(filialRetirada);
        locacao.setUsuario(usuario);
        locacao.setGrupo(grupo);
        locacao.setValorTotal(400F);

        var pagamento = new Pagamento();
        pagamento.setValor(200);
        pagamento.setNumBanco(3);
        pagamento.setData("12/12/2023");
        pagamento.setStatus("aprovado");
        pagamento.setTipo("pix");
        pagamento.setLocacao(locacao);

        when(pagamentoRepository.save(pagamento)).thenReturn(pagamento);

        var pagamentoSalvo = pagamentoService.createPagamento(pagamento);
        assertEquals(pagamento.getId(), pagamentoSalvo.getId());

        verify(pagamentoRepository, times(1)).save(pagamento);
    }
}
