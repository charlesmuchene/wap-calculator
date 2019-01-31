'use strict';

window.onload = function () {

    const clearButton = document.getElementById('clear-form');

    clearButton.addEventListener('click', function (event) {
        const elements = document.getElementsByClassName('input-box');
        Array.from(elements).forEach(function(element) {
            // noinspection JSPrimitiveTypeWrapperUsage
            element.value = "";
        } );
        event.preventDefault();
    });

};