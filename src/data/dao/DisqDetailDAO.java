package data.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import data.bean.DisqDetail;
import data.bean.mapping.DisqDetailMapping;
import data.util.GenericQueryImpl;
import data.util.GenericTemplate;

public class DisqDetailDAO  extends GenericQueryImpl<DisqDetail, DisqDetailMapping> {

	//GenericTemplate genericTemplate;
	List<Object> value;
	String sql;
	int result;
	boolean flag;
	List<DisqDetail> list;
	static DisqDetailMapping disqDetailMapping = new DisqDetailMapping();
	
	/**
	 * 构造函数
	 */
	public DisqDetailDAO() {
		super(DisqDetail.class, disqDetailMapping);
		//genericTemplate = new GenericTemplate();
		value = new ArrayList<Object>();
		result = 0;
		flag = false;
		list = new ArrayList<DisqDetail>();
	}
	
	public int create(DisqDetail entity) {
		// TODO Auto-generated method stub
		sql = "insert into disqdetail values (?,?,?,?)";
		
		value.add(entity.getId());
		value.add(entity.getDisKId());
		value.add(entity.getNextId());
		value.add(entity.getNum());
		
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

	public int delete(DisqDetail entity) {
		// TODO Auto-generated method stub
		sql = "delete from disqDetail where Id=?";
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

	public int update(DisqDetail entity, Integer pk) {
		// TODO Auto-generated method stub
		sql = "update disqDetail set disKId=?,nextId=?,num=? where Id=?";

		value.add(entity.getDisKId());
		value.add(entity.getNextId());
		value.add(entity.getNum());		
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

	public List<DisqDetail> read(DisqDetail entity) {
		// TODO Auto-generated method stub
		DisqDetailMapping disqDetailMapping = new DisqDetailMapping();
		DisqDetail disqDetail = null;
		ResultSet resultSet;
		sql = "select * from disqDetail where Id=?";
		value.add(entity.getId());
		genericTemplate.setSqlValue(sql);
		genericTemplate.setValues(value);
		try {
			resultSet = genericTemplate.executeQuery();
			//System.out.print(genericTemplate.executeQuery());
			disqDetail = disqDetailMapping.mapping(resultSet);
			list.add(disqDetail);
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			genericTemplate.close();
		}
		return list;
	}

	public List<DisqDetail> readByPk(Integer pk) {
		// TODO Auto-generated method stub
		DisqDetailMapping disqDetailMapping = new DisqDetailMapping();
		DisqDetail disqDetail = null;
		ResultSet resultSet;
		sql = "select * from disqDetail where Id=?";
		value.add(pk);
		genericTemplate.setSqlValue(sql);
		genericTemplate.setValues(value);
		try {
			resultSet = genericTemplate.executeQuery();
			disqDetail = disqDetailMapping.mapping(resultSet);
			list.add(disqDetail);
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
		sql = "select count(*) from disqDetail";
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
