package com.smile.donor.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.smile.donor.model.DonorModel;

@RestController
@RequestMapping("/donors")
@CrossOrigin(origins = "*")
public class DonorController {
   String url1="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRxxhn8xHYZzpjjeI7tGNKNIct8EGQdV_Yn0g&usqp=CAU";
   String url2="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRklu4cpv3tSlMs7SawV2LGI6fW96mX3bht1g&usqp=CAU";
	List<DonorModel> donors = Arrays.asList(new DonorModel(1,
					"Hector Juarez",
					"Rita and her family have incurred significant fees due to a life-threatening surgery complication", url1, 12.0),
			new DonorModel(2, "Amy Taylor", "My boys are in need of assistance bills", url2, 9.0));

	@Autowired
	RestTemplate restTemplate;


	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getDonor() {
		DonorModel donorModel = new DonorModel();

		return new ResponseEntity<>(donors, HttpStatus.OK);

	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getDonorById(@PathVariable int id){

		return  ResponseEntity.ok().body(donors.stream().filter(d->d.getId()==id).findFirst().orElse(new DonorModel()));
	}


}
