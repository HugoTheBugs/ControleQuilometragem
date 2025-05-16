package com.fema.ControleQuilometragem.Veiculo;

import org.springframework.stereotype.Service;

import java.util.List;
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
}
