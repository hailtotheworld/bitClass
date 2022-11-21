package program;

import java.sql.SQLException;

import com.newlecture.app.service.NoticeServiceCl;

public class programCl {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		NoticeServiceCl service = new NoticeServiceCl();
		service.getList();
		
	}

}
