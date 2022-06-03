package com.promineotech.jeep.controller;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.*;
import com.promineotech.JeepSaleApplication;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;
 @SpringBootTest(classes = JeepSaleApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
 @ActiveProfiles("test")
 @Sql(scripts = {
		"classpath:flyway/migrations/v1.0__Jeep_Schema.sql",
		"classpath:flyway/migrations/v1.1__Jeep_Data.sql"},
		config = @SqlConfig(encoding = "utf-8"))
class FetchJeepTest {
	  
	 @Autowired
	 private TestRestTemplate restTemplate;
	 
	 @org.springframework.boot.web.server.LocalServerPort
	  private int serverPort;
	 
	 @Test
	  void testThatJeepsAreReturnedWhenAValidModelAndTrimAreSupplied() {
		JeepModel model = JeepModel.WRANGLER;
		String trim = "Sport";
		String uri = String.format("http://localhost:%d/jeeps?model=%s&trim=%s", serverPort, model, trim);
			ResponseEntity<List<Jeep>> response = 
					restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<>(){});
			assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
			 List<Jeep> expected = buildExpected();
			 assertThat(response.getBody()).isEqualTo(expected);
	 }
	
	 protected List<Jeep> buildExpected(){
		 List<Jeep> list = new LinkedList<>();
		 
		 list.add(Jeep.builder()
				.modelId(JeepModel.WRANGLER)
				.trimLevel("Sport")
				.numDoors(2)
				.wheelSize(17)
				.basePrice(new BigDecimal("28475.00"))
				.build());
		 
		 list.add(Jeep.builder()
					.modelId(JeepModel.WRANGLER)
					.trimLevel("Sport")
					.numDoors(4)
					.wheelSize(17)
					.basePrice(new BigDecimal("31975.00"))
					.build());
		 return list;
		 
		
	 }
	 
	 
}