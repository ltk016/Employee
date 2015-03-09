package webapp.model;

import static org.junit.Assert.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeptTest {

	static Log log = LogFactory.getLog(DeptTest.class);

	@Test
	public void test1() {
		Dept d1 = new Dept(100, "xxx", "yyy");
		Dept d2 = new Dept(100, "xxx", "yyy");

		log.info("d1 == d2	   :  " + (d1 == d2));
		log.info("d1.equals(d2) :  " + d1.equals(d2));
	}

	@Test
	public void test2() {
		String s1 = new String("xxx");
		String s2 = new String("xxx");

		log.info("s1 == s2	   :  " + (s1 == s2));
		log.info("s1.equals(s2) :  " + s1.equals(s2));
	}
	
	@Test
	public void test3() {
		Dept d1 = new Dept(100, null, null);
		Dept d2 = new Dept(100, null, null);
		
		assertEquals(d1, d2);
	}
	
	@Test
	public void test4() {
		Dept d1 = new Dept(100, "xxx", null);
		Dept d2 = new Dept(100, null, null);
		
		assertNotEquals(d1, d2);
	}
	
	@Test
	public void test5() {
		Dept d1 = new Dept(100, "xxx", null);
		Dept d2 = new Dept(100, "xxx", null);
		
		assertEquals(d1, d2);
	}
	
	@Test
	public void test6() {
		Dept d1 = new Dept(100, "xxx", "yyy");
		Dept d2 = new Dept(100, null, null);
		
		assertNotEquals(d1, d2);
	}
	
	@Test
	public void test7() {
		Dept d1 = new Dept(100, "xxx", "yyy");
		Dept d2 = new Dept(100, "xxx", "yyy");
		
		assertEquals(d1, d2);
	}
	
	@Test
	public void test8() {
		Dept d1 = new Dept(null, "xxx", "yyy");
		Dept d2 = new Dept(100, "xxx", "yyy");
		
		assertNotEquals(d1, d2);
	}
	
	@Test
	public void test9() {
		Dept d1 = new Dept(null, "xxx", "yyy");
		Dept d2 = new Dept(null, "xxx", "yyy");
		
		assertEquals(d1, d2);
	}
}
