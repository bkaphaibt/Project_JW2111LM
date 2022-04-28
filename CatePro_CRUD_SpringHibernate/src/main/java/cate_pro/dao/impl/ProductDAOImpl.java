package cate_pro.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cate_pro.dao.ProductDAO;
import cate_pro.entities.Product;

@Repository
public class ProductDAOImpl implements ProductDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Product> getListProducts() {
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("from Product").list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean insertProduct(Product pro) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(pro);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}

}
