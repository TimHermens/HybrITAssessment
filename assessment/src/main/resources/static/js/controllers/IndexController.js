angular.module('myApp').controller('IndexController', 
    ['$scope','$http', function($scope,$http) {
        console.log("index");

        var self = this;

        self.userIsPadawan = false;
        self.userIsJediMaster = false;
        
        $scope.$on('userLoggedInEvent', function(event, data) {
            if(data.data.title === "Padawan") {
                self.userIsPadawan = true;
                self.userIsJediMaster = false;
            }
            else if(data.data.title === "Jedi master") {
                self.userIsJediMaster = true;
                self.userIsPadawan = false;
            }
        });
        
        $http.get("http://localhost:8080/rest/products")
            .then(
                function (response) {
                    console.log('Fetched successfully all products');
                    console.log(response.data);
                },
                function (errResponse) {
                    console.error('Error');
                }
            );
    }
    ]);