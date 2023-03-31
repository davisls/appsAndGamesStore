package br.com.ada.store.controller;

import br.com.ada.store.domain.Game;
import br.com.ada.store.dto.GameSaveDTO;
import br.com.ada.store.mapper.GameMapper;
import br.com.ada.store.service.GameService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/game")
@RestController
public class GameController {

    private final GameService gameService;
    private final GameMapper gameMapper;

    @GetMapping
    public List<Game> list() {
        return gameService.list();
    }

    @GetMapping("{id}")
    public Game getById(@PathVariable Long id) {
        return gameService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Game save(@Valid @RequestBody GameSaveDTO dto) {
        Game game = gameMapper.gameSaveDTOToGame(dto);
        return gameService.save(game);
    }

    @PutMapping("{id}")
    public Game update(@PathVariable Long id, @RequestBody GameSaveDTO dto) {
        Game game = gameMapper.gameSaveDTOToGame(dto);
        return gameService.update(game, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        gameService.delete(id);
    }

}
