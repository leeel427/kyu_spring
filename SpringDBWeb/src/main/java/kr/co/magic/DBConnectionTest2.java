package kr.co.magic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DBConnectionTest2 {

	public static void main(String[] args) throws SQLException {
		// 데이터베이스 접속 정보 변수 선언
		String DB_URL = "jdbc:postgresql://localhost:5432/ezendb";		// postgres,ezendb,dvdrental
		// DB의 사용자정보
		String DB_USER = "postgres";
		String DB_PASSWORD = "0101";
		String DB_DRIVER = "org.postgresql.Driver";

		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(DB_DRIVER);
		ds.setUrl(DB_URL);
		ds.setUsername(DB_USER);
		ds.setPassword(DB_PASSWORD);
		
		//데이터베이스의 연결 얻음
		Connection conn = ds.getConnection();
		System.out.println("conn = " + conn);
		
		
		

//		
//		// 2) Statement 객체 생성 
//		Statement stmt = conn.createStatement();
//		
//		// 시스템의 현재 날짜 시간 출력하는 쿼리
//		String query = "select * from t_user";
//		
//		// 3) Statement 객체의 executeQuery() 실행해서 ResultSet 객체를 생성.
//		// query 실행 결과를 rs에 담음
//		ResultSet rs = stmt.executeQuery(query);
//		
//		// 실행 결과가 담긴 rs 에서 한줄씩 읽어서 출력
//		while (rs.next()) {
//			String curDate = rs.getString(1);		// 읽어온 행의 첫번째 컬럼의 값을 String으로 읽어서 curDate 에 저장
//			System.out.println(curDate);
//		}
//		
//		
		
		
	}

}
