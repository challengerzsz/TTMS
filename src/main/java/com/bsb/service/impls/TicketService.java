package com.bsb.service.impls;

import com.bsb.common.ServerResponse;
import com.bsb.mapper.IScheduleMapper;
import com.bsb.mapper.ITicketMapper;
import com.bsb.pojo.Schedule;
import com.bsb.pojo.Seat;
import com.bsb.pojo.Ticket;
import com.bsb.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TicketService implements ITicketService {

    @Autowired
    private ITicketMapper ticketMapper;
    @Autowired
    private IScheduleMapper scheduleMapper;

    @Override
    public ServerResponse<List<Ticket>> getTicketsByScheduleId(int scheduleId) {
        Schedule schedule = scheduleMapper.getScheduleById(scheduleId);
        if (schedule == null) {
            return ServerResponse.createByErrorMsg("演出计划不存在");
        }

        List<Ticket> tickets = ticketMapper.getSelectedTickets(schedule.getHallId(), schedule.getStartTime());
        if (tickets.size() == 0) {
            return ServerResponse.createByErrorMsg("无人订座");
        }

        return ServerResponse.createBySuccess("查询成功", tickets);
    }

    @Override
    public ServerResponse<String> buyTicket(ArrayList<Seat> seats) {

        Schedule schedule = scheduleMapper.getScheduleById(seats.get(0).getScheduleId());
        if (schedule == null) {
            return ServerResponse.createByErrorMsg("无此演出计划");
        }

        List<Ticket> buyTickets = new ArrayList<>();

        for (Seat seat : seats) {
            if (seat == null) {
                return ServerResponse.createByErrorMsg("购票失败");
            }

            Ticket ticket = new Ticket();
            ticket.setMovieId(schedule.getMovieId());
            ticket.setHallId(schedule.getHallId());
            ticket.setStartTime(schedule.getStartTime());
            ticket.setSeatRow(seat.getRow());
            ticket.setSeatColumn(seat.getColumn());
            ticket.setTicketPrice(schedule.getPrice());
            buyTickets.add(ticket);
        }

        int resultCount = ticketMapper.buyTicket(buyTickets);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("购票失败");
        }

        return ServerResponse.createBySuccessMsg("购票成功!");
    }
}
