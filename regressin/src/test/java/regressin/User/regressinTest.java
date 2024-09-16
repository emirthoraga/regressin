package regressin.User;





import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import io.restassured.response.Response;
import regressin.GeneralApiBase.regressinBase;
import regressin.User.UserRequest.NoFoundUserRequest;
import regressin.User.UserRequest.SingleUserRequest;
import regressin.User.UserRequest.UserDelayRequest;


public class regressinTest extends regressinBase {
    @ParameterizedTest
    @CsvSource ({
        "2,200",
    })    
    public void baseuri(String userlist, Integer statusExpected){

        Response response =  UserRequest.getuser(requestSpecification, userlist );
        UserQuestion.validatestatuscode(response, statusExpected);
        UserQuestion.validatejsonschema(response);
}

    @ParameterizedTest
    @CsvSource ({
        "rachel.howell@reqres.in",
    })    
    public void SingleUser(String Email){

        Response response =  SingleUserRequest.Singleuser(requestSpecification);
        UserQuestion.Emailcheck(response, Email);
        UserQuestion.validatejsonschemaerrordato(response);
}

@ParameterizedTest
@CsvSource ({
    "404",
})    
    public void Usernofound(Integer statusExpected){
    Response response =  NoFoundUserRequest.Nofounduser(requestSpecification);
    UserQuestion.NofoundUser404(response, statusExpected);
    UserQuestion.validatejsonschemaerror(response);
}
@ParameterizedTest
@CsvSource ({
    "Emirtho, Raga, 15665321, 201",
})    
    public void createuser(String name, String email, String password, Integer statuscodeexpect){     
        String createuser = ModelUser.createuser(name, email, password);
        Response response= UserRequest.postcreateuser(requestSpecification, createuser);
        UserQuestion.ValideateCreated(response, statuscodeexpect);
        UserQuestion.validatejsonschemaerror(response);
    }

    @ParameterizedTest
    @CsvSource ({
        "3,200",
    })    
    public void delaycreateuser(String userdelaylist, Integer statusExpected){

        Response response =  UserDelayRequest.Delayuser(requestSpecification, userdelaylist );
        UserQuestion.validatestatuscode(response, statusExpected);
        UserQuestion.validatejsonschema(response);
}


}