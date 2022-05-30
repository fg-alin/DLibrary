package com.application.dlibrary.exemplary.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.application.dlibrary.exemplary.Exemplary;
import com.application.dlibrary.exemplary.dto.ExemplaryDTO;

@Component
public class ExemplaryMapper {
	public ExemplaryDTO exemplary2ExemplaryDTO(Exemplary exemplary) {
		ExemplaryDTO exemplaryDTO = new ExemplaryDTO();
		exemplaryDTO.setId(exemplary.getId());
		exemplaryDTO.setDate(exemplary.getDate());
		exemplaryDTO.setCode(exemplary.getCode());
		exemplaryDTO.setPageNumbers(exemplary.getPageNumbers());
		return exemplaryDTO;
	}

	public List<ExemplaryDTO> exemplaryList2ExemplaryDTOList(List<Exemplary> exemplaryList) {
		return exemplaryList.stream().map(exemplary -> exemplary2ExemplaryDTO(exemplary)).collect(Collectors.toList());
	}

	public Exemplary exemplaryDTO2Exemplary(ExemplaryDTO exemplaryDTO) {
		Exemplary exemplary = new Exemplary();
		exemplary.setId(exemplaryDTO.getId());
		exemplary.setDate(exemplaryDTO.getDate());
		exemplary.setCode(exemplaryDTO.getCode());
		exemplary.setPageNumbers(exemplaryDTO.getPageNumbers());
		return exemplary;
	}
}