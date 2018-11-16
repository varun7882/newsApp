package com.varun.newsapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Article {
	@Id
	@GeneratedValue
	private int articleId;
	
	@Column(name = "articleTitle")
	private String articleTitle;
	
	@Column(name = "ArticleUrl")
	private String articleUrl;
	
	@Column(name = "PublisherName")
	private String publisherName;
	
	@Column(name = "publisherType")
	private String publisherType;
	
	@Column(name = "PublisherUrl")
	private String publisherUrl;
	
	@Column(name = "releasedOn")
	private String releasedOn;

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleUrl() {
		return articleUrl;
	}

	public void setArticleUrl(String articleUrl) {
		this.articleUrl = articleUrl;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getPublisherType() {
		return publisherType;
	}

	public void setPublisherType(String publisherType) {
		this.publisherType = publisherType;
	}

	public String getPublisherUrl() {
		return publisherUrl;
	}

	public void setPublisherUrl(String publisherUrl) {
		this.publisherUrl = publisherUrl;
	}

	public String getReleasedOn() {
		return releasedOn;
	}

	public void setReleasedOn(String releasedOn) {
		this.releasedOn = releasedOn;
	}
	
	
	
}
