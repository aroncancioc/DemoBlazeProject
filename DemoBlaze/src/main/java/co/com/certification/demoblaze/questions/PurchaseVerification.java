package co.com.certification.demoblaze.questions;

import co.com.certification.demoblaze.userinterfaces.Cart;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class PurchaseVerification implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(Cart.SUCCESS_MESSAGE, isVisible()).forNoMoreThan(10).seconds()
        );

        return Cart.SUCCESS_MESSAGE.resolveFor(actor).isCurrentlyVisible();
    }

    public static PurchaseVerification isSuccessful() {
        return new PurchaseVerification();
    }
}
