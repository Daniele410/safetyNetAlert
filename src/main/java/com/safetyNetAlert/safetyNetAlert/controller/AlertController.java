package com.safetyNetAlert.safetyNetAlert.controller;

import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetyNetAlert.safetyNetAlert.dto.ChildDto;
import com.safetyNetAlert.safetyNetAlert.dto.FloodDto;
import com.safetyNetAlert.safetyNetAlert.dto.PersonAtAddressDto;
import com.safetyNetAlert.safetyNetAlert.dto.PersonInfoDto;
import com.safetyNetAlert.safetyNetAlert.dto.PersonLightDto;
import com.safetyNetAlert.safetyNetAlert.service.IAlertService;

@RestController
public class AlertController {

	static final Logger logger = LogManager.getLogger(PersonController.class);

	@Autowired
	private IAlertService alertService;

	@GetMapping(value = "/communityEmail")
	public ResponseEntity<List<String>> getCommunityEmail(@RequestParam String city) {
		if (city.isBlank()) {
			logger.error("email is blank");
			return new ResponseEntity<List<String>>(HttpStatus.NOT_FOUND);
		} else {
			logger.info("List of communityEmail generated");
			return new ResponseEntity<>(alertService.getCommunityEmail(city), HttpStatus.OK);
		}
	}

	@GetMapping(value = "/personInfo")
	public ResponseEntity<List<PersonInfoDto>> getPersonInfo(@RequestParam String lastName) {
		if (lastName.isBlank()) {
			logger.error("Firstname or Lastname blank");
			return new ResponseEntity<List<PersonInfoDto>>(HttpStatus.NOT_FOUND);
		} else {
			logger.info("List of Person generated");
			return new ResponseEntity<List<PersonInfoDto>>(alertService.getPersonInfo(lastName), HttpStatus.OK);
		}
	}

	@GetMapping(value = "/childAlert")
	public ResponseEntity<List<ChildDto>> getChildDto(@RequestParam String address) {
		if (address.isBlank()) {
			logger.error("address is blank");
			return new ResponseEntity<List<ChildDto>>(HttpStatus.NOT_FOUND);
		} else {
			logger.info("List of childAddress generated");
			return new ResponseEntity<List<ChildDto>>(alertService.getChildDto(address), HttpStatus.OK);
		}
	}

	@GetMapping(value = "/phoneAlert")
	public ResponseEntity<Set<String>> getPersonsPhoneNumberByStation(@RequestParam String firestation) {
		if (firestation.isBlank()) {
			logger.error("Station number is blank");
			return new ResponseEntity<Set<String>>(HttpStatus.NOT_FOUND);
		} else {
			logger.info("List of PhoneAlert By Station number generated");
			return new ResponseEntity<Set<String>>(alertService.getPersonsPhoneNumberByStation(firestation),
					HttpStatus.OK);
		}

	}

	@GetMapping(value = "/fire")
	public ResponseEntity<List<PersonAtAddressDto>> getPersonsByAddressFromListOfStationNumber(
			@RequestParam String address) {
		if (address.isBlank()) {
			logger.error("address is blank");
			return new ResponseEntity<List<PersonAtAddressDto>>(HttpStatus.NOT_FOUND);
		} else {
			logger.info("List of persons By Station address generated");
			return new ResponseEntity<List<PersonAtAddressDto>>(
					alertService.getPersonsByAddressFromListOfStationNumber(address), HttpStatus.OK);
		}
	}

	@GetMapping(value = "/flood/stations")
	public ResponseEntity<List<FloodDto>> getPersonsBySameAddress(@RequestParam(value = "stations") String station) {
		if (station.isBlank()) {
			logger.error("station is blank");
			return new ResponseEntity<List<FloodDto>>(HttpStatus.NOT_FOUND);
		} else {
			logger.info("List of persons By Station address generated");
			return new ResponseEntity<List<FloodDto>>(alertService.getPersonsBySameAddress(station), HttpStatus.OK);
		}
	}

	@GetMapping(value = "/firestations")
	public ResponseEntity<List<PersonLightDto>> getPersonsCoveredByStationNumberWithCountAdultAndChilds(
			@RequestParam(value = "stationsNumber") String station) {
		if (station.isBlank()) {
			logger.error("station number is blank");
			return new ResponseEntity<List<PersonLightDto>>(HttpStatus.NOT_FOUND);
		} else {
			logger.info("List of persons By Station address generated");
			return new ResponseEntity<List<PersonLightDto>>(
					alertService.getPersonsCoveredByStationNumberWithCountAdultAndChilds(station), HttpStatus.OK);
		}
	}

}
