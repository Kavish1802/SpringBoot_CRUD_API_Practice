package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.entities.Book;

@Component 
//this will make autowired function
public class BookService {
    private static List<Book> list =new ArrayList<>();
    static{
        list.add(new Book(1,"The king","kavish"));
        list.add(new Book(2,"The queen","kavish"));
        list.add(new Book(3,"The prince","kavish"));
    }

    // get all books
    public List<Book> getAllBooks(){
        return list;
    }
    
    // get books by id
    public Book getBookById(int id) {
        Book book = null;
        book = list.stream().filter(e -> e.getId() == id).findFirst().get();
        return book;
    }

    //adding the book - put operation
    public void addBook(Book b){
        list.add(b);
    }


    // delete method
    public void deleteBook(int bId){
        list=list.stream().filter(book->{
            if(book.getId()!=bId){
                return true;
            }
            else{
                return false;
            }
        }).collect(Collectors.toList());
    }

    //update method
    public void updateBook(Book book,int bookId){
        list=list.stream().map(b->{
            if(b.getId()==bookId){
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
    }

}
