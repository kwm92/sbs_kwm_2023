package com.kwm.exam.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kwm.exam.demo.repository.ArticleRepository;
import com.kwm.exam.demo.vo.Article;

@Service
public class ArticleService {
	// 인스턴스 변수 시작
	private int articlesLastId;
	private List<Article> articles;
	// 인스턴스 변수 끝

	public ArticleService() {
		articlesLastId = 0;
		articles = new ArrayList<>();

		makeTestData();
	}
	
	public void makeTestData() {
		for ( int i = 1; i <= 10; i++ ) {
			String title = "제목" + i;
			String body = "내용" + i;
			
			writeArticle(title, body);
		}
	}
	
	public Article getArticle(int id) {
		for ( Article article : articles ) {
			if ( article.getId() == id ) {
				return article;
			}
		}
		
		return null;
	}
	
	public List<Article> getArticles() {
		return articles;
	}
	
	public Article writeArticle(String title, String body) {
		int id = articlesLastId + 1;
		Article article = new Article(id, title, body);
		
		articles.add(article);
		articlesLastId = id;
		
		return article;
	}
	
	public void deleteArticle(int id) {
		Article article = getArticle(id);
		
		articles.remove(article);
	}

	public void modifyArticle(int id, String title, String body) {
		Article article = getArticle(id);
		
		article.setTitle(title);
		article.setBody(body);
	}
}
