(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/*!**********************************************************!*\
  !*** ./src/$$_lazy_route_resource lazy namespace object ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

var map = {
	"../about/about.module": [
		"./src/app/about/about.module.ts"
	],
	"../home/home.module": [
		"./src/app/home/home.module.ts"
	]
};
function webpackAsyncContext(req) {
	var ids = map[req];
	if(!ids) {
		return Promise.resolve().then(function() {
			var e = new Error("Cannot find module '" + req + "'");
			e.code = 'MODULE_NOT_FOUND';
			throw e;
		});
	}
	return Promise.all(ids.slice(1).map(__webpack_require__.e)).then(function() {
		var id = ids[0];
		return __webpack_require__(id);
	});
}
webpackAsyncContext.keys = function webpackAsyncContextKeys() {
	return Object.keys(map);
};
webpackAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";
module.exports = webpackAsyncContext;

/***/ }),

/***/ "./src/app/about/about-routing.module.ts":
/*!***********************************************!*\
  !*** ./src/app/about/about-routing.module.ts ***!
  \***********************************************/
/*! exports provided: AboutRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AboutRoutingModule", function() { return AboutRoutingModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _components_about_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./components/about.component */ "./src/app/about/components/about.component.ts");




var routes = [
    {
        path: '',
        component: _components_about_component__WEBPACK_IMPORTED_MODULE_3__["AboutComponent"]
    }
];
var AboutRoutingModule = /** @class */ (function () {
    function AboutRoutingModule() {
    }
    AboutRoutingModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
        })
    ], AboutRoutingModule);
    return AboutRoutingModule;
}());



/***/ }),

/***/ "./src/app/about/about.module.ts":
/*!***************************************!*\
  !*** ./src/app/about/about.module.ts ***!
  \***************************************/
/*! exports provided: AboutModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AboutModule", function() { return AboutModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _components_about_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./components/about.component */ "./src/app/about/components/about.component.ts");
/* harmony import */ var _about_routing_module__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./about-routing.module */ "./src/app/about/about-routing.module.ts");





var AboutModule = /** @class */ (function () {
    function AboutModule() {
    }
    AboutModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            declarations: [
                _components_about_component__WEBPACK_IMPORTED_MODULE_3__["AboutComponent"],
            ],
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_2__["CommonModule"],
                _about_routing_module__WEBPACK_IMPORTED_MODULE_4__["AboutRoutingModule"]
            ]
        })
    ], AboutModule);
    return AboutModule;
}());



/***/ }),

/***/ "./src/app/about/components/about.component.css":
/*!******************************************************!*\
  !*** ./src/app/about/components/about.component.css ***!
  \******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".jumbotron {\n  background-color: transparent;\n}\n\n.jumbotron img {\n  width: 50%;\n  margin-bottom: 2vh;\n}\n\n.jumbotron p {\n  text-align: center;\n}\n\n#logos p {\n  text-align: center;\n}\n\n#logos img {\n  width: 80%;\n}\n\nfooter{\n  font-size: 10px;\n  position: fixed;\n  bottom: 2em;\n  right: 2em;\n}\n\nfooter p {\n  text-align: right;\n}\n\n#cite {\n  margin-bottom: 5em;\n  color: white;\n}\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvYWJvdXQvY29tcG9uZW50cy9hYm91dC5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0UsNkJBQTZCO0FBQy9COztBQUVBO0VBQ0UsVUFBVTtFQUNWLGtCQUFrQjtBQUNwQjs7QUFFQTtFQUNFLGtCQUFrQjtBQUNwQjs7QUFFQTtFQUNFLGtCQUFrQjtBQUNwQjs7QUFDQTtFQUNFLFVBQVU7QUFDWjs7QUFFQTtFQUNFLGVBQWU7RUFDZixlQUFlO0VBQ2YsV0FBVztFQUNYLFVBQVU7QUFDWjs7QUFFQTtFQUNFLGlCQUFpQjtBQUNuQjs7QUFFQTtFQUNFLGtCQUFrQjtFQUNsQixZQUFZO0FBQ2QiLCJmaWxlIjoic3JjL2FwcC9hYm91dC9jb21wb25lbnRzL2Fib3V0LmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIuanVtYm90cm9uIHtcbiAgYmFja2dyb3VuZC1jb2xvcjogdHJhbnNwYXJlbnQ7XG59XG5cbi5qdW1ib3Ryb24gaW1nIHtcbiAgd2lkdGg6IDUwJTtcbiAgbWFyZ2luLWJvdHRvbTogMnZoO1xufVxuXG4uanVtYm90cm9uIHAge1xuICB0ZXh0LWFsaWduOiBjZW50ZXI7XG59XG5cbiNsb2dvcyBwIHtcbiAgdGV4dC1hbGlnbjogY2VudGVyO1xufVxuI2xvZ29zIGltZyB7XG4gIHdpZHRoOiA4MCU7XG59XG5cbmZvb3RlcntcbiAgZm9udC1zaXplOiAxMHB4O1xuICBwb3NpdGlvbjogZml4ZWQ7XG4gIGJvdHRvbTogMmVtO1xuICByaWdodDogMmVtO1xufVxuXG5mb290ZXIgcCB7XG4gIHRleHQtYWxpZ246IHJpZ2h0O1xufVxuXG4jY2l0ZSB7XG4gIG1hcmdpbi1ib3R0b206IDVlbTtcbiAgY29sb3I6IHdoaXRlO1xufVxuIl19 */"

