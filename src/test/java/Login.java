import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Login {
    @Test
    void login() {
        Configuration.holdBrowserOpen=true;
        //Configuration.browserSize="1920x1080";
        open("http://vstest.labvs.local:8001/models/");
        WebDriverRunner.getWebDriver().manage().window().maximize();
        $(".styles_space__1A-26").shouldHave(text("Authorization"));
        $("[id=username]").setValue("admin");
        $("[id=password]").setValue("admin");
        $("[class=styles_button__309uh]").click();
        $(".title").shouldHave(text("Model list"));

    }
}
