package br.com.pedrobelmino.springbootjooq.mapper;

import br.com.pedrobelmino.springbootjooq.domain.BookDTO;
import br.com.pedrobelmino.springbootjooq.presentation.response.BookResponse;

public class BookMapper {

    public BookResponse bookDTOToResponse(BookDTO bookDTO) {

        if (bookDTO == null) {
            return null;
        }

        return BookResponse.builder()
                .id(bookDTO.getId())
                .title(bookDTO.getTitle())
                .build();
    }

}