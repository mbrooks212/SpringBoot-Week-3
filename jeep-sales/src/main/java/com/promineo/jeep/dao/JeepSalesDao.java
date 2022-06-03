package com.promineo.jeep.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;

@Component
public interface JeepSalesDao {
	 List<Jeep> fetchJeeps(JeepModel model, String trim);
}
