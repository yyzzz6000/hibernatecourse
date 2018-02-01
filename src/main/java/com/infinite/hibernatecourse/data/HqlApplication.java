package com.infinite.hibernatecourse.data;

import com.infinite.hibernatecourse.data.entities.Transaction;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by yangweny on 31/01/2018.
 */
public class HqlApplication {
    public static void main(String[] args) {

        SessionFactory factory = null;
        Session session = null;
        org.hibernate.Transaction tx = null;

        try {
            factory = HibernateUtil.getSessionFactory();
            session = factory.openSession();
            tx = session.beginTransaction();

            Query query = session.createQuery("select t.account, t.transactionType " +
                    "from Transaction as t " +
                    "left join t.account account " +
                    "group by t.account, t.transactionType " +
                    "having count(account) >= 2");
            List<Transaction> transactions = query.list();

            for (Transaction t : transactions) {
                System.out.println(t.getTitle());
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            session.close();
            factory.close();
        }
    }

}
