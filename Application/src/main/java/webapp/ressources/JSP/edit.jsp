<%--
  Created by IntelliJ IDEA.
  User: thibom
  Date: 20/10/16
  Time: 06:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Projet MULTIMIF - Edition</title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../CSS/edit.css">
        <!--[if lt IE 9]>
        <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

<<<<<<< local
        <script src="../../codeMirror/lib/codemirror.js"></script>
        <link rel="stylesheet" href="../../codeMirror/lib/codemirror.css">
        <link rel="stylesheet" href="../../codeMirror/theme/dracula.css">
        <link rel="stylesheet" href="../../codeMirror/theme/night.css">
        <script src="../../codeMirror/mode/clike/clike.js"></script>
=======
        <script src="../../ace-builds-master/src-min-noconflict/ace.js" type="text/javascript"></script>
>>>>>>> other
    </head>
    <body>
        <header>
            <nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
                <div class="container-fluid">
                    <!-- Pour navigation mobile -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div>

                    <!-- Pour navigation ordinateur -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li><a href="home.jsp">Home</a></li>
                            <li><a href="#">Projet</a></li>
                            <li class="active"><a href="edit.jsp">Edition</a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="#">Deconnexion</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
        <main class="container">
            <aside class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <select id="changerTheme">
                        <option value="1">Dracula</option>
                        <option value="2" selected="selected">Night</option>
                        <option value="3">solarized_light</option>
                    </select>
                </div>
            </aside>

            <section class="row">
                    <div class="col-lg-8 col-lg-offset-2" id="editeurJava">
                        <pre id="editor"></pre>
                    </div>
            </section>
            <a id="ancrePanelDroite" aria-label="Panel deroulant">
                <span class="glyphicon glyphicon-chevron-left" id="chevronAncreDroite" aria-hidden="true"></span>
            </a>

            <section id="panelDroite">
                <p> BLABLABLA </p>
                <p> BLABLABLA </p>
                <p> BLABLABLA </p>
            </section>

            <a id="ancrePanelGauche" aria-label="Panel deroulant">
                <span class="glyphicon glyphicon-chevron-right" id="chevronAncreGauche" aria-hidden="true"></span>
            </a>

            <section id="panelGauche">
                <p> BLABLABLA </p>
                <p> BLABLABLA </p>
                <p> BLABLABLA </p>
            </section>
        </main>
        <script async src="../JS/edit.js"></script>
    </body>
</html>






