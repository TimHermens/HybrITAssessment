var app = angular.module('myApp',['ngRoute','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080',
    API_FORCEUSER: 'http://localhost:8080/rest/forceuser/',
    API_PRODUCTS: 'http://localhost:8080/rest/products',
    API_INVENTORY: 'http://localhost:8080/rest/inventory',
    API_ORDER: 'http://localhost:8080/rest/order',
    API_ORDERS: 'http://localhost:8080/rest/orders',
    API_CRYSTALS: 'http://localhost:8080/rest/crystals',
    API_PRODUCT: 'http://localhost:8080/rest/product'
});

app.config(['$routeProvider','$locationProvider', function($routeProvider, $locationProvider) {
        $locationProvider.hashPrefix('');
        $locationProvider.html5Mode(true);
        $routeProvider
                .when('/', {
                        templateUrl: 'views/login.html',
                        controller: 'LoginController',
                        controllerAs: 'ctrl'
                })
                .when('/products', {
                        templateUrl: 'views/products.html',
                        controller: 'ProductController',
                        controllerAs: 'ctrl'
                })
                .when('/inventory', {
                        templateUrl: 'views/inventory.html',
                        controller: 'InventoryController',
                        controllerAs: 'ctrl'
                })
                .when('/orders', {
                        templateUrl: 'views/orders.html',
                        controller: 'OrderController',
                        controllerAs: 'ctrl'
                })
                .when('/newproduct', {
                        templateUrl: 'views/newproduct.html',
                        controller: 'NewProductController',
                        controllerAs: 'ctrl'
                })
                .otherwise({
                    redirectTo: '/'
                });
    
}]);

//app.controller('MainController', function ($scope, $location) {
//    $scope.text = "ok";
//    console.log("testing");
//});