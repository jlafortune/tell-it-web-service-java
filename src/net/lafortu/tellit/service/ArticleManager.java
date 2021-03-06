package net.lafortu.tellit.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@LocalBean
public class ArticleManager {
	@PersistenceContext(name="article-unit")
    private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Article> findAll() {
		Query query = em.createNamedQuery("Article.findAll");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Article> findByCategory(String category) {
		Query query = em.createNamedQuery("Article.findByCategory");
		query.setParameter("categoryName", category);
		return query.getResultList();
	}
	
	public void saveArticle(Article article) {
		em.persist(article);
	}	
}
