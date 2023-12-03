package com.example.SoftwareLocacao;

import com.example.SoftwareLocacao.models.UsuarioCliente;
import com.example.SoftwareLocacao.repositories.UsuarioClienteRepository;
import com.example.SoftwareLocacao.services.UsuarioClienteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UsuarioClienteControllerTest {

    @InjectMocks
    private UsuarioClienteService usuarioClienteService;

    @Mock
    private UsuarioClienteRepository usuarioClienteRepository;

    @Test
    void salvarUsuarioComSucesso(){
        var usuario = new UsuarioCliente();
        usuario.setId(9l);
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

        /*var usuarioCadastradoCaptor = ArgumentCaptor.forClass(UsuarioCliente.class);

        assertEquals(usuario.getId(), usuarioCadastradoCaptor.getValue().getId());
        assertEquals(usuario.getNome(), usuarioCadastradoCaptor.getValue().getNome());
        assertEquals(usuario.getEmail(), usuarioCadastradoCaptor.getValue().getEmail());
        assertEquals(usuario.getSenha(), usuarioCadastradoCaptor.getValue().getSenha());
        assertEquals(usuario.getCpf(), usuarioCadastradoCaptor.getValue().getCpf());
        assertEquals(usuario.getDtNascimento(), usuarioCadastradoCaptor.getValue().getDtNascimento());
        assertEquals(usuario.getEndereco(), usuarioCadastradoCaptor.getValue().getEndereco());*/

    }
}
