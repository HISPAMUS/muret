(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/*!**********************************************************!*\
  !*** ./src/$$_lazy_route_resource lazy namespace object ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error("Cannot find module '" + req + "'");
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/about/about.component.css":
/*!*******************************************!*\
  !*** ./src/app/about/about.component.css ***!
  \*******************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".jumbotron {\n  background-color: transparent;\n}\n\n.jumbotron img {\n  width: 50%;\n  margin-bottom: 2vh;\n}\n\n.jumbotron p {\n  text-align: center;\n}\n\n#logos p {\n  text-align: center;\n}\n\n#logos img {\n  width: 80%;\n}\n\nfooter{\n  font-size: 10px;\n  position: fixed;\n  bottom: 2em;\n  right: 2em;\n}\n\nfooter p {\n  text-align: right;\n}\n\n#cite {\n  margin-bottom: 5em;\n  color: white;\n}\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvYWJvdXQvYWJvdXQuY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLDZCQUE2QjtBQUMvQjs7QUFFQTtFQUNFLFVBQVU7RUFDVixrQkFBa0I7QUFDcEI7O0FBRUE7RUFDRSxrQkFBa0I7QUFDcEI7O0FBRUE7RUFDRSxrQkFBa0I7QUFDcEI7O0FBQ0E7RUFDRSxVQUFVO0FBQ1o7O0FBRUE7RUFDRSxlQUFlO0VBQ2YsZUFBZTtFQUNmLFdBQVc7RUFDWCxVQUFVO0FBQ1o7O0FBRUE7RUFDRSxpQkFBaUI7QUFDbkI7O0FBRUE7RUFDRSxrQkFBa0I7RUFDbEIsWUFBWTtBQUNkIiwiZmlsZSI6InNyYy9hcHAvYWJvdXQvYWJvdXQuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi5qdW1ib3Ryb24ge1xuICBiYWNrZ3JvdW5kLWNvbG9yOiB0cmFuc3BhcmVudDtcbn1cblxuLmp1bWJvdHJvbiBpbWcge1xuICB3aWR0aDogNTAlO1xuICBtYXJnaW4tYm90dG9tOiAydmg7XG59XG5cbi5qdW1ib3Ryb24gcCB7XG4gIHRleHQtYWxpZ246IGNlbnRlcjtcbn1cblxuI2xvZ29zIHAge1xuICB0ZXh0LWFsaWduOiBjZW50ZXI7XG59XG4jbG9nb3MgaW1nIHtcbiAgd2lkdGg6IDgwJTtcbn1cblxuZm9vdGVye1xuICBmb250LXNpemU6IDEwcHg7XG4gIHBvc2l0aW9uOiBmaXhlZDtcbiAgYm90dG9tOiAyZW07XG4gIHJpZ2h0OiAyZW07XG59XG5cbmZvb3RlciBwIHtcbiAgdGV4dC1hbGlnbjogcmlnaHQ7XG59XG5cbiNjaXRlIHtcbiAgbWFyZ2luLWJvdHRvbTogNWVtO1xuICBjb2xvcjogd2hpdGU7XG59XG4iXX0= */"

/***/ }),

/***/ "./src/app/about/about.component.html":
/*!********************************************!*\
  !*** ./src/app/about/about.component.html ***!
  \********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"jumbotron\">\n  <p><img src=\"assets/images/muret_negativo.png\" alt=\"Logo MuRET\"></p>\n  <p>Music Recognition, encoding, and transcription</p>\n</div>\n<div class=\"row\" id=\"cite\">\n  <div class=\"offset-3 col-7\">\n    <h3>Cite as:</h3>\n    <p>\n      Rizo, D.; Calvo-Zaragoza, J.; Iñesta, J.M.<br/>\n      <strong>\"MuRET: a music recognition, encoding, and transcription tool\"</strong><br/>\n      Proceedings of the 5th International Conference on Digital Libraries for Musicology (DLfM'18), ISBN: 978-1-4503-6522-2, pp. 52--56, París, France (2018)\n    </p>\n  </div>\n</div>\n<div class=\"row\" id=\"logos\">\n  <div class=\"col-4\">\n    <p><img src=\"assets/images/uacolor.jpg\" alt=\"Logo UA\"></p>\n  </div>\n  <div class=\"col-4\">\n    <p><img src=\"assets/images/hispamus_negativo_sin_fondo.png\" alt=\"Logo MuRET\"></p>\n  </div>\n  <div class=\"col-4\">\n    <p><img src=\"assets/images/economiac.jpg\" alt=\"Logo MuRET\"></p>\n  </div>\n</div>\n<footer>\n  <p><a href=\"mailto:drizo [@] dlsi.ua.es \">©2018 Development: David Rizo</a></p>\n  <p><a href=\"mailto:drizo [@] dlsi.ua.es \">©2018 Backend classifiers: Jorge Calvo-Zaragoza</a></p>\n  <p><a href=\"mailto:lvf.lauravasallo [@] gmail.com\">©2018 Visual Design: Laura Vasallo</a></p>\n</footer>\n\n"

/***/ }),

/***/ "./src/app/about/about.component.ts":
/*!******************************************!*\
  !*** ./src/app/about/about.component.ts ***!
  \******************************************/
/*! exports provided: AboutComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AboutComponent", function() { return AboutComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var AboutComponent = /** @class */ (function () {
    function AboutComponent() {
    }
    AboutComponent.prototype.ngOnInit = function () {
    };
    AboutComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-about',
            template: __webpack_require__(/*! ./about.component.html */ "./src/app/about/about.component.html"),
            styles: [__webpack_require__(/*! ./about.component.css */ "./src/app/about/about.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], AboutComponent);
    return AboutComponent;
}());



/***/ }),

/***/ "./src/app/app-routing.module.ts":
/*!***************************************!*\
  !*** ./src/app/app-routing.module.ts ***!
  \***************************************/
/*! exports provided: AppRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppRoutingModule", function() { return AppRoutingModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _projects_projects_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./projects/projects.component */ "./src/app/projects/projects.component.ts");
/* harmony import */ var _project_project_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./project/project.component */ "./src/app/project/project.component.ts");
/* harmony import */ var _startup_startup_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./startup/startup.component */ "./src/app/startup/startup.component.ts");
/* harmony import */ var _about_about_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./about/about.component */ "./src/app/about/about.component.ts");
/* harmony import */ var _image_image_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./image/image.component */ "./src/app/image/image.component.ts");
/* harmony import */ var _new_project_form_new_project_form_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./new-project-form/new-project-form.component */ "./src/app/new-project-form/new-project-form.component.ts");
/* harmony import */ var _upload_images_upload_images_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./upload-images/upload-images.component */ "./src/app/upload-images/upload-images.component.ts");
/* harmony import */ var _auth_guard__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./auth.guard */ "./src/app/auth.guard.ts");
/* harmony import */ var _login_login_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./login/login.component */ "./src/app/login/login.component.ts");
/* harmony import */ var _symbols_symbols_component__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./symbols/symbols.component */ "./src/app/symbols/symbols.component.ts");
/* harmony import */ var _svgdrawing_svgdrawing_component__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./svgdrawing/svgdrawing.component */ "./src/app/svgdrawing/svgdrawing.component.ts");
/* harmony import */ var _preferences_preferences_component__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./preferences/preferences.component */ "./src/app/preferences/preferences.component.ts");
/* harmony import */ var _dev_dev_component__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ./dev/dev.component */ "./src/app/dev/dev.component.ts");
/* harmony import */ var _training_sets_training_sets_component__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ./training-sets/training-sets.component */ "./src/app/training-sets/training-sets.component.ts");

















var routes = [
    { path: 'svg', component: _svgdrawing_svgdrawing_component__WEBPACK_IMPORTED_MODULE_13__["SVGDrawingComponent"] },
    { path: 'about', component: _about_about_component__WEBPACK_IMPORTED_MODULE_6__["AboutComponent"] },
    { path: 'preferences', component: _preferences_preferences_component__WEBPACK_IMPORTED_MODULE_14__["PreferencesComponent"], canActivate: [_auth_guard__WEBPACK_IMPORTED_MODULE_10__["AuthGuard"]] },
    { path: 'login', component: _login_login_component__WEBPACK_IMPORTED_MODULE_11__["LoginComponent"] },
    { path: 'startup', component: _startup_startup_component__WEBPACK_IMPORTED_MODULE_5__["StartupComponent"], canActivate: [_auth_guard__WEBPACK_IMPORTED_MODULE_10__["AuthGuard"]] },
    { path: 'projects', component: _projects_projects_component__WEBPACK_IMPORTED_MODULE_3__["ProjectsComponent"], canActivate: [_auth_guard__WEBPACK_IMPORTED_MODULE_10__["AuthGuard"]] },
    { path: 'newproject', component: _new_project_form_new_project_form_component__WEBPACK_IMPORTED_MODULE_8__["NewProjectFormComponent"], canActivate: [_auth_guard__WEBPACK_IMPORTED_MODULE_10__["AuthGuard"]] },
    { path: 'project/:id', component: _project_project_component__WEBPACK_IMPORTED_MODULE_4__["ProjectComponent"], canActivate: [_auth_guard__WEBPACK_IMPORTED_MODULE_10__["AuthGuard"]], canDeactivate: [_auth_guard__WEBPACK_IMPORTED_MODULE_10__["AuthGuard"]] },
    { path: 'image', component: _image_image_component__WEBPACK_IMPORTED_MODULE_7__["ImageComponent"], canActivate: [_auth_guard__WEBPACK_IMPORTED_MODULE_10__["AuthGuard"]], canDeactivate: [_auth_guard__WEBPACK_IMPORTED_MODULE_10__["AuthGuard"]] },
    { path: 'symbols', component: _symbols_symbols_component__WEBPACK_IMPORTED_MODULE_12__["SymbolsComponent"], canActivate: [_auth_guard__WEBPACK_IMPORTED_MODULE_10__["AuthGuard"]], canDeactivate: [_auth_guard__WEBPACK_IMPORTED_MODULE_10__["AuthGuard"]] },
    { path: 'uploadimages/:id', component: _upload_images_upload_images_component__WEBPACK_IMPORTED_MODULE_9__["UploadImagesComponent"], canActivate: [_auth_guard__WEBPACK_IMPORTED_MODULE_10__["AuthGuard"]] },
    { path: 'export', component: _training_sets_training_sets_component__WEBPACK_IMPORTED_MODULE_16__["TrainingSetsComponent"], canActivate: [_auth_guard__WEBPACK_IMPORTED_MODULE_10__["AuthGuard"]] },
    // usado para desarrollo //TODO Quitar
    { path: 'dev', component: _dev_dev_component__WEBPACK_IMPORTED_MODULE_15__["DevComponent"] },
    { path: '', pathMatch: 'full', redirectTo: 'startup' }
    /*{ path: '**', redirectTo: '' },*/
];
var AppRoutingModule = /** @class */ (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"].forRoot(routes, { enableTracing: false } // <-- debugging purposes only
                )],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"]]
        })
    ], AppRoutingModule);
    return AppRoutingModule;
}());



/***/ }),

/***/ "./src/app/app.component.css":
/*!***********************************!*\
  !*** ./src/app/app.component.css ***!
  \***********************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "#page {\n  background-color: #103339;\n}\n\n\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvYXBwLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRSx5QkFBeUI7QUFDM0IiLCJmaWxlIjoic3JjL2FwcC9hcHAuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIiNwYWdlIHtcbiAgYmFja2dyb3VuZC1jb2xvcjogIzEwMzMzOTtcbn1cblxuXG4iXX0= */"

/***/ }),

/***/ "./src/app/app.component.html":
/*!************************************!*\
  !*** ./src/app/app.component.html ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<app-layout>\n  <router-outlet></router-outlet>\n</app-layout>\n"

/***/ }),

/***/ "./src/app/app.component.ts":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var AppComponent = /** @class */ (function () {
    function AppComponent() {
        this.title = 'MuRET';
    }
    AppComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-root',
            template: __webpack_require__(/*! ./app.component.html */ "./src/app/app.component.html"),
            styles: [__webpack_require__(/*! ./app.component.css */ "./src/app/app.component.css")]
        })
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _projects_projects_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./projects/projects.component */ "./src/app/projects/projects.component.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _app_routing_module__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./app-routing.module */ "./src/app/app-routing.module.ts");
/* harmony import */ var _ui_ui_module__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./ui/ui.module */ "./src/app/ui/ui.module.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _project_project_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./project/project.component */ "./src/app/project/project.component.ts");
/* harmony import */ var _startup_startup_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./startup/startup.component */ "./src/app/startup/startup.component.ts");
/* harmony import */ var _about_about_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./about/about.component */ "./src/app/about/about.component.ts");
/* harmony import */ var _image_image_component__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./image/image.component */ "./src/app/image/image.component.ts");
/* harmony import */ var ng2_dragula__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ng2-dragula */ "./node_modules/ng2-dragula/dist/fesm5/ng2-dragula.js");
/* harmony import */ var angular_svg_icon__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! angular-svg-icon */ "./node_modules/angular-svg-icon/fesm5/angular-svg-icon.js");
/* harmony import */ var _new_project_form_new_project_form_component__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ./new-project-form/new-project-form.component */ "./src/app/new-project-form/new-project-form.component.ts");
/* harmony import */ var ngx_img__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ngx-img */ "./node_modules/ngx-img/ngx-img.es5.js");
/* harmony import */ var _upload_images_upload_images_component__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ./upload-images/upload-images.component */ "./src/app/upload-images/upload-images.component.ts");
/* harmony import */ var ng2_file_upload__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! ng2-file-upload */ "./node_modules/ng2-file-upload/index.js");
/* harmony import */ var ng2_file_upload__WEBPACK_IMPORTED_MODULE_18___default = /*#__PURE__*/__webpack_require__.n(ng2_file_upload__WEBPACK_IMPORTED_MODULE_18__);
/* harmony import */ var _image_thumbnail_image_thumbnail_component__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! ./image-thumbnail/image-thumbnail.component */ "./src/app/image-thumbnail/image-thumbnail.component.ts");
/* harmony import */ var _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! @ng-bootstrap/ng-bootstrap */ "./node_modules/@ng-bootstrap/ng-bootstrap/fesm5/ng-bootstrap.js");
/* harmony import */ var ngx_lightbox__WEBPACK_IMPORTED_MODULE_21__ = __webpack_require__(/*! ngx-lightbox */ "./node_modules/ngx-lightbox/index.js");
/* harmony import */ var ngx_lightbox__WEBPACK_IMPORTED_MODULE_21___default = /*#__PURE__*/__webpack_require__.n(ngx_lightbox__WEBPACK_IMPORTED_MODULE_21__);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_22__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _services_rest_client_service__WEBPACK_IMPORTED_MODULE_23__ = __webpack_require__(/*! ./services/rest-client.service */ "./src/app/services/rest-client.service.ts");
/* harmony import */ var _login_login_component__WEBPACK_IMPORTED_MODULE_24__ = __webpack_require__(/*! ./login/login.component */ "./src/app/login/login.component.ts");
/* harmony import */ var ngx_logger__WEBPACK_IMPORTED_MODULE_25__ = __webpack_require__(/*! ngx-logger */ "./node_modules/ngx-logger/esm5/ngx-logger.js");
/* harmony import */ var _global_error_handler_service__WEBPACK_IMPORTED_MODULE_26__ = __webpack_require__(/*! ./global-error-handler.service */ "./src/app/global-error-handler.service.ts");
/* harmony import */ var angular_resize_event__WEBPACK_IMPORTED_MODULE_27__ = __webpack_require__(/*! angular-resize-event */ "./node_modules/angular-resize-event/fesm5/angular-resize-event.js");
/* harmony import */ var _image_tool_bar_image_tool_bar_component__WEBPACK_IMPORTED_MODULE_28__ = __webpack_require__(/*! ./image-tool-bar/image-tool-bar.component */ "./src/app/image-tool-bar/image-tool-bar.component.ts");
/* harmony import */ var _symbols_symbols_component__WEBPACK_IMPORTED_MODULE_29__ = __webpack_require__(/*! ./symbols/symbols.component */ "./src/app/symbols/symbols.component.ts");
/* harmony import */ var _svgcanvas_svgdrawing_tool_module__WEBPACK_IMPORTED_MODULE_30__ = __webpack_require__(/*! ./svgcanvas/svgdrawing-tool.module */ "./src/app/svgcanvas/svgdrawing-tool.module.ts");
/* harmony import */ var _document_analysis_view_document_analysis_view_component__WEBPACK_IMPORTED_MODULE_31__ = __webpack_require__(/*! ./document-analysis-view/document-analysis-view.component */ "./src/app/document-analysis-view/document-analysis-view.component.ts");
/* harmony import */ var _preferences_preferences_component__WEBPACK_IMPORTED_MODULE_32__ = __webpack_require__(/*! ./preferences/preferences.component */ "./src/app/preferences/preferences.component.ts");
/* harmony import */ var _dev_dev_component__WEBPACK_IMPORTED_MODULE_33__ = __webpack_require__(/*! ./dev/dev.component */ "./src/app/dev/dev.component.ts");
/* harmony import */ var _state_state_component__WEBPACK_IMPORTED_MODULE_34__ = __webpack_require__(/*! ./state/state.component */ "./src/app/state/state.component.ts");
/* harmony import */ var _inline_edit_inline_edit_component__WEBPACK_IMPORTED_MODULE_35__ = __webpack_require__(/*! ./inline-edit/inline-edit.component */ "./src/app/inline-edit/inline-edit.component.ts");
/* harmony import */ var _training_sets_training_sets_component__WEBPACK_IMPORTED_MODULE_36__ = __webpack_require__(/*! ./training-sets/training-sets.component */ "./src/app/training-sets/training-sets.component.ts");






































var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"],
                _projects_projects_component__WEBPACK_IMPORTED_MODULE_4__["ProjectsComponent"],
                _project_project_component__WEBPACK_IMPORTED_MODULE_9__["ProjectComponent"],
                _startup_startup_component__WEBPACK_IMPORTED_MODULE_10__["StartupComponent"],
                _about_about_component__WEBPACK_IMPORTED_MODULE_11__["AboutComponent"],
                _image_image_component__WEBPACK_IMPORTED_MODULE_12__["ImageComponent"],
                _new_project_form_new_project_form_component__WEBPACK_IMPORTED_MODULE_15__["NewProjectFormComponent"],
                _upload_images_upload_images_component__WEBPACK_IMPORTED_MODULE_17__["UploadImagesComponent"],
                _image_thumbnail_image_thumbnail_component__WEBPACK_IMPORTED_MODULE_19__["ImageThumbnailComponent"],
                _login_login_component__WEBPACK_IMPORTED_MODULE_24__["LoginComponent"],
                _image_tool_bar_image_tool_bar_component__WEBPACK_IMPORTED_MODULE_28__["ImageToolBarComponent"],
                _symbols_symbols_component__WEBPACK_IMPORTED_MODULE_29__["SymbolsComponent"],
                _document_analysis_view_document_analysis_view_component__WEBPACK_IMPORTED_MODULE_31__["DocumentAnalysisViewComponent"],
                _preferences_preferences_component__WEBPACK_IMPORTED_MODULE_32__["PreferencesComponent"],
                _dev_dev_component__WEBPACK_IMPORTED_MODULE_33__["DevComponent"],
                _state_state_component__WEBPACK_IMPORTED_MODULE_34__["StateComponent"],
                _inline_edit_inline_edit_component__WEBPACK_IMPORTED_MODULE_35__["InlineEditComponent"],
                _training_sets_training_sets_component__WEBPACK_IMPORTED_MODULE_36__["TrainingSetsComponent"]
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__["BrowserModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_5__["HttpClientModule"],
                _app_routing_module__WEBPACK_IMPORTED_MODULE_6__["AppRoutingModule"],
                _ui_ui_module__WEBPACK_IMPORTED_MODULE_7__["UiModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_8__["ReactiveFormsModule"],
                angular_svg_icon__WEBPACK_IMPORTED_MODULE_14__["AngularSvgIconModule"],
                ng2_file_upload__WEBPACK_IMPORTED_MODULE_18__["FileUploadModule"],
                ngx_img__WEBPACK_IMPORTED_MODULE_16__["NgxImgModule"].forRoot(),
                ng2_dragula__WEBPACK_IMPORTED_MODULE_13__["DragulaModule"].forRoot(),
                _angular_forms__WEBPACK_IMPORTED_MODULE_8__["FormsModule"],
                _angular_router__WEBPACK_IMPORTED_MODULE_22__["RouterModule"],
                ngx_lightbox__WEBPACK_IMPORTED_MODULE_21__["LightboxModule"],
                _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_20__["NgbModule"],
                angular_resize_event__WEBPACK_IMPORTED_MODULE_27__["AngularResizedEventModule"],
                _svgcanvas_svgdrawing_tool_module__WEBPACK_IMPORTED_MODULE_30__["SVGDrawingToolModule"],
                // LoggerModule.forRoot({serverLoggingUrl: '/api/logs', level: NgxLoggerLevel.DEBUG, serverLogLevel: NgxLoggerLevel.ERROR})
                ngx_logger__WEBPACK_IMPORTED_MODULE_25__["LoggerModule"].forRoot({ level: ngx_logger__WEBPACK_IMPORTED_MODULE_25__["NgxLoggerLevel"].DEBUG, serverLogLevel: ngx_logger__WEBPACK_IMPORTED_MODULE_25__["NgxLoggerLevel"].ERROR })
            ],
            providers: [_services_rest_client_service__WEBPACK_IMPORTED_MODULE_23__["RestClientService"], ngx_logger__WEBPACK_IMPORTED_MODULE_25__["NGXLogger"], _global_error_handler_service__WEBPACK_IMPORTED_MODULE_26__["GlobalErrorHandlerService"],
                { provide: _angular_core__WEBPACK_IMPORTED_MODULE_2__["ErrorHandler"], useClass: _global_error_handler_service__WEBPACK_IMPORTED_MODULE_26__["GlobalErrorHandlerService"] },
            ],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/auth.guard.ts":
/*!*******************************!*\
  !*** ./src/app/auth.guard.ts ***!
  \*******************************/
/*! exports provided: AuthGuard */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AuthGuard", function() { return AuthGuard; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var ngx_logger__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ngx-logger */ "./node_modules/ngx-logger/esm5/ngx-logger.js");
/* harmony import */ var _services_session_data_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./services/session-data.service */ "./src/app/services/session-data.service.ts");
/* harmony import */ var _services_auth_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./services/auth.service */ "./src/app/services/auth.service.ts");






var AuthGuard = /** @class */ (function () {
    function AuthGuard(authService, sessionDataService, router, logger) {
        this.authService = authService;
        this.sessionDataService = sessionDataService;
        this.router = router;
        this.logger = logger;
    }
    AuthGuard.prototype.canActivate = function (route, state) {
        var url = state.url;
        this.logger.debug('Checking canActivate for ' + url);
        return this.checkLogin(url);
    };
    AuthGuard.prototype.canActivateChild = function (route, state) {
        return this.canActivate(route, state);
    };
    AuthGuard.prototype.canLoad = function (route) {
        this.logger.debug('Check can load ' + route.path);
        var url = "/" + route.path;
        return this.checkLogin(url);
    };
    AuthGuard.prototype.checkLogin = function (url) {
        if (this.authService.authenticated()) {
            this.logger.debug('Can activate ' + url);
            return true;
        }
        this.logger.debug('Cannot activate ' + url);
        // Create a dummy session id
        var sessionId = this.getRandomInt(1, 1000000);
        // Set our navigation extras object
        // that contains our global query params and fragment
        var navigationExtras = {
            queryParams: { 'session_id': sessionId },
            fragment: 'anchor'
        };
        // Navigate to the login page with extras
        this.router.navigate(['login'], navigationExtras);
        return false;
    };
    AuthGuard.prototype.getRandomInt = function (min, max) {
        return Math.floor(Math.random() * (max - min + 1)) + min;
    };
    AuthGuard.prototype.canDeactivate = function (component, currentRoute, currentState, nextState) {
        if (component.canDeactivate()) {
            if (confirm('You have unsaved changes! If you leave, your changes will be lost.')) {
                return true;
            }
            else {
                return false;
            }
        }
        return true;
    };
    AuthGuard = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
            providedIn: 'root',
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_services_auth_service__WEBPACK_IMPORTED_MODULE_5__["AuthService"], _services_session_data_service__WEBPACK_IMPORTED_MODULE_4__["SessionDataService"], _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"],
            ngx_logger__WEBPACK_IMPORTED_MODULE_3__["NGXLogger"]])
    ], AuthGuard);
    return AuthGuard;
}());



/***/ }),

/***/ "./src/app/component-can-deactivate.ts":
/*!*********************************************!*\
  !*** ./src/app/component-can-deactivate.ts ***!
  \*********************************************/
/*! exports provided: ComponentCanDeactivate */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ComponentCanDeactivate", function() { return ComponentCanDeactivate; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var ComponentCanDeactivate = /** @class */ (function () {
    function ComponentCanDeactivate() {
    }
    ComponentCanDeactivate.prototype.unloadNotification = function ($event) {
        if (!this.canDeactivate()) {
            $event.returnValue = true;
        }
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["HostListener"])('window:beforeunload', ['$event']),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Function),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [Object]),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:returntype", void 0)
    ], ComponentCanDeactivate.prototype, "unloadNotification", null);
    return ComponentCanDeactivate;
}());



/***/ }),

/***/ "./src/app/configuration.service.ts":
/*!******************************************!*\
  !*** ./src/app/configuration.service.ts ***!
  \******************************************/
/*! exports provided: ConfigurationService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ConfigurationService", function() { return ConfigurationService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _messages_message_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./messages/message.service */ "./src/app/messages/message.service.ts");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../environments/environment */ "./src/environments/environment.ts");





var ConfigurationService = /** @class */ (function () {
    function ConfigurationService(http, messageService) {
        this.http = http;
        this.messageService = messageService;
        this.IM3WS_SERVER = _environments_environment__WEBPACK_IMPORTED_MODULE_4__["environment"].apiEndpoint;
    }
    ConfigurationService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
            providedIn: 'root'
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"],
            _messages_message_service__WEBPACK_IMPORTED_MODULE_3__["MessageService"]])
    ], ConfigurationService);
    return ConfigurationService;
}());



/***/ }),

/***/ "./src/app/dev/dev.component.css":
/*!***************************************!*\
  !*** ./src/app/dev/dev.component.css ***!
  \***************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2Rldi9kZXYuY29tcG9uZW50LmNzcyJ9 */"

/***/ }),

/***/ "./src/app/dev/dev.component.html":
/*!****************************************!*\
  !*** ./src/app/dev/dev.component.html ***!
  \****************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<p>\n  dev works!\n</p>\n"

/***/ }),

/***/ "./src/app/dev/dev.component.ts":
/*!**************************************!*\
  !*** ./src/app/dev/dev.component.ts ***!
  \**************************************/
/*! exports provided: DevComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "DevComponent", function() { return DevComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _services_session_data_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../services/session-data.service */ "./src/app/services/session-data.service.ts");
/* harmony import */ var ngx_logger__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ngx-logger */ "./node_modules/ngx-logger/esm5/ngx-logger.js");
/* harmony import */ var _services_auth_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../services/auth.service */ "./src/app/services/auth.service.ts");
/* harmony import */ var _services_image_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../services/image.service */ "./src/app/services/image.service.ts");







var DevComponent = /** @class */ (function () {
    function DevComponent(authService, router, imageService, sessionDataService, logger) {
        var _this = this;
        this.authService = authService;
        this.router = router;
        this.imageService = imageService;
        this.sessionDataService = sessionDataService;
        this.logger = logger;
        // projectID = 37;
        // imageID = 198;
        // path = 'villancico-al-smo--sto--al-molino-del-amor';
        this.projectID = 167;
        this.imageID = 2103;
        this.path = 'b-59-850';
        this.logger.warn('¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡ DEV!!!!!!!!!!!!!!!!!!!!!!');
        this.authService.login('davidrizo', 'nose').subscribe(function (next) {
            if (next) {
                _this.authService.setUser(next);
                _this.router.navigate(['/project/' + _this.projectID])
                    .then(function (value) {
                    _this.imageService.getImage$(_this.imageID).
                        subscribe(function (serviceImage) {
                        _this.sessionDataService.currentImage = serviceImage;
                        _this.router.navigate(['/image']);
                    });
                });
            }
            else {
                throw new Error('Cannot authenticate!!!');
            }
        });
    }
    DevComponent.prototype.ngOnInit = function () {
    };
    DevComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-dev',
            template: __webpack_require__(/*! ./dev.component.html */ "./src/app/dev/dev.component.html"),
            styles: [__webpack_require__(/*! ./dev.component.css */ "./src/app/dev/dev.component.css")]
        })
        // Used to speed up development
        ,
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_services_auth_service__WEBPACK_IMPORTED_MODULE_5__["AuthService"], _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"],
            _services_image_service__WEBPACK_IMPORTED_MODULE_6__["ImageService"],
            _services_session_data_service__WEBPACK_IMPORTED_MODULE_3__["SessionDataService"],
            ngx_logger__WEBPACK_IMPORTED_MODULE_4__["NGXLogger"]])
    ], DevComponent);
    return DevComponent;
}());



/***/ }),

/***/ "./src/app/document-analysis-view/document-analysis-view.component.css":
/*!*****************************************************************************!*\
  !*** ./src/app/document-analysis-view/document-analysis-view.component.css ***!
  \*****************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "#documentAnalysis {\n  position: relative;\n}\n#documentAnalysisCanvas {\n  position: absolute;\n  top: 0px;\n  width: 100%;\n  height: 100%;\n}\n#documentAnalysisTools {\n  margin-bottom: 1em;\n}\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvZG9jdW1lbnQtYW5hbHlzaXMtdmlldy9kb2N1bWVudC1hbmFseXNpcy12aWV3LmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRSxrQkFBa0I7QUFDcEI7QUFDQTtFQUNFLGtCQUFrQjtFQUNsQixRQUFRO0VBQ1IsV0FBVztFQUNYLFlBQVk7QUFDZDtBQUNBO0VBQ0Usa0JBQWtCO0FBQ3BCIiwiZmlsZSI6InNyYy9hcHAvZG9jdW1lbnQtYW5hbHlzaXMtdmlldy9kb2N1bWVudC1hbmFseXNpcy12aWV3LmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIjZG9jdW1lbnRBbmFseXNpcyB7XG4gIHBvc2l0aW9uOiByZWxhdGl2ZTtcbn1cbiNkb2N1bWVudEFuYWx5c2lzQ2FudmFzIHtcbiAgcG9zaXRpb246IGFic29sdXRlO1xuICB0b3A6IDBweDtcbiAgd2lkdGg6IDEwMCU7XG4gIGhlaWdodDogMTAwJTtcbn1cbiNkb2N1bWVudEFuYWx5c2lzVG9vbHMge1xuICBtYXJnaW4tYm90dG9tOiAxZW07XG59XG4iXX0= */"

/***/ }),

/***/ "./src/app/document-analysis-view/document-analysis-view.component.html":
/*!******************************************************************************!*\
  !*** ./src/app/document-analysis-view/document-analysis-view.component.html ***!
  \******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div id=\"documentAnalysisTools\" class=\"btn-group-justified\" role=\"group\" aria-label=\"Region types\">\n  <input type=\"checkbox\" [checked]=\"showLabels\" disabled/> Show labels\n\n  <button *ngFor=\"let regionType of regionTypes; trackBy: trackByRegionTypeFn\" type=\"button\" class=\"btn btn-secondary\"\n          (click)=\"changeRegionType(regionType)\">\n    {{regionType.name}}\n  </button>\n</div>\n\n<div id=\"documentAnalysis\">\n  <img #domImage class=\"img-fluid\" (load)=\"onImageLoad()\" src=\"{{imageURL}}\" alt=\"Image\">\n  <div id=\"documentAnalysisCanvas\"\n     [style.left]=\"domImagePaddingLeft\" [style.width.px]=\"domImageWidth\" [style.height.px]=\"domImageHeight\"\n     [style.cursor]=\"canvasCursor\"\n  >\n    <app-svgcanvas #svgCanvas [width]=\"domImageWidth\" [height]=\"domImageHeight\"\n                 (svgMouseEvent)=\"onMouseEvent($event)\"\n                 (svgShapeCreated)=\"onShapeCreated($event)\"\n                 (svgShapeChanged)=\"onShapeChanged($event)\"\n                 (svgShapeSelected)=\"onShapeSelected($event)\"\n                   (svgShapeDeselected)=\"onShapeDeselected($event)\"\n    ></app-svgcanvas>\n  </div>\n</div>\n"

/***/ }),

/***/ "./src/app/document-analysis-view/document-analysis-view.component.ts":
/*!****************************************************************************!*\
  !*** ./src/app/document-analysis-view/document-analysis-view.component.ts ***!
  \****************************************************************************/
/*! exports provided: DocumentAnalysisMode, DocumentAnalysisViewComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "DocumentAnalysisMode", function() { return DocumentAnalysisMode; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "DocumentAnalysisViewComponent", function() { return DocumentAnalysisViewComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var ngx_logger__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ngx-logger */ "./node_modules/ngx-logger/esm5/ngx-logger.js");
/* harmony import */ var _services_session_data_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../services/session-data.service */ "./src/app/services/session-data.service.ts");
/* harmony import */ var _svgcanvas_components_svgcanvas_svgcanvas_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../svgcanvas/components/svgcanvas/svgcanvas.component */ "./src/app/svgcanvas/components/svgcanvas/svgcanvas.component.ts");
/* harmony import */ var _svgcanvas_model_shape__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../svgcanvas/model/shape */ "./src/app/svgcanvas/model/shape.ts");
/* harmony import */ var _svgcanvas_components_rectangle_rectangle_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../svgcanvas/components/rectangle/rectangle.component */ "./src/app/svgcanvas/components/rectangle/rectangle.component.ts");
/* harmony import */ var _services_region_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../services/region.service */ "./src/app/services/region.service.ts");
/* harmony import */ var _services_image_service__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../services/image.service */ "./src/app/services/image.service.ts");










var DocumentAnalysisMode;
(function (DocumentAnalysisMode) {
    DocumentAnalysisMode[DocumentAnalysisMode["eSelecting"] = 0] = "eSelecting";
    DocumentAnalysisMode[DocumentAnalysisMode["eEditing"] = 1] = "eEditing";
    DocumentAnalysisMode[DocumentAnalysisMode["eSplittingPages"] = 2] = "eSplittingPages";
    DocumentAnalysisMode[DocumentAnalysisMode["eSplittingRegions"] = 3] = "eSplittingRegions";
})(DocumentAnalysisMode || (DocumentAnalysisMode = {}));
var DocumentAnalysisViewComponent = /** @class */ (function () {
    function DocumentAnalysisViewComponent(regionService, imageService, sessionDataService, route, logger) {
        var _this = this;
        this.regionService = regionService;
        this.imageService = imageService;
        this.sessionDataService = sessionDataService;
        this.route = route;
        this.logger = logger;
        this.canvasCursor = 'default';
        this.documentAnalysisMode = DocumentAnalysisMode.eSelecting;
        this.regionIDs = new Map();
        this.mouseEvent = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
        this.svgShapeCreated = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
        this.svgShapeSelected = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"](); // in order to observe it from other components such as symbol editing
        this.showLabels = true;
        this.selectedRegion = null;
        this.project = sessionDataService.currentProject;
        this.image = sessionDataService.currentImage;
        this.logger.debug('Working with image ' + this.imageURL);
        if (!sessionDataService.regionTypes) {
            this.regionService.getRegionTypes().subscribe(function (value) {
                sessionDataService.regionTypes = value;
                _this.logger.debug('Fetched #' + sessionDataService.regionTypes.length + ' region types');
                _this.regionTypes = value;
            }).unsubscribe();
        }
        else {
            this.regionTypes = sessionDataService.regionTypes;
        }
    }
    DocumentAnalysisViewComponent.prototype.ngOnInit = function () {
        this.logger.debug('fullImageSVGCanvas= ' + this.svgCanvas);
    };
    DocumentAnalysisViewComponent.prototype.ngAfterViewInit = function () {
        this.logger.debug('ngAfterViewInit');
    };
    DocumentAnalysisViewComponent.prototype.onImageLoad = function () {
        this.logger.debug('OnImageLoad');
        this.scale = this.domImage.nativeElement.width / this.domImage.nativeElement.naturalWidth;
        this.logger.debug('Using scale ' + this.scale);
        this.domImageHeight = this.domImage.nativeElement.height;
        this.domImageWidth = this.domImage.nativeElement.width;
        this.domImagePaddingLeft = this.domImage.nativeElement.paddingLeft;
        this.drawBoundingBoxes();
    };
    DocumentAnalysisViewComponent.prototype.drawBoundingBox = function (objectType, objectID, boundingBox, targetScale, strokeColor, strokeWidth, label) {
        var rx = boundingBox.fromX * targetScale;
        var ry = boundingBox.fromY * targetScale;
        var rwidth = targetScale * (boundingBox.toX - boundingBox.fromX);
        var rheight = targetScale * (boundingBox.toY - boundingBox.fromY);
        var rectangle = this.svgCanvas.drawRectangle(rx, ry, rwidth, rheight, label);
        rectangle.modelObjectType = objectType;
        rectangle.modelObjectID = objectID;
        rectangle.shape.shapeProperties.fillColor = 'transparent';
        rectangle.shape.shapeProperties.stroke = true;
        rectangle.shape.shapeProperties.strokeColor = strokeColor;
        rectangle.shape.shapeProperties.strokeWidth = strokeWidth;
    };
    DocumentAnalysisViewComponent.prototype.drawBoundingBoxes = function () {
        this.drawImagePages();
    };
    //TODO Centralizar imageService / regionService en lo mismo
    DocumentAnalysisViewComponent.prototype.splitPage = function (imageX) {
        var _this = this;
        this.logger.debug('Splitting page at X: ' + imageX);
        var prevCursor = this.canvasCursor;
        this.canvasCursor = 'wait';
        try {
            this.imageService.splitPage$(this.image.id, imageX).subscribe(function (next) {
                _this.image.pages = next;
                _this.drawImagePages();
                _this.canvasCursor = prevCursor;
                _this.clearInteractiveLines();
            });
        }
        catch (e) {
            this.canvasCursor = prevCursor;
            this.clearInteractiveLines();
        }
    };
    DocumentAnalysisViewComponent.prototype.splitRegion = function (imageX, imageY) {
        var _this = this;
        this.logger.debug('Splitting region at X: ' + imageX + ', Y: ' + imageY);
        var prevCursor = this.canvasCursor;
        this.canvasCursor = 'wait';
        try {
            this.imageService.splitRegion$(this.image.id, imageX, imageY).subscribe(function (next) {
                _this.image.pages = next;
                _this.drawImagePages();
                _this.canvasCursor = prevCursor;
                _this.clearInteractiveLines();
            });
        }
        catch (e) {
            this.canvasCursor = prevCursor;
            this.clearInteractiveLines();
        }
    };
    DocumentAnalysisViewComponent.prototype.clearDocumentAnalysis = function () {
        var _this = this;
        this.imageService.clearDocumentAnalysis$(this.image.id).subscribe(function (next) {
            _this.image.pages = next;
            _this.drawImagePages();
            _this.clearInteractiveLines();
        });
    };
    DocumentAnalysisViewComponent.prototype.drawInteractiveVerticalLine = function () {
        this.interactionLine = this.svgCanvas.drawLine(0, 0, 0, this.domImageWidth);
        this.interactionLine.shape.shapeProperties.strokeColor = 'red';
        this.interactionLine.shape.shapeProperties.strokeWidth = 2;
        this.svgCanvas.changeState(_svgcanvas_components_svgcanvas_svgcanvas_component__WEBPACK_IMPORTED_MODULE_5__["SVGCanvasState"].eIdle);
    };
    DocumentAnalysisViewComponent.prototype.drawInteractiveHorizontalLine = function () {
        this.interactionLine = this.svgCanvas.drawLine(0, 0, this.domImageWidth, 0);
        this.interactionLine.shape.shapeProperties.strokeColor = 'red';
        this.interactionLine.shape.shapeProperties.strokeWidth = 2;
        this.svgCanvas.changeState(_svgcanvas_components_svgcanvas_svgcanvas_component__WEBPACK_IMPORTED_MODULE_5__["SVGCanvasState"].eIdle);
    };
    DocumentAnalysisViewComponent.prototype.drawImagePages = function () {
        var _this = this;
        this.svgCanvas.clear();
        this.logger.debug('Drawing bounding boxes for image ' + this.image);
        this.image.pages.forEach(function (page) {
            _this.logger.debug('Page ' + page);
            _this.drawBoundingBox('Page', page.id, page.boundingBox, _this.scale, 'red', 12, '');
            page.regions.forEach(function (region) {
                _this.logger.debug('Region ' + region);
                var color;
                if (region.regionType) {
                    color = '#' + region.regionType.hexargb;
                }
                else {
                    _this.logger.debug('Region without region type');
                    color = 'black';
                }
                _this.drawBoundingBox('Region', region.id, region.boundingBox, _this.scale, color, 3, region.regionType.name);
                _this.regionIDs.set(region.id, region);
            });
        });
    };
    DocumentAnalysisViewComponent.prototype.findRegionID = function (id) {
        return this.regionIDs.get(id);
    };
    DocumentAnalysisViewComponent.prototype.clearInteractiveLines = function () {
        this.svgCanvas.remove(this.interactionLine);
    };
    DocumentAnalysisViewComponent.prototype.onMouseEvent = function ($event) {
        if ($event.mouseEvent.type === 'mousemove') {
            switch (this.documentAnalysisMode) {
                case DocumentAnalysisMode.eSplittingPages:
                    // this.splitLine.transform(transform().translate(event.layerX, 0));
                    this.interactionLine.moveHorizontallyTo($event.svgPosition.x);
                    break;
                case DocumentAnalysisMode.eSplittingRegions:
                    this.interactionLine.moveVerticallyTo($event.svgPosition.y);
                    // this.splitLine.transform(transform().translate(0, event.layerY));
                    break;
                default:
                    this.mouseEvent.emit($event);
            }
        }
        else if ($event.mouseEvent.type === 'mousedown') {
            switch (this.documentAnalysisMode) {
                case DocumentAnalysisMode.eSplittingPages:
                    this.splitPage($event.svgPosition.x / this.scale);
                    break;
                case DocumentAnalysisMode.eSplittingRegions:
                    this.splitRegion($event.svgPosition.x / this.scale, $event.svgPosition.y / this.scale);
                    break;
                default:
                    this.mouseEvent.emit($event);
            }
        }
        else {
            this.mouseEvent.emit($event);
        }
    };
    DocumentAnalysisViewComponent.prototype.onShapeCreated = function ($event) {
        // TODO para crear objetos dibujando
    };
    DocumentAnalysisViewComponent.prototype.onShapeSelected = function ($event) {
        this.logger.debug('Shape selected ' + $event);
        this.svgShapeSelected.emit($event);
        this.selectedRegion = $event;
    };
    DocumentAnalysisViewComponent.prototype.onShapeDeselected = function ($event) {
        this.selectedRegion = null;
    };
    DocumentAnalysisViewComponent.prototype.onShapeChanged = function ($event) {
        this.logger.debug('Image: detected a shape change on a ' + $event.modelObjectType
            + ' with ID=' + $event.modelObjectID);
        if ($event.shape instanceof _svgcanvas_model_shape__WEBPACK_IMPORTED_MODULE_6__["Rectangle"]) {
            // TODO Si da error la actualización que se repinte
            if ($event.modelObjectType === 'Region') {
                this.imageService.updateRegionBoundingBox$($event.modelObjectID, $event.shape.originX / this.scale, $event.shape.originY / this.scale, ($event.shape.originX + $event.shape.width) / this.scale, ($event.shape.originX + $event.shape.height) / this.scale);
            }
            else if ($event.modelObjectType === 'Page') {
                this.imageService.updatePageBoundingBox$($event.modelObjectID, $event.shape.originX / this.scale, $event.shape.originY / this.scale, ($event.shape.originX + $event.shape.width) / this.scale, ($event.shape.originX + $event.shape.height) / this.scale);
            }
        }
        else {
            this.logger.debug('Image: shape change not on a rectangle');
        }
    };
    DocumentAnalysisViewComponent.prototype.activatePageSplitMode = function () {
        this.documentAnalysisMode = DocumentAnalysisMode.eSplittingPages;
        this.drawInteractiveVerticalLine();
        this.canvasCursor = 'col-resize';
    };
    DocumentAnalysisViewComponent.prototype.activateRegionSplitMode = function () {
        this.documentAnalysisMode = DocumentAnalysisMode.eSplittingRegions;
        this.drawInteractiveHorizontalLine();
        this.canvasCursor = 'row-resize';
    };
    DocumentAnalysisViewComponent.prototype.activateEditMode = function () {
        this.documentAnalysisMode = DocumentAnalysisMode.eEditing;
        this.canvasCursor = 'move';
        this.svgCanvas.changeState(_svgcanvas_components_svgcanvas_svgcanvas_component__WEBPACK_IMPORTED_MODULE_5__["SVGCanvasState"].eEditing);
    };
    DocumentAnalysisViewComponent.prototype.activateSelectMode = function () {
        this.documentAnalysisMode = DocumentAnalysisMode.eSelecting;
        this.canvasCursor = 'default';
        this.svgCanvas.changeState(_svgcanvas_components_svgcanvas_svgcanvas_component__WEBPACK_IMPORTED_MODULE_5__["SVGCanvasState"].eSelecting);
    };
    DocumentAnalysisViewComponent.prototype.getImageNaturalWidth = function () {
        return this.domImage.nativeElement.naturalWidth;
    };
    DocumentAnalysisViewComponent.prototype.changeRegionType = function (regionType) {
        var _this = this;
        if (this.selectedRegion != null) {
            var region_1 = this.findRegionID(this.selectedRegion.modelObjectID);
            if (region_1) {
                this.imageService.updateRegionType$(region_1.id, regionType).subscribe(function (next) {
                    if (_this.selectedRegion instanceof _svgcanvas_components_rectangle_rectangle_component__WEBPACK_IMPORTED_MODULE_7__["RectangleComponent"]) {
                        region_1.regionType = regionType;
                        _this.selectedRegion.label = regionType.name;
                    }
                });
            }
        }
    };
    DocumentAnalysisViewComponent.prototype.trackByRegionTypeFn = function (index, item) {
        return item.id; // unique id corresponding to the item
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["ViewChild"])('domImage'),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", _angular_core__WEBPACK_IMPORTED_MODULE_1__["ElementRef"])
    ], DocumentAnalysisViewComponent.prototype, "domImage", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["ViewChild"])('svgCanvas'),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", _svgcanvas_components_svgcanvas_svgcanvas_component__WEBPACK_IMPORTED_MODULE_5__["SVGCanvasComponent"])
    ], DocumentAnalysisViewComponent.prototype, "svgCanvas", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Output"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Object)
    ], DocumentAnalysisViewComponent.prototype, "mouseEvent", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Output"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Object)
    ], DocumentAnalysisViewComponent.prototype, "svgShapeCreated", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Output"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Object)
    ], DocumentAnalysisViewComponent.prototype, "svgShapeSelected", void 0);
    DocumentAnalysisViewComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-document-analysis-view',
            template: __webpack_require__(/*! ./document-analysis-view.component.html */ "./src/app/document-analysis-view/document-analysis-view.component.html"),
            styles: [__webpack_require__(/*! ./document-analysis-view.component.css */ "./src/app/document-analysis-view/document-analysis-view.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_services_region_service__WEBPACK_IMPORTED_MODULE_8__["RegionService"],
            _services_image_service__WEBPACK_IMPORTED_MODULE_9__["ImageService"],
            _services_session_data_service__WEBPACK_IMPORTED_MODULE_4__["SessionDataService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_2__["ActivatedRoute"],
            ngx_logger__WEBPACK_IMPORTED_MODULE_3__["NGXLogger"]])
    ], DocumentAnalysisViewComponent);
    return DocumentAnalysisViewComponent;
}());



/***/ }),

/***/ "./src/app/form-utils.ts":
/*!*******************************!*\
  !*** ./src/app/form-utils.ts ***!
  \*******************************/
/*! exports provided: FormUtils */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FormUtils", function() { return FormUtils; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var FormUtils = /** @class */ (function () {
    function FormUtils() {
    }
    FormUtils.minSelectedCheckboxes = function (min) {
        if (min === void 0) { min = 1; }
        var validator = function (formArray) {
            var totalSelected = formArray.controls
                .map(function (control) { return control.value; })
                .reduce(function (prev, next) { return next ? prev + next : prev; }, 0);
            return totalSelected >= min ? null : { required: true };
        };
        return validator;
    };
    FormUtils = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])()
    ], FormUtils);
    return FormUtils;
}());



/***/ }),

/***/ "./src/app/global-error-handler.service.ts":
/*!*************************************************!*\
  !*** ./src/app/global-error-handler.service.ts ***!
  \*************************************************/
/*! exports provided: GlobalErrorHandlerService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "GlobalErrorHandlerService", function() { return GlobalErrorHandlerService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var ngx_logger__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ngx-logger */ "./node_modules/ngx-logger/esm5/ngx-logger.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");





var GlobalErrorHandlerService = /** @class */ (function () {
    function GlobalErrorHandlerService(logger, injector) {
        this.logger = logger;
        this.injector = injector;
    }
    GlobalErrorHandlerService.prototype.handleError = function (error) {
        var router = this.injector.get(_angular_router__WEBPACK_IMPORTED_MODULE_4__["Router"]);
        if (error instanceof _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpErrorResponse"]) {
            // Backend returns unsuccessful response codes such as 404, 500 etc.
            this.logger.error(router.url + ', backend returned status code: ', error.status + ', and response body ' + error.message);
        }
        else {
            // A client-side or network error occurred.
            this.logger.error(router.url + ', a client or network error occurred:', error.message);
        }
    };
    GlobalErrorHandlerService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [ngx_logger__WEBPACK_IMPORTED_MODULE_3__["NGXLogger"], _angular_core__WEBPACK_IMPORTED_MODULE_1__["Injector"]])
    ], GlobalErrorHandlerService);
    return GlobalErrorHandlerService;
}());



/***/ }),

/***/ "./src/app/image-thumbnail/image-thumbnail.component.css":
/*!***************************************************************!*\
  !*** ./src/app/image-thumbnail/image-thumbnail.component.css ***!
  \***************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".thumbnail {\n  display: inline-block;\n  margin: 5px;\n}\n\n.thumbnail img {\n  height: 200px;\n}\n\nh5 {\n  color: white;\n  text-align: center;\n}\n\n.links {\n  text-align: center;\n}\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvaW1hZ2UtdGh1bWJuYWlsL2ltYWdlLXRodW1ibmFpbC5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0UscUJBQXFCO0VBQ3JCLFdBQVc7QUFDYjs7QUFFQTtFQUNFLGFBQWE7QUFDZjs7QUFFQTtFQUNFLFlBQVk7RUFDWixrQkFBa0I7QUFDcEI7O0FBQ0E7RUFDRSxrQkFBa0I7QUFDcEIiLCJmaWxlIjoic3JjL2FwcC9pbWFnZS10aHVtYm5haWwvaW1hZ2UtdGh1bWJuYWlsLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIudGh1bWJuYWlsIHtcbiAgZGlzcGxheTogaW5saW5lLWJsb2NrO1xuICBtYXJnaW46IDVweDtcbn1cblxuLnRodW1ibmFpbCBpbWcge1xuICBoZWlnaHQ6IDIwMHB4O1xufVxuXG5oNSB7XG4gIGNvbG9yOiB3aGl0ZTtcbiAgdGV4dC1hbGlnbjogY2VudGVyO1xufVxuLmxpbmtzIHtcbiAgdGV4dC1hbGlnbjogY2VudGVyO1xufVxuIl19 */"

/***/ }),

/***/ "./src/app/image-thumbnail/image-thumbnail.component.html":
/*!****************************************************************!*\
  !*** ./src/app/image-thumbnail/image-thumbnail.component.html ***!
  \****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"thumbnail\">\n  <p>\n    <img #imageThumbnail alt=\"Image\">\n  </p>\n  <h5>{{image?.filename}}</h5>\n  <p class=\"links\">\n    <a class=\"previewLink\" (click)=\"previewImage()\" target=\"_blank\">Preview</a>\n    &nbsp;\n    <a class=\"openLink\" (click)=\"openImage()\">Open</a>\n  </p>\n</div>\n"

/***/ }),

/***/ "./src/app/image-thumbnail/image-thumbnail.component.ts":
/*!**************************************************************!*\
  !*** ./src/app/image-thumbnail/image-thumbnail.component.ts ***!
  \**************************************************************/
/*! exports provided: ImageThumbnailComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ImageThumbnailComponent", function() { return ImageThumbnailComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _model_image__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../model/image */ "./src/app/model/image.ts");
/* harmony import */ var ngx_logger__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ngx-logger */ "./node_modules/ngx-logger/esm5/ngx-logger.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _services_session_data_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../services/session-data.service */ "./src/app/services/session-data.service.ts");
/* harmony import */ var _services_image_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../services/image.service */ "./src/app/services/image.service.ts");
/* harmony import */ var ngx_lightbox__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ngx-lightbox */ "./node_modules/ngx-lightbox/index.js");
/* harmony import */ var ngx_lightbox__WEBPACK_IMPORTED_MODULE_7___default = /*#__PURE__*/__webpack_require__.n(ngx_lightbox__WEBPACK_IMPORTED_MODULE_7__);
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");









var ImageThumbnailComponent = /** @class */ (function () {
    function ImageThumbnailComponent(logger, router, sessionDataService, imageService, _lightbox, _lighboxConfig, sanitizer) {
        this.logger = logger;
        this.router = router;
        this.sessionDataService = sessionDataService;
        this.imageService = imageService;
        this._lightbox = _lightbox;
        this._lighboxConfig = _lighboxConfig;
        this.sanitizer = sanitizer;
        _lighboxConfig.fitImageInViewPort = true;
        _lighboxConfig.showImageNumberLabel = false;
        _lighboxConfig.centerVertically = true;
        _lighboxConfig.resizeDuration = 0;
    }
    ImageThumbnailComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.imageService.getThumbnailImage$(this.image.id).subscribe(function (imageBlob) {
            _this.imageThumbnail.nativeElement.src = window.URL.createObjectURL(imageBlob);
        });
    };
    ImageThumbnailComponent.prototype.openImage = function () {
        var _this = this;
        this.logger.debug('Opening image ' + this.image.id);
        // this call retrieves the whole image data (the current image does not contain all lazy relations)
        this.imageService.getImage$(this.image.id).subscribe(function (next) {
            _this.sessionDataService.currentImage = next;
            _this.router.navigate(['/image']);
        });
    };
    ImageThumbnailComponent.prototype.previewImage = function () {
        var _this = this;
        this.imageService.getPreviewImage$(this.image.id).subscribe(function (imageBlob) {
            var albums = []; // used by Lightbox
            var album = {
                src: _this.sanitizer.bypassSecurityTrustResourceUrl(window.URL.createObjectURL(imageBlob)),
                caption: _this.image.filename,
            };
            albums.push(album);
            _this._lightbox.open(albums);
        });
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", _model_image__WEBPACK_IMPORTED_MODULE_2__["Image"])
    ], ImageThumbnailComponent.prototype, "image", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["ViewChild"])('imageThumbnail'),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", _angular_core__WEBPACK_IMPORTED_MODULE_1__["ElementRef"])
    ], ImageThumbnailComponent.prototype, "imageThumbnail", void 0);
    ImageThumbnailComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-image-thumbnail',
            template: __webpack_require__(/*! ./image-thumbnail.component.html */ "./src/app/image-thumbnail/image-thumbnail.component.html"),
            styles: [__webpack_require__(/*! ./image-thumbnail.component.css */ "./src/app/image-thumbnail/image-thumbnail.component.css")]
        })
        // see https://stackoverflow.com/questions/49411283/angular-5-http-get-images-from-back-end
        ,
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [ngx_logger__WEBPACK_IMPORTED_MODULE_3__["NGXLogger"], _angular_router__WEBPACK_IMPORTED_MODULE_4__["Router"], _services_session_data_service__WEBPACK_IMPORTED_MODULE_5__["SessionDataService"],
            _services_image_service__WEBPACK_IMPORTED_MODULE_6__["ImageService"], ngx_lightbox__WEBPACK_IMPORTED_MODULE_7__["Lightbox"], ngx_lightbox__WEBPACK_IMPORTED_MODULE_7__["LightboxConfig"],
            _angular_platform_browser__WEBPACK_IMPORTED_MODULE_8__["DomSanitizer"]])
    ], ImageThumbnailComponent);
    return ImageThumbnailComponent;
}());



/***/ }),

/***/ "./src/app/image-tool-bar/image-tool-bar.component.css":
/*!*************************************************************!*\
  !*** ./src/app/image-tool-bar/image-tool-bar.component.css ***!
  \*************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "#toolbar {\n  background-color: #7DE2DB;\n}\n\n#linkBackProject {\n  text-align: center;\n}\n\n#linkBackProject a {\n  color: white;\n  font-weight: bold;\n}\n\n/** use ::ng-deep to change component css */\n\n::ng-deep #toolbar .card-body {\n  background-color: #7DE2DB;\n  padding-left: 5px;\n  padding-right: 5px;\n}\n\n::ng-deep #toolbar .card-header {\n  background-color: #D91E63;\n}\n\n::ng-deep #toolbar .card-header button {\n  color: black;\n  padding-left: 0;\n  padding-right: 0;\n}\n\n/* it removes radio box because after adding accordions to the button groups it has appeared */\n\n::ng-deep #toolbar input[type=\"radio\"] {\n  -webkit-appearance: none;\n     -moz-appearance: none;\n          appearance: none;\n}\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvaW1hZ2UtdG9vbC1iYXIvaW1hZ2UtdG9vbC1iYXIuY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLHlCQUF5QjtBQUMzQjs7QUFFQTtFQUNFLGtCQUFrQjtBQUNwQjs7QUFFQTtFQUNFLFlBQVk7RUFDWixpQkFBaUI7QUFDbkI7O0FBRUEsMkNBQTJDOztBQUMzQztFQUNFLHlCQUF5QjtFQUN6QixpQkFBaUI7RUFDakIsa0JBQWtCO0FBQ3BCOztBQUNBO0VBQ0UseUJBQXlCO0FBQzNCOztBQUVBO0VBQ0UsWUFBWTtFQUNaLGVBQWU7RUFDZixnQkFBZ0I7QUFDbEI7O0FBRUEsOEZBQThGOztBQUM5RjtFQUNFLHdCQUFnQjtLQUFoQixxQkFBZ0I7VUFBaEIsZ0JBQWdCO0FBQ2xCIiwiZmlsZSI6InNyYy9hcHAvaW1hZ2UtdG9vbC1iYXIvaW1hZ2UtdG9vbC1iYXIuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIiN0b29sYmFyIHtcbiAgYmFja2dyb3VuZC1jb2xvcjogIzdERTJEQjtcbn1cblxuI2xpbmtCYWNrUHJvamVjdCB7XG4gIHRleHQtYWxpZ246IGNlbnRlcjtcbn1cblxuI2xpbmtCYWNrUHJvamVjdCBhIHtcbiAgY29sb3I6IHdoaXRlO1xuICBmb250LXdlaWdodDogYm9sZDtcbn1cblxuLyoqIHVzZSA6Om5nLWRlZXAgdG8gY2hhbmdlIGNvbXBvbmVudCBjc3MgKi9cbjo6bmctZGVlcCAjdG9vbGJhciAuY2FyZC1ib2R5IHtcbiAgYmFja2dyb3VuZC1jb2xvcjogIzdERTJEQjtcbiAgcGFkZGluZy1sZWZ0OiA1cHg7XG4gIHBhZGRpbmctcmlnaHQ6IDVweDtcbn1cbjo6bmctZGVlcCAjdG9vbGJhciAuY2FyZC1oZWFkZXIge1xuICBiYWNrZ3JvdW5kLWNvbG9yOiAjRDkxRTYzO1xufVxuXG46Om5nLWRlZXAgI3Rvb2xiYXIgLmNhcmQtaGVhZGVyIGJ1dHRvbiB7XG4gIGNvbG9yOiBibGFjaztcbiAgcGFkZGluZy1sZWZ0OiAwO1xuICBwYWRkaW5nLXJpZ2h0OiAwO1xufVxuXG4vKiBpdCByZW1vdmVzIHJhZGlvIGJveCBiZWNhdXNlIGFmdGVyIGFkZGluZyBhY2NvcmRpb25zIHRvIHRoZSBidXR0b24gZ3JvdXBzIGl0IGhhcyBhcHBlYXJlZCAqL1xuOjpuZy1kZWVwICN0b29sYmFyIGlucHV0W3R5cGU9XCJyYWRpb1wiXSB7XG4gIGFwcGVhcmFuY2U6IG5vbmU7XG59XG4iXX0= */"

/***/ }),

/***/ "./src/app/image-tool-bar/image-tool-bar.component.html":
/*!**************************************************************!*\
  !*** ./src/app/image-tool-bar/image-tool-bar.component.html ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div  id=\"toolbar\" class=\"btn-group-vertical btn-group-toggle\" ngbRadioGroup name=\"radioBasic\" [(ngModel)]=\"selectedTool\">\n  <p id=\"linkBackProject\">\n    <a (click)=\"onBrowseCurrentProject()\">Back to {{getCurrentProjectName()}}</a>\n  </p>\n  <ngb-accordion [closeOthers]=\"true\" [activeIds]=\"currentActivePanel\" (panelChange)=\"onPanelChange($event)\">\n    <ngb-panel id=\"documentAnalysisMode\" title=\"1. Document analysis\">\n      <ng-template ngbPanelContent>\n        <ngb-accordion [closeOthers]=\"true\" activeIds=\"daManual\">\n          <ngb-panel id=\"daManual\" title=\"Manual\">\n            <ng-template ngbPanelContent>\n              <label ngbButtonLabel class=\"btn-light\" (click)=\"clearDocumentAnalysis()\">\n                Clear\n              </label>\n              <label ngbButtonLabel class=\"btn-light\">\n                <input ngbButton type=\"radio\" value=\"101\"> Select\n              </label>\n              <label ngbButtonLabel class=\"btn-light\">\n                <input ngbButton type=\"radio\" value=\"102\"> Split pages\n              </label>\n              <label ngbButtonLabel class=\"btn-light\">\n                <input ngbButton type=\"radio\" value=\"103\"> Split regions\n              </label>\n              <label ngbButtonLabel class=\"btn-light\">\n                <input ngbButton type=\"radio\" value=\"104\" disabled> Draw pages\n              </label>\n              <label ngbButtonLabel class=\"btn-light\">\n                <input ngbButton type=\"radio\" value=\"105\" disabled> Draw regions\n              </label>\n            </ng-template>\n          </ngb-panel>\n          <ngb-panel id=\"daAutomatic\" title=\"Automatic\">\n            <ng-template ngbPanelContent>\n              <label ngbButtonLabel class=\"btn-light\">\n                <input ngbButton type=\"radio\" value=\"110\" disabled> Pages\n              </label>\n              <label ngbButtonLabel class=\"btn-light\">\n                <input ngbButton type=\"radio\" value=\"111\" disabled> Regions in pages\n              </label>\n            </ng-template>\n          </ngb-panel>\n        </ngb-accordion>\n      </ng-template>\n    </ngb-panel>\n    <ngb-panel id=\"symbolsMode\" title=\"2. Symbols\">\n      <ng-template ngbPanelContent>\n        <ngb-accordion [closeOthers]=\"true\" activeIds=\"symbolsManual\">\n          <ngb-panel id=\"symbolsManual\" title=\"Manual\">\n            <ng-template ngbPanelContent>\n              <label ngbButtonLabel class=\"btn-light\">\n                <input ngbButton type=\"radio\" value=\"200\"> Select\n              </label>\n              <label ngbButtonLabel class=\"btn-light\">\n                <input ngbButton type=\"radio\" value=\"201\"> Bounding boxes\n              </label>\n              <label ngbButtonLabel class=\"btn-light\">\n                <input ngbButton type=\"radio\" value=\"202\"> Strokes\n              </label>\n            </ng-template>\n          </ngb-panel>\n          <ngb-panel id=\"symmbolsAutomatic\" title=\"Automatic\">\n            <ng-template ngbPanelContent>\n              <label ngbButtonLabel class=\"btn-light\">\n                <input ngbButton type=\"radio\" value=\"210\" disabled> Image end to end\n              </label>\n              <label ngbButtonLabel class=\"btn-light\">\n                <input ngbButton type=\"radio\" value=\"211\" disabled> Staff end to end\n              </label>\n            </ng-template>\n          </ngb-panel>\n        </ngb-accordion>\n      </ng-template>\n    </ngb-panel>\n    <ngb-panel id=\"diplomatic\" title=\"3. Diplomatic\" [disabled]=\"true\">\n      <ng-template ngbPanelContent>\n      </ng-template>\n    </ngb-panel>\n  </ngb-accordion>\n</div>\n"

/***/ }),

/***/ "./src/app/image-tool-bar/image-tool-bar.component.ts":
/*!************************************************************!*\
  !*** ./src/app/image-tool-bar/image-tool-bar.component.ts ***!
  \************************************************************/
/*! exports provided: ImageToolBarComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ImageToolBarComponent", function() { return ImageToolBarComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _image_tool_bar_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./image-tool-bar.service */ "./src/app/image-tool-bar/image-tool-bar.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var ngx_logger__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ngx-logger */ "./node_modules/ngx-logger/esm5/ngx-logger.js");
/* harmony import */ var _services_session_data_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../services/session-data.service */ "./src/app/services/session-data.service.ts");






var ImageToolBarComponent = /** @class */ (function () {
    function ImageToolBarComponent(currentSession, toolbarService, router, logger) {
        this.currentSession = currentSession;
        this.toolbarService = toolbarService;
        this.router = router;
        this.logger = logger;
    }
    ImageToolBarComponent.prototype.ngOnInit = function () {
    };
    ImageToolBarComponent.prototype.getCurrentProjectName = function () {
        return this.currentSession.currentProject.name;
    };
    ImageToolBarComponent.prototype.onBrowseCurrentProject = function () {
        this.router.navigate(['/project/' + this.currentSession.currentProject.id]);
    };
    Object.defineProperty(ImageToolBarComponent.prototype, "selectedTool", {
        get: function () {
            return this.toolbarService.selectedTool;
        },
        set: function (value) {
            this.toolbarService.selectedTool = value;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(ImageToolBarComponent.prototype, "currentActivePanel", {
        get: function () {
            return this.toolbarService.currentActivePanel;
        },
        set: function (value) {
            this.toolbarService.currentActivePanel = value;
        },
        enumerable: true,
        configurable: true
    });
    ImageToolBarComponent.prototype.clearDocumentAnalysis = function () {
        this.toolbarService.clearDocumentAnalysisEvent.emit();
    };
    ImageToolBarComponent.prototype.onPanelChange = function ($event) {
        this.logger.debug('Panel change ' + $event.panelId + ', nextState=' + $event.nextState);
        if ($event.nextState) {
            this.toolbarService.currentActivePanel = $event.panelId;
            switch ($event.panelId) {
                case 'documentAnalysisMode':
                    this.router.navigate(['/image']);
                    break;
                case 'symbolsMode':
                    this.router.navigate(['/symbols']);
                    break;
            }
        }
    };
    ImageToolBarComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-image-tool-bar',
            template: __webpack_require__(/*! ./image-tool-bar.component.html */ "./src/app/image-tool-bar/image-tool-bar.component.html"),
            styles: [__webpack_require__(/*! ./image-tool-bar.component.css */ "./src/app/image-tool-bar/image-tool-bar.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_services_session_data_service__WEBPACK_IMPORTED_MODULE_5__["SessionDataService"], _image_tool_bar_service__WEBPACK_IMPORTED_MODULE_2__["ImageToolBarService"], _angular_router__WEBPACK_IMPORTED_MODULE_3__["Router"], ngx_logger__WEBPACK_IMPORTED_MODULE_4__["NGXLogger"]])
    ], ImageToolBarComponent);
    return ImageToolBarComponent;
}());



/***/ }),

/***/ "./src/app/image-tool-bar/image-tool-bar.service.ts":
/*!**********************************************************!*\
  !*** ./src/app/image-tool-bar/image-tool-bar.service.ts ***!
  \**********************************************************/
/*! exports provided: ImageToolBarService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ImageToolBarService", function() { return ImageToolBarService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");



var ImageToolBarService = /** @class */ (function () {
    function ImageToolBarService() {
        this._selectedTool = '101';
        this._selectedToolSubject = new rxjs__WEBPACK_IMPORTED_MODULE_2__["Subject"]();
        this.selectedTool$ = this._selectedToolSubject.asObservable();
        this.clearDocumentAnalysisEvent = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
        this.currentActivePanel = 'documentAnalysisMode';
    }
    Object.defineProperty(ImageToolBarService.prototype, "selectedTool", {
        get: function () {
            return this._selectedTool;
        },
        set: function (value) {
            this._selectedTool = value;
            this._selectedToolSubject.next(value);
        },
        enumerable: true,
        configurable: true
    });
    ImageToolBarService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
            providedIn: 'root'
        })
        /**
         * It contains the share data of the toolbar
         */
        ,
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], ImageToolBarService);
    return ImageToolBarService;
}());



/***/ }),

/***/ "./src/app/image/image.component.css":
/*!*******************************************!*\
  !*** ./src/app/image/image.component.css ***!
  \*******************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2ltYWdlL2ltYWdlLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/image/image.component.html":
/*!********************************************!*\
  !*** ./src/app/image/image.component.html ***!
  \********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"row\" xmlns:svg=\"\">\n  <div class=\"col-2\">\n    <app-image-tool-bar></app-image-tool-bar>\n </div>\n\n  <!-------------- CONTENT ------------------>\n  <div class=\"col-10\">\n    <div class=\"row\" id=\"manuscriptImage\">\n      <div class=\"col\">\n        <app-document-analysis-view #appDocumentAnalysisView (mouseEvent)=\"onMouseEvent($event)\"></app-document-analysis-view>\n      </div>\n    </div>\n  </div>\n</div>\n\n\n"

/***/ }),

/***/ "./src/app/image/image.component.ts":
/*!******************************************!*\
  !*** ./src/app/image/image.component.ts ***!
  \******************************************/
/*! exports provided: ImageComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ImageComponent", function() { return ImageComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var ngx_logger__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ngx-logger */ "./node_modules/ngx-logger/esm5/ngx-logger.js");
/* harmony import */ var _component_can_deactivate__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../component-can-deactivate */ "./src/app/component-can-deactivate.ts");
/* harmony import */ var _image_tool_bar_image_tool_bar_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../image-tool-bar/image-tool-bar.service */ "./src/app/image-tool-bar/image-tool-bar.service.ts");
/* harmony import */ var _document_analysis_view_document_analysis_view_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../document-analysis-view/document-analysis-view.component */ "./src/app/document-analysis-view/document-analysis-view.component.ts");




// import {ResizedEvent} from 'angular-resize-event/resized-event';



var ImageComponent = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](ImageComponent, _super);
    function ImageComponent(route, logger, toolbarService) {
        var _this = _super.call(this) || this;
        _this.route = route;
        _this.logger = logger;
        _this.toolbarService = toolbarService;
        return _this;
    }
    ImageComponent.prototype.ngOnInit = function () {
    };
    ImageComponent.prototype.initToolBarInteraction = function () {
        var _this = this;
        this.logger.info('Initiating image tool bar interaction');
        // this way, when a new image is opened, despite the previous selected mode, the documentAnalysis is selected
        this.toolbarService.currentActivePanel = 'documentAnalysisMode';
        this.activateEditMode();
        this.toolbarService.selectedTool$.subscribe(function (next) {
            switch (next) {
                case '101': // select
                    _this.activateEditMode();
                    break;
                case '102': // split pages
                    _this.documentAnalysisView.activatePageSplitMode();
                    break;
                case '103': // split regions
                    _this.documentAnalysisView.activateRegionSplitMode();
                    break;
            }
        });
    };
    ImageComponent.prototype.activateEditMode = function () {
        if (this.toolbarService.selectedTool !== '101') {
            this.toolbarService.selectedTool = '101';
            this.documentAnalysisView.activateEditMode();
        }
    };
    ImageComponent.prototype.ngAfterViewInit = function () {
        var _this = this;
        this.logger.debug('ngAfterViewInit');
        this.initToolBarInteraction();
        this.toolbarService.clearDocumentAnalysisEvent.subscribe(function (next) {
            _this.clearDocumentAnalysis();
        });
    };
    /* It draws the page and region bounding boxes */
    /* private setImage(serviceImage: Image) {
      this.image = serviceImage;
      this.logger.debug('Setting image ' + serviceImage + ' ' + this.image.filename);
      this.imageURL = this.projectURLs + '/' + this.image.filename;
    } */
    ImageComponent.prototype.canDeactivate = function () {
        return false; // TODO
    };
    ImageComponent.prototype.clearDocumentAnalysis = function () {
        if (confirm('Do you really want to clear the document analysis?')) {
            this.documentAnalysisView.clearDocumentAnalysis();
        }
    };
    ImageComponent.prototype.onMouseEvent = function ($event) {
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["ViewChild"])('appDocumentAnalysisView'),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", _document_analysis_view_document_analysis_view_component__WEBPACK_IMPORTED_MODULE_6__["DocumentAnalysisViewComponent"])
    ], ImageComponent.prototype, "documentAnalysisView", void 0);
    ImageComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-image',
            template: __webpack_require__(/*! ./image.component.html */ "./src/app/image/image.component.html"),
            styles: [__webpack_require__(/*! ./image.component.css */ "./src/app/image/image.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_router__WEBPACK_IMPORTED_MODULE_2__["ActivatedRoute"],
            ngx_logger__WEBPACK_IMPORTED_MODULE_3__["NGXLogger"],
            _image_tool_bar_image_tool_bar_service__WEBPACK_IMPORTED_MODULE_5__["ImageToolBarService"]])
    ], ImageComponent);
    return ImageComponent;
}(_component_can_deactivate__WEBPACK_IMPORTED_MODULE_4__["ComponentCanDeactivate"]));



/***/ }),

/***/ "./src/app/inline-edit/inline-edit.component.html":
/*!********************************************************!*\
  !*** ./src/app/inline-edit/inline-edit.component.html ***!
  \********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div>\n  <div *ngIf=\"editing\">\n    <input [required]=\"required\" (blur)=\"onBlur($event)\" [name]=\"value\" [(ngModel)]=\"value\" [placeholder]=\"label\" [size]=\"size\"/>\n  </div>\n  <div *ngIf=\"!editing\">\n    <a href=\"#\" (click)=\"beginEdit(value)\" (focus)=\"beginEdit(value)\" tabindex=\"0\">{{value}}</a>\n  </div>\n</div>\n"

/***/ }),

/***/ "./src/app/inline-edit/inline-edit.component.scss":
/*!********************************************************!*\
  !*** ./src/app/inline-edit/inline-edit.component.scss ***!
  \********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2lubGluZS1lZGl0L2lubGluZS1lZGl0LmNvbXBvbmVudC5zY3NzIn0= */"

/***/ }),

/***/ "./src/app/inline-edit/inline-edit.component.ts":
/*!******************************************************!*\
  !*** ./src/app/inline-edit/inline-edit.component.ts ***!
  \******************************************************/
/*! exports provided: InlineEditComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "InlineEditComponent", function() { return InlineEditComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");



var VALUE_ACCESSOR = {
    provide: _angular_forms__WEBPACK_IMPORTED_MODULE_2__["NG_VALUE_ACCESSOR"],
    useExisting: Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["forwardRef"])(function () { return InlineEditComponent; }),
    multi: true
};
var InlineEditComponent = /** @class */ (function () {
    function InlineEditComponent() {
        this.size = '80';
        this.label = 'Enter value here';
        this.required = true;
        this.changed = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
        this.preValue = '';
        this.editing = false;
        this.onChange = Function.prototype;
        this.onTouched = Function.prototype;
    }
    Object.defineProperty(InlineEditComponent.prototype, "value", {
        get: function () {
            if (this._value === null || this._value === '') {
                return this.label;
            }
            else {
                return this._value;
            }
        },
        set: function (v) {
            if (v !== this._value) {
                this._value = v;
            }
        },
        enumerable: true,
        configurable: true
    });
    InlineEditComponent.prototype.writeValue = function (value) {
        this._value = value;
    };
    InlineEditComponent.prototype.registerOnChange = function (fn) {
        this.onChange = fn;
    };
    InlineEditComponent.prototype.registerOnTouched = function (fn) {
        this.onTouched = fn;
    };
    InlineEditComponent.prototype.onBlur = function ($event) {
        this.editing = false;
        if (this._value === '') {
            this._value = 'No value available';
        }
        this.changed.emit(this._value);
    };
    InlineEditComponent.prototype.beginEdit = function (value) {
        this.preValue = value;
        this.editing = true;
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Object)
    ], InlineEditComponent.prototype, "size", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Object)
    ], InlineEditComponent.prototype, "label", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Object)
    ], InlineEditComponent.prototype, "required", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Output"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Object)
    ], InlineEditComponent.prototype, "changed", void 0);
    InlineEditComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-inline-edit',
            template: __webpack_require__(/*! ./inline-edit.component.html */ "./src/app/inline-edit/inline-edit.component.html"),
            providers: [VALUE_ACCESSOR],
            styles: [__webpack_require__(/*! ./inline-edit.component.scss */ "./src/app/inline-edit/inline-edit.component.scss")]
        })
    ], InlineEditComponent);
    return InlineEditComponent;
}());



/***/ }),

/***/ "./src/app/login/login.component.css":
/*!*******************************************!*\
  !*** ./src/app/login/login.component.css ***!
  \*******************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "input {\n  margin: 10px;\n}\n\nh2 {\n  margin-top: 20vh;\n}\n\n#login button {\n  margin-top: 10px;\n\n}\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvbG9naW4vbG9naW4uY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLFlBQVk7QUFDZDs7QUFFQTtFQUNFLGdCQUFnQjtBQUNsQjs7QUFFQTtFQUNFLGdCQUFnQjs7QUFFbEIiLCJmaWxlIjoic3JjL2FwcC9sb2dpbi9sb2dpbi5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiaW5wdXQge1xuICBtYXJnaW46IDEwcHg7XG59XG5cbmgyIHtcbiAgbWFyZ2luLXRvcDogMjB2aDtcbn1cblxuI2xvZ2luIGJ1dHRvbiB7XG4gIG1hcmdpbi10b3A6IDEwcHg7XG5cbn1cbiJdfQ== */"

/***/ }),

/***/ "./src/app/login/login.component.html":
/*!********************************************!*\
  !*** ./src/app/login/login.component.html ***!
  \********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"row\" id=\"login\">\n  <div class=\"offset-4 col\">\n    <h2>LOGIN</h2>\n    <p>{{message}}</p>\n\n    <div *ngIf=\"!isLoggedIn()\">\n      <form name=\"form\" (ngSubmit)=\"f.form.valid && login()\" #f=\"ngForm\" novalidate>\n        <div [ngClass]=\"{ 'has-error': f.submitted && !username.valid }\">\n          <label>Username</label>\n          <input type=\"text\"\n                 name=\"username\" [(ngModel)]=\"model.username\"\n                 #username=\"ngModel\" required />\n          <div *ngIf=\"f.submitted\n              && !username.valid\">Username is required</div>\n        </div>\n        <div [ngClass]=\"{ 'has-error': f.submitted && !password.valid }\">\n          <label>Password</label>\n          <input type=\"password\"\n                 name=\"password\" [(ngModel)]=\"model.password\"\n                 #password=\"ngModel\" required />\n          <div *ngIf=\"f.submitted\n              && !password.valid\">Password is required</div>\n        </div>\n        <div class=\"offset-1\">\n          <button class=\"btn btn-primary\" [disabled]=\"loading\">Login</button>\n        </div>\n      </form>\n    </div>\n\n    <div *ngIf=\"isLoggedIn()\">\n      Logged in ...\n      <button class=\"btn btn-primary\" (click)=\"logout()\" >Logout</button>\n    </div>\n  </div>\n</div>\n<!--<p>\n  <button (click)=\"login()\"  *ngIf=\"!authService.isLoggedIn\">Login</button>\n  <button (click)=\"logout()\" *ngIf=\"authService.isLoggedIn\">Logout</button>\n</p>-->\n"

/***/ }),

/***/ "./src/app/login/login.component.ts":
/*!******************************************!*\
  !*** ./src/app/login/login.component.ts ***!
  \******************************************/
/*! exports provided: LoginComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoginComponent", function() { return LoginComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var ngx_logger__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ngx-logger */ "./node_modules/ngx-logger/esm5/ngx-logger.js");
/* harmony import */ var _services_auth_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../services/auth.service */ "./src/app/services/auth.service.ts");





var LoginComponent = /** @class */ (function () {
    function LoginComponent(authService, router, logger) {
        this.authService = authService;
        this.router = router;
        this.logger = logger;
        this.model = {
            'username': '',
            'password': ''
        };
        this.setMessage();
    }
    LoginComponent.prototype.setMessage = function () {
        /* if (this.im3WSService.authenticated()) {
           this.message = 'Logged in as ' + this.im3WSService.getUser().username;
         } else {
           this.message = 'Logged out';
         } */
    };
    // TODO Refactorizar
    LoginComponent.prototype.login = function () {
        var _this = this;
        this.logger.debug('Loging in');
        this.message = 'Trying to log in ...';
        this.authService.login(this.model.username, this.model.password).subscribe(function (next) {
            _this.authService.setUser(next);
            _this.setMessage();
            if (_this.authService.authenticated()) {
                var redirect = 'startup';
                // Redirect the user
                _this.router.navigate([redirect]);
            }
        });
    };
    LoginComponent.prototype.logout = function () {
        this.logger.debug('Logging out');
        this.authService.logout();
        this.setMessage();
    };
    LoginComponent.prototype.isLoggedIn = function () {
        return this.authService.authenticated();
    };
    LoginComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-login',
            template: __webpack_require__(/*! ./login.component.html */ "./src/app/login/login.component.html"),
            styles: [__webpack_require__(/*! ./login.component.css */ "./src/app/login/login.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_services_auth_service__WEBPACK_IMPORTED_MODULE_4__["AuthService"], _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"], ngx_logger__WEBPACK_IMPORTED_MODULE_3__["NGXLogger"]])
    ], LoginComponent);
    return LoginComponent;
}());

/*
Copyright 2017-2018 Google Inc. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/


/***/ }),

/***/ "./src/app/messages/message.service.ts":
/*!*********************************************!*\
  !*** ./src/app/messages/message.service.ts ***!
  \*********************************************/
/*! exports provided: MessageService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MessageService", function() { return MessageService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var MessageService = /** @class */ (function () {
    function MessageService() {
        this.messages = [];
    }
    MessageService.prototype.add = function (message) {
        this.messages.push(message);
    };
    MessageService.prototype.clear = function () {
        this.messages = [];
    };
    MessageService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
            providedIn: 'root',
        })
    ], MessageService);
    return MessageService;
}());



/***/ }),

/***/ "./src/app/messages/messages.component.css":
/*!*************************************************!*\
  !*** ./src/app/messages/messages.component.css ***!
  \*************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL21lc3NhZ2VzL21lc3NhZ2VzLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/messages/messages.component.html":
/*!**************************************************!*\
  !*** ./src/app/messages/messages.component.html ***!
  \**************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div *ngIf=\"messageService.messages.length\">\n\n  <h2>Messages</h2>\n  <button class=\"clear\"\n          (click)=\"messageService.clear()\">clear</button>\n  <div *ngFor='let message of messageService.messages'> {{message}} </div>\n\n</div>\n"

/***/ }),

/***/ "./src/app/messages/messages.component.ts":
/*!************************************************!*\
  !*** ./src/app/messages/messages.component.ts ***!
  \************************************************/
/*! exports provided: MessagesComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MessagesComponent", function() { return MessagesComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _message_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./message.service */ "./src/app/messages/message.service.ts");



var MessagesComponent = /** @class */ (function () {
    function MessagesComponent(messageService) {
        this.messageService = messageService;
    }
    MessagesComponent.prototype.ngOnInit = function () {
    };
    MessagesComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-messages',
            template: __webpack_require__(/*! ./messages.component.html */ "./src/app/messages/messages.component.html"),
            styles: [__webpack_require__(/*! ./messages.component.css */ "./src/app/messages/messages.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_message_service__WEBPACK_IMPORTED_MODULE_2__["MessageService"]])
    ], MessagesComponent);
    return MessagesComponent;
}());



/***/ }),

/***/ "./src/app/model/image.ts":
/*!********************************!*\
  !*** ./src/app/model/image.ts ***!
  \********************************/
/*! exports provided: Image */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Image", function() { return Image; });
var Image = /** @class */ (function () {
    function Image(id, filename, pages, state) {
        this.id = id;
        this.filename = filename;
        this.pages = pages;
        this.state = state;
    }
    return Image;
}());



/***/ }),

/***/ "./src/app/model/point.ts":
/*!********************************!*\
  !*** ./src/app/model/point.ts ***!
  \********************************/
/*! exports provided: Point */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Point", function() { return Point; });
var Point = /** @class */ (function () {
    function Point(time, x, y) {
        this.time = time;
        this.x = x;
        this.y = y;
    }
    return Point;
}());



/***/ }),

/***/ "./src/app/model/project.ts":
/*!**********************************!*\
  !*** ./src/app/model/project.ts ***!
  \**********************************/
/*! exports provided: Project */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Project", function() { return Project; });
var Project = /** @class */ (function () {
    function Project() {
    }
    /*constructor(id: number, name: string, path: string, comments: string, thumbnailBase64Encoding: string, imagesOrdering: string,
                images: Array<Image>) {
      this.id = id;
      this.name = name;
      this.path = path;
      this.thumbnailBase64Encoding = thumbnailBase64Encoding;
      this.comments = comments;
      this.imagesOrdering = imagesOrdering;
      this.orderImageArray();
    }*/
    Project.prototype.orderImageArray = function () {
        var _this = this;
        if (this.images) {
            // first insert input images in a map
            var imagesMap_1 = new Map();
            this.images.forEach(function (image) {
                imagesMap_1.set(image.id, image);
            });
            var newImages_1 = new Array();
            // insert images as appear on the imagesOrdering
            if (this.imagesOrdering) {
                this.images = new Array();
                var imageOrders = this.imagesOrdering.split(',');
                imageOrders.forEach(function (order) {
                    var imageId = Number(order);
                    var image = imagesMap_1.get(imageId);
                    if (image) { // if not something may go wrong but it is not important here
                        newImages_1.push(image);
                        imagesMap_1.delete(imageId);
                    }
                });
            }
            else {
                this.imagesOrdering = '';
            }
            // now insert the other images not inserted yet
            imagesMap_1.forEach(function (value, key) {
                if (_this.imagesOrdering.length > 0) {
                    _this.imagesOrdering += ',';
                }
                _this.imagesOrdering += key;
                newImages_1.push(value);
            });
            this.images = newImages_1;
        }
    };
    return Project;
}());



/***/ }),

/***/ "./src/app/model/state.ts":
/*!********************************!*\
  !*** ./src/app/model/state.ts ***!
  \********************************/
/*! exports provided: State */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "State", function() { return State; });
var State = /** @class */ (function () {
    function State() {
    }
    return State;
}());



/***/ }),

/***/ "./src/app/model/stroke.ts":
/*!*********************************!*\
  !*** ./src/app/model/stroke.ts ***!
  \*********************************/
/*! exports provided: Stroke */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Stroke", function() { return Stroke; });
var Stroke = /** @class */ (function () {
    function Stroke(points) {
        this.points = points;
    }
    return Stroke;
}());



/***/ }),

/***/ "./src/app/model/strokes.ts":
/*!**********************************!*\
  !*** ./src/app/model/strokes.ts ***!
  \**********************************/
/*! exports provided: Strokes */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Strokes", function() { return Strokes; });
var Strokes = /** @class */ (function () {
    function Strokes(strokeList) {
        this.strokeList = strokeList;
    }
    return Strokes;
}());



/***/ }),

/***/ "./src/app/model/user.ts":
/*!*******************************!*\
  !*** ./src/app/model/user.ts ***!
  \*******************************/
/*! exports provided: User */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "User", function() { return User; });
var User = /** @class */ (function () {
    function User() {
    }
    Object.defineProperty(User.prototype, "id", {
        get: function () {
            return this._id;
        },
        set: function (value) {
            this._id = value;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(User.prototype, "username", {
        get: function () {
            return this._username;
        },
        set: function (value) {
            this._username = value;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(User.prototype, "projectsCreated", {
        get: function () {
            return this._projectsCreated;
        },
        set: function (value) {
            this._projectsCreated = value;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(User.prototype, "permissions", {
        get: function () {
            return this._permissions;
        },
        set: function (value) {
            this._permissions = value;
        },
        enumerable: true,
        configurable: true
    });
    return User;
}());



/***/ }),

/***/ "./src/app/new-project-form/new-project-form.component.css":
/*!*****************************************************************!*\
  !*** ./src/app/new-project-form/new-project-form.component.css ***!
  \*****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL25ldy1wcm9qZWN0LWZvcm0vbmV3LXByb2plY3QtZm9ybS5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/new-project-form/new-project-form.component.html":
/*!******************************************************************!*\
  !*** ./src/app/new-project-form/new-project-form.component.html ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<form [formGroup]=\"newProjectForm\" (ngSubmit)=\"onSubmit()\">\n  <div class=\"row\">\n    <div class=\"col-6\">\n      <p>\n        <label>Project name <input type=\"text\" formControlName=\"name\" size=\"128\"> (required)</label>\n      </p>\n      <p>\n        <label>Composer <input type=\"text\" formControlName=\"composer\" size=\"128\"></label>\n      </p>\n      <p>\n        <input type=\"radio\" name=\"notationType\" formControlName=\"notationType\" value=\"eMensural\" checked>Mensural &nbsp;\n        <input type=\"radio\" name=\"notationType\" formControlName=\"notationType\" value=\"eModern\">Modern &nbsp; (required)\n      </p>\n      <p>\n        <input type=\"radio\" name=\"manuscriptType\" formControlName=\"manuscriptType\" value=\"eHandwritten\" checked>Handwritten &nbsp;\n        <input type=\"radio\" name=\"manuscriptType\" formControlName=\"manuscriptType\" value=\"ePrinted\">Printed&nbsp; (required)\n      </p>\n      <p>\n        <label>Comments <input type=\"text\" formControlName=\"comments\"></label>\n      </p>\n    </div>\n    <div *ngIf=\"imgSrc\" class=\"col-6\">\n      <h5>Preview</h5>\n      <img class=\"img-fluid\" [src]=\"imgSrc\">\n    </div>\n  </div>\n  <div class=\"row\">\n    <div class=\"col\">\n      <label>Upload poster image (use mouse scroll to zoom)</label>\n      <ngx-img (onSelect)=\"onSelect($event)\" (onReset)=\"onReset()\" [config]=\"{ fileSize: 10000, height: 200, crop: [ { minWidth: 200, maxWidth: 200, ratio: 1 } ] }\"></ngx-img>\n    </div>\n  </div>\n\n  <div class=\"row\">\n    <div class=\"col\">\n      <button type=\"submit\" [disabled]=\"!newProjectForm.valid\">Submit</button>\n    </div>\n  </div>\n\n</form>\n"

/***/ }),

/***/ "./src/app/new-project-form/new-project-form.component.ts":
/*!****************************************************************!*\
  !*** ./src/app/new-project-form/new-project-form.component.ts ***!
  \****************************************************************/
/*! exports provided: NewProjectFormComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "NewProjectFormComponent", function() { return NewProjectFormComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var ngx_logger__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ngx-logger */ "./node_modules/ngx-logger/esm5/ngx-logger.js");
/* harmony import */ var _services_project_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../services/project.service */ "./src/app/services/project.service.ts");





// import { ImageCropperModule } from 'ngx-image-cropper';


var NewProjectFormComponent = /** @class */ (function () {
    function NewProjectFormComponent(fb, projectService, router, logger) {
        this.fb = fb;
        this.projectService = projectService;
        this.router = router;
        this.logger = logger;
        this.newProjectForm = this.fb.group({
            name: ['', _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            composer: [''],
            notationType: ['eMensural', _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            manuscriptType: ['eHandwritten', _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            comments: ['']
        });
    }
    NewProjectFormComponent.prototype.ngOnInit = function () {
    };
    NewProjectFormComponent.prototype.onReset = function () {
    };
    NewProjectFormComponent.prototype.onSelect = function ($event) {
        this.imgSrc = $event;
    };
    NewProjectFormComponent.prototype.onSubmit = function () {
        var _this = this;
        this.logger.debug('Submitting new project');
        this.projectService.newProject$(this.newProjectForm.controls['name'].value, this.newProjectForm.controls['composer'].value, this.newProjectForm.controls['notationType'].value, this.newProjectForm.controls['manuscriptType'].value, this.newProjectForm.controls['comments'].value, this.imgSrc)
            .subscribe(function (serviceNewProject) {
            return _this.router.navigate(['/project/get', { id: serviceNewProject.id }]);
        });
        // TODO ¿Si hay error?
    };
    NewProjectFormComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-new-project-form',
            template: __webpack_require__(/*! ./new-project-form.component.html */ "./src/app/new-project-form/new-project-form.component.html"),
            styles: [__webpack_require__(/*! ./new-project-form.component.css */ "./src/app/new-project-form/new-project-form.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"], _services_project_service__WEBPACK_IMPORTED_MODULE_5__["ProjectService"], _angular_router__WEBPACK_IMPORTED_MODULE_3__["Router"], ngx_logger__WEBPACK_IMPORTED_MODULE_4__["NGXLogger"]])
    ], NewProjectFormComponent);
    return NewProjectFormComponent;
}());



/***/ }),

/***/ "./src/app/payloads/post-strokes.ts":
/*!******************************************!*\
  !*** ./src/app/payloads/post-strokes.ts ***!
  \******************************************/
/*! exports provided: PostStrokes */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PostStrokes", function() { return PostStrokes; });
var PostStrokes = /** @class */ (function () {
    function PostStrokes(regionID, points) {
        this.regionID = regionID;
        this.points = points;
    }
    return PostStrokes;
}());



/***/ }),

/***/ "./src/app/payloads/string-body.ts":
/*!*****************************************!*\
  !*** ./src/app/payloads/string-body.ts ***!
  \*****************************************/
/*! exports provided: StringBody */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "StringBody", function() { return StringBody; });
var StringBody = /** @class */ (function () {
    function StringBody(value) {
        this.value = value;
    }
    return StringBody;
}());



/***/ }),

/***/ "./src/app/preferences/preferences.component.css":
/*!*******************************************************!*\
  !*** ./src/app/preferences/preferences.component.css ***!
  \*******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3ByZWZlcmVuY2VzL3ByZWZlcmVuY2VzLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/preferences/preferences.component.html":
/*!********************************************************!*\
  !*** ./src/app/preferences/preferences.component.html ***!
  \********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<h2>Preferences</h2>\n\n<form [formGroup]=\"preferencesGroup\" (ngSubmit)=\"onSubmit()\">\n        <div *ngFor=\"let classifierType of classifierTypes; trackBy: trackByClassifierTypeFunction\" class=\"form-group\">\n          <h3>{{classifierType.name}}</h3>\n          <label class=\"center-block\">Symbol classifier based on image:\n            <select class=\"form-control\" formControlName=\"symbolImageClassifiersSelect\">\n              <option *ngFor=\"let classifier of classifierType.classifiers; trackBy: trackByClassifierFunction\" [ngValue]=\"classifier.id\">{{classifier.description}}</option>\n            </select>\n          </label>\n        </div>\n        <div>\n          <button type=\"submit\">Submit</button>\n        </div>\n</form>\n"

/***/ }),

/***/ "./src/app/preferences/preferences.component.ts":
/*!******************************************************!*\
  !*** ./src/app/preferences/preferences.component.ts ***!
  \******************************************************/
/*! exports provided: PreferencesComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PreferencesComponent", function() { return PreferencesComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _services_classifier_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../services/classifier.service */ "./src/app/services/classifier.service.ts");




var PreferencesComponent = /** @class */ (function () {
    function PreferencesComponent(classifierService) {
        this.classifierService = classifierService;
        this.preferencesGroup = new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormGroup"]({
            symbolImageClassifiersSelect: new _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControl"]()
        });
    }
    PreferencesComponent.prototype.onSubmit = function () {
    };
    PreferencesComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.classifierService.getClassifierTypes$().subscribe(function (next) {
            _this.classifierTypes = next;
        });
    };
    PreferencesComponent.prototype.trackByClassifierFunction = function (index, item) {
        return item.id; // unique id corresponding to the item
    };
    PreferencesComponent.prototype.trackByClassifierTypeFunction = function (index, item) {
        return item.id; // unique id corresponding to the item
    };
    PreferencesComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-preferences',
            template: __webpack_require__(/*! ./preferences.component.html */ "./src/app/preferences/preferences.component.html"),
            styles: [__webpack_require__(/*! ./preferences.component.css */ "./src/app/preferences/preferences.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_services_classifier_service__WEBPACK_IMPORTED_MODULE_3__["ClassifierService"]])
    ], PreferencesComponent);
    return PreferencesComponent;
}());



/***/ }),

/***/ "./src/app/project/project.component.css":
/*!***********************************************!*\
  !*** ./src/app/project/project.component.css ***!
  \***********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "/*----- Dragula ----- */\n/* in-flight clone */\n.gu-mirror {\n  position: fixed !important;\n  margin: 0 !important;\n  z-index: 9999 !important;\n  opacity: 0.8;\n  -ms-filter: \"progid:DXImageTransform.Microsoft.Alpha(Opacity=80)\";\n  filter: alpha(opacity=80);\n  pointer-events: none;\n}\n/* high-performance display:none; helper */\n.gu-hide {\n  left: -9999px !important;\n}\n/* added to mirrorContainer (default = body) while dragging */\n.gu-unselectable {\n  -webkit-user-select: none !important;\n  -moz-user-select: none !important;\n  -ms-user-select: none !important;\n  user-select: none !important;\n}\n/* added to the source element while its mirror is dragged */\n.gu-transit {\n  opacity: 0.2;\n  -ms-filter: \"progid:DXImageTransform.Microsoft.Alpha(Opacity=20)\";\n  filter: alpha(opacity=20);\n}\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvcHJvamVjdC9wcm9qZWN0LmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUEsdUJBQXVCO0FBQ3ZCLG9CQUFvQjtBQUNwQjtFQUNFLDBCQUEwQjtFQUMxQixvQkFBb0I7RUFDcEIsd0JBQXdCO0VBQ3hCLFlBQVk7RUFDWixpRUFBaUU7RUFDakUseUJBQXlCO0VBQ3pCLG9CQUFvQjtBQUN0QjtBQUNBLDBDQUEwQztBQUMxQztFQUNFLHdCQUF3QjtBQUMxQjtBQUNBLDZEQUE2RDtBQUM3RDtFQUNFLG9DQUFvQztFQUNwQyxpQ0FBaUM7RUFDakMsZ0NBQWdDO0VBQ2hDLDRCQUE0QjtBQUM5QjtBQUNBLDREQUE0RDtBQUM1RDtFQUNFLFlBQVk7RUFDWixpRUFBaUU7RUFDakUseUJBQXlCO0FBQzNCIiwiZmlsZSI6InNyYy9hcHAvcHJvamVjdC9wcm9qZWN0LmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIvKi0tLS0tIERyYWd1bGEgLS0tLS0gKi9cbi8qIGluLWZsaWdodCBjbG9uZSAqL1xuLmd1LW1pcnJvciB7XG4gIHBvc2l0aW9uOiBmaXhlZCAhaW1wb3J0YW50O1xuICBtYXJnaW46IDAgIWltcG9ydGFudDtcbiAgei1pbmRleDogOTk5OSAhaW1wb3J0YW50O1xuICBvcGFjaXR5OiAwLjg7XG4gIC1tcy1maWx0ZXI6IFwicHJvZ2lkOkRYSW1hZ2VUcmFuc2Zvcm0uTWljcm9zb2Z0LkFscGhhKE9wYWNpdHk9ODApXCI7XG4gIGZpbHRlcjogYWxwaGEob3BhY2l0eT04MCk7XG4gIHBvaW50ZXItZXZlbnRzOiBub25lO1xufVxuLyogaGlnaC1wZXJmb3JtYW5jZSBkaXNwbGF5Om5vbmU7IGhlbHBlciAqL1xuLmd1LWhpZGUge1xuICBsZWZ0OiAtOTk5OXB4ICFpbXBvcnRhbnQ7XG59XG4vKiBhZGRlZCB0byBtaXJyb3JDb250YWluZXIgKGRlZmF1bHQgPSBib2R5KSB3aGlsZSBkcmFnZ2luZyAqL1xuLmd1LXVuc2VsZWN0YWJsZSB7XG4gIC13ZWJraXQtdXNlci1zZWxlY3Q6IG5vbmUgIWltcG9ydGFudDtcbiAgLW1vei11c2VyLXNlbGVjdDogbm9uZSAhaW1wb3J0YW50O1xuICAtbXMtdXNlci1zZWxlY3Q6IG5vbmUgIWltcG9ydGFudDtcbiAgdXNlci1zZWxlY3Q6IG5vbmUgIWltcG9ydGFudDtcbn1cbi8qIGFkZGVkIHRvIHRoZSBzb3VyY2UgZWxlbWVudCB3aGlsZSBpdHMgbWlycm9yIGlzIGRyYWdnZWQgKi9cbi5ndS10cmFuc2l0IHtcbiAgb3BhY2l0eTogMC4yO1xuICAtbXMtZmlsdGVyOiBcInByb2dpZDpEWEltYWdlVHJhbnNmb3JtLk1pY3Jvc29mdC5BbHBoYShPcGFjaXR5PTIwKVwiO1xuICBmaWx0ZXI6IGFscGhhKG9wYWNpdHk9MjApO1xufVxuIl19 */"

/***/ }),

/***/ "./src/app/project/project.component.html":
/*!************************************************!*\
  !*** ./src/app/project/project.component.html ***!
  \************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"row\">\n  <div *ngIf=\"projectIsLoaded()\" class=\"col-7 offset-1\">\n    <h2>{{project?.name}}</h2>\n    <app-inline-edit [(ngModel)]=\"project.composer\" type=\"text\" [label]=\"'Enter value for composer'\" (changed)=\"composerChanged($event)\" [size]=\"128\"> </app-inline-edit>\n    <p>{{projectStatistics?.images}} images, {{projectStatistics?.pages}} pages, {{projectStatistics?.regions}} regions, {{projectStatistics?.agnosticSymbols}} symbols </p>\n\n    <input type=\"radio\" name=\"rbProjectState\" [(ngModel)]=\"projectState\" value=\"none\">\n    None\n    <input type=\"radio\" name=\"rbProjectState\" [(ngModel)]=\"projectState\" value=\"inprogress\">\n    In progress\n    <input type=\"radio\" name=\"rbProjectState\" [(ngModel)]=\"projectState\" value=\"done\">\n    Done\n    <input type=\"radio\" name=\"rbProjectState\" [(ngModel)]=\"projectState\" value=\"doublechecked\">\n    Double checked\n\n    <app-inline-edit [(ngModel)]=\"project.comments\" type=\"text\" [label]=\"'Enter comments'\" (changed)=\"commentsChanged($event)\" [size]=\"128\"> </app-inline-edit>\n  </div>\n\n  <div class=\"col-1\">\n    <a (click)=\"uploadImages()\">\n      Upload images\n    </a>\n  </div>\n  <div class=\"col-3\">\n    <img src=\"assets/images/orderimages.png\" alt=\"Order images\"/>\n  </div>\n</div>\n\n<div class=\"row\">\n  <div class=\"offset-1 col-10\">\n    <div *ngIf=\"project; let project; else loading\" dragula=\"DRAGULA_FACTS\" #domImages>\n      <app-image-thumbnail *ngFor=\"let image of project.images\" [image]=\"image\" [attr.data-id]=\"image.id\"></app-image-thumbnail>\n    </div>\n    <ng-template #loading>Loading project...</ng-template>\n  </div>\n</div>\n"

/***/ }),

/***/ "./src/app/project/project.component.ts":
/*!**********************************************!*\
  !*** ./src/app/project/project.component.ts ***!
  \**********************************************/
/*! exports provided: ProjectComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ProjectComponent", function() { return ProjectComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _model_project__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../model/project */ "./src/app/model/project.ts");
/* harmony import */ var ng2_dragula__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ng2-dragula */ "./node_modules/ng2-dragula/dist/fesm5/ng2-dragula.js");
/* harmony import */ var _image_thumbnail_image_thumbnail_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../image-thumbnail/image-thumbnail.component */ "./src/app/image-thumbnail/image-thumbnail.component.ts");
/* harmony import */ var ngx_logger__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ngx-logger */ "./node_modules/ngx-logger/esm5/ngx-logger.js");
/* harmony import */ var _services_session_data_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../services/session-data.service */ "./src/app/services/session-data.service.ts");
/* harmony import */ var _component_can_deactivate__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../component-can-deactivate */ "./src/app/component-can-deactivate.ts");
/* harmony import */ var _services_project_service__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../services/project.service */ "./src/app/services/project.service.ts");










// import { Lightbox } from 'ngx-lightbox';
var ProjectComponent = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](ProjectComponent, _super);
    function ProjectComponent(sessionDataService, route, router, dragulaService, logger, projectService) {
        var _this = _super.call(this) || this;
        _this.sessionDataService = sessionDataService;
        _this.route = route;
        _this.router = router;
        _this.dragulaService = dragulaService;
        _this.logger = logger;
        _this.projectService = projectService;
        _this.BAG = 'DRAGULA_FACTS';
        _this.logger.debug('Loading project component');
        _this.initReorderInteraction();
        return _this;
    }
    ProjectComponent.prototype.ngOnInit = function () {
        var _this = this;
        var routeParams = this.route.snapshot.params;
        this.projectService.getProject$(routeParams.id).subscribe(function (next) { return _this.loadProject(next); });
        this.projectService.getProjectStatistics$(routeParams.id).subscribe(function (next) { return _this.projectStatistics = next; });
    };
    ProjectComponent.prototype.loadProject = function (loadedProject) {
        var project = Object.assign(new _model_project__WEBPACK_IMPORTED_MODULE_3__["Project"](), loadedProject);
        project.orderImageArray();
        this.sessionDataService.currentProject = project;
        this.changeProjectState();
    };
    Object.defineProperty(ProjectComponent.prototype, "project", {
        get: function () {
            return this.sessionDataService.currentProject;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(ProjectComponent.prototype, "projectState", {
        get: function () {
            return this._projectState;
        },
        set: function (value) {
            this.logger.debug('Changing project state to ' + value);
            if (value === 'none') {
                this.project.state = null;
            }
            else {
                this.project.state.state = value;
            }
            this.projectService.saveProjectState(this.project);
            this._projectState = value;
        },
        enumerable: true,
        configurable: true
    });
    ProjectComponent.prototype.uploadImages = function () {
        var url = 'uploadimages';
        // Redirect the user
        this.router.navigate([url, this.project.id]);
    };
    ProjectComponent.prototype.canDeactivate = function () {
        return false; // TODO
    };
    ProjectComponent.prototype.projectIsLoaded = function () {
        return this.project != null;
    };
    ProjectComponent.prototype.composerChanged = function ($event) {
        this.project.composer = $event;
        this.projectService.saveProjectComposer(this.project);
    };
    ProjectComponent.prototype.commentsChanged = function ($event) {
        this.project.comments = $event;
        this.projectService.saveProjectComments(this.project);
    };
    ProjectComponent.prototype.changeProjectState = function () {
        if (this.project.state == null) {
            this._projectState = 'none';
        }
        else {
            this._projectState = this.project.state.state;
        }
    };
    ProjectComponent.prototype.initReorderInteraction = function () {
        var _this = this;
        this.dragulaService.drop(this.BAG)
            .subscribe(function (_a) {
            // this.logger.debug('Images order for drop ' + el );
            // this.logger.debug('DOM:' + this.domImages.nativeElement);
            var el = _a.el;
            var imagesOrder = '';
            var firstImage = true;
            var sortedImages = _this.domImages.nativeElement.querySelectorAll('app-image-thumbnail');
            sortedImages.forEach(function (sortedImage) {
                if (firstImage) {
                    firstImage = false;
                }
                else {
                    imagesOrder += ',';
                }
                // sortedImage.dataset['id'] is obtained using the HTML attribute [attr.data-id]="image.id"
                imagesOrder += sortedImage.dataset['id'];
            });
            _this.logger.debug('Sorted images ' + imagesOrder);
            _this.project.imagesOrdering = imagesOrder;
            _this.projectService.updateProject(_this.project);
        });
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["ViewChildren"])(_image_thumbnail_image_thumbnail_component__WEBPACK_IMPORTED_MODULE_5__["ImageThumbnailComponent"]),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", _angular_core__WEBPACK_IMPORTED_MODULE_1__["QueryList"])
    ], ProjectComponent.prototype, "imageThumbnailComponents", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["ViewChild"])('domImages'),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", _angular_core__WEBPACK_IMPORTED_MODULE_1__["ElementRef"])
    ], ProjectComponent.prototype, "domImages", void 0);
    ProjectComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-project',
            template: __webpack_require__(/*! ./project.component.html */ "./src/app/project/project.component.html"),
            styles: [__webpack_require__(/*! ./project.component.css */ "./src/app/project/project.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_services_session_data_service__WEBPACK_IMPORTED_MODULE_7__["SessionDataService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_2__["ActivatedRoute"],
            _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"],
            ng2_dragula__WEBPACK_IMPORTED_MODULE_4__["DragulaService"],
            ngx_logger__WEBPACK_IMPORTED_MODULE_6__["NGXLogger"],
            _services_project_service__WEBPACK_IMPORTED_MODULE_9__["ProjectService"]])
    ], ProjectComponent);
    return ProjectComponent;
}(_component_can_deactivate__WEBPACK_IMPORTED_MODULE_8__["ComponentCanDeactivate"]));



/***/ }),

/***/ "./src/app/projects/projects.component.css":
/*!*************************************************!*\
  !*** ./src/app/projects/projects.component.css ***!
  \*************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".projects {\n  margin-bottom: 20px;\n}\n\n.projects .card {\n  background-color: transparent;\n  text-align: center;\n}\n\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvcHJvamVjdHMvcHJvamVjdHMuY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLG1CQUFtQjtBQUNyQjs7QUFFQTtFQUNFLDZCQUE2QjtFQUM3QixrQkFBa0I7QUFDcEIiLCJmaWxlIjoic3JjL2FwcC9wcm9qZWN0cy9wcm9qZWN0cy5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiLnByb2plY3RzIHtcbiAgbWFyZ2luLWJvdHRvbTogMjBweDtcbn1cblxuLnByb2plY3RzIC5jYXJkIHtcbiAgYmFja2dyb3VuZC1jb2xvcjogdHJhbnNwYXJlbnQ7XG4gIHRleHQtYWxpZ246IGNlbnRlcjtcbn1cblxuIl19 */"

/***/ }),

/***/ "./src/app/projects/projects.component.html":
/*!**************************************************!*\
  !*** ./src/app/projects/projects.component.html ***!
  \**************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"row titles\">\n  <div class=\"col-2 offset-1 align-self-end\">\n    <img src=\"assets/images/myprojects.png\" alt=\"My projects\"/>\n  </div>\n  <div class=\"col-9 screenTitle\">\n    <img src=\"assets/images/openproject.png\" alt=\"Open project\"/>\n  </div>\n</div>\n\n<div class=\"row projects\">\n  <div class=\"col-10 offset-1\">\n    <div class=\"row\">\n      <div *ngFor=\"let project of myProjects; trackBy: trackByProjectFn\" class=\"project col-2\">\n        <div class=\"card\">\n          <img class=\"card-img-top img-thumbnail\" *ngIf=\"project.thumbnailBase64Encoding\" src=\"{{project.thumbnailBase64Encoding}}\" alt=\"Project thumbnail\">\n          <img class=\"card-img-top img-thumbnail\" *ngIf=\"!project.thumbnailBase64Encoding\" src=\"assets/images/empty_thumbnail.png\" alt=\"Project thumbnail\">\n          <app-state [state]=\"project.state\"></app-state>\n          <div class=\"card-body\">\n            <p>\n              <a [routerLink]=\"['/project', project.id]\">{{project.name}}</a>\n            </p>\n          </div>\n        </div>\n      </div>\n    </div>\n  </div>\n</div>\n\n\n<div class=\"row titles\">\n  <div class=\"col-2 offset-1 align-self-end\">\n    <img src=\"assets/images/assignedprojects.png\" alt=\"My projects\"/>\n  </div>\n</div>\n<div class=\"row projects\">\n  <div class=\"col-10 offset-1\">\n    <div class=\"row\">\n      <div *ngFor=\"let permission of permissions; trackBy: trackByPermissionFn\" class=\"project col-2\">\n        <div class=\"card\">\n          <img class=\"card-img-top img-thumbnail\" *ngIf=\"permission.project.thumbnailBase64Encoding\" src=\"{{permission.project.thumbnailBase64Encoding}}\" alt=\"Project thumbnail\">\n          <img class=\"card-img-top img-thumbnail\" *ngIf=\"!permission.project.thumbnailBase64Encoding\" src=\"assets/images/empty_thumbnail.png\" alt=\"Project thumbnail\">\n          <app-state [state]=\"permission.state\"></app-state>\n          <div class=\"card-body\">\n              <a [routerLink]=\"['/project', permission.project.id]\">{{permission.project.name}}</a>\n          </div>\n        </div>\n      </div>\n    </div>\n  </div>\n</div>\n"

/***/ }),

/***/ "./src/app/projects/projects.component.ts":
/*!************************************************!*\
  !*** ./src/app/projects/projects.component.ts ***!
  \************************************************/
/*! exports provided: ProjectsComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ProjectsComponent", function() { return ProjectsComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var ngx_logger__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ngx-logger */ "./node_modules/ngx-logger/esm5/ngx-logger.js");
/* harmony import */ var _services_session_data_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../services/session-data.service */ "./src/app/services/session-data.service.ts");




var ProjectsComponent = /** @class */ (function () {
    function ProjectsComponent(sessionDataService, logger) {
        this.sessionDataService = sessionDataService;
        this.logger = logger;
    }
    ProjectsComponent.prototype.ngOnInit = function () {
        this.myProjects = this.sessionDataService.user.projectsCreated;
        this.permissions = this.sessionDataService.user.permissions;
    };
    ProjectsComponent.prototype.trackByProjectFn = function (index, item) {
        return item.id; // unique id corresponding to the item
    };
    ProjectsComponent.prototype.trackByPermissionFn = function (index, item) {
        return item.id; // unique id corresponding to the item
    };
    ProjectsComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-projects',
            template: __webpack_require__(/*! ./projects.component.html */ "./src/app/projects/projects.component.html"),
            styles: [__webpack_require__(/*! ./projects.component.css */ "./src/app/projects/projects.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_services_session_data_service__WEBPACK_IMPORTED_MODULE_3__["SessionDataService"], ngx_logger__WEBPACK_IMPORTED_MODULE_2__["NGXLogger"]])
    ], ProjectsComponent);
    return ProjectsComponent;
}());



/***/ }),

/***/ "./src/app/services/agnostic.service.ts":
/*!**********************************************!*\
  !*** ./src/app/services/agnostic.service.ts ***!
  \**********************************************/
/*! exports provided: AgnosticService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AgnosticService", function() { return AgnosticService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../environments/environment */ "./src/environments/environment.ts");
/* harmony import */ var ngx_logger__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ngx-logger */ "./node_modules/ngx-logger/esm5/ngx-logger.js");
/* harmony import */ var _dialogs_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./dialogs.service */ "./src/app/services/dialogs.service.ts");
/* harmony import */ var _rest_client_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./rest-client.service */ "./src/app/services/rest-client.service.ts");






var AgnosticService = /** @class */ (function () {
    function AgnosticService(restClientService, logger, dialogService) {
        this.restClientService = restClientService;
        this.logger = logger;
        this.dialogService = dialogService;
        this.urlAgnostic = _environments_environment__WEBPACK_IMPORTED_MODULE_2__["environment"].apiEndpoint + '/agnostic';
    }
    AgnosticService.prototype.getSVGFromAgnosticSymbolType$ = function (notationType, manuscriptType, agnosticSymbolType) {
        return this.restClientService.httpGet$(this.urlAgnostic + '/svg'
            + '?notationType=' + notationType
            + '&manuscriptType=' + manuscriptType
            + '&symbolType=' + agnosticSymbolType, 'Fetching svg path for notationType=' + notationType
            + 'manuscriptType=' + manuscriptType
            + ' and agnosticSymbolType=' + agnosticSymbolType);
    };
    AgnosticService.prototype.getSVGSet$ = function (notationType, manuscriptType) {
        return this.restClientService.httpGet$(this.urlAgnostic + '/svgset'
            + '?notationType=' + notationType
            + '&manuscriptType=' + manuscriptType, 'Fetching svgset for notationType=' + notationType
            + 'manuscriptType=' + manuscriptType);
    };
    AgnosticService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
            providedIn: 'root'
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_rest_client_service__WEBPACK_IMPORTED_MODULE_5__["RestClientService"],
            ngx_logger__WEBPACK_IMPORTED_MODULE_3__["NGXLogger"],
            _dialogs_service__WEBPACK_IMPORTED_MODULE_4__["DialogsService"]])
    ], AgnosticService);
    return AgnosticService;
}());



/***/ }),

/***/ "./src/app/services/auth.service.ts":
/*!******************************************!*\
  !*** ./src/app/services/auth.service.ts ***!
  \******************************************/
/*! exports provided: AuthService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AuthService", function() { return AuthService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _model_user__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../model/user */ "./src/app/model/user.ts");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../environments/environment */ "./src/environments/environment.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var ngx_logger__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ngx-logger */ "./node_modules/ngx-logger/esm5/ngx-logger.js");
/* harmony import */ var _session_data_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./session-data.service */ "./src/app/services/session-data.service.ts");







var AuthService = /** @class */ (function () {
    function AuthService(http, logger, sessionDataService) {
        this.http = http;
        this.logger = logger;
        this.sessionDataService = sessionDataService;
        this.SESSION_USER_STORAGE = 'token';
        this.urlLogin = _environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].apiEndpoint + '/auth/login'; // URL to web api
        this.urlAuthenticatedUser = _environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].apiEndpoint + '/auth/user';
        this.urlUser = _environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].apiEndpoint + '/user';
    }
    AuthService.prototype.logout = function () {
        this.sessionDataService.user = null;
        sessionStorage.removeItem(this.SESSION_USER_STORAGE);
    };
    AuthService.prototype.authenticated = function () {
        // return this.isLoggedIn;
        return this.sessionDataService.user != null;
    };
    AuthService.prototype.getUser = function () {
        return this.sessionDataService.user;
    };
    AuthService.prototype.login = function (username, password) {
        return this.http.post(this.urlLogin, {
            username: username,
            password: password
        }); /*.pipe(
          tap<User>(next => {
            if (next != null) {
              sessionStorage.setItem(
                this.SESSION_USER_STORAGE,
                btoa(username + ':' + password)
              );
              this.logger.error('Found user with id=' + next.id);
              Object.assign(this.user, next);
            }
          })
        );*/
    };
    AuthService.prototype.getHttpAuthOptions = function () {
        var options = { headers: this.getHeaders() };
        return options;
    };
    AuthService.prototype.getHeaders = function () {
        var token = sessionStorage.getItem(this.SESSION_USER_STORAGE);
        if (!token) {
            throw new Error('User is not authorized yet');
        }
        var headers = new _angular_common_http__WEBPACK_IMPORTED_MODULE_4__["HttpHeaders"]({
            'Authorization': 'Bearer ' + token
        });
        return headers;
    };
    AuthService.prototype.checkAuthorized = function () {
        var _this = this;
        this.http.post(this.urlAuthenticatedUser, {}, this.getHttpAuthOptions()).
            subscribe(function (principal) {
            _this.logger.log('Current user: ' + principal['name']);
        }, function (error) {
            if (error.status === 401) {
                alert('Unauthorized');
            }
        });
    };
    /*this.http.post<Observable<boolean>>(this.urlLogin, {
      username: username,
      password: password
    }).subscribe(isValid => {
      if (isValid) {
        sessionStorage.setItem(
          'token',
          btoa(username + ':' + password)
        );
        // router.navigate(['']);
        return true;
      } else {
        // alert('Authentication failed.');
        return false;
      }
    });*/
    AuthService.prototype.setUser = function (u) {
        this.sessionDataService.user = Object.assign(new _model_user__WEBPACK_IMPORTED_MODULE_2__["User"](), u);
        sessionStorage.setItem(this.SESSION_USER_STORAGE, btoa(this.sessionDataService.user.username));
        this.logger.debug('ID: ' + this.sessionDataService.user.id);
    };
    AuthService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
            providedIn: 'root'
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_4__["HttpClient"],
            ngx_logger__WEBPACK_IMPORTED_MODULE_5__["NGXLogger"],
            _session_data_service__WEBPACK_IMPORTED_MODULE_6__["SessionDataService"]])
    ], AuthService);
    return AuthService;
}());



/***/ }),

/***/ "./src/app/services/classifier.service.ts":
/*!************************************************!*\
  !*** ./src/app/services/classifier.service.ts ***!
  \************************************************/
/*! exports provided: ClassifierService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ClassifierService", function() { return ClassifierService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../environments/environment */ "./src/environments/environment.ts");
/* harmony import */ var ngx_logger__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ngx-logger */ "./node_modules/ngx-logger/esm5/ngx-logger.js");
/* harmony import */ var _rest_client_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./rest-client.service */ "./src/app/services/rest-client.service.ts");





var ClassifierService = /** @class */ (function () {
    function ClassifierService(restClientService, logger) {
        this.restClientService = restClientService;
        this.logger = logger;
        this.urlClassifierTypes = _environments_environment__WEBPACK_IMPORTED_MODULE_2__["environment"].apiEndpoint + '/classifiers';
    }
    ClassifierService.prototype.getClassifierTypes$ = function () {
        // TODO Pasarle usuario actual
        return this.restClientService.httpGet$(this.urlClassifierTypes, 'Fetching classifier types');
    };
    ClassifierService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
            providedIn: 'root'
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_rest_client_service__WEBPACK_IMPORTED_MODULE_4__["RestClientService"],
            ngx_logger__WEBPACK_IMPORTED_MODULE_3__["NGXLogger"]])
    ], ClassifierService);
    return ClassifierService;
}());



/***/ }),

/***/ "./src/app/services/dialogs.service.ts":
/*!*********************************************!*\
  !*** ./src/app/services/dialogs.service.ts ***!
  \*********************************************/
/*! exports provided: DialogsService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "DialogsService", function() { return DialogsService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var DialogsService = /** @class */ (function () {
    function DialogsService() {
    }
    /**
     * Handle Http operation that failed.
     * Let the app continue.
     * @param operation - name of the operation that failed
     * @param result - optional value to return as the observable result
     */
    DialogsService.prototype.handleError = function (operation, result) {
        if (operation === void 0) { operation = 'operation'; }
        return function (error) {
            // this.logger.error(`${operation} failed: ${error.message}`);
            alert('Warning: ' + error.message);
            // Let the app keep running by returning an empty result.
            throw new Error(error.message);
        };
    };
    DialogsService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
            providedIn: 'root'
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], DialogsService);
    return DialogsService;
}());



/***/ }),

/***/ "./src/app/services/image.service.ts":
/*!*******************************************!*\
  !*** ./src/app/services/image.service.ts ***!
  \*******************************************/
/*! exports provided: ImageService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ImageService", function() { return ImageService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var ngx_logger__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ngx-logger */ "./node_modules/ngx-logger/esm5/ngx-logger.js");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../environments/environment */ "./src/environments/environment.ts");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var _payloads_post_strokes__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../payloads/post-strokes */ "./src/app/payloads/post-strokes.ts");
/* harmony import */ var _rest_client_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./rest-client.service */ "./src/app/services/rest-client.service.ts");







var ImageService = /** @class */ (function () {
    function ImageService(logger, restClientService) {
        this.logger = logger;
        this.restClientService = restClientService;
        this.urlImage = _environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].apiEndpoint + '/image';
    }
    ImageService.prototype.getImage$ = function (id) {
        return this.restClientService.httpGet$(this.urlImage + '/get/' + id, 'Fetching image with id ' + id);
    };
    ImageService.prototype.getMasterImage$ = function (imageID) {
        return this.restClientService.httpGetBlob(this.urlImage + '/master/' + imageID, 'Fetching master image ' + imageID);
    };
    ImageService.prototype.getThumbnailImage$ = function (imageID) {
        return this.restClientService.httpGetBlob(this.urlImage + '/thumbnail/' + imageID, 'Fetching thumbnail image ' + imageID);
    };
    ImageService.prototype.getPreviewImage$ = function (imageID) {
        return this.restClientService.httpGetBlob(this.urlImage + '/preview/' + imageID, 'Fetching preview image ' + imageID);
    };
    ImageService.prototype.updateRegionBoundingBox$ = function (id, fromX, fromY, toX, toY) {
        //TODO Cambiar por PUT
        return this.restClientService.httpGet$(this.urlImage + '/regionUpdate/' + id + '/'
            + fromX + '/' + fromY + '/'
            + toX + '/' + toY, 'Updating region bounding box of id: ' + id);
    };
    ImageService.prototype.updateRegionType$ = function (id, regionType) {
        //TODO Cambiar por PUT
        return this.restClientService.httpGet$(this.urlImage + '/regionUpdateType/' + id + '/' + regionType.id, 'Updating region type of id' + id + ' to ' + regionType.name);
    };
    ImageService.prototype.updatePageBoundingBox$ = function (id, fromX, fromY, toX, toY) {
        this.logger.debug('IM3WSService: updating page bounding box of id: ' + id);
        //TODO Cambiar por PUT
        return this.restClientService.httpGet$(this.urlImage + '/pageUpdate/' + id + '/'
            + fromX + '/' + fromY + '/'
            + toX + '/' + toY, 'Updating page bounding box of id ' + id);
    };
    ImageService.prototype.splitPage$ = function (imageId, imageX) {
        //TODO Cambiar por PUT
        return this.restClientService.httpGet$(this.urlImage + '/pageSplit/' + imageId + '/' + imageX, 'Splitting page image with id ' + imageId);
    };
    ImageService.prototype.splitRegion$ = function (imageId, imageX, imageY) {
        //TODO Cambiar por PUT
        return this.restClientService.httpGet$(this.urlImage + '/regionSplit/' + imageId + '/' + imageX + '/' + imageY, 'IM3WSService: splitting region image with id ' + imageId);
    };
    ImageService.prototype.clearDocumentAnalysis$ = function (imageId) {
        //TODO Cambiar por PUT
        return this.restClientService.httpGet$(this.urlImage + '/documentAnalysisClear/' + imageId, 'Clearing document analysis of image with id ' + imageId);
    };
    ImageService.prototype.createSymbolFromBoundingBox$ = function (region, fromX, fromY, toX, toY) {
        //TODO Cambiar por PUT
        return this.restClientService.httpGet$(this.urlImage + '/createSymbolFromBoundingBox/' + region.id + '/'
            + fromX + '/' + fromY + '/'
            + toX + '/' + toY, 'Create symbol from bounding box in region ' + region.id)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["share"])()); // if not, two calls are made for the same request due to CORS checking
        //TODO Comprobar esto del share
    };
    ImageService.prototype.createSymbolFromStrokes$ = function (region, currentStrokes) {
        var points = [[]];
        currentStrokes.strokeList.forEach(function (stroke) {
            points.push(stroke.points);
        });
        var postStrokes = new _payloads_post_strokes__WEBPACK_IMPORTED_MODULE_5__["PostStrokes"](region.id, points);
        return this.restClientService.httpPost(this.urlImage + '/createSymbolFromStrokes', postStrokes, 'Create symbol from strokes in region ' + region.id)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["share"])()); // if not, two calls are made for the same request due to CORS checking
        //TODO Comprobar esto del share
    };
    ImageService.prototype.deleteSymbol$ = function (regionID, symbolID) {
        //TODO Cambiar por DELETE
        return this.restClientService.httpGet$(this.urlImage + '/removeSymbol/' + regionID + '/' + symbolID, 'Deleting symbol from region with id ' + regionID + ' with symbol id: ' + symbolID);
    };
    ImageService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
            providedIn: 'root'
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [ngx_logger__WEBPACK_IMPORTED_MODULE_2__["NGXLogger"],
            _rest_client_service__WEBPACK_IMPORTED_MODULE_6__["RestClientService"]])
    ], ImageService);
    return ImageService;
}());



/***/ }),

/***/ "./src/app/services/project.service.ts":
/*!*********************************************!*\
  !*** ./src/app/services/project.service.ts ***!
  \*********************************************/
/*! exports provided: ProjectService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ProjectService", function() { return ProjectService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var ngx_logger__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ngx-logger */ "./node_modules/ngx-logger/esm5/ngx-logger.js");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../environments/environment */ "./src/environments/environment.ts");
/* harmony import */ var _payloads_string_body__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../payloads/string-body */ "./src/app/payloads/string-body.ts");
/* harmony import */ var _rest_client_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./rest-client.service */ "./src/app/services/rest-client.service.ts");






var ProjectService = /** @class */ (function () {
    function ProjectService(restClientService, logger) {
        this.restClientService = restClientService;
        this.logger = logger;
        this.urlProject = _environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].apiEndpoint + '/project';
    }
    /**
     * It returns an observable array of lazily loaded projects
     */
    ProjectService.prototype.getProjects$ = function () {
        return this.restClientService.httpGet$(this.urlProject, 'Fetching all projects (lazy)');
    };
    /**
     * Post a new project
     * @param name
     * @param composer
     * @param notationType
     * @param manuscriptType
     * @param comments
     * @param base64Thumbnail
     */
    ProjectService.prototype.newProject$ = function (name, composer, notationType, manuscriptType, comments, base64Thumbnail) {
        return this.restClientService.httpPost(this.urlProject + '/new', {
            'name': name,
            'composer': composer,
            'notationType': notationType,
            'manuscriptType': manuscriptType,
            'comments': comments,
            'thumbnailBase64Encoding': base64Thumbnail
        }, 'Creating new project with name ' + name);
    };
    /**
     * It retrieves eagerly the project
     * @param id
     */
    ProjectService.prototype.getProject$ = function (id) {
        return this.restClientService.httpGet$(this.urlProject + '/get/' + id, 'Fetching project with id ' + id);
    };
    /**
     * It retrieves the project statistics
     * @param id
     */
    ProjectService.prototype.getProjectStatistics$ = function (id) {
        return this.restClientService.httpGet$(this.urlProject + '/statistics/' + id, 'Fetching project statistics for id ' + id);
    };
    /**
     * It puts a project update
     * @param project
     */
    ProjectService.prototype.updateProject = function (project) {
        this.logger.debug('IM3WSService: saving project with id: ' + project.id);
        return this.restClientService.httpPut(this.urlProject, project, 'Updating project with id ' + project.id);
    };
    /**
     * It just updates the project composer
     * @param project
     */
    ProjectService.prototype.saveProjectComposer = function (project) {
        var stringBody = new _payloads_string_body__WEBPACK_IMPORTED_MODULE_4__["StringBody"](project.composer);
        return this.restClientService.httpPut(this.urlProject + '/composer/' + project.id, stringBody, 'Updating project composer of project with id ' + project.id);
    };
    /**
     * It just updates the project comments
     * @param project
     */
    ProjectService.prototype.saveProjectComments = function (project) {
        var stringBody = new _payloads_string_body__WEBPACK_IMPORTED_MODULE_4__["StringBody"](project.comments);
        return this.restClientService.httpPut(this.urlProject + '/comments/' + project.id, stringBody, 'Updating project comments of project with id ' + project.id);
    };
    /**
     * It just updates the project state
     * @param project
     */
    ProjectService.prototype.saveProjectState = function (project) {
        return this.restClientService.httpPut(this.urlProject + '/state/' + project.id, project.state, 'Updating project state of project with id ' + project.id);
    };
    ProjectService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
            providedIn: 'root'
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_rest_client_service__WEBPACK_IMPORTED_MODULE_5__["RestClientService"],
            ngx_logger__WEBPACK_IMPORTED_MODULE_2__["NGXLogger"]])
    ], ProjectService);
    return ProjectService;
}());



/***/ }),

/***/ "./src/app/services/region.service.ts":
/*!********************************************!*\
  !*** ./src/app/services/region.service.ts ***!
  \********************************************/
/*! exports provided: RegionService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RegionService", function() { return RegionService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../environments/environment */ "./src/environments/environment.ts");
/* harmony import */ var ngx_logger__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ngx-logger */ "./node_modules/ngx-logger/esm5/ngx-logger.js");
/* harmony import */ var _rest_client_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./rest-client.service */ "./src/app/services/rest-client.service.ts");





var RegionService = /** @class */ (function () {
    function RegionService(restClientService, logger) {
        this.restClientService = restClientService;
        this.logger = logger;
        this.urlRegionTypes = _environments_environment__WEBPACK_IMPORTED_MODULE_2__["environment"].apiEndpoint + '/regiontypes';
    }
    RegionService.prototype.getRegionTypes = function () {
        return this.restClientService.httpGet$(this.urlRegionTypes, 'Fetching region types');
    };
    RegionService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
            providedIn: 'root'
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_rest_client_service__WEBPACK_IMPORTED_MODULE_4__["RestClientService"],
            ngx_logger__WEBPACK_IMPORTED_MODULE_3__["NGXLogger"]])
    ], RegionService);
    return RegionService;
}());



/***/ }),

/***/ "./src/app/services/rest-client.service.ts":
/*!*************************************************!*\
  !*** ./src/app/services/rest-client.service.ts ***!
  \*************************************************/
/*! exports provided: RestClientService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RestClientService", function() { return RestClientService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var ngx_logger__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ngx-logger */ "./node_modules/ngx-logger/esm5/ngx-logger.js");
/* harmony import */ var _auth_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./auth.service */ "./src/app/services/auth.service.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _dialogs_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./dialogs.service */ "./src/app/services/dialogs.service.ts");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");







var RestClientService = /** @class */ (function () {
    function RestClientService(http, authService, dialogService, logger) {
        this.http = http;
        this.authService = authService;
        this.dialogService = dialogService;
        this.logger = logger;
        this.logger.info('Creating RestClientService');
    }
    RestClientService.prototype.httpGetBlob = function (url, debugMessage) {
        this.logger.debug('RestClientService: ' + debugMessage);
        return this.http.get(url, { headers: this.authService.getHeaders(), responseType: 'blob' }).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_6__["catchError"])(this.dialogService.handleError(debugMessage, null)));
    };
    RestClientService.prototype.httpGet$ = function (url, debugMessage) {
        this.logger.debug('RestClientService: ' + debugMessage);
        return this.http.get(url, this.authService.getHttpAuthOptions()).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_6__["catchError"])(this.dialogService.handleError(debugMessage, null)));
    };
    RestClientService.prototype.httpPost = function (url, body, debugMessage) {
        this.logger.debug('RestClientService: ' + debugMessage);
        return this.http.post(url, body, this.authService.getHttpAuthOptions()).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_6__["catchError"])(this.dialogService.handleError(debugMessage, null)));
    };
    RestClientService.prototype.httpPut = function (url, body, debugMessage) {
        this.logger.debug('RestClientService: ' + debugMessage);
        return this.http.put(url, body, this.authService.getHttpAuthOptions()).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_6__["catchError"])(this.dialogService.handleError(debugMessage, null)));
    };
    RestClientService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
            providedIn: 'root'
        })
        /**
         * This class encapsulates the HTTP REST API calls including CORS and authentication
         */
        ,
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_4__["HttpClient"],
            _auth_service__WEBPACK_IMPORTED_MODULE_3__["AuthService"],
            _dialogs_service__WEBPACK_IMPORTED_MODULE_5__["DialogsService"],
            ngx_logger__WEBPACK_IMPORTED_MODULE_2__["NGXLogger"]])
    ], RestClientService);
    return RestClientService;
}());



/***/ }),

/***/ "./src/app/services/session-data.service.ts":
/*!**************************************************!*\
  !*** ./src/app/services/session-data.service.ts ***!
  \**************************************************/
/*! exports provided: SessionDataService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SessionDataService", function() { return SessionDataService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var SessionDataService = /** @class */ (function () {
    function SessionDataService() {
    }
    Object.defineProperty(SessionDataService.prototype, "user", {
        get: function () {
            return this._user;
        },
        set: function (value) {
            this._user = value;
            if (value == null) {
                this._currentProject = null;
                this._currentImage = null;
            }
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(SessionDataService.prototype, "currentProject", {
        get: function () {
            return this._currentProject;
        },
        set: function (value) {
            this._currentProject = value;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(SessionDataService.prototype, "currentImage", {
        get: function () {
            return this._currentImage;
        },
        set: function (value) {
            this._currentImage = value;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(SessionDataService.prototype, "regionTypes", {
        get: function () {
            return this._regionTypes;
        },
        set: function (value) {
            this._regionTypes = value;
        },
        enumerable: true,
        configurable: true
    });
    SessionDataService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
            providedIn: 'root'
        })
    ], SessionDataService);
    return SessionDataService;
}());



/***/ }),

/***/ "./src/app/services/symbol.service.ts":
/*!********************************************!*\
  !*** ./src/app/services/symbol.service.ts ***!
  \********************************************/
/*! exports provided: SymbolService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SymbolService", function() { return SymbolService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var ngx_logger__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ngx-logger */ "./node_modules/ngx-logger/esm5/ngx-logger.js");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../environments/environment */ "./src/environments/environment.ts");
/* harmony import */ var _rest_client_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./rest-client.service */ "./src/app/services/rest-client.service.ts");





var SymbolService = /** @class */ (function () {
    function SymbolService(restClientService, logger) {
        this.restClientService = restClientService;
        this.logger = logger;
        this.urlSymbol = _environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].apiEndpoint + '/symbol';
    }
    SymbolService.prototype.changeAgnosticSymbolType$ = function (symbolID, agnosticSymbolTypeString) {
        return this.restClientService.httpGet$(this.urlSymbol + '/changeAgnosticSymbolType/' + symbolID + '/' + agnosticSymbolTypeString, 'ChangeAgnosticSymbolType with symbol id: ' + symbolID + ' to ' + agnosticSymbolTypeString);
    };
    SymbolService.prototype.changeAgnosticPositionInStaff = function (symbolID, agnosticSymbolPositionInStaff) {
        this.logger.debug('IM3WSService: changeAgnosticSymbolType with symbol id: ' + symbolID + ' to ' + agnosticSymbolPositionInStaff);
        return this.restClientService.httpGet$(this.urlSymbol + '/changeAgnosticPositionInStaff/' + symbolID + '/' + agnosticSymbolPositionInStaff, 'ChangeAgnosticSymbolType with symbol id: ' + symbolID + ' to ' + agnosticSymbolPositionInStaff);
    };
    /**
     * @param upOrDown up | down
     */
    SymbolService.prototype.changeAgnosticPositionInStaffUpOrDown$ = function (symbolID, upOrDown) {
        return this.restClientService.httpGet$(this.urlSymbol + '/changeAgnosticPositionInStaffUpOrDown/' + symbolID + '/' + upOrDown, 'ChangeAgnosticSymbolType with symbol id: ' + symbolID + ' ' + upOrDown);
    };
    SymbolService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
            providedIn: 'root'
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_rest_client_service__WEBPACK_IMPORTED_MODULE_4__["RestClientService"],
            ngx_logger__WEBPACK_IMPORTED_MODULE_2__["NGXLogger"]])
    ], SymbolService);
    return SymbolService;
}());



/***/ }),

/***/ "./src/app/services/training-set.service.ts":
/*!**************************************************!*\
  !*** ./src/app/services/training-set.service.ts ***!
  \**************************************************/
/*! exports provided: TrainingSetService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TrainingSetService", function() { return TrainingSetService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../environments/environment */ "./src/environments/environment.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var ngx_logger__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ngx-logger */ "./node_modules/ngx-logger/esm5/ngx-logger.js");
/* harmony import */ var _auth_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./auth.service */ "./src/app/services/auth.service.ts");
/* harmony import */ var _dialogs_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./dialogs.service */ "./src/app/services/dialogs.service.ts");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");








var TrainingSetService = /** @class */ (function () {
    function TrainingSetService(http, logger, authService, dialogService) {
        this.http = http;
        this.logger = logger;
        this.authService = authService;
        this.dialogService = dialogService;
        this.urlTrainingSets = _environments_environment__WEBPACK_IMPORTED_MODULE_2__["environment"].apiEndpoint + '/trainingsets';
    }
    TrainingSetService.prototype.getTrainingSetExporters$ = function () {
        this.logger.debug('IM3WSService: fetching training set exporters');
        return this.http.get(this.urlTrainingSets + '/exporters', this.authService.getHttpAuthOptions())
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_7__["catchError"])(this.dialogService.handleError('Fetch training set exporters', null)));
    };
    TrainingSetService.prototype.downloadTrainingSet$ = function (exporterIndex, projectIDS) {
        this.logger.debug('IM3WSService: fetching training set file for exporter ' + exporterIndex + ' and project ids: ' + projectIDS);
        var projectIdsString = null;
        projectIDS.forEach(function (id) {
            if (projectIdsString != null) {
                projectIdsString = projectIdsString + ',' + id;
            }
            else {
                projectIdsString = '' + id;
            }
        });
        var headers = new _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpHeaders"]();
        Object.assign(headers, this.authService.getHttpAuthOptions());
        headers.append('Content-Type', 'application/x-gzip');
        /*return this.http.post<any>(this.urlTrainingSets + '/download/' + exporterIndex + '/' + projectIdsString,
          {headers, responseType: 'blob'})
          .pipe(
            catchError(this.dialogService.handleError('Download training set', null))
          );*/
        return this.http.get(this.urlTrainingSets + '/download/' + exporterIndex + '/' + projectIdsString, { responseType: 'blob' }).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_7__["catchError"])(this.dialogService.handleError('Download training set', null)));
    };
    TrainingSetService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
            providedIn: 'root'
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClient"],
            ngx_logger__WEBPACK_IMPORTED_MODULE_4__["NGXLogger"],
            _auth_service__WEBPACK_IMPORTED_MODULE_5__["AuthService"],
            _dialogs_service__WEBPACK_IMPORTED_MODULE_6__["DialogsService"]])
    ], TrainingSetService);
    return TrainingSetService;
}());



/***/ }),

/***/ "./src/app/startup/startup.component.css":
/*!***********************************************!*\
  !*** ./src/app/startup/startup.component.css ***!
  \***********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "#startup {\n  height: 100vh;\n  margin-top: 20vh;\n}\n#startuplogo {\n  margin-bottom: 5vh;\n}\n#startup img {\n  width: 100%;\n}\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvc3RhcnR1cC9zdGFydHVwLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRSxhQUFhO0VBQ2IsZ0JBQWdCO0FBQ2xCO0FBQ0E7RUFDRSxrQkFBa0I7QUFDcEI7QUFDQTtFQUNFLFdBQVc7QUFDYiIsImZpbGUiOiJzcmMvYXBwL3N0YXJ0dXAvc3RhcnR1cC5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiI3N0YXJ0dXAge1xuICBoZWlnaHQ6IDEwMHZoO1xuICBtYXJnaW4tdG9wOiAyMHZoO1xufVxuI3N0YXJ0dXBsb2dvIHtcbiAgbWFyZ2luLWJvdHRvbTogNXZoO1xufVxuI3N0YXJ0dXAgaW1nIHtcbiAgd2lkdGg6IDEwMCU7XG59XG4iXX0= */"

/***/ }),

/***/ "./src/app/startup/startup.component.html":
/*!************************************************!*\
  !*** ./src/app/startup/startup.component.html ***!
  \************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"row\" id=\"startup\">\n  <div class=\"col-4 offset-4\">\n    <div class=\"row\">\n      <div class=\"col\" id=\"startuplogo\">\n        <img src=\"assets/images/muret_negativo.png\" alt=\"Logo\">\n      </div>\n    </div>\n    <div class=\"row\" id=\"startupbuttons\">\n      <div class=\"col-6\">\n        <a routerLinkActive=\"active\" routerLink=\"/newproject\">\n          <img src=\"assets/images/start_newproject.png\" alt=\"New Project\">\n        </a>\n      </div>\n      <div class=\"col-6\">\n        <a routerLinkActive=\"active\" routerLink=\"/projects\">\n          <img src=\"assets/images/start_openproject.png\" alt=\"Open Project\">\n        </a>\n      </div>\n    </div>\n  </div>\n</div>\n\n\n"

/***/ }),

/***/ "./src/app/startup/startup.component.ts":
/*!**********************************************!*\
  !*** ./src/app/startup/startup.component.ts ***!
  \**********************************************/
/*! exports provided: StartupComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "StartupComponent", function() { return StartupComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var StartupComponent = /** @class */ (function () {
    function StartupComponent() {
    }
    StartupComponent.prototype.ngOnInit = function () {
    };
    StartupComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-startup',
            template: __webpack_require__(/*! ./startup.component.html */ "./src/app/startup/startup.component.html"),
            styles: [__webpack_require__(/*! ./startup.component.css */ "./src/app/startup/startup.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], StartupComponent);
    return StartupComponent;
}());



/***/ }),

/***/ "./src/app/state/state.component.css":
/*!*******************************************!*\
  !*** ./src/app/state/state.component.css ***!
  \*******************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".state {\n  position: absolute;\n  right: 1em;\n  top: 1em;\n}\n\n.state {\n  color: green;\n}\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvc3RhdGUvc3RhdGUuY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLGtCQUFrQjtFQUNsQixVQUFVO0VBQ1YsUUFBUTtBQUNWOztBQUVBO0VBQ0UsWUFBWTtBQUNkIiwiZmlsZSI6InNyYy9hcHAvc3RhdGUvc3RhdGUuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi5zdGF0ZSB7XG4gIHBvc2l0aW9uOiBhYnNvbHV0ZTtcbiAgcmlnaHQ6IDFlbTtcbiAgdG9wOiAxZW07XG59XG5cbi5zdGF0ZSB7XG4gIGNvbG9yOiBncmVlbjtcbn1cbiJdfQ== */"

/***/ }),

/***/ "./src/app/state/state.component.html":
/*!********************************************!*\
  !*** ./src/app/state/state.component.html ***!
  \********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"state\" data-toggle=\"tooltip\" title=\"{{getTooltip()}}\">\n  <i *ngIf=\"showEdit()\" class=\"fa fa-pencil\" aria-hidden=\"true\"></i>\n  <i *ngIf=\"showCheck()\" class=\"fa fa-check\" aria-hidden=\"true\"></i>\n  <i *ngIf=\"showDoubleCheck()\" class=\"fa fa-check\" aria-hidden=\"true\"></i>\n</div>\n"

/***/ }),

/***/ "./src/app/state/state.component.ts":
/*!******************************************!*\
  !*** ./src/app/state/state.component.ts ***!
  \******************************************/
/*! exports provided: StateComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "StateComponent", function() { return StateComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _model_state__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../model/state */ "./src/app/model/state.ts");



var StateComponent = /** @class */ (function () {
    function StateComponent() {
    }
    StateComponent.prototype.ngOnInit = function () {
    };
    StateComponent.prototype.showEdit = function () {
        return this.state && this.state.state === 'inprogress';
    };
    StateComponent.prototype.showCheck = function () {
        return this.state && this.state.state === 'done';
    };
    StateComponent.prototype.showDoubleCheck = function () {
        return this.state && this.state.state === 'doublechecked';
    };
    StateComponent.prototype.getTooltip = function () {
        if (this.state) {
            return this.state.comments;
        }
        else {
            return '';
        }
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", _model_state__WEBPACK_IMPORTED_MODULE_2__["State"])
    ], StateComponent.prototype, "state", void 0);
    StateComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-state',
            template: __webpack_require__(/*! ./state.component.html */ "./src/app/state/state.component.html"),
            styles: [__webpack_require__(/*! ./state.component.css */ "./src/app/state/state.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], StateComponent);
    return StateComponent;
}());



/***/ }),

/***/ "./src/app/svgcanvas/components/circle/circle.component.css":
/*!******************************************************************!*\
  !*** ./src/app/svgcanvas/components/circle/circle.component.css ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3N2Z2NhbnZhcy9jb21wb25lbnRzL2NpcmNsZS9jaXJjbGUuY29tcG9uZW50LmNzcyJ9 */"

/***/ }),

/***/ "./src/app/svgcanvas/components/circle/circle.component.html":
/*!*******************************************************************!*\
  !*** ./src/app/svgcanvas/components/circle/circle.component.html ***!
  \*******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<ng-template #shapeTemplate>\n    <svg:g *ngIf=\"isSelected\">\n        <svg:rect attr.x=\"{{ shape.originX - shape.r - 2 }}\" attr.y=\"{{ shape.originY - shape.r - 2 }}\" width=\"4\"\n            height=\"4\" style=\"stroke: green; stroke-width: 1; fill:green\" />\n        <svg:rect attr.x=\"{{ shape.originX + shape.r - 2 }}\" attr.y=\"{{ shape.originY - shape.r - 2 }}\" width=\"4\"\n            height=\"4\" style=\"stroke: green; stroke-width: 1; fill:green\" />\n        <svg:rect attr.x=\"{{ shape.originX - shape.r - 2 }}\" attr.y=\"{{ shape.originY + shape.r - 2 }}\" width=\"4\"\n            height=\"4\" style=\"stroke: green; stroke-width: 1; fill:green\" />\n        <svg:rect attr.x=\"{{ shape.originX + shape.r - 2 }}\" attr.y=\"{{ shape.originY + shape.r - 2 }}\" width=\"4\"\n            height=\"4\" style=\"stroke: green; stroke-width: 1; fill:green\" />\n        <svg:rect *ngIf=\"isSelected\" attr.x=\"{{ shape.originX - shape.r }}\" attr.y=\"{{ shape.originY - shape.r }}\"\n            attr.width=\"{{ shape.r * 2 }}\" attr.height=\"{{ shape.r * 2 }}\" style=\"stroke: green; stroke-width: 1; fill:none\" />\n    </svg:g>\n    <svg:circle attr.id=\"{{ shape.shapeProperties.name }}\" class=\"draggable\" attr.cx=\"{{ shape.originX }}\" attr.cy=\"{{ shape.originY }}\"\n        attr.r=\"{{ shape.r }}\" [ngStyle]=\"setStyles()\">\n        <title>{{ shape.shapeProperties.name }}</title>\n    </svg:circle>\n\n</ng-template>"

/***/ }),

/***/ "./src/app/svgcanvas/components/circle/circle.component.ts":
/*!*****************************************************************!*\
  !*** ./src/app/svgcanvas/components/circle/circle.component.ts ***!
  \*****************************************************************/
/*! exports provided: CircleComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CircleComponent", function() { return CircleComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _shape_shape_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../shape/shape.component */ "./src/app/svgcanvas/components/shape/shape.component.ts");
/* harmony import */ var _model_shape_types__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../model/shape-types */ "./src/app/svgcanvas/model/shape-types.ts");
/* harmony import */ var _model_shape__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../model/shape */ "./src/app/svgcanvas/model/shape.ts");





var CircleComponent = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](CircleComponent, _super);
    function CircleComponent() {
        var _this = _super.call(this) || this;
        _this.shape = new _model_shape__WEBPACK_IMPORTED_MODULE_4__["Circle"]();
        _this.shapeType = _model_shape_types__WEBPACK_IMPORTED_MODULE_3__["ShapeType"].Circle;
        console.log('CircleComponent constructor:', _this);
        return _this;
    }
    CircleComponent.prototype.ngOnInit = function () {
        console.log('CircleComponent ngOnInit');
    };
    CircleComponent.prototype.setStyles = function () {
        var styles = {
            'stroke': this.shape.shapeProperties.strokeColor,
            'fill': this.shape.shapeProperties.fillColor,
            'stroke-width': this.shape.shapeProperties.strokeWidth
        };
        return styles;
    };
    CircleComponent.prototype.startDrawing = function (beginPosition) {
        console.log('CircleComponent startDrawing at ', beginPosition);
        if (this.shape instanceof _model_shape__WEBPACK_IMPORTED_MODULE_4__["Circle"]) {
            this.shape.originX = beginPosition.x;
            this.shape.originY = beginPosition.y;
        }
    };
    CircleComponent.prototype.draw = function (currentPosition) {
        console.log('CircleComponent draw');
        if (this.shape instanceof _model_shape__WEBPACK_IMPORTED_MODULE_4__["Circle"]) {
            this.shape.r = Math.abs(currentPosition.x - this.shape.originX);
            //console.log('circle properties : ', this.shape.shapeProperties);
        }
    };
    CircleComponent.prototype.setSelectionPoints = function () {
        // <!-- < svg: rect attr.x = "{{ shape.originX - shape.r }}" attr.y = "{{ shape.originY - shape.r }}" attr.width = "{{ shape.r * 2 }}"
        // attr.height = "{{ shape.r * 2 }}" style = "stroke: red; stroke-width: 1; stroke-dasharray:5; fill:none" /> -->
    };
    CircleComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-circle',
            template: __webpack_require__(/*! ./circle.component.html */ "./src/app/svgcanvas/components/circle/circle.component.html"),
            styles: [__webpack_require__(/*! ./circle.component.css */ "./src/app/svgcanvas/components/circle/circle.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], CircleComponent);
    return CircleComponent;
}(_shape_shape_component__WEBPACK_IMPORTED_MODULE_2__["ShapeComponent"]));



/***/ }),

/***/ "./src/app/svgcanvas/components/dynamic-form/dynamic-form.component.css":
/*!******************************************************************************!*\
  !*** ./src/app/svgcanvas/components/dynamic-form/dynamic-form.component.css ***!
  \******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3N2Z2NhbnZhcy9jb21wb25lbnRzL2R5bmFtaWMtZm9ybS9keW5hbWljLWZvcm0uY29tcG9uZW50LmNzcyJ9 */"

/***/ }),

/***/ "./src/app/svgcanvas/components/dynamic-form/dynamic-form.component.html":
/*!*******************************************************************************!*\
  !*** ./src/app/svgcanvas/components/dynamic-form/dynamic-form.component.html ***!
  \*******************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div>\n    <form [formGroup]=\"dynamicForm\" novalidate (ngSubmit)=\"onSubmit(dynamicForm)\">\n        <ng-container *ngFor=\"let field of fields\" dynamic-field [field]=\"field\" [group]=\"dynamicForm\">\n        </ng-container>\n        <br>\n        <button class=\"btn btn-primary\" type=\"submit\">Submit</button>\n    </form>\n</div>"

/***/ }),

/***/ "./src/app/svgcanvas/components/dynamic-form/dynamic-form.component.ts":
/*!*****************************************************************************!*\
  !*** ./src/app/svgcanvas/components/dynamic-form/dynamic-form.component.ts ***!
  \*****************************************************************************/
/*! exports provided: DynamicFormComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "DynamicFormComponent", function() { return DynamicFormComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");



var DynamicFormComponent = /** @class */ (function () {
    function DynamicFormComponent(fb) {
        this.fb = fb;
        this.fields = [];
    }
    DynamicFormComponent.prototype.ngOnInit = function () {
        this.dynamicForm = this.createForm();
    };
    DynamicFormComponent.prototype.ngOnChanges = function () {
        this.dynamicForm = this.createForm();
    };
    DynamicFormComponent.prototype.createForm = function () {
        var _this = this;
        var formGroup = this.fb.group({});
        this.fields.forEach(function (field) {
            var formControl = _this.fb.control(field.value, _this.bindValidations(field.validations || []));
            formGroup.addControl(field.name, formControl);
        });
        return formGroup;
    };
    DynamicFormComponent.prototype.bindValidations = function (validations) {
        if (validations.length > 0) {
            var validList_1 = [];
            validations.forEach(function (valid) {
                validList_1.push(valid.validator);
            });
            return _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].compose(validList_1);
        }
        return null;
    };
    DynamicFormComponent.prototype.onSubmit = function (theForm) {
        console.log('form values:', theForm.value);
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Array)
    ], DynamicFormComponent.prototype, "fields", void 0);
    DynamicFormComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'dynamic-form',
            template: __webpack_require__(/*! ./dynamic-form.component.html */ "./src/app/svgcanvas/components/dynamic-form/dynamic-form.component.html"),
            styles: [__webpack_require__(/*! ./dynamic-form.component.css */ "./src/app/svgcanvas/components/dynamic-form/dynamic-form.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"]])
    ], DynamicFormComponent);
    return DynamicFormComponent;
}());



/***/ }),

/***/ "./src/app/svgcanvas/components/ellipse/ellipse.component.css":
/*!********************************************************************!*\
  !*** ./src/app/svgcanvas/components/ellipse/ellipse.component.css ***!
  \********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3N2Z2NhbnZhcy9jb21wb25lbnRzL2VsbGlwc2UvZWxsaXBzZS5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/svgcanvas/components/ellipse/ellipse.component.html":
/*!*********************************************************************!*\
  !*** ./src/app/svgcanvas/components/ellipse/ellipse.component.html ***!
  \*********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<ng-template #shapeTemplate>\n    <svg:g *ngIf=\"isSelected\">\n        <svg:rect attr.x=\"{{ shape.originX - shape.rx - 2 }}\" attr.y=\"{{ shape.originY - shape.ry - 2 }}\" width=\"4\"\n            height=\"4\" style=\"stroke: green; stroke-width: 1; fill:green\" />\n        <svg:rect attr.x=\"{{ shape.originX + shape.rx - 2 }}\" attr.y=\"{{ shape.originY - shape.ry - 2 }}\" width=\"4\"\n            height=\"4\" style=\"stroke: green; stroke-width: 1; fill:green\" />\n        <svg:rect attr.x=\"{{ shape.originX - shape.rx - 2 }}\" attr.y=\"{{ shape.originY + shape.ry - 2 }}\" width=\"4\"\n            height=\"4\" style=\"stroke: green; stroke-width: 1; fill:green\" />\n        <svg:rect attr.x=\"{{ shape.originX + shape.rx - 2 }}\" attr.y=\"{{ shape.originY + shape.ry - 2 }}\" width=\"4\"\n            height=\"4\" style=\"stroke: green; stroke-width: 1; fill:green\" />\n        <svg:rect *ngIf=\"isSelected\" attr.x=\"{{ shape.originX - shape.rx }}\" attr.y=\"{{ shape.originY - shape.ry }}\"\n            attr.width=\"{{ shape.rx * 2 }}\" attr.height=\"{{ shape.ry * 2 }}\" style=\"stroke: green; stroke-width: 1; fill:none\" />\n\n    </svg:g>\n    <svg:ellipse attr.id=\"{{shape.shapeProperties.name}}\" class=\"draggable\" attr.cx=\"{{ shape.originX }}\" attr.cy=\"{{ shape.originY }}\"\n        attr.rx=\"{{ shape.rx }}\" attr.ry=\"{{ shape.ry }}\" [ngStyle]=\"setStyles()\">\n        <title>{{ shape.shapeProperties.name }}</title>\n    </svg:ellipse>\n</ng-template>"

/***/ }),

/***/ "./src/app/svgcanvas/components/ellipse/ellipse.component.ts":
/*!*******************************************************************!*\
  !*** ./src/app/svgcanvas/components/ellipse/ellipse.component.ts ***!
  \*******************************************************************/
/*! exports provided: EllipseComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "EllipseComponent", function() { return EllipseComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _shape_shape_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../shape/shape.component */ "./src/app/svgcanvas/components/shape/shape.component.ts");
/* harmony import */ var _model_shape__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../model/shape */ "./src/app/svgcanvas/model/shape.ts");
/* harmony import */ var _model_shape_types__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../model/shape-types */ "./src/app/svgcanvas/model/shape-types.ts");





var EllipseComponent = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](EllipseComponent, _super);
    function EllipseComponent() {
        var _this = _super.call(this) || this;
        console.log('EllipseComponent constructor');
        _this.shape = new _model_shape__WEBPACK_IMPORTED_MODULE_3__["Ellipse"]();
        _this.shapeType = _model_shape_types__WEBPACK_IMPORTED_MODULE_4__["ShapeType"].Ellipse;
        return _this;
    }
    EllipseComponent.prototype.ngOnInit = function () {
        console.log('EllipseComponent ngOnInit');
    };
    EllipseComponent.prototype.setStyles = function () {
        var styles = {
            'stroke': this.shape.shapeProperties.strokeColor,
            'fill': this.shape.shapeProperties.fillColor,
            'stroke-width': this.shape.shapeProperties.strokeWidth
        };
        return styles;
    };
    EllipseComponent.prototype.startDrawing = function (beginPosition) {
        console.log('EllipseComponent startDrawing at ', beginPosition);
        if (this.shape instanceof _model_shape__WEBPACK_IMPORTED_MODULE_3__["Ellipse"]) {
            this.shape.originX = beginPosition.x;
            this.shape.originY = beginPosition.y;
        }
    };
    EllipseComponent.prototype.draw = function (currentPosition) {
        console.log('EllipseComponent draw');
        if (this.shape instanceof _model_shape__WEBPACK_IMPORTED_MODULE_3__["Ellipse"]) {
            this.shape.rx = Math.abs(currentPosition.x - this.shape.originX);
            this.shape.ry = Math.abs(currentPosition.y - this.shape.originY);
            //console.log('eliipse properties : ', this.shape);
        }
    };
    EllipseComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-ellipse',
            template: __webpack_require__(/*! ./ellipse.component.html */ "./src/app/svgcanvas/components/ellipse/ellipse.component.html"),
            styles: [__webpack_require__(/*! ./ellipse.component.css */ "./src/app/svgcanvas/components/ellipse/ellipse.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], EllipseComponent);
    return EllipseComponent;
}(_shape_shape_component__WEBPACK_IMPORTED_MODULE_2__["ShapeComponent"]));



/***/ }),

/***/ "./src/app/svgcanvas/components/freehand/freehand.component.css":
/*!**********************************************************************!*\
  !*** ./src/app/svgcanvas/components/freehand/freehand.component.css ***!
  \**********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3N2Z2NhbnZhcy9jb21wb25lbnRzL2ZyZWVoYW5kL2ZyZWVoYW5kLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/svgcanvas/components/freehand/freehand.component.html":
/*!***********************************************************************!*\
  !*** ./src/app/svgcanvas/components/freehand/freehand.component.html ***!
  \***********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<ng-template #shapeTemplate>\n  <svg:polyline attr.id=\"{{ shape.shapeProperties.name }}\" class=\"draggable\" attr.points=\"{{ svgValue }}\" [ngStyle]=\"setStyles()\">\n    <title>{{ shape.shapeProperties.name }}</title>\n  </svg:polyline>\n</ng-template>\n"

/***/ }),

/***/ "./src/app/svgcanvas/components/freehand/freehand.component.ts":
/*!*********************************************************************!*\
  !*** ./src/app/svgcanvas/components/freehand/freehand.component.ts ***!
  \*********************************************************************/
/*! exports provided: FreehandComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FreehandComponent", function() { return FreehandComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _shape_shape_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../shape/shape.component */ "./src/app/svgcanvas/components/shape/shape.component.ts");
/* harmony import */ var _model_shape__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../model/shape */ "./src/app/svgcanvas/model/shape.ts");
/* harmony import */ var _model_shape_types__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../model/shape-types */ "./src/app/svgcanvas/model/shape-types.ts");





var FreehandComponent = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](FreehandComponent, _super);
    function FreehandComponent() {
        var _this = _super.call(this) || this;
        console.log('Freehand constructor');
        _this.shape = new _model_shape__WEBPACK_IMPORTED_MODULE_3__["PolyLine"]();
        _this.shapeType = _model_shape_types__WEBPACK_IMPORTED_MODULE_4__["ShapeType"].PolyLine;
        _this.svgValue = '';
        return _this;
    }
    FreehandComponent.prototype.ngOnInit = function () {
    };
    FreehandComponent.prototype.setStyles = function () {
        var styles = {
            'stroke': this.shape.shapeProperties.strokeColor,
            'fill': 'transparent',
            'stroke-width': this.isSelected ? 5 : this.shape.shapeProperties.strokeWidth
        };
        return styles;
    };
    FreehandComponent.prototype.savePosition = function (x, y) {
        this.lastX = Math.round(x);
        this.lastY = Math.round(y);
        this.svgValue += x + ',' + y + ' ';
    };
    FreehandComponent.prototype.startDrawing = function (beginPosition) {
        console.log('FreehandComponent startDrawing at ', beginPosition);
        if (this.shape instanceof _model_shape__WEBPACK_IMPORTED_MODULE_3__["PolyLine"]) {
            this.savePosition(beginPosition.x, beginPosition.y);
            if (this.shape instanceof _model_shape__WEBPACK_IMPORTED_MODULE_3__["PolyLine"]) {
                this.shape.points.push(beginPosition);
            }
        }
    };
    FreehandComponent.prototype.draw = function (currentPosition) {
        // console.log('FreehandComponent draw');
        if (this.shape instanceof _model_shape__WEBPACK_IMPORTED_MODULE_3__["PolyLine"]) {
            var x = Math.round(currentPosition.x);
            var y = Math.round(currentPosition.y);
            if (x !== this.lastX || y !== this.lastY) {
                var mp = new _model_shape__WEBPACK_IMPORTED_MODULE_3__["MousePosition"]();
                mp.x = x;
                mp.y = y;
                mp.timestamp = currentPosition.timestamp;
                this.shape.points.push(mp);
                this.savePosition(x, y);
                // console.log('FH: ' + currentPosition.x + ' ' + currentPosition.y + ' ' + currentPosition.timestamp);
            }
        }
    };
    FreehandComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-freehand',
            template: __webpack_require__(/*! ./freehand.component.html */ "./src/app/svgcanvas/components/freehand/freehand.component.html"),
            styles: [__webpack_require__(/*! ./freehand.component.css */ "./src/app/svgcanvas/components/freehand/freehand.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], FreehandComponent);
    return FreehandComponent;
}(_shape_shape_component__WEBPACK_IMPORTED_MODULE_2__["ShapeComponent"]));



/***/ }),

/***/ "./src/app/svgcanvas/components/group/group.component.css":
/*!****************************************************************!*\
  !*** ./src/app/svgcanvas/components/group/group.component.css ***!
  \****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3N2Z2NhbnZhcy9jb21wb25lbnRzL2dyb3VwL2dyb3VwLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/svgcanvas/components/group/group.component.html":
/*!*****************************************************************!*\
  !*** ./src/app/svgcanvas/components/group/group.component.html ***!
  \*****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<p>\n  group works!\n</p>\n"

/***/ }),

/***/ "./src/app/svgcanvas/components/group/group.component.ts":
/*!***************************************************************!*\
  !*** ./src/app/svgcanvas/components/group/group.component.ts ***!
  \***************************************************************/
/*! exports provided: GroupComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "GroupComponent", function() { return GroupComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _shape_shape_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../shape/shape.component */ "./src/app/svgcanvas/components/shape/shape.component.ts");



var GroupComponent = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](GroupComponent, _super);
    function GroupComponent() {
        var _this = _super.call(this) || this;
        console.log('GroupComponent constructor');
        _this.groupObjects = new Array();
        return _this;
    }
    GroupComponent.prototype.ngOnInit = function () {
    };
    GroupComponent.prototype.clear = function () {
        this.groupObjects = new Array();
    };
    GroupComponent.prototype.add = function (shape) {
        this.groupObjects.push(shape);
    };
    GroupComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-group',
            template: __webpack_require__(/*! ./group.component.html */ "./src/app/svgcanvas/components/group/group.component.html"),
            styles: [__webpack_require__(/*! ./group.component.css */ "./src/app/svgcanvas/components/group/group.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], GroupComponent);
    return GroupComponent;
}(_shape_shape_component__WEBPACK_IMPORTED_MODULE_2__["ShapeComponent"]));



/***/ }),

/***/ "./src/app/svgcanvas/components/image/image.component.css":
/*!****************************************************************!*\
  !*** ./src/app/svgcanvas/components/image/image.component.css ***!
  \****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3N2Z2NhbnZhcy9jb21wb25lbnRzL2ltYWdlL2ltYWdlLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/svgcanvas/components/image/image.component.html":
/*!*****************************************************************!*\
  !*** ./src/app/svgcanvas/components/image/image.component.html ***!
  \*****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<ng-template #shapeTemplate>\n    <svg:image attr.id=\"{{shape.shapeProperties.name}}\" class=\"draggable\" attr.x=\"{{ shape.originX }}\" attr.y=\"{{ shape.originY }}\"\n        attr.height=\"{{ shape.height }}\" attr.width=\"{{ shape.width }}\" attr.xlink:href=\"{{ shape.url }}\">\n        <title>{{ shape.shapeProperties.name }}</title>\n    </svg:image>\n</ng-template>"

/***/ }),

/***/ "./src/app/svgcanvas/components/image/image.component.ts":
/*!***************************************************************!*\
  !*** ./src/app/svgcanvas/components/image/image.component.ts ***!
  \***************************************************************/
/*! exports provided: ImageComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ImageComponent", function() { return ImageComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _shape_shape_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../shape/shape.component */ "./src/app/svgcanvas/components/shape/shape.component.ts");
/* harmony import */ var _model_shape__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../model/shape */ "./src/app/svgcanvas/model/shape.ts");
/* harmony import */ var _model_shape_types__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../model/shape-types */ "./src/app/svgcanvas/model/shape-types.ts");





var ImageComponent = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](ImageComponent, _super);
    function ImageComponent() {
        var _this = _super.call(this) || this;
        console.log('ImgeComponent constructor');
        _this.shape = new _model_shape__WEBPACK_IMPORTED_MODULE_3__["ImageBox"]();
        _this.shapeType = _model_shape_types__WEBPACK_IMPORTED_MODULE_4__["ShapeType"].Image;
        return _this;
    }
    ImageComponent.prototype.ngOnInit = function () {
        console.log('ImageComponent ngOnInit');
    };
    ImageComponent.prototype.startDrawing = function (beginPosition) {
        if (this.shape instanceof _model_shape__WEBPACK_IMPORTED_MODULE_3__["ImageBox"]) {
            this.shape.originX = beginPosition.x;
            this.shape.originY = beginPosition.y;
        }
        console.log('ImageComponent startDrawing at ', beginPosition, ', ', this.shape);
    };
    ImageComponent.prototype.draw = function (currentPosition) {
        console.log('ImageComponent draw');
        if (this.shape instanceof _model_shape__WEBPACK_IMPORTED_MODULE_3__["ImageBox"]) {
            this.shape.width = Math.abs(currentPosition.x - this.shape.originX);
            this.shape.height = Math.abs(currentPosition.y - this.shape.originY);
        }
    };
    ImageComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-image',
            template: __webpack_require__(/*! ./image.component.html */ "./src/app/svgcanvas/components/image/image.component.html"),
            styles: [__webpack_require__(/*! ./image.component.css */ "./src/app/svgcanvas/components/image/image.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], ImageComponent);
    return ImageComponent;
}(_shape_shape_component__WEBPACK_IMPORTED_MODULE_2__["ShapeComponent"]));



/***/ }),

/***/ "./src/app/svgcanvas/components/line/line.component.css":
/*!**************************************************************!*\
  !*** ./src/app/svgcanvas/components/line/line.component.css ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3N2Z2NhbnZhcy9jb21wb25lbnRzL2xpbmUvbGluZS5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/svgcanvas/components/line/line.component.html":
/*!***************************************************************!*\
  !*** ./src/app/svgcanvas/components/line/line.component.html ***!
  \***************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<ng-template #shapeTemplate>\n    <svg:g *ngIf=\"isSelected\">\n        <svg:rect attr.x=\"{{ shape.originX - 2 }}\" attr.y=\"{{ shape.originY - 2 }}\" width=\"4\" height=\"4\" style=\"stroke: green; stroke-width: 1; fill:green\" />\n        <svg:rect attr.x=\"{{ shape.x2 - 2 }}\" attr.y=\"{{ shape.y2 - 2 }}\" width=\"4\" height=\"4\" style=\"stroke: green; stroke-width: 1; fill:green\" />\n    </svg:g>\n    <svg:line attr.id=\"{{shape.shapeProperties.name}}\" class=\"draggable\" attr.x1=\"{{ shape.originX }}\" attr.y1=\"{{ shape.originY }}\"\n        attr.x2=\"{{ shape.x2 }}\" attr.y2=\"{{ shape.y2 }}\" [ngStyle]=\"setStyles()\">\n        <title>{{ shape.shapeProperties.name }}</title>\n    </svg:line>\n</ng-template>"

/***/ }),

/***/ "./src/app/svgcanvas/components/line/line.component.ts":
/*!*************************************************************!*\
  !*** ./src/app/svgcanvas/components/line/line.component.ts ***!
  \*************************************************************/
/*! exports provided: LineComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LineComponent", function() { return LineComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _model_shape__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../model/shape */ "./src/app/svgcanvas/model/shape.ts");
/* harmony import */ var _shape_shape_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../shape/shape.component */ "./src/app/svgcanvas/components/shape/shape.component.ts");
/* harmony import */ var _model_shape_types__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../model/shape-types */ "./src/app/svgcanvas/model/shape-types.ts");





var LineComponent = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](LineComponent, _super);
    function LineComponent() {
        var _this = _super.call(this) || this;
        _this.shape = new _model_shape__WEBPACK_IMPORTED_MODULE_2__["Line"]();
        _this.shapeType = _model_shape_types__WEBPACK_IMPORTED_MODULE_4__["ShapeType"].Line;
        console.log('LineComponent constructor:', _this);
        return _this;
    }
    LineComponent.prototype.ngOnInit = function () {
        console.log('LineComponent ngOnInit');
    };
    LineComponent.prototype.setStyles = function () {
        var styles = {
            'stroke': this.shape.shapeProperties.strokeColor,
            'stroke-width': this.shape.shapeProperties.strokeWidth
        };
        return styles;
    };
    LineComponent.prototype.startDrawing = function (beginPosition) {
        if (this.shape instanceof _model_shape__WEBPACK_IMPORTED_MODULE_2__["Line"]) {
            this.shape.originX = beginPosition.x;
            this.shape.originY = beginPosition.y;
            this.shape.x2 = beginPosition.x;
            this.shape.y2 = beginPosition.y;
        }
        console.log('LineComponent startDrawing at ', beginPosition, ', ', this.shape);
    };
    LineComponent.prototype.draw = function (currentPosition) {
        console.log('LineComponent draw');
        if (this.shape instanceof _model_shape__WEBPACK_IMPORTED_MODULE_2__["Line"]) {
            this.shape.x2 = currentPosition.x;
            this.shape.y2 = currentPosition.y;
        }
    };
    LineComponent.prototype.drag = function (draqPosition) {
        console.log('line dragging');
    };
    LineComponent.prototype.setEndPosition = function (toX, toY) {
        if (this.shape instanceof _model_shape__WEBPACK_IMPORTED_MODULE_2__["Line"]) {
            this.shape.x2 = toX;
            this.shape.y2 = toY;
        }
    };
    LineComponent.prototype.moveHorizontallyTo = function (x) {
        if (this.shape instanceof _model_shape__WEBPACK_IMPORTED_MODULE_2__["Line"]) {
            this.shape.originX = x;
            this.shape.x2 = x;
        }
    };
    LineComponent.prototype.moveVerticallyTo = function (y) {
        if (this.shape instanceof _model_shape__WEBPACK_IMPORTED_MODULE_2__["Line"]) {
            this.shape.originY = y;
            this.shape.y2 = y;
        }
    };
    LineComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-line',
            template: __webpack_require__(/*! ./line.component.html */ "./src/app/svgcanvas/components/line/line.component.html"),
            styles: [__webpack_require__(/*! ./line.component.css */ "./src/app/svgcanvas/components/line/line.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], LineComponent);
    return LineComponent;
}(_shape_shape_component__WEBPACK_IMPORTED_MODULE_3__["ShapeComponent"]));



/***/ }),

/***/ "./src/app/svgcanvas/components/path/path.component.css":
/*!**************************************************************!*\
  !*** ./src/app/svgcanvas/components/path/path.component.css ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3N2Z2NhbnZhcy9jb21wb25lbnRzL3BhdGgvcGF0aC5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/svgcanvas/components/path/path.component.html":
/*!***************************************************************!*\
  !*** ./src/app/svgcanvas/components/path/path.component.html ***!
  \***************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<ng-template #shapeTemplate>\n    <svg:line *ngIf=\"hasPoints\" attr.x1=\"{{ shape.points[0].x }}\" attr.y1=\"{{ shape.points[0].y }}\" attr.x2=\"{{ lastPoint.x }}\"\n        attr.y2=\"{{ lastPoint.y }}\" [ngStyle]=\"setStyles()\">\n    </svg:line>\n\n    <svg:g *ngIf=\"isSelected || isMoving\">\n        <svg:circle attr.cx=\"{{ shape.points[0].x }}\" attr.cy=\"{{ shape.points[0].y }}\" r=\"4\" stroke=\"black\"\n            stroke-width=\"1\" fill=\"green\">\n        </svg:circle>\n        <svg:circle attr.cx=\"{{ shape.points[1].x }}\" attr.cy=\"{{ shape.points[1].y }}\" r=\"4\" stroke=\"black\"\n            stroke-width=\"1\" fill=\"green\">\n        </svg:circle>\n        <svg:circle attr.cx=\"{{ controlPoint.x }}\" attr.cy=\"{{ controlPoint.y }}\" r=\"4\" stroke=\"black\" stroke-width=\"1\"\n            fill=\"green\">\n        </svg:circle>\n    </svg:g>\n\n    <svg:path attr.id=\"{{ shape.shapeProperties.name }}\" attr.d=\"{{ value }}\" class=\"draggable\" [ngStyle]=\"setStyles()\">\n        <title>{{ shape.shapeProperties.name }}</title>\n    </svg:path>\n</ng-template>"

/***/ }),

/***/ "./src/app/svgcanvas/components/path/path.component.ts":
/*!*************************************************************!*\
  !*** ./src/app/svgcanvas/components/path/path.component.ts ***!
  \*************************************************************/
/*! exports provided: PathComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PathComponent", function() { return PathComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _shape_shape_component__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./../shape/shape.component */ "./src/app/svgcanvas/components/shape/shape.component.ts");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _model_shape_types__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../model/shape-types */ "./src/app/svgcanvas/model/shape-types.ts");
/* harmony import */ var _model_shape__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../model/shape */ "./src/app/svgcanvas/model/shape.ts");





var PathComponent = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](PathComponent, _super);
    function PathComponent() {
        var _this = _super.call(this) || this;
        _this.value = '';
        _this.hasPoints = false;
        _this.isMoving = false;
        _this.shape = new _model_shape__WEBPACK_IMPORTED_MODULE_4__["Path"]();
        _this.shapeType = _model_shape_types__WEBPACK_IMPORTED_MODULE_3__["ShapeType"].Path;
        console.log('PathComponent constructor');
        return _this;
    }
    PathComponent.prototype.ngOnInit = function () {
        console.log('PathComponent ngOnInit');
    };
    PathComponent.prototype.setStyles = function () {
        var styles = {
            'fill': 'none',
            'stroke': this.shape.shapeProperties.strokeColor,
            'stroke-width': this.shape.shapeProperties.strokeWidth
        };
        return styles;
    };
    PathComponent.prototype.setPoint = function (point) {
        if (this.shape instanceof _model_shape__WEBPACK_IMPORTED_MODULE_4__["Path"]) {
            if (this.shape.state == _model_shape_types__WEBPACK_IMPORTED_MODULE_3__["State"].Moving) {
                this.shape.state = _model_shape_types__WEBPACK_IMPORTED_MODULE_3__["State"].Finished;
                this.hasPoints = false;
                this.isMoving = false;
            }
            else {
                this.lastPoint = Object.assign({}, point);
                this.shape.points.push(this.lastPoint);
                console.log('points = ', this.shape.points, ', size = ', this.shape.points.length, ', %2 = ', this.shape.points.length % 2);
                if (this.shape.points.length % 2 == 0) {
                    this.calculateControlPoint(this.shape.points[0], this.shape.points[1]);
                    this.value = "M" + this.shape.points[0].x + " " + this.shape.points[0].y + " Q " + this.controlPoint.x + " " + this.controlPoint.y + " " + this.shape.points[1].x + " " + this.shape.points[1].y;
                    this.hasPoints = false;
                    this.shape.state = _model_shape_types__WEBPACK_IMPORTED_MODULE_3__["State"].Moving;
                    this.isMoving = true;
                }
            }
        }
    };
    PathComponent.prototype.draw = function (currentPosition) {
        if (this.shape instanceof _model_shape__WEBPACK_IMPORTED_MODULE_4__["Path"]) {
            if (this.shape.state == _model_shape_types__WEBPACK_IMPORTED_MODULE_3__["State"].Moving) {
                this.controlPoint = Object.assign({}, currentPosition);
                this.value = "M" + this.shape.points[0].x + " " + this.shape.points[0].y + " Q " + this.controlPoint.x + " " + this.controlPoint.y + " " + this.shape.points[1].x + " " + this.shape.points[1].y;
            }
            else if (this.shape.state != _model_shape_types__WEBPACK_IMPORTED_MODULE_3__["State"].Finished) {
                this.lastPoint = Object.assign({}, currentPosition);
                this.hasPoints = true;
            }
        }
    };
    PathComponent.prototype.endDrawing = function () {
        if (this.shape instanceof _model_shape__WEBPACK_IMPORTED_MODULE_4__["Path"]) {
            this.hasPoints = false;
            this.shape.state = _model_shape_types__WEBPACK_IMPORTED_MODULE_3__["State"].None;
        }
    };
    PathComponent.prototype.calculateControlPoint = function (p1, p2) {
        var mpx = (p2.x + p1.x) * 0.5;
        var mpy = (p2.y + p1.y) * 0.5;
        var theta = Math.atan2(p2.y - p1.y, p2.x - p1.x) - Math.PI / 2;
        var offset = 50;
        var c1x = mpx + offset * Math.cos(theta);
        var c1y = mpy + offset * Math.sin(theta);
        this.controlPoint = {
            x: c1x,
            y: c1y,
            timestamp: 0
        };
    };
    PathComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["Component"])({
            selector: 'app-path',
            template: __webpack_require__(/*! ./path.component.html */ "./src/app/svgcanvas/components/path/path.component.html"),
            styles: [__webpack_require__(/*! ./path.component.css */ "./src/app/svgcanvas/components/path/path.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], PathComponent);
    return PathComponent;
}(_shape_shape_component__WEBPACK_IMPORTED_MODULE_1__["ShapeComponent"]));



/***/ }),

/***/ "./src/app/svgcanvas/components/polyline/polyline.component.css":
/*!**********************************************************************!*\
  !*** ./src/app/svgcanvas/components/polyline/polyline.component.css ***!
  \**********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3N2Z2NhbnZhcy9jb21wb25lbnRzL3BvbHlsaW5lL3BvbHlsaW5lLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/svgcanvas/components/polyline/polyline.component.html":
/*!***********************************************************************!*\
  !*** ./src/app/svgcanvas/components/polyline/polyline.component.html ***!
  \***********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<ng-template #shapeTemplate>\n    <svg:line *ngIf=\"hasPoints\" attr.x1=\"{{ lastPoint.x }}\" attr.y1=\"{{ lastPoint.y }}\" attr.x2=\"{{ currentPoint.x }}\"\n        attr.y2=\"{{ currentPoint.y }}\" [ngStyle]=\"setStyles()\">\n    </svg:line>\n\n    <svg:polyline attr.id=\"{{ shape.shapeProperties.name }}\" class=\"draggable\" attr.points=\"{{ value }}\" [ngStyle]=\"setStyles()\">\n        <title>{{ shape.shapeProperties.name }}</title>\n    </svg:polyline>\n</ng-template>"

/***/ }),

/***/ "./src/app/svgcanvas/components/polyline/polyline.component.ts":
/*!*********************************************************************!*\
  !*** ./src/app/svgcanvas/components/polyline/polyline.component.ts ***!
  \*********************************************************************/
/*! exports provided: PolyLineComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PolyLineComponent", function() { return PolyLineComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _shape_shape_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../shape/shape.component */ "./src/app/svgcanvas/components/shape/shape.component.ts");
/* harmony import */ var _model_shape__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../model/shape */ "./src/app/svgcanvas/model/shape.ts");
/* harmony import */ var _model_shape_types__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../model/shape-types */ "./src/app/svgcanvas/model/shape-types.ts");





var PolyLineComponent = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](PolyLineComponent, _super);
    function PolyLineComponent() {
        var _this = _super.call(this) || this;
        _this.value = '';
        _this.hasPoints = false;
        _this.shape = new _model_shape__WEBPACK_IMPORTED_MODULE_3__["PolyLine"]();
        _this.shapeType = _model_shape_types__WEBPACK_IMPORTED_MODULE_4__["ShapeType"].PolyLine;
        console.log('PolyLineComponent constructor:', _this);
        return _this;
    }
    PolyLineComponent.prototype.ngOnInit = function () {
        console.log('PolyLineComponent ngOnInit');
    };
    PolyLineComponent.prototype.setStyles = function () {
        var styles = {
            'fill': 'none',
            'stroke': this.shape.shapeProperties.strokeColor,
            'stroke-width': this.shape.shapeProperties.strokeWidth
        };
        return styles;
    };
    PolyLineComponent.prototype.setPoint = function (point) {
        if (this.shape instanceof _model_shape__WEBPACK_IMPORTED_MODULE_3__["PolyLine"]) {
            this.lastPoint = Object.assign({}, point);
            this.shape.points.push(this.lastPoint);
            console.log('points = ', this.shape.points);
            this.value += point.x + "," + point.y + " ";
            console.log('PolyLineComponent value ', this.value);
        }
    };
    PolyLineComponent.prototype.draw = function (currentPosition) {
        if (this.shape instanceof _model_shape__WEBPACK_IMPORTED_MODULE_3__["PolyLine"]) {
            this.currentPoint = Object.assign({}, currentPosition);
            this.hasPoints = true;
            console.log('PolyLineComponent : draw() last= ', this.lastPoint, ', current=', this.currentPoint, ', points=', this.shape.points);
        }
    };
    PolyLineComponent.prototype.endDrawing = function () {
        this.currentPoint = this.lastPoint;
    };
    PolyLineComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-polyline',
            template: __webpack_require__(/*! ./polyline.component.html */ "./src/app/svgcanvas/components/polyline/polyline.component.html"),
            styles: [__webpack_require__(/*! ./polyline.component.css */ "./src/app/svgcanvas/components/polyline/polyline.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], PolyLineComponent);
    return PolyLineComponent;
}(_shape_shape_component__WEBPACK_IMPORTED_MODULE_2__["ShapeComponent"]));



/***/ }),

/***/ "./src/app/svgcanvas/components/rectangle/rectangle.component.css":
/*!************************************************************************!*\
  !*** ./src/app/svgcanvas/components/rectangle/rectangle.component.css ***!
  \************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "/* drizo */\n.svgHandle {\n  stroke-width: 1;\n}\n.svgTopLeftHandle {\n  cursor: nw-resize;\n}\n.svgTopRightHandle {\n  cursor: ne-resize;\n}\n.svgBottomLeftHandle {\n  cursor: sw-resize;\n}\n.svgBottomRightHandle {\n  cursor: se-resize;\n}\n\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvc3ZnY2FudmFzL2NvbXBvbmVudHMvcmVjdGFuZ2xlL3JlY3RhbmdsZS5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBLFVBQVU7QUFDVjtFQUNFLGVBQWU7QUFDakI7QUFFQTtFQUNFLGlCQUFpQjtBQUNuQjtBQUVBO0VBQ0UsaUJBQWlCO0FBQ25CO0FBRUE7RUFDRSxpQkFBaUI7QUFDbkI7QUFFQTtFQUNFLGlCQUFpQjtBQUNuQiIsImZpbGUiOiJzcmMvYXBwL3N2Z2NhbnZhcy9jb21wb25lbnRzL3JlY3RhbmdsZS9yZWN0YW5nbGUuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi8qIGRyaXpvICovXG4uc3ZnSGFuZGxlIHtcbiAgc3Ryb2tlLXdpZHRoOiAxO1xufVxuXG4uc3ZnVG9wTGVmdEhhbmRsZSB7XG4gIGN1cnNvcjogbnctcmVzaXplO1xufVxuXG4uc3ZnVG9wUmlnaHRIYW5kbGUge1xuICBjdXJzb3I6IG5lLXJlc2l6ZTtcbn1cblxuLnN2Z0JvdHRvbUxlZnRIYW5kbGUge1xuICBjdXJzb3I6IHN3LXJlc2l6ZTtcbn1cblxuLnN2Z0JvdHRvbVJpZ2h0SGFuZGxlIHtcbiAgY3Vyc29yOiBzZS1yZXNpemU7XG59XG5cbiJdfQ== */"

/***/ }),

/***/ "./src/app/svgcanvas/components/rectangle/rectangle.component.html":
/*!*************************************************************************!*\
  !*** ./src/app/svgcanvas/components/rectangle/rectangle.component.html ***!
  \*************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<ng-template #shapeTemplate>\n    <svg:rect attr.id=\"{{shape.shapeProperties.name}}\" class=\"draggable\" attr.x=\"{{ shape.originX }}\" attr.y=\"{{ shape.originY }}\"\n        attr.width=\"{{ shape.width }}\" attr.height=\"{{ shape.height }}\" [ngStyle]=\"setStyles()\">\n        <title>{{ shape.shapeProperties.name }}</title>\n    </svg:rect>\n    <svg:text attr.x=\"{{shape.originX+3}}\" attr.y=\"{{ shape.originY+8 }}\">{{ label }}</svg:text>\n    <svg:g *ngIf=\"isEditing\">\n        <svg:rect attr.x=\"{{ shape.originX - handlesRadius }}\" attr.y=\"{{ shape.originY - handlesRadius }}\"\n                  class=\"svgHandle svgTopLeftHandle\"\n                  attr.width=\"{{handlesRadius*2}}\" attr.height=\"{{handlesRadius*2}}\" attr.fill=\"{{handlesColor}}\" attr.stroke=\"{{handlesColor}}\"\n                  (mousedown)=\"onHandleMouseDown($event, 'svgTopLeftHandle')\"\n        />\n        <svg:rect attr.x=\"{{ shape.originX + shape.width - handlesRadius }}\" attr.y=\"{{ shape.originY - handlesRadius }}\"\n                  class=\"svgHandle svgTopRightHandle\"\n                  attr.width=\"{{handlesRadius*2}}\" attr.height=\"{{handlesRadius*2}}\" attr.fill=\"{{handlesColor}}\" attr.stroke=\"{{handlesColor}}\"\n                  (mousedown)=\"onHandleMouseDown($event, 'svgTopRightHandle')\"\n        />\n        <svg:rect attr.x=\"{{ shape.originX - handlesRadius }}\" attr.y=\"{{ shape.originY + shape.height - handlesRadius }}\"\n                  class=\"svgHandle svgBottomLeftHandle\"\n                  attr.width=\"{{handlesRadius*2}}\" attr.height=\"{{handlesRadius*2}}\" attr.fill=\"{{handlesColor}}\" attr.stroke=\"{{handlesColor}}\"\n                  (mousedown)=\"onHandleMouseDown($event, 'svgBottomLeftHandle')\"\n        />\n        <svg:rect attr.x=\"{{ shape.originX + shape.width - handlesRadius }}\" attr.y=\"{{ shape.originY + shape.height - handlesRadius }}\"\n                  class=\"svgHandle svgBottomRightHandle\"\n                  attr.width=\"{{handlesRadius*2}}\" attr.height=\"{{handlesRadius*2}}\" attr.fill=\"{{handlesColor}}\" attr.stroke=\"{{handlesColor}}\"\n                  (mousedown)=\"onHandleMouseDown($event, 'svgBottomRightHandle')\"\n        />\n    </svg:g>\n</ng-template>\n"

/***/ }),

/***/ "./src/app/svgcanvas/components/rectangle/rectangle.component.ts":
/*!***********************************************************************!*\
  !*** ./src/app/svgcanvas/components/rectangle/rectangle.component.ts ***!
  \***********************************************************************/
/*! exports provided: RectangleComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RectangleComponent", function() { return RectangleComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _shape_shape_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../shape/shape.component */ "./src/app/svgcanvas/components/shape/shape.component.ts");
/* harmony import */ var _model_shape_types__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../model/shape-types */ "./src/app/svgcanvas/model/shape-types.ts");
/* harmony import */ var _model_shape__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../model/shape */ "./src/app/svgcanvas/model/shape.ts");





var RectangleComponent = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](RectangleComponent, _super);
    function RectangleComponent() {
        var _this = _super.call(this) || this;
        _this.label = '';
        console.log('RectangleComponent constructor');
        _this.shape = new _model_shape__WEBPACK_IMPORTED_MODULE_4__["Rectangle"]();
        _this.shapeType = _model_shape_types__WEBPACK_IMPORTED_MODULE_3__["ShapeType"].Rectangle;
        return _this;
    }
    RectangleComponent.prototype.ngOnInit = function () {
        console.log('RectangleComponent ngOnInit');
    };
    RectangleComponent.prototype.setStyles = function () {
        var styles = {
            'stroke': this.shape.shapeProperties.strokeColor,
            'fill': this.shape.shapeProperties.fillColor,
            'stroke-width': this.isSelected ? 5 : this.shape.shapeProperties.strokeWidth
        };
        return styles;
    };
    RectangleComponent.prototype.startDrawing = function (beginPosition) {
        console.log('RectanleComponent startDrawing at ', beginPosition);
        if (this.shape instanceof _model_shape__WEBPACK_IMPORTED_MODULE_4__["Rectangle"]) {
            this.shape.originX = beginPosition.x;
            this.shape.originY = beginPosition.y;
        }
    };
    RectangleComponent.prototype.draw = function (currentPosition) {
        console.log('RectangleComponent draw');
        if (this.shape instanceof _model_shape__WEBPACK_IMPORTED_MODULE_4__["Rectangle"]) {
            this.shape.width = Math.abs(currentPosition.x - this.shape.originX);
            this.shape.height = Math.abs(currentPosition.y - this.shape.originY);
        }
    };
    RectangleComponent.prototype.setDimensions = function (width, height) {
        if (this.shape instanceof _model_shape__WEBPACK_IMPORTED_MODULE_4__["Rectangle"]) {
            this.shape.width = width;
            this.shape.height = height;
        }
    };
    // drizo don't use mouseUp or move because it usually looses focus no movement
    // - it is handled
    RectangleComponent.prototype.onHandleMouseMove = function (x, y) {
        if (this.handleSelected) {
            switch (this.handleSelected) {
                case 'svgTopLeftHandle':
                    this.resizeNW(x, y);
                    break;
                case 'svgTopRightHandle':
                    this.resizeNE(x, y);
                    break;
                case 'svgBottomLeftHandle':
                    this.resizeSW(x, y);
                    break;
                case 'svgBottomRightHandle':
                    this.resizeSE(x, y);
                    break;
            }
            return true;
        }
        else {
            return false;
        }
    };
    RectangleComponent.prototype.resizeNW = function (x, y) {
        if (this.shape instanceof _model_shape__WEBPACK_IMPORTED_MODULE_4__["Rectangle"]) {
            var diffX = this.shape.originX - x;
            var diffY = this.shape.originY - y;
            var newWidth = this.shape.width + diffX;
            var newHeight = this.shape.height + diffY;
            if (newWidth > 0 && newHeight > 0) {
                this.shape.originX = x;
                this.shape.originY = y;
                this.shape.width = newWidth;
                this.shape.height = newHeight;
            }
        }
    };
    RectangleComponent.prototype.resizeNE = function (x, y) {
        if (this.shape instanceof _model_shape__WEBPACK_IMPORTED_MODULE_4__["Rectangle"]) {
            var diffX = x - (this.shape.originX + this.shape.width);
            var diffY = this.shape.originY - y;
            var newWidth = this.shape.width + diffX;
            var newHeight = this.shape.height + diffY;
            if (newWidth > 0 && newHeight > 0) {
                this.shape.width = newWidth;
                this.shape.height = newHeight;
                this.shape.originY = y;
            }
        }
    };
    RectangleComponent.prototype.resizeSW = function (x, y) {
        if (this.shape instanceof _model_shape__WEBPACK_IMPORTED_MODULE_4__["Rectangle"]) {
            var diffX = this.shape.originX - x;
            var diffY = y - (this.shape.originY + this.shape.height);
            var newWidth = this.shape.width + diffX;
            var newHeight = this.shape.height + diffY;
            if (newWidth > 0 && newHeight > 0) {
                this.shape.originX = x;
                this.shape.width = newWidth;
                this.shape.height = newHeight;
            }
        }
    };
    RectangleComponent.prototype.resizeSE = function (x, y) {
        if (this.shape instanceof _model_shape__WEBPACK_IMPORTED_MODULE_4__["Rectangle"]) {
            var diffX = x - (this.shape.originX + this.shape.width);
            var diffY = y - (this.shape.originY + this.shape.height);
            var newWidth = this.shape.width + diffX;
            var newHeight = this.shape.height + diffY;
            if (newWidth > 0 && newHeight > 0) {
                this.shape.width = newWidth;
                this.shape.height = newHeight;
            }
        }
    };
    RectangleComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-rectangle',
            template: __webpack_require__(/*! ./rectangle.component.html */ "./src/app/svgcanvas/components/rectangle/rectangle.component.html"),
            styles: [__webpack_require__(/*! ./rectangle.component.css */ "./src/app/svgcanvas/components/rectangle/rectangle.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], RectangleComponent);
    return RectangleComponent;
}(_shape_shape_component__WEBPACK_IMPORTED_MODULE_2__["ShapeComponent"]));



/***/ }),

/***/ "./src/app/svgcanvas/components/shape/shape.component.css":
/*!****************************************************************!*\
  !*** ./src/app/svgcanvas/components/shape/shape.component.css ***!
  \****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3N2Z2NhbnZhcy9jb21wb25lbnRzL3NoYXBlL3NoYXBlLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/svgcanvas/components/shape/shape.component.html":
/*!*****************************************************************!*\
  !*** ./src/app/svgcanvas/components/shape/shape.component.html ***!
  \*****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<p>\n    Shape works!\n</p>>"

/***/ }),

/***/ "./src/app/svgcanvas/components/shape/shape.component.ts":
/*!***************************************************************!*\
  !*** ./src/app/svgcanvas/components/shape/shape.component.ts ***!
  \***************************************************************/
/*! exports provided: ShapeComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ShapeComponent", function() { return ShapeComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var ShapeComponent = /** @class */ (function () {
    function ShapeComponent() {
        this.isSelected = false;
        this.isEditing = false;
        this.selectionPoints = [];
        this.handlesColor = 'green';
        this.handlesRadius = 4;
        console.log('ShapeComponent constructor');
    }
    ShapeComponent.prototype.ngOnInit = function () {
        console.log('ShapeComponent ngOnInit');
    };
    ShapeComponent.prototype.startDrawing = function (beginPosition) {
        console.log('ShapeComponent: startDrawing at ', beginPosition);
    };
    ShapeComponent.prototype.endDrawing = function () {
        console.log('ShapeComponent: endDrawing()');
    };
    ShapeComponent.prototype.draw = function (currentPosition) {
        console.log('ShapeComponent: draw at ', currentPosition);
    };
    ShapeComponent.prototype.setPoint = function (point) {
        console.log('ShapeComponent: setPoint at ', point);
    };
    ShapeComponent.prototype.drag = function (draqPosition) {
        console.log(this.shape.shapeProperties.name + ' drag at ', draqPosition, ', offset : ', this.offset);
        if (this.offset === undefined) {
            this.offset = Object.assign({}, draqPosition);
            this.offset.x -= this.shape.originX;
            this.offset.y -= this.shape.originY;
        }
        this.shape.originX = (draqPosition.x - this.offset.x);
        this.shape.originY = (draqPosition.y - this.offset.y);
    };
    // drizo don't use mouseUp or move because it usually looses focus no movement
    // - it is handled
    ShapeComponent.prototype.onHandleMouseDown = function ($event, handle) {
        console.log('Handle mouse down on ' + handle);
        this.handleSelected = handle;
        $event.stopPropagation();
    };
    ShapeComponent.prototype.onHandleMouseMove = function (x, y) {
        return false;
    };
    ShapeComponent.prototype.deselectHandle = function () {
        if (this.handleSelected) {
            this.handleSelected = null;
            return true;
        }
        else {
            return false;
        }
    };
    ShapeComponent.prototype.isHandleSelected = function () {
        return this.handleSelected != null;
    };
    ShapeComponent.prototype.setPosition = function (x, y) {
        this.shape.originX = x;
        this.shape.originY = y;
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["ViewChild"])('shapeTemplate'),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", _angular_core__WEBPACK_IMPORTED_MODULE_1__["TemplateRef"])
    ], ShapeComponent.prototype, "shapeTemplate", void 0);
    ShapeComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-shape',
            template: __webpack_require__(/*! ./shape.component.html */ "./src/app/svgcanvas/components/shape/shape.component.html"),
            styles: [__webpack_require__(/*! ./shape.component.css */ "./src/app/svgcanvas/components/shape/shape.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], ShapeComponent);
    return ShapeComponent;
}());



/***/ }),

/***/ "./src/app/svgcanvas/components/square/square.component.css":
/*!******************************************************************!*\
  !*** ./src/app/svgcanvas/components/square/square.component.css ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3N2Z2NhbnZhcy9jb21wb25lbnRzL3NxdWFyZS9zcXVhcmUuY29tcG9uZW50LmNzcyJ9 */"

/***/ }),

/***/ "./src/app/svgcanvas/components/square/square.component.html":
/*!*******************************************************************!*\
  !*** ./src/app/svgcanvas/components/square/square.component.html ***!
  \*******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<ng-template #shapeTemplate>\n    <svg:rect attr.id=\"{{shape.shapeProperties.name}}\" class=\"draggable\" attr.x=\"{{ shape.originX }}\" attr.y=\"{{ shape.originY }}\"\n        attr.width=\"{{ shape.width }}\" attr.height=\"{{ shape.width }}\" [ngStyle]=\"setStyles()\">\n        <title>{{ shape.shapeProperties.name }}</title>\n    </svg:rect>\n</ng-template>"

/***/ }),

/***/ "./src/app/svgcanvas/components/square/square.component.ts":
/*!*****************************************************************!*\
  !*** ./src/app/svgcanvas/components/square/square.component.ts ***!
  \*****************************************************************/
/*! exports provided: SquareComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SquareComponent", function() { return SquareComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _shape_shape_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../shape/shape.component */ "./src/app/svgcanvas/components/shape/shape.component.ts");
/* harmony import */ var _model_shape__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../model/shape */ "./src/app/svgcanvas/model/shape.ts");
/* harmony import */ var _model_shape_types__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../model/shape-types */ "./src/app/svgcanvas/model/shape-types.ts");





var SquareComponent = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](SquareComponent, _super);
    function SquareComponent() {
        var _this = _super.call(this) || this;
        console.log('SquareComponent constructor');
        _this.shape = new _model_shape__WEBPACK_IMPORTED_MODULE_3__["Square"]();
        _this.shapeType = _model_shape_types__WEBPACK_IMPORTED_MODULE_4__["ShapeType"].Square;
        return _this;
    }
    SquareComponent.prototype.ngOnInit = function () {
        console.log('SquareComponent ngOnInit');
    };
    SquareComponent.prototype.setStyles = function () {
        var styles = {
            'stroke': this.shape.shapeProperties.strokeColor,
            'fill': this.shape.shapeProperties.fillColor,
            'stroke-width': this.shape.shapeProperties.strokeWidth
        };
        return styles;
    };
    SquareComponent.prototype.startDrawing = function (beginPosition) {
        console.log('SquareComponent startDrawing at ', beginPosition);
        if (this.shape instanceof _model_shape__WEBPACK_IMPORTED_MODULE_3__["Square"]) {
            this.shape.originX = beginPosition.x;
            this.shape.originY = beginPosition.y;
        }
    };
    SquareComponent.prototype.draw = function (currentPosition) {
        console.log('SquareComponent draw');
        if (this.shape instanceof _model_shape__WEBPACK_IMPORTED_MODULE_3__["Square"]) {
            this.shape.width = Math.abs(currentPosition.x - this.shape.originX);
        }
    };
    SquareComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-square',
            template: __webpack_require__(/*! ./square.component.html */ "./src/app/svgcanvas/components/square/square.component.html"),
            styles: [__webpack_require__(/*! ./square.component.css */ "./src/app/svgcanvas/components/square/square.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], SquareComponent);
    return SquareComponent;
}(_shape_shape_component__WEBPACK_IMPORTED_MODULE_2__["ShapeComponent"]));



/***/ }),

/***/ "./src/app/svgcanvas/components/svgcanvas/svgcanvas.component.css":
/*!************************************************************************!*\
  !*** ./src/app/svgcanvas/components/svgcanvas/svgcanvas.component.css ***!
  \************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3N2Z2NhbnZhcy9jb21wb25lbnRzL3N2Z2NhbnZhcy9zdmdjYW52YXMuY29tcG9uZW50LmNzcyJ9 */"

/***/ }),

/***/ "./src/app/svgcanvas/components/svgcanvas/svgcanvas.component.html":
/*!*************************************************************************!*\
  !*** ./src/app/svgcanvas/components/svgcanvas/svgcanvas.component.html ***!
  \*************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"\n     (mousedown)=\"onMouseDown($event)\" (mouseup)=\"onMouseUp($event)\" (mousemove)=\"onMouseMove($event)\"\n    [attr.width.px]=\"width\" [attr.height.px]=\"height\">\n  <ng-container *ngFor=\"let shape of getShapes(); trackBy: trackByShapeFn\">\n    <ng-template [appDynamicSVG]=\"shape\"></ng-template>\n  </ng-container>\n</svg>\n"

/***/ }),

/***/ "./src/app/svgcanvas/components/svgcanvas/svgcanvas.component.ts":
/*!***********************************************************************!*\
  !*** ./src/app/svgcanvas/components/svgcanvas/svgcanvas.component.ts ***!
  \***********************************************************************/
/*! exports provided: SVGCanvasState, SVGMousePositionEvent, SVGCanvasComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SVGCanvasState", function() { return SVGCanvasState; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SVGMousePositionEvent", function() { return SVGMousePositionEvent; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SVGCanvasComponent", function() { return SVGCanvasComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _model_shape__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../model/shape */ "./src/app/svgcanvas/model/shape.ts");
/* harmony import */ var _line_line_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../line/line.component */ "./src/app/svgcanvas/components/line/line.component.ts");
/* harmony import */ var _circle_circle_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../circle/circle.component */ "./src/app/svgcanvas/components/circle/circle.component.ts");
/* harmony import */ var _rectangle_rectangle_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../rectangle/rectangle.component */ "./src/app/svgcanvas/components/rectangle/rectangle.component.ts");
/* harmony import */ var _square_square_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../square/square.component */ "./src/app/svgcanvas/components/square/square.component.ts");
/* harmony import */ var _ellipse_ellipse_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../ellipse/ellipse.component */ "./src/app/svgcanvas/components/ellipse/ellipse.component.ts");
/* harmony import */ var _text_text_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../text/text.component */ "./src/app/svgcanvas/components/text/text.component.ts");
/* harmony import */ var _image_image_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../image/image.component */ "./src/app/svgcanvas/components/image/image.component.ts");
/* harmony import */ var _polyline_polyline_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../polyline/polyline.component */ "./src/app/svgcanvas/components/polyline/polyline.component.ts");
/* harmony import */ var _path_path_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ../path/path.component */ "./src/app/svgcanvas/components/path/path.component.ts");
/* harmony import */ var ngx_logger__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ngx-logger */ "./node_modules/ngx-logger/esm5/ngx-logger.js");
/* harmony import */ var _freehand_freehand_component__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ../freehand/freehand.component */ "./src/app/svgcanvas/components/freehand/freehand.component.ts");














var SVGCanvasState;
(function (SVGCanvasState) {
    SVGCanvasState[SVGCanvasState["eIdle"] = 0] = "eIdle";
    SVGCanvasState[SVGCanvasState["eSelecting"] = 1] = "eSelecting";
    SVGCanvasState[SVGCanvasState["eDrawing"] = 2] = "eDrawing";
    SVGCanvasState[SVGCanvasState["eEditing"] = 3] = "eEditing";
    SVGCanvasState[SVGCanvasState["eMoving"] = 4] = "eMoving";
})(SVGCanvasState || (SVGCanvasState = {}));
var SVGMousePositionEvent = /** @class */ (function () {
    function SVGMousePositionEvent() {
    }
    Object.defineProperty(SVGMousePositionEvent.prototype, "svgPosition", {
        get: function () {
            return this._svgPosition;
        },
        set: function (value) {
            this._svgPosition = value;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(SVGMousePositionEvent.prototype, "mouseEvent", {
        get: function () {
            return this._mouseEvent;
        },
        set: function (value) {
            this._mouseEvent = value;
        },
        enumerable: true,
        configurable: true
    });
    return SVGMousePositionEvent;
}());

var SVGCanvasComponent = /** @class */ (function () {
    function SVGCanvasComponent(viewContainerRef, componentFactoryResolver, logger) {
        this.viewContainerRef = viewContainerRef;
        this.componentFactoryResolver = componentFactoryResolver;
        this.logger = logger;
        this.currentPosition = new _model_shape__WEBPACK_IMPORTED_MODULE_2__["MousePosition"]();
        this.state = SVGCanvasState.eIdle;
        this.svgMouseEvent = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"](); // only emitted on eIdle state
        this.svgMouseEventContent = new SVGMousePositionEvent(); // avoid creating too many objects
        this.svgShapeChanged = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
        this.svgShapeSelected = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
        this.svgShapeDeselected = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
        this.svgShapeCreated = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
        this.defaultFillColor = 'gray';
        this.defaultStrokeWidth = 1;
        this.defaultStrokeColor = 'black';
        this.shapesComponents = new Array();
    }
    SVGCanvasComponent.prototype.ngOnInit = function () {
        this.svg = document.querySelector('svg');
    };
    SVGCanvasComponent.prototype.getShapes = function () {
        return this.shapesComponents;
    };
    SVGCanvasComponent.prototype.changeState = function (state) {
        this.state = state;
    };
    SVGCanvasComponent.prototype.changeMousePosition = function (event) {
        var CTM = this.svg.getScreenCTM();
        this.currentPosition.x = (event.clientX - CTM.e) / CTM.a;
        this.currentPosition.y = (event.clientY - CTM.f) / CTM.d;
        this.currentPosition.timestamp = event.timeStamp;
    };
    SVGCanvasComponent.prototype.buildComponent = function (shapeType) {
        this.logger.debug('buildComponent for :', shapeType);
        switch (shapeType) {
            case 'Line':
                return _line_line_component__WEBPACK_IMPORTED_MODULE_3__["LineComponent"];
            case 'Circle':
                return _circle_circle_component__WEBPACK_IMPORTED_MODULE_4__["CircleComponent"];
            case 'Rectangle':
                return _rectangle_rectangle_component__WEBPACK_IMPORTED_MODULE_5__["RectangleComponent"];
            case 'Square':
                return _square_square_component__WEBPACK_IMPORTED_MODULE_6__["SquareComponent"];
            case 'Ellipse':
                return _ellipse_ellipse_component__WEBPACK_IMPORTED_MODULE_7__["EllipseComponent"];
            case 'TextBox':
                return _text_text_component__WEBPACK_IMPORTED_MODULE_8__["TextComponent"];
            case 'Image':
                return _image_image_component__WEBPACK_IMPORTED_MODULE_9__["ImageComponent"];
            case 'Freehand':
                return _freehand_freehand_component__WEBPACK_IMPORTED_MODULE_13__["FreehandComponent"];
            case 'PolyLine':
                return _polyline_polyline_component__WEBPACK_IMPORTED_MODULE_10__["PolyLineComponent"];
            case 'Path':
                return _path_path_component__WEBPACK_IMPORTED_MODULE_11__["PathComponent"];
        }
        return null;
    };
    SVGCanvasComponent.prototype.selectShape = function (shapeType$) {
        this.logger.debug('SVGCanvas selecting shape: ' + shapeType$);
        this.shapeTypeToCreate = shapeType$;
        this.state = SVGCanvasState.eDrawing;
    };
    SVGCanvasComponent.prototype.onMouseDown = function (event) {
        this.logger.debug('SVGCanvas mouse down');
        this.changeMousePosition(event);
        if (this.selectedComponent) {
            this.selectedComponent.isSelected = false;
            this.selectedComponent.isEditing = false;
        }
        switch (this.state) {
            case SVGCanvasState.eIdle:
                this.svgMouseEventContent.svgPosition = this.currentPosition;
                this.svgMouseEventContent.mouseEvent = event;
                this.svgMouseEvent.emit(this.svgMouseEventContent);
                break;
            case SVGCanvasState.eDrawing:
                this.createShape();
                break;
            case SVGCanvasState.eSelecting:
            case SVGCanvasState.eEditing:
                this.deselect();
                this.selectedComponent = this.findShapeComponent(event.target.id);
                if (this.selectedComponent) {
                    this.selectedComponent.isSelected = true;
                    this.svgShapeSelected.emit(this.selectedComponent);
                    if (this.state === SVGCanvasState.eEditing) {
                        this.state = SVGCanvasState.eMoving;
                        this.selectedComponent.isEditing = true;
                    }
                }
                else {
                    this.svgShapeSelected.emit(null); // unselect
                    // TODO - create selection rectangle
                }
                break;
        }
    };
    SVGCanvasComponent.prototype.createComponent = function (shapeType) {
        var componentClass = this.buildComponent(shapeType);
        var injector = _angular_core__WEBPACK_IMPORTED_MODULE_1__["Injector"].create([], this.viewContainerRef.parentInjector);
        var factory = this.componentFactoryResolver.resolveComponentFactory(componentClass);
        var componentRef = factory.create(injector);
        var result = componentRef.instance;
        this.logger.debug('Created ' + this.selectedComponent + ' of class ' + componentClass);
        return result;
    };
    SVGCanvasComponent.prototype.createShape = function () {
        this.selectedComponent = this.createComponent(this.shapeTypeToCreate);
        this.shapesComponents.push(this.selectedComponent);
        this.selectedComponent.startDrawing(this.currentPosition);
    };
    SVGCanvasComponent.prototype.deselect = function () {
        if (this.selectedComponent) {
            this.selectedComponent.isSelected = false;
            this.svgShapeDeselected.emit(this.selectedComponent);
            this.selectedComponent = null;
        }
    };
    SVGCanvasComponent.prototype.onMouseMove = function (event) {
        this.changeMousePosition(event);
        switch (this.state) {
            case SVGCanvasState.eIdle:
                this.svgMouseEventContent.svgPosition = this.currentPosition;
                this.svgMouseEventContent.mouseEvent = event;
                this.svgMouseEvent.emit(this.svgMouseEventContent);
                break;
            case SVGCanvasState.eDrawing:
                if (this.selectedComponent) {
                    this.selectedComponent.draw(this.currentPosition);
                }
                break;
            case SVGCanvasState.eEditing:
                if (this.selectedComponent && this.selectedComponent.isHandleSelected()) {
                    this.selectedComponent.onHandleMouseMove(this.currentPosition.x, this.currentPosition.y);
                }
                break;
            case SVGCanvasState.eMoving:
                if (this.selectedComponent) {
                    this.selectedComponent.drag(this.currentPosition);
                }
                break;
        }
    };
    SVGCanvasComponent.prototype.onMouseUp = function ($event) {
        this.logger.debug('SVGCanvas mouse up');
        this.changeMousePosition($event);
        switch (this.state) {
            case SVGCanvasState.eIdle:
                this.svgMouseEventContent.svgPosition = this.currentPosition;
                this.svgMouseEventContent.mouseEvent = $event;
                this.svgMouseEvent.emit(this.svgMouseEventContent);
                $event.stopPropagation();
                break;
            case SVGCanvasState.eDrawing:
                this.svgShapeCreated.emit(this.selectedComponent);
                this.selectedComponent = null;
                $event.stopPropagation();
                break;
            case SVGCanvasState.eMoving:
                this.state = SVGCanvasState.eEditing;
                $event.stopPropagation();
                // this.deselect();
                break;
            case SVGCanvasState.eEditing:
                if (this.selectedComponent && this.selectedComponent.isHandleSelected()) {
                    this.selectedComponent.deselectHandle();
                    this.svgShapeChanged.emit(this.selectedComponent);
                    $event.stopPropagation();
                }
                break;
        }
    };
    SVGCanvasComponent.prototype.clear = function () {
        this.shapesComponents = new Array();
    };
    SVGCanvasComponent.prototype.findShapeComponent = function (name) {
        console.log('find name : ', name);
        /*for (let i = 0; i < this.shapesComponents.length; i++) {
          console.log('FIND JSON : ', JSON.stringify(this.shapesComponents[i].shape));
        }*/
        return this.shapesComponents.find(function (x) { return x.shape.shapeProperties.name === name; });
    };
    SVGCanvasComponent.prototype.drawRectangle = function (x, y, width, height, label) {
        var rect = this.createComponent('Rectangle');
        if (rect instanceof _rectangle_rectangle_component__WEBPACK_IMPORTED_MODULE_5__["RectangleComponent"]) {
            rect.setPosition(x, y);
            rect.setDimensions(width, height);
            rect.label = label;
        }
        this.assignDefaultProperties(rect);
        this.shapesComponents.push(rect);
        return rect;
    };
    SVGCanvasComponent.prototype.drawFreeHand = function (positions) {
        var fh = this.createComponent('Freehand');
        if (fh instanceof _freehand_freehand_component__WEBPACK_IMPORTED_MODULE_13__["FreehandComponent"]) {
            var first_1 = true;
            positions.forEach(function (position) {
                if (first_1) {
                    fh.startDrawing(position);
                    first_1 = false;
                }
                else {
                    fh.draw(position);
                }
            });
            this.assignDefaultProperties(fh);
            this.shapesComponents.push(fh);
            return fh;
        }
        else {
            throw new Error('Should be a freehand component');
        }
    };
    SVGCanvasComponent.prototype.drawLine = function (fromX, fromY, toX, toY) {
        var line = this.createComponent('Line');
        if (line instanceof _line_line_component__WEBPACK_IMPORTED_MODULE_3__["LineComponent"]) {
            line.setPosition(fromX, fromY);
            line.setEndPosition(toX, toY);
        }
        this.assignDefaultProperties(line);
        this.shapesComponents.push(line);
        return line;
    };
    SVGCanvasComponent.prototype.assignDefaultProperties = function (component) {
        component.shape.shapeProperties.fillColor = this.defaultFillColor;
        component.shape.shapeProperties.strokeColor = this.defaultStrokeColor;
        component.shape.shapeProperties.strokeWidth = this.defaultStrokeWidth;
    };
    SVGCanvasComponent.prototype.remove = function (shapeComponent) {
        var index = this.shapesComponents.indexOf(shapeComponent);
        if (index !== -1) {
            this.shapesComponents.splice(index, 1);
        }
    };
    SVGCanvasComponent.prototype.selectShapeProperties = function (fillColor, strokeWidth, strokeColor) {
        this.defaultFillColor = fillColor;
        this.defaultStrokeWidth = strokeWidth;
        this.defaultStrokeColor = strokeColor;
    };
    SVGCanvasComponent.prototype.trackByShapeFn = function (index, item) {
        return index; // TODO ¿mejor un ID?
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Number)
    ], SVGCanvasComponent.prototype, "height", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Number)
    ], SVGCanvasComponent.prototype, "width", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["ContentChild"])(_angular_core__WEBPACK_IMPORTED_MODULE_1__["TemplateRef"]),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", _angular_core__WEBPACK_IMPORTED_MODULE_1__["TemplateRef"])
    ], SVGCanvasComponent.prototype, "shapeTemplate", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Output"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Object)
    ], SVGCanvasComponent.prototype, "svgMouseEvent", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Output"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Object)
    ], SVGCanvasComponent.prototype, "svgShapeChanged", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Output"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Object)
    ], SVGCanvasComponent.prototype, "svgShapeSelected", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Output"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Object)
    ], SVGCanvasComponent.prototype, "svgShapeDeselected", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Output"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Object)
    ], SVGCanvasComponent.prototype, "svgShapeCreated", void 0);
    SVGCanvasComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-svgcanvas',
            template: __webpack_require__(/*! ./svgcanvas.component.html */ "./src/app/svgcanvas/components/svgcanvas/svgcanvas.component.html"),
            styles: [__webpack_require__(/*! ./svgcanvas.component.css */ "./src/app/svgcanvas/components/svgcanvas/svgcanvas.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_core__WEBPACK_IMPORTED_MODULE_1__["ViewContainerRef"],
            _angular_core__WEBPACK_IMPORTED_MODULE_1__["ComponentFactoryResolver"],
            ngx_logger__WEBPACK_IMPORTED_MODULE_12__["NGXLogger"]])
    ], SVGCanvasComponent);
    return SVGCanvasComponent;
}());



/***/ }),

/***/ "./src/app/svgcanvas/components/text/text.component.css":
/*!**************************************************************!*\
  !*** ./src/app/svgcanvas/components/text/text.component.css ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3N2Z2NhbnZhcy9jb21wb25lbnRzL3RleHQvdGV4dC5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/svgcanvas/components/text/text.component.html":
/*!***************************************************************!*\
  !*** ./src/app/svgcanvas/components/text/text.component.html ***!
  \***************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<ng-template #shapeTemplate>\n    <svg:text attr.id=\"{{shape.shapeProperties.name}}\" class=\"draggable\" attr.x=\"{{ shape.originX }}\" attr.y=\"{{ shape.originY }}\"\n        [ngStyle]=\"setStyles()\">{{ shape.value }}\n        <title>{{ shape.shapeProperties.name }}</title>\n    </svg:text>\n</ng-template>"

/***/ }),

/***/ "./src/app/svgcanvas/components/text/text.component.ts":
/*!*************************************************************!*\
  !*** ./src/app/svgcanvas/components/text/text.component.ts ***!
  \*************************************************************/
/*! exports provided: TextComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TextComponent", function() { return TextComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _shape_shape_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../shape/shape.component */ "./src/app/svgcanvas/components/shape/shape.component.ts");
/* harmony import */ var _model_shape__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../model/shape */ "./src/app/svgcanvas/model/shape.ts");
/* harmony import */ var _model_shape_types__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../model/shape-types */ "./src/app/svgcanvas/model/shape-types.ts");





var TextComponent = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](TextComponent, _super);
    function TextComponent() {
        var _this = _super.call(this) || this;
        console.log('TextComponent constructor');
        _this.shape = new _model_shape__WEBPACK_IMPORTED_MODULE_3__["TextBox"]();
        _this.shapeType = _model_shape_types__WEBPACK_IMPORTED_MODULE_4__["ShapeType"].TextBox;
        return _this;
    }
    TextComponent.prototype.ngOnInit = function () {
        console.log('TextComponent ngOnInit');
    };
    TextComponent.prototype.setStyles = function () {
        var styles = {
            'fill': this.shape.shapeProperties.strokeColor
        };
        return styles;
    };
    TextComponent.prototype.startDrawing = function (beginPosition) {
        if (this.shape instanceof _model_shape__WEBPACK_IMPORTED_MODULE_3__["TextBox"]) {
            this.shape.originX = beginPosition.x;
            this.shape.originY = beginPosition.y;
        }
        console.log('TextComponent startDrawing at ', beginPosition, ', ', this.shape);
    };
    TextComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-text',
            template: __webpack_require__(/*! ./text.component.html */ "./src/app/svgcanvas/components/text/text.component.html"),
            styles: [__webpack_require__(/*! ./text.component.css */ "./src/app/svgcanvas/components/text/text.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], TextComponent);
    return TextComponent;
}(_shape_shape_component__WEBPACK_IMPORTED_MODULE_2__["ShapeComponent"]));



/***/ }),

/***/ "./src/app/svgcanvas/control/checkbox/checkbox.component.css":
/*!*******************************************************************!*\
  !*** ./src/app/svgcanvas/control/checkbox/checkbox.component.css ***!
  \*******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3N2Z2NhbnZhcy9jb250cm9sL2NoZWNrYm94L2NoZWNrYm94LmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/svgcanvas/control/checkbox/checkbox.component.html":
/*!********************************************************************!*\
  !*** ./src/app/svgcanvas/control/checkbox/checkbox.component.html ***!
  \********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"form-check\" [formGroup]=\"group\">\n    <input formControlName=\"{{field.name}}\" type=\"checkbox\" class=\"form-check-input mr-2\" />\n    <label>{{field.label}}</label>\n</div>"

/***/ }),

/***/ "./src/app/svgcanvas/control/checkbox/checkbox.component.ts":
/*!******************************************************************!*\
  !*** ./src/app/svgcanvas/control/checkbox/checkbox.component.ts ***!
  \******************************************************************/
/*! exports provided: CheckboxComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CheckboxComponent", function() { return CheckboxComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var CheckboxComponent = /** @class */ (function () {
    function CheckboxComponent() {
    }
    CheckboxComponent.prototype.ngOnInit = function () {
    };
    CheckboxComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-checkbox',
            template: __webpack_require__(/*! ./checkbox.component.html */ "./src/app/svgcanvas/control/checkbox/checkbox.component.html"),
            styles: [__webpack_require__(/*! ./checkbox.component.css */ "./src/app/svgcanvas/control/checkbox/checkbox.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], CheckboxComponent);
    return CheckboxComponent;
}());



/***/ }),

/***/ "./src/app/svgcanvas/control/color-picker/color-picker.component.css":
/*!***************************************************************************!*\
  !*** ./src/app/svgcanvas/control/color-picker/color-picker.component.css ***!
  \***************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3N2Z2NhbnZhcy9jb250cm9sL2NvbG9yLXBpY2tlci9jb2xvci1waWNrZXIuY29tcG9uZW50LmNzcyJ9 */"

/***/ }),

/***/ "./src/app/svgcanvas/control/color-picker/color-picker.component.html":
/*!****************************************************************************!*\
  !*** ./src/app/svgcanvas/control/color-picker/color-picker.component.html ***!
  \****************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div [formGroup]=\"group\">\n    <input class=\"form-control color-text\" formControlName=\"{{field.name}}\" value=\"{{field.value}}\" [(colorPicker)]=\"field.value\"\n        [(ngModel)]=\"field.value\" [cpOutputFormat]=\"'hex'\" [cpOKButton]=\"true\" [cpCancelButton]=\"true\"\n        [style.background]=\"field.value\">\n</div>"

/***/ }),

/***/ "./src/app/svgcanvas/control/color-picker/color-picker.component.ts":
/*!**************************************************************************!*\
  !*** ./src/app/svgcanvas/control/color-picker/color-picker.component.ts ***!
  \**************************************************************************/
/*! exports provided: ColorPickerComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ColorPickerComponent", function() { return ColorPickerComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var ColorPickerComponent = /** @class */ (function () {
    function ColorPickerComponent() {
    }
    ColorPickerComponent.prototype.ngOnInit = function () {
    };
    ColorPickerComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-color-picker',
            template: __webpack_require__(/*! ./color-picker.component.html */ "./src/app/svgcanvas/control/color-picker/color-picker.component.html"),
            styles: [__webpack_require__(/*! ./color-picker.component.css */ "./src/app/svgcanvas/control/color-picker/color-picker.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], ColorPickerComponent);
    return ColorPickerComponent;
}());



/***/ }),

/***/ "./src/app/svgcanvas/control/input/input.component.css":
/*!*************************************************************!*\
  !*** ./src/app/svgcanvas/control/input/input.component.css ***!
  \*************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3N2Z2NhbnZhcy9jb250cm9sL2lucHV0L2lucHV0LmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/svgcanvas/control/input/input.component.html":
/*!**************************************************************!*\
  !*** ./src/app/svgcanvas/control/input/input.component.html ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"form-group\" [formGroup]=\"group\">\n    <label>{{field.label}}</label>\n    <input formControlName=\"{{field.name}}\" type=\"{{field.inputType}}\" class=\"form-control\" />\n    <ng-container *ngFor=\"let validation of field.validations;\">\n        <div class=\"text-danger mt-2\" *ngIf=\"group.get(field.name).invalid && (group.get(field.name).touched || group.get(field.name).dirty)\">{{validation.message}}</div>\n    </ng-container>\n</div>"

/***/ }),

/***/ "./src/app/svgcanvas/control/input/input.component.ts":
/*!************************************************************!*\
  !*** ./src/app/svgcanvas/control/input/input.component.ts ***!
  \************************************************************/
/*! exports provided: InputComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "InputComponent", function() { return InputComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var InputComponent = /** @class */ (function () {
    function InputComponent() {
    }
    InputComponent.prototype.ngOnInit = function () {
    };
    InputComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-input',
            template: __webpack_require__(/*! ./input.component.html */ "./src/app/svgcanvas/control/input/input.component.html"),
            styles: [__webpack_require__(/*! ./input.component.css */ "./src/app/svgcanvas/control/input/input.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], InputComponent);
    return InputComponent;
}());



/***/ }),

/***/ "./src/app/svgcanvas/control/radiobutton/radiobutton.component.css":
/*!*************************************************************************!*\
  !*** ./src/app/svgcanvas/control/radiobutton/radiobutton.component.css ***!
  \*************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3N2Z2NhbnZhcy9jb250cm9sL3JhZGlvYnV0dG9uL3JhZGlvYnV0dG9uLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/svgcanvas/control/radiobutton/radiobutton.component.html":
/*!**************************************************************************!*\
  !*** ./src/app/svgcanvas/control/radiobutton/radiobutton.component.html ***!
  \**************************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"form-group\" [formGroup]=\"group\">\n    <ng-container *ngFor=\"let item of field.options\">\n        <label class=\"radio-inline mr-2\"><input type=\"radio\" [formControlName]=\"field.name\" [value]=\"item\"> {{item}}</label>\n    </ng-container>\n</div>"

/***/ }),

/***/ "./src/app/svgcanvas/control/radiobutton/radiobutton.component.ts":
/*!************************************************************************!*\
  !*** ./src/app/svgcanvas/control/radiobutton/radiobutton.component.ts ***!
  \************************************************************************/
/*! exports provided: RadiobuttonComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RadiobuttonComponent", function() { return RadiobuttonComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var RadiobuttonComponent = /** @class */ (function () {
    function RadiobuttonComponent() {
    }
    RadiobuttonComponent.prototype.ngOnInit = function () {
    };
    RadiobuttonComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-radiobutton',
            template: __webpack_require__(/*! ./radiobutton.component.html */ "./src/app/svgcanvas/control/radiobutton/radiobutton.component.html"),
            styles: [__webpack_require__(/*! ./radiobutton.component.css */ "./src/app/svgcanvas/control/radiobutton/radiobutton.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], RadiobuttonComponent);
    return RadiobuttonComponent;
}());



/***/ }),

/***/ "./src/app/svgcanvas/control/select/select.component.css":
/*!***************************************************************!*\
  !*** ./src/app/svgcanvas/control/select/select.component.css ***!
  \***************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3N2Z2NhbnZhcy9jb250cm9sL3NlbGVjdC9zZWxlY3QuY29tcG9uZW50LmNzcyJ9 */"

/***/ }),

/***/ "./src/app/svgcanvas/control/select/select.component.html":
/*!****************************************************************!*\
  !*** ./src/app/svgcanvas/control/select/select.component.html ***!
  \****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div [formGroup]=\"group\">\n    <label>{{field.label}}</label>\n    <select class=\"form-control\" formControlName=\"{{field.name}}\">\n        <option [value]=\"item\" *ngFor=\"let item of field.options\"> {{item}}</option>\n    </select>\n</div>"

/***/ }),

/***/ "./src/app/svgcanvas/control/select/select.component.ts":
/*!**************************************************************!*\
  !*** ./src/app/svgcanvas/control/select/select.component.ts ***!
  \**************************************************************/
/*! exports provided: SelectComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SelectComponent", function() { return SelectComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var SelectComponent = /** @class */ (function () {
    function SelectComponent() {
    }
    SelectComponent.prototype.ngOnInit = function () {
    };
    SelectComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-select',
            template: __webpack_require__(/*! ./select.component.html */ "./src/app/svgcanvas/control/select/select.component.html"),
            styles: [__webpack_require__(/*! ./select.component.css */ "./src/app/svgcanvas/control/select/select.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], SelectComponent);
    return SelectComponent;
}());



/***/ }),

/***/ "./src/app/svgcanvas/directives/dynamic-field.directive.ts":
/*!*****************************************************************!*\
  !*** ./src/app/svgcanvas/directives/dynamic-field.directive.ts ***!
  \*****************************************************************/
/*! exports provided: DynamicFieldDirective */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "DynamicFieldDirective", function() { return DynamicFieldDirective; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _control_input_input_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../control/input/input.component */ "./src/app/svgcanvas/control/input/input.component.ts");
/* harmony import */ var _control_select_select_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../control/select/select.component */ "./src/app/svgcanvas/control/select/select.component.ts");
/* harmony import */ var _control_radiobutton_radiobutton_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../control/radiobutton/radiobutton.component */ "./src/app/svgcanvas/control/radiobutton/radiobutton.component.ts");
/* harmony import */ var _control_checkbox_checkbox_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../control/checkbox/checkbox.component */ "./src/app/svgcanvas/control/checkbox/checkbox.component.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");







var controlMapper = {
    input: _control_input_input_component__WEBPACK_IMPORTED_MODULE_2__["InputComponent"],
    select: _control_select_select_component__WEBPACK_IMPORTED_MODULE_3__["SelectComponent"],
    radiobutton: _control_radiobutton_radiobutton_component__WEBPACK_IMPORTED_MODULE_4__["RadiobuttonComponent"],
    checkbox: _control_checkbox_checkbox_component__WEBPACK_IMPORTED_MODULE_5__["CheckboxComponent"]
};
var DynamicFieldDirective = /** @class */ (function () {
    function DynamicFieldDirective(resolver, viewContainer) {
        this.resolver = resolver;
        this.viewContainer = viewContainer;
    }
    DynamicFieldDirective.prototype.ngOnInit = function () {
        var factory = this.resolver.resolveComponentFactory(controlMapper[this.field.type]);
        this.componentRef = this.viewContainer.createComponent(factory);
        this.componentRef.instance.field = this.field;
        this.componentRef.instance.group = this.group;
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Object)
    ], DynamicFieldDirective.prototype, "field", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", _angular_forms__WEBPACK_IMPORTED_MODULE_6__["FormGroup"])
    ], DynamicFieldDirective.prototype, "group", void 0);
    DynamicFieldDirective = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Directive"])({
            selector: '[dynamic-field]'
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_core__WEBPACK_IMPORTED_MODULE_1__["ComponentFactoryResolver"], _angular_core__WEBPACK_IMPORTED_MODULE_1__["ViewContainerRef"]])
    ], DynamicFieldDirective);
    return DynamicFieldDirective;
}());



/***/ }),

/***/ "./src/app/svgcanvas/directives/dynamic-svg.directive.ts":
/*!***************************************************************!*\
  !*** ./src/app/svgcanvas/directives/dynamic-svg.directive.ts ***!
  \***************************************************************/
/*! exports provided: DynamicSvgDirective */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "DynamicSvgDirective", function() { return DynamicSvgDirective; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _components_shape_shape_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../components/shape/shape.component */ "./src/app/svgcanvas/components/shape/shape.component.ts");



var DynamicSvgDirective = /** @class */ (function () {
    function DynamicSvgDirective(viewContainerRef) {
        this.viewContainerRef = viewContainerRef;
    }
    DynamicSvgDirective.prototype.ngOnInit = function () {
        /* console.log('DynamicSvgDirective ngOnInit() - component : ',
          this.appDynamicSVG + ' and viewContainerRef=' + this.viewContainerRef
        + ' and shapeComponent=' + this.appDynamicSVG); */
        // const shapeComponent: ShapeComponent = this.shapeService.getShapeComponent();
        // this.viewContainerRef.createEmbeddedView(shapeComponent.shapeTemplate);
        if (this.viewContainerRef) {
            if (this.appDynamicSVG) {
                if (this.appDynamicSVG.shapeTemplate) {
                    this.viewContainerRef.createEmbeddedView(this.appDynamicSVG.shapeTemplate);
                }
                else {
                    throw new Error('this.appDynamicSVG.shapeTemplate is null in DynamicSvgDirective (is there a ShapeComponent not created by the ShapeCanvas?');
                }
            }
            else {
                throw new Error('this.appDynamicSVG is null in DynamicSvgDirective');
            }
        }
        else {
            throw new Error('this.viewContainerRef is null in DynamicSvgDirective');
        }
    };
    DynamicSvgDirective.prototype.ngOnDestroy = function () {
        console.log('DynamicSvgDirective ngOnDestroy()');
        this.viewContainerRef.clear();
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", _components_shape_shape_component__WEBPACK_IMPORTED_MODULE_2__["ShapeComponent"])
    ], DynamicSvgDirective.prototype, "appDynamicSVG", void 0);
    DynamicSvgDirective = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Directive"])({
            selector: '[appDynamicSVG]'
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_core__WEBPACK_IMPORTED_MODULE_1__["ViewContainerRef"]])
    ], DynamicSvgDirective);
    return DynamicSvgDirective;
}());



/***/ }),

/***/ "./src/app/svgcanvas/model/shape-types.ts":
/*!************************************************!*\
  !*** ./src/app/svgcanvas/model/shape-types.ts ***!
  \************************************************/
/*! exports provided: ShapeType, ToolType, State */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ShapeType", function() { return ShapeType; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ToolType", function() { return ToolType; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "State", function() { return State; });
var ShapeType;
(function (ShapeType) {
    ShapeType[ShapeType["NoShape"] = 0] = "NoShape";
    ShapeType[ShapeType["Line"] = 1] = "Line";
    ShapeType[ShapeType["Circle"] = 2] = "Circle";
    ShapeType[ShapeType["Ellipse"] = 3] = "Ellipse";
    ShapeType[ShapeType["Rectangle"] = 4] = "Rectangle";
    ShapeType[ShapeType["TextBox"] = 5] = "TextBox";
    ShapeType[ShapeType["Path"] = 6] = "Path";
    ShapeType[ShapeType["PolyLine"] = 7] = "PolyLine";
    ShapeType[ShapeType["Image"] = 8] = "Image";
    ShapeType[ShapeType["Square"] = 9] = "Square";
})(ShapeType || (ShapeType = {}));
var ToolType;
(function (ToolType) {
    ToolType[ToolType["Pointer"] = 0] = "Pointer";
    ToolType[ToolType["Move"] = 1] = "Move";
    ToolType[ToolType["Rotate"] = 2] = "Rotate";
    ToolType[ToolType["SelectArea"] = 3] = "SelectArea";
    ToolType[ToolType["Flipvertical"] = 4] = "Flipvertical";
    ToolType[ToolType["Fliphorizontal"] = 5] = "Fliphorizontal";
})(ToolType || (ToolType = {}));
var State;
(function (State) {
    State[State["None"] = 0] = "None";
    State[State["Moving"] = 1] = "Moving";
    State[State["Finished"] = 2] = "Finished";
})(State || (State = {}));


/***/ }),

/***/ "./src/app/svgcanvas/model/shape.ts":
/*!******************************************!*\
  !*** ./src/app/svgcanvas/model/shape.ts ***!
  \******************************************/
/*! exports provided: MousePosition, ShapeProperties, Shape, Line, Circle, Rectangle, Square, Ellipse, TextBox, ImageBox, PolyLine, Path */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MousePosition", function() { return MousePosition; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ShapeProperties", function() { return ShapeProperties; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Shape", function() { return Shape; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Line", function() { return Line; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Circle", function() { return Circle; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Rectangle", function() { return Rectangle; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Square", function() { return Square; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Ellipse", function() { return Ellipse; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TextBox", function() { return TextBox; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ImageBox", function() { return ImageBox; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PolyLine", function() { return PolyLine; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Path", function() { return Path; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _shape_types__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./shape-types */ "./src/app/svgcanvas/model/shape-types.ts");


/*
 * The MousePosition object
 */
var MousePosition = /** @class */ (function () {
    function MousePosition() {
        this.x = 0;
        this.y = 0;
        this.timestamp = 0;
    }
    return MousePosition;
}());

/*
 * The ShapeProperties object
 */
var ShapeProperties = /** @class */ (function () {
    function ShapeProperties() {
        this.fill = true;
        this.fillColor = 'transparent';
        this.stroke = true;
        this.strokeColor = 'red';
        this.strokeWidth = 3;
        this.name = 'unknown';
        this.visible = true;
    }
    return ShapeProperties;
}());

/*
 * The Shape object
 */
var Shape = /** @class */ (function () {
    function Shape(name) {
        this.shapeProperties = new ShapeProperties();
        this.originX = this.originY = 0;
        this.shapeProperties.name = name;
        console.log('Shape constructor name : ', this.shapeProperties);
    }
    return Shape;
}());

/*
 * The Line class.
 */
var Line = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](Line, _super);
    function Line() {
        var _this = _super.call(this, 'line-' + Line.id++) || this;
        _this.x2 = _this.y2 = 0;
        console.log('Line constructor ', _this);
        return _this;
    }
    Line.id = 0;
    return Line;
}(Shape));

/*
 * The Circle class.
 */
var Circle = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](Circle, _super);
    function Circle() {
        var _this = _super.call(this, 'circle-' + Circle.id++) || this;
        _this.r = 0;
        console.log('Circle constructor ', _this);
        return _this;
    }
    Circle.id = 0;
    return Circle;
}(Shape));

/*
 * The Rectangle class.
 */
var Rectangle = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](Rectangle, _super);
    function Rectangle() {
        var _this = _super.call(this, 'rectangle-' + Rectangle.id++) || this;
        _this.width = _this.height = 0;
        console.log('Rectangle constructor ', _this);
        return _this;
    }
    Rectangle.id = 0;
    return Rectangle;
}(Shape));

/*
 * The Square class.
 */
var Square = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](Square, _super);
    function Square() {
        var _this = _super.call(this, 'square-' + Square.id++) || this;
        _this.width = 0;
        console.log('Rectangle constructor ', _this);
        return _this;
    }
    Square.id = 0;
    return Square;
}(Shape));

/*
 * The Ellipse class.
 */
var Ellipse = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](Ellipse, _super);
    function Ellipse() {
        var _this = _super.call(this, 'ellipse-' + Ellipse.id++) || this;
        _this.rx = _this.ry = 0;
        console.log('Ellipse constructor ', _this);
        return _this;
    }
    Ellipse.id = 0;
    return Ellipse;
}(Shape));

/*
 * The TextBox class.
 */
var TextBox = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](TextBox, _super);
    function TextBox() {
        var _this = _super.call(this, 'text-' + TextBox.id++) || this;
        _this.value = 'Some text';
        console.log('Text constructor ', _this);
        return _this;
    }
    TextBox.id = 0;
    return TextBox;
}(Shape));

/*
 * The Image class.
 */
var ImageBox = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](ImageBox, _super);
    function ImageBox() {
        var _this = _super.call(this, 'image-' + ImageBox.id++) || this;
        _this.width = _this.height = 0;
        _this.url = 'assets/pictures/tiger.png';
        console.log('Image constructor ', _this);
        return _this;
    }
    ImageBox.id = 0;
    return ImageBox;
}(Shape));

/*
 * The PolyLine class.
 */
var PolyLine = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](PolyLine, _super);
    function PolyLine() {
        var _this = _super.call(this, 'polyline-' + PolyLine.id++) || this;
        _this.points = [];
        console.log('PolyLine constructor ', _this);
        return _this;
    }
    PolyLine.id = 0;
    return PolyLine;
}(Shape));

/*
 * The Path class.
 */
var Path = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](Path, _super);
    function Path() {
        var _this = _super.call(this, 'path-' + Path.id++) || this;
        _this.points = [];
        _this.state = _shape_types__WEBPACK_IMPORTED_MODULE_1__["State"].None;
        console.log('Path constructor ', _this);
        return _this;
    }
    Path.id = 0;
    return Path;
}(Shape));



/***/ }),

/***/ "./src/app/svgcanvas/svgdrawing-tool.module.ts":
/*!*****************************************************!*\
  !*** ./src/app/svgcanvas/svgdrawing-tool.module.ts ***!
  \*****************************************************/
/*! exports provided: SVGDrawingToolModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SVGDrawingToolModule", function() { return SVGDrawingToolModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _components_rectangle_rectangle_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./components/rectangle/rectangle.component */ "./src/app/svgcanvas/components/rectangle/rectangle.component.ts");
/* harmony import */ var _components_line_line_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./components/line/line.component */ "./src/app/svgcanvas/components/line/line.component.ts");
/* harmony import */ var _components_path_path_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./components/path/path.component */ "./src/app/svgcanvas/components/path/path.component.ts");
/* harmony import */ var _directives_dynamic_svg_directive__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./directives/dynamic-svg.directive */ "./src/app/svgcanvas/directives/dynamic-svg.directive.ts");
/* harmony import */ var _svgdrawing_svgdrawing_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../svgdrawing/svgdrawing.component */ "./src/app/svgdrawing/svgdrawing.component.ts");
/* harmony import */ var _components_circle_circle_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./components/circle/circle.component */ "./src/app/svgcanvas/components/circle/circle.component.ts");
/* harmony import */ var _components_shape_shape_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./components/shape/shape.component */ "./src/app/svgcanvas/components/shape/shape.component.ts");
/* harmony import */ var _components_square_square_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./components/square/square.component */ "./src/app/svgcanvas/components/square/square.component.ts");
/* harmony import */ var _components_ellipse_ellipse_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./components/ellipse/ellipse.component */ "./src/app/svgcanvas/components/ellipse/ellipse.component.ts");
/* harmony import */ var _components_text_text_component__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./components/text/text.component */ "./src/app/svgcanvas/components/text/text.component.ts");
/* harmony import */ var _components_group_group_component__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./components/group/group.component */ "./src/app/svgcanvas/components/group/group.component.ts");
/* harmony import */ var _components_image_image_component__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./components/image/image.component */ "./src/app/svgcanvas/components/image/image.component.ts");
/* harmony import */ var _components_polyline_polyline_component__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ./components/polyline/polyline.component */ "./src/app/svgcanvas/components/polyline/polyline.component.ts");
/* harmony import */ var _directives_dynamic_field_directive__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ./directives/dynamic-field.directive */ "./src/app/svgcanvas/directives/dynamic-field.directive.ts");
/* harmony import */ var _components_dynamic_form_dynamic_form_component__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ./components/dynamic-form/dynamic-form.component */ "./src/app/svgcanvas/components/dynamic-form/dynamic-form.component.ts");
/* harmony import */ var _control_checkbox_checkbox_component__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! ./control/checkbox/checkbox.component */ "./src/app/svgcanvas/control/checkbox/checkbox.component.ts");
/* harmony import */ var _control_input_input_component__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! ./control/input/input.component */ "./src/app/svgcanvas/control/input/input.component.ts");
/* harmony import */ var _control_radiobutton_radiobutton_component__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! ./control/radiobutton/radiobutton.component */ "./src/app/svgcanvas/control/radiobutton/radiobutton.component.ts");
/* harmony import */ var _control_select_select_component__WEBPACK_IMPORTED_MODULE_21__ = __webpack_require__(/*! ./control/select/select.component */ "./src/app/svgcanvas/control/select/select.component.ts");
/* harmony import */ var _control_color_picker_color_picker_component__WEBPACK_IMPORTED_MODULE_22__ = __webpack_require__(/*! ./control/color-picker/color-picker.component */ "./src/app/svgcanvas/control/color-picker/color-picker.component.ts");
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_23__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_24__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var ngx_color_picker__WEBPACK_IMPORTED_MODULE_25__ = __webpack_require__(/*! ngx-color-picker */ "./node_modules/ngx-color-picker/dist/ngx-color-picker.es5.js");
/* harmony import */ var _components_svgcanvas_svgcanvas_component__WEBPACK_IMPORTED_MODULE_26__ = __webpack_require__(/*! ./components/svgcanvas/svgcanvas.component */ "./src/app/svgcanvas/components/svgcanvas/svgcanvas.component.ts");
/* harmony import */ var _components_freehand_freehand_component__WEBPACK_IMPORTED_MODULE_27__ = __webpack_require__(/*! ./components/freehand/freehand.component */ "./src/app/svgcanvas/components/freehand/freehand.component.ts");




























/**
 * Adapted from: https://github.com/johandb/svg-drawing-tool
 */
var SVGDrawingToolModule = /** @class */ (function () {
    function SVGDrawingToolModule() {
    }
    SVGDrawingToolModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_2__["CommonModule"],
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_23__["BrowserModule"],
                ngx_color_picker__WEBPACK_IMPORTED_MODULE_25__["ColorPickerModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_24__["FormsModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_24__["ReactiveFormsModule"]
            ],
            exports: [
                _components_svgcanvas_svgcanvas_component__WEBPACK_IMPORTED_MODULE_26__["SVGCanvasComponent"]
            ],
            declarations: [
                _svgdrawing_svgdrawing_component__WEBPACK_IMPORTED_MODULE_7__["SVGDrawingComponent"],
                _components_line_line_component__WEBPACK_IMPORTED_MODULE_4__["LineComponent"],
                _components_circle_circle_component__WEBPACK_IMPORTED_MODULE_8__["CircleComponent"],
                _components_rectangle_rectangle_component__WEBPACK_IMPORTED_MODULE_3__["RectangleComponent"],
                _directives_dynamic_svg_directive__WEBPACK_IMPORTED_MODULE_6__["DynamicSvgDirective"],
                _components_shape_shape_component__WEBPACK_IMPORTED_MODULE_9__["ShapeComponent"],
                _components_square_square_component__WEBPACK_IMPORTED_MODULE_10__["SquareComponent"],
                _components_ellipse_ellipse_component__WEBPACK_IMPORTED_MODULE_11__["EllipseComponent"],
                _components_text_text_component__WEBPACK_IMPORTED_MODULE_12__["TextComponent"],
                _components_group_group_component__WEBPACK_IMPORTED_MODULE_13__["GroupComponent"],
                _components_image_image_component__WEBPACK_IMPORTED_MODULE_14__["ImageComponent"],
                _components_polyline_polyline_component__WEBPACK_IMPORTED_MODULE_15__["PolyLineComponent"],
                _components_path_path_component__WEBPACK_IMPORTED_MODULE_5__["PathComponent"],
                _directives_dynamic_field_directive__WEBPACK_IMPORTED_MODULE_16__["DynamicFieldDirective"],
                _components_dynamic_form_dynamic_form_component__WEBPACK_IMPORTED_MODULE_17__["DynamicFormComponent"],
                _control_checkbox_checkbox_component__WEBPACK_IMPORTED_MODULE_18__["CheckboxComponent"],
                _control_input_input_component__WEBPACK_IMPORTED_MODULE_19__["InputComponent"],
                _control_radiobutton_radiobutton_component__WEBPACK_IMPORTED_MODULE_20__["RadiobuttonComponent"],
                _control_select_select_component__WEBPACK_IMPORTED_MODULE_21__["SelectComponent"],
                _control_color_picker_color_picker_component__WEBPACK_IMPORTED_MODULE_22__["ColorPickerComponent"],
                _components_svgcanvas_svgcanvas_component__WEBPACK_IMPORTED_MODULE_26__["SVGCanvasComponent"],
                _components_freehand_freehand_component__WEBPACK_IMPORTED_MODULE_27__["FreehandComponent"]
            ],
            entryComponents: [
                _components_shape_shape_component__WEBPACK_IMPORTED_MODULE_9__["ShapeComponent"],
                _components_line_line_component__WEBPACK_IMPORTED_MODULE_4__["LineComponent"],
                _components_circle_circle_component__WEBPACK_IMPORTED_MODULE_8__["CircleComponent"],
                _components_rectangle_rectangle_component__WEBPACK_IMPORTED_MODULE_3__["RectangleComponent"],
                _components_square_square_component__WEBPACK_IMPORTED_MODULE_10__["SquareComponent"],
                _components_ellipse_ellipse_component__WEBPACK_IMPORTED_MODULE_11__["EllipseComponent"],
                _components_text_text_component__WEBPACK_IMPORTED_MODULE_12__["TextComponent"],
                _components_group_group_component__WEBPACK_IMPORTED_MODULE_13__["GroupComponent"],
                _components_image_image_component__WEBPACK_IMPORTED_MODULE_14__["ImageComponent"],
                _components_polyline_polyline_component__WEBPACK_IMPORTED_MODULE_15__["PolyLineComponent"],
                _components_path_path_component__WEBPACK_IMPORTED_MODULE_5__["PathComponent"],
                _control_input_input_component__WEBPACK_IMPORTED_MODULE_19__["InputComponent"],
                _control_select_select_component__WEBPACK_IMPORTED_MODULE_21__["SelectComponent"],
                _control_checkbox_checkbox_component__WEBPACK_IMPORTED_MODULE_18__["CheckboxComponent"],
                _control_radiobutton_radiobutton_component__WEBPACK_IMPORTED_MODULE_20__["RadiobuttonComponent"],
                _components_freehand_freehand_component__WEBPACK_IMPORTED_MODULE_27__["FreehandComponent"]
            ],
            providers: [],
            bootstrap: [_svgdrawing_svgdrawing_component__WEBPACK_IMPORTED_MODULE_7__["SVGDrawingComponent"]]
        })
    ], SVGDrawingToolModule);
    return SVGDrawingToolModule;
}());



/***/ }),

/***/ "./src/app/svgdrawing/svgdrawing.component.css":
/*!*****************************************************!*\
  !*** ./src/app/svgdrawing/svgdrawing.component.css ***!
  \*****************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "svg {\n    background: whitesmoke;\n    width: 934px;\n    height: 600px;\n    border: 1px solid black;\n}\n\n.header {\n    background-color: #f0f5e1;\n    margin-bottom: 5px;\n    margin-top: 5px;\n}\n\n.draggable {\n    cursor: move;\n}\n\n.nopadding {\n    padding: 0 !important;\n    margin: 0 !important;\n }\n\nh1 {\n    color: #80b944;\n    padding-top: 20px;\n}\n\n.shape {\n    margin: 5px 1px 5px 10px;\n}\n\n.tools {\n    background-color: whitesmoke;\n}\n\n.toolbar {\n    background-color: whitesmoke;\n    margin: 0;\n}\n\n.color-text {\n    font-weight: bolder;\n    color: white;\n}\n\n.panel-body:target {\n    height: auto;\n}\n\n/* .panel-body ul {\n    list-style: none;\n    padding-left: 0;\n    padding: 0;\n    margin: 0;\n}    \n\n.panel-body ul li {\n    background-color: #eee;\n    margin-bottom: 1px;\n    padding-left: 5px;\n    cursor: pointer;\n}   */\n\n.panel-body select {\n    width: 100%;\n    padding: 0;\n    margin: 0;\n    border: 0;\n    outline: 0;\n    background-color: #eee;\n}\n\n.panel-heading .accordion-toggle:after {\n    font-family: FontAwesome;\n    content:\"\\f068\"; \n    float: right;   \n    margin: 0;\n}\n\n.panel-heading .accordion-toggle.collapsed:after {\n    float: right !important;\n    content:\"\\f067\";\n}\n\n.panel-title {\n    width: 100%;\n    border: none;\n    outline: none;\n    background-color: #80b944;\n    color: white;\n    text-align: left;\n    cursor: pointer;\n    font-family: FontAwesome;\n    font-size: 18px;\n    margin-bottom: 1px;\n    padding: 10px 10px;\n}\n\n.panel-title:hover {\n    background-color: #609944;\n}\n\n.panel-title a { \n    text-decoration: none;\n    color: white;\n}\n\n.panel-title > a:hover, \n.panel-title > a:active, \n.panel-title > a:focus  {\n    text-decoration:none;\n}\n\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvc3ZnZHJhd2luZy9zdmdkcmF3aW5nLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7SUFDSSxzQkFBc0I7SUFDdEIsWUFBWTtJQUNaLGFBQWE7SUFDYix1QkFBdUI7QUFDM0I7O0FBRUE7SUFDSSx5QkFBeUI7SUFDekIsa0JBQWtCO0lBQ2xCLGVBQWU7QUFDbkI7O0FBRUE7SUFDSSxZQUFZO0FBQ2hCOztBQUVBO0lBQ0kscUJBQXFCO0lBQ3JCLG9CQUFvQjtDQUN2Qjs7QUFFRDtJQUNJLGNBQWM7SUFDZCxpQkFBaUI7QUFDckI7O0FBRUE7SUFDSSx3QkFBd0I7QUFDNUI7O0FBRUE7SUFDSSw0QkFBNEI7QUFDaEM7O0FBRUE7SUFDSSw0QkFBNEI7SUFDNUIsU0FBUztBQUNiOztBQUVBO0lBQ0ksbUJBQW1CO0lBQ25CLFlBQVk7QUFDaEI7O0FBRUE7SUFDSSxZQUFZO0FBQ2hCOztBQUVBOzs7Ozs7Ozs7Ozs7S0FZSzs7QUFFTDtJQUNJLFdBQVc7SUFDWCxVQUFVO0lBQ1YsU0FBUztJQUNULFNBQVM7SUFDVCxVQUFVO0lBQ1Ysc0JBQXNCO0FBQzFCOztBQUVBO0lBQ0ksd0JBQXdCO0lBQ3hCLGVBQWU7SUFDZixZQUFZO0lBQ1osU0FBUztBQUNiOztBQUVBO0lBQ0ksdUJBQXVCO0lBQ3ZCLGVBQWU7QUFDbkI7O0FBRUE7SUFDSSxXQUFXO0lBQ1gsWUFBWTtJQUNaLGFBQWE7SUFDYix5QkFBeUI7SUFDekIsWUFBWTtJQUNaLGdCQUFnQjtJQUNoQixlQUFlO0lBQ2Ysd0JBQXdCO0lBQ3hCLGVBQWU7SUFDZixrQkFBa0I7SUFDbEIsa0JBQWtCO0FBQ3RCOztBQUVBO0lBQ0kseUJBQXlCO0FBQzdCOztBQUVBO0lBQ0kscUJBQXFCO0lBQ3JCLFlBQVk7QUFDaEI7O0FBRUE7OztJQUdJLG9CQUFvQjtBQUN4QiIsImZpbGUiOiJzcmMvYXBwL3N2Z2RyYXdpbmcvc3ZnZHJhd2luZy5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsic3ZnIHtcbiAgICBiYWNrZ3JvdW5kOiB3aGl0ZXNtb2tlO1xuICAgIHdpZHRoOiA5MzRweDtcbiAgICBoZWlnaHQ6IDYwMHB4O1xuICAgIGJvcmRlcjogMXB4IHNvbGlkIGJsYWNrO1xufVxuXG4uaGVhZGVyIHtcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiAjZjBmNWUxO1xuICAgIG1hcmdpbi1ib3R0b206IDVweDtcbiAgICBtYXJnaW4tdG9wOiA1cHg7XG59XG5cbi5kcmFnZ2FibGUge1xuICAgIGN1cnNvcjogbW92ZTtcbn1cblxuLm5vcGFkZGluZyB7XG4gICAgcGFkZGluZzogMCAhaW1wb3J0YW50O1xuICAgIG1hcmdpbjogMCAhaW1wb3J0YW50O1xuIH1cblxuaDEge1xuICAgIGNvbG9yOiAjODBiOTQ0O1xuICAgIHBhZGRpbmctdG9wOiAyMHB4O1xufVxuXG4uc2hhcGUge1xuICAgIG1hcmdpbjogNXB4IDFweCA1cHggMTBweDtcbn1cblxuLnRvb2xzIHtcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiB3aGl0ZXNtb2tlO1xufVxuXG4udG9vbGJhciB7XG4gICAgYmFja2dyb3VuZC1jb2xvcjogd2hpdGVzbW9rZTtcbiAgICBtYXJnaW46IDA7XG59XG5cbi5jb2xvci10ZXh0IHtcbiAgICBmb250LXdlaWdodDogYm9sZGVyO1xuICAgIGNvbG9yOiB3aGl0ZTtcbn1cblxuLnBhbmVsLWJvZHk6dGFyZ2V0IHtcbiAgICBoZWlnaHQ6IGF1dG87XG59XG5cbi8qIC5wYW5lbC1ib2R5IHVsIHtcbiAgICBsaXN0LXN0eWxlOiBub25lO1xuICAgIHBhZGRpbmctbGVmdDogMDtcbiAgICBwYWRkaW5nOiAwO1xuICAgIG1hcmdpbjogMDtcbn0gICAgXG5cbi5wYW5lbC1ib2R5IHVsIGxpIHtcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiAjZWVlO1xuICAgIG1hcmdpbi1ib3R0b206IDFweDtcbiAgICBwYWRkaW5nLWxlZnQ6IDVweDtcbiAgICBjdXJzb3I6IHBvaW50ZXI7XG59ICAgKi9cblxuLnBhbmVsLWJvZHkgc2VsZWN0IHtcbiAgICB3aWR0aDogMTAwJTtcbiAgICBwYWRkaW5nOiAwO1xuICAgIG1hcmdpbjogMDtcbiAgICBib3JkZXI6IDA7XG4gICAgb3V0bGluZTogMDtcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiAjZWVlO1xufVxuXG4ucGFuZWwtaGVhZGluZyAuYWNjb3JkaW9uLXRvZ2dsZTphZnRlciB7XG4gICAgZm9udC1mYW1pbHk6IEZvbnRBd2Vzb21lO1xuICAgIGNvbnRlbnQ6XCJcXGYwNjhcIjsgXG4gICAgZmxvYXQ6IHJpZ2h0OyAgIFxuICAgIG1hcmdpbjogMDtcbn1cblxuLnBhbmVsLWhlYWRpbmcgLmFjY29yZGlvbi10b2dnbGUuY29sbGFwc2VkOmFmdGVyIHtcbiAgICBmbG9hdDogcmlnaHQgIWltcG9ydGFudDtcbiAgICBjb250ZW50OlwiXFxmMDY3XCI7XG59XG5cbi5wYW5lbC10aXRsZSB7XG4gICAgd2lkdGg6IDEwMCU7XG4gICAgYm9yZGVyOiBub25lO1xuICAgIG91dGxpbmU6IG5vbmU7XG4gICAgYmFja2dyb3VuZC1jb2xvcjogIzgwYjk0NDtcbiAgICBjb2xvcjogd2hpdGU7XG4gICAgdGV4dC1hbGlnbjogbGVmdDtcbiAgICBjdXJzb3I6IHBvaW50ZXI7XG4gICAgZm9udC1mYW1pbHk6IEZvbnRBd2Vzb21lO1xuICAgIGZvbnQtc2l6ZTogMThweDtcbiAgICBtYXJnaW4tYm90dG9tOiAxcHg7XG4gICAgcGFkZGluZzogMTBweCAxMHB4O1xufVxuXG4ucGFuZWwtdGl0bGU6aG92ZXIge1xuICAgIGJhY2tncm91bmQtY29sb3I6ICM2MDk5NDQ7XG59XG5cbi5wYW5lbC10aXRsZSBhIHsgXG4gICAgdGV4dC1kZWNvcmF0aW9uOiBub25lO1xuICAgIGNvbG9yOiB3aGl0ZTtcbn1cblxuLnBhbmVsLXRpdGxlID4gYTpob3ZlciwgXG4ucGFuZWwtdGl0bGUgPiBhOmFjdGl2ZSwgXG4ucGFuZWwtdGl0bGUgPiBhOmZvY3VzICB7XG4gICAgdGV4dC1kZWNvcmF0aW9uOm5vbmU7XG59XG5cbiJdfQ== */"

/***/ }),

/***/ "./src/app/svgdrawing/svgdrawing.component.html":
/*!******************************************************!*\
  !*** ./src/app/svgdrawing/svgdrawing.component.html ***!
  \******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\n    <div class=\"row header\">\n        <div class=\"col-md-2\">\n            <img src=\"assets/svgdrawing/drawing.png\" width=\"160\" height=\"80\" />\n        </div>\n        <div class=\"col-md-10\">\n            <h1>{{ title }}</h1>\n        </div>\n    </div>\n    <div class=\"row\">\n        <div class=\"col-md-2 tools nopadding\">\n                <div class=\"panel panel-default\">\n                    <div id=\"shapes\">\n                        <div class=\"panel-body\">\n                            <div class=\"row nopadding\">\n                                <button (click)=\"selectShape('Line')\" type=\"button\" class=\"btn btn-outline-primary col-md-3 shape\"><img\n                                        src=\"assets/svgdrawing/line.png\" width=\"24\" height=\"24\"></button>\n                                <button (click)=\"selectShape('Rectangle')\" type=\"button\" class=\"btn btn-outline-primary col-md-3 shape\"><img\n                                        src=\"assets/svgdrawing/rectangle.png\" width=\"24\" height=\"24\"></button>\n                                <button (click)=\"selectShape('Circle')\" type=\"button\" class=\"btn btn-outline-primary col-md-3 shape\"><img\n                                        src=\"assets/svgdrawing/circle.png\" width=\"24\" height=\"24\"></button>\n                                <button (click)=\"selectShape('Ellipse')\" type=\"button\" class=\"btn btn-outline-primary col-md-3 shape\"><img\n                                        src=\"assets/svgdrawing/ellipse.png\" width=\"24\" height=\"24\"></button>\n                                <button (click)=\"selectShape('Freehand')\" type=\"button\" class=\"btn btn-outline-primary col-md-3 shape\"><img\n                                        src=\"assets/svgdrawing/path.png\" width=\"24\" height=\"24\"></button>\n                                <button (click)=\"selectShape('Square')\" type=\"button\" class=\"btn btn-outline-primary col-md-3 shape\"><img\n                                        src=\"assets/svgdrawing/square.png\" width=\"24\" height=\"24\"></button>\n                                <button (click)=\"selectShape('TextBox')\" type=\"button\" class=\"btn btn-outline-primary col-md-3 shape\"><img\n                                        src=\"assets/svgdrawing/text.png\" width=\"24\" height=\"24\"></button>\n                                <button (click)=\"selectShape('Image')\" type=\"button\" class=\"btn btn-outline-primary col-md-3 shape\"><img\n                                        src=\"assets/svgdrawing/image.png\" width=\"24\" height=\"24\"></button>\n                                <button (click)=\"selectShape('PolyLine')\" type=\"button\" class=\"btn btn-outline-primary col-md-3 shape\"><img\n                                        src=\"assets/svgdrawing/polyline.png\" width=\"24\" height=\"24\"></button>\n                            </div>\n                        </div>\n                        <hr>\n                        <div class=\"panel-body\">\n                            <div class=\"row nopadding\">\n                                <button (click)=\"selectTool('Pointer')\" type=\"button\" class=\"btn btn-outline-primary col-md-3 shape\"><img\n                                        src=\"assets/svgdrawing/pointer.png\" width=\"24\" height=\"24\"></button>\n                              <button (click)=\"selectTool('Move')\" type=\"button\" class=\"btn btn-outline-primary col-md-3 shape\"><img\n                                src=\"assets/svgdrawing/move.png\" width=\"24\" height=\"24\"></button>\n                                <button (click)=\"selectTool('SelectArea')\" type=\"button\" class=\"btn btn-outline-primary col-md-3 shape\"><img\n                                        src=\"assets/svgdrawing/select-area.png\" width=\"24\" height=\"24\"></button>\n                            </div>\n                        </div>\n                </div>\n            </div>\n        </div>\n        <div class=\"col-md-10 toolbar\">\n            <div class=\"row\">\n                <div class=\"col-md-6\">\n                    <p>Selected Shape : {{ this.shapeValue }}</p>\n                </div>\n                <div class=\"col-md-6\">\n                    <button (click)=\"clearShapes()\" type=\"button\" class=\"btn btn-light\">Clear</button>\n                </div>\n            </div>\n          <app-svgcanvas #svgCanvas [width]=\"800\" [height]=\"600\"></app-svgcanvas>\n        </div>\n    </div>\n</div>\n"

/***/ }),

/***/ "./src/app/svgdrawing/svgdrawing.component.ts":
/*!****************************************************!*\
  !*** ./src/app/svgdrawing/svgdrawing.component.ts ***!
  \****************************************************/
/*! exports provided: SVGDrawingComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SVGDrawingComponent", function() { return SVGDrawingComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _svgcanvas_model_shape__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../svgcanvas/model/shape */ "./src/app/svgcanvas/model/shape.ts");
/* harmony import */ var _svgcanvas_components_svgcanvas_svgcanvas_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../svgcanvas/components/svgcanvas/svgcanvas.component */ "./src/app/svgcanvas/components/svgcanvas/svgcanvas.component.ts");




var SVGDrawingComponent = /** @class */ (function () {
    function SVGDrawingComponent() {
        this.title = 'SVG Drawing Tool';
        this.shapeProperties = new _svgcanvas_model_shape__WEBPACK_IMPORTED_MODULE_2__["ShapeProperties"]();
        console.log('SVGDrawing constructor');
    }
    SVGDrawingComponent.prototype.ngOnInit = function () {
        console.log('svgCanvas = ' + this.svgCanvas);
    };
    SVGDrawingComponent.prototype.clearShapes = function () {
        this.svgCanvas.clear();
    };
    SVGDrawingComponent.prototype.selectTool = function (toolType) {
        if (toolType === 'Pointer') {
            this.svgCanvas.changeState(_svgcanvas_components_svgcanvas_svgcanvas_component__WEBPACK_IMPORTED_MODULE_3__["SVGCanvasState"].eSelecting);
        }
        else if (toolType === 'Move') {
            this.svgCanvas.changeState(_svgcanvas_components_svgcanvas_svgcanvas_component__WEBPACK_IMPORTED_MODULE_3__["SVGCanvasState"].eEditing);
        }
        console.log('selected tool:', toolType);
    };
    SVGDrawingComponent.prototype.selectShape = function (shapeType$) {
        this.svgCanvas.selectShape(shapeType$);
    };
    SVGDrawingComponent.prototype.ngOnChanges = function (changes) {
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["ViewChild"])('svgCanvas'),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", _svgcanvas_components_svgcanvas_svgcanvas_component__WEBPACK_IMPORTED_MODULE_3__["SVGCanvasComponent"])
    ], SVGDrawingComponent.prototype, "svgCanvas", void 0);
    SVGDrawingComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-svgdrawing-component',
            template: __webpack_require__(/*! ./svgdrawing.component.html */ "./src/app/svgdrawing/svgdrawing.component.html"),
            styles: [__webpack_require__(/*! ./svgdrawing.component.css */ "./src/app/svgdrawing/svgdrawing.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], SVGDrawingComponent);
    return SVGDrawingComponent;
}());



/***/ }),

/***/ "./src/app/symbols/agnostic-symbol-strokes.ts":
/*!****************************************************!*\
  !*** ./src/app/symbols/agnostic-symbol-strokes.ts ***!
  \****************************************************/
/*! exports provided: AgnosticSymbolStrokes */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AgnosticSymbolStrokes", function() { return AgnosticSymbolStrokes; });
var AgnosticSymbolStrokes = /** @class */ (function () {
    function AgnosticSymbolStrokes() {
        this.freehandComponents = new Array();
    }
    return AgnosticSymbolStrokes;
}());



/***/ }),

/***/ "./src/app/symbols/agnostic-symbol-svgpath.ts":
/*!****************************************************!*\
  !*** ./src/app/symbols/agnostic-symbol-svgpath.ts ***!
  \****************************************************/
/*! exports provided: AgnosticSymbolSVGPath */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AgnosticSymbolSVGPath", function() { return AgnosticSymbolSVGPath; });
var AgnosticSymbolSVGPath = /** @class */ (function () {
    function AgnosticSymbolSVGPath(d, x, y) {
        this.d = d;
        this.x = x;
        this.y = y;
    }
    return AgnosticSymbolSVGPath;
}());



/***/ }),

/***/ "./src/app/symbols/symbols.component.css":
/*!***********************************************!*\
  !*** ./src/app/symbols/symbols.component.css ***!
  \***********************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "#staff > div {\n  background-color: white;\n}\n\n#staff {\n  min-height: 100px;\n}\n\n#selectedStaff {\n  position: relative;\n}\n\n#noStaffSelectedMessage {\n  position: absolute;\n  z-index: 100;\n  top: 50px; /* TODO */\n  left: 50%;\n}\n\n#agnosticToolbarEditButtons {\n  font-size: 18px;\n}\n\n#agnosticToolbarSymbols button {\n  font-size: 10px;\n}\n\n#agnosticToolbar input[type=checkbox] {\n  width: 25px;\n  height: 25px;\n  -moz-appearance: none;\n}\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvc3ltYm9scy9zeW1ib2xzLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRSx1QkFBdUI7QUFDekI7O0FBRUE7RUFDRSxpQkFBaUI7QUFDbkI7O0FBRUE7RUFDRSxrQkFBa0I7QUFDcEI7O0FBQ0E7RUFDRSxrQkFBa0I7RUFDbEIsWUFBWTtFQUNaLFNBQVMsRUFBRSxTQUFTO0VBQ3BCLFNBQVM7QUFDWDs7QUFHQTtFQUNFLGVBQWU7QUFDakI7O0FBRUE7RUFDRSxlQUFlO0FBQ2pCOztBQUVBO0VBQ0UsV0FBVztFQUNYLFlBQVk7RUFDWixxQkFBcUI7QUFDdkIiLCJmaWxlIjoic3JjL2FwcC9zeW1ib2xzL3N5bWJvbHMuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIiNzdGFmZiA+IGRpdiB7XG4gIGJhY2tncm91bmQtY29sb3I6IHdoaXRlO1xufVxuXG4jc3RhZmYge1xuICBtaW4taGVpZ2h0OiAxMDBweDtcbn1cblxuI3NlbGVjdGVkU3RhZmYge1xuICBwb3NpdGlvbjogcmVsYXRpdmU7XG59XG4jbm9TdGFmZlNlbGVjdGVkTWVzc2FnZSB7XG4gIHBvc2l0aW9uOiBhYnNvbHV0ZTtcbiAgei1pbmRleDogMTAwO1xuICB0b3A6IDUwcHg7IC8qIFRPRE8gKi9cbiAgbGVmdDogNTAlO1xufVxuXG5cbiNhZ25vc3RpY1Rvb2xiYXJFZGl0QnV0dG9ucyB7XG4gIGZvbnQtc2l6ZTogMThweDtcbn1cblxuI2Fnbm9zdGljVG9vbGJhclN5bWJvbHMgYnV0dG9uIHtcbiAgZm9udC1zaXplOiAxMHB4O1xufVxuXG4jYWdub3N0aWNUb29sYmFyIGlucHV0W3R5cGU9Y2hlY2tib3hdIHtcbiAgd2lkdGg6IDI1cHg7XG4gIGhlaWdodDogMjVweDtcbiAgLW1vei1hcHBlYXJhbmNlOiBub25lO1xufVxuIl19 */"

/***/ }),

/***/ "./src/app/symbols/symbols.component.html":
/*!************************************************!*\
  !*** ./src/app/symbols/symbols.component.html ***!
  \************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"row\" xmlns:svg=\"\">\n  <div class=\"col-2\">\n    <app-image-tool-bar></app-image-tool-bar>\n  </div>\n\n  <!-------------- CONTENT ------------------>\n  <div class=\"col-10\">\n    <div class=\"row\" id=\"selectedStaff\">\n      <div class=\"col\">\n        <!-- This inner div is used to avoid problems with padding -->\n        <div #selectedStaffInnerDIV\n             [style.height.px]=\"selectedStaffHeight\"\n             [ngStyle]=\"{'background-image':' url(' + selectedStaffImageURL + ')'}\"\n             [style.background-position-x.px]=\"selectedStaffImageBackgroundPositionX\"\n             [style.background-position-y.px]=\"selectedStaffImageBackgroundPositionY\"\n             [style.background-size.%]=\"selectedStaffImageBackgroundPertentage\"\n             [style.cursor]=\"selectedStaffCursor\"\n        >\n          <app-svgcanvas #svgCanvas [width]=\"selectedStaffImageWidth\" [height]=\"selectedStaffHeight\"\n            (svgShapeCreated)=\"onShapeCreated($event)\" (svgShapeSelected)=\"onShapeSelected($event)\"\n          >\n\n          </app-svgcanvas>\n        </div>\n      </div>\n      <p id=\"noStaffSelectedMessage\" [hidden]=\"staffSelected\">Select a staff...</p>\n    </div>\n\n    <div class=\"row\" id=\"agnostic\">\n      <div class=\"col\" id=\"staff\" [style.height.px]=\"agnosticStaffHeight\">\n        <!-- This inner div is used to avoid problems with padding -->\n        <svg [attr.viewBox]=\"'0 0 ' + agnosticStaffWidth + ' ' + agnosticStaffHeight\"\n             preserveAspectRatio=\"xMidYMid meet\">\n          <rect width=\"100%\" height=\"100%\" fill=\"white\"/>\n          <g>\n            <line stroke=\"black\" *ngFor=\"let staffLineYCoordinate of staffLineYCoordinates\"\n                  [attr.x1]=\"0\" [attr.y1]=\"staffLineYCoordinate\"\n                  stroke-width=\"2\"\n                  [attr.x2]=\"selectedStaffImageWidth\"  [attr.y2]=\"staffLineYCoordinate\"/>\n          </g>\n          <g>\n            <!--<app-image-thumbnail *ngFor=\"let image of project.images\" [image]=\"image\" [projectURLs]=\"projectURLs\" [attr.data-id]=\"image.id\"></app-image-thumbnail>-->\n            <path *ngFor=\"let agnosticSymbolSVGKeyValue of agnosticSymbolSVGs | keyvalue; trackBy: trackByFn\"\n                  [attr.d]=\"agnosticSymbolSVGKeyValue.value.d\"\n                  [attr.stroke]=\"getAgnosticStaffSymbolColor(agnosticSymbolSVGKeyValue.key)\"\n                  [attr.fill]=\"getAgnosticStaffSymbolColor(agnosticSymbolSVGKeyValue.key)\"\n                  [attr.transform]=\"'translate(' + agnosticSymbolSVGKeyValue.value.x\n                  + ',' + agnosticSymbolSVGKeyValue.value.y\n                  + ') scale(' + agnosticSVGScaleX + ', ' + agnosticSVGScaleY + ')'\"\n                  (click)=\"onAgnosticStaffSymbolSelected(agnosticSymbolSVGKeyValue.key)\"\n            />\n          </g>\n        </svg>\n      </div>\n    </div>\n\n    <!-- tool bar to correct the agnostic transcription -->\n    <!--          {{item.key}}:{{item.value}} -->\n    <div class=\"row\" id=\"agnosticToolbar\">\n      <div class=\"col\">\n        <div class=\"btn-toolbar\" role=\"toolbar\" aria-label=\"Agnostic toolbar\" id=\"agnosticToolbarEditButtons\">\n          <div class=\"btn-group mr-2\" role=\"group\" aria-label=\"Symbol edition\">\n            <button type=\"button\" class=\"btn btn-primary\" title=\"Move pitch down\"  (click)=\"movePitchDownSelectedSymbol()\">\n              <i class=\"fa fa-angle-down\"></i>\n            </button>\n            <button type=\"button\" class=\"btn btn-primary\" title=\"Move pitch up\" (click)=\"movePitchUpSelectedSymbol()\">\n              <i class=\"fa fa-angle-up\"></i>\n            </button>\n            &nbsp;\n            <button type=\"button\" class=\"btn btn-primary\" title=\"Delete\" (click)=\"deleteSelectedSymbol()\">\n              <i class=\"fa fa-trash\"></i>\n            </button>\n            &nbsp;\n            <input id=\"showSymbolStrokesCheckBox\"\n                       type=\"checkbox\" [checked]=\"showSymbolStrokes\"/> Show strokes\n          </div>\n\n          <div class=\"btn-group-justified\" role=\"group\" aria-label=\"Agnostic symbols\" id=\"agnosticToolbarSymbols\">\n            <button *ngFor=\"let item of agnosticSymbolSVGMap | keyvalue; trackBy: trackByFn\" type=\"button\" class=\"btn btn-secondary\"\n                    (click)=\"changeAgnosticType(item.key)\">\n              <svg width=\"60\" height=\"60\" viewBox=\"0 -2048 2048 4096\"> <!-- TODO Valores de la escala, 2048 es el valor unitsPerEM de la fuente SVG -->\n                <path stroke=\"black\" fill=\"black\" [attr.d]=\"item.value\" [attr.transform]=\"'scale(1, -1)'\"/>\n              </svg><br>\n              {{item.key}}\n            </button>\n          </div>\n        </div>\n      </div>\n    </div>\n\n    <!-- image with regions drawn to be selected -->\n    <div class=\"row\" id=\"manuscriptImage\">\n      <div class=\"col\">\n        <app-document-analysis-view #appDocumentAnalysisView (mouseEvent)=\"onMouseEvent($event)\" (svgShapeSelected)=\"onRegionSelected($event)\"></app-document-analysis-view>\n      </div>\n    </div>\n  </div>\n</div>\n\n\n"

/***/ }),

/***/ "./src/app/symbols/symbols.component.ts":
/*!**********************************************!*\
  !*** ./src/app/symbols/symbols.component.ts ***!
  \**********************************************/
/*! exports provided: SymbolsComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SymbolsComponent", function() { return SymbolsComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _model_stroke__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../model/stroke */ "./src/app/model/stroke.ts");
/* harmony import */ var ngx_logger__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ngx-logger */ "./node_modules/ngx-logger/esm5/ngx-logger.js");
/* harmony import */ var _agnostic_symbol_svgpath__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./agnostic-symbol-svgpath */ "./src/app/symbols/agnostic-symbol-svgpath.ts");
/* harmony import */ var _services_session_data_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../services/session-data.service */ "./src/app/services/session-data.service.ts");
/* harmony import */ var _component_can_deactivate__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../component-can-deactivate */ "./src/app/component-can-deactivate.ts");
/* harmony import */ var _image_tool_bar_image_tool_bar_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../image-tool-bar/image-tool-bar.service */ "./src/app/image-tool-bar/image-tool-bar.service.ts");
/* harmony import */ var _svgcanvas_components_svgcanvas_svgcanvas_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../svgcanvas/components/svgcanvas/svgcanvas.component */ "./src/app/svgcanvas/components/svgcanvas/svgcanvas.component.ts");
/* harmony import */ var _document_analysis_view_document_analysis_view_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../document-analysis-view/document-analysis-view.component */ "./src/app/document-analysis-view/document-analysis-view.component.ts");
/* harmony import */ var _svgcanvas_model_shape__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ../svgcanvas/model/shape */ "./src/app/svgcanvas/model/shape.ts");
/* harmony import */ var _agnostic_symbol_strokes__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./agnostic-symbol-strokes */ "./src/app/symbols/agnostic-symbol-strokes.ts");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var _model_strokes__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ../model/strokes */ "./src/app/model/strokes.ts");
/* harmony import */ var _model_point__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ../model/point */ "./src/app/model/point.ts");
/* harmony import */ var _services_agnostic_service__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ../services/agnostic.service */ "./src/app/services/agnostic.service.ts");
/* harmony import */ var _services_image_service__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ../services/image.service */ "./src/app/services/image.service.ts");
/* harmony import */ var _services_symbol_service__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! ../services/symbol.service */ "./src/app/services/symbol.service.ts");



















var SymbolsComponent = /** @class */ (function (_super) {
    tslib__WEBPACK_IMPORTED_MODULE_0__["__extends"](SymbolsComponent, _super);
    function SymbolsComponent(agnosticService, imageService, symbolService, sessionDataService, route, logger, toolbarService) {
        var _this = _super.call(this) || this;
        _this.agnosticService = agnosticService;
        _this.imageService = imageService;
        _this.symbolService = symbolService;
        _this.sessionDataService = sessionDataService;
        _this.route = route;
        _this.logger = logger;
        _this.toolbarService = toolbarService;
        _this.staffSelected = false;
        _this.agnosticStaffHeight = 0;
        _this.agnosticStaffWidth = 0;
        _this.selectedStaffCursor = 'default';
        _this.currentTimerID = 0;
        _this.currentStrokes = null;
        _this.agnosticSymbolSVGMap = new Map();
        return _this;
    }
    SymbolsComponent.prototype.ngOnInit = function () {
        /*if (true) {
          /// ------- DEVELOPMENT FIXED VALUES ----
          this.im3wsService.getProject$(37).subscribe(next => {
            this.sessionDataService.currentProject = next;
            this.project = this.sessionDataService.currentProject;
            this.loadSVGSet();
          });
    
          this.im3wsService.getImage$(198).subscribe(next => {
            console.log('next = ' + next);
            this.sessionDataService.currentImage = next;
            this.sessionDataService.currentImageMastersURL = 'http://localhost:8888/muret/villancico-al-smo--sto--al-molino-del-amor/masters/';
    
            this.image = this.sessionDataService.currentImage;
            this.imageURL = this.sessionDataService.currentImageMastersURL + '/' + this.image.filename;
    
            this.toolbarService.currentActivePanel = 'symbolsMode';
            this.logger.debug('Working with image ' + this.imageURL);
          });
        } else {*/
        this.project = this.sessionDataService.currentProject;
        this.image = this.sessionDataService.currentImage;
        this.logger.debug('Working with image ' + this.imageURL);
        this.loadSVGSet();
        // }
        this.initToolBarInteraction();
        this.documentAnalysisView.activateSelectMode();
    };
    // TODO - usado en el *nfFor con keyvalue, ver si podemos coger el id del símbolo mejor - lo hacemos en dos sitios
    SymbolsComponent.prototype.trackByFn = function (index, item) {
        return index;
    };
    SymbolsComponent.prototype.loadSVGSet = function () {
        var _this = this;
        this.agnosticService.getSVGSet$(this.project.notationType, this.project.manuscriptType).
            subscribe(function (next) {
            _this.agnosticSVGScaleX = next.x;
            _this.agnosticSVGScaleY = next.y;
            _this.agnosticSVGem = next.em;
            _this.staffSpaceHeight = _this.agnosticSVGem / 4.0;
            _this.agnosticSymbolSVGMap = new Map();
            next.paths.forEach(function (item) {
                _this.agnosticSymbolSVGMap.set(item.agnosticTypeString, item.svgPathD);
            });
            _this.logger.debug('Using SVG scales: (' + _this.agnosticSVGScaleX + ', ' + _this.agnosticSVGScaleY
                + '), with default em=' + _this.agnosticSVGem
                + ' with ' + _this.agnosticSymbolSVGMap.size + ' SVG elements');
            _this.drawStaff();
            _this.drawAgnosticToolBar();
        });
    };
    SymbolsComponent.prototype.drawAgnosticToolBar = function () {
        // TODO ordenar
    };
    SymbolsComponent.prototype.initToolBarInteraction = function () {
        var _this = this;
        this.toolbarService.selectedTool$.subscribe(function (next) {
            _this.logger.debug('Using interaction: ' + next);
            _this.selectedStaffCursor = 'default';
            switch (next) {
                case '200': // symbols select
                    _this.svgCanvas.changeState(_svgcanvas_components_svgcanvas_svgcanvas_component__WEBPACK_IMPORTED_MODULE_9__["SVGCanvasState"].eEditing);
                    break;
                case '201': // symbols bounding boxes
                    _this.svgCanvas.selectShapeProperties('transparent', 2, 'lightgreen'); // TODO values
                    _this.svgCanvas.selectShape('Rectangle');
                    _this.svgCanvas.changeState(_svgcanvas_components_svgcanvas_svgcanvas_component__WEBPACK_IMPORTED_MODULE_9__["SVGCanvasState"].eDrawing);
                    _this.selectedStaffCursor = 'cell';
                    break;
                case '202': // symbols strokes
                    _this.svgCanvas.selectShapeProperties('transparent', 2, 'lightgreen'); // TODO values
                    _this.svgCanvas.selectShape('Freehand');
                    _this.svgCanvas.changeState(_svgcanvas_components_svgcanvas_svgcanvas_component__WEBPACK_IMPORTED_MODULE_9__["SVGCanvasState"].eDrawing);
                    _this.selectedStaffCursor = 'crosshair';
                    break;
            }
        });
        this.toolbarService.selectedTool = '200';
    };
    SymbolsComponent.prototype.ngAfterViewInit = function () {
    };
    SymbolsComponent.prototype.ngOnDestroy = function () {
    };
    /*onResized(event: ResizedEvent): void {
      this.logger.debug('Resized');
      if (this.imageSurface) {
        this.scale = this.domImage.nativeElement.width / this.domImage.nativeElement.naturalWidth;
        this.drawBoundingBoxes();
      } // else it is invoked before ngAfterViewInit
    }
  */
    SymbolsComponent.prototype.doSelectRegion = function (region) {
        this.staffSelected = true;
        this.selectedRegion = region;
        this.drawSelectedRegion(region);
        this.agnosticStaffWidth = this.selectedStaffWidth;
        this.drawSelectedRegionSymbols(region);
    };
    SymbolsComponent.prototype.drawSymbol = function (symbol) {
        this.agnosticSymbols.set(symbol.id, symbol);
        this.drawSymbolStrokes(symbol);
        this.drawSymbolBoundingBox(symbol);
        this.drawSymbolAgnostic(this.selectedRegion, symbol);
    };
    SymbolsComponent.prototype.drawSymbolStrokes = function (symbol) {
        var _this = this;
        this.logger.debug('Drawing symbol ' + symbol.id);
        if (symbol.strokes != null) {
            this.logger.debug('Drawing ' + symbol.strokes.strokeList.length + ' strokes');
            var agnosticStrokes_1 = new _agnostic_symbol_strokes__WEBPACK_IMPORTED_MODULE_12__["AgnosticSymbolStrokes"]();
            symbol.strokes.strokeList.forEach(function (stroke) {
                var component = _this.drawStroke(symbol, stroke);
                agnosticStrokes_1.freehandComponents.push(component);
            });
            this.agnosticSymbolStrokes.set(symbol.id, agnosticStrokes_1);
        }
    };
    SymbolsComponent.prototype.drawStaff = function () {
        this.staffMargin = this.agnosticSVGem;
        this.staffLineYCoordinates = new Array(5);
        var i = 0;
        for (i = 0; i < 5; i++) {
            var y = i * this.staffSpaceHeight + this.staffMargin;
            this.staffLineYCoordinates[i] = y;
            if (i === 4) {
                this.staffBottomLineY = y;
            }
        }
        this.agnosticStaffHeight = this.staffMargin * 2 + this.staffSpaceHeight * 5;
        this.agnosticSymbolSVGs = new Map();
        this.agnosticSymbolStrokes = new Map();
    };
    SymbolsComponent.prototype.drawSelectedRegion = function (region) {
        this.selectedStaffImageURL = this.imageURL;
        var regionWidth = region.boundingBox.toX - region.boundingBox.fromX;
        var regionHeight = region.boundingBox.toY - region.boundingBox.fromY;
        this.selectedStaffWidth = this.selectedStaffInnerDIV.nativeElement.offsetWidth;
        this.selectedStaffImageWidth = this.documentAnalysisView.getImageNaturalWidth();
        this.selectedStaffScale = this.selectedStaffImageWidth / regionWidth;
        var expectedStaffWidth = regionWidth / this.selectedStaffScale;
        this.expectedStaffWidthPercentage = this.selectedStaffWidth / expectedStaffWidth;
        this.selectedStaffImageBackgroundPertentage = this.selectedStaffScale * 100.0;
        this.selectedStaffImageBackgroundPositionX = this.expectedStaffWidthPercentage * (-region.boundingBox.fromX / this.selectedStaffScale);
        this.selectedStaffImageBackgroundPositionY = this.expectedStaffWidthPercentage * (-region.boundingBox.fromY / this.selectedStaffScale);
        this.selectedStaffHeight = (regionHeight / this.selectedStaffScale) * this.expectedStaffWidthPercentage;
        this.selectedStaffFinalScale = this.selectedStaffScale;
        this.logger.debug('Selected staff scale: ' + this.selectedStaffScale
            + ', regionBBoxY=' + region.boundingBox.fromY
            + ', selectedStaffImageBackgroundPositionY=' + this.selectedStaffImageBackgroundPositionY
            + ', expectedStaffWidthPercentage= ' + this.expectedStaffWidthPercentage);
    };
    /* private drawSelectedRegionSymbolBoxes(region: Region) {
       this.logger.debug('Drawing region symbol boxes');
       /// this.selectedStaffBoundingBoxesGroup.clear();
       if (region.symbols) {
         region.symbols.forEach(symbol => {
           this.logger.debug('Drawing symbol ' + symbol);
   
           const fromX = ((symbol.boundingBox.fromX - region.boundingBox.fromX) / this.selectedStaffScale) * this.expectedStaffWidthPercentage;
           const fromY = ((symbol.boundingBox.fromY - region.boundingBox.fromY) / this.selectedStaffScale) * this.expectedStaffWidthPercentage;
           const toX = ((symbol.boundingBox.toX - region.boundingBox.fromX) / this.selectedStaffScale) * this.expectedStaffWidthPercentage;
           const toY = ((symbol.boundingBox.toY - region.boundingBox.fromY) / this.selectedStaffScale) * this.expectedStaffWidthPercentage;
   
           const translatedAndScaledBoundingBox = new BoundingBox(
             fromX, fromY, toX, toY
           );
   
           this.drawBoundingBox(this.selectedStaffBoundingBoxesGroup, symbol, translatedAndScaledBoundingBox,
             1,
             'blue', 1);
         });
       }
     }*/
    SymbolsComponent.prototype.computeAgnosticStaffSymbolY = function (region, symbol) {
        var lineSpace = this.positionInStaffToLineSpace(symbol.positionInStaff);
        var heightDifference = -(this.staffSpaceHeight * (lineSpace / 2.0));
        var y = this.staffBottomLineY + heightDifference;
        return y;
    };
    /* TODO Posición */
    SymbolsComponent.prototype.drawSymbolAgnostic = function (region, symbol) {
        this.logger.debug('Drawing SVG ' + symbol);
        if (symbol.agnosticSymbolType) {
            var x = ((symbol.boundingBox.fromX - region.boundingBox.fromX) / this.selectedStaffScale) * this.expectedStaffWidthPercentage;
            var svg = this.agnosticSymbolSVGMap.get(symbol.agnosticSymbolType);
            var y = this.computeAgnosticStaffSymbolY(region, symbol);
            var asvg = new _agnostic_symbol_svgpath__WEBPACK_IMPORTED_MODULE_5__["AgnosticSymbolSVGPath"](svg, x, y);
            this.agnosticSymbolSVGs.set(symbol.id, asvg);
            /*if (!svg) {
              this.im3wsService.getSVGFromAgnosticSymbolType$(
                this.project.notationType,
                this.project.manuscriptType,
                symbol.agnosticSymbolType).subscribe(next => {
                const svgD = next.response;
                this.agnosticSymbolSVGMap.set(symbol.agnosticSymbolType, svgD);
                const asvg = new AgnosticSymbolSVGPath(svgD, x, y);
                this.agnosticSymbolSVGs.push(asvg);
              });
            } else {
              const asvg = new AgnosticSymbolSVGPath(svg, x, y);
              this.agnosticSymbolSVGs.push(asvg);
            }*/ // TODO
        }
    };
    SymbolsComponent.prototype.drawSelectedRegionSymbols = function (region) {
        var _this = this;
        this.svgCanvas.clear();
        this.agnosticSymbolSVGs = new Map(); // empty it
        this.agnosticSymbols = new Map(); // empty it
        region.symbols.forEach(function (symbol) {
            _this.drawSymbol(symbol);
        });
    };
    // TODO Sacar todo esto a componentes
    SymbolsComponent.prototype.positionInStaffToLineSpace = function (positionInStaff) {
        var value = Number(positionInStaff.substr(1));
        if (positionInStaff.charAt(0) === 'L') {
            return (value - 1) * 2;
        }
        else if (positionInStaff.charAt(0) === 'S') {
            return (value) * 2 - 1;
        }
        else {
            throw new Error('Invalid positionInStaff, it should start with L or S: ' + positionInStaff);
        }
    };
    SymbolsComponent.prototype.canDeactivate = function () {
        return false; // TODO
    };
    SymbolsComponent.prototype.onMouseEvent = function ($event) {
    };
    SymbolsComponent.prototype.onRegionSelected = function ($event) {
        if ($event.modelObjectType === 'Region') {
            // look for the region ID
            var region = this.documentAnalysisView.findRegionID($event.modelObjectID);
            if (!region) {
                this.logger.warn('Cannot find region with id ' + $event.modelObjectID);
            }
            else {
                this.logger.debug('Region with id ' + $event.modelObjectID + ' selected');
                this.doSelectRegion(region);
            }
        }
    };
    SymbolsComponent.prototype.onShapeSelected = function ($event) {
        if ($event == null) {
            this.selectedSymbol = null;
        }
        else if ($event.modelObjectType === 'Symbol') {
            var symbol = this.agnosticSymbols.get($event.modelObjectID);
            if (!symbol) {
                this.logger.warn('Cannot find symbol with id ' + $event.modelObjectID);
            }
            else {
                this.logger.debug('Symmbol with id ' + $event.modelObjectID + ' selected');
                this.doSelectSymbol(symbol);
            }
        }
    };
    SymbolsComponent.prototype.onShapeCreated = function ($event) {
        var _this = this;
        this.logger.debug('New bounding box: ' + $event);
        if ($event.shape instanceof _svgcanvas_model_shape__WEBPACK_IMPORTED_MODULE_11__["Rectangle"]) {
            var shape = $event.shape;
            /* const fromX = this.selectedRegion.boundingBox.fromX + ((shape.originX) * this.selectedStaffScale)
               / this.expectedStaffWidthPercentage;
             const fromY = this.selectedRegion.boundingBox.fromY + (( shape.originY) * this.selectedStaffScale)
               / this.expectedStaffWidthPercentage;
             const toX = this.selectedRegion.boundingBox.fromX  + (( shape.originX + shape.width) * this.selectedStaffScale)
               / this.expectedStaffWidthPercentage;
             const toY = this.selectedRegion.boundingBox.fromY + ((shape.originY + shape.height) * this.selectedStaffScale)
               / this.expectedStaffWidthPercentage;*/
            var fromX = this.fromScreenX(shape.originX);
            var fromY = this.fromScreenY(shape.originY);
            var toX = this.fromScreenX(shape.originX + shape.width);
            var toY = this.fromScreenY(shape.originY + shape.height);
            var prevCursor_1 = this.selectedStaffCursor;
            this.selectedStaffCursor = 'wait';
            this.imageService.createSymbolFromBoundingBox$(this.selectedRegion, fromX, fromY, toX, toY).subscribe(function (next) {
                _this.selectedStaffCursor = prevCursor_1;
                _this.logger.debug('New symbol created ' + next.id);
                _this.svgCanvas.remove($event);
                _this.drawSymbol(next);
                _this.selectedRegion.symbols.push(next); // the im3ws spring service just returns the new symbol, not the complete region on each symbol insert
            });
        }
        else if ($event.shape instanceof _svgcanvas_model_shape__WEBPACK_IMPORTED_MODULE_11__["PolyLine"]) {
            var shape = $event.shape;
            var source = Object(rxjs__WEBPACK_IMPORTED_MODULE_13__["timer"])(300); // TODO timer duration, now 300ms
            this.currentTimerID++;
            var subscribe = source.subscribe(function (val) {
                return _this.onStrokesTimer(_this.currentTimerID);
            });
            if (this.currentStrokes == null) {
                this.currentStrokes = new _model_strokes__WEBPACK_IMPORTED_MODULE_14__["Strokes"](new Array());
            }
            var points_1 = new Array();
            var prevTimeStamp_1 = 0;
            shape.points.forEach(function (p) {
                var t;
                if (prevTimeStamp_1 === 0) {
                    t = 0;
                }
                else {
                    t = p.timestamp - prevTimeStamp_1;
                }
                prevTimeStamp_1 = p.timestamp;
                var point = new _model_point__WEBPACK_IMPORTED_MODULE_15__["Point"](t, _this.fromScreenX(p.x), _this.fromScreenY(p.y));
                points_1.push(point);
            });
            var stroke = new _model_stroke__WEBPACK_IMPORTED_MODULE_3__["Stroke"](points_1);
            this.currentStrokes.strokeList.push(stroke);
            if (this.currentStrokesFreeHandComponents == null) {
                this.currentStrokesFreeHandComponents = new Array();
            }
            this.currentStrokesFreeHandComponents.push($event);
        }
    };
    SymbolsComponent.prototype.onStrokesTimer = function (timerID) {
        var _this = this;
        if (timerID === this.currentTimerID) {
            // generate strokes
            var prevCursor_2 = this.selectedStaffCursor;
            this.selectedStaffCursor = 'wait';
            this.imageService.createSymbolFromStrokes$(this.selectedRegion, this.currentStrokes).subscribe(function (next) {
                _this.selectedStaffCursor = prevCursor_2;
                _this.logger.debug('New symbol created ' + next.id);
                _this.currentStrokesFreeHandComponents.forEach(function (shape) {
                    _this.svgCanvas.remove(shape);
                });
                _this.currentStrokes = null;
                _this.currentStrokesFreeHandComponents = null;
                _this.drawSymbol(next);
                _this.selectedRegion.symbols.push(next); // the im3ws spring service just returns the new symbol, not the complete region on each symbol insert
            });
        } // else discard it because it has been overwritten by the new one
    };
    SymbolsComponent.prototype.toScreenX = function (x) {
        return ((x - this.selectedRegion.boundingBox.fromX) / this.selectedStaffScale)
            * this.expectedStaffWidthPercentage;
    };
    SymbolsComponent.prototype.toScreenY = function (y) {
        return ((y - this.selectedRegion.boundingBox.fromY) / this.selectedStaffScale)
            * this.expectedStaffWidthPercentage;
    };
    SymbolsComponent.prototype.fromScreenX = function (x) {
        return this.selectedRegion.boundingBox.fromX + (x * this.selectedStaffScale)
            / this.expectedStaffWidthPercentage;
    };
    SymbolsComponent.prototype.fromScreenY = function (y) {
        return this.selectedRegion.boundingBox.fromY + (y * this.selectedStaffScale)
            / this.expectedStaffWidthPercentage;
    };
    SymbolsComponent.prototype.drawSymbolBoundingBox = function (symbol) {
        if (symbol.boundingBox) {
            var fromX = this.toScreenX(symbol.boundingBox.fromX);
            var fromY = this.toScreenY(symbol.boundingBox.fromY);
            var toX = this.toScreenX(symbol.boundingBox.toX);
            var toY = this.toScreenY(symbol.boundingBox.toY);
            /*const fromX = symbol.boundingBox.fromX;
            const fromY = symbol.boundingBox.fromY;
            const toX = symbol.boundingBox.toX;
            const toY = symbol.boundingBox.toY;*/
            var shapeComponent = this.svgCanvas.drawRectangle(fromX, fromY, toX - fromX, toY - fromY, '');
            shapeComponent.shape.shapeProperties.fillColor = 'transparent';
            shapeComponent.shape.shapeProperties.strokeWidth = 1;
            shapeComponent.shape.shapeProperties.strokeColor = 'lightgreen'; // TODO
            shapeComponent.modelObjectType = 'Symbol';
            shapeComponent.modelObjectID = symbol.id;
        }
    };
    SymbolsComponent.prototype.drawStroke = function (symbol, stroke) {
        var _this = this;
        if (stroke) {
            var mousePositions_1 = new Array();
            stroke.points.forEach(function (point) {
                var mousePosition = new _svgcanvas_model_shape__WEBPACK_IMPORTED_MODULE_11__["MousePosition"]();
                mousePosition.x = _this.toScreenX(point.x);
                mousePosition.y = _this.toScreenY(point.y);
                mousePositions_1.push(mousePosition);
            });
            var shapeComponent = this.svgCanvas.drawFreeHand(mousePositions_1);
            shapeComponent.shape.shapeProperties.fillColor = 'transparent';
            shapeComponent.shape.shapeProperties.strokeWidth = 2;
            shapeComponent.shape.shapeProperties.strokeColor = 'blue'; // TODO
            shapeComponent.modelObjectType = 'Symbol';
            shapeComponent.modelObjectID = symbol.id;
            return shapeComponent;
        }
        else {
            return null;
        }
    };
    SymbolsComponent.prototype.doSelectSymbol = function (symbol) {
        this.selectedSymbol = symbol;
        // it is automatically selected in agnostic staff (see getAgnosticStaffSymbolColor)
    };
    SymbolsComponent.prototype.onAgnosticStaffSymbolSelected = function (symbolID) {
        // select symbol
        // TODO
    };
    SymbolsComponent.prototype.getAgnosticStaffSymbolColor = function (symbolID) {
        if (this.selectedSymbol != null && this.selectedSymbol.id === symbolID) {
            return 'red';
        }
        else {
            return 'black'; // TODO Constantes
        }
    };
    SymbolsComponent.prototype.deleteSelectedSymbol = function () {
        var _this = this;
        if (this.selectedSymbol != null) {
            this.imageService.deleteSymbol$(this.selectedRegion.id, this.selectedSymbol.id).subscribe(function () {
                _this.agnosticSymbols.delete(_this.selectedSymbol.id);
                _this.agnosticSymbolSVGs.delete(_this.selectedSymbol.id);
                _this.svgCanvas.remove(_this.svgCanvas.selectedComponent);
                var strokes = _this.agnosticSymbolStrokes.get(_this.selectedSymbol.id);
                if (strokes) {
                    strokes.freehandComponents.forEach(function (component) {
                        _this.svgCanvas.remove(component);
                    });
                    _this.agnosticSymbolStrokes.delete(_this.selectedSymbol.id);
                }
                _this.selectedSymbol = null;
            });
        }
    };
    SymbolsComponent.prototype.movePitchSelectedSymbol = function (upOrDown) {
        var _this = this;
        if (this.selectedSymbol != null) {
            this.symbolService.changeAgnosticPositionInStaffUpOrDown$(this.selectedSymbol.id, upOrDown).subscribe(function (next) {
                _this.selectedSymbol.positionInStaff = next.positionInStaff;
                var newY = _this.computeAgnosticStaffSymbolY(_this.selectedRegion, _this.selectedSymbol);
                var svgPath = _this.agnosticSymbolSVGs.get(_this.selectedSymbol.id);
                if (!svgPath) {
                    throw new Error('Cannot find an agnostic staff symbol for id ' + _this.selectedSymbol.id);
                }
                svgPath.y = newY;
            });
        }
    };
    SymbolsComponent.prototype.movePitchUpSelectedSymbol = function () {
        this.movePitchSelectedSymbol('up');
    };
    SymbolsComponent.prototype.movePitchDownSelectedSymbol = function () {
        this.movePitchSelectedSymbol('down');
    };
    SymbolsComponent.prototype.changeAgnosticType = function (type) {
        var _this = this;
        this.symbolService.changeAgnosticSymbolType$(this.selectedSymbol.id, type).subscribe(function (next) {
            _this.selectedSymbol.positionInStaff = next.positionInStaff;
            var svgPath = _this.agnosticSymbolSVGs.get(_this.selectedSymbol.id);
            if (!svgPath) {
                throw new Error('Cannot find an agnostic staff symbol for id ' + _this.selectedSymbol.id);
            }
            var newSVG = _this.agnosticSymbolSVGMap.get(type);
            svgPath.d = newSVG;
        });
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["ViewChild"])('appDocumentAnalysisView'),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", _document_analysis_view_document_analysis_view_component__WEBPACK_IMPORTED_MODULE_10__["DocumentAnalysisViewComponent"])
    ], SymbolsComponent.prototype, "documentAnalysisView", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["ViewChild"])('selectedStaffInnerDIV'),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", _angular_core__WEBPACK_IMPORTED_MODULE_1__["ElementRef"])
    ], SymbolsComponent.prototype, "selectedStaffInnerDIV", void 0);
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["ViewChild"])('svgCanvas'),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", _svgcanvas_components_svgcanvas_svgcanvas_component__WEBPACK_IMPORTED_MODULE_9__["SVGCanvasComponent"])
    ], SymbolsComponent.prototype, "svgCanvas", void 0);
    SymbolsComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-symbols',
            template: __webpack_require__(/*! ./symbols.component.html */ "./src/app/symbols/symbols.component.html"),
            styles: [__webpack_require__(/*! ./symbols.component.css */ "./src/app/symbols/symbols.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_services_agnostic_service__WEBPACK_IMPORTED_MODULE_16__["AgnosticService"],
            _services_image_service__WEBPACK_IMPORTED_MODULE_17__["ImageService"],
            _services_symbol_service__WEBPACK_IMPORTED_MODULE_18__["SymbolService"],
            _services_session_data_service__WEBPACK_IMPORTED_MODULE_6__["SessionDataService"],
            _angular_router__WEBPACK_IMPORTED_MODULE_2__["ActivatedRoute"],
            ngx_logger__WEBPACK_IMPORTED_MODULE_4__["NGXLogger"],
            _image_tool_bar_image_tool_bar_service__WEBPACK_IMPORTED_MODULE_8__["ImageToolBarService"]])
    ], SymbolsComponent);
    return SymbolsComponent;
}(_component_can_deactivate__WEBPACK_IMPORTED_MODULE_7__["ComponentCanDeactivate"]));



/***/ }),

/***/ "./src/app/training-sets/training-sets.component.css":
/*!***********************************************************!*\
  !*** ./src/app/training-sets/training-sets.component.css ***!
  \***********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "#trainingSets h3 {\n   color: white;\n}\n\n#trainingSets h4 {\n  color: white;\n}\n\n#trainingSets p {\n  color: gray;\n}\n\n#trainingSets button {\n  margin: 10px;\n  margin-bottom: 20px;\n}\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvdHJhaW5pbmctc2V0cy90cmFpbmluZy1zZXRzLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7R0FDRyxZQUFZO0FBQ2Y7O0FBRUE7RUFDRSxZQUFZO0FBQ2Q7O0FBRUE7RUFDRSxXQUFXO0FBQ2I7O0FBRUE7RUFDRSxZQUFZO0VBQ1osbUJBQW1CO0FBQ3JCIiwiZmlsZSI6InNyYy9hcHAvdHJhaW5pbmctc2V0cy90cmFpbmluZy1zZXRzLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIjdHJhaW5pbmdTZXRzIGgzIHtcbiAgIGNvbG9yOiB3aGl0ZTtcbn1cblxuI3RyYWluaW5nU2V0cyBoNCB7XG4gIGNvbG9yOiB3aGl0ZTtcbn1cblxuI3RyYWluaW5nU2V0cyBwIHtcbiAgY29sb3I6IGdyYXk7XG59XG5cbiN0cmFpbmluZ1NldHMgYnV0dG9uIHtcbiAgbWFyZ2luOiAxMHB4O1xuICBtYXJnaW4tYm90dG9tOiAyMHB4O1xufVxuIl19 */"

/***/ }),

/***/ "./src/app/training-sets/training-sets.component.html":
/*!************************************************************!*\
  !*** ./src/app/training-sets/training-sets.component.html ***!
  \************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div id=\"trainingSets\" [style.cursor]=\"currentCursor\">\n  <div class=\"row\">\n    <h2 class=\"offset-1 col-9\">Export training datasets</h2>\n  </div>\n\n  <form [formGroup]=\"form\" (ngSubmit)=\"submit()\">\n    <div class=\"row\">\n      <h3 class=\"offset-1 col-9\">Available exporters</h3>\n    </div>\n\n    <label class=\"row\" formArrayName=\"exportersFormArray\" *ngFor=\"let rb of form.controls.exportersFormArray.controls; let i = index\">\n      <div class=\"offset-1 col-1 text-right\">\n        <input type=\"radio\" checked name=\"exportersRadioButton\" value=\"{{i}}\" (change)=\"onExporterSelected(i)\">\n      </div>\n      <div class=\"col-9\">\n        <h4>{{exporters[i].name}}</h4>\n        <p>{{exporters[i].description}}</p>\n      </div>\n    </label>\n\n    <div class=\"row\">\n      <h3 class=\"offset-1 col-9\">Projects to be exported</h3>\n    </div>\n\n    <label class=\"row\" formArrayName=\"projectsFormArray\" *ngFor=\"let cb of form.controls.projectsFormArray.controls; let i = index\">\n      <div class=\"offset-1 col-1 text-right\">\n        <input type=\"checkbox\" [formControlName]=\"i\">\n      </div>\n      <div class=\"col-9\">\n        <h4>{{projects[i].name}}</h4>\n        <h5>{{projects[i].state?.state}}</h5>\n        <p>{{projects[i].comments}}</p>\n      </div>\n    </label>\n\n    <div class=\"row\" *ngIf=\"!form.valid\">\n      <p class=\"offset-1 col-9\">At least one exporter and one project order must be selected</p>\n    </div>\n\n    <div class=\"row\">\n      <div class=\"col offset-2\">\n        <button [disabled]=\"!form.valid\" class=\"btn btn-primary btn-lg\">Export training set</button>\n      </div>\n    </div>\n\n  </form>\n</div>\n"

/***/ }),

/***/ "./src/app/training-sets/training-sets.component.ts":
/*!**********************************************************!*\
  !*** ./src/app/training-sets/training-sets.component.ts ***!
  \**********************************************************/
/*! exports provided: TrainingSetsComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TrainingSetsComponent", function() { return TrainingSetsComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var file_saver__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! file-saver */ "./node_modules/file-saver/dist/FileSaver.min.js");
/* harmony import */ var file_saver__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(file_saver__WEBPACK_IMPORTED_MODULE_2__);
/* harmony import */ var _services_session_data_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../services/session-data.service */ "./src/app/services/session-data.service.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _form_utils__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../form-utils */ "./src/app/form-utils.ts");
/* harmony import */ var _services_training_set_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../services/training-set.service */ "./src/app/services/training-set.service.ts");
/* harmony import */ var _services_project_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../services/project.service */ "./src/app/services/project.service.ts");








var TrainingSetsComponent = /** @class */ (function () {
    function TrainingSetsComponent(projectService, trainingSetService, sessionDataService, formBuilder) {
        this.projectService = projectService;
        this.trainingSetService = trainingSetService;
        this.sessionDataService = sessionDataService;
        this.formBuilder = formBuilder;
        this.currentCursor = 'default';
        this.form = this.formBuilder.group({
            exportersFormArray: new _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormArray"]([], _angular_forms__WEBPACK_IMPORTED_MODULE_4__["Validators"].required),
            projectsFormArray: new _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormArray"]([], _form_utils__WEBPACK_IMPORTED_MODULE_5__["FormUtils"].minSelectedCheckboxes(1))
        });
    }
    TrainingSetsComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.trainingSetService.getTrainingSetExporters$().pipe().subscribe(function (value) {
            _this.exporters = value;
            var controls = _this.exporters.map(function (c) { return new _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormControl"](false); });
            controls.forEach(function (c) {
                _this.form.get('exportersFormArray').push(c);
            });
            _this.onExporterSelected(controls.length - 1); // TODO Parche
        });
        this.projectService.getProjects$().subscribe(function (value) {
            _this.projects = value;
            var controls = _this.projects.map(function (c) { return new _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormControl"](false); });
            var projectsFormArray = _this.form.get('projectsFormArray');
            controls.forEach(function (c) {
                projectsFormArray.push(c);
            });
        });
    };
    TrainingSetsComponent.prototype.submit = function () {
        var _this = this;
        var selectedProjectIDS = Array();
        var index = 0;
        this.form.get('projectsFormArray').controls.forEach(function (cb) {
            if (cb.value) {
                selectedProjectIDS.push(_this.projects[index].id);
            }
            index++;
        });
        this.currentCursor = 'wait';
        this.trainingSetService.downloadTrainingSet$(this.selectedExporterId, selectedProjectIDS).subscribe(function (data) {
            var blob1 = new Blob([data], { type: 'application/x-gzip' });
            file_saver__WEBPACK_IMPORTED_MODULE_2___default.a.saveAs(blob1, 'training_set.tgz'); // TODO file name
            _this.currentCursor = 'default';
        });
    };
    TrainingSetsComponent.prototype.onExporterSelected = function (i) {
        this.selectedExporterId = this.exporters[i].id;
    };
    TrainingSetsComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-training-sets',
            template: __webpack_require__(/*! ./training-sets.component.html */ "./src/app/training-sets/training-sets.component.html"),
            styles: [__webpack_require__(/*! ./training-sets.component.css */ "./src/app/training-sets/training-sets.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_services_project_service__WEBPACK_IMPORTED_MODULE_7__["ProjectService"], _services_training_set_service__WEBPACK_IMPORTED_MODULE_6__["TrainingSetService"], _services_session_data_service__WEBPACK_IMPORTED_MODULE_3__["SessionDataService"], _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormBuilder"]])
    ], TrainingSetsComponent);
    return TrainingSetsComponent;
}());



/***/ }),

/***/ "./src/app/ui/footer/footer.component.css":
/*!************************************************!*\
  !*** ./src/app/ui/footer/footer.component.css ***!
  \************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3VpL2Zvb3Rlci9mb290ZXIuY29tcG9uZW50LmNzcyJ9 */"

/***/ }),

/***/ "./src/app/ui/footer/footer.component.html":
/*!*************************************************!*\
  !*** ./src/app/ui/footer/footer.component.html ***!
  \*************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<nav class=\"navbar navbar-dark bg-dark mt-5 fixed-bottom navbar-collapse\">\n  <div id=\"messages\">\n    <app-messages></app-messages>\n  </div>\n</nav>\n"

/***/ }),

/***/ "./src/app/ui/footer/footer.component.ts":
/*!***********************************************!*\
  !*** ./src/app/ui/footer/footer.component.ts ***!
  \***********************************************/
/*! exports provided: FooterComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FooterComponent", function() { return FooterComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var FooterComponent = /** @class */ (function () {
    function FooterComponent() {
    }
    FooterComponent.prototype.ngOnInit = function () {
    };
    FooterComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-footer',
            template: __webpack_require__(/*! ./footer.component.html */ "./src/app/ui/footer/footer.component.html"),
            styles: [__webpack_require__(/*! ./footer.component.css */ "./src/app/ui/footer/footer.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], FooterComponent);
    return FooterComponent;
}());



/***/ }),

/***/ "./src/app/ui/header/header.component.css":
/*!************************************************!*\
  !*** ./src/app/ui/header/header.component.css ***!
  \************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".navbar-toggler-icon {\n  background-image: url(\"data:image/svg+xml;charset=utf8,%3Csvg viewBox='0 0 32 32' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath stroke='rgba(255,255,255, 1)' stroke-width='2' stroke-linecap='round' stroke-miterlimit='10' d='M4 8h24M4 16h24M4 24h24'/%3E%3C/svg%3E\");\n}\n\nnav {\n  margin-top: 25px;\n  margin-bottom: 25px;\n}\n\n\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvdWkvaGVhZGVyL2hlYWRlci5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0UsdVFBQXVRO0FBQ3pROztBQUVBO0VBQ0UsZ0JBQWdCO0VBQ2hCLG1CQUFtQjtBQUNyQiIsImZpbGUiOiJzcmMvYXBwL3VpL2hlYWRlci9oZWFkZXIuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi5uYXZiYXItdG9nZ2xlci1pY29uIHtcbiAgYmFja2dyb3VuZC1pbWFnZTogdXJsKFwiZGF0YTppbWFnZS9zdmcreG1sO2NoYXJzZXQ9dXRmOCwlM0Nzdmcgdmlld0JveD0nMCAwIDMyIDMyJyB4bWxucz0naHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmcnJTNFJTNDcGF0aCBzdHJva2U9J3JnYmEoMjU1LDI1NSwyNTUsIDEpJyBzdHJva2Utd2lkdGg9JzInIHN0cm9rZS1saW5lY2FwPSdyb3VuZCcgc3Ryb2tlLW1pdGVybGltaXQ9JzEwJyBkPSdNNCA4aDI0TTQgMTZoMjRNNCAyNGgyNCcvJTNFJTNDL3N2ZyUzRVwiKTtcbn1cblxubmF2IHtcbiAgbWFyZ2luLXRvcDogMjVweDtcbiAgbWFyZ2luLWJvdHRvbTogMjVweDtcbn1cblxuXG4iXX0= */"

/***/ }),

/***/ "./src/app/ui/header/header.component.html":
/*!*************************************************!*\
  !*** ./src/app/ui/header/header.component.html ***!
  \*************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<nav class=\"navbar navbar-light offset-1\">\n  <div ngbDropdown class=\"d-inline-block\">\n    <button class=\"navbar-toggler hidden-sm-up\" id=\"dropdownBasic1\" ngbDropdownToggle>\n      <span class=\"navbar-toggler-icon\"></span>\n    </button>\n    <div ngbDropdownMenu aria-labelledby=\"dropdownBasic1\">\n      <a class=\"dropdown-item nav-link\" routerLinkActive=\"active\" routerLink=\"startup\">Home</a>\n      <a class=\"dropdown-item nav-link\" [hidden]=\"authenticated()\" routerLink=\"login\">Login</a>\n      <a class=\"dropdown-item nav-link\" [hidden]=\"!authenticated()\" routerLink=\"login\">Logout</a>\n      <a class=\"dropdown-item nav-link\" [hidden]=\"!authenticated()\" routerLink=\"export\">Export training sets</a>\n      <a class=\"dropdown-item nav-link\" [hidden]=\"!authenticated()\" routerLink=\"preferences\">Preferences</a>\n      <a class=\"dropdown-item nav-link\" routerLinkActive=\"active\" routerLink=\"about\">About</a>\n      <a class=\"dropdown-item nav-link\" href=\"https://github.com/HISPAMUS/muret\" target=\"_blank\">\n        <i class=\"fa fa-github\"></i>\n      </a>\n    </div>\n    <a [hidden]=\"hideLogo()\" class=\"navbar-brand\" routerLink=\"startup\">\n      <img src=\"assets/images/muret.png\" alt=\"Logo MuRET\">\n    </a>\n    <a routerLink=\"dev\">DEV</a>&nbsp;\n\n  </div>\n  <div ng-if=\"authenticated()\" class=\"navbar-right\">\n    {{getUserName()}}\n  </div>\n</nav>\n"

/***/ }),

/***/ "./src/app/ui/header/header.component.ts":
/*!***********************************************!*\
  !*** ./src/app/ui/header/header.component.ts ***!
  \***********************************************/
/*! exports provided: HeaderComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "HeaderComponent", function() { return HeaderComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _services_auth_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../services/auth.service */ "./src/app/services/auth.service.ts");




var HeaderComponent = /** @class */ (function () {
    function HeaderComponent(authService, router) {
        this.authService = authService;
        this.router = router;
        this.hideLogoIn = new Set([
            '/about',
            '/startup'
        ]);
    }
    HeaderComponent.prototype.authenticated = function () {
        return this.authService.authenticated();
    };
    HeaderComponent.prototype.hideLogo = function () {
        return this.hideLogoIn.has(this.router.url);
    };
    HeaderComponent.prototype.getUserName = function () {
        if (this.authService.authenticated()) {
            return this.authService.getUser().username;
        }
        else {
            return '';
        }
    };
    HeaderComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-header',
            template: __webpack_require__(/*! ./header.component.html */ "./src/app/ui/header/header.component.html"),
            styles: [__webpack_require__(/*! ./header.component.css */ "./src/app/ui/header/header.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_services_auth_service__WEBPACK_IMPORTED_MODULE_3__["AuthService"], _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"]])
    ], HeaderComponent);
    return HeaderComponent;
}());



/***/ }),

/***/ "./src/app/ui/layout/layout.component.css":
/*!************************************************!*\
  !*** ./src/app/ui/layout/layout.component.css ***!
  \************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "header {\n}\n\n#mainContent {\n}\n\nfooter {\n}\n\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvdWkvbGF5b3V0L2xheW91dC5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0FBQ0E7O0FBRUE7QUFDQTs7QUFFQTtBQUNBIiwiZmlsZSI6InNyYy9hcHAvdWkvbGF5b3V0L2xheW91dC5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiaGVhZGVyIHtcbn1cblxuI21haW5Db250ZW50IHtcbn1cblxuZm9vdGVyIHtcbn1cblxuIl19 */"

/***/ }),

/***/ "./src/app/ui/layout/layout.component.html":
/*!*************************************************!*\
  !*** ./src/app/ui/layout/layout.component.html ***!
  \*************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<header>\n  <app-header></app-header>\n</header>\n<div id=\"mainContent\" class=\"container-fluid\">\n  <ng-content></ng-content>\n</div>\n<footer>\n  <app-footer></app-footer>\n</footer>\n"

/***/ }),

/***/ "./src/app/ui/layout/layout.component.ts":
/*!***********************************************!*\
  !*** ./src/app/ui/layout/layout.component.ts ***!
  \***********************************************/
/*! exports provided: LayoutComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LayoutComponent", function() { return LayoutComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var LayoutComponent = /** @class */ (function () {
    function LayoutComponent() {
    }
    LayoutComponent.prototype.ngOnInit = function () {
    };
    LayoutComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-layout',
            template: __webpack_require__(/*! ./layout.component.html */ "./src/app/ui/layout/layout.component.html"),
            styles: [__webpack_require__(/*! ./layout.component.css */ "./src/app/ui/layout/layout.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], LayoutComponent);
    return LayoutComponent;
}());



/***/ }),

/***/ "./src/app/ui/ui.module.ts":
/*!*********************************!*\
  !*** ./src/app/ui/ui.module.ts ***!
  \*********************************/
/*! exports provided: UiModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UiModule", function() { return UiModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _layout_layout_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./layout/layout.component */ "./src/app/ui/layout/layout.component.ts");
/* harmony import */ var _header_header_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./header/header.component */ "./src/app/ui/header/header.component.ts");
/* harmony import */ var _footer_footer_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./footer/footer.component */ "./src/app/ui/footer/footer.component.ts");
/* harmony import */ var _messages_messages_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../messages/messages.component */ "./src/app/messages/messages.component.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @ng-bootstrap/ng-bootstrap */ "./node_modules/@ng-bootstrap/ng-bootstrap/fesm5/ng-bootstrap.js");









var UiModule = /** @class */ (function () {
    function UiModule() {
    }
    UiModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_2__["CommonModule"], _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_8__["NgbModule"], _angular_router__WEBPACK_IMPORTED_MODULE_7__["RouterModule"] // important to include the router module here because routes do not work otherwise
            ],
            exports: [_layout_layout_component__WEBPACK_IMPORTED_MODULE_3__["LayoutComponent"]],
            declarations: [_layout_layout_component__WEBPACK_IMPORTED_MODULE_3__["LayoutComponent"], _header_header_component__WEBPACK_IMPORTED_MODULE_4__["HeaderComponent"], _footer_footer_component__WEBPACK_IMPORTED_MODULE_5__["FooterComponent"],
                _messages_messages_component__WEBPACK_IMPORTED_MODULE_6__["MessagesComponent"]]
        })
    ], UiModule);
    return UiModule;
}());



/***/ }),

/***/ "./src/app/upload-images/upload-images.component.css":
/*!***********************************************************!*\
  !*** ./src/app/upload-images/upload-images.component.css ***!
  \***********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3VwbG9hZC1pbWFnZXMvdXBsb2FkLWltYWdlcy5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/upload-images/upload-images.component.html":
/*!************************************************************!*\
  !*** ./src/app/upload-images/upload-images.component.html ***!
  \************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<style>\n  .my-drop-zone { border: dotted 3px lightgray; }\n  .nv-file-over { border: dotted 3px red; } /* Default class applied to drop zones on over */\n  .another-file-over-class { border: dotted 3px green; }\n\n  html, body { height: 100%; }\n</style>\n\n<div class=\"container\">\n\n  <div class=\"navbar navbar-default\">\n    <div class=\"navbar-header\">\n      <h1>{{project?.name}}</h1>\n    </div>\n  </div>\n\n  <div class=\"row\">\n\n    <div class=\"col-5\">\n      <h3>Select files to upload from disk</h3>\n      <input type=\"file\" ng2FileSelect [uploader]=\"uploader\" multiple  />\n    </div>\n\n    <div class=\"col-7\">\n      <div ng2FileDrop\n           [ngClass]=\"{'nv-file-over': hasBaseDropZoneOver}\"\n           (fileOver)=\"fileOverBase($event)\"\n           [uploader]=\"uploader\"\n           class=\"well my-drop-zone\">\n        Or drop images here\n      </div>\n    </div>\n  </div>\n  <div class=\"row\">\n    <div class=\"col\" style=\"margin-bottom: 40px\">\n\n      <h3>Upload queue</h3>\n      <p>Queue length: {{ uploader?.queue?.length }}</p>\n\n      <table class=\"table\">\n        <thead>\n        <tr>\n          <th width=\"50%\">Name</th>\n          <th>Size</th>\n          <th>Progress</th>\n          <th>Status</th>\n          <th>Actions</th>\n        </tr>\n        </thead>\n        <tbody>\n        <tr *ngFor=\"let item of uploader.queue\">\n          <td><strong>{{ item?.file?.name }}</strong></td>\n          <td *ngIf=\"uploader.isHTML5\" nowrap>{{ item?.file?.size/1024/1024 | number:'.2' }} MB</td>\n          <td *ngIf=\"uploader.isHTML5\">\n            <div class=\"progress\" style=\"margin-bottom: 0;\">\n              <div class=\"progress-bar\" role=\"progressbar\" [ngStyle]=\"{ 'width': item.progress + '%' }\"></div>\n            </div>\n          </td>\n          <td class=\"text-center\">\n            <span *ngIf=\"item.isSuccess\"><i class=\"glyphicon glyphicon-ok\"></i></span>\n            <span *ngIf=\"item.isCancel\"><i class=\"glyphicon glyphicon-ban-circle\"></i></span>\n            <span *ngIf=\"item.isError\"><i class=\"glyphicon glyphicon-remove\"></i></span>\n          </td>\n          <td nowrap>\n            <button type=\"button\" class=\"btn btn-success btn-xs\"\n                    (click)=\"item.upload()\" [disabled]=\"item.isReady || item.isUploading || item.isSuccess\">\n              <span class=\"glyphicon glyphicon-upload\"></span> Upload\n            </button>\n            <button type=\"button\" class=\"btn btn-warning btn-xs\"\n                    (click)=\"item.cancel()\" [disabled]=\"!item.isUploading\">\n              <span class=\"glyphicon glyphicon-ban-circle\"></span> Cancel\n            </button>\n            <button type=\"button\" class=\"btn btn-danger btn-xs\"\n                    (click)=\"item.remove()\">\n              <span class=\"glyphicon glyphicon-trash\"></span> Remove\n            </button>\n          </td>\n        </tr>\n        </tbody>\n      </table>\n\n      <div>\n        <div>\n          Queue progress:\n          <div class=\"progress\" style=\"\">\n            <div class=\"progress-bar\" role=\"progressbar\" [ngStyle]=\"{ 'width': uploader.progress + '%' }\"></div>\n          </div>\n        </div>\n        <button type=\"button\" class=\"btn btn-success btn-s\"\n                (click)=\"uploader.uploadAll()\" [disabled]=\"!uploader.getNotUploadedItems().length\">\n          <span class=\"glyphicon glyphicon-upload\"></span> Upload all\n        </button>\n        <button type=\"button\" class=\"btn btn-warning btn-s\"\n                (click)=\"uploader.cancelAll()\" [disabled]=\"!uploader.isUploading\">\n          <span class=\"glyphicon glyphicon-ban-circle\"></span> Cancel all\n        </button>\n        <button type=\"button\" class=\"btn btn-danger btn-s\"\n                (click)=\"uploader.clearQueue()\" [disabled]=\"!uploader.queue.length\">\n          <span class=\"glyphicon glyphicon-trash\"></span> Remove all\n        </button>\n      </div>\n\n    </div>\n\n  </div>\n  <div class=\"row\">\n    <div class=\"col\">\n      <a href=\"project/{{project?.id}}\">Continue with project {{project?.name}}</a>\n    </div>\n\n  </div>\n\n</div>\n"

/***/ }),

/***/ "./src/app/upload-images/upload-images.component.ts":
/*!**********************************************************!*\
  !*** ./src/app/upload-images/upload-images.component.ts ***!
  \**********************************************************/
/*! exports provided: UploadImagesComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UploadImagesComponent", function() { return UploadImagesComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var ng2_file_upload__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ng2-file-upload */ "./node_modules/ng2-file-upload/index.js");
/* harmony import */ var ng2_file_upload__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(ng2_file_upload__WEBPACK_IMPORTED_MODULE_2__);
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var ngx_logger__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ngx-logger */ "./node_modules/ngx-logger/esm5/ngx-logger.js");
/* harmony import */ var _configuration_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../configuration.service */ "./src/app/configuration.service.ts");
/* harmony import */ var _services_project_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../services/project.service */ "./src/app/services/project.service.ts");







// const URL = 'http://localhost:8080/muret/upload/projectImage';
var UploadImagesComponent = /** @class */ (function () {
    function UploadImagesComponent(projectService, route, logger, configurationService) {
        this.projectService = projectService;
        this.route = route;
        this.logger = logger;
        this.configurationService = configurationService;
        this.hasBaseDropZoneOver = true;
        this.hasAnotherDropZoneOver = false;
    }
    /* TODO Intentar pasar el objeto project directamente con redux? */
    UploadImagesComponent.prototype.ngOnInit = function () {
        var _this = this;
        var URL = this.configurationService + '/muret/upload/projectImage';
        this.uploader = new ng2_file_upload__WEBPACK_IMPORTED_MODULE_2__["FileUploader"]({ url: URL });
        var routeParams = this.route.snapshot.params;
        this.projectService.getProject$(routeParams.id)
            .subscribe(function (serviceProject) { return _this.project = serviceProject; }).add(function (teardown) {
            _this.logger.debug('UploadImagesComponent' + _this.project.name + ' with #' + _this.project.images.length + ' images');
        });
        // it avoids CORS problems
        this.uploader.onBeforeUploadItem = function (item) {
            item.withCredentials = false;
        };
        this.uploader.onAfterAddingFile = function (file) { file.withCredentials = false; };
        // Add in the other upload form parameters.
        this.uploader.onBuildItemForm = function (item, form) {
            form.append('projectid', _this.project.id);
        };
    };
    UploadImagesComponent.prototype.fileOverBase = function (e) {
        this.hasBaseDropZoneOver = e;
    };
    UploadImagesComponent.prototype.fileOverAnother = function (e) {
        this.hasAnotherDropZoneOver = e;
    };
    UploadImagesComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-upload-images',
            template: __webpack_require__(/*! ./upload-images.component.html */ "./src/app/upload-images/upload-images.component.html"),
            styles: [__webpack_require__(/*! ./upload-images.component.css */ "./src/app/upload-images/upload-images.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_services_project_service__WEBPACK_IMPORTED_MODULE_6__["ProjectService"], _angular_router__WEBPACK_IMPORTED_MODULE_3__["ActivatedRoute"], ngx_logger__WEBPACK_IMPORTED_MODULE_4__["NGXLogger"],
            _configuration_service__WEBPACK_IMPORTED_MODULE_5__["ConfigurationService"]])
    ], UploadImagesComponent);
    return UploadImagesComponent;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
/* TO-DO We are using the development environment also for production for an error in deployment */
var environment = {
    production: false,
    // PRODUCTION
    // important not to finish the URL with slash
    // apiEndpoint: 'https://muret.dlsi.ua.es/rest' // production
    // RECALL CHANGE the baseHRef in index.html
    // PRODUCTION
    // important not to finish the URL with slash
    // apiEndpoint: 'https://muret.dlsi.ua.es/rest' // production
    // apiEndpoint: 'https://muret.dlsi.ua.es/rest/muretapi' // production
    apiEndpoint: 'http://localhost:8080/muretapi',
};
/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");




if (_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
    .catch(function (err) { return console.error(err); });


/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! /Users/drizo/cmg/investigacion/software/github/repositorioHispamus/muret/angular/src/main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map