        //alert(window.echo.echo);
        //var success = function(r) { alert(JSON.stringify(r)); };
        //var error = function(message) { alert("Oopsie! " + message); };
        //window.echo.createEcho('hello', success, error);

var cordova = require('cordova'),
    exec = require('cordova/exec');

//alert('in3plugin2');
    
var Echo = function() {
    this.echo = 'hi';
    
    this.createEcho = function(valToEcho, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, 
            'Echo', 'createEcho', [ { "echoVal": valToEcho } ]
        ); 
    };

    this.sendNotification = function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback,
            'Echo', 'sendNotification', [ { } ]
        );
    };

    this.sayHi = function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback,
            'Echo', 'sayHi', [ { } ]
        );
    };

    this.showSplash = function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback,
            'Echo', 'showSplash', [{}]
        );
    }

    this.sendSMS = function (phoneNumber, message, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback,
            'Echo', 'sendSMS', [{ "phoneNumber": phoneNumber, "message": message }]
        );
    };

    this.makeCall = function (phoneNumber, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback,
            'Echo', 'makeCall', [{ "phoneNumber": phoneNumber }]
        );
    };

};

var echo = new Echo();

module.exports = echo;
