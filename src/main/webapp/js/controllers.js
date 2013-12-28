'use strict';

/* Controllers */

var userAdminControllers = angular.module('userAdminControllers', []);

userAdminControllers.controller('UserListCtrl', ['$scope', 'RESTBackend',
    function($scope, RESTBackend) {
        $scope.users = RESTBackend.query();
        $scope.editUser = function (user) {
            user.isDirty = true;
        }
        $scope.saveUser = function (user) {
            RESTBackend.update({ id:user.id }, user);
            user.isDirty = undefined;
        }
        $scope.deleteUser = function (index) {
            var id = $scope.users[index].id;
                RESTBackend.delete({},{'id': id}); // Calls: DELETE /api/customer/Id
            $scope.users.splice(index, 1);
        }
    }]);

userAdminControllers.controller('UserAddCtrl', ['$scope','RESTBackend',
    function($scope, RESTBackend) {
        $scope.addUser = function() {
            RESTBackend.save($scope.customer);
            $scope.result = "SUCCESSFULLY ADDED!";
        }
    }]);

userAdminControllers.controller('UserDetailCtrl', ['$scope', '$routeParams', 'RESTBackend',
    function($scope, $routeParams, RESTBackend) {
        $scope.user = RESTBackend.get({},{'id': $routeParams.id}); // Calls: GET /api/customer/Id
            /*get({Id: $routeParams.Id}, function(phone) {
           // $scope.mainImageUrl = phone.images[0];
        });*/

        $scope.setImage = function(imageUrl) {
            $scope.mainImageUrl = imageUrl;
        }
    }]);
