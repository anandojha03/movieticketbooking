package com.example.movieticketbooking.controllers;
import com.example.movieticketbooking.models.Booking;
import com.example.movieticketbooking.models.BookingData;
import com.example.movieticketbooking.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    private final BookingService bookingService;

    @Autowired
    public CheckoutController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public String checkoutPage() throws IOException {
        ClassPathResource resource = new ClassPathResource("static/frontend/checkout.html");
        return StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
    }


    @PostMapping
    public void checkout(@RequestBody BookingData bookingData) throws IOException {
        // Add code to process the bookingData and handle the checkout operation


        try {

            String seats = bookingData.getSelectedSeats().toString();

            Booking booking = new Booking(bookingData.getTotalPrice(),
                    seats,
                    bookingData.getMovieId(),
                    bookingData.getMovieName(),
                    bookingData.getDateTime(),
                    bookingData.getShowTime(),
                    bookingData.getUserId());
            bookingService.createBooking(booking);
            System.out.println("Booking Created" + bookingData);

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error creating Booking.");
        }



    }
}

