package data.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import data.bean.Department;
import data.bean.mapping.DepartmentMapping;
import data.util.GenericQueryImpl;
import data.util.GenericTemplate;

public class DepartmentDAO extends GenericQueryImpl<Department, DepartmentMapping> {

	//GenericTemplate genericTemplate;
	List<Object> value;
	String sql;
	int result;
	boolean flag;
	List<Department> list;
	static DepartmentMapping departmentMapping = new DepartmentMapping();
	
	/**
	 * 构造函数
	 */
	public DepartmentDAO() {
		super(Department.class, departmentMapping);
		//genericTemplate = new GenericTemplate();
		value = new ArrayList<Object>();
		result = 0;
		flag = false;
		list = new ArrayList<Department>();
	}
	
	public int create(Department entity) {
		// TODO Auto-generated method stub
		sql = "insert into department values (?,?,?,?,?)";
		
		value.add(entity.getId());
		value.add(entity.getDeptNo());
		value.add(entity.getDeptName());
		value.add(entity.getIsDelete());
		value.add(entity.getDeleteTime());
		
		genericTemplate.setSqlValue(sql);
		genericTemplate.setValues(value);
		try {
			result = genericTemplate.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			genericTemplate.close();
		}
		
		return result;
	}

	public int delete(Department entity) {
		// TODO Auto-generated method stub
		sql = "update department set isDelete=?,deleteTime=? where id=?";
		value.add(1);
		value.add(new Date());
		value.add(entity.getId());
		genericTemplate.setSqlValue(sql);
		genericTemplate.setValues(value);
		try {
			result = genericTemplate.executeUpdate();
		} catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			genericTemplate.close();
		}

		return result;
	}

	public int update(Department entity) {
		// TODO Auto-generated method stub
		sql = "update department set deptNo=?,deptName=?,isDelete=?,deleteTime=? where id=?";


		value.add(entity.getDeptNo());
		value.add(entity.getDeptName());
		value.add(entity.getIsDelete());
		value.add(entity.getDeleteTime());
		value.add(entity.getId());
		
		genericTemplate.setSqlValue(sql);
		genericTemplate.setValues(value);
		try {
			result = genericTemplate.executeUpdate();
		} catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			genericTemplate.close();
		}
		return result;
	}

	public List<Department> read(Department entity) {
		// TODO Auto-generated method stub
		DepartmentMapping departmentMapping = new DepartmentMapping();
		Department department = null;
		ResultSet resultSet;
		sql = "select * from department where Id=?";
		value.add(entity.getId());
		genericTemplate.setSqlValue(sql);
		genericTemplate.setValues(value);
		try {
			resultSet = genericTemplate.executeQuery();
			//System.out.print(genericTemplate.executeQuery());
			department = departmentMapping.mapping(resultSet);
			list.add(department);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			genericTemplate.close();
		}
		return list;
	}

	public List<Department> readByPk(Integer pk) {
		// TODO Auto-generated method stub
		DepartmentMapping departmentMapping = new DepartmentMapping();
		Department department = null;
		ResultSet resultSet;
		sql = "select * from department where Id=?";
		value.add(pk);
		genericTemplate.setSqlValue(sql);
		genericTemplate.setValues(value);
		try {
			resultSet = genericTemplate.executeQuery();
			department = departmentMapping.mapping(resultSet);
			list.add(department);
		} catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			genericTemplate.close();
		}
		return list;
	}

	public int count() {
		// TODO Auto-generated method stub
		ResultSet resultSet;
		sql = "select count(*) from department";
		genericTemplate.setSqlValue(sql);
		try {
			resultSet = genericTemplate.executeQuery();
			if(resultSet.next()) {
				result = resultSet.getInt("count(*)");
			}
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			genericTemplate.close();
		}
		return result;
	}

}
