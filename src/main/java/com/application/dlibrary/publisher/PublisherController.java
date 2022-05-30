package com.application.dlibrary.publisher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.application.dlibrary.publisher.dto.PublisherDTO;
import com.application.dlibrary.publisher.mapper.PublisherMapper;

@RestController
@RequestMapping("/publishers")
public class PublisherController {
	@Autowired
	private PublisherService publisherService;

	@Autowired
	private PublisherMapper publisherMapper;

	@PostMapping()
	public PublisherDTO createPublisher(@RequestBody PublisherDTO publisherDTO) {
		Publisher createPublisher = publisherService
				.createPublisher(publisherMapper.publisherDTO2Publisher(publisherDTO));
		return publisherMapper.publisher2PublisherDTO(createPublisher);
	}


	@GetMapping("/list")
	public List<PublisherDTO> getAllPublisher() {
		return publisherMapper.publisherList2PublisherDTOList(publisherService.getAllPublisher());
	}

	@GetMapping("/{id}")
	public PublisherDTO getPublisherById(@PathVariable Integer id) {
		return publisherMapper.publisher2PublisherDTO(publisherService.getPublisherById(id));
	}

	@DeleteMapping("/{id}")
	public void deletePublisherById(@PathVariable Integer id) {
		publisherService.deletePublisherById(id);
	}
}