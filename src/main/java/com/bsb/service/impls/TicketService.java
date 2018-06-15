package com.bsb.service.impls;

import com.bsb.common.ResponseCode;
import com.bsb.common.ServerResponse;
import com.bsb.mapper.IScheduleMapper;
import com.bsb.mapper.ITicketMapper;
import com.bsb.pojo.Schedule;
import com.bsb.pojo.Seat;
import com.bsb.pojo.Ticket;
import com.bsb.pojo.User;
import com.bsb.service.ITicketService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TicketService implements ITicketService {

    @Autowired
    private ITicketMapper ticketMapper;
    @Autowired
    private IScheduleMapper scheduleMapper;

    private Logger logger = Logger.getLogger(TicketService.class);

    @Transactional(rollbackFor=Exception.class)
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

    @Transactional(rollbackFor=Exception.class)
    @Override
    public synchronized ServerResponse<String> buyTicket(ArrayList<Seat> seats, User user) {

        Schedule schedule = scheduleMapper.getScheduleById(seats.get(0).getScheduleId());
        if (schedule == null) {
            return ServerResponse.createByErrorMsg("无此演出计划");
        }

        int checkResultCount = 0;
        for (Seat seat : seats) {
            logger.info(schedule.getHallId() +" "+ schedule.getStartTime() +" "+  seat.getRow() +" "+  seat.getColumn());
            checkResultCount = ticketMapper.checkTickets(schedule.getHallId(), schedule.getStartTime(), seat.getRow(), seat.getColumn());
            if (checkResultCount != 0) {
                return ServerResponse.createByErrorCodeMsg(ResponseCode.ALREADY_SOLD.getCode(), "已选择的座位已售出或已被购买");
            }
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
//            用户买票设置type为0
            ticket.setType(0);
            ticket.setUserId(user.getId());
            buyTickets.add(ticket);
        }

        int resultCount = ticketMapper.buyTicket(buyTickets);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("购票失败");
        }

        return ServerResponse.createBySuccessMsg("购票成功!");
    }

    @Transactional(rollbackFor=Exception.class)
    @Override
    public synchronized ServerResponse<String> sellTickets(User user, ArrayList<Seat> seats) {

        Schedule schedule = scheduleMapper.getScheduleById(seats.get(0).getScheduleId());
        if (schedule == null) {
            return ServerResponse.createByErrorMsg("无此演出计划");
        }

        int checkResultCount = 0;
        for (Seat seat : seats) {
            checkResultCount = ticketMapper.checkTickets(schedule.getHallId(), schedule.getStartTime(), seat.getRow(), seat.getColumn());
            if (checkResultCount != 0) {
                return ServerResponse.createByErrorCodeMsg(ResponseCode.ALREADY_SOLD.getCode(), "已选择的座位已售出或已被购买");
            }
        }

        List<Ticket> sellTickets = new ArrayList<>();

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
            ticket.setType(1);
            ticket.setSellerId(user.getId());
            sellTickets.add(ticket);
        }

        int resultCount = ticketMapper.sellTicket(sellTickets);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("售票失败");
        }

        return ServerResponse.createBySuccessMsg("售票成功!");
    }


    @Override
    public ServerResponse<List<Ticket>> getMyTickets(int userId) {

        List<Ticket> tickets = ticketMapper.getMyTickets(userId);
        if (tickets.size() == 0) {
            return ServerResponse.createByErrorMsg("抱歉，暂无订单");
        }

        return ServerResponse.createBySuccess("查询成功", tickets);
    }

    @Transactional(rollbackFor=Exception.class)
    @Override
    public ServerResponse<String> returnTickets(User user, Map<String,List<Integer>> returnTicketsJson) {

        ArrayList<Integer> ticketsIds = (ArrayList<Integer>) returnTicketsJson.get("returnTicketsId");
        for (Integer integer : ticketsIds) {
            logger.info(integer);
        }
        if (ticketsIds == null) {
            return ServerResponse.createByErrorMsg("票务信息为空，退票失败");
        }

        int resultCount = ticketMapper.returnTickets(user.getId(), ticketsIds);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("删除已订票失败");
        }

        return ServerResponse.createBySuccessMsg("退票成功");
    }


}
