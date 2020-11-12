package se.sda.backend.devNews.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class ArticleController {
    //Autowired will automatically create a service class that is annotated as service.
    // this is called dependency injection. all the dependency is connected by annotations.
    // here is field injection, also others like parameter injection is possible.
    @Autowired
    private ArticleService articleService;

    @GetMapping("/")
    public String WelcomPage(){
        return "Welcome!";
    }

    @GetMapping("/articles")
    public List<Article> getAll(){
        return articleService.getAll();
    }

    @GetMapping("/articles/{id}")
    public Article getById(Long id){
        return articleService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/articles")
    public Article create(@RequestBody Article article){
        return articleService.create(article);
    }

    @PutMapping("/articles")
    public Article update(@RequestBody Article article){
        return articleService.update(article);
    }

    @DeleteMapping("/articles")
    public void delete(Long id){
        articleService.delete(id);
    }
}
