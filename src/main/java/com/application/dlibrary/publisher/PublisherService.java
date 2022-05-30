package com.application.dlibrary.publisher;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

	@Autowired
	PublisherRepository publisherRepository;

	public Publisher createPublisher(Publisher publisher) {
		return publisherRepository.saveAndFlush(publisher);
	}

	public List<Publisher> getAllPublisher() {
		return publisherRepository.findAll();
	}

	public Publisher getPublisherById(Integer id) {
		Optional<Publisher> publisherOpt = publisherRepository.findById(id);
		if (publisherOpt.isPresent()) {
			return publisherOpt.get();
		}
		return null;
	}

	public void deletePublisherById(Integer id) {
		publisherRepository.deleteById(id);
	}

}