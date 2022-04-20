package homework7.pages;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Assertions;
import java.io.File;
import java.io.IOException;
import static com.codeborne.selenide.Selenide.*;


public class ConvertioPage {

    private String uploadFile = "#pc-upload-add";
    private String fileName = ".dt-file-name-inner";
    private String formatSelect = ".dropdown button";
    private String tabDocuments = "//div[contains(@class, 'show')]/*//li[contains(text(), 'Документ')]";
    private String formatPdf = "//div[contains(@class, 'scroll-scrolly_visible')]/*//span[contains(text(), 'PDF')]";
    private String convertButton = ".convert-button";

    public void openPage() {
        open("https://convertio.co/ru/");
    }

    public ConvertioPage upLoadFileOnPage(String filePath) {
        $(uploadFile).uploadFromClasspath(filePath);
        return this;
    }

    public ConvertioPage checkFileIsLoaded(String txtFileName) {
        String textFileNameOnPage = $(fileName).getText();
        Assertions.assertEquals(textFileNameOnPage, txtFileName);
        return this;
    }

    public ConvertioPage selectPdfFormat() {
        $(formatSelect).click();
        $x(tabDocuments).click();
        $x(formatPdf).click();
        return this;
    }

    public ConvertioPage clickConvertButton() {
        $(convertButton).click();
        return this;
    }

    public ConvertioPage downloadConvertingFileAndCheckContent() throws IOException {
        sleep(3000);
        File filePdf = $x("//a[contains(@class, ' btn-blue')]").download();
        PDF parsedPdf = new PDF(filePdf);
        Assertions.assertEquals("Текст для теста", parsedPdf.text);
        return this;
    }
}
