package day9_JsonCreate;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.JSONArray;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ExcelToJson {

    @Test
    public void runner()
    {
        // Input Excel file path and Output JSON file path
        String inputexl="src/main/inputs/input.xlsx";
        String jsonFilePath="src/main/inputs/json/output.json";
       try {
           JSONArray jsonArray = readExcelToJson(inputexl);
           writeJSonToFile(jsonArray, jsonFilePath);
       } catch (Exception e) {
           e.printStackTrace();
       }

    }

    private void writeJSonToFile(JSONArray jsonArray, String jsonFilePath) {


    }

    private JSONArray readExcelToJson(String excelFilePath) throws IOException {
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.rowIterator();

        Row headerRow= rowIterator.next();
        int columncount=headerRow.getPhysicalNumberOfCells();

        JSONArray jsonArray = new JSONArray();
        return  jsonArray;



    }

}
