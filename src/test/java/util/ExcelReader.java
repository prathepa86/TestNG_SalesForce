package util;

import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public static Object[][] readDataFromExcel(String ExcelFileName) {
		
		Object[][] data=null;
		Object cellValue=null;
		try {
			FileInputStream oFis=new FileInputStream("./data/"+ExcelFileName+".xlsx");
			XSSFWorkbook oWorkbook=new XSSFWorkbook(oFis);
			XSSFSheet oSheet = oWorkbook.getSheetAt(0);
			int lastRowNum = oSheet.getLastRowNum();
			short lastCellNum = oSheet.getRow(0).getLastCellNum();
			data=new Object[lastRowNum][lastCellNum];
			for(int i=1;i<=lastRowNum;i++) {
				XSSFRow oRow = oSheet.getRow(i);
				for(int j=0;j<lastCellNum;j++) {
					XSSFCell oCell = oRow.getCell(j);
					CellType cellType = oCell.getCellType();
					switch (cellType){
					
					case NUMERIC:
						cellValue= oCell.getNumericCellValue();
						break;
					case STRING:
						cellValue=oCell.getStringCellValue();
						break;
					default:
						cellValue=oCell.getErrorCellValue();
						break;
						
					}
					data[i-1][j]=cellValue; 
						
				}
					
				oFis.close();
				oWorkbook.close();
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	
	return data;	 
		
}
}