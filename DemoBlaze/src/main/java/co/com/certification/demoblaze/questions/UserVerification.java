package co.com.certification.demoblaze.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.certification.demoblaze.userinterfaces.Home.UserLoggedIn;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class UserVerification implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        String user = actor.recall("user");

        actor.attemptsTo(
                WaitUntil.the(UserLoggedIn, isVisible()).forNoMoreThan(10).seconds()
        );

        String textVisible = UserLoggedIn.resolveFor(actor).getText().trim();

        return textVisible.contains("Welcome " + user);
    }

    public static UserVerification isSuccessful() {
        return new UserVerification();
    }
}