package hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.dto;

import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.parser.MotorwayVignetteParser;
import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.validator.MotorwayVignetteResponseValidator;
import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.view.TollSystemConsoleUIView;
import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.viewmodel.MotorwayVignetteModel;
import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.viewmodel.VehicleModel;
import hu.kovacspeterzoltan.bootcamp.tollsystemapp.api.MotorwayVignettePresenterInterface;
import org.json.JSONObject;

import java.util.List;

public class TollSystemAppPresenterImp implements MotorwayVignettePresenterInterface {
    private TollSystemConsoleUIView view;
    private MotorwayVignetteResponseValidator validator;
    private MotorwayVignetteParser parser;

    public TollSystemAppPresenterImp() {
        view = new TollSystemConsoleUIView();
        validator = new MotorwayVignetteResponseValidator();
        parser = new MotorwayVignetteParser();
    }

    @Override
    public void displayJsonResponse(String jsonString) {
        validator.responseValidator(jsonString);
        JSONObject responseJsonObject = parser.jsonStringToJsonObject(jsonString);
        if (responseJsonObject.has("errorMessage")) {
            view.displayErrorMessage(responseJsonObject);
        } else {
            List<MotorwayVignetteModel> motorwayVignetteModels = parser.responseJsonObjectToMotorwayVignettes(responseJsonObject);
            VehicleModel vehicle = parser.responseJsonObjectToVehicleModel(responseJsonObject);
            view.displayMotorwayVignettesAndVehicle(motorwayVignetteModels, vehicle);
        }
    }
}