var headerMenu = Vue.extend({
    template: `<nav class="navbar navbar-expand-lg navbar-dark bg-dark shadow-sm">
        <router-link to="/" class="navbar-brand d-block d-relative" href="javascript:void(0);" style="width: 120px">
            <img class="d-absolute y-center" src="http://www.turkeydiscoverthepotential.com/Content/img/downloads/logo/turkce/Turkey_DTP_logo_Solid_T_rgb.png" height="90" width="auto" />
        </router-link>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <router-link to="/" class="nav-link" href="javascript: void(0);">Home <span class="sr-only">(current)</span></router-link>
            </li>
            <li class="nav-item">
                <router-link to="/user" class="nav-link" href="javascript: void(0);">Users</router-link>
            </li>
            <li class="nav-item">
                <router-link to="/group" class="nav-link" href="javascript: void(0);">Group</router-link>
            </li>
            <li class="nav-item">
                <router-link to="/vuex" class="nav-link" href="javascript: void(0);">Vuex</router-link>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Dropdown
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="#">Action</a>
                <a class="dropdown-item" href="#">Another action</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#">Disabled</a>
            </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
        </nav>`,
});

var mainContainer = Vue.extend({
    template: '<div class="container">\
        <div class="row">\
            <div class="col-12 text-center">\
                <h1>{{title}}</h1>\
            </div>\
        </div>\
    </div>',
    data() {
        return {
            title: 'MAIN'
        }
    }
})