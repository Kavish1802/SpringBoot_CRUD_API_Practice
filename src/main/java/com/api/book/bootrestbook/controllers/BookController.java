package com.api.book.bootrestbook.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


//@Controller
@RestController
public class BookController {

    //@RequestMapping(value="/books", method=RequestMethod.GET)
    //here we pass value and method in @REquestMapping
    //@ResponseBody
    // we donot need to write @Responsebody when we are using @RestController 
    //we can use @GetMapping instead of @requestmapping it does not require us to write method 
    @Autowired
    private BookService bookService;
    //The @Autowired annotation in your code is used by Spring to perform dependency injection. 
    //This means that Spring will automatically instantiate an object of BookService and assign it to 
    //the bookService field in your BookController class.
    

    //get all books handler
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks()
    {
        // Book book=new Book();
        // book.setId(1);
        // book.setTitle("The King");
        // book.setAuthor("Kavish");
        // now we we use the service we created 

        // learning to send status codes
        List<Book>list=bookService.getAllBooks();
        if(list.isEmpty())
         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();


        return ResponseEntity.of(Optional.of(list));
    }
    // get a single book by id
    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id) {
        return bookService.getBookById(id);
    }
    
    // adding a book 
    @PostMapping("/books")
    public Book addBook(@RequestBody Book bk){
         this.bookService.addBook(bk);
         return bk;
    }

    //deleting data
    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId){
        bookService.deleteBook(bookId);
    }

    //updating the book
    @PutMapping("/books/{bookId}")
    public void updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId){
        this.bookService.updateBook(book, bookId);
    }
}
 