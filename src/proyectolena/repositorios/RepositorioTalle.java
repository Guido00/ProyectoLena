package proyectolena.repositorios;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import proyectolena.BDLena.HibernateUtil;
import proyectolena.dominio.Talle;

public class RepositorioTalle {

    public void guardar(Talle talle) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(talle);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error no se pudo guardar, vuelva a intentarlo", null, JOptionPane.ERROR_MESSAGE);
            }
            throw e;
        } finally {
            session.close();
        }
    }

    public List<Talle> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List talles = session.createCriteria(Talle.class).list();
        session.close();
        return talles;
    }

    public List<Talle> findByNombre(String nombre) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List talles = session.createCriteria(Talle.class)
                .add(Restrictions.eq("nombre", nombre))
                .list();
        session.close();
        return talles;
    }
}
