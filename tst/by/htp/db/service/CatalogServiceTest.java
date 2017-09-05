package by.htp.db.service;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import by.htp.db.domain.service.CatalogService;
import by.htp.db.domain.service.impl.DefaultCatalogImpl;
import by.htp.db.domain.vo.Catalog;

public class CatalogServiceTest {
	
	private static CatalogService service;
	
	@BeforeClass
	public static void initCatalogServiceTest(){
		service = new DefaultCatalogImpl();
		
	}
	
	@Test
	public void testCatalogNotNull() {
		Catalog catalog = service.getCatalog();
		assertNotNull("The catalog isn't created", catalog);
	}
	
	@Test
	public void testCatalogNotEmptyFields() {
		Catalog catalog = service.getCatalog();
		assertNotNull("The catalog title wasn't filled in", catalog.getTitle());
		assertNotNull("The date of creation wasn't set", catalog.getDateCreation());
		assertNotNull("The book catalog wasn't attached to catalog item", catalog.getBooks());
	}
	
	@Test
	public void testCatalogEmptyBooks() {
		Catalog catalog = service.getCatalog();
		assertNotNull("The book catalog wasn't attached to catalog item", catalog.getBooks());
		assertTrue("The book list is empty",  catalog.getBooks().size()>0);
	}

}
