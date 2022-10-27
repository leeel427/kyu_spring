package kr.co.magic;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"} )
public class DBConnectionTest3Test2 {

	@Autowired
	DataSource ds;
	
	@Test
	public void springJdbcConnectionTest() throws SQLException {
//		ApplicationContext ac = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/**/root-context.xml");	
//		DataSource ds = ac.getBean(DataSource.class);		// 어노테이션으로 변경
	
		Connection conn = ds.getConnection();
		
		
		//괄호안의 조건식이 true 면 테스트 성공,아니면 실패
		assertTrue(conn != null);
		
		
	}
	
}
