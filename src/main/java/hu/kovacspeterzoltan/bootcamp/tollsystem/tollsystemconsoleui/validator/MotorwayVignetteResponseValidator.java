package hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.validator;

import org.json.JSONException;
import org.json.JSONObject;

public class MotorwayVignetteResponseValidator {
    public void responseValidator(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}