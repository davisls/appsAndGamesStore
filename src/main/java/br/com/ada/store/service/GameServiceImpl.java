package br.com.ada.store.service;

import br.com.ada.store.domain.Game;
import br.com.ada.store.exception.GameNotFoundException;
import br.com.ada.store.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    @Override
    public List<Game> list() {
        return (List<Game>) gameRepository.findAll();
    }

    @Override
    public Game save(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public Game findById(Long id) {
        if (!gameRepository.existsById(id)) {
            throw new GameNotFoundException();
        }
        return gameRepository.findById(id).get();
    }

    @Override
    public Game update(Game game, Long id) {
        if (!gameRepository.existsById(id)) {
            throw new GameNotFoundException();
        }
        game.setId(id);
        return gameRepository.save(game);
    }

    @Override
    public void delete(Long id) {
        if (!gameRepository.existsById(id)) {
            throw new GameNotFoundException();
        }
        gameRepository.deleteById(id);
    }
}
