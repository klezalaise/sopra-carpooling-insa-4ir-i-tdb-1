package com.sopride.dao;

import java.sql.Time;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sopride.core.beans.AddressBE;
import com.sopride.core.beans.RideInfoBE;
import com.sopride.core.beans.UserBE;
import com.sopride.core.beans.WorkdayBE;
import com.sopride.core.beans.WorkplaceBE;

public class RideInfoDAO {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private Session session = sessionFactory.openSession();
	private static RideInfoDAO instance;
	
	private RideInfoDAO() {		
	}
	
	public static RideInfoDAO getInstance(){
		if(instance==null){
			instance=new RideInfoDAO();
		}
		return instance;
	}
	
	public void registerRideInfo(RideInfoBE rideinfo){
		session.beginTransaction();
		session.save(rideinfo);
		session.getTransaction().commit();
	}
	
	public RideInfoBE getRideInfo(int id){
		session.beginTransaction();
		RideInfoBE rideinfo = (RideInfoBE) session.load(RideInfoBE.class, id);
		session.getTransaction().commit();
		return rideinfo;
	}
	
	public static void main(String[] argc){
		RideInfoBE rideinfo = RideInfoDAO.getInstance().getRideInfo(2);
	}
	

}
