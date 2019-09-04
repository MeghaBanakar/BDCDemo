package SeleniumDay1;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Demo {
	public static Object[][] readData()  throws IOException{
		
		 FileInputStream f=new FileInputStream("C:\\Users\\megha.banakar\\reg.xlsx");
		  XSSFWorkbook wb=new XSSFWorkbook(f);
		  XSSFSheet s1=wb.getSheetAt(0);
		  int rowCount=s1.getPhysicalNumberOfRows();
		  XSSFRow r1=s1.getRow(0);
		  int colCount=r1.getPhysicalNumberOfCells();
		  
		  Object[][] data=new Object[rowCount][colCount];
		  for(int i=0;i<rowCount;i++) {
			  for(int j=0;j<colCount;j++) {
				  if(j==7 || j==9 || j==10) {
					     data[i][j]=Long.toString((long)s1.getRow(i).getCell(j).getNumericCellValue());
					    }
					    else {
					     data[i][j]=s1.getRow(i).getCell(j).getStringCellValue();
					    }
			  }
		  }
		  return data;
	}

}
