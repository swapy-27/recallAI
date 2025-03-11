package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Main {

    private static SeleniumScreenRecorder screenRecorder = new SeleniumScreenRecorder();
    private static WhisperIntegration whisperIntegration = new WhisperIntegration();


    public static void main(String[] args) throws Exception {
        screenRecorder.startRecording("testing");


        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addArguments("--use-fake-ui-for-media-stream");
        options.addArguments("--disable-blink-features=AutomationControlled");



        //Creating webdriver instance
        WebDriver driver= new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Open web application
        driver.get("https://meet.google.com/trd-qgsb-zsm");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //click the got it pop up
        driver.findElement(new By.ByXPath("//span[text()='Got it']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //enter the name
        WebElement nameInput = driver.findElement(new By.ByXPath("//input[@placeholder='Your name']"));
        nameInput.clear();
        nameInput.click();
        nameInput.sendKeys("Meeting Bot");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //click on ask me to join
        driver.findElement(new By.ByXPath("//span[text()='Ask to join']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));



        whisperIntegration.transcriberAudio();

        screenRecorder.stopRecording();


    }
}