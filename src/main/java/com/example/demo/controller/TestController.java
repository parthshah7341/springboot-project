package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DependentDTO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class TestController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/fetchDetails")
	public List<EmployeeDTO> fetchEmployee(@RequestParam(required = true) String country,
			@RequestParam(required = false) String city) {
		List<Employee> employees = employeeRepository.findByCountry(country);
		List<EmployeeDTO> employeeDTOs = new ArrayList<>();
		if (null != city) {
			employees = employees.stream().filter(e -> city.equalsIgnoreCase(e.getCity())).collect(Collectors.toList());
		}
		employeeDTOs = employees.stream().map(e -> {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			List<DependentDTO> dependentDTOs = e.getDependents().stream().map(d -> {
				DependentDTO dependentDTO = new DependentDTO();
				BeanUtils.copyProperties(d, dependentDTO);
				return dependentDTO;
			}).collect(Collectors.toList());
			BeanUtils.copyProperties(e, employeeDTO);
			employeeDTO.setDependents(dependentDTOs);
			return employeeDTO;
		}).collect(Collectors.toList());
		return employeeDTOs;
	}
}
