package hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.controller;

import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.view.TollSystemConsoleUIView;
import hu.kovacspeterzoltan.bootcamp.tollsystemapp.api.MotorwayVignetteAPI;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Scanner;

public class TollSystemConsoleUIController {
    private MotorwayVignetteAPI motorwayVignetteInteractor;
    private TollSystemConsoleUIView view;
    private Scanner scanner;

    public TollSystemConsoleUIController() {
        view = new TollSystemConsoleUIView();
    }

    public void setMotorwayVignetteImp(MotorwayVignetteAPI motorwayVignetteImp) {
        this.motorwayVignetteInteractor = motorwayVignetteImp;
    }
    public void start() {
        scanner = new Scanner(System.in);
        String action = null;
        do {
            action = getActionString();

            if ("l".equals(action)) {
                findAction();
            }
        } while (!"k".equals(action));
    }
    private String getActionString() {
        String action;
        view.displaySelectActionMessage();
        action = scanner.next();
        return action;
    }

    private void findAction() {
        try {
            view.displayRegistrationNumberInputMessage();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("registrationNumber", scanner.next().toUpperCase());
            motorwayVignetteInteractor.findByRegistrationNumber(jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}