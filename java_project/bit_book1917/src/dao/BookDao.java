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
import util.JdbcUtil;

public class BookDao {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement pstmt;
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
	public  List<Book> selectAllList() {
		
		List<Book> result = new ArrayList<Book>();
		
		try {
			stmt = conn.createStatement();
			String sql = "select * from bit_book";
			rs = stmt.executeQuery(sql);


			while (rs.next()) {
				result.add(new Book(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7)));
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
	public List<Book> selectByCategory(int categoryId) {

		// 검색 결과 : 도서 정보
		List<Book> result = new ArrayList<Book>();

		String sql = "select * from bit_book where categoryid = ?";
		// 결과 -> 1또는0행

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, categoryId);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				result.add(new Book(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return result;
	}

	// 도서를 검색 메소드(제목으로)
	public List<Book> selectByBookName(String bookName) {
		
		// 검색 결과 : 도서 정보
		List<Book> result = new ArrayList<Book>();

		String sql = "select * from bit_book where bookname LIKE '%' || ? || '%'";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookName);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
				result.add(new Book(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7)));
			}

		} catch (SQLException e) {
			System.out.println(bookName + "이(가) 들어간 도서를 찾을 수 없습니다.");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return result;
	}


	// 도서를 검색 메소드(저자명으로)
	public List<Book> selectByWriter(String writer) {

		// 검색 결과 : 도서 정보
		List<Book> result = new ArrayList<>();

		String sql = "select * from bit_book where writer LIKE '%' || ? || '%'";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				result.add(new Book(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7)));
			}

		} catch (SQLException e) {
			System.out.println(writer + "은(는) 찾을 수 없습니다.");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return result;
	}

	// 도서를 검색 메소드(출판사명으로)
	public List<Book> selectByPublisher(String publisher) {

		// 검색 결과 : 도서 정보
		List<Book> result = new ArrayList<>();

		String sql = "select * from book where publisher LIKE '%' || ? || '%'";
		

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, publisher);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				result.add(new Book(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7)));
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return result;
	}

	// 도서 정보를 입력 메소드
	public int insertBook(Book book) {

		int resultCnt = 0;

		String sql = "insert into BIT_BOOK values (?, ?, ?, ?, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, book.getBookid());
			pstmt.setString(2, book.getBookName());
			pstmt.setInt(3, book.getPrice());
			pstmt.setString(4, book.getWriter());
			pstmt.setString(5, book.getPublisher());
			pstmt.setInt(6, book.getCategory());
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

	// 도서 정보를 수정하는 메소드(수정 필요)
	// 
	public int editBook(Book book) {
		
		int resultCnt = 0;

		String sql = "update bit_book set price = ?, writer = ?, category = ?, publisher = ? where bookid = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, book.getPrice());
			pstmt.setString(2, book.getWriter());
			pstmt.setInt(3, book.getCategory());
			pstmt.setString(4, book.getPublisher());

			resultCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}

		return resultCnt;
	}

	// 도서를 삭제하는 메소드(수정 필요)
	public int deleteBook(Connection conn, int bookid) {

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

	// 도서를 구매하는 메소드(작업 필요)
	public int purchaseBook(Connection conn, int bookid) {
		return bookid = 3;
		
	}

	
}
