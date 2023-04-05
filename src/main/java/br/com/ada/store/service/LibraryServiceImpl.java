package br.com.ada.store.service;

import br.com.ada.store.domain.Application;
import br.com.ada.store.domain.Game;
import br.com.ada.store.domain.Library;
import br.com.ada.store.exception.ApplicationNotFoundException;
import br.com.ada.store.exception.GameNotFoundException;
import br.com.ada.store.exception.LibraryNotFoundException;
import br.com.ada.store.repository.ApplicationRepository;
import br.com.ada.store.repository.GameRepository;
import br.com.ada.store.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibraryServiceImpl implements LibraryService {

    private final LibraryRepository libraryRepository;
    private final GameRepository gameRepository;
    private final ApplicationRepository applicationRepository;

    @Override
    public List<Game> listGames() {
        return null;
    }

    @Override
    public List<Application> listApps() {
        return null;
    }

    @Override
    public void addGame(Long libraryId, Long gameId) {
        Library library = libraryRepository.findById(libraryId).orElseThrow(LibraryNotFoundException::new);
        library.getGames().add(gameRepository.findById(gameId).orElseThrow(GameNotFoundException::new));
        libraryRepository.save(library);
    }

    @Override
    public void addApp(Long libraryId, Long appId) {
        Library library = libraryRepository.findById(libraryId).orElseThrow(LibraryNotFoundException::new);
        library.getApplications().add(applicationRepository.findById(appId).orElseThrow(ApplicationNotFoundException::new));
        libraryRepository.save(library);
    }
}
