package proyectolena.repositorios;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import proyectolena.BDLena.HibernateUtil;
import proyectolena.dominio.Color;

public class RepositorioColor {

    public void guardar(Color color) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(color);
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

    public List<Color> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List colors = session.createCriteria(Color.class).list();
        session.close();
        return colors;
    }

    public List<Color> findByNombre(String nombre) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List colors = session.createCriteria(Color.class)
                .add(Restrictions.eq("nombre", nombre))
                .list();
        session.close();
        return colors;
    }
}
