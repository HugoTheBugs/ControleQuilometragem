package com.fema.ControleQuilometragem.Veiculo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final VeiculoMapper veiculoMapper;

    public VeiculoService(VeiculoRepository veiculoRepository, VeiculoMapper veiculoMapper){
        this.veiculoRepository = veiculoRepository;
        this.veiculoMapper = veiculoMapper;
    }

    //Criar novo Veículo
    public VeiculoDTO criarVeiculo(VeiculoDTO veiculoDTO){
        VeiculoModel veiculo = veiculoMapper.map(veiculoDTO);
        veiculo = veiculoRepository.save(veiculo);
        return veiculoMapper.map(veiculo);
    }

    //Listar todos os Veículos
    public List<VeiculoDTO> listarVeiculos(){
        List<VeiculoModel> veiculos = veiculoRepository.findAll();
        return veiculos.stream()
                .map(veiculoMapper::map)
                .collect(Collectors.toList());
    }

    // Listar Veiculos por ID
    public VeiculoDTO listarVeiculosPorId(Long id){
        Optional<VeiculoModel> veiculoPorId = veiculoRepository.findById(id);
        return veiculoPorId.map(veiculoMapper::map).orElse(null);
    }

    // Deletar um veiculo
    public void deletarVeiculoPorId(Long id){
        veiculoRepository.deleteById(id);
    }

    // Atualizar Veiculo
    public VeiculoDTO atualizarVeiculo(Long id, VeiculoDTO veiculoDTO){
        Optional<VeiculoModel> veiculoExistente = veiculoRepository.findById(id);
        if(veiculoExistente.isPresent()){
            VeiculoModel veiculoAtualizado = veiculoMapper.map(veiculoDTO);
            veiculoAtualizado.setId(id);
            VeiculoModel veiculoSalvo = veiculoRepository.save(veiculoAtualizado);
            return veiculoMapper.map(veiculoSalvo);
        }
        return null;
    }
}
