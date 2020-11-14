package se.sda.backend.devNews.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.sda.backend.devNews.articles.Article;

import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getAll(){  return topicService.getAll(); }

    /*
    //why throw the not found here, but not the service? what will the service return if the object is not found?
    // how the controller identify that message from service?
    @GetMapping("/topics/{id}")
    public Topic getById(Long id){
        return service.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    */

    @GetMapping("/topics")
    public List<Topic> getAll(@RequestParam(required = false) Long articleId){
        if(articleId != null){
            return topicService.getByArticleId(articleId);
        }else{
            return topicService.getAll();
        }
    }

    @PutMapping("/topics")
    public Topic create(@RequestBody Topic topic){  return topicService.create(topic);}

    @PostMapping("/topics")
    public Topic update(@RequestBody Topic revisedTopic){  return topicService.update(revisedTopic);}

    @DeleteMapping("/topics/{id}")
    public void delete(@PathVariable Long id){  topicService.delete(id);}

}
