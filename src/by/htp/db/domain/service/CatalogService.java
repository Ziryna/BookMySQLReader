package by.htp.db.domain.service;

import java.util.Date;

import by.htp.db.domain.vo.Catalog;

public interface CatalogService {
	
	Catalog getCatalog();
	Catalog getCatalog(Date date);
	

}
