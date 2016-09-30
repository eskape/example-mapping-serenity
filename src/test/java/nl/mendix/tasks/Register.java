package nl.mendix.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import nl.mendix.ui.TheMonopolyPage;

public class Register implements Task {

    private final String name;

    protected Register(String name) {
        this.name = name;
    }

    @Step("Registering player #name")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(name)
                     .into(TheMonopolyPage.ADD_USER_FIELD),
                Click.on(TheMonopolyPage.ADD_USER_BUTTON)
        );
    }

    public static Register player(String name) {
        return instrumented(Register.class, name);
    }

}
