package nl.mendix.ui;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://localhost:8080")
public class TheMonopolyPage extends PageObject {

    public static Target ADD_USER_FIELD = Target.the("Add user field").located(By.name("name"));
    
    public static Target ADD_USER_BUTTON = Target.the("Add user button").located(By.name("addplayer"));
    
    public static Target START_GAME = Target.the("Start game button").located(By.name("startgame"));
    
    public static Target DICE_ONE_FIELD = Target.the("First dice field").located(By.name("d1"));
    
    public static Target DICE_TWO_FIELD = Target.the("Second dice field").located(By.name("d2"));
    
    public static Target ROLL_BUTTON = Target.the("Roll button").located(By.name("roll"));
}
