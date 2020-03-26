'use strict';

var myproject = window.myproject || {};

myproject.getWeather = function () {
  var urlPath = $('#weather-widget').data('resource-path') + '.json';
  $.ajax({
    url: urlPath,
    cache: false,
    method: 'GET',
    success: function success(response) {
      populateReport(response);
    },
    error: function error() {
      console.error('Unable to get Weather api response');
    }
  });

  function populateReport(response) {
    var cityName = $('.weather-widget__city-name');
    var temperature = $('.weather-widget__temperature');
    var description = $('.weather-widget__description');
    var wind = $('#weather-widget-wind');
    var cloud = $('#weather-widget-cloudiness');
    var pressure = $('#weather-widget-pressure');
    var humidity = $('#weather-widget-humidity');
    var sunrise = $('#weather-widget-sunrise');
    var sunset = $('#weather-widget-sunset');
    var lat = $('#wrong-data-lat');
    var lon = $('#wrong-data-lon');
    var time = $('#weather-widget-time');

    cityName.text('Weather in' + response.cityName + ',' + response.countryCode);
    temperature.text(response.temperature + '°C');
    description.text(response.weatherDescription);
    wind.text(response.windSpeed + ' m/s');
    cloud.text(response.weatherDescription);
    pressure.text(response.pressure + ' hpa');
    humidity.text(response.humidity + ' %');
    sunrise.text(response.sunrise);
    sunset.text(response.sunset);
    lat.text(response.latitude);
    lon.text(response.longitude);
    time.text(response.currentDateTime);
  }
};

(function () {
  myproject.getWeather();
})();
