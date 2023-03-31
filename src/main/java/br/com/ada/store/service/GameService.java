package br.com.ada.store.service;

import br.com.ada.store.domain.Game;

import java.util.List;

public interface GameService {
    List<Game> list();
    Game save(Game user);
    Game findById(Long id);
    Game update(Game user, Long id);
    void delete(Long id);
}
