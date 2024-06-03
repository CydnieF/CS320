package Main;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
	// stores appointments and their attributes
    private final Map<String, Appointment> appointments = new HashMap<>();

    // allows for a new appointment to be created
    public void addAppointment(String appointmentID, Date appointmentDate, String appointmentDescription) {
    	// ensure that appointment ID is not already in use
        if (appointments.containsKey(appointmentID)) {
            throw new IllegalArgumentException("Appointment ID already exists");
        }
        Appointment newAppointment = new Appointment(appointmentID, appointmentDate, appointmentDescription);
        appointments.put(appointmentID, newAppointment);
    }

    // allow for a appointment to be deleted via appointment ID
    public void deleteAppointment(String appointmentID) {
    	// ensure that appointment id is already in use
        if (!appointments.containsKey(appointmentID)) {
            throw new IllegalArgumentException("Appointment ID not found.");
        }
        // remove deleted appointment ID so it can be used again
        appointments.remove(appointmentID);
    }
}
