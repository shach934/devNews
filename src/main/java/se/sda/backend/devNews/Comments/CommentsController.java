package se.sda.backend.devNews.Comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.concurrent.CompletionException;

@RestController
public class CommentsController {
    @Autowired
    private CommentsService commentsService;

    @GetMapping("/comments")
    public List<Comments> getById(@RequestParam(required = false) Long articleId){
        if(articleId != null){
            return commentsService.findAllByArticleId(articleId);
        }else{
            return commentsService.getAll();
        }
    }

    @PostMapping("/comments")
    public Comments create(@RequestBody Comments comments){
        return commentsService.create(comments);
    }

    @PutMapping("/comments")
    public Comments update(@RequestBody Comments revisedComments){
        return commentsService.update(revisedComments);
    }

    @DeleteMapping("/comments/{id}")
    public void delete(@PathVariable Long id){
        commentsService.delete(id);
    }
}
