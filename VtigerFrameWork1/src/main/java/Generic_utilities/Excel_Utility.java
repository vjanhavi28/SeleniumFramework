package Generic_utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility 
{
	/**
	 * this method is used to fetch data from excel
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws Throwable
	 * @author Vaishnavi Macharde 
	 */
	public String getExcelData(String sheetname,int rownum,int cellnum) throws Throwable
	{
	FileInputStream fise=new FileInputStream("src/test/resources/ExcelData.xlsx");
    Workbook book=WorkbookFactory.create(fise);
    //1st way
	Sheet sheet=book.getSheet(sheetname);
	Row row = sheet.getRow(rownum);
	Cell cell = row.getCell(cellnum);
	String value = cell.getStringCellValue();
	return value;
	}
    //2nd way
    /*DataFormatter dm=new DataFormatter();
    String Data = dm.formatCellValue(book.getSheet(sheetname).getRow(rownum).getCell(cellnum));
	return Data;*/
	
	/**
	 * Fetching data from excel by using DataFormatter
	 * @param sheetname1
	 * @param rownum1
	 * @param cellnum1
	 * @return
	 * @throws Throwable
	 * @author Vaishnavi Macharde
	 */
	//OR we can write inside method also
	public String getExcelDataByUsingDataFormatter(String sheetname1,int rownum1,int cellnum1)throws Throwable
	{
		FileInputStream fise1=new FileInputStream("src/test/resources/ExcelData.xlsx");
	    Workbook book1=WorkbookFactory.create(fise1);
	    
	    DataFormatter dm=new DataFormatter();
	    String Data = dm.formatCellValue(book1.getSheet(sheetname1).getRow(rownum1).getCell(cellnum1));
		return Data;
	}
	
	}
	
	

