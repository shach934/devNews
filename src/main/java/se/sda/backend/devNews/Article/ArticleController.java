package se.sda.backend.devNews.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ArticleController {
    //Autowired will automatically create a service class that is annotated as service.
    // this is called dependency injection. all the dependency is connected by annotations.
    // here is field injection, also others like parameter injection is possible. 
    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles")
    public List<Article> getAll(){
        return articleService.getAll();
    }

    @GetMapping("/articles/{id}")
    public Optional<Article> getById(Long id){
        return articleService.getById(id);
    }

    @PostMapping("/Articles")
    public void create(@RequestBody Article article){
        articleService.create(article);
    }
}
