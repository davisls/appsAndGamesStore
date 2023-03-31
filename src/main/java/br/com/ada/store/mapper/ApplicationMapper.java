package br.com.ada.store.mapper;

import br.com.ada.store.domain.Application;
import br.com.ada.store.dto.ApplicationSaveDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {

    @Mapping(target = "id", ignore = true)
    Application applicationSaveDTOToApplication(ApplicationSaveDTO dto);

}
