package hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.validator;

import java.util.regex.Pattern;

public class InputValidator {
    public void registrationNumberValidator(String registrationNumber) {
        if (registrationNumber.equals("")) {
            throw new InvalidRegitrationNumberException();
        }

        Pattern pattern = Pattern.compile("^[a-zA-Z]{2}:[a-zA-Z]{2}-[0-9]{3}$");
        if (!pattern.matcher(registrationNumber).matches()) {
            throw new InvalidRegitrationNumberException();
        }
    }
}
