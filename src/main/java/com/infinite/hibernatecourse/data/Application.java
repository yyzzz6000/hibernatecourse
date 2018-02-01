package com.infinite.hibernatecourse.data;


import com.infinite.hibernatecourse.data.entities.*;
import org.hibernate.Session;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by yangweny on 28/01/2018.
 */
public class Application {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
//        TimeTest timeTest = new TimeTest(new Date());
//        session.save(timeTest);
//        session.getTransaction().commit();
//        session.refresh(timeTest);
//        System.out.println(timeTest.toString());
        User user = new User("Wenying", "Yang", getMyBirthday(), "yangwenying@gmail.com" );
        user.setCreatedDate(new Date());
        user.setCreatedBy("admin");
        user.setLastUpdatedDate(new Date());
        user.setLastUpdatedBy("admin");
        Address address = new Address();
        address.setAddressLine1("400 Monterey Blvd");
        address.setAddressLine2("Apt 15");
        address.setCity("SF");
        address.setState("CA");
        address.setZipCode("94172");
        address.setAddressType(AddressType.HOME);
        user.getAddresses().add(address);

        Credential credential = new Credential();
        credential.setUser(user);
        credential.setPassword("1qaz2wsx");
        credential.setUsername("yyzzz");

        //user.setCredential(credential);
        session.save(credential);
//        session.getTransaction().commit();
//        session.refresh(user);
//        System.out.print(user.getAge());
////        session.beginTransaction();
//        dbUser.setFirstName("Jane1");
//        dbUser.setCreatedDate(new Date());
//        session.update(dbUser);
//        session.getTransaction().commit();

//        Bank bank = new Bank();
//        bank.setAddressLine1("address1");
//        bank.setAddressLine2("address2");
//        bank.setAddressType("home");
//        bank.setName("SECOND Bank");
//        bank.setCity("SF");
//        bank.setState("CA");
//        bank.setZipCode("90000");
//        bank.setInternational(false);
//        bank.setCreatedBy("Joe");
//        bank.setCreatedDate(new Date());
//        bank.setLastUpdatedBy("Joe");
//        bank.setLastUpdatedDate(new Date());
//        bank.getContacts().put("Manager", "Joe");
//        bank.getContacts().put("TELLER","Tim");
//        session.save(bank);
        session.getTransaction().commit();
        User dbUser = (User) session.get(User.class, credential.getUser().getUserId());
        System.out.println(dbUser.getFirstName());

        session.close();

    }

    public static Date getMyBirthday(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 1982);
        calendar.set(Calendar.MONTH, 8);
        calendar.set(Calendar.DATE, 20);
        return calendar.getTime();
    }
}
