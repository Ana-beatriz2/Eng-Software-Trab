package com.example.SoftwareLocacao;

import com.example.SoftwareLocacao.models.Locacao;
import com.example.SoftwareLocacao.models.Pagamento;
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
public class PagamentoControllerTest {

    @InjectMocks
    private PagamentoService pagamentoService;

    @Mock
    private PagamentoRepository pagamentoRepository;

    @Mock
    private LocacaoService locacaoService;

    @Test
    void salvarPagamentoComSucesso(){

        Locacao locacao = this.locacaoService.findLocacaoById(2L);

        System.out.print(locacao.getId());

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
