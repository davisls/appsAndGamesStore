package br.com.ada.store.mapper;

import br.com.ada.store.domain.Game;
import br.com.ada.store.dto.GameSaveDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GameMapper {

    @Mapping(target = "id", ignore = true)
    Game gameSaveDTOToGame(GameSaveDTO dto);

}
