package br.com.ada.store.service;

import br.com.ada.store.domain.Application;
import br.com.ada.store.exception.ApplicationNotFoundException;
import br.com.ada.store.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Override
    public List<Application> list() {
        return (List<Application>) applicationRepository.findAll();
    }

    @Override
    public Application save(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public Application findById(Long id) {
        if (!applicationRepository.existsById(id)) {
            throw new ApplicationNotFoundException();
        }
        return applicationRepository.findById(id).get();
    }

    @Override
    public Application update(Application application, Long id) {
        if (!applicationRepository.existsById(id)) {
            throw new ApplicationNotFoundException();
        }
        application.setId(id);
        return applicationRepository.save(application);
    }

    @Override
    public void delete(Long id) {
        if (!applicationRepository.existsById(id)) {
            throw new ApplicationNotFoundException();
        }
        applicationRepository.deleteById(id);
    }

}
