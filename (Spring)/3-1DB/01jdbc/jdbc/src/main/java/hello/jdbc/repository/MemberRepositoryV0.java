package hello.jdbc.repository;

import hello.jdbc.connection.DBConnectionUtil;
import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;

import java.security.PrivilegedAction;
import java.sql.*;

/**
 * JDBC - DriverManager 사용
 */
@Slf4j
public class MemberRepositoryV0 {

    public Member save(Member member) throws SQLException {
        String sql = "insert into member(member_id, money) values (?, ?)";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, member.getMemberId());
            pstmt.setInt(2, member.getMoney());
            pstmt.executeUpdate();
            return member;
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            close(con, pstmt, null);
//            con.close(); //외부 리소스를 쓰고 있는거다. 실제 TCP/IP걸려서 쓰고있는거다. 이 커넥션을 안닫아주면 계속 연결이 안끊어지고 유지되게 된다. 꼭 닫아줘야 한다.
        }

    }

    private void close(Connection con, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                log.info("error",e);
            }
        }
        if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                log.info("error",e);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                log.info("error",e);
            }
        }
    }


    private Connection getConnection() {
        return DBConnectionUtil.getConnection();
    }
}
