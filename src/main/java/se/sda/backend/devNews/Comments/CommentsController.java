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
    private CommentsService service;

    @GetMapping("/comments")
    public List<Comments> getAll(){
        return service.getAll();
    }

    @GetMapping("/comments/{id}")
    public Comments getById(Long id){
        return service.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/comments")
    public Comments put(@RequestBody Comments comments){
        return service.put(comments);
    }

    @PostMapping("/comments")
    public Comments update(@RequestBody Comments revisedComments){
        return service.update(revisedComments);
    }

    @DeleteMapping("/comments")
    public void delete(Long id){
        service.delete(id);
    }
}
