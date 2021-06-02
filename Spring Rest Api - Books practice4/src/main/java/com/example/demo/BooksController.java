package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
public class BooksController {
    List<Book> list = new ArrayList<Book>();

    BooksController(){
        list.add(new Book(7,"Master Spring","Mix"));
        list.add(new Book(2,"videoGames","ps4"));
        list.add(new Book(8,"Cactuses","macete"));
        list.add(new Book(4,"Java","oracle"));

    }

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        list.sort(Comparator.comparing(Book::getId));
        return list;


    }

    @GetMapping("/books/add")
    @ResponseBody
    public String AddBook(@RequestParam Long id, @RequestParam String name, @RequestParam String author){
        this.list.add(new Book(id,name,author));
        return "added id:" + id+" name:"+name+" aut:"+author;
    }

    @GetMapping("/books/delete")
    @ResponseBody
    public String DeleteBook(@RequestParam Long id){

        Iterator<Book> i = list.iterator();
        while (i.hasNext()) {
            Book o = i.next();
            if(o.id==id) {
                i.remove();
                return "removed id:" + o.id+" name:"+o.name+" aut:"+o.author;
            }
        }
        return "id:" + id + " not found";
    }

    @GetMapping("/books/update")
    @ResponseBody
    public String UpdateBook(@RequestParam Long id, @RequestParam String name, @RequestParam String author){
        int removed=0;
        Iterator<Book> i = list.iterator();
        while (i.hasNext()) {
            Book o = i.next();
            if(o.id==id) {
                i.remove();
                removed=1;
            }
        }

        this.list.add(new Book(id,name,author));
        if(id==0){
            return "id didn't exist - added new id:" + id + " name:" + name + " aut:" + author;
        }
        else {
            return "modified id:" + id + " name:" + name + " aut:" + author;
        }

       //return "id:" + id + " not found";

    }
}
