import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage
{
    @Test
    void check_home_page()
    {
        Configuration.holdBrowserOpen=true;
        open("http://vstest.labvs.local:8001/models/");
        WebDriverRunner.getWebDriver().manage().window().maximize();
        $(".styles_space__1A-26").shouldHave(text("Authorization"));
        $("[id=username]").setValue("admin");
        $("[id=password]").setValue("admin");
        $("[class=styles_button__309uh]").click();
        $(".title").shouldHave(text("Model list"));
        SelenideElement ModelsImpotrBtn=$(".header").find(".menu_item",0).shouldBe(visible); //проверка отображения кнопки импорта модели
        SelenideElement SettingsBtn=$(".header").find(".menu_item",1).shouldBe(visible); //проверка отображения кнопки настроек
        SelenideElement HomeBtn=$(".header").find(".menu_item",2).shouldBe(visible); //проверка отображения кнопки домой
        SelenideElement HelpBtn=$(".header").find(".menu_item",3).shouldBe(visible); //проверка отображения кнопки help
        SelenideElement ThemeBtn=$(".header").find(".menu_item",4).shouldBe(visible); //проверка отображения кнопки смена темы
        SelenideElement ExitBtn=$(".header").find(".menu_item",5).shouldBe(visible); //проверка отображения кнопки выход

        //проверка кнопок блока меню

        SelenideElement CreateModelBtn=$(".stagesСreation").find(".svg_icon",0).shouldBe(visible);; //проверка отображения кнопки создать модель
        SelenideElement CreateConnectionBtn=$(".stagesСreation").find(".svg_icon",1).shouldBe(visible);; //проверка отображения кнопки создать подключение
        SelenideElement AnalyzeBtn=$(".stagesСreation").find(".svg_icon",2).shouldBe(visible);; //проверка отображения кнопки анализ данных
        SelenideElement DepersonalBtn=$(".stagesСreation").find(".svg_icon",3).shouldBe(visible);; //проверка отображения кнопки обезличить данные




    }
}
