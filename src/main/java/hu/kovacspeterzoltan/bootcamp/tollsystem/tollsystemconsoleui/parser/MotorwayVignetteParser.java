package hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.parser;

import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.viewmodel.MotorwayVignetteModel;
import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.viewmodel.VehicleModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MotorwayVignetteParser {
    public JSONObject jsonStringToJsonObject(String jsonString) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public VehicleModel responseJsonObjectToVehicleModel(JSONObject responseJsonObject) {
        VehicleModel v = new VehicleModel();
        try {
            v.registrationNumber = responseJsonObject.getString("registrationNumber");
            v.vehicleType = responseJsonObject.getString("vehicleType");
            v.make = responseJsonObject.getString("make");
            v.model = responseJsonObject.getString("model");
            v.numberOfSeats = responseJsonObject.getInt("numberOfSeats");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return v;
    }

    public List<MotorwayVignetteModel> responseJsonObjectToMotorwayVignettes(JSONObject responseJsonObject) {
        List<MotorwayVignetteModel> motorwayVignetteModels = new ArrayList<>();
        try {
            JSONArray motorwayVignettes = responseJsonObject.getJSONArray("motorwayVignettes");
            for (int i = 0; i < motorwayVignettes.length(); i++) {
                motorwayVignetteModels.add(jsonObjectToMotorwayVignetteeModel(motorwayVignettes.getJSONObject(i)));
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return motorwayVignetteModels;
    }
    private MotorwayVignetteModel jsonObjectToMotorwayVignetteeModel(JSONObject jsonObject) {
        MotorwayVignetteModel mv = new MotorwayVignetteModel();
        try {
            mv.registrationNumber = jsonObject.getString("registrationNumber");
            mv.vehicleCategory = jsonObject.getString("vehicleCategory");
            mv.motorwayVignetteType = jsonObject.getString("motorwayVignetteType");
            mv.price = jsonObject.getDouble("price");
            mv.setValidFrom(jsonObject.getString("validFrom"));
            mv.setValidTo(jsonObject.getString("validTo"));
            mv.setDateOfPurchase(jsonObject.getString("dateOfPurchase"));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return mv;
    }
}