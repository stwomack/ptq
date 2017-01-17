angular.module('ptq', []).controller('home', function($http) {
	var self = this;
	$http.get('health/').then(function(response) {
		self.health = response.data;
	})
});