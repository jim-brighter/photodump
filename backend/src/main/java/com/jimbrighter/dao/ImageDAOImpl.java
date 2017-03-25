package com.jimbrighter.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jimbrighter.entity.Image;

@Repository
public class ImageDAOImpl implements ImageDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional(
			isolation = Isolation.READ_COMMITTED,
			propagation = Propagation.REQUIRES_NEW,
			readOnly = true)
	public Image getImage(long id) {
		return sessionFactory.getCurrentSession().get(Image.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(
			isolation = Isolation.READ_COMMITTED,
			propagation = Propagation.REQUIRES_NEW,
			readOnly = true)
	public List<Image> getAllImages() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Image.class);
		return (List<Image>) crit.list();
	}

	@Override
	@Transactional(
			isolation = Isolation.READ_COMMITTED,
			propagation = Propagation.REQUIRES_NEW,
			rollbackFor = Exception.class,
			readOnly = false)
	public boolean createImage(String title, String url, String submitter) {
		Image i = new Image(title, url, submitter);
		try {
			sessionFactory.getCurrentSession().save(i);
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	@Transactional(
			isolation = Isolation.READ_COMMITTED,
			propagation = Propagation.REQUIRES_NEW,
			rollbackFor = Exception.class,
			readOnly = false)
	public boolean deleteImage(long id) {
		Image i = sessionFactory.getCurrentSession().get(Image.class, id);
		try {
			sessionFactory.getCurrentSession().delete(i);
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	@Transactional(
			isolation = Isolation.READ_COMMITTED,
			propagation = Propagation.REQUIRES_NEW,
			rollbackFor = Exception.class,
			readOnly = false)
	public boolean updateImage(Image image) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(image);
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
