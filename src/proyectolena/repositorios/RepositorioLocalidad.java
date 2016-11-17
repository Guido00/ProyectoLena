package proyectolena.repositorios;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import proyectolena.BDLena.HibernateUtil;
import proyectolena.dominio.Localidad;

public class RepositorioLocalidad {
    public void guardar(Localidad localidad) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(localidad);
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

    public List<Localidad> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List localidades = session.createCriteria(Localidad.class).list();
        session.close();
        return localidades;
    }

    public List<Localidad> findByNombre(String nombre) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List localidads = session.createCriteria(Localidad.class)
                .add(Restrictions.eq("nombre", nombre))
                .list();
        session.close();
        return localidads;
    }
}
