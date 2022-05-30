package com.application.dlibrary.appointment;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

	@Query(value = "SELECT DISTINCT appointment FROM appointment appointment inner join appointment.user user WHERE user.id = ?1")
	Set<Appointment> findByUser(Integer userId);
}