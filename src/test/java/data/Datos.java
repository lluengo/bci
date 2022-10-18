package data;

import com.bci.examen.examen.entity.Phone;
import com.bci.examen.examen.entity.User;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

public class Datos {

    public static Optional<User> getUser001(){

        return Optional.of(new User(UUID.fromString("bae0b173-4a38-41ae-988d-552fa8dd1a2c"), "lluengo","leonel.luengo@gmail.com","1234"
                , Arrays.asList(new Phone(1l,44345343,1,"rrers"))));
    }
}
