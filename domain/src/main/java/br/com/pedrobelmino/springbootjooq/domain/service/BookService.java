package br.com.pedrobelmino.springbootjooq.domain.service;

import br.com.pedrobelmino.springbootjooq.domain.pojo.BookDTO;
import br.com.pedrobelmino.springbootjooq.domain.repository.BookRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Optional<BookDTO>  getById(int id){
        return bookRepository.getById(id);
    }

}
