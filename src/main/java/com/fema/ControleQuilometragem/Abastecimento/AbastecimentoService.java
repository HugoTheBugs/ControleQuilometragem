package com.fema.ControleQuilometragem.Abastecimento;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AbastecimentoService {

    private final AbastecimentoRepository abastecimentoRepository;
    private final AbastecimentoMapper abastecimentoMapper;

    public AbastecimentoService(AbastecimentoRepository abastecimentoRepository, AbastecimentoMapper abastecimentoMapper){
        this.abastecimentoRepository = abastecimentoRepository;
        this.abastecimentoMapper = abastecimentoMapper;
    }

    //Realizar Abastecimento
    public AbastecimentoDTO criarAbastecimento(AbastecimentoDTO abastecimentoDTO){
        AbastecimentoModel abastecimento = abastecimentoMapper.map(abastecimentoDTO);
        abastecimento = abastecimentoRepository.save(abastecimento);
        return abastecimentoMapper.map(abastecimento);
    }

    //Listar Abastecimentos
    public List<AbastecimentoDTO> listarAbastecimento(){
        List<AbastecimentoModel> abastecimento = abastecimentoRepository.findAll();
        return abastecimento.stream()
                .map(abastecimentoMapper::map)
                .collect(Collectors.toList());
    }
}
