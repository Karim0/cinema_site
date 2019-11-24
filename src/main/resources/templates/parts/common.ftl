<#macro page title>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>${title}</title>
        <link rel="stylesheet" href="/css/font-awesome.min.css">
        <link rel="stylesheet" href="/css/animate.css">
        <link href="/css/fotorama.css" rel="stylesheet">
        <link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="/css/style.css" rel="stylesheet" type="text/css">

        <#--        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">-->
        <#--        <link  href="https://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.css" rel="stylesheet">-->
    </head>
    <body>
    <nav id="top_nav" class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="/">
            <img src="/img/logo.png" width="30" height="30" class="d-inline-block align-top"
                 alt="">
            SKcinema
        </a>
        <div class="col-8">
            <form class="form-inline my-2 my-lg-0" method="post" action="/">
                <input class="form-control mr-sm-2 col-lg-10" name="title" type="search" placeholder="Search"
                       aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
        <div class="col">
            <#if user?? >


                <form class="form-inline">
                    <h4>Hi ${user.getUsername()}</h4>
                    <a class="btn btn-outline-success mr-sm-3 ml-sm-3" href="/logout" role="button">Log out</a>
                </form>
            <#else>
                <form class="form-inline">
                    <button type="button" class="btn btn-outline-success mr-sm-3" data-toggle="modal"
                            data-target="#loginModal">Log in
                    </button>
                    <button type="button" class="btn btn-outline-success" data-toggle="modal"
                            data-target="#registrationModal">
                        Registration
                    </button>
                </form>
            </#if>
        </div>

    </nav>
    <div id="header"></div>

    <#nested>

    <footer id="footer" class="footer bg-light pt-4 mt-3">
        <div class="footer-copyright">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 text-center">
                        <p> © 2019 Полное или частичное использование информации с сайта допустимо только с письменного
                            разрешения редакции.
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </footer>


    <!-- Modal -->
    <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
         aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">Login</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">

                    <form id="login_form" method="post" action="/login">
                        <div class="form-group">
                            <label for="inputOrder"></label>
                            <input required type="text" class="form-control" id="inputOrder"
                                   aria-describedby="emailHelp"
                                   placeholder="Enter user name" name="username">
                        </div>
                        <div class="form-group">
                            <input required type="password" class="form-control" id="inputOrder"
                                   aria-describedby="emailHelp"
                                   placeholder="Enter password" name="password">

                            <#--            <input type="hidden" name="_csrf" value="${_csrf.token}"/>-->
                        </div>
                        <#--                        ${csrf_token}-->
                        <input type="hidden" name="next" value="{{ next }}"/>
                    </form>
                </div>
                <div class="modal-footer">
                    <button form="login_form" class="btn btn-success" type="submit" value="login">Login</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="registrationModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
         aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">Registration</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="registration_form" method="post" action="/registration/">
                        <div class="form-group">
                            <label for="inputOrder"></label>
                            <input required type="text" class="form-control" id="inputOrder"
                                   aria-describedby="emailHelp"
                                   placeholder="Enter user name" name="username">
                        </div>
                        <div class="form-group">
                            <input required type="password" class="form-control" id="inputOrder"
                                   aria-describedby="emailHelp"
                                   placeholder="Enter password" name="password">

                            <#--            <input type="hidden" name="_csrf" value="${_csrf.token}"/>-->
                        </div>
                        <#--                        ${csrf_token}-->
                        <input type="hidden" name="next" value="{{ next }}"/>
                    </form>
                </div>
                <div class="modal-footer">
                    <button form="registration_form" class="btn btn-success" type="submit" value="login">Registration
                    </button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="AddCommentModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
         aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">Рецензию</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="comment_form" method="post" action="addComment">
                        <div class="col">
                            <textarea class="w-100" name="comment" placeholder="" id="" rows="10"></textarea>
                        </div>

                        <input type="number" name="id_cinema" hidden value="<#if movie??>${movie.getId()}</#if>">
                        <#--                        {% csrf_token %}-->
                        <input type="hidden" name="next" value="{{ next }}"/>
                    </form>
                </div>
                <div class="modal-footer">
                    <button form="comment_form" class="btn btn-success" type="submit" value="login">Оставить рецензию</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <#--                    {#-->
                    <#--                    <button type="button" class="btn btn-success">Save changes</button>-->
                    <#--                    #}-->
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="ErrorModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
         aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <h3>Вы не авторизованны</h3>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn  btn-success" data-dismiss="modal" data-toggle="modal"
                            data-target="#loginModal">Login
                    </button>
                    <button type="button" class="btn  btn-success" data-dismiss="modal" data-toggle="modal"
                            data-target="#registrationModal">Registration
                    </button>
                    <#--                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>-->
                </div>
            </div>
        </div>
    </div>

    <#--    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>-->
    <#--    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>-->
    <#--    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>-->
    <script src="/js/jquery-3.4.1.js" type="text/javascript"></script>
    <script src="/js/popper.js" type="text/javascript"></script>
    <script src="/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="/js/myJS.js " type="text/javascript"></script>
    <script src="/js/fotorama.js" type="text/javascript"></script>

    </body>
    </html>
</#macro>