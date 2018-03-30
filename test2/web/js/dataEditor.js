function onEditBtnClick() {
    $(".editable").wrapInner("<textarea class='editTextarea' form='mainSendForm'></textarea>");

    $("#editBtn").hide();
    $("#saveBtn").show();
}

function onSaveChangesBtnClick() {
    sendSaveRequest();
}

function sendSaveRequest() {
    $.post(
        "/saver",
        {
            task: "update",
            objectType: "Abiturient",
            data: getArrayFromTdData($('.send'))
        },
        onSavedSuccessfully
    );
}

function onSavedSuccessfully(data) {
    alert("OK " + data);

    $('.editTextarea').each(function (index, value) {
        text = this.value;
        $(this).replaceWith(text);
    });

    $("#saveBtn").hide();
    $("#editBtn").show();
}


function getArrayFromTdData(array) {
    retArr = {};
    for (i = 0; i < array.length; i++) {
        if ($(array[i]).hasClass('editable'))
        //подбирает из td.send.textarea (те, которые можно редактировать)
            retArr[array[i].id] = array[i].childNodes[0].value;
        else {
            //подбирает из td.send (те, которые нельзя редактировать)
            if ($(array[i]).children().length !== 0)
                retArr[array[i].id] = $(array[i]).children().text();
            else
                retArr[array[i].id] = $(array[i]).text()
        }
        //$(array[i]).parent().attr('id')
    }

    return JSON.stringify(retArr);
}