package com.pretty.utils;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;

@UtilityClass
public class PLTUtil {

    public static Wait<WebDriver> wait;

    public static String stripProductSize(String productSize) {
        return productSize.substring(productSize.indexOf(":")+1).strip();
    }

    public static void setWait(WebDriver driver) {
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(21))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(Exception.class);
    }

    public static void waitForVisibilityOf(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForInvisibilityOf(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitForVisibilityOfAll(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
}
