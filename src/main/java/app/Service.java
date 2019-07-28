package app;

import java.util.List;

public class Service {

    private DAO dao = new DAO();

    public String getConcreteUser(int id) {
        return dao.getUserInformation(id);
    }

    public List getListOfAccounts() {
        return dao.getListOfAccounts();
    }
}