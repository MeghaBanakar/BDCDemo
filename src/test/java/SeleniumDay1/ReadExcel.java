package SeleniumDay1;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {
  @Test
  public void testExcel() throws IOException {
	  FileInputStream f=new FileInputStream("C:\\Users\\megha.banakar\\Book1.xlsx");
	  
	  XSSFWorkbook wb=new XSSFWorkbook(f);
	  //to get the first sheet
	  XSSFSheet s1=wb.getSheetAt(0);
	  
	  int rowCount=s1.getPhysicalNumberOfRows();
	  XSSFRow r1=s1.getRow(0);
	  int colCount=r1.getPhysicalNumberOfCells();
	  
	  for(int i=0;i<rowCount;i++) {
		  for(int j=0;j<colCount;j++) {
			  String value = s1.getRow(i).getCell(j).getStringCellValue();
	  		System.out.println(value);
		  }
	  }
  }
}
