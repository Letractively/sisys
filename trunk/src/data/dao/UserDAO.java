package data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import data.bean.Batch;
import data.bean.User;
import data.bean.UserBean;
import data.bean.mapping.BatchMapping;
import data.bean.mapping.BeanMapping;
import data.bean.mapping.UserMapping;

public class UserDAO {

	GenericTemplate genericTemplate;
	List<Object> value;
	String sql;
	int result;
	boolean flag;
	List<User> list;
	
	/**
	 * 构造函数
	 */
	public UserDAO() {
		genericTemplate = new GenericTemplate();
		value = new ArrayList<Object>();
		result = 0;
		flag = false;
		list = new ArrayList<User>();
	}
	
	public int create(User entity) {
		// TODO Auto-generated method stub
		sql = "insert into user values (?,?,?,?,?,?)";
		
		value.add(entity.getId());
		value.add(entity.getUsername());
		value.add(entity.getPassword());
		value.add(entity.getLevel());
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

	public int delete(User entity) {
		// TODO Auto-generated method stub
		sql = "update user set isDelete=?,deleteTime=? where id=?";
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

	public int update(User entity) {
		// TODO Auto-generated method stub
		sql = "update user set username=?,password=?,level=?,isDelete=?,deleteTime=? where id=?";


		value.add(entity.getUsername());
		value.add(entity.getPassword());
		value.add(entity.getLevel());
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

	public List<User> read(User entity) {
		// TODO Auto-generated method stub
		UserMapping userMapping = new UserMapping();
		User user = null;
		ResultSet resultSet;
		sql = "select * from user where Id=?";
		value.add(entity.getId());
		genericTemplate.setSqlValue(sql);
		genericTemplate.setValues(value);
		try {
			resultSet = genericTemplate.executeQuery();
			//System.out.print(genericTemplate.executeQuery());
			user = (User) userMapping.mapping(resultSet);
			list.add(user);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			genericTemplate.close();
		}
		return list;
	}

	public List<User> readByPk(Integer pk) {
		// TODO Auto-generated method stub
		UserMapping userMapping = new UserMapping();
		User user = null;
		ResultSet resultSet;
		sql = "select * from user where Id=?";
		value.add(pk);
		genericTemplate.setSqlValue(sql);
		genericTemplate.setValues(value);
		try {
			resultSet = genericTemplate.executeQuery();
			user = (User)userMapping.mapping(resultSet);
			list.add(user);
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
		sql = "select count(*) from user";
		genericTemplate.setSqlValue(sql);
		try {
			resultSet = genericTemplate.executeQuery();
			while(resultSet.next()) {
				result ++;
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			genericTemplate.close();
		}
		return result;
	}

}
