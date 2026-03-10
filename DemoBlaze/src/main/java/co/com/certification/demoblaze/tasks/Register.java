package co.com.certification.demoblaze.tasks;

import co.com.certification.demoblaze.userinterfaces.Home;
import co.com.certification.demoblaze.utils.Constants;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Random;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Register implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        int value = new Random().nextInt(10000 + 1) + 1;
        actor.attemptsTo(
                Click.on(Home.SignUp),
                Enter.theValue(Constants.Name + value).into(Home.NameRegister),
                Enter.theValue(Constants.Password).into(Home.PasswordRegister),
                Click.on(Home.ButtonRegister),
                WaitUntil.the(ExpectedConditions.alertIsPresent()),
                Switch.toAlert().andAccept()
        );
        actor.remember("user", Constants.Name + value);
    }

    public static Register register() {
        return instrumented(Register.class);
    }
}
