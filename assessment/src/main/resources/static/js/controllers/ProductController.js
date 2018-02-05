angular.module('myApp').controller('ProductController', 
    ['$scope', 'ProductsService','LoginService', function($scope, ProductsService, LoginService) {
        console.log("productController");

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

        self.orderProduct = function(product, inStock) {
                if (inStock > 0) {
                        console.log("ordering");
                        console.log(product);
                        var Order = {
                                forceUser: LoginService.getUser(), 
                                orderLines:[
                                        {quantity: 1, unitPrice: product.price, product: product}
                                ]};
                        ProductsService.order(JSON.stringify(Order)).then(
                                function (response) {
                                    console.log(response.data.message);
                                    console.log(response.data.productNames);
                                    alert(response.data.message + ". Ordered products: " + response.data.productNames.join(', ') + ".");
                                    self.getInventory(); // update inventory
                                },
                                function (errResponse) {
                                    console.error('Error' + errResponse.data);
                                }
                        );
                }
                else {
                        alert('Out of stock!');
                }
        };
        
        self.getInventory();
    }
    ]);