package processing.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.Transaction;

import processing.entity.EventEntity;
import processing.model.Event;
import processing.util.HibernateUtil;

public class EventDaoImpl implements EventDao {

    @Override
    public void saveAllEvents(List<Event> eventList) {
	// TODO - create EventServcie
	// TODO - custom mapper/orika etc.
	List<EventEntity> eventEntityList = eventList.stream()
		.map(e -> new EventEntity(e.getId(), e.isAlert(), e.getType(), e.getHost(), e.getDuration()))
		.collect(Collectors.toList());
	Transaction transaction = null;
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	    transaction = session.beginTransaction();
	    eventEntityList.forEach(e -> session.persist(e));
	    transaction.commit();
	} catch (Exception e) {
	    if (transaction != null) {
		transaction.rollback();
	    }
	    // TODO - handling
	    e.printStackTrace();
	}
    }

    public List<EventEntity> findAll() {

	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	    return session.createQuery("SELECT e FROM EventEntity e", EventEntity.class).getResultList();
	}
    }

    public void clearDb() {

	Transaction transaction = null;
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	    transaction = session.beginTransaction();
	    session.createQuery("DELETE FROM EventEntity e").executeUpdate();
	    transaction.commit();
	} catch (Exception e) {
	    if (transaction != null) {
		transaction.rollback();
	    }
	    // TODO - handling
	    e.printStackTrace();
	}
    }
}