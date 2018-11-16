package com.varun.newsapp.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.varun.newsapp.model.Article;
import com.varun.newsapp.repository.ArticleRepository;


@RestController
@RequestMapping("/article")
public class ArticleResource {
	final int articleSend=10; // Articles 
	
	@Autowired
	ArticleRepository articleRepo;
	
	@GetMapping("/all")
	public List<Article>  getAllArticles()
	{
		return articleRepo.findAll();
	}
	
	@GetMapping("/offset/{Id}")
	public List<Article>  getArticles(@PathVariable(value="Id") Integer id)
	{
		
		List<Article> ls= articleRepo.findAll();
		List<Article> ans=new ArrayList<>();
		int start=id*articleSend;
		for(int i=start;i<start+articleSend && i<articleRepo.count();i++)
		{
			ans.add(ls.get(i));
		}
		return ans;
	}
}
