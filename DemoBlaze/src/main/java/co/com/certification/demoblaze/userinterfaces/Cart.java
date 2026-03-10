package co.com.certification.demoblaze.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Cart {

    public static final Target FirstProduct = Target.the("ADD FIRST PRODUCT").locatedBy("(//div[@class=\"col-lg-4 col-md-6 mb-4\"])[1]");
    public static final Target SecondProduct = Target.the("ADD SECOND PRODUCT").locatedBy("(//div[@class=\"col-lg-4 col-md-6 mb-4\"])[2]");
    public static final Target ButtonAddToCart = Target.the("ADD TO CART").locatedBy("//a[contains(text(),'Add to cart')]");
    public static final Target ClickCart = Target.the("CLICK CART").located(By.id("cartur"));


    public static final Target ButtonPlaceOrder = Target.the("CLICK BUTTON PLACE ORDER").locatedBy("//button[@class=\"btn btn-success\"]");
    public static final Target ButtonPurchase = Target.the("CLICK BUTTON PURCHASE").locatedBy("//button[@onclick=\"purchaseOrder()\"]");
    public static final Target ButtonOK = Target.the("CLICK BUTTON OK").locatedBy("//button[@class=\"confirm btn btn-lg btn-primary\"]");
    public static final Target NameOrder = Target.the("NAME").located(By.id("name"));
    public static final Target Country = Target.the("COUNTRY NAME").located(By.id("country"));
    public static final Target City = Target.the("CITY NAME").located(By.id("city"));
    public static final Target CreditCard = Target.the("CREDIT CARD NUMBER").located(By.id("card"));
    public static final Target Month = Target.the("MONTH").located(By.id("month"));
    public static final Target Year = Target.the("YEAR").located(By.id("year"));
    public static final Target SUCCESS_MESSAGE = Target.the("SUCCESS MESSAGE").located(By.xpath("//h2[contains(text(),'Thank you for your purchase!')]"));
}
