package se.sda.backend.devNews.Article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// add the repository annotation to let Spring know and enable injection.
@Repository
public interface ArticleRepo extends JpaRepository<Article, Long> {
}
