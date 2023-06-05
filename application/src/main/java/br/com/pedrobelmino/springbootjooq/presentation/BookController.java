package br.com.pedrobelmino.springbootjooq.presentation;

import br.com.pedrobelmino.springbootjooq.exception.BookNotFoundException;
import br.com.pedrobelmino.springbootjooq.presentation.request.BookUpdateRequest;
import br.com.pedrobelmino.springbootjooq.service.BookService;
import br.com.pedrobelmino.springbootjooq.mapper.BookMapper;
import br.com.pedrobelmino.springbootjooq.presentation.response.BookResponse;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
                .collect(Collectors.toList())
        );
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<BookResponse> findOne(@PathVariable int id) {
        return bookService
                .findOne(id)
                .map(dto -> bookMapper.bookDTOToResponse(dto))
                .map(ResponseEntity::ofNullable)
                .orElse(
                        ResponseEntity
                                .notFound()
                                .build()
                );

    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<BookResponse> findOne(@PathVariable int id, @RequestBody BookUpdateRequest bookUpdateRequest) {
        try{
            bookService.update(
                    bookMapper.bookUpdateRequestTODomain(id, bookUpdateRequest));
            return ResponseEntity.ok().build();
        }catch(BookNotFoundException bookNotFoundException){
            return ResponseEntity.notFound().build();
        }

    }

}
