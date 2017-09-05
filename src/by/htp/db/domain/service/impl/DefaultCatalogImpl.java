package by.htp.db.domain.service.impl;

import java.util.Date;
import java.util.List;

import by.htp.db.domain.dao.BookDao;
import by.htp.db.domain.dao.impl.BookMySqlDAO;
import by.htp.db.domain.entity.Book;
import by.htp.db.domain.service.CatalogService;
import by.htp.db.domain.vo.Catalog;

public class DefaultCatalogImpl implements CatalogService {
	
	private BookDao dao;
	
	{
		// TODO!!!Change to factory
		dao = new BookMySqlDAO();
	}
	

	@Override
	public Catalog getCatalog() {
		Catalog catalog = new Catalog();
		List <Book> books = dao.fetchBooks();
		
		catalog.setTitle("New catalog of books");
		catalog.setDateCreation(new Date());
		catalog.setBooks(books);
		return catalog;
	}
	
	@Override
	public Catalog getCatalog(Date date) {
		Catalog catalog = new Catalog();
		List <Book> books = dao.fetchBooks(new Date());
		
		catalog.setTitle("New Date of books");
		catalog.setDateCreation(new Date());
		catalog.setBooks(books);
		
		return catalog;
	}

	
	

}
