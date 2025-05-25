package com.fema.ControleQuilometragem.Abastecimento;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
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

    // Listar Abastecimentos por ID
    public AbastecimentoDTO listarAbastecimentosPorId(Long id){
        Optional<AbastecimentoModel> abastecimentoPorId = abastecimentoRepository.findById(id);
        return abastecimentoPorId.map(abastecimentoMapper::map).orElse(null);
    }

    // Deletar um abastecimento
    public void deletarAbastecimentoPorId(Long id){
        abastecimentoRepository.deleteById(id);
    }

    // Atualizar Abastecimento
    public AbastecimentoDTO atualizarAbastecimento(Long id, AbastecimentoDTO abastecimentoDTO){
        Optional<AbastecimentoModel> abastecimentoExistente = abastecimentoRepository.findById(id);
        if(abastecimentoExistente.isPresent()){
            AbastecimentoModel abastecimentoAtualizado = abastecimentoMapper.map(abastecimentoDTO);
            abastecimentoAtualizado.setId(id);
            AbastecimentoModel abastecimentoSalvo = abastecimentoRepository.save(abastecimentoAtualizado);
            return abastecimentoMapper.map(abastecimentoSalvo);
        }
        return null;
    }
}