/***/ }),

/***/ "./src/app/about/components/about.component.html":
/*!*******************************************************!*\
  !*** ./src/app/about/components/about.component.html ***!
  \*******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"jumbotron\">\n  <p><img src=\"assets/images/muret_negativo.png\" alt=\"Logo MuRET\"></p>\n  <p>Music Recognition, encoding, and transcription</p>\n</div>\n<div class=\"row\" id=\"cite\">\n  <div class=\"offset-3 col-7\">\n    <h3>Cite as:</h3>\n    <p>\n      Rizo, D.; Calvo-Zaragoza, J.; Iñesta, J.M.<br/>\n      <strong>\"MuRET: a music recognition, encoding, and transcription tool\"</strong><br/>\n      Proceedings of the 5th International Conference on Digital Libraries for Musicology (DLfM'18), ISBN: 978-1-4503-6522-2, pp. 52--56, París, France (2018)\n    </p>\n  </div>\n</div>\n<div class=\"row\" id=\"logos\">\n  <div class=\"col-4\">\n    <p><img src=\"assets/images/uacolor.jpg\" alt=\"Logo UA\"></p>\n  </div>\n  <div class=\"col-4\">\n    <p><img src=\"assets/images/hispamus_negativo_sin_fondo.png\" alt=\"Logo MuRET\"></p>\n  </div>\n  <div class=\"col-4\">\n    <p><img src=\"assets/images/economiac.jpg\" alt=\"Logo MuRET\"></p>\n  </div>\n</div>\n<footer>\n  <p><a href=\"mailto:drizo [@] dlsi.ua.es \">©2018 Development: David Rizo</a></p>\n  <p><a href=\"mailto:drizo [@] dlsi.ua.es \">©2018 Backend classifiers: Jorge Calvo-Zaragoza</a></p>\n  <p><a href=\"mailto:lvf.lauravasallo [@] gmail.com\">©2018 Visual Design: Laura Vasallo</a></p>\n</footer>\n\n"

/***/ }),

/***/ "./src/app/about/components/about.component.ts":
/*!*****************************************************!*\
  !*** ./src/app/about/components/about.component.ts ***!
  \*****************************************************/
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
            template: __webpack_require__(/*! ./about.component.html */ "./src/app/about/components/about.component.html"),
            styles: [__webpack_require__(/*! ./about.component.css */ "./src/app/about/components/about.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], AboutComponent);
    return AboutComponent;
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
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _routing_app_routing_module__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./routing/app-routing.module */ "./src/app/routing/app-routing.module.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @ng-bootstrap/ng-bootstrap */ "./node_modules/@ng-bootstrap/ng-bootstrap/fesm5/ng-bootstrap.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var ngx_logger__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ngx-logger */ "./node_modules/ngx-logger/esm5/ngx-logger.js");
/* harmony import */ var _error_handling_global_error_handler_service__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./error-handling/global-error-handler.service */ "./src/app/error-handling/global-error-handler.service.ts");
/* harmony import */ var angular_resize_event__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! angular-resize-event */ "./node_modules/angular-resize-event/fesm5/angular-resize-event.js");
/* harmony import */ var _image_tool_bar_image_tool_bar_component__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./image-tool-bar/image-tool-bar.component */ "./src/app/image-tool-bar/image-tool-bar.component.ts");
/* harmony import */ var _ngrx_store__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! @ngrx/store */ "./node_modules/@ngrx/store/fesm5/store.js");
/* harmony import */ var _reducers__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./reducers */ "./src/app/reducers/index.ts");
/* harmony import */ var _layout_layout_module__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ./layout/layout.module */ "./src/app/layout/layout.module.ts");
/* harmony import */ var _about_about_module__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ./about/about.module */ "./src/app/about/about.module.ts");
/* harmony import */ var _home_home_module__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ./home/home.module */ "./src/app/home/home.module.ts");


















