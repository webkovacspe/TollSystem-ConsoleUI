package hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.view;

import org.json.JSONObject;

public class TollSystemConsoleUIView {
    public void displaySelectActionMessage() {
        System.out.println("Válasszon funkciót: Lekérdezés (l); Kilépés (k)");
    }
    public void displayRegistrationNumberInputMessage() {
        System.out.println("Adja meg a rendszámot:");
    }

    public void displayMotorwayVignette(JSONObject responseJsonObject) {
        System.out.println("Matrica adatok");
    }
}