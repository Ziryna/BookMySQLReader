package by.htp.db.domain.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import by.htp.db.domain.dao.impl.BookMySqlDAO;
import by.htp.db.domain.entity.Book;

public class BookDaoTest {

	private static BookDao dao;

	@BeforeClass
	public static void initDao() {
		dao = new BookMySqlDAO();
	}
	
	@Test
	public void testNullList() {
		List<Book> books = dao.fetchBooks();
		assertNotNull("The returned list is null", books);
	}

	@Test
	public void testEmpty() {
		List<Book> books = dao.fetchBooks();
		assertTrue("The returned list contains null books", books.size() > 0);
	}

	@Test
	public void testListContainsBook() {
		List<Book> books = dao.fetchBooks();
		assertTrue(books.containsAll(books));
	}

}