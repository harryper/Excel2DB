package com.harryper.service;

import java.util.Iterator;
import java.util.List;

import com.harryper.domain.PersonInfo;
import com.harryper.util.DBUtil;

public class Operate {
	/**
	 * 执行语句
	 * @param sql  sql语句
	 * @param list  读取的用户列表
	 */
	public void save(String sql, List<PersonInfo> list) {
		Iterator<PersonInfo> it = list.iterator();
		while(it.hasNext()) {
			PersonInfo p = it.next();
			DBUtil.executeUpdate(sql, new Object[] {p.getUser_id(), p.getUser_name(), p.getGender(), p.getAge()});
		}
	}
}
