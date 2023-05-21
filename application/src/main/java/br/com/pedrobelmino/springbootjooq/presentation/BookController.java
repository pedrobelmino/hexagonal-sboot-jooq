package br.com.pedrobelmino.springbootjooq.presentation;

import br.com.pedrobelmino.springbootjooq.domain.service.BookService;
import br.com.pedrobelmino.springbootjooq.mapper.BookMapper;
import br.com.pedrobelmino.springbootjooq.presentation.response.BookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper bookMapper;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<BookResponse>> findAll() {
        return ResponseEntity.ok( bookService
                .findAll()
                .stream()
                .map(dto -> bookMapper.bookDTOToResponse(dto))
                .toList()
        );
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<BookResponse> findOne(@PathVariable int id) {
        return bookService
                .findOne(id)
                .map(dto -> bookMapper.bookDTOToResponse(dto))
                .map(ResponseEntity::ofNullable)
                .orElse(ResponseEntity.notFound().build());

    }
}
