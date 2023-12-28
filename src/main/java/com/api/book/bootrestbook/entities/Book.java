package com.api.book.bootrestbook.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "Books")
public class Book {
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    private int id;
    private String title;
    private String author;

    public Book() {
    }

    public Book(int id, String title, String author)
    {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    // Getters and Setters
    public int getId()
    {
        return this.id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    
    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public String getAuthor()
    {
        return this.author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    // toString
    @Override
    public String toString()
    {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", author='" + getAuthor() + "'" +
            "}";
    }
}
