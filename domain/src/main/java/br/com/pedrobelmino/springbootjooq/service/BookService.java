package br.com.pedrobelmino.springbootjooq.service;

import br.com.pedrobelmino.springbootjooq.domain.BookDomain;
import br.com.pedrobelmino.springbootjooq.exception.BookNotFoundException;
import br.com.pedrobelmino.springbootjooq.repository.BookRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Optional<BookDomain>  findOne(int id){
        return bookRepository.findOne(id);
    }

    public List<BookDomain> findAll(){
        return bookRepository.findAll();
    }

    public void update(BookDomain bookParam){
        var bookDbOpt = bookRepository.findOne(bookParam.id());

        bookDbOpt.orElseThrow(BookNotFoundException::new);

        bookDbOpt.ifPresent(bookDomain1 -> {
            bookRepository.update(bookParam);
        });
    }

}
