package com.bsb.mapper;

import com.bsb.pojo.Ticket;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITicketMapper {

    @Select("SELECT * FROM ticket_table WHERE hallId = #{hallId} AND startTime = #{startTime}")
    List<Ticket> getSelectedTickets(int hallId, String startTime);

    int buyTicket(List<Ticket> buyTickets);
}
