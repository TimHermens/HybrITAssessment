angular.module('myApp').factory('OrdersService',
    ['$http', '$q', 'urls',
        function ($http, $q, urls) {

            var factory = {
                orders: orders
            };

            return factory;

            function orders() {
                console.log('Fetching orders');
                var deferred = $q.defer();
                $http.get(urls.API_ORDERS)
                    .then(
                        function (response) {
                            console.log('Fetched successfully orders');
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading orders');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
            
            function order(order) {
                console.log('Sending order');
                var deferred = $q.defer();
                $http.post(urls.API_ORDER, order)
                    .then(
                        function (response) {
                            console.log('Order sent succesfully');
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while sending order');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);