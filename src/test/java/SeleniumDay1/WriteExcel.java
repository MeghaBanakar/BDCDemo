package SeleniumDay1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteExcel {
 
	@Test
	  public void writeExcel() throws IOException {
		
		  FileInputStream f=new FileInputStream("C:\\Users\\megha.banakar\\Book1.xlsx");
		  XSSFWorkbook wb=new XSSFWorkbook(f);
		  //to get the first sheet
		  XSSFSheet s1=wb.getSheetAt(0);
		  
		  s1.getRow(0).createCell(2).setCellValue("valid user");
		  s1.getRow(1).createCell(2).setCellValue("valid user");
		  FileOutputStream fos=new FileOutputStream("C:\\Users\\megha.banakar\\Book1.xlsx");
		  wb.write(fos);
		  
	}
}
