package Service;

import Controller.FileEditController;
import Model.User;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by hadjiszs on 21/10/16.
 */
public class FichierServiceTests {

    private static FileService fileService;

    //private static final Logger LOG = LoggerFactory.getLogger(CategorieDAO.class);

    public FichierServiceTests() {

    }

    @BeforeClass
    public static void setUpClass() {
        APIService.persistance();
        fileService = new FileService();
    }

    @AfterClass
    public static void tearDownClass() {
        APIService.close();
    }

    @Test
    public void testEditFile() throws Exception {
        // @FIXME : remplacer par une vrai adresse mail
        String mail = "testmail";
        // @FIXME : remplacer par un vrai hexaId d'un ObjectID (jgit)
        String id = "fic1";
        String contenue = "nouveau contenue modifie du fichier";

        UserService userService = new UserServiceImpl(APIService.em);
        User u = null;

        try {
            u = userService.getEntityByMail(mail);
        } catch (Exception e) {
            e.printStackTrace();
        }

        fileService.edit(u, id, contenue);

        // @TODO: verification que le fichier a bien été modifié dans la bdd
        // fileService.get(id, machin)
    }

//    @Test
//    public void testToStringFileTree() throws Exception{
//        FolderTraverse ft = new FolderTraverse(new File("src"));
//        Assert.assertNotNull(ft.toString());
//    }
}