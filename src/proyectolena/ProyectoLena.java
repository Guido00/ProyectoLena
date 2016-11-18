package proyectolena;

import proyectolena.BDLena.HibernateUtil;
import proyectolena.pantallas.IPantallaPrincipal;

public class ProyectoLena {
    public static void main(String[] args) {
        HibernateUtil.inicializar();
        IPantallaPrincipal ipp=new IPantallaPrincipal();
        ipp.setLocationRelativeTo(null);
        ipp.setVisible(true);
    }
    
}
