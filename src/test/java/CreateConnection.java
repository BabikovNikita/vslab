import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CreateConnection {
    @Test
    void create_connection()
    {
        Configuration.holdBrowserOpen=true;
        open("http://vstest.labvs.local:8001/models/");
        WebDriverRunner.getWebDriver().manage().window().maximize();
        $(".styles_space__1A-26").shouldHave(text("Authorization"));
        $("[id=username]").setValue("admin");
        $("[id=password]").setValue("admin");
        $("[class=styles_button__309uh]").click();
        SelenideElement TestModel=$(byText("Test model"));
        TestModel.click();
        SelenideElement CreateConnectionBtn=$(".stagesСreation").find(".svg_icon",1);; //кнопка создать подключение
        CreateConnectionBtn.click();
        $("#name").setValue("Test connection"); // ввести имя
        $("#dbTypeSource").selectOption("MS_SQL"); // выбрать БД
        // ввести подключение
        $("#jdbcUrlSource").setValue("jdbc:sqlserver://10.5.10.48:1433;databaseName=devel;useUnicode=true;characterEncoding=UTF-8;encrypt=true;trustServerCertificate=true");
        $("#loginSource").setValue("sa"); // ввести логин
        $("#passwordSource").setValue("P@ssw0rd"); // ввести пароль
        $("#description").setValue("description test"); // ввести description
        SelenideElement ReceiverBtn = $(byText("Receiver"));
        ReceiverBtn.click(); // нажать на кнопку приемник
        $("#dbTypeReceiver").selectOption("MS_SQL"); // выбрать БД
        $("#jdbcUrlReceiver").setValue("jdbc:sqlserver://10.5.10.49:1433;databaseName=devel;useUnicode=true;characterEncoding=UTF-8;encrypt=true;trustServerCertificate=true");
        $("#loginReceiver").setValue("sa"); // ввести логин
        $("#passwordReceiver").setValue("P@ssw0rd"); // ввести пароль
        $(byText("Save")).click(); // нажать сохранить
        $(".mediumStyles_caption__2ndxx").shouldBe(visible).shouldHave(text("Test connection")); // проверяем что модель есть в списке
        $(".list_item_tool").shouldBe(visible); // проверяем видимость кнопок у модели

    }
}
