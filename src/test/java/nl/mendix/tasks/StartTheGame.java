package nl.mendix.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import nl.mendix.ui.TheMonopolyPage;

public class StartTheGame implements Task {
    
    TheMonopolyPage monopolyPage;
    
    @Step("Start the game")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(TheMonopolyPage.START_GAME)
        );
    }
}
