angular.module('myApp').controller('LoginController', 
    ['$scope','LoginService','$rootScope', function($scope, LoginService, $rootScope) {
        console.log("testing");

        var self = this;

        self.login = function(id) {
            console.log(id);
            console.log(LoginService);
            LoginService.login(id).then(
                function (user) {
                    self.user = user;
                    $rootScope.$broadcast('userLoggedInEvent', { data: user });
                    console.log(user);
                },
                function (errResponse) {
                    console.error('Error while loading user with id ' + id + ', Error :' + errResponse.data);
                }
            );
        };
    }
    ]);