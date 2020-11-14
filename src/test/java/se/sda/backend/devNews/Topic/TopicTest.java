package se.sda.backend.devNews.Topic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TopicTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void testGetAllReturnEmptyArray() {
        //Act
        // the return type is defined the last parameter.
        String responseTopics = testRestTemplate.getForObject("/topics", String.class);

        //assert
        Assertions.assertEquals("[]", responseTopics);
    }

}
