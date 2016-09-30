package nl.mendix.features.rolling;

import static net.serenitybdd.screenplay.GivenWhenThen.and;
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.GivenWhenThen.then;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static org.hamcrest.Matchers.is;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import nl.mendix.questions.TheTokenPosition;
import nl.mendix.tasks.OpenTheApplication;
import nl.mendix.tasks.Register;
import nl.mendix.tasks.Roll;
import nl.mendix.tasks.StartTheGame;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class RollingDice {

    Actor kishen = Actor.named("Kishen");

    @Managed(uniqueSession = true)
    public WebDriver hisBrowser;

    @Steps
    OpenTheApplication openTheApplication;
    
    @Steps
    StartTheGame startTheGame;
    
    @Before
    public void KishenCanStartPlayingMonopoly() {
        kishen.can(BrowseTheWeb.with(hisBrowser));
    }
    
    @Test
    public void rolling_dice_should_move_player() {
        givenThat(kishen).wasAbleTo(openTheApplication);
        and(kishen).wasAbleTo(Register.player("Jack"));
        and(kishen).wasAbleTo(Register.player("Jill"));
        and(kishen).wasAbleTo(startTheGame);
        
        when(kishen).attemptsTo(Roll.dice("2", "4"));
        
        then(kishen).should(seeThat(TheTokenPosition.of("Jack"), is(6)));
    }
}