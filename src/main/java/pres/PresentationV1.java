package pres;

import dao.DaoImpl;
import ext.DaoImplV2;
import metier.MetierImpl;

public class PresentationV1 {
    public static void main(String[] args) {
        /*
        Injection de dependances par instanciation statique
         */
        DaoImplV2 dao = new DaoImplV2();
        MetierImpl metier = new MetierImpl(dao); // Injection de dependances via le constructeur
//         metier.setDao(dao);
        System.out.println("Results "+metier.calcul());
    }
}
