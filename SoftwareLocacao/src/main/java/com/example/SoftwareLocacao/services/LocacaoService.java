package com.example.SoftwareLocacao.services;


import com.example.SoftwareLocacao.models.Grupo;
import com.example.SoftwareLocacao.models.Locacao;
import com.example.SoftwareLocacao.models.Motorista;
import com.example.SoftwareLocacao.models.UsuarioCliente;
import com.example.SoftwareLocacao.pdfDocument.Document;
import com.example.SoftwareLocacao.repositories.LocacaoRepository;
import com.example.SoftwareLocacao.services.exceptions.DataIntegrityViolationException;
import com.example.SoftwareLocacao.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class LocacaoService {

    @Autowired
    private LocacaoRepository locacaoRepository;

    @Autowired
    private UsuarioClienteService usuarioClienteService;

    @Autowired
    private MotoristaService motoristaService;

    @Autowired
    private GrupoService grupoService;

    public Locacao findLocacaoById(Long id){
        Optional<Locacao> locacao = this.locacaoRepository.findById(id);
        return locacao.orElseThrow( () -> new ObjectNotFoundException(
                "Usuário não encontrado! id: " + id + ", Tipo: " + Locacao.class.getName()
        ));
    }

    @Transactional
    public Locacao createLocacao(Locacao obj){
        String nomeMotorista;

        if (obj.getDataHoraDevolucao() == null || obj.getDataHoraRetirada() == null){
            throw new DataIntegrityViolationException("Campos obrigatórios não foram preenchidos!");
        }

        obj.setId(null);
        UsuarioCliente usuario = this.usuarioClienteService.findById(obj.getUsuario().getId());
        Grupo grupo = this.grupoService.findGrupoById(obj.getGrupo().getId());

        if (obj.getMotorista() != null){
            Motorista motorista = this.motoristaService.findMotoristaById(obj.getMotorista().getId());
            nomeMotorista = motorista.getNome();
        }
        else{
            nomeMotorista = usuario.getNome();
        }

        obj.setUsuario(usuario);
        obj = this.locacaoRepository.save(obj);

        new Document(usuario.getNome(), obj.getDataHoraRetirada(), obj.getDataHoraDevolucao(), grupo.getClassificacao(),
                grupo.getValorGrupo(), nomeMotorista);
        return obj;
    }
    @Transactional
    public Locacao updateLocacao(Locacao obj) {
        Locacao newObj = findLocacaoById(obj.getId());
        newObj.setDataHoraDevolucao(obj.getDataHoraDevolucao());
        newObj.setDataHoraRetirada(obj.getDataHoraRetirada());
        return this.locacaoRepository.save(newObj);
    }

    public void deleteLocacao(Long id){
        findLocacaoById(id);
        try {
            this.locacaoRepository.deleteById(id);
        } catch (Exception e){
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }
}
