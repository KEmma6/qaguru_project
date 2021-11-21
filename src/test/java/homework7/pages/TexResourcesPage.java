package homework7.pages;

import com.codeborne.xlstest.XLS;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TexResourcesPage {

    private SelenideElement
            downloadLink = $x("//strong[contains(., 'Скачать')]/parent::a"),
            textTitle = $("h1");

    public void openPage() {
        sleep(3000);
        open("https://ckmt.ru/price-download.html");
    }

    public String getProductName() {
        return (textTitle.getText()).split("\\.")[0];
    }

    public TexResourcesPage downloadXlsFileAndXCheck(String productName) throws FileNotFoundException {
        File xlsFile = downloadLink.download();
        XLS parsedXls = new XLS(xlsFile);
        String cellValue = parsedXls.excel.getSheetAt(0).getRow(0).getCell(3)
                .getStringCellValue().toLowerCase(Locale.ROOT);
        assertTrue(cellValue.contains(productName.toLowerCase(Locale.ROOT)));
        return this;
    }
}
