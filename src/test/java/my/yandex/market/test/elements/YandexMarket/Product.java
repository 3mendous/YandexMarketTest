package my.yandex.market.test.elements.YandexMarket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

public class Product extends TypifiedElement {

    private String nameXpath = "//div[@class='n-snippet-card2__title']/a";

    public Product(WebElement wrappedElement) {
        super(wrappedElement);
    }

    public String getProductName(){
        String name = getWrappedElement()
                .findElement(By.xpath(nameXpath))
                .getText();
        return name;
    }
}
