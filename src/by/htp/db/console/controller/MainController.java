package by.htp.db.console.controller;

import java.util.Date;

import by.htp.db.console.view.ConsoleOutput;
import by.htp.db.console.view.impl.SimpleConsoleOutput;
import by.htp.db.domain.service.CatalogService;
import by.htp.db.domain.service.impl.DefaultCatalogImpl;
import by.htp.db.domain.vo.Catalog;

public class MainController {

	public static void main(String[] args) {
		 ConsoleOutput output = new SimpleConsoleOutput();
		 CatalogService service = new DefaultCatalogImpl();
		 
		 Catalog catalog = service.getCatalog();
		 output.printCatalog(catalog);
		 
		 Catalog catalogDate = service.getCatalog(new Date());
		 output.printCatalog(catalogDate);

	}

}
