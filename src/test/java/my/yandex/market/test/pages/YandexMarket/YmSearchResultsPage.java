package my.yandex.market.test.pages.YandexMarket;

import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.allurehelper.ParamsHelper;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ActionTitle;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;
import my.yandex.market.test.blocks.YandexMarket.HeaderBlock;
import my.yandex.market.test.elements.YandexMarket.Product;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;
import java.util.List;

@PageEntry(title = "Результаты поиска товаров")
public class YmSearchResultsPage extends Page {

    public static String firstProductName;

    @ElementTitle("Меню поиска")
    public HeaderBlock headerBlock;

    @ElementTitle("Список товаров")
    @FindBy(className = "n-snippet-card2__title")
    private List<Product> products;

    public YmSearchResultsPage(){
        PageFactory.initElements(
                new HtmlElementDecorator(new HtmlElementLocatorFactory(PageFactory.getDriver())), this);
    }

    @ActionTitle("проверяет, что количество товаров на странице")
    public void countProducts(String numberOfProducts){
        int productsListSize = products.size();
        Assert.assertEquals("Количество товаров на странице (" + productsListSize +  ") не равно заданному (" + numberOfProducts +")",
                Integer.valueOf(numberOfProducts), (Integer) productsListSize);
        ParamsHelper.addParam("'Количество товаров на странице %s равно заданному %s'", new String[]{String.valueOf(productsListSize), numberOfProducts});
    }

    @ActionTitle("сохраняет название первого товара в списке")
    public void saveFirstProductName(){
        firstProductName = products.get(0).getProductName().replace("Планшет ", "");
        ParamsHelper.addParam("'Название первого товара \"%s\" сохранено'", new String[]{firstProductName});
    }

}
