package com.bookstore.BookStore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.BookStore.Entities.Book;
import com.bookstore.BookStore.Entities.MyBooksList;
import com.bookstore.BookStore.Services.BookServices;
import com.bookstore.BookStore.Services.MyBookService;


@Controller
public class BookController {

    @Autowired
    private BookServices bookServices;
    @Autowired 
    private MyBookService myBookService;

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister(){
        return "bookRegister";
    }

    @GetMapping("/available_book")
    public ModelAndView getAllBooks(){
        List<Book> list = bookServices.getAllBooks();
        // ModelAndView model = new ModelAndView();
        // model.setViewName("availableBook");
        // model.addObject("book", list);
        return new ModelAndView("availableBook", "book", list);
    }

    // save all book data action
    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book){

        bookServices.save(book);
        return "redirect:/available_book";
    }

    // My Books action

    @GetMapping("/my_books")
    public String myBooks(Model model){
        List<MyBooksList> list = myBookService.getAllMyBooks();
        model.addAttribute("book", list);
        return "myBooks";
    }

    // MyBooks action

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id){
        Book book = bookServices.getBookById(id);
        MyBooksList mb = new MyBooksList(book.getId(), book.getName(), book.getAuthor(), book.getPrice());
        myBookService.saveMyBooksList(mb);

        return "redirect:/my_books";
    }

    // Delete Book from List

    @RequestMapping("/deleteBook/{id}")
    public String deleteMyBook(@PathVariable("id") int id){
        bookServices.deleteById(id);
        return "redirect:/available_book";
    }

    // Edit Book 
    @RequestMapping("/editBook/{id}")
    public String editBookById(@PathVariable("id") int id, Model model){
        Book book = bookServices.getBookById(id);
        model.addAttribute("book", book);
        return "redirect:/bookEdit";
    }
    
    
    
    
}
