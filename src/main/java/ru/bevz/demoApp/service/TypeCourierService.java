package ru.bevz.demoApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bevz.demoApp.repository.TypeCourierRepository;

@Service
public class TypeCourierService {

	@Autowired
	private TypeCourierRepository typeCourierRepository;

	public boolean contains(String nameType) {
		return typeCourierRepository.findByName(nameType) != null;
	}
}
