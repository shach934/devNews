package se.sda.backend.devNews.articles;

import se.sda.backend.devNews.Comments.Comments;
import se.sda.backend.devNews.Topic.Topic;

import javax.persistence.*;
import java.util.List;

// to make a class into database, using Entity and assign Id annotation will do.
@Entity
// @Table(name = "Posts") // explicitly define the database name, otherwise same as the class name.
// By explicitly give the table/column names, the database is independent of the code, though may cause confusion.

public class Article {
    @Id
    // the id will be automatically generated by database.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    // by columnDefinition to TEXT, not limit to char 255 as in Java,
    // by default the name column name is variable name, can explicitly assign by: name = "Post".
    @Column(columnDefinition = "TEXT")
    private String body;
    private String author;

    @ManyToMany
    private List<Topic> topics;

    @OneToMany
    private List<Comments> commentsList;

    public Article() { }

    public Article(Long id, String title, String body, String author) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.author = author;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public List<Comments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
