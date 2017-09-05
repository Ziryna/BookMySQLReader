package by.htp.db.domain.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.htp.db.domain.dao.BookDao;
import by.htp.db.domain.entity.Book;

public class BookMySqlDAO implements BookDao{
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/mylibrary?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";

	private static final String DB_USER = "root";
	private static final String DB_PASS = "root";
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	
	private static final String SQL_SELECT_BOOKS = "select * from book";
	//private static final String SQL_SELECT_BOOK_ID = "select * from book where id =?";
	private static final String SQL_SELECT_BOOK_DATE = "select * from book where date <= ?";
	
	@Override
	public List<Book> fetchBooks() {
		List<Book> books = new ArrayList<Book>();
		Connection con = null;
		
		try{
			Class.forName(DB_DRIVER); 
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT_BOOKS);
			
			Book book = null;
			
			
			while(rs.next()){
				
				book = new Book();
				
				book.setId(rs.getInt("id"));
				book.setTitle(rs.getString("title"));
				book.setPages(rs.getInt("pages"));
				
				books.add(book);
				
				//System.out.println(id + " " + title + " " + pages);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return books;
	}

	@Override
	public List<Book> fetchBooks(Date date) {
		List<Book> books = new ArrayList<Book>();
		Connection con = null;
		Book book = null;
		
		try{
			
			Class.forName(DB_DRIVER);
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			System.out.println(sqlDate.toString());

			PreparedStatement ps = con.prepareStatement(SQL_SELECT_BOOK_DATE);
			ps.setDate(1, sqlDate);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				book = new Book();
				
				book.setId(rs.getInt("id"));
				book.setTitle(rs.getString("title"));
				book.setPages(rs.getInt("pages"));
				book.setDate(rs.getDate("date"));
				books.add(book);
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return books;
	}
}
