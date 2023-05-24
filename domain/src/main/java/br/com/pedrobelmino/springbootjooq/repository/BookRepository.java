package br.com.pedrobelmino.springbootjooq.repository;

import br.com.pedrobelmino.springbootjooq.domain.BookDTO;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    Optional<BookDTO> findOne(int id);

    List<BookDTO> findAll();
}
