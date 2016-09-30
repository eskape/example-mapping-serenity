package nl.mendix.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import org.openqa.selenium.By;

public class TheTokenPosition implements Question<Integer> {
    
    private String name;
    
    public TheTokenPosition(String name) {
        this.name = name;
    }
    
    @Override
    public Integer answeredBy(Actor actor) {
        String squareText = BrowseTheWeb.as(actor).find(By.xpath("//div[@rel='" + name + "']/..")).getAttribute("id");
        return Integer.parseInt(squareText.replace("square", ""));
    }
    
    public static Question<Integer> of(String name) {
        return new TheTokenPosition(name);
    }
}
