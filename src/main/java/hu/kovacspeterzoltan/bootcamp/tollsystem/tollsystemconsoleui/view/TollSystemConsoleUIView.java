package hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.view;

import org.json.JSONObject;

public class TollSystemConsoleUIView {
    public void displayStartMessage() {
        System.out.println("Adja meg a keresett rendszámot:");
    }

    public void displayMotorwayVignette(JSONObject responseJsonObject) {
        System.out.println("Matrica adatok");
    }
}