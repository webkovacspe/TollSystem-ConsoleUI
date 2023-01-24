package hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.dto;

import java.util.List;

public class MotorwayVignetteResponseDTO {
    public String errorMessage;
    public VehicleDTO vehicle;
    public List<MotorwayVignetteDTO> motorwayVignettes;

    public boolean isError() {
        return (errorMessage != null);
    }
}