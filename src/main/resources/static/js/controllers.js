'use strict';

var phonecatApp = angular.module('phonecatApp', []);

phonecatApp.controller('PhoneListCtrl', ['$scope', '$http', function($scope, $http) {

    $http.get('/phones').success(function(data) {
        $scope.phones = data;
    });

    $scope.orderProp = 'age';

    $scope.name = "World";
}]);