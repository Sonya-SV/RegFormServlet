// function create(htmlStr) {
//     var frag = document.createDocumentFragment(),
//         temp = document.createElement('div');
//     temp.innerHTML = htmlStr;
//     while (temp.firstChild) {
//         frag.appendChild(temp.firstChild);
//     }
//     return frag;
// }
// function startTimer(duration, display) {
//     var start = Date.now(),
//         diff,
//         minutes,
//         seconds;
//     function timer() {
//         diff = duration - (((Date.now() - start) / 1000) | 0);
//
//         minutes = (diff / 60) | 0;
//         seconds = (diff % 60) | 0;
//
//         minutes = minutes < 10 ? "0" + minutes : minutes;
//         seconds = seconds < 10 ? "0" + seconds : seconds;
//
//         display.textContent = minutes + ":" + seconds;
//
//         if (diff <= 0) {
//             start = Date.now() + 1000;
//         }
//     };
//     timer();
//     setInterval(timer, 1000);
// }
// window.onload = function () {
//
//     var fragment3 = create('<div style="background:#fff5d2;padding:10px 20px;border:1px solid #e3df74; font-size:14px; color:#2c2c2c; font-weight:bold;-webkit-border-radius: 5px; -moz-border-radius: 5px; border-radius: 5px; margin:10px 0px 20px 0px">Your order is reserved for <span id="time"></span> minutes!</div>');
//     document.getElementsByClassName('main__header')[0].appendChild(fragment3);
//
//     var ten = 60 * 10,
//         display = document.querySelector('#time');
//     startTimer(ten, display);
// };

function countdown(endDate) {
    let days, hours, minutes, seconds;

    endDate = new Date(endDate).getTime();

    if (isNaN(endDate)) {
        return;
    }

    setInterval(calculate, 1000);

    function calculate() {
        let startDate = new Date();
        startDate = startDate.getTime();

        let timeRemaining = parseInt((endDate - startDate) / 1000);

        if (timeRemaining >= 0) {
            days = parseInt(timeRemaining / 86400);
            timeRemaining = (timeRemaining % 86400);

            hours = parseInt(timeRemaining / 3600);
            timeRemaining = (timeRemaining % 3600);

            minutes = parseInt(timeRemaining / 60);
            timeRemaining = (timeRemaining % 60);

            seconds = parseInt(timeRemaining);

            document.getElementById("days").innerHTML = parseInt(days, 10);
            document.getElementById("hours").innerHTML = ("0" + hours).slice(-2);
            document.getElementById("minutes").innerHTML = ("0" + minutes).slice(-2);
            document.getElementById("seconds").innerHTML = ("0" + seconds).slice(-2);
        } else {
            return;
        }
    }
}

(function () {
    countdown('04/01/2333 05:00:00 PM');
}());