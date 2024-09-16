package regressin.User;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserRequest {

    public static Response getuser(RequestSpecification requestSpecification, String
    userlist){
      
        requestSpecification.param("page", userlist);
        return requestSpecification.get("/api/users");

    }

    public class SingleUserRequest {

        public static Response Singleuser(RequestSpecification requestSpecification){
          
            return requestSpecification.get("/api/users/12");
        }
    }

    public class NoFoundUserRequest {

        public static Response Nofounduser(RequestSpecification requestSpecification){
          
            return requestSpecification.get("/api/users/55551256");
        }
    }
   
    public static Response postcreateuser(RequestSpecification requestSpecification, String
    createuser){
      
        return requestSpecification.body(createuser).post("/api/users");

    }

    public class UserDelayRequest {

        public static Response Delayuser(RequestSpecification requestSpecification, String delaylist ){
          
            requestSpecification.param("delay", delaylist);
            return requestSpecification.get("/api/users");
        }
    }
}
