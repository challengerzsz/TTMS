package com.bsb.service;

import com.bsb.common.ServerResponse;
import com.bsb.pojo.Seat;
import com.bsb.pojo.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ITicketService {

    ServerResponse<List<Ticket>> getTicketsByScheduleId(int scheduleId);

    ServerResponse<String> buyTicket(ArrayList<Seat> seats);
}
