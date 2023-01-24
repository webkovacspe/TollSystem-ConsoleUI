package hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.view;

import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.viewmodel.MotorwayVignetteModel;
import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.viewmodel.VehicleModel;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class TollSystemConsoleUIView {
    public void displaySelectActionMessage() {
        System.out.println("Válasszon funkciót: Lekérdezés (l); Kilépés (k)");
    }
    public void displayRegistrationNumberInputMessage() {
        System.out.println("Adja meg a rendszámot:");
    }

    public void displayVehicle(VehicleModel vehicle) {
        String message = """
                A jármű adatai:
                Rendszám: %s
                Jármű kategóriája: %s
                Gyártmány: %s
                Típus: %s
                Szállítható személyek száma: %d
            """;
        System.out.println(message.formatted(
                vehicle.registrationNumber,
                vehicle.vehicleType,
                vehicle.make,
                vehicle.model,
                vehicle.numberOfSeats
        ));
    }

    public void displayErrorMessage(JSONObject responseJsonObject) {
        try {
            System.out.println(responseJsonObject.get("errorMessage").toString());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void displayMotorwayVignettes(List<MotorwayVignetteModel> motorwayVignetteModels) {
        motorwayVignetteModels.forEach(mv -> {
            String message = "[%s][%s][%s][%s][%s]";
            System.out.println(message.formatted(
                    (mv.validDate() ? "X" : " "),
                    mv.getFormattedValidFrom(),
                    mv.getFormattedValidFrom(),
                    mv.vehicleCategory,
                    mv.getFormattedValidFrom()
            ));
        });
    }

    public void displayMotorwayVignettesAndVehicle(List<MotorwayVignetteModel> motorwayVignetteModels, VehicleModel vehicle) {
        System.out.println("Az [%s] rendszámú jármű úthasználati jogosultság története:".formatted(vehicle.registrationNumber));
        displayMotorwayVignettes(motorwayVignetteModels);
        displayVehicle(vehicle);
    }
}