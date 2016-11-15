package Service;

import DAO.UserDAO;
import DAO.UserDAOImp;
import Model.User;
import Util.DataException;

import java.util.List;

/**
 * Created by amaia.nazabal on 10/19/16.
 */
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    public UserServiceImpl(){
        userDAO = new UserDAOImp(APIService.em);
    }

    public Long addEntity(String pseudo, String mail, String hashkey) throws DataException {
        User user = new User(pseudo, mail, hashkey);
        return userDAO.addEntity(user);
    }

    public User getEntityByMail(String mail) throws DataException {
        return userDAO.getEntityByMail(mail);
    }

    public List getEntityList() throws Exception {
        return userDAO.getEntityList();
    }

    public boolean deleteEntity(String mail) throws Exception {
        return userDAO.deleteEntity(mail);
    }

}
