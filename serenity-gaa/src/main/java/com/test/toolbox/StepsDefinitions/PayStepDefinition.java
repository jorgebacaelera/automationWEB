package com.test.toolbox.StepsDefinitions;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import com.test.toolbox.Steps.PaySteps;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.thucydides.core.annotations.Steps;

public class PayStepDefinition {
public static String emailAdress="";

    @Steps
    PaySteps paySteps;


    @Dado("que el cliente accede a la web de DemoBlaze")
    public void loginAP(){
        paySteps.openWeb();

    }

    @Y("el cliente decide registrarse como usuario indicando su user (.*) y password (.*)")
    public void registryEmail(String user, String password){
        emailAdress=user;
        paySteps.registryUser(user,password);
        paySteps.loginUser(user,password);
    }



    @Y("el cliente accede de forma automática a la web de compras")
    public void verifyAccount(){
        paySteps.verifyUser();
    }

    @Y("el cliente decide selecciona el segundo producto (.*)")
    public void selectProduct2(String product){
        paySteps.selectProduct(product);
        paySteps.clickCart();

    }

    @Cuando ("el cliente decide seleccionar el segundo producto (.*)")
    public void selectProducts(String product2){
        paySteps.selectProduct(product2);
        paySteps.returnHome();

    }


    @Y("el cliente confirma la totalidad de productos a comprar")
    public void confirmBuy(){
        paySteps.confirmBuy();
        paySteps.insertAddress();
    }

    @Entonces("deberá visualizar el mensaje de éxito de compra")
    public void verifySuscriptionCancelled(){
        paySteps.verifyDetails();

    }

}
