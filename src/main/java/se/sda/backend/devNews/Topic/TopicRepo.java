package se.sda.backend.devNews.Topic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.sda.backend.devNews.articles.Article;

import java.util.List;

@Repository
public interface TopicRepo extends JpaRepository<Topic, Long> {
    List<Topic> findAllByArticles_id(Long articleId);
}
