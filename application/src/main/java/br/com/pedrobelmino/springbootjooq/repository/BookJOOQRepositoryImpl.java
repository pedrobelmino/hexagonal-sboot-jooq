package br.com.pedrobelmino.springbootjooq.repository;

import br.com.pedrobelmino.springbootjooq.database.public_.tables.Book;
import br.com.pedrobelmino.springbootjooq.database.public_.tables.records.BookRecord;
import br.com.pedrobelmino.springbootjooq.domain.BookDomain;
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
    public Optional<BookDomain> findOne(int id){

        BookRecord bookRecord = new BookRecord();
        bookRecord.setId(id);
        return dsl
                .selectFrom(Book.BOOK)
                .where(
                        condition(bookRecord)
                ).fetchOptionalInto(BookDomain.class);
    }

    @Override
    public List<BookDomain> findAll(){
        return dsl
                .selectFrom(Book.BOOK)
                .fetchInto(BookDomain.class);
    }

    @Override
    public void update(BookDomain bookDomain){
        dsl.update(Book.BOOK)
                .set(Book.BOOK.TITLE, bookDomain.title())
                .where(Book.BOOK.ID.eq(bookDomain.id()))
                .execute();
    }

}
