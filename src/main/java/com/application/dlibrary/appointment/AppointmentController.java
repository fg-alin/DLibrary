package com.application.dlibrary.appointment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.dlibrary.appointment.dto.AppointmentCreateDTO;
import com.application.dlibrary.appointment.dto.AppointmentDTO;
import com.application.dlibrary.appointment.dto.AppointmentInfoDTO;
import com.application.dlibrary.appointment.mapper.AppointmentMapper;
import com.application.dlibrary.exemplary.Exemplary;
import com.application.dlibrary.exemplary.dto.ExemplaryDTO;
import com.application.dlibrary.exemplary.mapper.ExemplaryMapper;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;
	@Autowired
	private AppointmentMapper appointmentMapper;
	@Autowired
	private ExemplaryMapper exemplaryMapper;

	@GetMapping("/list/{userId}")
	public List<AppointmentDTO> getAppointmentsForUser(@PathVariable Integer userId) {
		List<Appointment> appointmentDBs = new ArrayList<>(appointmentService.getAllAppointmentsForUser(userId));
		return appointmentMapper.appointmentList2AppointmentListDTO(appointmentDBs);
	}

	@PostMapping("/find")
	public List<ExemplaryDTO> getExemplariesForPeriod(@RequestBody AppointmentInfoDTO appointmentInfoDTO) {
		List<Exemplary> exemplaries = appointmentService.getExemplariesForPeriod(appointmentInfoDTO.getDateFrom(),
				appointmentInfoDTO.getDateUntil(), appointmentInfoDTO.getBookId());
		return exemplaryMapper.exemplaryList2ExemplaryDTOList(exemplaries);
	}

	@PostMapping("/book/{exemplaryId}/{userId}")
	public void book(@RequestBody AppointmentCreateDTO appointmentCreateDTO, @PathVariable Integer exemplaryId,
			@PathVariable Integer userId) {
		appointmentService.book(appointmentMapper.appointmentCreateDTO2Appointment(appointmentCreateDTO), exemplaryId,
				userId);
	}
}
