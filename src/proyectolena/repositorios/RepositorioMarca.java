package proyectolena.repositorios;

import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import proyectolena.BDLena.HibernateUtil;
import proyectolena.dominio.Marca;

public class RepositorioMarca {

    public void guardar(Marca marca) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(marca);
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

    public List<Marca> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List marcas = session.createCriteria(Marca.class).list();
        session.close();
        return marcas;
    }

    public List<Marca> findByNombre(String nombre) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List marcas = session.createCriteria(Marca.class)
                .add(Restrictions.eq("nombre", nombre))
                .list();
        session.close();
        return marcas;
    }
}
