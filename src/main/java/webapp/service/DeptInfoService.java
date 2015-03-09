package webapp.service;

import java.util.List;

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

	public List<Dept> getDeptInfoAll() {

		List<Dept> list = deptdao.selectAll();

		return list;
	}

	public List<Dept> getDeptInfoAllWithEmps() {

		List<Dept> list = deptdao.selectAllWithEmps();

		return list;
	}
}
