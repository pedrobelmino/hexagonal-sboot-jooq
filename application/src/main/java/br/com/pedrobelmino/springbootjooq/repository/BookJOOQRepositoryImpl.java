package br.com.pedrobelmino.springbootjooq.repository;

import br.com.pedrobelmino.springbootjooq.database.public_.tables.Book;
import br.com.pedrobelmino.springbootjooq.database.public_.tables.records.BookRecord;
import br.com.pedrobelmino.springbootjooq.domain.pojo.BookDTO;
import br.com.pedrobelmino.springbootjooq.domain.repository.BookRepository;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.jooq.impl.DSL.condition;

@Repository
public class BookJOOQRepositoryImpl implements BookRepository {

    @Autowired
    private DSLContext dsl;

    @Override
    public Optional<BookDTO> findOne(int id){
        BookRecord bookRecord = new BookRecord();
        bookRecord.setId(id);
        return dsl
                .selectFrom(Book.BOOK)
                .where(
                        condition(bookRecord)
                ).fetchOptionalInto(BookDTO.class);
    }

    @Override
    public List<BookDTO> findAll(){
        return dsl
                .selectFrom(Book.BOOK)
                .fetchInto(BookDTO.class);
    }

}
