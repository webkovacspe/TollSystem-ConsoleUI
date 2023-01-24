package hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.viewmodel;

import hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.parser.MotorwayVignetteParser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MotorwayVignetteModel {
    public String registrationNumber;
    public String vehicleCategory;
    public String motorwayVignetteType;
    public double price;
    public Date validFrom;
    public Date validTo;
    public Date dateOfPurchase;
    public boolean isValid;
    private final MotorwayVignetteParser parser;

    public MotorwayVignetteModel() {
        parser = new MotorwayVignetteParser();
    }

    public String getFormattedValidFrom() {
        return parser.dateToDateString(validFrom);
    }

    public String getFormattedValidTo() {
        return parser.dateToDateString(validTo);
    }

    public String getFormattedDateOfPurchase() {
        return parser.dateToDateString(dateOfPurchase);
    }
}