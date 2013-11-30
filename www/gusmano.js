        //alert(window.echo.echo);
        //var success = function(r) { alert(JSON.stringify(r)); };
        //var error = function(message) { alert("Oopsie! " + message); };
        //window.echo.createEcho('hello', success, error);

var cordova = require('cordova'),
    exec = require('cordova/exec');

//alert('in3plugin2');
    
var Gusmano = function() {
    this.echo = 'hi';
    
    this.createEcho = function(valToEcho, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, 
            'Gusmano', 'createEcho', [ { "echoVal": valToEcho } ]
        ); 
    };

    this.sendNotification = function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback,
            'Gusmano', 'sendNotification', [ { } ]
        );
    };

    this.sayHi = function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback,
            'Gusmano', 'sayHi', [ { } ]
        );
    };

    this.showSplash = function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback,
            'Gusmano', 'showSplash', [{}]
        );
    }

    this.sendSMS = function (phoneNumber, message, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback,
            'Gusmano', 'sendSMS', [{ "phoneNumber": phoneNumber, "message": message }]
        );
    };

    this.makeCall = function (phoneNumber, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback,
            'Gusmano', 'makeCall', [{ "phoneNumber": phoneNumber }]
        );
    };

};

var gusmano = new Gusmano();

module.exports = gusmano;
