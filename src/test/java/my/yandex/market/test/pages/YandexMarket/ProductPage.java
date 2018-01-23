package my.yandex.market.test.pages.YandexMarket;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.allurehelper.ParamsHelper;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

@PageEntry(title = "Страница товара")
public class ProductPage extends Page {

    String savedProductName = YmSearchResultsPage.firstProductName;

    @ElementTitle("Название товара")
    @FindBy(className = "n-title__text")
    public WebElement productNameElement;

    public ProductPage() {
        PageFactory.initElements(
                new HtmlElementDecorator(new HtmlElementLocatorFactory(PageFactory.getDriver())), this);
    }

    @ActionTitle("проверяет, что название найденного товара совпадает с запомненным")
    public void checkValue() {
        String productName = productNameElement.getText();
        Assert.assertEquals("Название найденного товара (" + productName + ") не совпадает с запомненным (" + savedProductName + ")",
                savedProductName, productName);
        ParamsHelper.addParam("'Название найденного товара %s совпадает с запомненным %s'", new String[]{productName, savedProductName});
    }
}