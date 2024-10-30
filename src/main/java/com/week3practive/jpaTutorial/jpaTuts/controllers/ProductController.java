package com.week3practive.jpaTutorial.jpaTuts.controllers;

import com.week3practive.jpaTutorial.jpaTuts.entities.ProductEntity;
import com.week3practive.jpaTutorial.jpaTuts.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.title;

@RestController
@RequestMapping(path="/Products")
public class ProductController {

    private final int PAGE_SIZE = 5;

    @Autowired
    private final ProductRepository productRepository;


    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductEntity> getAllProducts(@RequestParam(defaultValue="") String title,
                                              @RequestParam(defaultValue="id") String sortBy,
                                              @RequestParam(defaultValue="0") Integer pageNumber)
    {

        return productRepository.findByTitleContainingIgnoreCase(
                title,
                PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(sortBy))
        );
//        return productRepository.findBy(
//                Sort.by(Sort.Order.desc(sortBy)));
//        Sort sortByPrice = Sort.by(Sort.Direction.ASC, "id");
//        return productRepository.findAll(sortByPrice);

//        Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(sortBy));
//        return productRepository.findAll(pageable).getContent();


    }
}
