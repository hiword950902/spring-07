package com.neuedu.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.neuedu.util.JdbcUtil;

public class BanjiDao {
	public List<Banji> getBanji(){
		return JdbcUtil.executeQuery("select id,name from banji", new RowMap<Banji>() {

			@Override
			public Banji rowMapping(ResultSet rs) {
				// TODO Auto-generated method stub
				Banji banji=new Banji();
				try {
					banji.setId(rs.getInt("id"));
					banji.setName(rs.getString("name"));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return banji;
			}}, null);
		
	}
}
