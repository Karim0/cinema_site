<#import "parts/common.ftl" as c/>
<@c.page title="Главная страница">
    <div class="container">
        <div class="row">
            <div class="col-9">
                <#list movies as m>
                    <div class="row bg-light mt-3 p-3">
                        <div class="col-4">
                            <div>
                                <img class="w-100" src="${m.getPhotoPath()}" alt="">
                            </div>
                        </div>
                        <div class="col-8">
                            <div class="row">
                                <a class="text-center h3" href="movie/${m.getId()}">${m.getTitle()}</a>
                            </div>
                            <div class="row">
                                <p>
                                    <#list m.getCategory() as c>
                                        ${c.getName()}
                                    </#list>
                                </p>
                                <#--                                <div class="col-8">-->
                                <p>${m.getDescription()}</p>
                                <#--                                </div>-->
                                <#--                                <div class="col-4">-->
                                <#--                                    <ul>-->
                                <#--                                        <#list m.getActors() as a>-->
                                <#--                                            <li>${a}</li>-->
                                <#--                                        </#list>-->
                                <#--                                    </ul>-->
                                <#--                                </div>-->
                                <p>Возрастной рейтинг:
                                    <#list m.getAgeRating() as r>
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
                            </div>

                        </div>
                    </div>
                </#list>
            </div>

            <div class="col-3">
                <ul class="list-group list-group-flush">
                    <#if premiere??>
                    <li class="list-group-item"><h3>Премьеры: </h3></li>
                    <#list premiere as p>

                    <li class="list-group-item"><a class="list-group-item text-justify"
                                                   style="color: #000"
                                                   href="/movie/${p.getId()}">${p?index + 1}  ${p.getTitle()}
                            <strong>${p.getRating()}</strong></a>
                    </li>

                    </#list>
                </ul>
                </#if>
            </div>
        </div>
    </div>
</@c.page>