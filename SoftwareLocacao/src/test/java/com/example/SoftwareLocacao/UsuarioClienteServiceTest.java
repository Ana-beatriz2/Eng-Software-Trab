package com.example.SoftwareLocacao;

import com.example.SoftwareLocacao.models.UsuarioCliente;
import com.example.SoftwareLocacao.repositories.UsuarioClienteRepository;
import com.example.SoftwareLocacao.services.UsuarioClienteService;
import com.example.SoftwareLocacao.services.exceptions.DataIntegrityViolationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UsuarioClienteServiceTest {

    @InjectMocks
    private UsuarioClienteService usuarioClienteService;

    @Mock
    private UsuarioClienteRepository usuarioClienteRepository;

    @Test
    void salvarUsuarioComSucesso(){
        var usuario = new UsuarioCliente();
        usuario.setNome("Kayky");
        usuario.setEmail("teste20@teste.com");
        usuario.setSenha("123321");
        usuario.setCpf("112345543202");
        usuario.setDtNascimento("05/06/1999");
        usuario.setEndereco("Rua da Ameixa, 8");

        when(usuarioClienteRepository.save(usuario)).thenReturn(usuario);
        var usuarioSalvo = usuarioClienteService.create(usuario);
        assertEquals(usuario.getId(), usuarioSalvo.getId());

        verify(usuarioClienteRepository, times(1)).save(usuario);

    }

    @Test
    void cadastroCampoObrigatorioFaltando(){
        var usuario = new UsuarioCliente();
        usuario.setNome("Kayky");
        usuario.setEmail("teste20@teste.com");
        usuario.setSenha("123321");
        usuario.setCpf("112345543202");
        usuario.setDtNascimento("05/06/1999");
        usuario.setEndereco("Rua da Ameixa, 8");

        usuario.setNome(null);

        assertThrows(DataIntegrityViolationException.class, () -> usuarioClienteService.create(usuario));
    }

    @Test
    void cadastroQuandoJaExisteNomeCadastrado(){
        var usuario = new UsuarioCliente();
        usuario.setNome("Kayky");
        usuario.setEmail("teste20@teste.com");
        usuario.setSenha("123321");
        usuario.setCpf("112345543202");
        usuario.setDtNascimento("05/06/1999");
        usuario.setEndereco("Rua da Ameixa, 8");

        when(usuarioClienteRepository.findByNome(usuario.getNome())).thenReturn(usuario);

        assertThrows(DataIntegrityViolationException.class, () -> usuarioClienteService.create(usuario));
        verify(usuarioClienteRepository, never()).save(usuario);
    }
}
