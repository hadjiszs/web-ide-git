/**
 * Created by thibom on 19/10/16.
 */

/* Faut true si le panel est visible à l'écran */
var derouler = false;

$("#ancrePanel").click(deroulerPanel);

function deroulerPanel(){
    if(!derouler){
        $("#panelDeroulant").animate({
            right: "0px",
        },1000);
        $("#ancrePanel").animate({
            right: "20%",
        },1000);
        derouler = true;
        $("#chevronAncre").toggleClass('glyphicon-chevron-left glyphicon-chevron-right');
    }
    else{
        $("#panelDeroulant").animate({
            right: "-20%",
        },1000);
        $("#ancrePanel").animate({
            right: "0px",
        },1000);
        derouler = false;
        $("#chevronAncre").toggleClass('glyphicon-chevron-left glyphicon-chevron-right');
    }

}


$(document).ready(function() {
    refreshPage();

    /////////////// TEST ////////////////
    // Test création d'un projet

    //var url = "/api/project/add?name=test&version=1&root=/&type=JAVA&user="+ Cookies.get('id');
    //ApiRequest('GET',url,"",addProject);

    /*var url = "/api/project/add?name=salut&version=1&root=/&type=JAVA&user="+ Cookies.get('id');
    ApiRequest('GET',url,"",addProject);*/

    // Liste des projets de l'utilisateur
    //url = "/api/project/getall?idUser=" +  Cookies.get('id');
    //ApiRequest('GET',url,"",listProject);

    //Liste
    $("#deconnexion").on("click", function (e) {
        e.preventDefault();
        deconnexion();
    });

    // Créer un nouveau projet
    $('#modalCreateProjectSubmit').on("click", function (e) {
        e.preventDefault();
        var url = "/api/project/?"+ $("#createProjectForm").serialize() +"&idUser="+ Cookies.get('idUser');
        console.log(url);
        ApiRequest('POST',url,"",addProject);
    });

    // Si on click sur un projet, on ses informations
    $(".userProject-list").on("click", function (e) {
        e.preventDefault();
        alert("get arborescence");
        listBranch($(this).attr("value"));
        listCommit($(this).attr("value"),"master");
        listDeveloppers($(this).attr("value"));
        /*var url = "/git/"+ Cookies.get('idUser') + "/" + $(this).attr("value") + "/branches";
        ApiRequest('GET',url,"",arborescenceAffichage);*/
    });

    //Si on change de branch
    $('#listBranch').on("change", function (e) {
        e.preventDefault();
        console.log($('#listBranch option:selected').val() + " " + $('#listBranch option:selected').text());
        listCommit($('#listBranch option:selected').val(), $('#listBranch option:selected').text());
    });

    //Si on change de commit
    $('#listCommit').on("change",function(e){
        e.preventDefault();
        console.log($('#listCommit option:selected').val() + " " + $('#listCommit option:selected').text());
        getArborescence($('#listCommit option:selected').val(),$('#listCommit option:selected').text());
    });





});

/* Actualise la page */
function refreshPage(){
    listProject();
    listCollarborations();
}

/* Liste les projets d'un utilisateur */
function listProject(){
    url = "/api/permissions/projects/users/" +  Cookies.get('idUser') + "/admin";
    ApiRequest('GET',url,"",function (json){
                console.log("Liste projets: " + JSON.stringify(json));
                $("#listeProjets").empty();

                $.each(json, function(index, element) {

                    $('#listeProjets').append('<a href="#" value="'+ element.idProject +'"class="list-group-item userProject-list">' + element.name +'</a>');
                });
    });
}


function listCollarborations(){
    url = "/api/permissions/projects/users/" +  Cookies.get('idUser') + "/developers";
    ApiRequest('GET',url,"",function (json){
        console.log("Liste collaboration: " + JSON.stringify(json));
        $("#listeCollaborations").empty();

        $.each(json, function(index, element) {

            $('#listeCollaborations').append('<a href="#" value="'+ element.idProject +'"class="list-group-item userProject-list">' + element.name +'</a>');
        });
    });


}

/* Créer un nouveau projet */
function addProject(json){
    console.log("Nouveau projet:" + JSON.stringify(json));
    //console.log(json["id"]);
    $("#listeProjets").append(JSON.stringify(json));
    refreshPage();
}


/* Liste les branches d'un projet*/
function listBranch(idProject){
    var url = "/api/git/"+ Cookies.get('idUser') + "/" + idProject + "/branches";
    ApiRequest('GET',url,"",function(json){
                console.log("Liste des branch de " + idProject + ": " + JSON.stringify(json));
                $.each(json["branches"], function(index, element) {
                    $('#listBranch').append('<option value="'+ idProject+'">' + element.name.substr(element.name.lastIndexOf('/') + 1) + '</option>');
                });
    });
}

function listCommit(idProject,branch){
    var url = "/api/git/"+ Cookies.get('idUser') + "/" + idProject + "/listCommit/" + branch;
    ApiRequest('GET',url,"",function(json){
                    console.log("Liste des commits de " + branch + ": " + JSON.stringify(json));
                    $.each(json["commits"], function(index, element) {
                        $('#listCommit').append('<option value="'+ idProject+'">' + element.id + '</option>');
                    });
            });
}

function getFile(idProject,revision,path){
    var url = "/api/git/"+ Cookies.get('idUser') + "/" + idProject + "/" + revision +"?path=" + path;
    ApiRequest('GET',url,"",function(json){
        console.log("Contenu du fichier " + revision + ": " + JSON.stringify(json));
        $('#openFile').append(json);
    });
}

function getArborescence(idProject,revision){
    var url = "/api/git/"+ Cookies.get('idUser') + "/" + idProject + "/tree/" + revision;
    ApiRequest('GET',url,"",function(json){
        console.log("Arborescence de " + revision + ": " + JSON.stringify(json));
        //$('#commitArbo').append(json);
        $('#commitArbo').tree({
            data: json.root,
            onCreateLi: function(node, $li) {
                    $li.find('.jqtree-title').attr({"path":node.path.replace("root/",""),"revision":revision});
                }
            });
        });
            // Handle a click on the edit link
        $('#commitArbo').on('dblclick', function(e) {
                // Get the id from the 'node-id' data property
                alert($(e.target).attr("path"));
                getFile(idProject,$(e.target).attr("revision"),$(e.target).attr("path"));

            }
        );
}

function listDeveloppers(idProject){
    var url = "/api/permissions/projects/"+ idProject +"/developers";
    ApiRequest('GET',url,"",function(json){
        console.log("List des devs du projets " + idProject + ": " + JSON.stringify(json));
    });
}