var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"],
                _image_tool_bar_image_tool_bar_component__WEBPACK_IMPORTED_MODULE_12__["ImageToolBarComponent"],
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__["BrowserModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_4__["HttpClientModule"],
                _angular_router__WEBPACK_IMPORTED_MODULE_8__["RouterModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_6__["ReactiveFormsModule"],
                _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_7__["NgbModule"],
                angular_resize_event__WEBPACK_IMPORTED_MODULE_11__["AngularResizedEventModule"],
                _layout_layout_module__WEBPACK_IMPORTED_MODULE_15__["LayoutModule"],
                _routing_app_routing_module__WEBPACK_IMPORTED_MODULE_5__["AppRoutingModule"],
                _about_about_module__WEBPACK_IMPORTED_MODULE_16__["AboutModule"],
                _home_home_module__WEBPACK_IMPORTED_MODULE_17__["HomeModule"],
                // LoggerModule.forRoot({serverLoggingUrl: '/api/logs', level: NgxLoggerLevel.DEBUG, serverLogLevel: NgxLoggerLevel.ERROR})
                ngx_logger__WEBPACK_IMPORTED_MODULE_9__["LoggerModule"].forRoot({ level: ngx_logger__WEBPACK_IMPORTED_MODULE_9__["NgxLoggerLevel"].DEBUG, serverLogLevel: ngx_logger__WEBPACK_IMPORTED_MODULE_9__["NgxLoggerLevel"].ERROR }),
                _ngrx_store__WEBPACK_IMPORTED_MODULE_13__["StoreModule"].forRoot(_reducers__WEBPACK_IMPORTED_MODULE_14__["reducers"], { metaReducers: _reducers__WEBPACK_IMPORTED_MODULE_14__["metaReducers"] })
            ],
            providers: [
                //RestClientService,
                ngx_logger__WEBPACK_IMPORTED_MODULE_9__["NGXLogger"],
                _error_handling_global_error_handler_service__WEBPACK_IMPORTED_MODULE_10__["GlobalErrorHandlerService"],
                { provide: _angular_core__WEBPACK_IMPORTED_MODULE_2__["ErrorHandler"], useClass: _error_handling_global_error_handler_service__WEBPACK_IMPORTED_MODULE_10__["GlobalErrorHandlerService"] },
            ],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/error-handling/global-error-handler.service.ts":
/*!****************************************************************!*\
  !*** ./src/app/error-handling/global-error-handler.service.ts ***!
  \****************************************************************/
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

/***/ "./src/app/home/components/dev/dev.component.css":
/*!*******************************************************!*\
  !*** ./src/app/home/components/dev/dev.component.css ***!
  \*******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2hvbWUvY29tcG9uZW50cy9kZXYvZGV2LmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/home/components/dev/dev.component.html":
/*!********************************************************!*\
  !*** ./src/app/home/components/dev/dev.component.html ***!
  \********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<p>\n  dev works!\n</p>\n"

/***/ }),

/***/ "./src/app/home/components/dev/dev.component.ts":
/*!******************************************************!*\
  !*** ./src/app/home/components/dev/dev.component.ts ***!
  \******************************************************/
/*! exports provided: DevComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "DevComponent", function() { return DevComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _services_session_data_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../../services/session-data.service */ "./src/app/services/session-data.service.ts");
/* harmony import */ var ngx_logger__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ngx-logger */ "./node_modules/ngx-logger/esm5/ngx-logger.js");
/* harmony import */ var _services_auth_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../../services/auth.service */ "./src/app/services/auth.service.ts");
/* harmony import */ var _services_crud_image_crud_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../../services/crud/image-crud.service */ "./src/app/services/crud/image-crud.service.ts");







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
            template: __webpack_require__(/*! ./dev.component.html */ "./src/app/home/components/dev/dev.component.html"),
            styles: [__webpack_require__(/*! ./dev.component.css */ "./src/app/home/components/dev/dev.component.css")]
        })
        // Used to speed up development
        ,
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_services_auth_service__WEBPACK_IMPORTED_MODULE_5__["AuthService"], _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"],
            _services_crud_image_crud_service__WEBPACK_IMPORTED_MODULE_6__["ImageCrudService"],
            _services_session_data_service__WEBPACK_IMPORTED_MODULE_3__["SessionDataService"],
            ngx_logger__WEBPACK_IMPORTED_MODULE_4__["NGXLogger"]])
    ], DevComponent);
    return DevComponent;
}());



/***/ }),

/***/ "./src/app/home/components/login/login.component.css":
/*!***********************************************************!*\
  !*** ./src/app/home/components/login/login.component.css ***!
  \***********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "input {\n  margin: 10px;\n}\n\nh2 {\n  margin-top: 20vh;\n}\n\n#login button {\n  margin-top: 10px;\n\n}\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvaG9tZS9jb21wb25lbnRzL2xvZ2luL2xvZ2luLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7RUFDRSxZQUFZO0FBQ2Q7O0FBRUE7RUFDRSxnQkFBZ0I7QUFDbEI7O0FBRUE7RUFDRSxnQkFBZ0I7O0FBRWxCIiwiZmlsZSI6InNyYy9hcHAvaG9tZS9jb21wb25lbnRzL2xvZ2luL2xvZ2luLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyJpbnB1dCB7XG4gIG1hcmdpbjogMTBweDtcbn1cblxuaDIge1xuICBtYXJnaW4tdG9wOiAyMHZoO1xufVxuXG4jbG9naW4gYnV0dG9uIHtcbiAgbWFyZ2luLXRvcDogMTBweDtcblxufVxuIl19 */"

/***/ }),

