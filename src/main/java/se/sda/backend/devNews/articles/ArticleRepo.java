package se.sda.backend.devNews.articles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// add the repository annotation to let Spring know and enable injection.
@Repository
public interface ArticleRepo extends JpaRepository<Article, Long> {
    List<Article> findAllByTopicId(Long TopicId);

    // here the logic of database can be used, as long as the name fits the field.
    // if a field is a object, just use And, .etc, if it is a list, use _ then the logic 
}
