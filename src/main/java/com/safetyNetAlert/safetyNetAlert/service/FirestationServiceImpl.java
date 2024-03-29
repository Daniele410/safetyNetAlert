package com.safetyNetAlert.safetyNetAlert.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetyNetAlert.safetyNetAlert.model.Firestation;
import com.safetyNetAlert.safetyNetAlert.repository.FirestationRepository;

import exception.FirestationNotFoundException;

@Service
public class FirestationServiceImpl implements IFirestationService {

	static final Logger logger = LogManager.getLogger(FirestationServiceImpl.class);

	@Autowired
	FirestationRepository firestationRepository;

	public FirestationServiceImpl(FirestationRepository firestationRepository) {
		this.firestationRepository = firestationRepository;
	}

	@Override
	public List<Firestation> getFirestations() throws FirestationNotFoundException {
		List<Firestation> firestations = new ArrayList<>();
		firestationRepository.getAllFirestation().forEach(firestations::add);
		if (firestations.isEmpty()) {
			String errorMessage = String.format("%s not found", firestations);
			throw new FirestationNotFoundException(errorMessage);
		}
		return firestations;

	}

	@Override
	public Firestation updateFirestation(Firestation firestation) throws FirestationNotFoundException {
		Firestation firestationToUpdate = firestationRepository.findByAddress(firestation.getAddress());
		if (firestationToUpdate != null) {
			return firestationRepository.updateFirestation(firestation);
		} else
			logger.error("The " + firestation + " is not present");
		throw new FirestationNotFoundException(
				"the " + firestation + " is not update: " + " " + "insert a existing address");
	}

	@Override
	public Firestation addFirestation(Firestation firestation) {
		this.firestationRepository.addFirestation(firestation);
		return firestation;
	}

	@Override
	public Firestation deleteFirestation(Firestation firestation) {
		firestationRepository.deleteFirestation(firestation);
		return null;
	}

	@Override
	public Optional<Firestation> getFirestationsByAddress(String address) {
		return firestationRepository.getFirestationsByAddress(address);
	}

	public List<String> getAddressesCoveredByStationNumber(String station) {
		return firestationRepository.getAddressesCoveredByStationNumber(station);
	}

	public List<Firestation> getFireStationsByStation(String station) {
		return firestationRepository.getFireStationsByStation(station);

	}

}
