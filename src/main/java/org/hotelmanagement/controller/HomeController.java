package org.hotelmanagement.controller;

import org.hotelmanagement.model.Book;
import org.hotelmanagement.model.SearchType;
import org.hotelmanagement.services.SearchCatalogService;
import org.hotelmanagement.strategy.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController("/search")
public class HomeController {

    @Autowired
    private SearchCatalogService searchCatalogService;


    @GetMapping
    public ResponseEntity<List<Book>> search(@RequestBody SearchCriteria criteria, @RequestParam String searchType){

        List<Book> result = searchCatalogService.searchBook(SearchType.valueOf(searchType.toUpperCase()), criteria);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
