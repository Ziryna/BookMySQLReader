package by.htp.db.domain.dao;

import java.util.Date;
import java.util.List;

import by.htp.db.domain.entity.Book;

public interface BookDao {
	List<Book> fetchBooks();
	List<Book> fetchBooks(Date date);
		
	}
	
