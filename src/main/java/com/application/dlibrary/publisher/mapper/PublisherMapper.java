package com.application.dlibrary.publisher.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.application.dlibrary.publisher.Publisher;
import com.application.dlibrary.publisher.dto.PublisherDTO;

@Component
public class PublisherMapper {

	public PublisherDTO publisher2PublisherDTO(Publisher publisher) {
		PublisherDTO publisherDTO = new PublisherDTO();
		publisherDTO.setId(publisher.getId());
		publisherDTO.setName(publisher.getName());
		publisherDTO.setAddress(publisher.getAddress());
		return publisherDTO;
	}

	public Publisher publisherDTO2Publisher(PublisherDTO publisherDTO) {
		Publisher publisher = new Publisher();
		publisher.setId(publisherDTO.getId());
		publisher.setName(publisherDTO.getName());
		publisher.setAddress(publisherDTO.getAddress());
		return publisher;
	}

	public List<PublisherDTO> publisherList2PublisherDTOList(List<Publisher> publishers) {
		return publishers.stream().map(publisher -> publisher2PublisherDTO(publisher)).collect(Collectors.toList());
	}
}