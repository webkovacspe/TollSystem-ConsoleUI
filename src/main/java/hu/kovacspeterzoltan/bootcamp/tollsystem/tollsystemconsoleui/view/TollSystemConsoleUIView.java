package hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.view;

import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.controller.TollSystemConsoleUIController;
import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.dto.MotorwayVignetteResponseDTO;
import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.parser.ConsoleParser;
import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.validator.InputValidator;
import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.viewmodel.MotorwayVignetteModel;
import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.viewmodel.VehicleModel;

import java.util.List;
import java.util.Scanner;

public class TollSystemConsoleUIView {
    private TollSystemConsoleUIController controller;
    private final InputValidator validator;
    private final ConsoleParser parser;
    private Scanner scanner;

    public TollSystemConsoleUIView() {
        validator = new InputValidator();
        parser = new ConsoleParser();
    }

    public void setController(TollSystemConsoleUIController controller) {
        this.controller = controller;
    }

    public void start() {
        scanner = new Scanner(System.in);
        String action;
        do {
            action = getActionString();

            if ("l".equals(action)) {
                displayRegistrationNumberInputMessage();
                String registrationNumber = scanner.next();
                try {
                    validator.registrationNumberValidator(registrationNumber);
                    controller.findAction(parser.registrationNumberInputString(registrationNumber));
                } catch (RuntimeException e) {
                    System.out.println("Hibásad adta meg a rendszámot");
                }
            }
        } while (!"k".equals(action));
    }

    private String getActionString() {
        System.out.println("Válasszon funkciót: Lekérdezés (l); Kilépés (k)");
        return scanner.next();
    }

    private void displayRegistrationNumberInputMessage() {
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