$(document).ready(function () {
    loadItems()
})

function loadItems() {
    const req = $.ajax({
        type: "GET",
        url: "http://localhost:8080/job4j_todo/find.do",
        dataType: "json"
    })
    req.done(function (data) {
        let items = ""
        for (let i = 0; i < data.length; i++) {
            if (data[i]["done"] !== "true") {
                items += "<tr>"
                    + "<td>" + data[i]["description"] + "</td>"
                    + "<td>" + data[i]["created"] + "</td>"
                    + "<td>" + "Не выполнено  "
                    + "<input type='checkbox' id='setStatus' value=" + data[i]["id"] + ">"
                    + "</td>"
                    + "</tr>"
            }
        }
        $('#showAll').on('click', function () {
            $('#items').html(items);
            $('input:checked:not(:disabled)').each(function () {
                for (let i = 0; i < data.length; i++) {
                    if (data[i]["done"] === "true") {
                        $('#items').append("<tr style='background: #7dec4c'>"
                            + "<td>" + data[i]["description"] + "</td>"
                            + "<td>" + data[i]["created"] + "</td>"
                            + "<td>" + "Выполнено  "
                            + "<input disabled type='checkbox' id='setStatus' checked value=" + data[i]["id"] + ">"
                            + "</td>"
                            + "</tr>");
                    }
                }
            });
        });
        $('#items').html(items)
    })
}

function validate() {
    let result = true
    if ($("#desc").val() === '') {
        alert("Необходимо ввести описание задачи")
        result = false
    }
    return result
}

function addItem() {
    if (validate()) {
        $.ajax({
            method: 'POST',
            url: 'http://localhost:8080/job4j_todo/add.do',
            data: {description: $("#desc").val()},
            dataType: 'json'
        });
        location.reload()
    }
}

function getSelectedValues() {
    let selectedValues = [];
    $('input[id=setStatus]:checked:not(:disabled)').each(function (i, e) {
        selectedValues.push($(e).attr('value'))
    })
    return selectedValues;
}

function markDone() {
    let selectedValues = getSelectedValues()
    if (selectedValues.length > 0) {
        for (let i = 0; i < selectedValues.length; i++) {
            $.ajax({
                method: 'POST',
                url: 'http://localhost:8080/job4j_todo/update.do',
                data: {id: selectedValues[i]},
                dataType: 'json'
            });
        }
        location.reload()
    } else {
        alert("Необходмио выбрать задания")
    }
}