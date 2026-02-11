package org.hotelmanagement.strategy;

import org.hotelmanagement.model.Book;

import java.util.List;

public class SearchByBookName implements SearchCatalogStrategy{

    @Override
    public List<Book> searchBook(List<Book> books, SearchCriteria criteria) {

        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(criteria.getTitle()))
                .toList();
    }
}