/***/ "./src/app/home/components/login/login.component.html":
/*!************************************************************!*\
  !*** ./src/app/home/components/login/login.component.html ***!
  \************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"row\" id=\"login\">\n  <div class=\"offset-4 col\">\n    <h2>LOGIN</h2>\n    <p>{{message}}</p>\n\n    <div *ngIf=\"!isLoggedIn()\">\n      <form name=\"form\" (ngSubmit)=\"f.form.valid && login()\" #f=\"ngForm\" novalidate>\n        <div [ngClass]=\"{ 'has-error': f.submitted && !username.valid }\">\n          <label>Username</label>\n          <input type=\"text\"\n                 name=\"username\" [(ngModel)]=\"model.username\"\n                 #username=\"ngModel\" required />\n          <div *ngIf=\"f.submitted\n              && !username.valid\">Username is required</div>\n        </div>\n        <div [ngClass]=\"{ 'has-error': f.submitted && !password.valid }\">\n          <label>Password</label>\n          <input type=\"password\"\n                 name=\"password\" [(ngModel)]=\"model.password\"\n                 #password=\"ngModel\" required />\n          <div *ngIf=\"f.submitted\n              && !password.valid\">Password is required</div>\n        </div>\n        <div class=\"offset-1\">\n          <button class=\"btn btn-primary\" [disabled]=\"loading\">Login</button>\n        </div>\n      </form>\n    </div>\n\n    <div *ngIf=\"isLoggedIn()\">\n      Logged in ...\n      <button class=\"btn btn-primary\" (click)=\"logout()\" >Logout</button>\n    </div>\n  </div>\n</div>\n<!--<p>\n  <button (click)=\"login()\"  *ngIf=\"!authService.isLoggedIn\">Login</button>\n  <button (click)=\"logout()\" *ngIf=\"authService.isLoggedIn\">Logout</button>\n</p>-->\n"

/***/ }),

/***/ "./src/app/home/components/login/login.component.ts":
/*!**********************************************************!*\
  !*** ./src/app/home/components/login/login.component.ts ***!
  \**********************************************************/
/*! exports provided: LoginComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoginComponent", function() { return LoginComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var ngx_logger__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ngx-logger */ "./node_modules/ngx-logger/esm5/ngx-logger.js");
/* harmony import */ var _services_auth_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../../services/auth.service */ "./src/app/services/auth.service.ts");





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
            template: __webpack_require__(/*! ./login.component.html */ "./src/app/home/components/login/login.component.html"),
            styles: [__webpack_require__(/*! ./login.component.css */ "./src/app/home/components/login/login.component.css")]
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

/***/ "./src/app/home/components/startup/startup.component.css":
/*!***************************************************************!*\
  !*** ./src/app/home/components/startup/startup.component.css ***!
  \***************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "#startup {\n  height: 100vh;\n  margin-top: 20vh;\n}\n#startuplogo {\n  margin-bottom: 5vh;\n}\n#startup img {\n  width: 100%;\n}\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvaG9tZS9jb21wb25lbnRzL3N0YXJ0dXAvc3RhcnR1cC5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0UsYUFBYTtFQUNiLGdCQUFnQjtBQUNsQjtBQUNBO0VBQ0Usa0JBQWtCO0FBQ3BCO0FBQ0E7RUFDRSxXQUFXO0FBQ2IiLCJmaWxlIjoic3JjL2FwcC9ob21lL2NvbXBvbmVudHMvc3RhcnR1cC9zdGFydHVwLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyIjc3RhcnR1cCB7XG4gIGhlaWdodDogMTAwdmg7XG4gIG1hcmdpbi10b3A6IDIwdmg7XG59XG4jc3RhcnR1cGxvZ28ge1xuICBtYXJnaW4tYm90dG9tOiA1dmg7XG59XG4jc3RhcnR1cCBpbWcge1xuICB3aWR0aDogMTAwJTtcbn1cbiJdfQ== */"

/***/ }),

/***/ "./src/app/home/components/startup/startup.component.html":
/*!****************************************************************!*\
  !*** ./src/app/home/components/startup/startup.component.html ***!
  \****************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"row\" id=\"startup\">\n  <div class=\"col-4 offset-4\">\n    <div class=\"row\">\n      <div class=\"col\" id=\"startuplogo\">\n        <img src=\"assets/images/muret_negativo.png\" alt=\"Logo\">\n      </div>\n    </div>\n    <div class=\"row\" id=\"startupbuttons\">\n      <div class=\"col-6\">\n        <a routerLinkActive=\"active\" routerLink=\"/newproject\">\n          <img src=\"assets/images/start_newproject.png\" alt=\"New Project\">\n        </a>\n      </div>\n      <div class=\"col-6\">\n        <a routerLinkActive=\"active\" routerLink=\"/projects\">\n          <img src=\"assets/images/start_openproject.png\" alt=\"Open Project\">\n        </a>\n      </div>\n    </div>\n  </div>\n</div>\n\n\n"

/***/ }),

/***/ "./src/app/home/components/startup/startup.component.ts":
/*!**************************************************************!*\
  !*** ./src/app/home/components/startup/startup.component.ts ***!
  \**************************************************************/
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
            template: __webpack_require__(/*! ./startup.component.html */ "./src/app/home/components/startup/startup.component.html"),
            styles: [__webpack_require__(/*! ./startup.component.css */ "./src/app/home/components/startup/startup.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], StartupComponent);
    return StartupComponent;
}());



/***/ }),

/***/ "./src/app/home/home-routing.module.ts":
/*!*********************************************!*\
  !*** ./src/app/home/home-routing.module.ts ***!
  \*********************************************/
/*! exports provided: HomeRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "HomeRoutingModule", function() { return HomeRoutingModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _components_login_login_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./components/login/login.component */ "./src/app/home/components/login/login.component.ts");




var routes = [
    {
        path: 'login',
        component: _components_login_login_component__WEBPACK_IMPORTED_MODULE_3__["LoginComponent"]
    }
];
var HomeRoutingModule = /** @class */ (function () {
    function HomeRoutingModule() {
    }
    HomeRoutingModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
        })
    ], HomeRoutingModule);
    return HomeRoutingModule;
}());



