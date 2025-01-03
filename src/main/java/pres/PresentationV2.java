package pres;

import dao.DaoImpl;
import dao.IDao;
import metier.IMetier;
import metier.MetierImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Scanner;


public class PresentationV2 {
    public static void main(String[] args) throws FileNotFoundException {
        try {
//            INSTANCIATION DYNAMIQUE
            Scanner scanner = new Scanner(new File("config.txt"));

//            DaoImpl dao = new DaoImpl(); == 3 lignes den bas
            String daoClassName = scanner.nextLine();
            Class<?> cDao = Class.forName(daoClassName);
            IDao dao = (IDao) cDao.getConstructor().newInstance();
//            System.out.println(dao.getData());

//            MetierImpl metier = new MetierImpl(dao); == 3 lignes den bas
            String metierClassName = scanner.nextLine();
            System.out.println("cMetier: " + metierClassName );
            Class<?> cMetier = Class.forName(metierClassName);
            IMetier metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);

//          metier.setDao
            Method setDaoMethod = cMetier.getMethod("setDao", IDao.class);
            setDaoMethod.invoke(metier,dao);
            System.out.println("La temperature " +metier.calcul());


        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
