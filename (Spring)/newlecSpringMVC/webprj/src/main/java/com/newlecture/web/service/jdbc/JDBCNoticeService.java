package com.newlecture.web.service.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@Service // @Component @Controller @Service @Repository
public class JDBCNoticeService implements NoticeService{
	
//	private String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
//	private String username = "SCOTT";
//	private String password = "tiger";
//	private String driverClassName = "oracle.jdbc.driver.OracleDriver";
	
	@Autowired
	private DataSource dataSource;
	
//	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}
	
	public List<Notice> getList(int page, String field, String query) throws ClassNotFoundException, SQLException{
		
		int start = 1 + (page-1)*10;     // 1, 11, 21, 31, ..
		int end = 10*page; // 10, 20, 30, 40...
		
		String sql = "SELECT * FROM NOTICE";
		
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(dataSource);
		List<Notice> list = template.query(sql,new BeanPropertyRowMapper(Notice.class));
		//                 ㄴ서버쪽에 있는 데이터베이스 컬럼과 그것을 데이터객체에 담을건데 매핑해주는 정보를 달라고한다.
		// new BeanPropertyRowMapper(Notice.class) Bean이라는 Property를 자동으로 매핑해준다.
		
		// .query          목록을 반환.
		// .queryForList   목록을 반환. 과거버전의 호환성을 위해서 사용하기도 하는데 가능하면 안씀.
		// .queryForObject 단일객체를 반환할때 쓴다. row하나 혹은 특정값을 반환할때 쓴다.
		
//		String sql = "SELECT * FROM NOTICE_VIEW WHERE "+field+" LIKE ? AND NUM BETWEEN ? AND ?";	
		/*
		String sql = "select * from "
				+ "(select rownum NUM, N.* "
				+ "from (select * from notice_view where "+ field +" like ? order by regdate desc) N) "
				+ "where NUM between ? and ?";
		
		//Class.forName(driver);
		//Connection con = DriverManager.getConnection(url,uid, pwd);
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+query+"%");
		st.setInt(2, start);
		st.setInt(3, end);
		ResultSet rs = st.executeQuery();
		
		List<NoticeView> list = new ArrayList<NoticeView>();
		
		while(rs.next()){
		    int id = rs.getInt("ID");
		    String title = rs.getString("TITLE");
		    String writerId = rs.getString("WRITER_ID");
		    Date regDate = rs.getDate("REGDATE");
//		    String content = rs.getString("CONTENT");
		    int hit = rs.getInt("hit");
		    String files = rs.getString("FILES");
		    int cmtCount = rs.getInt("CMT_COUNT");
		    
		    NoticeView noticeView = new NoticeView(
		    					id,
		    					title,
		    					writerId,
		    					regDate,
		    					"",
		    					hit,
		    					files,
		    					cmtCount
		    				);

		    list.add(noticeView);
		    
		}

		
		rs.close();
		st.close();
		con.close();
		*/
		
		return list;
	}
	
	// Scalar 
	public int getCount() throws ClassNotFoundException, SQLException {
		int count = 0;
		
		String sql = "SELECT COUNT(ID) COUNT FROM NOTICE";	
		
		//Class.forName(driver);
		//Connection con = DriverManager.getConnection(url,uid, pwd);
		Connection con = dataSource.getConnection();
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery(sql);
		
		if(rs.next())
			count = rs.getInt("COUNT");		
		
		rs.close();
		st.close();
		con.close();
		
		return count;
	}

	public int insert(Notice notice) throws SQLException, ClassNotFoundException {
		String title = notice.getTitle();
		String writerId = notice.getWriterId();
		String content = notice.getContent();
		String files = notice.getFiles();
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "INSERT INTO notice (    " + 
				"    title," + 
				"    writer_id," + 
				"    content," + 
				"    files" + 
				") VALUES (?,?,?,?)";	
		
		//Class.forName(driver);
		//Connection con = DriverManager.getConnection(url,uid, pwd);
		Connection con = dataSource.getConnection();               
		//Statement st = con.createStatement();
		//st.ex....(sql)
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, writerId);
		st.setString(3, content);
		st.setString(4, files);
		
		int result = st.executeUpdate();
		
		
		st.close();
		con.close();
		
		return result;
	}
	
	public int update(Notice notice) throws SQLException, ClassNotFoundException {
		String title = notice.getTitle();
		String content = notice.getContent();
		String files = notice.getFiles();
		int id = notice.getId();
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "UPDATE NOTICE " + 
				"SET" + 
				"    TITLE=?," + 
				"    CONTENT=?," + 
				"    FILES=?" + 
				"WHERE ID=?";
		
		//Class.forName(driver);
		//Connection con = DriverManager.getConnection(url,uid, pwd);
		Connection con = dataSource.getConnection();               
		//Statement st = con.createStatement();
		//st.ex....(sql)
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, content);
		st.setString(3, files);
		st.setInt(4, id);
		
		int result = st.executeUpdate();
				
		st.close();
		con.close();
		
		return result;
	}
	
	public int delete(int id) throws ClassNotFoundException, SQLException {
	
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "DELETE NOTICE WHERE ID=?";
		
		//Class.forName(driver);
		//Connection con = DriverManager.getConnection(url,uid, pwd);
		Connection con = dataSource.getConnection();                
		//Statement st = con.createStatement();
		//st.ex....(sql)
		PreparedStatement st = con.prepareStatement(sql);		
		st.setInt(1, id);
		
		int result = st.executeUpdate();
				
		st.close();
		con.close();
		
		return result;
	}

	
}
