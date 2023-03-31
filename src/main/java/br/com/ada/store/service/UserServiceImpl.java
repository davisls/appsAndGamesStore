package br.com.ada.store.service;

import br.com.ada.store.domain.User;
import br.com.ada.store.exception.DuplicatedFieldException;
import br.com.ada.store.exception.UserNotFoundException;
import br.com.ada.store.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> list() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User save(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new DuplicatedFieldException("email");
        }
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException();
        }
        return userRepository.findById(id).get();
    }

    @Override
    public User update(User user, Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException();
        }
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException();
        }
        userRepository.deleteById(id);
    }
}
