package com.example.tdd.service;

import java.time.Period;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tdd.model.BookingModel;
import com.example.tdd.repository.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	BookingRepository bookingRepository;
		
	public int daysCalculadorWithDB(String name) {
		Optional<BookingModel> bookingModelOptional = bookingRepository.findByReservedName(name);			
		return Period.between(bookingModelOptional.get().getCheckIn(), bookingModelOptional.get().getCheckOut()).getDays();
	}
}
