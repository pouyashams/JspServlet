package Service;

import DTO.UserDetailsDTO;

import java.math.BigDecimal;
import java.util.HashMap;

public class LoginService {
    HashMap<String, BigDecimal> users = new HashMap<String, BigDecimal>();

    public LoginService() {
        users.put("pouya", BigDecimal.valueOf(1000000));
        users.put("Germany", BigDecimal.valueOf(300));
        users.put("Norway", BigDecimal.valueOf(2000));
        users.put("USA", BigDecimal.valueOf(8000));
    }

    public Boolean authenticate(String user, String password) {
        if (user.equals("pouya") && password.equals("12345")) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public UserDetailsDTO createUserInfo(String user) {
        UserDetailsDTO userDetails = new UserDetailsDTO();
        userDetails.setUser(user);
        userDetails.setAmount(users.get(user));
        return userDetails;
    }
}
