package br.com.pedrobelmino.springbootjooq.service;

import br.com.pedrobelmino.springbootjooq.domain.BookDTO;
import br.com.pedrobelmino.springbootjooq.repository.BookRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Optional<BookDTO>  findOne(int id){
        return bookRepository.findOne(id);
    }

    public List<BookDTO> findAll(){
        return bookRepository.findAll();
    }

}
