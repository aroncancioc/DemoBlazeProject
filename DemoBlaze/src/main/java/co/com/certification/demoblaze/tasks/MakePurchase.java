package co.com.certification.demoblaze.tasks;

import co.com.certification.demoblaze.userinterfaces.Cart;
import co.com.certification.demoblaze.utils.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class MakePurchase implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(Cart.ButtonPlaceOrder),
                Enter.theValue(Constants.OrderName).into(Cart.NameOrder),
                Enter.theValue(Constants.Country).into(Cart.Country),
                Enter.theValue(Constants.City).into(Cart.City),
                Enter.theValue(Constants.CreditCard).into(Cart.CreditCard),
                Enter.theValue(Constants.Month).into(Cart.Month),
                Enter.theValue(Constants.Year).into(Cart.Year),
                Click.on(Cart.ButtonPurchase)

        );
    }

    public static MakePurchase makePurchase() {
        return instrumented(MakePurchase.class);
    }
}
