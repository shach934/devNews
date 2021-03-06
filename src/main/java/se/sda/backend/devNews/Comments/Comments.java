package se.sda.backend.devNews.Comments;

import se.sda.backend.devNews.articles.Article;

import javax.persistence.*;

@Entity
public class Comments {

    // comments for the post, it has a field of article

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    private Article article;

    private String author;

    public Comments(Long id, String content, String name) {
        this.id = id;
        this.content = content;
        this.author = name;
    }

    public Comments() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
