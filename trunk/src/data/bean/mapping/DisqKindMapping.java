package data.bean.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import data.bean.DisqKind;

public class DisqKindMapping extends BasicMapping<DisqKind> {

	public DisqKind mapping(ResultSet rs) {

		DisqKind disqKind = new DisqKind();
		try {
			disqKind.setDeleteTime(rs.getDate("deleteTime"));
			disqKind.setDisDesc(rs.getString("disDesc"));
			disqKind.setId(rs.getInt("Id"));
			disqKind.setIsDelete(rs.getInt("isDelete"));
			disqKind.setKind(rs.getInt("kind"));
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return disqKind;
	}

}
