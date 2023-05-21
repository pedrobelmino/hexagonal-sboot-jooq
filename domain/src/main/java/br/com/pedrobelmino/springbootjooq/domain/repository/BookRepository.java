package br.com.pedrobelmino.springbootjooq.domain.repository;

import br.com.pedrobelmino.springbootjooq.domain.pojo.BookDTO;

import java.util.Optional;

public interface BookRepository {

    Optional<BookDTO> getById(int id);
}
