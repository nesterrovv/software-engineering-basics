const SVG_SIZE = 300

// Функции для расчёта координат точки
function calculateX(x, r) {
    // return Math.floor(SVG_SIZE / 2 + x / r * 100);
    return SVG_SIZE / 2 + x / r * 100;
}

function calculateY(y, r) {
    return SVG_SIZE / 2 + y / r * -100;
    // return Math.floor(SVG_SIZE / 2 + y / r * -100);
}

function doRequest(x, y, r, isFromSvg) {
    let request = ("send?x_value=" + x + "&y_value=" + y + "&r_value=" + r + "&type=" + (isFromSvg ? "svg" : "form"));
    fetch(request)
        .then(response => response.text())
        .then(response => addToTable(response))
        .then(response => drawDot(response));
}

$('svg').on("click", function (e) {
    const position = $('svg').offset();
    const rowX = e.pageX - position.left;
    const rowY = e.pageY - position.top;
    const r = parseFloat($('#r').val());
    const x = (r / 100 * (rowX - SVG_SIZE / 2)).toFixed(2);
    const y = (r / 100 * (SVG_SIZE / 2 - rowY)).toFixed(2);
    doRequest(x, y, r, true);
});

function addToTable(response) {
    // console.log(response)
    response = JSON.parse(response);
    // console.log(response);
    $('tbody')
        .append($('<tr>')
            .append($('<td>')
                .text(Number.isInteger(response['x']) ? parseFloat(response['x']).toFixed(1) : response['x'])
            )
            .append($('<td>')
                .text(Number.isInteger(response['y']) ? parseFloat(response['y']).toFixed(1) : response['y'])
            )
            .append($('<td>')
                .text(Number.isInteger(response['r']) ? parseFloat(response['r']).toFixed(1) : response['r'])
            )
            .append($('<td>')
                .text(response['result'])
            ).append($('<td>')
                .text(response['localTime'])
            ).append($('<td>')
                .text(response['executionTime'])
            ));
    return response;
}

function drawDot(response) {
    // console.log(response);
    // response = JSON.parse(response);
    console.log(response);

    let xCoordinate = calculateX(response['x'], response['r']);
    let yCoordinate = calculateY(response['y'], response['r']);
    let color = response['result'] ? "green" : "red";
    console.log(xCoordinate, yCoordinate, color);

    let svgns = "http://www.w3.org/2000/svg";
    let circle = document.createElementNS(svgns, "circle");
    circle.setAttributeNS(null, 'r', '3.5');
    circle.setAttributeNS(null, 'cx', xCoordinate);
    circle.setAttributeNS(null, 'cy', yCoordinate);
    circle.setAttributeNS(null, 'fill', color);
    document.querySelector("svg").appendChild(circle);
}