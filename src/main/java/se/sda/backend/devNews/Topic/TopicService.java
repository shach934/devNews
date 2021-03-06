package se.sda.backend.devNews.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    @Autowired
    private TopicRepo repo;

    public List<Topic> getAll() {  return repo.findAll(); }

    public List<Topic> getByArticleId(Long articleId){return repo.findAllByArticles_id(articleId);}

    public Topic create(Topic topic) {
        return repo.save(topic);
    }

    public Topic update(Topic revisedTopic){
        return repo.save(revisedTopic);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}
