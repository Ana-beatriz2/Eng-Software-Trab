package com.example.SoftwareLocacao;

import com.example.SoftwareLocacao.controllers.UsuarioClienteController;
import com.example.SoftwareLocacao.models.UsuarioCliente;
import com.example.SoftwareLocacao.services.UsuarioClienteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UsuarioClienteControllerTest {

    @InjectMocks
    private UsuarioClienteController usuarioClienteController;

    @Mock
    private UsuarioClienteService usuarioClienteService;

    private UsuarioCliente usuario;

    void setup(){
        usuario = new UsuarioCliente( 8L, "Mare",  "teste7@teste.com", "123321", "112345543202", "05/06/1999", "Rua da Ameixa, 8", "123123123", 0, 1);
    }

    @Test
    void deveSalvarUsuario(){

        when(usuarioClienteService.create(usuario)).thenReturn();
        usuarioClienteController.createUsuario(usuario);
    }
}
