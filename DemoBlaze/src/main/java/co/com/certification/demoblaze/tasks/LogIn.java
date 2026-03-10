package co.com.certification.demoblaze.tasks;

import co.com.certification.demoblaze.userinterfaces.Home;
import co.com.certification.demoblaze.utils.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LogIn implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        String user = actor.recall("user");
        actor.attemptsTo(
                Click.on(Home.Login),
                Enter.theValue(user).into(Home.NameLogin),
                Enter.theValue(Constants.Password).into(Home.PasswordLogin),
                Click.on(Home.ButtonLogin)
        );
    }

    public static LogIn logIn() {
        return instrumented(LogIn.class);
    }
}
