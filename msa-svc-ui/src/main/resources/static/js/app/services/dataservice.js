'use strict';


angular.module('oauthApp')
    .factory('dataService', function ($http, $q) {
        // We always use this angular service within the preview context
    	
    	var gwUrl	=	'http://zuul.msasmp01.com';
        var memberApi = gwUrl + '/v1/member';

        var orderApi = gwUrl + '/v1/order';

        var loggedInUserApi = gwUrl + '/api/loggedinuser/me';

        // This method makes the REST call and the response is parsed by
        // Angular.js by default to convert to JSON. If the response is
        // successfully parsed then the JSON is available as an 'object'
        var makeRestCall = function (url) {
            return $http.get(url)
                .then(function (response) {

                    if (typeof response.data === 'object') {
                        return response.data;
                    } else {
                        // invalid response
                        return $q.reject(response.data);
                    }

                }, function (response) {
                    // something went wrong
                    return $q.reject(response.data);
                });
        };

        return {
        	getMemberList: function () {
                // Make call to the api to get all users
        		alert(memberApi)
                return makeRestCall(memberApi);
            },

            getAllTaskData: function () {
                // Make call to the api to get all tasks       
                return makeRestCall(orderApi);
            },

            getMemberByName: function (memberName) {
                // Make call to the api to get user details by user name
                return makeRestCall(memeberApi + '/' + memeberName);
            },

            getTaskDataByTaskId: function (orderId) {
                // Make call to theapi to get task details by task id	        
                return makeRestCall(orderApi + '/' + orderId);
            },

            getTaskDataByUserName: function (memberName) {
                return makeRestCall(orderApi + '/' + 'ordertask' + '/' + memberName);
            },

            getLoggedInUser: function () {
                // Make call to get the current logged in user
                return makeRestCall(loggedInUserApi);
            }
        };
    });