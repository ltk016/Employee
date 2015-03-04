package webapp.service;

import javax.sql.DataSource;

import webapp.dao.DeptDao;
import webapp.model.Dept;

public class DeptInfoService {

	DeptDao deptdao;
	DataSource dataSource;
	
	public void setDeptDao(DeptDao dao) {
		deptdao = dao;
	}
	
	public void setDataSource(DataSource datasource) {
		this.dataSource = datasource;
	}
	
	public Dept getDeptInfo(Integer deptno) {
		
		Dept dept = deptdao.selectByDeptno(deptno);
		
		return dept;
	}
	public Dept getDeptInfoWithEmps(Integer deptno) {
		
		Dept dept = deptdao.selectByDeptnoWithEmps(deptno);
				
		return dept;
	}
	
}















