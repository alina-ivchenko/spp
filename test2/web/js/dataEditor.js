function onEditBtnClick() {
    //вставляем textarea
    //$(".editable").wrapInner("<textarea class='editTextarea' form='mainSendForm'></textarea>");

    $.post(
        "/getInfo",
        {
            task: "ListOfSpecialities"
        },
        onRequiredInfoLoaded
    );
}

//продолжение запустится сразу, как подкгрзятся данные
function onRequiredInfoLoaded(data) {
    var serverAnswer = JSON.parse(data);

    $('.send').each(function (index, value) {
        id = this.id;

        if ($(this).hasClass('editable'))
            $(this).wrapInner("<textarea class='editTextarea' form='mainSendForm' name='" + id + "'></textarea>");

        if ($(this).hasClass('non-editable'))
            $(this).wrapInner("<textarea class='editTextarea readonly' form='mainSendForm' name='" + id + "' readonly='readonly'></textarea>");

        if ($(this).hasClass('selectable')) {
            if (this.id === 'IdSpeciality') {
                str = "<select form = 'mainSendForm' name='IdSpeciality'>";
                for (key in serverAnswer) {
                    key = parseInt(key);

                    str += "<option value='" + key + "'>";
                    str += serverAnswer[key] + "</option>";
                }
                str += "</select>";
                $(this).html(str)
            }
        }
    });

    $("#editBtn").hide();
    $("#saveBtn").show();
}

function onSaveChangesBtnClick() {
    sendSaveRequest();
}

function sendSaveRequest() {

    $('#mainSendForm').append("<input name='task' value='update'>");
    $('#mainSendForm').append("<input name='objectType' value='Abiturient'>");
    $('#mainSendForm').submit();

    //reset form
    $('#mainSendForm').html("");
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

function onSaveError(data) {
    alert("ERROR");
}

/*
    теперь будем отправлять через форму.
    собирать вручную данные нет необходимости

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

*/