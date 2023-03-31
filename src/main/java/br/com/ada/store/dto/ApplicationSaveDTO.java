package br.com.ada.store.dto;

import br.com.ada.store.domain.ApplicationCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ApplicationSaveDTO {

    @NotBlank
    private String name;

    @NotNull
    private List<ApplicationCategory> categories;

}
