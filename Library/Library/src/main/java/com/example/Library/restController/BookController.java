package com.example.Library.restController;

import com.example.Library.entity.Book;
import com.example.Library.entity.UserEntity;
import com.example.Library.service.LibraryService;
import com.example.Library.service.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class BookController {

    private final LibraryService libraryService;

    private final UserService userService;

    public BookController(LibraryService libraryService, UserService userService) {
        this.libraryService = libraryService;
        this.userService = userService;
    }

    @GetMapping("/book")
    public String showLibraryList(Model model){
        model.addAttribute("listBooks", libraryService.showAll());
        return "library";
    }

    @GetMapping("/")
    public String showLibraryListUser(Model model){
        model.addAttribute("listBooks", libraryService.showAll());
        return "libraryUser";
    }

    @GetMapping("/book/create")
    public String showCreateForm(Model model){
        model.addAttribute("book", new Book());
        return "create";
    }

    @PostMapping("/book/create")
    public String createBook(@ModelAttribute Book book){
        libraryService.createNewBook(book);
        return "redirect:/";
    }

    @GetMapping("/book/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model){
        Optional<Book> book = libraryService.findBookById(id);
        if(book.isPresent()){
            model.addAttribute("book", book.get());
            return "edit";
        }
        return "redirect:/";
    }

    @PostMapping("/book/edit")
    public String editBook(@ModelAttribute Book book){
        libraryService.updateBook(book);
        return "redirect:/";
    }

    @GetMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        libraryService.deleteBook(id);
        return "redirect:/";
    }

    @GetMapping("/register")
    public String showRegistrationFrom(Model model){
        model.addAttribute("userEntity", new UserEntity());
        return "registration";
    }

    @PostMapping("/register")
    public String adduser(UserEntity user, Model model)
    {
        try
        {
            userService.addUser(user.getUsername(), user.getPassword());
            return "redirect:/login";
        }
        catch (Exception ex)
        {
            model.addAttribute("message", "User exists");
            return "registration";
        }
    }
}
