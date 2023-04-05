package br.com.ada.store.service;

import br.com.ada.store.domain.Application;
import br.com.ada.store.domain.Game;

import java.util.List;

public interface LibraryService {
    List<Game> listGames();
    List<Application> listApps();
    void addGame(Long libraryId, Long gameId);
    void addApp(Long libraryId, Long gameId);
}
