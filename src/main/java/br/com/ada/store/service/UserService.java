package br.com.ada.store.service;

import br.com.ada.store.domain.User;
import br.com.ada.store.dto.UserSaveDTO;

import java.util.List;

public interface UserService {
    List<User> list();
    User save(User user);
    User findById(Long id);
    User update(User user, Long id);
    void delete(Long id);
}
