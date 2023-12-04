package com.example.SoftwareLocacao;

import com.example.SoftwareLocacao.models.Motorista;
import com.example.SoftwareLocacao.repositories.MotoristaRepository;
import com.example.SoftwareLocacao.services.MotoristaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MotoristaServiceTest {

    @InjectMocks
    private MotoristaService motoristaService;

    @Mock
    private MotoristaRepository motoristaRepository;

    @Test
    void salvarMotoristaComSucesso(){
        var motorista = new Motorista();
        motorista.setAds("127123128");
        motorista.setCnh("100090");
        motorista.setCpf("123320");
        motorista.setDtNascimento("02/12/2000");
        motorista.setEmail("teste6@teste.com");
        motorista.setNome("Pablão");

        when(motoristaRepository.save(motorista)).thenReturn(motorista);

        var motoristaSalvo = motoristaService.createMotorista(motorista);
        assertEquals(motorista.getId(), motoristaSalvo.getId());

        verify(motoristaRepository, times(1)).save(motorista);
    }
}
