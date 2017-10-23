package com.harryper.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.harryper.domain.PersonInfo;

public class ExcelRead {
	public List<PersonInfo> getExcelList() {
		List<PersonInfo> list = new ArrayList<PersonInfo>();
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		XSSFRow row = null;
		PersonInfo p = null;
		File file = new File("e:\\person_info.xlsx");	//excel存放的位置
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheetAt(0);
		//每一行的迭代器
		Iterator<Row> rowIterator = sheet.iterator();
		rowIterator.next();	//跳过 excel 表格的列名行
		while(rowIterator.hasNext()) {
			row = (XSSFRow) rowIterator.next();
			p = new PersonInfo();
			
			Cell user_id = row.getCell(0);
			Cell user_name = row.getCell(1);
			Cell gender = row.getCell(2);
			Cell age = row.getCell(3);
			
			p.setUser_id(((Double)getValue(user_id)).intValue());
			p.setUser_name((String)getValue(user_name));
			p.setGender((String)getValue(gender));
			p.setAge(((Double)getValue(age)).intValue());
			
			list.add(p);
		}
		
		//关闭资源
		try {
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings("static-access")
	/**
	 * 根据excel中不同的元素类型来接收
	 * @param cell 列元素
	 * @return 返回值
	 * 
	 * ps: Cell 文档地址 http://poi.apache.org/apidocs/org/apache/poi/ss/usermodel/Cell.html
	 */
	private Object getValue(Cell cell) {
		if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			return cell.getNumericCellValue();
		} else {
			return cell.getStringCellValue();
		}
	}
}