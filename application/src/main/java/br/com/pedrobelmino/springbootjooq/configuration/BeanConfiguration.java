package br.com.pedrobelmino.springbootjooq.configuration;

import br.com.pedrobelmino.springbootjooq.repository.BookRepository;
import br.com.pedrobelmino.springbootjooq.service.BookService;
import br.com.pedrobelmino.springbootjooq.mapper.BookMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public BookService bookService( BookRepository bookRepository){
        return new BookService(bookRepository);
    }

    @Bean
    public BookMapper bookMapper(){
        return new BookMapper();
    }

}
