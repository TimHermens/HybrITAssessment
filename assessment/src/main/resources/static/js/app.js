var app = angular.module('myApp',['ngRoute']);

app.constant('urls', {
    BASE: 'http://localhost:8080',
    API_FORCEUSER: 'http://localhost:8080/rest/forceuser/'
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
                .otherwise({
                    redirectTo: '/'
                });
    
}]);

//app.controller('MainController', function ($scope, $location) {
//    $scope.text = "ok";
//    console.log("testing");
//});