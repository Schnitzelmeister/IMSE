<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Website Font style -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

        <!-- Google Fonts -->
        <link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap-tab.js" crossorigin="anonymous" type="text/javascript">
        </script>

        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <jsp:include page="/Online_Shopping_System/WebContent/loaddata/" />
        <title>Kundendaten verwalten</title>
    </head>

    <body>
    
            <nav class="navbar navbar-default" role="navigation">
    	  <div class="container">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-brand-centered">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		    </div>

		    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="navbar-brand-centered">
		      <ul class="nav navbar-nav">
		        <li><a href="/Online_Shopping_System/index.jsp">< Zurück zur Hauptseite</a></li>
		        
                  </ul>
                </li>
		      </ul>
		      <ul class="nav navbar-nav navbar-right">
		        <li><a href="/Online_Shopping_System/logout">Abmelden</a></li>   
		      </ul>
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>
    
        <div class="container">
            <div class="page-header">
                <h1>Kontodaten verwalten</h1>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="panel with-nav-tabs panel-primary">
                        <div class="panel-heading">
                            <ul class="nav nav-tabs">
                                <li class="active"><a href="#tab1primary" data-toggle="tab">Pers&ouml;nliche Informationen</a>
                                </li>

                                <li><a href="#tab2primary" data-toggle="tab">Kreditkartendaten</a>
                                </li>

                                <li><a href="#tab3primary" data-toggle="tab">Rechnungsadresse</a>
                                </li>

                                <li><a href="#tab4primary" data-toggle="tab">Sendungsadresse</a>
                                </li>
                            </ul>
                        </div>
                        <div class="panel-body">
                            <div class="tab-content">
                                <div class="tab-pane fade in active" id="tab1primary">
                                    <form method="POST" action="../../editinfo">
                                        <div class="form-group">
                                            <label for="name" class="cols-sm-2 control-label">Email:</label>
                                            <div class="cols-sm-10">
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="fa fa-envelope-o" aria-hidden="true"></i></span>
                                                    <input type="text" class="form-control" name="email" value="${email}" readonly/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="name" class="cols-sm-2 control-label">Vorname:</label>
                                            <div class="cols-sm-10">
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="fa fa-info-circle" aria-hidden="true"></i></span>
                                                    <input type="text" class="form-control" name="vorname" value="${vorname}" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="name" class="cols-sm-2 control-label">Nachname:</label>
                                            <div class="cols-sm-10">
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="fa fa-info-circle" aria-hidden="true"></i></span>
                                                    <input type="text" class="form-control" name="nachname" value="${nachname}" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="name" class="cols-sm-2 control-label">Telefonnummer:</label>
                                            <div class="cols-sm-10">
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="fa fa-phone" aria-hidden="true"></i></span>
                                                    <input type="text" class="form-control" name="telefonnummer" value="${telefonnummer}" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="name" class="cols-sm-2 control-label">Passwort:</label>
                                            <div class="cols-sm-10">
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="fa fa-key" aria-hidden="true"></i></span>
                                                    <input type="text" class="form-control" name="passwort" value="${passwort}" />
                                                </div>
                                            </div>
                                        </div>
                                        <br />
                                        <label>
                                            <input type="submit" value="Kontodaten aktualisieren" />
                                        </label>
                                        </br>
                                    </form>
                                </div>
                                <div class="tab-pane fade" id="tab2primary">
                                <form method="POST" action="../../updatecreditcard">
                                    <div class="form-group">
                                        <label for="name" class="cols-sm-2 control-label">Kreditkartennummer:</label>
                                        <div class="cols-sm-10">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="fa fa-info" aria-hidden="true"></i></span>
                                                <input type="text" class="form-control" name="kreditkartennr" value="${kreditkartennr}" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="name" class="cols-sm-2 control-label">Vorname:</label>
                                        <div class="cols-sm-10">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="fa fa-info-circle" aria-hidden="true"></i></span>
                                                <input type="text" class="form-control" name="vornamekreditkarte" value="${vornamekreditkarte}" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="name" class="cols-sm-2 control-label">Nachname:</label>
                                        <div class="cols-sm-10">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="fa fa-info-circle" aria-hidden="true"></i></span>
                                                <input type="text" class="form-control" name="nachnamekreditkarte" value="${nachnamekreditkarte}" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="name" class="cols-sm-2 control-label">Typ:</label>
                                        <div class="cols-sm-10">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="fa fa-info" aria-hidden="true"></i></span>
                                                <input type="text" class="form-control" name="typ" value="${typ}" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="name" class="cols-sm-2 control-label">CVV:</label>
                                        <div class="cols-sm-10">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="fa fa-info" aria-hidden="true"></i></span>
                                                <input type="text" class="form-control" name="cvv" value="${cvv}" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="name" class="cols-sm-2 control-label">Gültig bis (Monat):</label>
                                        <div class="cols-sm-10">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="fa fa-calendar-check-o" aria-hidden="true"></i></span>
                                                <input type="text" class="form-control" name="gueltigbismonat" value="${gueltigbismonat}" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="name" class="cols-sm-2 control-label">Gültig bis (Jahr):</label>
                                        <div class="cols-sm-10">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="fa fa-calendar-check-o" aria-hidden="true"></i></span>
                                                <input type="text" class="form-control" name="gueltigbisjahr" value="${gueltigbisjahr}" />
                                            </div>
                                        </div>
                                    </div>

                                    <label>
                                        <input type="submit" value="Kreditkartendaten aktualisieren" />
                                    </label>
                                    </br>
                                    </form>
                                </div>
                                <div class="tab-pane fade" id="tab3primary">
                                    <form method="POST" action="../../updatebilling">
                                        <div class="form-group">
                                            <label for="name" class="cols-sm-2 control-label">Stadt:</label>
                                            <div class="cols-sm-10">
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="fa fa-bank" aria-hidden="true"></i></span>
                                                    <input type="text" class="form-control" name="stadtr" value="${stadtr}" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="name" class="cols-sm-2 control-label">Straßenname:</label>
                                            <div class="cols-sm-10">
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="fa fa-info" aria-hidden="true"></i></span>
                                                    <input type="text" class="form-control" name="strassennamer" value="${strassennamer}" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="name" class="cols-sm-2 control-label">Hausnummer:</label>
                                            <div class="cols-sm-10">
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="fa fa-info" aria-hidden="true"></i></span>
                                                    <input type="text" class="form-control" name="hausnummerr" value="${hausnummerr}" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="name" class="cols-sm-2 control-label">PLZ:</label>
                                            <div class="cols-sm-10">
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="fa fa-info" aria-hidden="true"></i></span>
                                                    <input type="text" class="form-control" name="plzr" value="${plzr}" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="name" class="cols-sm-2 control-label">Land:</label>
                                            <div class="cols-sm-10">
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="fa fa-info" aria-hidden="true"></i></span>
                                                    <input type="text" class="form-control" name="landr" value="${landr}" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="name" class="cols-sm-2 control-label">Zusätzliche Informationen:</label>
                                            <div class="cols-sm-10">
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="fa fa-info" aria-hidden="true"></i></span>
                                                    <input type="text" class="form-control" name="infor" value="${infor}" />
                                                </div>
                                            </div>
                                        </div>

                                        <br />
                                        <label>
                                            <input type="submit" value="Rechnungsadresse aktualisieren" />
                                        </label>
                                        </br>
                                    </form>
                                </div>
                                <div class="tab-pane fade" id="tab4primary">
                                    <form method="POST" action="../../updateshipping">
                                        <div class="form-group">
                                            <label for="name" class="cols-sm-2 control-label">Stadt:</label>
                                            <div class="cols-sm-10">
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="fa fa-bank" aria-hidden="true"></i></span>
                                                    <input type="text" class="form-control" name="stadts" value="${stadts}" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="name" class="cols-sm-2 control-label">Straßenname:</label>
                                            <div class="cols-sm-10">
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="fa fa-info" aria-hidden="true"></i></span>
                                                    <input type="text" class="form-control" name="strassennames" value="${strassennames}" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="name" class="cols-sm-2 control-label">Hausnummer:</label>
                                            <div class="cols-sm-10">
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="fa fa-info" aria-hidden="true"></i></span>
                                                    <input type="text" class="form-control" name="hausnummers" value="${hausnummers}" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="name" class="cols-sm-2 control-label">PLZ:</label>
                                            <div class="cols-sm-10">
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="fa fa-info" aria-hidden="true"></i></span>
                                                    <input type="text" class="form-control" name="plzs" value="${plzs}" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="name" class="cols-sm-2 control-label">Land:</label>
                                            <div class="cols-sm-10">
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="fa fa-info" aria-hidden="true"></i></span>
                                                    <input type="text" class="form-control" name="lands" value="${lands}" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="name" class="cols-sm-2 control-label">Zusätzliche Informationen:</label>
                                            <div class="cols-sm-10">
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="fa fa-info" aria-hidden="true"></i></span>
                                                    <input type="text" class="form-control" name="infos" value="${infos}" />
                                                </div>
                                            </div>
                                        </div>
                                        <br />
                                        <label>
                                            <input type="submit" value="Rechnungsadresse aktualisieren" />
                                        </label>
                                        </br>
                                    </form>
                                </div>


                                <% if (request.getParameter( "errorMessage") !=null) { request.setAttribute( "errorMessage", request.getParameter( "errorMessage")); %>

                                    <div class="alert alert-warning">
                                        <strong> ${errorMessage}</strong>
                                    </div>


                                    <% } %>

                                        <% if (request.getParameter( "infoMessage") !=null) { request.setAttribute( "infoMessage", request.getParameter( "infoMessage")); %>

                                            <div class="alert alert-success">
                                                <strong> ${infoMessage}</strong>
                                            </div>

                                            <% } %>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    </body>

    </html>