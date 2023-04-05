package br.com.ada.store.controller;

import br.com.ada.store.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/library/{libraryId}")
@RestController
public class LibraryController {

    private final LibraryService libraryService;

    @PostMapping("/add-game/{gameId}")
    public void addGameToLibrary(@PathVariable Long libraryId, @PathVariable Long gameId) {
        libraryService.addGame(libraryId, gameId);
    }

    @PostMapping("/add-app/{appId}")
    public void addApplicationToLibrary(@PathVariable Long libraryId, @PathVariable Long appId) {
        libraryService.addApp(libraryId, appId);
    }
}
