package com.bsb.service;

import com.bsb.common.ServerResponse;
import com.bsb.pojo.Seat;
import com.bsb.pojo.Ticket;
import com.bsb.pojo.User;

import java.util.ArrayList;
import java.util.List;

public interface ITicketService {

    ServerResponse<List<Ticket>> getTicketsByScheduleId(int scheduleId);

    ServerResponse<String> buyTicket(ArrayList<Seat> seats, User user);

    ServerResponse<String> sellTickets(User user, ArrayList<Seat> seats);

    ServerResponse<List<Ticket>> getMyTickets(int userId);
}
