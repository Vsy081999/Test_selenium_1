package Data_Provider;

import java.io.File;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC001 {

	@Test(dataProvider = "logindata")
	public void readtestdata(String username, String password) {
		System.out.println(username + " " + password);
		System.out.println(username + " " + password);
	}

	@DataProvider(name = "logindata")
	public Object[][] readdata() throws InvalidFormatException, IOException {
		Object[][] data = readexceldata("Sheet1");
		return data;
	}

	public static Object[][] readexceldata(String Sheetname) throws InvalidFormatException, IOException {

		File file = new File("C:\\Users\\Vsy08\\eclipse-workspace\\DataProviderDemo\\testdata2\\Testdata.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet excelsheet = wb.getSheet(Sheetname);
		int ttlrows = excelsheet.getLastRowNum();
		int ttlcells = excelsheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[ttlrows][ttlcells];
		for (int currentrow = 0; currentrow < ttlrows; currentrow++) {
			for (int currentcell = 0; currentcell < ttlcells; currentcell++) {
				data[currentrow][currentcell] = excelsheet.getRow(currentrow + 1).getCell(currentcell).toString();
			}
		}
		return data;
	}
}
