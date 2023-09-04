package testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelsheet {

	public static Workbook book;
	
	public static org.apache.poi.ss.usermodel.Sheet sheet;
	public static Object[][] readexcel(String Sheetname)
	{
		FileInputStream file=null;
		try
		{
			file=new FileInputStream("C:\\Users\\Shalini\\HRManagement\\src\\test\\java\\testdata\\Details.xlsx");
			
		}
		catch(FileNotFoundException fe)
		{
			fe.printStackTrace();
		}
		try {
		book=WorkbookFactory.create(file);
		}
		catch(IOException ie)
		{
			ie.printStackTrace();
		}
		
		sheet=book.getSheet(Sheetname);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				
			}
		}
		
		return data;
	}
}
