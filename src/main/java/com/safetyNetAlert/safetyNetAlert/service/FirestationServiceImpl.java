package com.safetyNetAlert.safetyNetAlert.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetyNetAlert.safetyNetAlert.model.Firestation;
import com.safetyNetAlert.safetyNetAlert.repository.FirestationRepository;

@Service
public class FirestationServiceImpl implements IFirestationService{

	@Autowired
	FirestationRepository firestationRepository;
	
	public FirestationServiceImpl(FirestationRepository firestationRepository) {
		this.firestationRepository = firestationRepository;
	}

	@Override
	public List<Firestation> getFirestations() {
		List<Firestation> firestations = new ArrayList<>();
		firestationRepository.getAllFirestation().forEach(firestations::add);
		return firestations;
	}
	
	@Override
	public Firestation updateFirestation(Firestation firestation) {
		firestationRepository.updateFirestation(firestation);
		return null;
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

	

	
	

}