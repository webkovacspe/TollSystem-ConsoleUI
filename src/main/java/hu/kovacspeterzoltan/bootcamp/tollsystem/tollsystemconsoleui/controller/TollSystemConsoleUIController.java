package hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.controller;

import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.parser.ConsoleParser;
import hu.kovacspeterzoltan.bootcamp.tollsystemapp.api.MotorwayVignetteAPI;

public class TollSystemConsoleUIController {
    private MotorwayVignetteAPI motorwayVignetteInteractor;
    private final ConsoleParser parser;

    public TollSystemConsoleUIController() {
        parser = new ConsoleParser();
    }

    public void setMotorwayVignetteImp(MotorwayVignetteAPI motorwayVignetteImp) {
        this.motorwayVignetteInteractor = motorwayVignetteImp;
    }

    public void findAction(String registrationNumber) {
        motorwayVignetteInteractor.findByRegistrationNumber(parser.registrationNumberToJsonString(registrationNumber));
    }
}