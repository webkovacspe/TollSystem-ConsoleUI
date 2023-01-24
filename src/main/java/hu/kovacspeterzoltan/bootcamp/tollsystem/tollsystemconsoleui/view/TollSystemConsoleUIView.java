package hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.view;

import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.dto.MotorwayVignetteResponseDTO;
import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.viewmodel.MotorwayVignetteModel;
import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.viewmodel.VehicleModel;

import java.util.List;

public class TollSystemConsoleUIView {
    public void displaySelectActionMessage() {
        System.out.println("Válasszon funkciót: Lekérdezés (l); Kilépés (k)");
    }

    public void displayRegistrationNumberInputMessage() {
        System.out.println("Adja meg a rendszámot:");
    }

    public void displayErrorMessage(MotorwayVignetteResponseDTO responseDTO) {
        System.out.println(responseDTO.errorMessage);
    }

    public void displayMotorwayVignettesAndVehicle(List<MotorwayVignetteModel> mv, VehicleModel v) {
        System.out.println("Az [%s] rendszámú jármű úthasználati jogosultság története:".formatted(v.registrationNumber));
        displayMotorwayVignettes(mv);
        displayVehicle(v);
    }

    public void displayMotorwayVignettes(List<MotorwayVignetteModel> motorwayVignetteModels) {
        if (motorwayVignetteModels.isEmpty()) {
            System.out.println("-- Nincs megjelenítendő adat --");
        } else {
            motorwayVignetteModels.forEach(mv -> {
                String message = "[%s][%s][%s][%s][%s]";
                System.out.println(message.formatted(
                        (mv.isValid ? "X" : " "),
                        mv.getFormattedValidFrom(),
                        mv.getFormattedValidTo(),
                        mv.vehicleCategory,
                        mv.getFormattedDateOfPurchase()
                ));
            });
        }
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
}