/***/ }),

/***/ "./src/app/home/home.module.ts":
/*!*************************************!*\
  !*** ./src/app/home/home.module.ts ***!
  \*************************************/
/*! exports provided: HomeModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "HomeModule", function() { return HomeModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _components_startup_startup_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./components/startup/startup.component */ "./src/app/home/components/startup/startup.component.ts");
/* harmony import */ var _components_login_login_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./components/login/login.component */ "./src/app/home/components/login/login.component.ts");
/* harmony import */ var _components_dev_dev_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./components/dev/dev.component */ "./src/app/home/components/dev/dev.component.ts");
/* harmony import */ var _home_routing_module__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./home-routing.module */ "./src/app/home/home-routing.module.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");








var HomeModule = /** @class */ (function () {
    function HomeModule() {
    }
    HomeModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            declarations: [
                _components_startup_startup_component__WEBPACK_IMPORTED_MODULE_3__["StartupComponent"],
                _components_login_login_component__WEBPACK_IMPORTED_MODULE_4__["LoginComponent"],
                _components_dev_dev_component__WEBPACK_IMPORTED_MODULE_5__["DevComponent"],
            ],
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_2__["CommonModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_7__["FormsModule"],
                _home_routing_module__WEBPACK_IMPORTED_MODULE_6__["HomeRoutingModule"]
            ]
        })
    ], HomeModule);
    return HomeModule;
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

/***/ "./src/app/layout/components/messages/message.service.ts":
/*!***************************************************************!*\
  !*** ./src/app/layout/components/messages/message.service.ts ***!
  \***************************************************************/
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

/***/ "./src/app/layout/components/messages/messages.component.css":
/*!*******************************************************************!*\
  !*** ./src/app/layout/components/messages/messages.component.css ***!
  \*******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2xheW91dC9jb21wb25lbnRzL21lc3NhZ2VzL21lc3NhZ2VzLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/layout/components/messages/messages.component.html":
/*!********************************************************************!*\
  !*** ./src/app/layout/components/messages/messages.component.html ***!
  \********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div *ngIf=\"messageService.messages.length\">\n\n  <h2>Messages</h2>\n  <button class=\"clear\"\n          (click)=\"messageService.clear()\">clear</button>\n  <div *ngFor='let message of messageService.messages'> {{message}} </div>\n\n</div>\n"

/***/ }),

/***/ "./src/app/layout/components/messages/messages.component.ts":
/*!******************************************************************!*\
  !*** ./src/app/layout/components/messages/messages.component.ts ***!
  \******************************************************************/
/*! exports provided: MessagesComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MessagesComponent", function() { return MessagesComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _message_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./message.service */ "./src/app/layout/components/messages/message.service.ts");



var MessagesComponent = /** @class */ (function () {
    function MessagesComponent(messageService) {
        this.messageService = messageService;
    }
    MessagesComponent.prototype.ngOnInit = function () {
    };
    MessagesComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-messages',
            template: __webpack_require__(/*! ./messages.component.html */ "./src/app/layout/components/messages/messages.component.html"),
            styles: [__webpack_require__(/*! ./messages.component.css */ "./src/app/layout/components/messages/messages.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_message_service__WEBPACK_IMPORTED_MODULE_2__["MessageService"]])
    ], MessagesComponent);
    return MessagesComponent;
}());



/***/ }),

/***/ "./src/app/layout/components/ui/footer/footer.component.css":
/*!******************************************************************!*\
  !*** ./src/app/layout/components/ui/footer/footer.component.css ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2xheW91dC9jb21wb25lbnRzL3VpL2Zvb3Rlci9mb290ZXIuY29tcG9uZW50LmNzcyJ9 */"

/***/ }),

/***/ "./src/app/layout/components/ui/footer/footer.component.html":
/*!*******************************************************************!*\
  !*** ./src/app/layout/components/ui/footer/footer.component.html ***!
  \*******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<nav class=\"navbar navbar-dark bg-dark mt-5 fixed-bottom navbar-collapse\">\n  <div id=\"messages\">\n    <app-messages></app-messages>\n  </div>\n</nav>\n"

/***/ }),

/***/ "./src/app/layout/components/ui/footer/footer.component.ts":
/*!*****************************************************************!*\
  !*** ./src/app/layout/components/ui/footer/footer.component.ts ***!
  \*****************************************************************/
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
            template: __webpack_require__(/*! ./footer.component.html */ "./src/app/layout/components/ui/footer/footer.component.html"),
            styles: [__webpack_require__(/*! ./footer.component.css */ "./src/app/layout/components/ui/footer/footer.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], FooterComponent);
    return FooterComponent;
}());



/***/ }),

