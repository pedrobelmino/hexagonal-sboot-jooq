package br.com.pedrobelmino.springbootjooq.mapper;

import br.com.pedrobelmino.springbootjooq.domain.BookDomain;
import br.com.pedrobelmino.springbootjooq.presentation.BookUpdateRequest;
import br.com.pedrobelmino.springbootjooq.presentation.response.BookResponse;

public class BookMapper {

    public BookResponse bookDTOToResponse(BookDomain bookDomain) {

        if (bookDomain == null) {
            return null;
        }

        return new BookResponse(bookDomain.id(), bookDomain.title());
    }

    public BookDomain bookUpdateRequestTODomain(int id, BookUpdateRequest bookUpdateRequest){
        if(bookUpdateRequest ==null ){
            return null;
        }

        return new BookDomain(id, bookUpdateRequest.title());
    }

}