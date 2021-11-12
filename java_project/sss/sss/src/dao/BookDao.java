package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionProvider;
import object.Book;
import object.User;
import util.JdbcUtil;


public class BookDao {
	Connection conn;

	// 싱글톤
	private BookDao() {
		try {
			conn = ConnectionProvider.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static BookDao dao = new BookDao();

	static public BookDao getInstance() {
		return dao;
	}

	// 도서의 전체 목록을 출력하는 메소드
	public List<Book> selectAllList() {
		System.out.println("요기는dao");
		Statement stmt = null;
		ResultSet rs = null;
		List<Book> result = new ArrayList<Book>();
		
		try {

			stmt = conn.createStatement();

			String sql = "select * from book";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				result.add(new Book(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7)));
			System.out.println("데이터");
			}

		} catch (SQLException e) {
			System.out.println("!!System alert!!");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}

		return result;
	}

	// 도서 검색 메소드(카테고리별)
	public Book selectByCategory(Connection conn, String category) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 검색 결과 : 도서 정보
		Book book = null;

		String sql = "select * from book where category=?";
		// 결과 -> 1또는0행

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				book = new Book(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return book;
	}

	// 도서를 검색 메소드(제목으로)
	public Book selectByBookName(Connection conn, String bookName) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 검색 결과 : 도서 정보
		Book book = null;

		String sql = "select * from book where bookname=%?%";
		// 결과 -> 1또는0행

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookName);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				book = new Book(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return book;
	}

	// 도서를 검색 메소드(저자명으로)
	public Book selectByWriter(Connection conn, String writer) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 검색 결과 : 도서 정보
		Book book = null;

		String sql = "select * from book where writer=?";
		// 결과 -> 1또는0행

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				book = new Book(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return book;
	}

	// 도서를 검색 메소드(출판사명으로)
	public Book selectByPublisher(Connection conn, String publisher) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 검색 결과 : 도서 정보
		Book book = null;

		String sql = "select * from book where publisher=?";
		// 결과 -> 1또는0행

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, publisher);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				book = new Book(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return book;
	}

	// 도서 정보를 입력 메소드
	public int insertBook(Connection conn, Book book) {

		PreparedStatement pstmt = null;

		int resultCnt = 0;

		String sql = "insert into book values (?, ?, ?, ?, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, book.getBookid());
			pstmt.setString(2, book.getBookName());
			pstmt.setInt(3, book.getPrice());
			pstmt.setString(4, book.getWriter());
			pstmt.setString(5, book.getCategory());
			pstmt.setString(6, book.getPublisher());
			pstmt.setInt(7, book.getStock());

			resultCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}

		return resultCnt;
	}

	// 도서 정보를 수정하는 메소드
	public int editBook(Connection conn, Book book) {

		PreparedStatement pstmt = null;

		int resultCnt = 0;

		String sql = "update dept set price = ?, writer = ?, category = ?, publisher = ? where bookid = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, book.getPrice());
			pstmt.setString(2, book.getWriter());
			pstmt.setString(3, book.getCategory());
			pstmt.setString(4, book.getPublisher());

			resultCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}

		return resultCnt;
	}

	// 도서를 삭제하는 메소드
	public int deleteBook(Connection conn, int bookid) {

		PreparedStatement pstmt = null;
		int resultCnt = 0;

		String sql = "delete from book where bookid = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookid);

			resultCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}

		return resultCnt;
	}

	
///////////////////////////////////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////////////////////////////////
	// 도서를 구매하는 메소드
	public int purchaseBook(int orderId, int bookId) {
		
		PreparedStatement pstmt = null;
		int resultCnt = 0;

		String sql = "insert into BIT_ORDERS values (?, ?, ?, sysdate)"; //


		try {
			pstmt = conn.prepareStatement(sql);

			
			pstmt.setInt(1, 3);
			pstmt.setInt(2, bookId);
			pstmt.setInt(3, 1);
		
			
			resultCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}

		return resultCnt;
	}




}
