package co.com.certification.demoblaze.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Home {
    public static final Target Index = Target.the("HOME").locatedBy("//a[contains(text(),'Home')]");

    public static final Target SignUp = Target.the("SIGN UP").located(By.id("signin2"));
    public static final Target NameRegister = Target.the("NAME REGISTER").located(By.id("sign-username"));
    public static final Target PasswordRegister = Target.the("PASSWORD REGISTER").located(By.id("sign-password"));
    public static final Target ButtonRegister = Target.the("BUTTON REGISTER").locatedBy("//button[@onclick=\"register()\"]");


    public static final Target Login = Target.the("LOGIN").located(By.id("login2"));
    public static final Target NameLogin = Target.the("NAME LOGIN").located(By.id("loginusername"));
    public static final Target PasswordLogin = Target.the("PASSWORD LOGIN").located(By.id("loginpassword"));
    public static final Target ButtonLogin = Target.the("BUTTON LOGIN").locatedBy("//button[@onclick=\"logIn()\"]");
    public static final Target UserLoggedIn = Target.the("USER LOGGED IN").located(By.id("nameofuser"));


}
