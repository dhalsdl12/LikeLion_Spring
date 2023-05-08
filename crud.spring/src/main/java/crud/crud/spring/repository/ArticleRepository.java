package crud.crud.spring.repository;

import crud.crud.spring.domain.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository {
    Article save(Article article);
    Optional<Article> findById(Long id);
    Optional<Article> findByTitle(String title);
    Optional<Article> findByWriter(String writer);
    List<Article> findAll();

    // delete
    void delete(Long id);
}
