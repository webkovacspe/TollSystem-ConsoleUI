package hu.kovacspeterzoltan.bootcamp.tollsystem.tollsystemconsoleui.viewmodel;

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
    private SimpleDateFormat formatter;

    public MotorwayVignetteModel() {
        formatter = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
    }

    public String getFormattedValidFrom() {
        return formatter.format(validFrom);
    }
    public void setValidFrom(String dateString) {
        validFrom = dateParser(dateString);
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(String dateString) {
        validTo = dateParser(dateString);
    }
    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(String dateString) {
        dateOfPurchase = dateParser(dateString);
    }

    public boolean validDate() {
        Date currentDate = new Date();
        return (currentDate.compareTo(validFrom) >= 0 && currentDate.compareTo(validTo) <= 0);
    }

    private Date dateParser(String dateString) {
        try {
            return formatter.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
