angular.module('myApp').controller('InventoryController', 
    ['$scope', 'ProductsService', function($scope, ProductsService) {
        console.log("inventoryController");

        var self = this;
        
        self.inventory = [];

        self.getInventory = function() {
                ProductsService.inventory().then(
                        function (inventory) {
                            self.inventory = inventory;
                            console.log(inventory);
                        },
                        function (errResponse) {
                            console.error('Error while loading product inventory, Error :' + errResponse.data);
                        }
                );
        };
        
        self.getInventory();
    }
    ]);