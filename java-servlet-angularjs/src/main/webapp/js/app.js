var app = angular.module('app', ['ui.router', 'ngTable', 'ngCookies']);

app.config(function($stateProvider) {
  var mainState = {
    name: 'main',
    url: '/',
    templateUrl: '/java-servlet/pages/index.html'
  };

  var helloState = {
    name: 'bank_list',
    url: '/bank/list',
    templateUrl: '/java-servlet/pages/bank/list/index.html'
  };

  var aboutState = {
    name: 'bank_new',
    url: '/bank/new',
    templateUrl: '/java-servlet/pages/bank/new/index.html'
  };

  var userLoginState = {
    name: 'user_login',
    url: '/user/login',
    templateUrl: '/java-servlet/pages/user/login/index.html'
  };

  var userLogoutState = {
    name: 'user_logout',
    url: '/user/logout',
    templateUrl: '/java-servlet/pages/user/logout/index.html'
  };

  $stateProvider.state(mainState);
  $stateProvider.state(helloState);
  $stateProvider.state(aboutState);
  $stateProvider.state(userLoginState);
  $stateProvider.state(userLogoutState);
});

app.controller('indexCtrl', function($scope, $state) {
  console.log('Index controller');

  //$state.go('main');
});

app.service('menuService', function(userService) {
  this.update = function() {
    console.log('menuService.update()');

    userService.userIsAuthenticated();
  };
});