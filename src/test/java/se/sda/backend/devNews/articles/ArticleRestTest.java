package se.sda.backend.devNews.articles;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import se.sda.backend.devNews.Topic.Topic;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ArticleRestTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void testGetAllReturnEmptyArray() {
        //TODO: this only runs at first time a database created, after the following test run, it will not return empty anymore.
        // So remember to clean the databse after each test.
        //Act
        // the return type is defined the last parameter.
        String responseArticles = testRestTemplate.getForObject("/articles", String.class);

        //assert
        Assertions.assertEquals("[]", responseArticles);
    }

    @Test
    public void testCreateArticle() {
        //arrange
        Article articleSample = new Article(null, "Hello", "This is my first Post", "SDA");
        //Act
        // the return type is defined the last parameter.
        Article responseArticles = testRestTemplate.postForObject("/articles", articleSample, Article.class);

        //assert
        Assertions.assertEquals(articleSample.getAuthor(), responseArticles.getAuthor());
        // clean up
        testRestTemplate.delete("/articles/" + responseArticles.getId().toString());
    }


    @Test
    public void testDelete(){
        Article articleSample1 = testRestTemplate.postForObject("/articles", new Article(null, "1st", "This is my first Post", "SDA"), Article.class);
        Article articleSample2 = testRestTemplate.postForObject("/articles", new Article(null, "2nd", "This is my second Post", "SDA"), Article.class);

        Article[] ArticleList1 = testRestTemplate.getForObject("/articles", Article[].class);
        Assertions.assertEquals(2, ArticleList1.length);

        testRestTemplate.delete("/articles/" + articleSample1.getId().toString()) ;

        Article[] ArticleList2 = testRestTemplate.getForObject("/articles", Article[].class);
        Assertions.assertEquals(1, ArticleList2.length);
    }

    @Test
    public void testGetById() {
        //TODO: is there a way to check the database manually? The localhost:8080 in postman seems not working,
        // Seems this test is working on a different database??
        //arrange
        new Article(null, "first", "Hello everyone! ", "SDA");
        Article articleSample = new Article(null, "need help to setup the environment", "How to setup Spring?? ", "SDA");
        //Act
        // the return type is defined the last parameter.
        Article responseArticles = testRestTemplate.postForObject("/articles", articleSample, Article.class);
        System.out.println("the article added to the database is: " + responseArticles.getTitle());

        Assertions.assertEquals(articleSample.getAuthor(), responseArticles.getAuthor());

        Article getByIdArticle = testRestTemplate.getForObject("/articles/" + responseArticles.getId().toString(), Article.class);

        System.out.println("The title is: " + getByIdArticle.getTitle());

        //assert
        Assertions.assertEquals(responseArticles.getAuthor(), getByIdArticle.getAuthor());

        // clean
        testRestTemplate.delete("/articles/" + responseArticles.getId().toString());
    }

    @Test
    public void testUpdate(){
        // arrange
        Article articleSample = testRestTemplate.postForObject("/articles", new Article(null, "Hello", "This is my first Post", "SDA"), Article.class);
        Article updateArticle = new Article(articleSample.getId(), "update title", "updated body", "SHCH");

        HttpEntity<Article> articleHttpEntity = new HttpEntity<>(updateArticle);
        HttpEntity<Article> updateResponse =  testRestTemplate.exchange("/articles", HttpMethod.PUT, articleHttpEntity, Article.class);
        Article updatedArticle = updateResponse.getBody();

        Assertions.assertEquals(updateArticle.getAuthor(), updatedArticle.getAuthor());

        //clean
        testRestTemplate.delete("/articles/" + articleSample.getId().toString());

    }
}