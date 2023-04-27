package org.example;

public class Book {

    protected String title;
    protected int year;
    protected String author;
    protected int pages;
    protected String review;
    protected Author authorClass;

    public Book(String title, int year, String author, int pages, String review) {
        this.title = title;
        this.year = year;
        this.author = author;
        this.pages = pages;
        this.review = review;
    }

    public Book(String title, int year, Author author, int pages, String review) {
        this.title = title;
        this.year = year;
        this.authorClass = author;
        this.pages = pages;
        this.review = review;
    }

    protected boolean isBig() {
        if (pages > 500) {
            return true;
        }
        return false;
    }

    protected boolean matches(String word) {
        if (author != null) {
            if (title.toLowerCase().contains(word.toLowerCase()) ||
                    review.toLowerCase().contains(word.toLowerCase()) ||
                    author.toLowerCase().contains(word.toLowerCase())) {
                return true;
            }
        } else if (authorClass.name != null && authorClass.surname != null) {
            if (title.toLowerCase().contains(word.toLowerCase()) ||
                    review.toLowerCase().contains(word.toLowerCase()) ||
                    authorClass.name.toLowerCase().contains(word.toLowerCase()) ||
                    authorClass.surname.toLowerCase().contains(word.toLowerCase()))
                return true;
        }
        return false;
    }

    protected int estimatePrice() {
        int price = pages * 3;
        if (price < 250) {
            return 250;
        }
        return price;
    }

    protected int estimatePriceSqrt() {
        int price = (int) Math.floor(pages * 3 * Math.sqrt(authorClass.rating));
        if (price < 250) {
            return 250;
        }
        return price;
    }
}
