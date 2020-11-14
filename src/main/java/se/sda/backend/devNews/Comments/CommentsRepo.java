package se.sda.backend.devNews.Comments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepo extends JpaRepository<Comments, Long> {
    List<Comments> findAllByArticleId(Long articleId);
}
