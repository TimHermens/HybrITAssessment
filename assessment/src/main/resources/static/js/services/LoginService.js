angular.module('myApp').factory('LoginService',
    ['$http', '$q', 'urls',
        function ($http, $q, urls) {

            var factory = {
                login: login
            };

            return factory;

            function login(id) {
                console.log('Fetching ForceUser with id :'+id);
                var deferred = $q.defer();
                $http.get(urls.API_FORCEUSER + id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully User with id :'+id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading user with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);