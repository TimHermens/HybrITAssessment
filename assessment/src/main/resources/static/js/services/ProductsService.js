angular.module('myApp').factory('ProductsService',
    ['$http', '$q', 'urls',
        function ($http, $q, urls) {

            var factory = {
                inventory: inventory,
                order: order,
                crystals: crystals,
                createProduct: createProduct
            };

            return factory;

            function inventory() {
                console.log('Fetching product inventory');
                var deferred = $q.defer();
                $http.get(urls.API_INVENTORY)
                    .then(
                        function (response) {
                            console.log('Fetched successfully product inventory');
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading product inventory');
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
            
            function crystals() {
                console.log('Fetching crystals');
                var deferred = $q.defer();
                $http.get(urls.API_CRYSTALS)
                    .then(
                        function (response) {
                            console.log('Fetched successfully crystals');
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading crystals');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
            
            function createProduct(product) {
                console.log('Creating product');
                var deferred = $q.defer();
                $http.post(urls.API_PRODUCT, product)
                    .then(
                        function (response) {
                            console.log('Product created succesfully');
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while creating product');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);