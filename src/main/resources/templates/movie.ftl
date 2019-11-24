<#import "parts/common.ftl" as c/>
<@c.page title="Главная страница">
    <div class="container">
        <h1 class="text-center">${movie.getTitle()}</h1>
        <div class="row w-100 mb-3">
            <div class="slider  w-100">
                <div class="fotorama" data-nav="thumbs"
                     data-ratio="21/9"
                     data-fit="cover"
                     data-width="100%">
                    <img src="${movie.getPhotoPath()} " alt="">
                    <iframe allowfullscreen width="100%" height="100%" src="${movie.getVideoPath()}">
                    </iframe>
                </div>
            </div>
        </div>


        <div class="row">
            <div class="col-3">
                <h3>О фильме</h3>
                <p>${movie.getTitle()}</p>
                <p>Country: ${movie.getCountry()}</p>
                <p>Возрастной рейтинг:
                    <#list movie.getAgeRating() as r>
                        <#if r == "over0">
                            Без ограничений
                        </#if>
                        <#if r == "over14">
                            С 14 лет
                        </#if>
                        <#if r == "over16">
                            С 16 лет
                        </#if>
                        <#if r == "over18">
                            С 18 лет
                        </#if>
                    </#list>
                </p>
                <p>Rating: <br>
                    <#list 1..10 as i>
                        <#if movie.getRating() < i>
                            <span class="rating-item fa fa-star"></span>
                        <#else>
                            <span class="rating-item fa fa-star checked"></span>
                        </#if>
                    </#list>
                </p>
                <p>Премьера ${movie.getRealise()?string["dd.MM.yyyy"]}</p>
                <p>Продолжительность ${movie.getDur()} мин.</p>
            </div>
            <div class="col-6">
                <h3>Сюжет</h3>
                <p>${movie.getTitle()}</p>
                <p>${movie.getDescription()}</p>
            </div>

            <div class="col-3">
                <ul class="list-group list-group-flush">
                    <li class="list-group-item"><h3>Режиссёр</h3></li>

                    <#list movie.getAuthors() as a>
                        <li class="list-group-item">${a}</li>
                    </#list>
                </ul>


                <ul class="list-group list-group-flush">
                    <li class="list-group-item"><h3>В ролях</h3></li>

                    <#list movie.getActors() as a>
                        <li class="list-group-item">${a}</li>
                    </#list>
                </ul>
            </div>
        </div>

        <div class="row">
            <h3 class="text-center w-100">Расписание сеансов</h3>
            <div class="row inline-flex mb-3 ml-3 w-100">
                <form class="form-inline my-2 my-lg-0" method="post" action="">
                    <input class="form-control  col-lg-10" hidden name="type" type="text"
                           value="time">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">By Time</button>
                </form>
                <form class="form-inline my-2 my-lg-0" method="post" action="">
                    <input class="form-control  col-lg-10" hidden name="type" type="text"
                           value="name">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">By name</button>
                </form>
                <form class="form-inline my-2 my-lg-0" method="post" action="">
                    <input class="form-control col-lg-10" hidden name="type" type="text"
                           value="language">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">By language</button>
                </form>

                <form class="form-inline my-2 my-lg-0 offset-7" method="post" action="">
                    <input class="form-control col-lg-10" hidden name="type" type="text"
                           value="actual" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Show actual schedule</button>
                </form>

            </div>
            <table class="table  table-hover">
                <thead>
                <tr>
                    <th scope="col">Кинотеатр</th>
                    <th scope="col">Время</th>
                    <th scope="col">Формат</th>
                    <th scope="col">Язык</th>
                    <th scope="col">Взрослый</th>
                    <th scope="col">Детский</th>
                    <th scope="col">Студент.</th>
                    <th scope="col">VIP</th>
                </tr>
                </thead>
                <tbody>
                <#list schedule as s>
                    <tr>
                        <th scope="row">${s.getNameCinema()}</th>
                        <td>${s.getTime()}</td>
                        <td>
                            <#if s.getFormat()?has_content >
                                ${s.getFormat()}
                            <#else >
                                -
                            </#if>
                        </td>
                        <td>
                            <#if s.getLanguage()?has_content >
                                ${s.getLanguage()}
                            <#else >
                                -
                            </#if>
                        </td>
                        <td>
                            <#if s.getCostForAdult()?? >
                                ${s.getCostForAdult()}
                            <#else >
                                -
                            </#if>
                        </td>
                        <td>
                            <#if s.getCostForChild()?? >
                                ${s.getCostForChild()}
                            <#else >
                                -
                            </#if>
                        </td>
                        <td>
                            <#if s.getCostForStudent()?? >
                                ${s.getCostForStudent()}
                            <#else >
                                -
                            </#if>
                        </td>
                        <td>
                            <#if s.getCostForVIP()?? >
                                ${s.getCostForVIP()}
                            <#else >
                                -
                            </#if>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>

        <div class="row">
            <ul class="list-group list-group-flush w-100">
                <li class="list-group-item" style="display: inline-flex;">
                    <h4>Коментарии: </h4>
                    <#if user??>
                        <button type="button" class="btn btn-success ml-4" data-dismiss="modal" data-toggle="modal"
                                data-target="#AddCommentModal">Написать рецензию
                        </button>
                    <#else>
                        <button type="button" class="btn btn-success ml-4" data-dismiss="modal" data-toggle="modal"
                                data-target="#ErrorModal">Написать рецензию
                        </button>
                    </#if>
                </li>
                <#list comment as c>
                    <li class="list-group-item">
                        <div>
                            <h3>${c.getUsr().getUsername()} <small>${c.getDate()?string}</small></h3>
                            <p>${c.getComment()}</p>
                        </div>
                    </li>
                </#list>
            </ul>


        </div>
    </div>
</@c.page>