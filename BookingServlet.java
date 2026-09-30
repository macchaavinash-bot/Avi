package com.functionhall.servlet;

import com.functionhall.dao.BookingDAO;
import com.functionhall.model.Booking;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/book")
public class BookingServlet extends HttpServlet {

    private final BookingDAO bookingDAO = new BookingDAO();

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Booking booking = new Booking();
        booking.setCustomerName(request.getParameter("customerName"));
        booking.setPhone(request.getParameter("phone"));
        booking.setEmail(request.getParameter("email"));
        booking.setEventType(request.getParameter("eventType"));
        booking.setEventDate(request.getParameter("eventDate"));
        booking.setGuests(Integer.parseInt(request.getParameter("guests")));
        booking.setDecoration(request.getParameter("decoration"));
        booking.setFoodService(request.getParameter("foodService"));
        booking.setFoodItems(request.getParameter("foodItems"));
        booking.setHallName(request.getParameter("hallName"));
        booking.setSpecialRequest(request.getParameter("specialRequest"));

        boolean saved = bookingDAO.saveBooking(booking);

        if (saved) {
            response.sendRedirect("success.html");
        } else {
            response.sendRedirect("index.html?error=booking");
        }
    }
}
