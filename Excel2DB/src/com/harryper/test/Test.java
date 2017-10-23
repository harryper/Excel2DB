package com.harryper.test;

import com.harryper.excel.ExcelRead;
import com.harryper.service.Operate;

public class Test {
	static final String INSERT_SQL = "insert into person_info(`user_id`,`user_name`,`gender`,`age`) values(?,?,?,?)";
	
	
	public static void main(String[] args) {
		ExcelRead er = new ExcelRead();
		new Operate().save(INSERT_SQL, er.getExcelList());
	}
}
