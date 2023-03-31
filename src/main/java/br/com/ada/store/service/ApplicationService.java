package br.com.ada.store.service;

import br.com.ada.store.domain.Application;

import java.util.List;

public interface ApplicationService {
    List<Application> list();
    Application save(Application user);
    Application findById(Long id);
    Application update(Application user, Long id);
    void delete(Long id);
}
