package regressin.User;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class UserQuestion {

    public static void validatestatuscode(Response response, Integer statuscodeExpected) {
        assertEquals(
            statuscodeExpected,
            response.statusCode(),
            "validacion de la consulta"
        );
    } 

    public static void Emailcheck(Response response, String emailExpected) {
        String emailActual = response.jsonPath().getString("data.email");
        assertEquals(emailExpected, emailActual, "El correo es igual");
    }

        public static void NofoundUser404(Response response, Integer statuscodeExpected) {
            assertEquals(
                statuscodeExpected,
                response.statusCode(),
                "Usuario no encontrado"
            );
        } 

        public static void ValideateCreated(Response response, Integer statuscodeExpected) {
            assertEquals(
                statuscodeExpected,
                response.statusCode(),
                "Usuario Creado"
            );
        } 

        public static void validatejsonschema(Response response) {
            JsonSchemaValidator jsv = 
            JsonSchemaValidator.matchesJsonSchemaInClasspath("Regressin/UserJsonSchema.json");
            
            
            assertTrue
            ("Validacion de Json Schema para Creacion de usuarios ",jsv.matches(response.asString())
            );
        } 

        public static void validatejsonschemaerror(Response response) {
            JsonSchemaValidator jsv = 
            JsonSchemaValidator.matchesJsonSchemaInClasspath("Regressin/UserJsonSchema.json");
            
            
            assertFalse
            ("Validacion de Json Schema para Creacion de usuarios ",jsv.matches(response.asString())
            );
        } 

        public static void validatejsonschemaerrordato(Response response) {
            JsonSchemaValidator jsv = 
            JsonSchemaValidator.matchesJsonSchemaInClasspath("Regressin/UserJsonSchemasingleuser.json");
            
            
            assertTrue
            ("Validacion de Json Schema para Creacion de usuarios ",jsv.matches(response.asString())
            );
        } 
}