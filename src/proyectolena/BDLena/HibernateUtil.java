package proyectolena.BDLena;

import javax.swing.JOptionPane;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static ServiceRegistry standardRegistry;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory != null) {
        } else {
            inicializar();
        }
        return sessionFactory;
    }

    public static void finalizar() {
        try {
            sessionFactory.close();
            StandardServiceRegistryBuilder.destroy(standardRegistry);
        } catch (java.lang.NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Debe abrir una session primero para poder cerrarla");
        }
    }

    public static void inicializar() {
        Configuration conf = new Configuration()
                .setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
                .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
                .setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/ProyectoLena")
                .setProperty("hibernate.connection.username", "postgres")
                .setProperty("hibernate.connection.password", "1234")
                .setProperty("hibernate.connection.pool_size", "10")
                .setProperty("hibernate.hbm2ddl.auto", "update")
                .addPackage("hibernate2.dominio")
                .addAnnotatedClass(proyectolena.dominio.Articulo.class)
                .addAnnotatedClass(proyectolena.dominio.Color.class)
                .addAnnotatedClass(proyectolena.dominio.DefArticulo.class)
                .addAnnotatedClass(proyectolena.dominio.Marca.class)
                .addAnnotatedClass(proyectolena.dominio.Stock.class)
                .addAnnotatedClass(proyectolena.dominio.Talle.class)
                .addAnnotatedClass(proyectolena.dominio.Temporada.class)
                .addAnnotatedClass(proyectolena.dominio.TipoArticulo.class)
                .addAnnotatedClass(proyectolena.dominio.Cliente.class)
                .addAnnotatedClass(proyectolena.dominio.Localidad.class);

        standardRegistry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();

        sessionFactory = conf.buildSessionFactory(standardRegistry);
    }

}
