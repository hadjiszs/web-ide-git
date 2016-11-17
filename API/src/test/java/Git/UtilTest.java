package Git;

import org.junit.*;
import static org.junit.Assert.*;

import javax.json.JsonObject;


/**
 * Created by p1317074 on 15/11/16.
 */
public class UtilTest {

    private static final String REMOTE_URL = "https://github.com/hadjiszs/Interpolation.git";
    private static final String USER = "userTest";
    private static final String DIR_NAME = "TestGitRepository";

    @BeforeClass
    public static void init() throws Exception {
        System.out.println("-- Clone du dépôt : " + REMOTE_URL);
        Util.cloneRemoteRepo(USER, DIR_NAME, REMOTE_URL);
    }

    @AfterClass
    public static void end() throws Exception {
        System.out.println("-- Suppression du dépôt ; fin tests");

        Util.deleteRepository(USER, DIR_NAME);
    }

    @Test
    public void testGetArborescence() throws Exception {
        // Creation of the JsonObject for the new repository

        // Recuperation de l'aborescence associé au commit de la revision suivante
        String revision = "70ad3b45d04d53ad77f0444a3cc9e33e657e9779";

        JsonObject object = Util.getArborescence(USER, DIR_NAME, revision);
        System.out.println(object.toString());

        assertNotNull("dsd", object);
    }

    @Test
    public void testGetContent() throws Exception {
        Util.cloneRemoteRepo(USER, DIR_NAME, REMOTE_URL);

        //Recuperation du contenu d'un fichier pour une certaine révision

        String revision = "70ad3b45d04d53ad77f0444a3cc9e33e657e9779";
        String path = "src/CMakeLists.txt";
        JsonObject content = Util.getContent(USER, DIR_NAME, revision, path);

        //assertNotNull(content);
        System.out.println(content);
        Boolean test = Util.deleteRepository(USER, DIR_NAME);
        assertTrue(test);
    }

//    @Test
//    public void testCreateBranch() throws Exception {
//        Util.cloneRemoteRepo("userTest", "TestGitRepository.git", REMOTE_URL);
//
//        // Creation d'une branche
//        JsonObject content =
//                    Util.createBranch("userTest",
//                                      "TestGitRepository.git",
//                                      "f7ef6d9d3d5ad33656aaa2996272f686e7fd485c", "src/CMakeLists.txt");
//        assertNotNull(content);
//        System.out.println(content);
//        Boolean test = Util.deleteRepository("userTest", "TestGitRepository.git");
//        assertTrue(test);
//    }

}