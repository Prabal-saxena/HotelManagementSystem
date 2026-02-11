package org.hotelmanagement.services;

import jakarta.annotation.PostConstruct;
import lombok.Setter;
import org.hotelmanagement.model.Book;
import org.hotelmanagement.model.SearchType;
import org.hotelmanagement.repository.SearchRepository;
import org.hotelmanagement.strategy.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SearchCatalogService {
    private final Map<SearchType, SearchCatalogStrategy> strategy;

    @Autowired
    private SearchRepository searchRepository;

    public SearchCatalogService(){
        strategy = Map.of(
                SearchType.TITLE, new SearchByBookName(),
                SearchType.AUTHOR, new SearchByBookAuthor(),
                SearchType.PUBLICATION, new SearchByBookPublication()
        );
    }

    public List<Book> searchBook(SearchType type, SearchCriteria criteria){

        List<Book> bookList = searchRepository.findAll();
        return strategy.get(type).searchBook(bookList, criteria);
    }
}
