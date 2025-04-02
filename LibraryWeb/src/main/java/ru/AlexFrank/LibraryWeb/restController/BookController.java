package ru.AlexFrank.LibraryWeb.restController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.AlexFrank.LibraryWeb.entity.Book;
import ru.AlexFrank.LibraryWeb.service.LibraryService;

@Controller
public class BookController {

    private final LibraryService libraryService;

    public BookController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/")
    public String showLibraryList(Model model){
        model.addAttribute("listBooks", libraryService.showAll());
        return "library";
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

}
