'use strict';

/* App Module */

var userAdminApp = angular.module('userAdminApp', [
    'ngRoute',
    'userAdminControllers',
    'userAdminFilters',
    'userAdminServices'
]);


userAdminApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/userLists', {
                templateUrl: 'partials/userlist.html',
                controller: 'UserListCtrl'
            }).
            when('/add', {
                templateUrl: 'partials/signup.html',
                controller: 'UserAddCtrl'
            }).
            when('/user/:id', {
                templateUrl: 'partials/userdetail.html',
                controller: 'UserDetailCtrl'
            }).
            otherwise({
                redirectTo: '/userLists'
            });
    }]);



