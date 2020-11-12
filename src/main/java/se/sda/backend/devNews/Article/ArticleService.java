package se.sda.backend.devNews.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepo repo;

    public List<Article> getAll() {  return repo.findAll(); }

    public Optional<Article> getById(Long Id){
        return repo.findById(Id);
    }

    public Article create(Article article) {
        return repo.save(article);
    }

    public Article update(Article revicedArticle){
        return repo.save(revicedArticle);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}
