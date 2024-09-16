package regressin.User;

public class ModelUser {
    public static String createuser (String name, String email, String password){
        String json = "{"
        + "\"name\":\"" + name + "\","
        + "\"email\":\"" + email + "\","
        + "\"password\":\"" + password + "\""
        + "}";

        return json;
    }
}
