package com.example.litepaltext;

import org.litepal.crud.LitePalSupport;

public class Book extends LitePalSupport {

    private String author;//作者
    private int price;//价格
    private int pages;//页码
    private String name;//书名



    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
