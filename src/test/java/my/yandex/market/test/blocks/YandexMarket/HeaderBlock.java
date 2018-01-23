package my.yandex.market.test.blocks.YandexMarket;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import my.yandex.market.test.pages.YandexMarket.YmSearchResultsPage;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@Name("Меню поиска")
@FindBy(xpath = "//div[@class='header2__main']")
public class HeaderBlock extends HtmlElement{

    @Name("Строка поиска")
    @FindBy(xpath = ".//input[@id='header-search']")
    public TextInput searchString;

    @Name("Найти")
    @FindBy(xpath = ".//span[text()='Найти']")
    public TextInput searchButton;

    @ActionTitle("выполняет поиск по имени первого товара в списке")
    public void startSearch(){
        searchString.sendKeys(YmSearchResultsPage.firstProductName);
        searchString.sendKeys(Keys.ENTER);
    }
}
