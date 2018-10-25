package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.*;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Implementation of DAO for Booking entity
 * @author Tomas Rudolf
 */
@Repository
public class BookingDaoImpl implements BookingDao {

    /** Start of selection query */
    private static final String SELECT_QUERY = "SELECT b from " + Booking.TABLE_NAME;

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(Booking booking) {
        em.persist(booking);
    }

    @Override
    public Booking findById(Long id) {
        return em.createQuery(SELECT_QUERY + " where id = :id", Booking.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<Booking> findAll() {
        return em.createQuery(SELECT_QUERY, Booking.class)
                .getResultList();
    }

    @Override
    public Booking findByTicket(Ticket ticket) {
        return em.createQuery(SELECT_QUERY + " WHERE ticket = :ticket", Booking.class)
                .setParameter("ticket", ticket)
                .getSingleResult();
    }

    @Override
    public List<Booking> findByPaymentStatus(PaymentStatus paymentStatus) {
        return em.createQuery(SELECT_QUERY + " WHERE paymentStatus = :paymentStatus", Booking.class)
                .setParameter("paymentStatus", paymentStatus)
                .getResultList();
    }

    @Override
    public List<Booking> findByCreationDate(LocalDate creationDate) {
        return em.createQuery(SELECT_QUERY + " WHERE createdAt = :creationDate", Booking.class)
                .setParameter("creationDate", creationDate)
                .getResultList();
    }

    @Override
    public List<Booking> findByUpdateDate(LocalDate updateDate) {
        return em.createQuery(SELECT_QUERY + " WHERE updatedAt = :updateDate", Booking.class)
                .setParameter("updateDate", updateDate)
                .getResultList();
    }

    // FIXME Tomas milestone1 - Uncomment after classes are in repository
    /*@Override
    public List<Booking> findByPerformance(Performance performance) {
        return em.createQuery(SELECT_QUERY + " WHERE performance = :performance", Booking.class)
                .setParameter("performance", performance)
                .getResultList();
    }

    @Override
    public List<Booking> findByUser(User user) {
        return em.createQuery(SELECT_QUERY + " WHERE user = :user", Booking.class)
                .setParameter("user", user)
                .getResultList();
    }*/

    @Override
    public void update(Booking booking) {
        em.merge(booking);
    }

    @Override
    public void delete(Booking booking) {
        em.remove(booking);
    }
}
