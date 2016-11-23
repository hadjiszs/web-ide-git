/* Liste les branches d'un projet*/
function listBranch(idProject){
    var url = "/api/git/"+ Cookies.get('idUser') + "/" + idProject + "/branches";
    ApiRequest('GET',url,"",function(json){
        if(json == null){
            BootstrapDialog.show({
                title: 'Branches',
                message: 'Impossible de récupérer la liste des branches du projets',
                type: BootstrapDialog.TYPE_DANGER,
                closable: true,
                draggable: true
            });
        }else{
            console.log("Liste des branch de " + idProject + ": " + JSON.stringify(json));
            $.each(json["branches"], function(index, element) {
                $('#listBranch').append('<option value="'+ idProject+'">' + element.name.substr(element.name.lastIndexOf('/') + 1) + '</option>');
            });
        }
    });
}

/* Liste des commits */
function listCommit(idProject,branch){
    var url = "/api/git/"+ Cookies.get('idUser') + "/" + idProject + "/listCommit/" + branch;
    ApiRequest('GET',url,"",function(json){
        if(json == null){
            BootstrapDialog.show({
                title: 'Commits',
                message: 'Impossible de récupérer la liste des commits de la branche',
                type: BootstrapDialog.TYPE_DANGER,
                closable: true,
                draggable: true
            });
        }else{
            console.log("Liste des commits de " + branch + ": " + JSON.stringify(json));
            $.each(json["commits"], function(index, element) {
                $('#listCommit').append('<option value="'+ idProject+'">' + element.id + '</option>');
            });
        }
    });
}

/* Récupère le contenu d'un fichier */
function getFile(idProject,revision,path){
    var url = "/api/git/"+ Cookies.get('idUser') + "/" + idProject + "/" + revision +"?path=" + path;
    ApiRequest('GET',url,"",function(json){
        if(json == null){
            BootstrapDialog.show({
                title: 'Fichier',
                message: 'Impossible de récupérer le contenu du fichier',
                type: BootstrapDialog.TYPE_DANGER,
                closable: true,
                draggable: true
            });
        }else{
            console.log("Contenu du fichier " + revision + ": " + JSON.stringify(json));
            $('#openFile').append(json);
        }
    });
}

/* Récupère l'arborescence du commit courant */
function getArborescence(idProject,revision){
    var url = "/api/git/"+ Cookies.get('idUser') + "/" + idProject + "/tree/" + revision;
    ApiRequest('GET',url,"",function(json){
        if(json == null){
            BootstrapDialog.show({
                title: 'Arborescence',
                message: 'Impossible de récupérer l\'arborescence du commit',
                type: BootstrapDialog.TYPE_DANGER,
                closable: true,
                draggable: true
            });
        }else{
            console.log("Arborescence de " + revision + ": " + JSON.stringify(json));
            $('#commitArbo').tree({
                data: json.root,
                onCreateLi: function(node, $li) {
                    $li.find('.jqtree-title').attr({"path":node.path.replace("root/",""),"revision":revision});
                }
            });
            // Handle a click on the edit link
            $('#commitArbo').on('dblclick', function(e) {
                    // Get the id from the 'node-id' data property
                    alert($(e.target).attr("path"));
                    getFile(idProject,$(e.target).attr("revision"),$(e.target).attr("path"));

                }
            );
        }
    });

}

function createFile(){

}

function makeCommit(){

}

function createDir(){

}

function createBranch(){

}