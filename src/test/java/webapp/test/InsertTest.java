package webapp.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.print.attribute.standard.PresentationDirection;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;


public class InsertTest {
	static GenericXmlApplicationContext factory;
	static Logger log = Logger.getLogger(InsertTest.class);
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		log.info("### setUpBeforeClass");
		factory = new GenericXmlApplicationContext("classpath:/webapp/resource/beans.xml");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		log.info("### tearDownAfterClass");
		factory.close();
	}
	
	@Test
	public void testInsert() throws SQLException {
		DataSource ds = factory.getBean(DataSource.class);
		Connection con = ds.getConnection();
		
		con.setAutoCommit(false);
		
		String sql = "insert into dept values (?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, 70);
		pstmt.setString(2, "xxx");
		pstmt.setString(3, "yyyy");		
		
		pstmt.executeUpdate();
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, 80);
		pstmt.setString(2, "xxx");
		pstmt.setString(3, "yyyy");
		
		pstmt.executeUpdate();
		
//		con.rollback();
		con.commit();
	
	}
}





