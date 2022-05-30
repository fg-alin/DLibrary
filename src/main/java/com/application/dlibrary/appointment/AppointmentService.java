package com.application.dlibrary.appointment;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.dlibrary.exception.ResourceNotFoundException;
import com.application.dlibrary.exception.ValidationException;
import com.application.dlibrary.exemplary.Exemplary;
import com.application.dlibrary.exemplary.ExemplaryRepository;
import com.application.dlibrary.user.User;
import com.application.dlibrary.user.UserRepository;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	@Autowired
	private ExemplaryRepository exemplaryRepository;
	@Autowired
	private UserRepository userRepository;

	public Set<Appointment> getAllAppointmentsForUser(Integer userId) {
		return appointmentRepository.findByUser(userId);
	}

	public List<Exemplary> getExemplariesForPeriod(LocalDate dateFrom, LocalDate dateUntil, Integer bookId) {
		return exemplaryRepository.getExemplariesForPeriod(dateFrom, dateUntil, bookId);
	}

	public void book(Appointment appointment, Integer exemplaryId, Integer userId) {
		if (appointment.getDateFrom().isAfter(appointment.getDateUntil())) {
			throw new ValidationException("End date of the appointment is before start date");
		}

		Exemplary exemplary = exemplaryRepository.findById(exemplaryId)
				.orElseThrow(() -> new ResourceNotFoundException("Exemplary not found"));
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));

		if (!getExemplariesForPeriod(appointment.getDateFrom(), appointment.getDateUntil(), exemplary.getBook().getId())
				.contains(exemplary)) {
			throw new ValidationException("The exemplary was reserved by somebody else");
		}

		exemplary.addAppointment(appointment);
		user.addAppointment(appointment);

		appointmentRepository.saveAndFlush(appointment);
	}

}
