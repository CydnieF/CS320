package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Main.Appointment;

class AppointmentTest {
	@Test // tests that appointment can be created
	void testAppointmentClass() {
		Appointment appointment = new Appointment ("1234567890", new Date(), "appointment description");
		assertEquals("1234567890", appointment.getAppointmentID());
		assertEquals("appointment date", appointment.getAppointmentDate());
		assertEquals("appointment description", appointment.getAppointmentDescription());
	}
	
	@Test // tests that assertion is thrown if appointment ID is invalid
	void testAppointmentIDInvalid() {
		// appointment ID is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345123456", "appointment date", "appointment description");	
		});
		// appointment ID is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, "appointment date", "appointment description");
		});
	}
		
	@Test // tests that assertion is thrown if appointment date is invalid
	void testAppointmentDateInvalid() {
		// appointment Date is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1234512345", "appointment date 1234567890-", "appointment description");
		});
		// appointment date is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1234512345", null, "appointment description");
		});
	}

	@Test // tests that assertion is thrown if appointment description is invalid
	void testAppointmentDescriptionInvalid() {
		// appointment description is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1234512345", "appointment date", 
					"appointment description 1234567890qwertyuiopasdfghjklzxcvbnm");
		});
		// appointment description is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1234512345", "appointment date", null);
		});
	}
		
	@Test // tests setter method for appointment date, and if appropriate exceptions are thrown
	void testSetAppointmentDate () {
		Appointment appointment = new Appointment ("1234512345", "appointment date", "appointment description");
		appointment.setAppointmentDate ("date");
		assertEquals("date", appointment.getAppointmentDate());
		// appointment date is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
            appointment.setAppointmentDate("appointment date 1234567890-");
        });
        // appointment date is null
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            appointment.setAppointmentDate(null);
        });
	}
	
	@Test // tests setter method for appointment description, and if appropriate exceptions are thrown
	void testSetAppointmentDescription () {
		Appointment appointment = new Appointment ("1234512345", "appointment date", "appointment description");
		appointment.setAppointmentDescription ("description");
		assertEquals("description", appointment.getAppointmentDescription());
		// appointment description is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
            appointment.setAppointmentDescription("appointment description 1234567890qwertyuiopasdfghjklzxcvbnm");
        });		
        // appointment description is null
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            appointment.setAppointmentDescription(null);
        });
	}
}