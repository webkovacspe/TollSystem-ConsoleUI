package hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.controller;

import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.validator.MotorwayVignetteResponseValidator;
import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.view.TollSystemConsoleUIView;
import hu.kovacspeterzoltan.bootcamp.tollsystemapp.api.MotorwayVignetteAPI;

public class TollSystemConsoleUIController {
    private MotorwayVignetteAPI motorwayVignetteInteractor;
    private TollSystemConsoleUIView view;

    public TollSystemConsoleUIController() {
        view = new TollSystemConsoleUIView();
    }

    public void setMotorwayVignetteAPI(MotorwayVignetteAPI motorwayVignetteImp) {
        this.motorwayVignetteInteractor = motorwayVignetteImp;
    }
    public void start() {
        view.displayStartMessage();
    }
}