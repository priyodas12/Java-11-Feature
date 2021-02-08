package optionalMethods;

import java.util.Optional;

public class OptionalImpl {
    public static void main(String[] args) {
        Optional optional=Optional.of("");
        //optional=optional.empty();
        //boolean check
        System.out.println(optional.isEmpty());
    }
}
