package nl.mendix.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import nl.mendix.ui.TheMonopolyPage;

public class OpenTheApplication implements Task {
    
    TheMonopolyPage monopolyPage;

    @Step("Open the application")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(monopolyPage)
        );
    }
}
