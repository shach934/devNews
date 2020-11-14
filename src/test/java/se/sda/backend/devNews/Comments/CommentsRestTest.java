package se.sda.backend.devNews.Comments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import se.sda.backend.devNews.articles.Article;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CommentsRestTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void testGetAllReturnEmptyArray() {
        //Act
        // the return type is defined the last parameter.
        String responseComments = testRestTemplate.getForObject("/comments", String.class);

        //assert
        Assertions.assertEquals("[]", responseComments);
    }

    @Test
    public void testCreateComments() {
        //arrange
        Comments commentsSample = new Comments(null, "Thanks", null);
        //Act
        // the return type is defined the last parameter.
        Article responseArticles = testRestTemplate.postForObject("/comments", commentsSample, Article.class);

        //assert
        Assertions.assertEquals(commentsSample.getAuthor(), responseArticles.getAuthor());
        // clean up
        testRestTemplate.delete("/comments/" + responseArticles.getId().toString());
    }
}
