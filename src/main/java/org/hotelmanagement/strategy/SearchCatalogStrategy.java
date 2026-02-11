package org.hotelmanagement.strategy;

import org.hotelmanagement.model.Book;

import java.util.List;

public interface SearchCatalogStrategy {

    List<Book> searchBook(List<Book> books, SearchCriteria criteria);
}
