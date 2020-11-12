package se.sda.backend.devNews.articles;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
public class ArticleControllerTest {
    @Autowired
    ArticleController articleController;

    @MockBean
    ArticleService articleService;

    @Test
    public void getAllTest(){
        // AAA: arrange -> act -> assert

        //TODO: What will happen if add two articles and give the same Id? It will update?

        // arrange
        Article a1 = new Article(1L, "Newbee here", "Hello everyone, this is shaohui, I am new here to learn the Java development", "Shaohui");
        Article a2 = new Article(2L, "Help!", "Hello, how can I print out hello world with Java", "Shaohui");
        Article a3 = new Article(3L, "First project", "My PC is under my command finally!", "Shaohui");

        //TODO:  why here the controller cannot initiate its service??

        // mockito replaced the real service with the following behavior. the method will not call the real service anymore.
        // by this this test will focus on the ArticleController function, not depend on the articleService anymore, even ArticleService is wrong,
        // this test still pass.
        Mockito.when(articleService.getById(1L))
                .thenReturn(Optional.of(a1));
        Mockito.when(articleService.getById(2L))
                    .thenReturn(Optional.of(a2));
        Mockito.when(articleService.getById(3L))
                    .thenReturn(Optional.of(a3));

        // act

        Article articleByController1 = articleController.getById(1L);
        Article articleByController2 = articleController.getById(2L);
        Article articleByController3 = articleController.getById(3L);

        // assert
        Assertions.assertEquals(articleByController1.getTitle(), a1.getTitle());
        Assertions.assertEquals(articleByController2.getBody(), a2.getBody());
        Assertions.assertEquals(articleByController3.getAuthor(), a2.getAuthor());
    }
}
