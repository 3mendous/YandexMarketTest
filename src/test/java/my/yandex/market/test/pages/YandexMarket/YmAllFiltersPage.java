package my.yandex.market.test.pages.YandexMarket;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.allurehelper.ParamsHelper;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.sbtqa.tag.pagefactory.exceptions.PageException;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.CheckBox;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

@PageEntry(title = "Все фильтры")
public class YmAllFiltersPage extends Page {

    @ElementTitle("Минимальная цена")
    @FindBy(name = "glf-pricefrom-var")
    public TextInput priceFromInput;

    @ElementTitle("Максимальная цена")
    @FindBy(name = "glf-priceto-var")
    public TextInput priceToInput;

    @ElementTitle("HP")
    @FindBy(xpath = "//label[@for='glf-7893318-152722']")
    public CheckBox hpCheckBox;

    @ElementTitle("Lenovo")
    @FindBy(xpath = "//label[@for='glf-7893318-152981']")
    public CheckBox lenovoCheckBox;

    @ElementTitle("Acer")
    @FindBy(xpath = "//label[@for='glf-7893318-267101']")
    public CheckBox acerCheckBox;

    @ElementTitle("DELL")
    @FindBy(xpath = "//label[@for='glf-7893318-153080']")
    public CheckBox dellCheckBox;

    @ElementTitle("Показать всё")
    @FindBy(xpath = "//div[@data-filter-id='7893318']/descendant::button")
    public Button showAllManufacturersButton;

    @ElementTitle("Показать подходящие")
    @FindBy(linkText = "Показать подходящие")
    public Button showEligibleButton;

    public YmAllFiltersPage() {
        PageFactory.initElements(
                new HtmlElementDecorator(new HtmlElementLocatorFactory(PageFactory.getDriver())), this);
    }

    @ActionTitle("скроллит до производителя")
    public void scrollToManufacturer(String elementTitle) throws PageException {
        ((JavascriptExecutor)PageFactory.getDriver()).executeScript("arguments[0].focus();", this.getElementByTitle(elementTitle));
        ParamsHelper.addParam("'Скролл до элемента %s'", new String[]{elementTitle});
    }
}