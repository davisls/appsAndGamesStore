package br.com.ada.store.repository;

import br.com.ada.store.domain.Library;
import org.springframework.data.repository.CrudRepository;

public interface LibraryRepository extends CrudRepository<Library, Long> {
}
