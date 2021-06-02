package com.example.demo;

public class Book implements Comparable<Book>{
        long id;

        String name;
        String author;
        
        public Book(long id, String name, String author){
            super();
            this.id=id;
            this.name=name;
            this.author=author;

        }
    public Long getId() {
        return id;
    }

    @Override
    public int compareTo(Book u) {
        if (getId() == null || u.getId() == null) {
            return 0;
        }
        return getId().compareTo(u.getId());
    }



    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }
}
