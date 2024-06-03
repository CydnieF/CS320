package Main;

import java.util.Date;

public class Appointment {
	private final String appointmentID;
	private Date appointmentDate;
	private String appointmentDescription;
	
	
	// constructor for appointment
    public Appointment(String appointmentID, Date appointmentDate, String appointmentDescription) {
    	// appointment ID cannot be null, or greater than 10 characters
        if (appointmentID == null || appointmentID.length() > 10) {
            throw new IllegalArgumentException("Invalid appointment ID");
        }
        // appointment Date cannot be null or a date that has already passed
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment date");
        }
        // appointment description cannot be null, or greater than 50 characters
        if (appointmentDescription == null || appointmentDescription.length() > 50) {
            throw new IllegalArgumentException("Invalid appointment description");
        }

        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.appointmentDescription = appointmentDescription;
    }

 // getters and setters for appointment attributes
    public String getAppointmentID() {
        return appointmentID;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    // appointment date cannot be null or a date that has already passed
    public void setAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment date");
        }
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentDescription() {
        return appointmentDescription;
    }

    // appointment description cannot be null or greater than 50 characters
    public void setAppointmentDescription(String appointmentDescription) {
        if (appointmentDescription == null || appointmentDescription.length() > 50) {
            throw new IllegalArgumentException("Invalid appointment description");
        }
        this.appointmentDescription = appointmentDescription;
    }
}
