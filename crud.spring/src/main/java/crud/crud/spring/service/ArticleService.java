package crud.crud.spring.service;

import crud.crud.spring.domain.Article;
import crud.crud.spring.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Transactional
public class ArticleService {
    private final ArticleRepository articleRepository;


    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }
    // 글 생성 (create)
    public Long create(Article article){
        articleRepository.save(article);
        return article.getId();
    }

    // 조회 (전체 글)
    public List<Article> findArticles(){
        return articleRepository.findAll();
    }

    // 조회 (하나의 글 - 아이디로)
    public Optional<Article> findOne(Long articleId){
        return articleRepository.findById(articleId);
    }
}
