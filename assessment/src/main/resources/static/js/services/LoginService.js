angular.module('myApp').factory('LoginService',
    ['$http', '$q', 'urls','$localStorage',
        function ($http, $q, urls, $localStorage) {

            var factory = {
                login: login,
                getUser: getUser
            };

            return factory;

            function getUser() {
                    return $localStorage.user;
            }

            function login(id) {
                console.log('Fetching ForceUser with id :'+id);
                var deferred = $q.defer();
                $http.get(urls.API_FORCEUSER + id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully User with id :'+id);
                            $localStorage.user = response.data;
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