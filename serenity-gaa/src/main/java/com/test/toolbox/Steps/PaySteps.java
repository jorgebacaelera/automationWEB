package com.test.toolbox.Steps;

import com.test.toolbox.StepsDefinitions.PayStepDefinition;
import com.test.toolbox.Util.Util;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import java.util.concurrent.TimeUnit;
import com.test.toolbox.Page.ElementsPage;
import org.openqa.selenium.Alert;

import static com.test.toolbox.Page.ElementsPage.*;
import static com.test.toolbox.StepsDefinitions.PayStepDefinition.emailAdress;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PaySteps extends PageObject {

    ElementsPage elementsPage;
    public static int priceProducto1;
    public static int priceProducto2;
    public static int expectResult;
    public static int sumTotalPrice;
    public static int amount;
    public static String fullname="";
    public static String companyName="Auna Clinicas";
    public static String phone="921447908";

    @Step ("Ingresa a la web de prueba")
    public void openWeb() {
        setDefaultBaseUrl("https://www.demoblaze.com/");
        open();
        getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        Serenity.takeScreenshot();

    }


    @Step ("Registra al usuario")
    public void registryUser(String email, String password){
        Util.waitFor(5);
        (getDriver().findElement(By.id(ElementsPage.butonRegister))).click();
        Util.waitFor(2);
        (getDriver().findElement(By.id(ElementsPage.user))).sendKeys(email);
        (getDriver().findElement(By.id(ElementsPage.password))).sendKeys(password);
        (getDriver().findElement(By.xpath(buttonRegistry))).click();
        Util.waitFor(5);
       Alert alert = getDriver().switchTo().alert();
        // Accepting alert
        alert.accept();

    }

    @Step ("Login con el usuario creado")
    public void loginUser(String user, String password){
        Util.waitFor(2);
        (getDriver().findElement(By.id(buttonLogin))).click();
        (getDriver().findElement(By.id(loginusername))).sendKeys(user);
        Util.waitFor(2);
        (getDriver().findElement(By.id(loginpassword))).sendKeys(password);
        Serenity.takeScreenshot();
        (getDriver().findElement(By.xpath(buttonConfirmLogin))).click();
        Util.waitFor(2);

    }

    @Step ("Verificando nombre del usuario en el sistema")
    public void verifyUser(){
        Util.waitFor(4);
        Serenity.takeScreenshot();
        fullname=(getDriver().findElement(By.id(nameofuser))).getText();
        Serenity.takeScreenshot();
        assertThat(fullname, equalTo("Welcome "+emailAdress));

    }
    @Step("Seleccionando el Producto")
    public void selectProduct(String product)
    {
        Util.waitFor(5);
        (getDriver().findElement(By.linkText(product))).click();
        Util.waitFor(3);
        (getDriver().findElement(By.linkText(buttonAddToCard))).click();
        Util.waitFor(5);
        Alert alert = getDriver().switchTo().alert(); // Accepting alert
        alert.accept();
        Util.waitFor(5);
    }

    public void returnHome(){
        Serenity.takeScreenshot();

        (getDriver().findElement(By.xpath(returnHome))).click();
    }

    public void clickCart(){

        (getDriver().findElement(By.linkText(Cart))).click();
        Util.waitFor(2);
        Serenity.takeScreenshot();
    }

    @Step("Verificando los precios ingresados vs los precios recibidos desde la web")
    public void confirmBuy(){

        expectResult = Integer.parseInt((getDriver().findElement(By.id(totalSales))).getText());
        priceProducto1 = Integer.parseInt((getDriver().findElement(By.xpath(priceOne))).getText());
        priceProducto2 = Integer.parseInt((getDriver().findElement(By.xpath(priceTwo))).getText());
        sumTotalPrice = priceProducto1 + priceProducto2;
        assertThat(sumTotalPrice, equalTo(expectResult));
        Util.waitFor(2);
        (getDriver().findElement(By.xpath(buttonConfirm))).click();
        Util.waitFor(5);
    }
    @Step("Ingresamos los datos requeridos del pago con tarjeta")
    public void insertAddress(){
        (getDriver().findElement(By.id(name))).click();
        (getDriver().findElement(By.id(name))).sendKeys("Jorge");
        (getDriver().findElement(By.xpath(country))).click();
        (getDriver().findElement(By.xpath(country))).sendKeys("Perú");
        (getDriver().findElement(By.xpath(city))).click();
        (getDriver().findElement(By.xpath(city))).sendKeys("Lima");
        (getDriver().findElement(By.xpath(card))).click();
        (getDriver().findElement(By.xpath(card))).sendKeys("45557888899996600");
        (getDriver().findElement(By.xpath(month))).click();
        (getDriver().findElement(By.xpath(month))).sendKeys("11");
        (getDriver().findElement(By.xpath(year))).click();
        (getDriver().findElement(By.xpath(year))).sendKeys("2026");
        Serenity.takeScreenshot();
        (getDriver().findElement(By.xpath(buttonOk))).click();
        Util.waitFor(5);

    }


    @Step("Verificando el mensaje de compra con éxito")
    public void verifyDetails(){

        Util.waitFor(5);
        String mensajeFinal=(getDriver().findElement(By.xpath(finishMessage))).getText();
        assertThat(mensajeFinal, equalTo("Thank you for your purchase!"));
        Serenity.takeScreenshot();
        (getDriver().findElement(By.xpath(buttonFinish))).click();
    }



}