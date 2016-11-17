package Controller;



import Util.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;

/**
 * Created by Mahmoud on 15/11/2016.
 */
@RestController
@RequestMapping("/compile")
public class CompileController {
    private EntityManager entityManager;

    @RequestMapping(value = "/c", produces = "application/json; charset=utf-8")
    public @ResponseBody
    ResponseEntity<String> compile(@RequestParam("currentUser") String currentUser,
                                   @RequestParam("projectName") String projectName  ){

        // On récupère les params
        //cp -rf repositories/nom_propri_project/projectName to compile/currentUser/
        //compile compile/currentUser/projectName
        // rm -rf compile/currentUser/projectName


        try{
            System.out.println("compile");
        }catch(Exception ex){
            return new ResponseEntity<String>(Util.convertToJson(new Status(Constantes.OPERATION_CODE_RATE,
                    ex.getMessage())), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<String>(Util.convertToJson("reponse"), HttpStatus.OK);
    }

}
