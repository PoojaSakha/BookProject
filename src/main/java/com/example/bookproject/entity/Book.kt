package com.example.bookproject.entity

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private var id: Long = 0

    private var title: String? = null
    private var author: String? = null
    private var price: Double = 0.0

    constructor() {}
    constructor(title: String?, author: String?, price: Double) {
        this.title = title
        this.author = author
        this.price = price
    }

    fun getId(): Long {
        return id
    }

    fun setId(id: Long) {
        this.id = id
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String?) {
        this.title = title
    }

    fun getAuthor(): String? {
        return author
    }

    fun setAuthor(author: String?) {
        this.author = author
    }

    fun getPrice(): Double {
        return price
    }

    fun setPrice(price: Double) {
        this.price = price
    }
}