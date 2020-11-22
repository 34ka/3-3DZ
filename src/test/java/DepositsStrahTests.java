import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DepositsStrahTests {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void checkButtonDepositsStrahFourPractics() {
        open("http://alfabank.ru");
        $(byText("Вклады")).shouldHave(text("Вклады"));

        $(byText("Вклады")).click();

        //click parent
        $$(byText("Страхование вкладов")).find(visible).parent().click();
        //assert
        $(byText("Альфа-Банк является участником системы обязательного страхования вкладов")).shouldBe(visible);

        //click sibling
        $("[data-test-id=tabs-list-tabTitle-0]").sibling(0).click();
        //assert
        $(byText("Альфа-Банк является участником системы обязательного страхования вкладов")).shouldBe(visible);
        sleep(500);

        //click preceding
        $("[data-test-id=tabs-list-tabTitle-2]").preceding(0).click();
        //assert
        $(byText("Альфа-Банк является участником системы обязательного страхования вкладов")).shouldBe(visible);

        //click closest
        $(byText("Страхование вкладов")).closest("button").click();
        //assert
        $(byText("Альфа-Банк является участником системы обязательного страхования вкладов")).shouldBe(visible);
    }
}