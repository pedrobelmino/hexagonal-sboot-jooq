package br.com.pedrobelmino.springbootjooq.presentation.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookResponse {
    private int id;
    private String title;
}
