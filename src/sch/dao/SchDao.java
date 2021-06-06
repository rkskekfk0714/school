package sch.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SchDao {
	private static SchDao dao = new SchDao();
	private SchDao() {}
	public static SchDao getInstance() {
		return dao;
	}
	
	public Connection connect()
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","1234");
		}catch(Exception e)
		{
			System.out.print("MDAO:connect" + e);
		}
		return conn;
	}
	
	public void close(Connection conn, PreparedStatement pstmt)
	{
		if(pstmt != null)
		{
			try {
				pstmt.close();
			}catch(Exception e) {
				System.out.print("Pstmt close error" + e);
			}
		}
		if(conn != null)
		{
			try {
				conn.close();
			} catch(Exception e)
			{
				System.out.print("Conn close error" + e);
			}
		}
	}
	
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs)
	{
		if(rs != null)
		{
			try {
				rs.close();
			} catch(Exception e)
			{
				System.out.print("rs close error" + e);
			}
		}
		close(conn, pstmt);
	}
	
	public boolean index(String id, String pwd, String radio) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.print(pwd);
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select * from count where id = ? and pwd = ? and radio = ?;");
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, radio);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				result = true;
			}
			else
				result = false;
			
		}catch(Exception e)
		{
			System.out.print("login error" + e);
		} finally
		{
			close(conn, pstmt, rs);
		}
		return true;
	}
	public int proEnroll(String id, int num) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int numDB = 0;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select num from count where id = ?;");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				numDB = rs.getInt(1);
			}
			num = numDB + num;
				
			pstmt = conn.prepareStatement("update count set num=? where id = ?;");
			pstmt.setString(1, num+"");
			pstmt.setString(2, id);
			pstmt.executeUpdate();
			
			
			
		}catch(Exception e)
		{
			System.out.print("proEnroll error" + e);
		} finally
		{
			close(conn, pstmt, rs);
		}
		return num;
	}
	public int proEnrollList(String id) {
		// TODO Auto-generated method stub
		int num = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select num from count where id = ?;");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				num = rs.getInt(1);
			}
			
		}catch(Exception e)
		{
			System.out.print("proEnrollList error" + e);
		} finally
		{
			close(conn, pstmt, rs);
		}
		return num;
	}
}
