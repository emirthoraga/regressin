package regressin.GeneralApiBase;

import org.junit.jupiter.api.BeforeEach;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import regressin.Utils.IconfigBase;

public class regressinBase implements IconfigBase {

     protected   RequestSpecification requestSpecification;

    @BeforeEach
    public void configure(){

        // Configuracion donde se realizaran las consultas 
        //Obtener Base Uri
        RestAssured.baseURI = "https://reqres.in";
           //Armar  el request (caracteristica de la peticion y en viar la peticion)
        requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.accept(ContentType.JSON);
   
    }
    
}
