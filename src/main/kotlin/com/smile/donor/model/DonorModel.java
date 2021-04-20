package com.smile.donor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonorModel {


private int id;

private String name;

private String description;

private String imageUrl;

private double amount;
	
}
