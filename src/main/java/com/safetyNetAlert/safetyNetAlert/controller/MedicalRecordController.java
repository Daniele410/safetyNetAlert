package com.safetyNetAlert.safetyNetAlert.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetyNetAlert.safetyNetAlert.model.MedicalRecord;
import com.safetyNetAlert.safetyNetAlert.service.IMedicalRecordService;

@RestController
public class MedicalRecordController {

	private static final Logger logger = LogManager.getLogger("MedicalRecordController");

	@Autowired
	private IMedicalRecordService medicalRecordService;

	/**
	 * Get stored medicalRecord.
	 */
	@GetMapping(value = "/medicalRecord")
	public ResponseEntity<List<MedicalRecord>> getAllMedicalRecords() {
		List<MedicalRecord> medicalRecordsList = medicalRecordService.getMedicalRecords();
		logger.info("GET request for medicalRecord send");
		logger.info("Response for the GET request for medicalRecord: " + medicalRecordsList);
		return new ResponseEntity<>(medicalRecordService.getMedicalRecords(), HttpStatus.OK);
	}

	/**
	 * Adds a new medicalRecord.
	 */
	@PostMapping(value = "/medicalRecord")
	public ResponseEntity<MedicalRecord> addMedicalRecord(@RequestBody MedicalRecord medicalRecord) throws Exception {
		if (medicalRecord.getFirstName() == null || medicalRecord.getFirstName().isEmpty()
				|| medicalRecord.getLastName() == null || medicalRecord.getLastName().isEmpty()) {
			throw new Exception("Bad request : missing or incomplete body request");
		} else {
			medicalRecordService.addMedicalRecord(medicalRecord);
			return new ResponseEntity<>(medicalRecord, HttpStatus.CREATED);
		}
	}

	/**
	 * Update stored medicalRecord.
	 */
	@PutMapping(value = "/medicalRecord")
	public ResponseEntity<MedicalRecord> updateMedicalRecord(@RequestBody MedicalRecord medicalRecord)
			throws Exception {
		if (medicalRecord.getFirstName() == null || medicalRecord.getFirstName().isEmpty()
				|| medicalRecord.getLastName() == null || medicalRecord.getLastName().isEmpty()) {
			throw new Exception("Bad request : missing or incomplete body request");
		} else {
			return new ResponseEntity<>(medicalRecordService.updateMedicalRecord(medicalRecord), HttpStatus.OK);
		}
	}

	/**
	 * Delete stored medicalRecord.
	 */
	@DeleteMapping(value = "/medicalRecord")
	public ResponseEntity<MedicalRecord> deleteMedicalRecord(@RequestBody MedicalRecord medicalRecord)
			throws Exception {
		if (medicalRecord.getFirstName() == null || medicalRecord.getFirstName().trim().length() == 0
				|| medicalRecord.getLastName() == null || medicalRecord.getLastName().trim().length() == 0) {
			throw new Exception("Bad request : missing or incomplete parameter");
		} else {
			return new ResponseEntity<>(medicalRecordService.deleteMedicalRecord(medicalRecord), HttpStatus.OK);
		}
	}

}
