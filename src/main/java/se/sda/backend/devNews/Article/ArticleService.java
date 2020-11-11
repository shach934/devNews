package se.sda.backend.devNews.Article;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    static private List<Article> articles;

    public List<Article> getAll() {
        return articles;
    }

    public Optional<Article> getById(Long Id){
        return null;
    }

    public void create(Article article) {
        articles.add(article);
    }
}
