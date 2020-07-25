package com.zimug.boot.launch;

import com.zimug.boot.launch.dao.testdb.ArticleRepository;
import com.zimug.boot.launch.dao.testdb.Article;
import com.zimug.boot.launch.dao.testdb2.Message;
import com.zimug.boot.launch.dao.testdb2.MessageRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.Date;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class JPAKeyWordTest {

    @Resource
    private ArticleRepository articleRepository;

    @Resource
    private MessageRepository messageRepository;


    @Test
    public void userTest() {
        Article article = articleRepository.findByAuthor("zimug");
        System.out.println(article);
    }
    @Test
    public void jpaTest(){
        Article article = Article.builder()
                .id(2L)
                .author("zimug")
                .content("spring boot 从青铜到王者")
                .createTime(new Date())
                //.reader(readers)
                .title("t1").build();

        Message message = Message.builder()
                .name("zimug").content("ok").build();

        //先构造一个Article对象article，这个操作针对testdb
        articleRepository.save(article);
        //在构造一个Message对象message，这个操作针对testdb2
        messageRepository.save(message);
    }
}
