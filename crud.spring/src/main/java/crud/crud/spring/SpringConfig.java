package crud.crud.spring;

import crud.crud.spring.repository.ArticleRepository;
import crud.crud.spring.repository.JpaArticleRepository;
import crud.crud.spring.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public ArticleService articleService(){
        return new ArticleService(articleRepository());
    }

    @Bean
    public ArticleRepository articleRepository(){
        return new JpaArticleRepository(em);
    }
}
