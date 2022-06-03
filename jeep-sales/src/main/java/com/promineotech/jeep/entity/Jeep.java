package com.promineotech.jeep.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Jeep {

	@JsonIgnore
	public Long getModelPK() {
		return modelPK;
	}
	
	  private Long modelPK;
	  private JeepModel modelId;
	  private String trimLevel;
	  private int numDoors;
	  private int wheelSize;
	  private BigDecimal basePrice;

}
