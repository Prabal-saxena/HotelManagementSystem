package org.hotelmanagement.strategy;

import org.hotelmanagement.model.Book;

import java.util.List;

public class SearchByBookAuthor implements SearchCatalogStrategy{

    @Override
    public List<Book> searchBook(List<Book> books, SearchCriteria criteria) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(criteria.getAuthor()))
                .toList();
    }
}