/***/ "./src/app/layout/components/ui/header/header.component.css":
/*!******************************************************************!*\
  !*** ./src/app/layout/components/ui/header/header.component.css ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".navbar-toggler-icon {\n  background-image: url(\"data:image/svg+xml;charset=utf8,%3Csvg viewBox='0 0 32 32' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath stroke='rgba(255,255,255, 1)' stroke-width='2' stroke-linecap='round' stroke-miterlimit='10' d='M4 8h24M4 16h24M4 24h24'/%3E%3C/svg%3E\");\n}\n\nnav {\n  margin-top: 25px;\n  margin-bottom: 25px;\n}\n\n\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvbGF5b3V0L2NvbXBvbmVudHMvdWkvaGVhZGVyL2hlYWRlci5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0UsdVFBQXVRO0FBQ3pROztBQUVBO0VBQ0UsZ0JBQWdCO0VBQ2hCLG1CQUFtQjtBQUNyQiIsImZpbGUiOiJzcmMvYXBwL2xheW91dC9jb21wb25lbnRzL3VpL2hlYWRlci9oZWFkZXIuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi5uYXZiYXItdG9nZ2xlci1pY29uIHtcbiAgYmFja2dyb3VuZC1pbWFnZTogdXJsKFwiZGF0YTppbWFnZS9zdmcreG1sO2NoYXJzZXQ9dXRmOCwlM0Nzdmcgdmlld0JveD0nMCAwIDMyIDMyJyB4bWxucz0naHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmcnJTNFJTNDcGF0aCBzdHJva2U9J3JnYmEoMjU1LDI1NSwyNTUsIDEpJyBzdHJva2Utd2lkdGg9JzInIHN0cm9rZS1saW5lY2FwPSdyb3VuZCcgc3Ryb2tlLW1pdGVybGltaXQ9JzEwJyBkPSdNNCA4aDI0TTQgMTZoMjRNNCAyNGgyNCcvJTNFJTNDL3N2ZyUzRVwiKTtcbn1cblxubmF2IHtcbiAgbWFyZ2luLXRvcDogMjVweDtcbiAgbWFyZ2luLWJvdHRvbTogMjVweDtcbn1cblxuXG4iXX0= */"

/***/ }),

/***/ "./src/app/layout/components/ui/header/header.component.html":
/*!*******************************************************************!*\
  !*** ./src/app/layout/components/ui/header/header.component.html ***!
  \*******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<nav class=\"navbar navbar-light offset-1\">\n  <div ngbDropdown class=\"d-inline-block\">\n    <button class=\"navbar-toggler hidden-sm-up\" id=\"dropdownBasic1\" ngbDropdownToggle>\n      <span class=\"navbar-toggler-icon\"></span>\n    </button>\n    <div ngbDropdownMenu aria-labelledby=\"dropdownBasic1\">\n      <a class=\"dropdown-item nav-link\" routerLinkActive=\"active\" routerLink=\"startup\">Home</a>\n      <a class=\"dropdown-item nav-link\" [hidden]=\"authenticated()\" routerLink=\"login\">Login</a>\n      <a class=\"dropdown-item nav-link\" [hidden]=\"!authenticated()\" routerLink=\"login\">Logout</a>\n      <a class=\"dropdown-item nav-link\" [hidden]=\"!authenticated()\" routerLink=\"export\">Export training sets</a>\n      <a class=\"dropdown-item nav-link\" [hidden]=\"!authenticated()\" routerLink=\"preferences\">Preferences</a>\n      <a class=\"dropdown-item nav-link\" routerLinkActive=\"active\" routerLink=\"about\">About</a>\n      <a class=\"dropdown-item nav-link\" href=\"https://github.com/HISPAMUS/muret\" target=\"_blank\">\n        <i class=\"fa fa-github\"></i>\n      </a>\n    </div>\n    <a [hidden]=\"hideLogo()\" class=\"navbar-brand\" routerLink=\"startup\">\n      <img src=\"assets/images/muret.png\" alt=\"Logo MuRET\">\n    </a>\n    <a routerLink=\"dev\">DEV</a>&nbsp;\n\n  </div>\n  <div ng-if=\"authenticated()\" class=\"navbar-right\">\n    {{getUserName()}}\n  </div>\n</nav>\n"

/***/ }),

/***/ "./src/app/layout/components/ui/header/header.component.ts":
/*!*****************************************************************!*\
  !*** ./src/app/layout/components/ui/header/header.component.ts ***!
  \*****************************************************************/
/*! exports provided: HeaderComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "HeaderComponent", function() { return HeaderComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _services_auth_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../../../services/auth.service */ "./src/app/services/auth.service.ts");




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
            template: __webpack_require__(/*! ./header.component.html */ "./src/app/layout/components/ui/header/header.component.html"),
            styles: [__webpack_require__(/*! ./header.component.css */ "./src/app/layout/components/ui/header/header.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_services_auth_service__WEBPACK_IMPORTED_MODULE_3__["AuthService"], _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"]])
    ], HeaderComponent);
    return HeaderComponent;
}());



/***/ }),

/***/ "./src/app/layout/components/ui/layout/layout.component.css":
/*!******************************************************************!*\
  !*** ./src/app/layout/components/ui/layout/layout.component.css ***!
  \******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "header {\n}\n\n#mainContent {\n}\n\nfooter {\n}\n\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvbGF5b3V0L2NvbXBvbmVudHMvdWkvbGF5b3V0L2xheW91dC5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0FBQ0E7O0FBRUE7QUFDQTs7QUFFQTtBQUNBIiwiZmlsZSI6InNyYy9hcHAvbGF5b3V0L2NvbXBvbmVudHMvdWkvbGF5b3V0L2xheW91dC5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiaGVhZGVyIHtcbn1cblxuI21haW5Db250ZW50IHtcbn1cblxuZm9vdGVyIHtcbn1cblxuIl19 */"

