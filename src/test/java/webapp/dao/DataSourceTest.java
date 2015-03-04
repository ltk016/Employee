package webapp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.eclipse.jdt.internal.compiler.apt.model.Factory;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import webapp.util.EmployeeDataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/webapp/spring/beans.xml")
public class DataSourceTest {
	static Log log = LogFactory.getLog(DataSourceTest.class);

	@Autowired
	private ApplicationContext factory;
	
	@Test
	public void testDariverManagerDataSource() throws SQLException {
		DataSource ds = factory.getBean(DataSource.class);
		Connection con = ds.getConnection();
		Statement stmnt = con.createStatement();
		ResultSet rs = stmnt.executeQuery("select 2+2 from dual");
		
		rs.next();
		
		int sum = rs.getInt(1);
		
		assertEquals(4, sum);
		
		log.info("sum=" + sum);
	}

	@Test
	public void testDataSource() throws SQLException {
		String className = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";

		DriverManagerDataSource dmds = new DriverManagerDataSource();

		dmds.setDriverClassName(className);
		dmds.setUrl(url);
		dmds.setUsername(user);
		dmds.setPassword(password);

		Connection con = dmds.getConnection();
		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("select 1+1 from dual");
		rs.next();

		int sum = rs.getInt(1);

		assertEquals(2, sum);

		log.info("sum=" + sum);
	}
}
