package hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.presenter;

import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.dto.MotorwayVignetteResponseDTO;
import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.parser.MotorwayVignetteParser;
import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.validator.MotorwayVignetteResponseValidator;
import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.view.TollSystemConsoleUIView;
import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.viewmodel.MotorwayVignetteModel;
import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.viewmodel.VehicleModel;
import hu.kovacspeterzoltan.bootcamp.tollsystemapp.api.MotorwayVignettePresenterInterface;

import java.text.SimpleDateFormat;
import java.util.List;

public class TollSystemAppPresenterImp implements MotorwayVignettePresenterInterface {
    private final TollSystemConsoleUIView view;
    private final MotorwayVignetteResponseValidator validator;
    private final MotorwayVignetteParser parser;

    public TollSystemAppPresenterImp() {
        view = new TollSystemConsoleUIView();
        validator = new MotorwayVignetteResponseValidator();
        parser = new MotorwayVignetteParser();
    }

    @Override
    public void displayJsonResponse(String responseJsonString) {
        validator.responseValidator(responseJsonString);
        MotorwayVignetteResponseDTO responseDTO = parser.jsonStringToMotorwayVignetteResponseDTO(responseJsonString);
        if (responseDTO.isError()) {
            view.displayErrorMessage(responseDTO);
        } else {
            view.displayMotorwayVignettesAndVehicle(
                    parser.responseDTOToMotorwayVignettes(responseDTO.motorwayVignettes),
                    parser.responseDTOToVehicleModel(responseDTO.vehicle)
            );
        }
    }
}