package DAO;

import Model.Project;
import Model.User;
import Model.UserGrant;
import Model.UserGrantID;
import Util.DataException;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by amaia.nazabal on 10/21/16.
 */
public class UserGrantDAOImpl extends DAO implements UserGrantDAO {

    public boolean addEntity(UserGrant grant) throws DataException {
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(grant);
        getEntityManager().getTransaction().commit();
        closeEntityManager();
        return true;
    }

    public List<UserGrant> getProjectsByEntity(User user) throws DataException {
        List<UserGrant> permissions;

        Query query = getEntityManager().createNamedQuery("findByUser", UserGrant.class);
        query.setParameter("id",user.getId());

        permissions = query.getResultList();
        closeEntityManager();

        return permissions;
    }

    public List getDevelopersByEntity(Long idProject) throws DataException {
        List<UserGrant> list;
        Query query = getEntityManager().createNamedQuery("findProjectsByUserType", UserGrant.class);
        query.setParameter("id", idProject);
        query.setParameter("type", UserGrant.Permis.Dev);

        list = query.getResultList();
        closeEntityManager();

        return list;
    }

    public UserGrant getEntityById(Long idUser, Long idProject) throws DataException {
        UserGrant grant;
        UserGrantID id = new UserGrantID();

        id.setProjectId(idProject);
        id.setUserId(idUser);

        try {
            grant = getEntityManager().find(UserGrant.class, id);
        } catch (Exception e) {
            closeEntityManager();
            throw new DataException("Permis doesn't exists");
        }

        closeEntityManager();
        return grant;
    }

    public UserGrant getAdminByEntity(Long idProject) throws DataException {
        UserGrant userGrant;

        Query query = getEntityManager().createNamedQuery("findProjectsByUserType", UserGrant.class);
        query.setParameter("id", idProject);
        query.setParameter("type", UserGrant.Permis.Admin);

        userGrant = (UserGrant) query.getSingleResult();
        closeEntityManager();

        return userGrant;
    }

    public boolean deleteEntity(UserGrant grant) throws DataException {
        getEntityManager().getTransaction().begin();
        getEntityManager().remove(getEntityManager().contains(grant) ? grant : getEntityManager().merge(grant));
        getEntityManager().getTransaction().commit();

        closeEntityManager();

        return true;
    }
}
