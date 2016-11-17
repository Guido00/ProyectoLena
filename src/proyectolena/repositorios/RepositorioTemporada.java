package proyectolena.repositorios;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import proyectolena.BDLena.HibernateUtil;
import proyectolena.dominio.Temporada;

public class RepositorioTemporada {

    public void guardar(Temporada temporada) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(temporada);
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

    public List<Temporada> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List temporadas = session.createCriteria(Temporada.class).list();
        session.close();
        return temporadas;
    }

    public List<Temporada> findByNombre(String nombre) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List temporadas = session.createCriteria(Temporada.class)
                .add(Restrictions.eq("nombre", nombre))
                .list();
        session.close();
        return temporadas;
    }
}
