package cz.muni.fi.pa165.services;

import cz.muni.fi.pa165.dao.PerformanceDao;
import cz.muni.fi.pa165.dao.TicketDao;
import cz.muni.fi.pa165.dao.UserDao;
import cz.muni.fi.pa165.entity.Performance;
import cz.muni.fi.pa165.entity.Ticket;
import cz.muni.fi.pa165.entity.Users;
import cz.muni.fi.pa165.enums.TicketStatus;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@Service
public class TicketServiceImpl implements TicketService {

    @Inject
    TicketDao ticketDao;

    @Inject
    // FIXME Tomas milestone2 use service when it is implemented
    UserDao userDao;

    @Inject
    // FIXME Tomas milestone2 use service when it is implemented
    PerformanceDao performanceDao;

    @Override
    public List<Ticket> getAll() {
        return ticketDao.findAll();
    }

    @Override
    public Ticket getById(Long id) {
        return ticketDao.findById(id);
    }

    @Override
    public List<Ticket> getByUser(Long id) {
        Users user = userDao.findById(id);
        return ticketDao.findByUser(user);
    }

    @Override
    public Ticket getByBarcode(UUID barcode) {
        return ticketDao.findByBarcode(barcode);
    }

    @Override
    public List<Ticket> getByPerformance(Long id) {
        Performance performance = performanceDao.findById(id);
        return ticketDao.findByPerformance(performance);
    }

    @Override
    public boolean returnTicket(Long id) {
        Ticket ticket = getById(id);
        if (ticket.getStatus().equals(TicketStatus.NOT_USED)) {
            ticket.setStatus(TicketStatus.RETURNED);
            ticketDao.update(ticket);
            return true;
        }
        return false;
    }
}