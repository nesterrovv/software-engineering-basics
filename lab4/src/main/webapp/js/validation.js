function validate() {
    return !(!checkX() || !checkY());
}

function checkX() {
    let selected = $("input[name='x_value']:checked");
    if (selected.length > 1) {
        alert('Select only one value!');
        console.log(selected);
        console.log(selected.length);
        return false;
    } else if (selected.length === 0) {
        alert('Select X value');
        console.log(selected);
        console.log(selected.length);
        return false;
    } else if (selected.length === 1)
        return true;
    else {
        console.log(selected);
        console.log(selected.length);
        return false;
    }
}

function checkY() {
    const minValue = -5;
    const maxValue = 3;

    let yValue = $('#y').val();
    if (yValue === '') {
        alert("Enter Y value");
        return false;
    }
    if (isNaN(yValue) || !isFinite(yValue)) {
        alert("Invalid Y value");
        return false;
    }
    yValue = parseFloat(yValue.replace(",", "."));

    if (yValue <= minValue || yValue >= maxValue) {
        alert("Invalid Y value:\n" +
            `Should be in (${minValue}; ${maxValue})`);
        return false;
    }
    return true;
}

// Функция для кнопки Submit
$('.submit').on("click", function (event) {
    event.preventDefault();
    if (!validate()) return;
    const {x, y, r} = getData();
    doRequest(x, y, r, false);
});

function getData() {
    let x = parseInt($("input[name='x_value']:checked:first").val());
    let y = parseFloat($('#y').val().replace(",", "."));
    let r = parseFloat($('#r').val());

    return {x, y, r};
}