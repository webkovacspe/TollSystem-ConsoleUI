package hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.dto;

import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.parser.MotorwayVignetteParser;
import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.validator.MotorwayVignetteResponseValidator;
import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.view.TollSystemConsoleUIView;
import hu.kovacspeterzoltan.bootcamp.tollsystemapp.api.MotorwayVignettePresenter;
import org.json.JSONObject;

public class TollSystemAppPresenterImp implements MotorwayVignettePresenter {
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
        view.displayMotorwayVignette(responseJsonObject);
    }
}