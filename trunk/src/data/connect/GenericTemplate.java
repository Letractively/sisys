package data.connect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class GenericTemplate {
	    // �������ݿ�����
		private int result;
		private DatabaseConnect databaseConnect;
	    private Connection connection;
	 
	    // ����sql���
	    private String sqlValue;
	 
	    // ����sql�������б�
	    private List<Object> values;
	 
	    private PreparedStatement preparedStatement;
	    private Statement statement;
	    private ResultSet resultSet;
	    /*
	     * ���캯��
	     */
	    public GenericTemplate() {
	    	 databaseConnect = new DatabaseConnect();
		     connection = databaseConnect.getConnection();
		     result = 0;
	    }
	    
	    /**
	     * �趨SQL���
	     */
	    public void setSqlValue(String sqlValue) {
	        this.sqlValue = sqlValue;
	    }
	 
	    /**
	     * �趨SQL���Ĳ����б�
	     */
	    public void setValues(List<Object> values) {
	        this.values = values;
	    }
	 
	    /**
	     * ��SQL�������б��е�ֵ����Ԥִ�����.
	     *
	     * @param pstmt
	     *            Ԥִ�����
	     * @param values
	     *            sql�������б�
	     * @throws SQLException 
	     */
	    private void setValues(PreparedStatement pstmt, List<Object> values) throws SQLException {
	        // ѭ������SQL�������б��е�ֵ���θ���Ԥִ�����
	    	
	        for (int i = 0; i < values.size(); i++) {
	            Object v = values.get(i);
	            // ע�⣬setObject()����������ֵ��1��ʼ��������i+1
	            pstmt.setObject(i + 1, v);
	        }
	    }
	 
	    /**
	     * ִ�в�ѯ
	     *
	     * @return a javax.servlet.jsp.jstl.sql.Result
	     *                ����Result����result
	     * @exception SQLException
	     *                ����sql�쳣
	     */
	    public ResultSet executeQuery() throws SQLException {
	    	
	            if (values != null && values.size() > 0) {
	                // ʹ��Ԥ������䣬���趨���е�sql������в���ֵ
	                preparedStatement = (PreparedStatement) connection.prepareStatement(sqlValue);
	                setValues(preparedStatement, values);
	                //System.out.print(values);
	                // ִ�в�ѯsql��䣬���ز�ѯ�����
	                resultSet = preparedStatement.executeQuery();
	            } else {
	                statement = (Statement) connection.createStatement();
	                resultSet = statement.executeQuery(sqlValue);
	               
	            }
	        return resultSet;
	    }
	 
	    /**
	     * ִ��Update���
	     *
	     * @return numOfRows
	     *                ������Ӱ�������
	     * @exception SQLException
	     *                ����sql�쳣
	     */
	    public int executeUpdate() throws SQLException {
	        
	            if (values != null && values.size() > 0) {
	                // ʹ��Ԥ������䣬���趨���е�sql������в���ֵ
	                preparedStatement = (PreparedStatement) connection.prepareStatement(sqlValue);
	                setValues(preparedStatement, values);
	                result = preparedStatement.executeUpdate();
	            } else {
	                // ִ�и���sql��䣬������Ӱ�������
	            	statement = (Statement) connection.createStatement();
	            	result = statement.executeUpdate(sqlValue);
	            }
	        
	        return result;
	    }
	    public void close() {
		
				try {
					if(resultSet != null) {
						resultSet.close();
						//resultSet = null;
					}
					if(statement != null) {
						statement.close();
						statement = null;
					}
					if(preparedStatement != null) {
						preparedStatement.close();
						preparedStatement = null;
					}
					if(connection != null) {
						connection.close();
						connection = null;
					}
				} catch(Exception ex) {
					ex.printStackTrace();
				}
				
		}

}
