package hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.parser;

import org.json.JSONException;
import org.json.JSONObject;

public class ConsoleParser {
    public String registrationNumberInputString(String r) {
        return r.trim().toUpperCase();
    }

    public String registrationNumberToJsonString(String r) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("registrationNumber", r);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}