/***/ }),

/***/ "./src/app/layout/components/ui/layout/layout.component.html":
/*!*******************************************************************!*\
  !*** ./src/app/layout/components/ui/layout/layout.component.html ***!
  \*******************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<header>\n  <app-header></app-header>\n</header>\n<div id=\"mainContent\" class=\"container-fluid\">\n  <ng-content></ng-content>\n</div>\n<footer>\n  <app-footer></app-footer>\n</footer>\n"

/***/ }),

/***/ "./src/app/layout/components/ui/layout/layout.component.ts":
/*!*****************************************************************!*\
  !*** ./src/app/layout/components/ui/layout/layout.component.ts ***!
  \*****************************************************************/
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
            template: __webpack_require__(/*! ./layout.component.html */ "./src/app/layout/components/ui/layout/layout.component.html"),
            styles: [__webpack_require__(/*! ./layout.component.css */ "./src/app/layout/components/ui/layout/layout.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], LayoutComponent);
    return LayoutComponent;
}());



/***/ }),

/***/ "./src/app/layout/layout.module.ts":
/*!*****************************************!*\
  !*** ./src/app/layout/layout.module.ts ***!
  \*****************************************/
/*! exports provided: LayoutModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LayoutModule", function() { return LayoutModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @ng-bootstrap/ng-bootstrap */ "./node_modules/@ng-bootstrap/ng-bootstrap/fesm5/ng-bootstrap.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _components_ui_layout_layout_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./components/ui/layout/layout.component */ "./src/app/layout/components/ui/layout/layout.component.ts");
/* harmony import */ var _components_ui_header_header_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./components/ui/header/header.component */ "./src/app/layout/components/ui/header/header.component.ts");
/* harmony import */ var _components_ui_footer_footer_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./components/ui/footer/footer.component */ "./src/app/layout/components/ui/footer/footer.component.ts");
/* harmony import */ var _components_messages_messages_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./components/messages/messages.component */ "./src/app/layout/components/messages/messages.component.ts");









var LayoutModule = /** @class */ (function () {
    function LayoutModule() {
    }
    LayoutModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_2__["CommonModule"], _ng_bootstrap_ng_bootstrap__WEBPACK_IMPORTED_MODULE_3__["NgbModule"], _angular_router__WEBPACK_IMPORTED_MODULE_4__["RouterModule"] // important to include the router module here because routes do not work otherwise
            ],
            exports: [_components_ui_layout_layout_component__WEBPACK_IMPORTED_MODULE_5__["LayoutComponent"]],
            declarations: [_components_ui_layout_layout_component__WEBPACK_IMPORTED_MODULE_5__["LayoutComponent"], _components_ui_header_header_component__WEBPACK_IMPORTED_MODULE_6__["HeaderComponent"], _components_ui_footer_footer_component__WEBPACK_IMPORTED_MODULE_7__["FooterComponent"],
                _components_messages_messages_component__WEBPACK_IMPORTED_MODULE_8__["MessagesComponent"]]
        })
    ], LayoutModule);
    return LayoutModule;
}());



/***/ }),

/***/ "./src/app/reducers/index.ts":
/*!***********************************!*\
  !*** ./src/app/reducers/index.ts ***!
  \***********************************/
/*! exports provided: reducers, metaReducers */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "reducers", function() { return reducers; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "metaReducers", function() { return metaReducers; });
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../../environments/environment */ "./src/environments/environment.ts");

var reducers = {};
var metaReducers = !_environments_environment__WEBPACK_IMPORTED_MODULE_0__["environment"].production ? [] : [];


/***/ }),

/***/ "./src/app/routing/app-routing.module.ts":
/*!***********************************************!*\
  !*** ./src/app/routing/app-routing.module.ts ***!
  \***********************************************/
/*! exports provided: AppRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppRoutingModule", function() { return AppRoutingModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");



var routes = [
    {
        path: 'about',
        loadChildren: '../about/about.module#AboutModule'
    },
    {
        path: 'login',
        loadChildren: '../home/home.module#HomeModule'
    },
    { path: '', pathMatch: 'full', redirectTo: 'startup' },
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
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../environments/environment */ "./src/environments/environment.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var ngx_logger__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ngx-logger */ "./node_modules/ngx-logger/esm5/ngx-logger.js");
/* harmony import */ var _session_data_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./session-data.service */ "./src/app/services/session-data.service.ts");






var AuthService = /** @class */ (function () {
    function AuthService(http, logger, sessionDataService) {
        this.http = http;
        this.logger = logger;
        this.sessionDataService = sessionDataService;
        this.SESSION_USER_STORAGE = 'token';
        this.urlLogin = _environments_environment__WEBPACK_IMPORTED_MODULE_2__["environment"].apiEndpoint + '/auth/login'; // URL to web api
        this.urlAuthenticatedUser = _environments_environment__WEBPACK_IMPORTED_MODULE_2__["environment"].apiEndpoint + '/auth/user';
        this.urlUser = _environments_environment__WEBPACK_IMPORTED_MODULE_2__["environment"].apiEndpoint + '/user';
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
        var headers = new _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpHeaders"]({
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
        //this.sessionDataService.user = Object.assign(new User(), u);
        this.sessionDataService.user = Object.assign({}, u);
        sessionStorage.setItem(this.SESSION_USER_STORAGE, btoa(this.sessionDataService.user.username));
        this.logger.debug('ID: ' + this.sessionDataService.user.id);
    };
    AuthService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
            providedIn: 'root'
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClient"],
            ngx_logger__WEBPACK_IMPORTED_MODULE_4__["NGXLogger"],
            _session_data_service__WEBPACK_IMPORTED_MODULE_5__["SessionDataService"]])
    ], AuthService);
    return AuthService;
}());



