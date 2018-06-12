package com.bsb.controller;

import com.bsb.common.Const;
import com.bsb.common.ServerResponse;
import com.bsb.pojo.Seat;
import com.bsb.pojo.Ticket;
import com.bsb.pojo.User;
import com.bsb.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/ticket")
public class TicketController {

    @Autowired
    private ITicketService ticketService;

    @GetMapping("/{scheduleId}")
    public ServerResponse<List<Ticket>> getTicketsByScheduleId(@PathVariable("scheduleId") int scheduleId) {
        return ticketService.getTicketsByScheduleId(scheduleId);
    }

    @PostMapping("/buy")
    public ServerResponse<String> buyTicket(HttpSession session,
                                            @RequestBody Map<String,ArrayList<Seat>> seatsJson) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null || user.getType() != 0) {
            return ServerResponse.createByErrorMsg("身份信息验证失败，请重新登录");
        }

        ArrayList<Seat> seats = seatsJson.get("seats");
        if (seats.size() == 0) {
            return ServerResponse.createByErrorMsg("选择座位为空");
        }

        return ticketService.buyTicket(seats, user);

    }

    @PostMapping("/sell")
    public ServerResponse<String> sellTickets(HttpSession session,
                                              @RequestBody Map<String,ArrayList<Seat>> seatsJson) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null || user.getType() != 1) {
            return ServerResponse.createByErrorMsg("未登录，请登录后进行操作");
        }

        ArrayList<Seat> seats = seatsJson.get("seats");
        if (seats.size() == 0) {
            return ServerResponse.createByErrorMsg("选择座位为空");
        }

        return ticketService.sellTickets(user, seats);
    }

    /**
     * 仅由用户操作查询自己的订单
     * @param userId
     * @param session
     * @return
     */
    @GetMapping("/myTickets/{userId}")
    public ServerResponse<List<Ticket>> getMyTickets(@PathVariable("userId") int userId, HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null || user.getType() != 0) {
            return ServerResponse.createByErrorMsg("身份信息验证失败，请重新登录");
        }

        return ticketService.getMyTickets(userId);
    }

}
