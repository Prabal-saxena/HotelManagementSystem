package org.hotelmanagement.strategy;

import org.hotelmanagement.model.Book;

import java.util.ArrayList;
import java.util.List;

public class SearchByBookPublication implements SearchCatalogStrategy{
    @Override
    public List<Book> searchBook(List<Book> books, SearchCriteria criteria) {
        return books.stream().filter(book -> book.getPublisher().equalsIgnoreCase(criteria.getPublication())).toList();
    }
}
