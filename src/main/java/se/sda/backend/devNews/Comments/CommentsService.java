package se.sda.backend.devNews.Comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletionException;

@Service
public class CommentsService {
    @Autowired
    private CommentsRepo repo;

    public List<Comments> getAll(){
        return repo.findAll();
    }

    public Optional<Comments> getById(Long id){  return repo.findById(id); }

    public Comments create(Comments comments){  return repo.save(comments); }

    public Comments update(Comments revisedComments){  return repo.save(revisedComments); }

    public void delete(Long id){ repo.deleteById(id); }

    public List<Comments> findAllByArticleId(Long articleId) { return repo.findAllByArticleId(articleId);}
}
