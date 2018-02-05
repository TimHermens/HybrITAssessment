angular.module('myApp').controller('OrderController', 
    ['$scope', 'OrdersService', function($scope, OrdersService) {
        console.log("orderController");

        var self = this;
        
        self.orders = [];

        self.getOrders = function() {
                OrdersService.orders().then(
                        function (orders) {
                            self.orders = orders;
                            console.log(orders);
                        },
                        function (errResponse) {
                            console.error('Error while loading orders, Error :' + errResponse.data);
                        }
                );
        };
        
        self.getOrders();
    }
    ]);