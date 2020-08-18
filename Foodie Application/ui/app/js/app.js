var app = angular.module('myApp', []);
app.config(['$httpProvider', function($httpProvider) {
    $httpProvider.defaults.timeout = 20000;
}])
app.controller('myCtrl', function($scope, $http) {
    this.retrieve = function() {
    $http.get('http://127.0.0.1:8302/api/stock-service/rest/foodPrice/' + $scope.name)
    .then(function (response) {
        console.log('inside'+ response);
        $scope.price = response.data;
    }, function (response) {
        console.log('came here');
    });
    }


    this.add = function() {
        var message = {
            userName: $scope.name
        }
        $http.post('http://127.0.0.1:8302/api/db-service/rest/db/add', message)
            .then(function(response) {
                $scope.user = response.data;
            }, function(response) {
                console.log('error..');
            });
    }
});