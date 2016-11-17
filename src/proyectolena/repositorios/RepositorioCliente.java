package proyectolena.repositorios;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import proyectolena.BDLena.HibernateUtil;
import proyectolena.dominio.Cliente;

public class RepositorioCliente {
    
    public void guardar(Cliente cliente) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(cliente);
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

    public List<Cliente> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List clientes = session.createCriteria(Cliente.class).list();
        session.close();
        return clientes;
    }

    public List<Cliente> findByNombre(String nombre) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List clientes = session.createCriteria(Cliente.class)
                .add(Restrictions.eq("nombre", nombre))
                .list();
        session.close();
        return clientes;
    }
    public List<Cliente> findByApellido(String apellido) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List clientes = session.createCriteria(Cliente.class)
                .add(Restrictions.eq("apellido", apellido))
                .list();
        session.close();
        return clientes;
    }
    public List<Cliente> findByTelefono(String telefono) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List clientes = session.createCriteria(Cliente.class)
                .add(Restrictions.eq("telefono", telefono))
                .list();
        session.close();
        return clientes;
    }
}
