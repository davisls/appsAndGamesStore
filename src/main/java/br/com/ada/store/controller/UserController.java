package br.com.ada.store.controller;

import br.com.ada.store.domain.Library;
import br.com.ada.store.domain.User;
import br.com.ada.store.dto.UserSaveDTO;
import br.com.ada.store.mapper.UserMapper;
import br.com.ada.store.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public List<User> list() {
        return userService.list();
    }

    @GetMapping("{id}")
    public User getById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("{id}/library")
    public Library getLibraryByUserId(@PathVariable Long id) {
        return userService.findById(id).getLibrary();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@Valid @RequestBody UserSaveDTO dto) {
        User user = userMapper.userSaveDTOToUser(dto);
        Library library = Library.builder()
                .games(new HashSet<>())
                .applications(new HashSet<>())
                .build();
        user.setLibrary(library);
        return userService.save(user);
    }

    @PutMapping("{id}")
    public User update(@PathVariable Long id, @RequestBody UserSaveDTO dto) {
        User user = userMapper.userSaveDTOToUser(dto);
        return userService.update(user, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

}
