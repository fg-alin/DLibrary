package com.application.dlibrary.appointment.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.application.dlibrary.appointment.Appointment;
import com.application.dlibrary.appointment.dto.AppointmentCreateDTO;
import com.application.dlibrary.appointment.dto.AppointmentDTO;

@Component
public class AppointmentMapper {

	public Appointment appointmentCreateDTO2Appointment(AppointmentCreateDTO appointmentCreateDTO) {
		Appointment appointment = new Appointment();
		appointment.setDateFrom(appointmentCreateDTO.getDateFrom());
		appointment.setDateUntil(appointmentCreateDTO.getDateUntil());
		return appointment;
	}

	public AppointmentDTO appointment2AppointmentDTO(Appointment appointment) {
		AppointmentDTO appointmentDTO = new AppointmentDTO();
		appointmentDTO.setId(appointment.getId());
		appointmentDTO.setDateFrom(appointment.getDateFrom());
		appointmentDTO.setDateUntil(appointment.getDateUntil());

		return appointmentDTO;
	}

	public List<AppointmentDTO> appointmentList2AppointmentListDTO(List<Appointment> appointments) {
		return appointments.stream().map(appointment -> appointment2AppointmentDTO(appointment))
				.collect(Collectors.toList());
	}
}