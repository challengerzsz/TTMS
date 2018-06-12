package com.bsb.mapper;

import com.bsb.pojo.Ticket;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITicketMapper {

    @Select("SELECT * FROM ticket_table WHERE hallId = #{hallId} AND startTime = #{startTime}")
    List<Ticket> getSelectedTickets(@Param("hallId") int hallId,
                                    @Param("startTime") String startTime);

    int buyTicket(List<Ticket> buyTickets);

    int sellTicket(List<Ticket> sellTickets);

    @Select("SELECT * FROM ticket_table WHERE userId = #{userId}")
    List<Ticket> getMyTickets(int userId);
}
