package my.yandex.market.test.pages.YandexMarket;

import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

@PageEntry(title = "Компьютерная техника")
public class YmComputersPage extends Page {

    @ElementTitle("Ноутбуки")
    @FindBy(linkText = "Ноутбуки")
    public Link notebooksLink;

    @ElementTitle("Планшеты")
    @FindBy(linkText = "Планшеты")
    public Link tabletsLink;

    public YmComputersPage() {
        PageFactory.initElements(
                new HtmlElementDecorator(new HtmlElementLocatorFactory(PageFactory.getDriver())), this);
    }
}