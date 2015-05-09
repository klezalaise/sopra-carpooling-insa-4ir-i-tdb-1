# Introduction #

Hibernate simplifies the communication between a Java EE class and a database.


# Mapping #

  * In hibernate.cfg.xml, add your class :
```
<mapping class="MyClass"/>
```

  * In the class, inform the table name corresponding :
```
@Entity
@Table(name="NameofTheTable")
public class MyClass{
```

  * Column/Attribute mapping
```
@Column(name = "nameofCollumn1")
private int attribute1;
@Column(name="nameofCollumn2")
private String attribute2;
@Column(name="nameofCollumn3")
private String attribute3;
```

  * For more specific mapping (ManytoMany, ...), use the tutoriels [here](http://www.mkyong.com/tutorials/hibernate-tutorials/)


## Transactions ##
To save the new data, it is very simple with Hibernate

  * In the DAO class, use :
```
private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
private Session session = sessionFactory.openSession();
```

  * In order to save, use this code :
```
public void register(User user){
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}
```

  * If you want to get all the items from a table :

```

public List<User> getUser(){
		session.beginTransaction();
		Query query = session.createQuery("from covoiturage.beans.User");
		List<User> ul = query.list();

		session.getTransaction().commit();

		return ul;

```

