package com.fema.ControleQuilometragem.Posto;
import org.springframework.stereotype.Component;

@Component
public class PostoMapper {

        public PostoModel map(PostoDTO postoDTO){
            PostoModel postoModel = new PostoModel();
            postoModel.setId(postoDTO.getId());
            postoModel.setNome(postoDTO.getNome());
            postoModel.setCidade(postoDTO.getCidade());
            postoModel.setEstado(postoDTO.getEstado());
            return postoModel;
        }

        public PostoDTO map(PostoModel postoModel){
            PostoDTO postoDTO = new PostoDTO();
            postoDTO.setId(postoModel.getId());
            postoDTO.setNome(postoModel.getNome());
            postoDTO.setCidade(postoModel.getCidade());
            postoDTO.setEstado(postoModel.getEstado());

            return postoDTO;
        }
}
