package proyectolena.repositorios;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import proyectolena.BDLena.HibernateUtil;
import proyectolena.dominio.TipoArticulo;

public class RepositorioTipoArticulo {

    public void guardar(TipoArticulo tipoArticulo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(tipoArticulo);
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

    public List<TipoArticulo> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List tipoArticulos = session.createCriteria(TipoArticulo.class).list();
        session.close();
        return tipoArticulos;
    }

    public List<TipoArticulo> findByNombre(String nombre) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List tipoArticulos = session.createCriteria(TipoArticulo.class)
                .add(Restrictions.eq("nombre", nombre))
                .list();
        session.close();
        return tipoArticulos;
    }
}
