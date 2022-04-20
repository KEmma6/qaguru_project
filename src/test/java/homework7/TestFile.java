package homework7;

import TestBase.TestBase;
import homework7.pages.ConvertioPage;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.json.simple.parser.*;
import homework7.pages.TexResourcesPage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestFile extends TestBase {
    ConvertioPage convertioPage = new ConvertioPage();
    String txtFile  = "forTest.txt";
    TexResourcesPage texResourcesPage = new TexResourcesPage();

    @Test
    @DisplayName("Конвертация .txt файла в pdf формат")
    public void testConvertTxtFileToPdf() throws IOException {
        convertioPage
                .openPage();

        convertioPage
                .upLoadFileOnPage(txtFile)
                .checkFileIsLoaded(txtFile)
                .selectPdfFormat()
                .clickConvertButton()
                .downloadConvertingFileAndCheckContent();
    }

    @Test
    @DisplayName("Проверка json файла")
    public void testJsonFile() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object file = parser.parse(new FileReader("src/test/resources/jsonFileForTest.json"));
        JSONObject jsonObject =  (JSONObject) file;
        Assertions.assertFalse(jsonObject.isEmpty());
        Assertions.assertTrue(jsonObject.containsValue("Ivan"));
        Assertions.assertEquals(jsonObject.get("age"), "33");
    }

    @Test
    @DisplayName("Скачивание xls файла и проверка содержимого")
    public void testDownLoadXlsFile() throws FileNotFoundException {
        texResourcesPage
                .openPage();

        String productName = texResourcesPage.getProductName();

        texResourcesPage
                .downloadXlsFileAndXCheck(productName);
    }
}
