import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AlfabankArhiveDepositsTests {
    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void checkShouldHaveFiveArhiveDeposits() {
        open("http://alfabank.ru");
        $(byText("Вклады")).shouldHave(text("Вклады"));

        $(byText("Вклады")).click();

        $$(byText("Архивные счета и депозиты")).find(visible).parent().click();
        sleep(500);//без слипа не прокликивается, я хз почему

        $$(byText("Депозиты")).find(visible).parent().click();
        //assert 5-ти депозитов
        $("#filter").$$("[data-widget-name=CatalogCard]").shouldHaveSize(5);
        //"[data-widget-name='Catalog.Card']" - если в значении атрибута точка, то можно взять в одинарные кавычки.
    }
}