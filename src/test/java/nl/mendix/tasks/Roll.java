package nl.mendix.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import nl.mendix.ui.TheMonopolyPage;

public class Roll implements Task {

    private final String diceOne;
    private final String diceTwo;

    protected Roll(String diceOne, String diceTwo) {
        this.diceOne = diceOne;
        this.diceTwo = diceTwo;
    }

    @Step("Rolling #diceOne and #diceTwo")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(diceOne)
                     .into(TheMonopolyPage.DICE_ONE_FIELD),
                 Enter.theValue(diceTwo)
                     .into(TheMonopolyPage.DICE_TWO_FIELD),     
                Click.on(TheMonopolyPage.ROLL_BUTTON)
        );
    }

    public static Roll dice(String diceOne, String diceTwo) {
        return instrumented(Roll.class, diceOne, diceTwo);
    }

}
