angular.module('myApp').controller('NewProductController', 
    ['$scope', 'ProductsService', function($scope, ProductsService) {
        console.log("newProductController");

        var self = this;
        
        self.product = {};
        self.crystals = [];
        
        self.crystalIndex = 0;
        
        self.onlyNumbers = /^\d+([,.]\d+)?$/;
        self.onlyIntegers = /^\d+$/;
        
        self.submit = function() {
                var crystalIndex = parseInt(self.crystalIndex);
                var crystal = self.crystals[crystalIndex];
                console.log(crystal);
                self.product.product.kaiburrCrystal = crystal;
                console.log(self.product);
                ProductsService.createProduct(self.product).then(
                        function (response) {
                            self.reset();
                            console.log(response);
                            alert('Product created successfully');
                        },
                        function (errResponse) {
                            console.error('Error while creating new product, Error :' + errResponse.data);
                        }
                );
        };
        
        self.getCrystals = function() {
                ProductsService.crystals().then(
                        function (crystals) {
                            self.crystals = crystals;
                            console.log(crystals);
                        },
                        function (errResponse) {
                            console.error('Error while loading crystals, Error :' + errResponse.data);
                        }
                );
        };
        
        self.getCrystals = function() {
                ProductsService.crystals().then(
                        function (crystals) {
                            self.crystals = crystals;
                            console.log(crystals);
                        },
                        function (errResponse) {
                            console.error('Error while loading crystals, Error :' + errResponse.data);
                        }
                );
        };
        
        self.reset = function() {
                self.product = {};
                $scope.productForm.$setPristine();
                self.crystalIndex = undefined;
        };
        
        self.getCrystals();
    }
    ]);