package br.com.ada.store.controller;

import br.com.ada.store.domain.Application;
import br.com.ada.store.domain.ApplicationCategory;
import br.com.ada.store.dto.ApplicationSaveDTO;
import br.com.ada.store.mapper.ApplicationMapper;
import br.com.ada.store.service.ApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/app")
@RestController
public class ApplicationController {

    private final ApplicationService applicationService;
    private final ApplicationMapper applicationMapper;

    @GetMapping
    public List<Application> list() {
        return applicationService.list();
    }

    @GetMapping("/category/{category}")
    public List<Application> listByCategories(@PathVariable ApplicationCategory category) {
        List<Application> allApps = applicationService.list();
        return allApps.stream().filter(app -> app.getCategories().contains(category)).toList();
    }

    @GetMapping("{id}")
    public Application getById(@PathVariable Long id) {
        return applicationService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Application save(@Valid @RequestBody ApplicationSaveDTO dto) {
        Application application = applicationMapper.applicationSaveDTOToApplication(dto);
        return applicationService.save(application);
    }

    @PutMapping("{id}")
    public Application update(@PathVariable Long id, @RequestBody ApplicationSaveDTO dto) {
        Application application = applicationMapper.applicationSaveDTOToApplication(dto);
        return applicationService.update(application, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        applicationService.delete(id);
    }

}