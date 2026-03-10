package co.com.certification.demoblaze.tasks;

import co.com.certification.demoblaze.userinterfaces.Cart;
import co.com.certification.demoblaze.userinterfaces.Home;
import co.com.certification.demoblaze.utils.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static co.com.certification.demoblaze.userinterfaces.Home.UserLoggedIn;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LogInCart implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(Home.Login),
                Enter.theValue(Constants.Name).into(Home.NameLogin),
                Enter.theValue(Constants.Password).into(Home.PasswordLogin),
                Click.on(Home.ButtonLogin),
                WaitUntil.the(UserLoggedIn, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(Cart.FirstProduct),
                Click.on(Cart.ButtonAddToCart),
                WaitUntil.the(ExpectedConditions.alertIsPresent()),
                Switch.toAlert().andAccept(),
                Click.on(Home.Index),
                WaitUntil.the(UserLoggedIn, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(Cart.SecondProduct),
                Click.on(Cart.ButtonAddToCart),
                WaitUntil.the(ExpectedConditions.alertIsPresent()),
                Switch.toAlert().andAccept(),
                Click.on(Cart.ClickCart)
        );
    }


    public static LogInCart logInCart() {
        return instrumented(LogInCart.class);
    }
}