/***/ }),

/***/ "./src/app/services/crud/image-crud.service.ts":
/*!*****************************************************!*\
  !*** ./src/app/services/crud/image-crud.service.ts ***!
  \*****************************************************/
/*! exports provided: ImageCrudService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ImageCrudService", function() { return ImageCrudService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var ngx_logger__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ngx-logger */ "./node_modules/ngx-logger/esm5/ngx-logger.js");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../../environments/environment */ "./src/environments/environment.ts");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
/* harmony import */ var _rest_client_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../rest-client.service */ "./src/app/services/rest-client.service.ts");







var ImageCrudService = /** @class */ (function () {
    function ImageCrudService(logger, restClientService) {
        this.logger = logger;
        this.restClientService = restClientService;
        this.urlImage = _environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].apiEndpoint + '/imagecrud';
        this.imageBlobsMap = new Map();
    }
    ImageCrudService.prototype.getImage$ = function (id) {
        return this.restClientService.httpGet$(this.urlImage + '/get/' + id, 'Fetching image with id ' + id);
    };
    ImageCrudService.prototype.getImageBlobs = function (image_id) {
        if (this.imageBlobsMap.has(image_id)) {
            return this.imageBlobsMap.get(image_id);
        }
        else {
            //const imageBlobs: ImageBlobs = {};TODO
            this.imageBlobsMap.set(image_id, null);
            //TODO return imageBlobs;
            return null;
        }
    };
    ImageCrudService.prototype.getMasterImage$ = function (imageID) {
        var _this = this;
        var blob = this.getImageBlobs(imageID).master;
        if (blob) {
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_4__["of"])(blob);
        }
        else {
            return this.restClientService.httpGetBlob(this.urlImage + '/master/' + imageID, 'Fetching master image ' + imageID).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["tap"])(function (next) { _this.getImageBlobs(imageID).master = next; }));
        }
    };
    ImageCrudService.prototype.getThumbnailImage$ = function (imageID) {
        var _this = this;
        var blob = this.getImageBlobs(imageID).thumbnail;
        if (blob) {
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_4__["of"])(blob);
        }
        else {
            return this.restClientService.httpGetBlob(this.urlImage + '/thumbnail/' + imageID, 'Fetching thumbnail image ' + imageID).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["tap"])(function (next) { _this.getImageBlobs(imageID).thumbnail = next; }));
        }
    };
    ImageCrudService.prototype.getPreviewImage$ = function (imageID) {
        var _this = this;
        var blob = this.getImageBlobs(imageID).thumbnail;
        if (blob) {
            return Object(rxjs__WEBPACK_IMPORTED_MODULE_4__["of"])(blob);
        }
        else {
            return this.restClientService.httpGetBlob(this.urlImage + '/preview/' + imageID, 'Fetching preview image ' + imageID).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_5__["tap"])(function (next) { _this.getImageBlobs(imageID).thumbnail = next; }));
        }
    };
    ImageCrudService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
            providedIn: 'root'
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [ngx_logger__WEBPACK_IMPORTED_MODULE_2__["NGXLogger"],
            _rest_client_service__WEBPACK_IMPORTED_MODULE_6__["RestClientService"]])
    ], ImageCrudService);
    return ImageCrudService;
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
        return this.http.put(url, body, this.authService.getHttpAuthOptions()).
            pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_6__["catchError"])(this.dialogService.handleError(debugMessage, null)));
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
    // TODO Deberíamos ver el patrón redux (https://academia-binaria.com/el-patron-redux-con-ngrx-en-angular/)
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
    /**
     * It replaces the user lazily loaded project for the one as parameter
     * @param loadedProject
     */
    SessionDataService.prototype.loadProject = function (loadedProject) {
        //const newLoadedProject = Object.assign(new Project(), loadedProject);
        var newLoadedProject = Object.assign({}, loadedProject);
        var itemIndex = this._user.projectsCreated.findIndex(function (item) { return item.id == loadedProject.id; });
        if (itemIndex != -1) {
            this.currentProject = this._user.projectsCreated[itemIndex] = newLoadedProject;
        }
        else {
            var itemIndex_1 = this._user.permissions.findIndex(function (item) { return item.project.id == loadedProject.id; });
            if (itemIndex_1 != -1) {
                this.currentProject = this._user.permissions[itemIndex_1].project = newLoadedProject;
            }
            else {
                throw new Error('Cannot find a project with id=' + loadedProject.id);
            }
        }
    };
    SessionDataService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
            providedIn: 'root'
        })
        // TODO Deberíamos ver el patrón redux (https://academia-binaria.com/el-patron-redux-con-ngrx-en-angular/)
    ], SessionDataService);
    return SessionDataService;
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