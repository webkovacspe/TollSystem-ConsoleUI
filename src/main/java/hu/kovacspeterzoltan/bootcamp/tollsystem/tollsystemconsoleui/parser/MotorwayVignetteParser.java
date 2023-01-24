package hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.parser;

import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.dto.MotorwayVignetteDTO;
import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.dto.MotorwayVignetteResponseDTO;
import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.dto.VehicleDTO;
import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.viewmodel.MotorwayVignetteModel;
import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.viewmodel.VehicleModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MotorwayVignetteParser {
    private final SimpleDateFormat formatter;

    public MotorwayVignetteParser() {
        formatter = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
    }

    public MotorwayVignetteResponseDTO jsonStringToMotorwayVignetteResponseDTO(String jsonString) {
        MotorwayVignetteResponseDTO dto = null;
        String errorMessageKey = "errorMessage";
        try {
            JSONObject j = new JSONObject(jsonString);
            dto = new MotorwayVignetteResponseDTO();
            if (j.has(errorMessageKey)) {
                dto.errorMessage = j.getString(errorMessageKey);
            } else {
                dto.vehicle = jsonObjectToVehicleDTO(j.getJSONObject("vehicle"));
                dto.motorwayVignettes = jsonObjectToMotorwayVignettes(j.getJSONArray("motorwayVignettes"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return dto;
    }

    private List<MotorwayVignetteDTO> jsonObjectToMotorwayVignettes(JSONArray motorwayVignettes) {
        List<MotorwayVignetteDTO> mv = new ArrayList<>();
        try {
            for (int i = 0; i < motorwayVignettes.length(); i++) {
                mv.add(jsonObjectToMotorwayVignetteDTO(motorwayVignettes.getJSONObject(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mv;
    }

    private MotorwayVignetteDTO jsonObjectToMotorwayVignetteDTO(JSONObject jsonObject) {
        MotorwayVignetteDTO dto = null;
        try {
            dto = new MotorwayVignetteDTO();
            dto.registrationNumber = jsonObject.getString("registrationNumber");
            dto.vehicleCategory = jsonObject.getString("vehicleCategory");
            dto.motorwayVignetteType = jsonObject.getString("motorwayVignetteType");
            dto.price = jsonObject.getDouble("price");
            dto.validFrom = dateStringToDate(jsonObject.getString("validFrom"));
            dto.validTo = dateStringToDate(jsonObject.getString("validTo"));
            dto.dateOfPurchase = dateStringToDate(jsonObject.getString("dateOfPurchase"));
            dto.isValid = jsonObject.getBoolean("isValid");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return dto;
    }

    private Date dateStringToDate(String dateString) {
        Date d = null;
        try {
            d = formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }

    public String dateToDateString(Date date) {
        return formatter.format(date);
    }

    private VehicleDTO jsonObjectToVehicleDTO(JSONObject vehicle) {
        VehicleDTO dto = new VehicleDTO();
        try {
            dto.registrationNumber = vehicle.getString("registrationNumber");
            dto.vehicleType = vehicle.getString("vehicleType");
            dto.make = vehicle.getString("make");
            dto.model = vehicle.getString("model");
            dto.numberOfSeats = vehicle.getInt("numberOfSeats");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return dto;
    }

    public List<MotorwayVignetteModel> responseDTOToMotorwayVignettes(List<MotorwayVignetteDTO> motorwayVignettes) {
        List<MotorwayVignetteModel> motorwayVignetteModels = new ArrayList<>();
        motorwayVignettes.forEach(dto -> {
            motorwayVignetteModels.add(motorwayVignetteDTOToModel(dto));
        });
        return motorwayVignetteModels;

    }

    private MotorwayVignetteModel motorwayVignetteDTOToModel(MotorwayVignetteDTO dto) {
        MotorwayVignetteModel mv = new MotorwayVignetteModel();
        mv.registrationNumber = dto.registrationNumber;
        mv.vehicleCategory = dto.vehicleCategory;
        mv.motorwayVignetteType = dto.motorwayVignetteType;
        mv.price = dto.price;
        mv.validFrom = dto.validFrom;
        mv.validTo = dto.validTo;
        mv.dateOfPurchase = dto.dateOfPurchase;
        mv.isValid = dto.isValid;
        return mv;
    }

    public VehicleModel responseDTOToVehicleModel(VehicleDTO dto) {
        VehicleModel v = new VehicleModel();
        v.registrationNumber = dto.registrationNumber;
        v.vehicleType = dto.vehicleType;
        v.make = dto.make;
        v.model = dto.model;
        v.numberOfSeats = dto.numberOfSeats;
        return v;
    }
}