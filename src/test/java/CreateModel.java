import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CreateModel {

    @Test
    void create_model()
    {
        Configuration.holdBrowserOpen=true;
        open("http://vstest.labvs.local:8001/models/");
        WebDriverRunner.getWebDriver().manage().window().maximize();
        $(".styles_space__1A-26").shouldHave(text("Authorization"));
        $("[id=username]").setValue("admin");
        $("[id=password]").setValue("admin");
        $("[class=styles_button__309uh]").click();
        $(".title").shouldHave(text("Model list"));
        SelenideElement CreateModelBtn = $(".stagesСreation").find(".svg_icon",0);
        CreateModelBtn.click();
        $(".styles_label__1oBqn").shouldHave(text("Anonymization Model Name"));
        $("[id=name]").setValue("Test model");
        $("[id=description]").setValue("Description Test model");
        SelenideElement SaveBtn =$(".styles_button__309uh");
        SaveBtn.click();
        $(".list_item_name").shouldHave(text("Test model"));
        $(".list_item_description").shouldHave(text("Description Test model"));

    }
}