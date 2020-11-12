package se.sda.backend.devNews.articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    // return all the articles with certain topic id
    public List<Article> getAllArticleByTopic(Long topicId) {
        return repo.findAllByTopicId(topicId);
    }
}