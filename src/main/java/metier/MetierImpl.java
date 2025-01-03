package metier;

import dao.DaoImpl;
import dao.IDao;

public class MetierImpl implements IMetier {
     //    Couplage faible
    private IDao dao ;

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    public MetierImpl() {
    }

    @Override
    public double calcul() {
        double t = dao.getData();
        return t * 23;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
