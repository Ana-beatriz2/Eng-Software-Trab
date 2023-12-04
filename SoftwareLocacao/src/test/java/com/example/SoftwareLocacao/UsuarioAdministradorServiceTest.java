package com.example.SoftwareLocacao;

import com.example.SoftwareLocacao.models.UsuarioAdministrador;
import com.example.SoftwareLocacao.repositories.UsuarioAdministradorRepository;
import com.example.SoftwareLocacao.services.UsuarioAdministradorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UsuarioAdministradorServiceTest {

    @InjectMocks
    private UsuarioAdministradorService usuarioAdministradorService;

    @Mock
    private UsuarioAdministradorRepository usuarioAdministradorRepository;

    @Test
    void salvarAdministradorComSucesso(){
        var usuario = new UsuarioAdministrador();
        usuario.setNome("Kayky");
        usuario.setEmail("teste20@teste.com");
        usuario.setSenha("123321");
        usuario.setCpf("112345543202");
        usuario.setDtNascimento("05/06/1999");
        usuario.setEndereco("Rua da Ameixa, 8");
        usuario.setCtps("123123");
        usuario.setStatusGerente(1);

        when(usuarioAdministradorRepository.save(usuario)).thenReturn(usuario);
        var usuarioSalvo = usuarioAdministradorService.create(usuario);
        assertEquals(usuario.getId(), usuarioSalvo.getId());

        verify(usuarioAdministradorRepository, times(1)).save(usuario);
    }
}
