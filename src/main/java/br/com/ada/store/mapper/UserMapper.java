package br.com.ada.store.mapper;

import br.com.ada.store.domain.User;
import br.com.ada.store.dto.UserSaveDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User userSaveDTOToUser(UserSaveDTO dto);

}
