package homework4.tests;

import TestBase.TestBase;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;

public class TestDragAndDrop extends TestBase {

    @Test
    public void checkDragAndDropSquares() {

        open("https://the-internet.herokuapp.com/drag_and_drop");

        SelenideElement squareA = $("div#column-a"),
                        squareB = $("div#column-b"),
                        titleSquare = $("div#column-a > header");

        Assertions.assertTrue(titleSquare.getText().contains("A"));
        squareA.dragAndDropTo(squareB);
        Assertions.assertTrue(titleSquare.getText().contains("B"));

    }
}

