package br.com.pedrobelmino.springbootjooq.repository;

import br.com.pedrobelmino.springbootjooq.domain.BookDomain;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    Optional<BookDomain> findOne(int id);

    List<BookDomain> findAll();

    void update(BookDomain bookDomain);
}
