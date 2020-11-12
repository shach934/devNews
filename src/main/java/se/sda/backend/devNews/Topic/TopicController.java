package se.sda.backend.devNews.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {
    @Autowired
    private TopicService service;

    @RequestMapping("/topics")
    public List<Topic> getAll(){
        return service.getAll();
    }

    // why throw the not found here, but not the service? what will the service return if the object is not found?
    // how the controller identify that message from service?
    @GetMapping("/topics/{id}")
    public Topic getById(Long id){
        return service.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/topics")
    public Topic add(@RequestBody Topic topic){
        return service.create(topic);
    }

    @PostMapping("/topics")
    public Topic update(@RequestBody Topic revicedTopic){
        return service.update(revicedTopic);
    }

    @DeleteMapping("/topics")
    public void delete(Long id){
        service.delete(id);
    }

}
