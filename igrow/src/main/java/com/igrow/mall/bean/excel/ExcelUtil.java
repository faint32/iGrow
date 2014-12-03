package com.igrow.mall.bean.excel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.igrow.mall.bean.xls.Exportable;


public final class ExcelUtil {

	//将Workbook写入到InputStream
	 public static void workbook2InputStream(HSSFWorkbook workbook,InputStream excelStream) throws Exception{
	        //this.fileName = fileName; //设置fileName
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        workbook.write(baos); 
	        baos.flush(); 
	        byte[] aa = baos.toByteArray();
	        excelStream = new ByteArrayInputStream(aa, 0, aa.length);
	        baos.close();
	 }
	 
	 
	 /*下面这个方法是将list转换为Excel工作表的*/
	public static HSSFWorkbook getWorkbook(List<Exportable> list) throws Exception{
	  HSSFWorkbook workbook = new HSSFWorkbook(); 
	  HSSFSheet sheet = workbook.createSheet("sheet1");
	  String[] columnNames;
	  String[] columnMethods;
	 
	//首先，我们读取list中的第一个元素，根据它来确定工作表的列名，以及输出数据所对应的方法数组
	  Exportable exp = list.get(0);
	  columnNames = exp.getColumnNames();
	  columnMethods = exp.getColumnMethods();
	   
	  HSSFRow row = sheet.createRow(0); //创建第1行，也就是输出表头
	  HSSFCell cell;
	  for(int i=0;i<columnNames.length;i++){
	   cell = row.createCell(i); //创建第i列
	   cell.setCellValue(new HSSFRichTextString(columnNames[i]));
	  }
	 
	 //下面是输出各行的数据
	  for (int i = 0; i < list.size(); i++) {
	   exp=(Exportable)list.get(i);
	   row=sheet.createRow(i+1);//创建第i+1行
	   for(int j=0;j<columnMethods.length;j++){
	    cell=row.createCell(j);//创建第j列
	    Method method; 
	    method = exp.getClass().getMethod(columnMethods[j]);  //这里用到了反射机制，通过方法名来取得对应方法返回的结果对象
	    Object obj = method.invoke(exp);
	    if(obj != null){
	    	 cell.setCellValue(obj.toString());
	    }else{
	    	cell.setCellValue("");
	    }
	  
	   }
	  }
	  return workbook;
	 }
	
}
