function onDeleteButtonClick(objectType, id) {
    //пока что не асинхронно
    $('#mainSendForm').append("<input name='task' value='delete'>")
        .append("<input name='objectType' value='" + objectType + "'>")
        .append("<input name='id' value='" + id + "'>")
        .submit();
}

function onEditBtnClick(tasks) {
    //taskStr определяет, нужно ли что-то подгружать дополнительно
    //перед началом изменения. например, чтобы получить список всех
    //специальностей, нужно передать в taskStr 'ListOfSpecialities'
    //если ничего не нужно, ничего и не передаём

    if (tasks === null || tasks.length === 0)
        onRequiredInfoLoaded();
    else
        $.post(
            "/getInfo",
            {
                tasks: JSON.stringify(tasks)
            },
            onRequiredInfoLoaded
        );
}

//продолжение запустится сразу, как подкгрзятся данные
function onRequiredInfoLoaded(data) {
    if (data !== null && data !== 'Error')
        var serverAnswer = JSON.parse(data);

    $('.send').each(function (index, value) {

        if ($(this).hasClass('editable'))
            $(this).wrapInner("<textarea class='editTextarea' form='mainSendForm' name='" + this.id + "'></textarea>");

        if ($(this).hasClass('non-editable'))
            $(this).wrapInner("<textarea class='editTextarea readonly' form='mainSendForm' name='" + this.id + "' readonly='readonly'></textarea>");

        if ($(this).hasClass('selectable')) {

            if (this.id === 'IdSpeciality')
                firstKey = 'ListOfSpecialities';
            if (this.id === 'IdFaculty')
                firstKey = 'ListOfFaculties';
            if (this.id === 'FirstSubject' || this.id === 'SecondSubject' || this.id === 'ThirdSubject')
                firstKey = 'ListOfSubjects';

            str = "<select form = 'mainSendForm' name='" + this.id + "'>";
            for (key in serverAnswer[firstKey]) {
                key = parseInt(key);

                str += "<option value='" + key + "'>";
                str += serverAnswer[firstKey][key] + "</option>";
            }
            str += "</select>";
            $(this).html(str)
        }
    });

    $("#editBtn").hide();
    $("#saveBtn").show();
}

function onSaveChangesBtnClick(task, objectType) {
    if (task !== null && objectType !== null)
        sendSaveRequest(task, objectType);
    else
        alert("onSaveChangesBtnClick error: неверные параметры");
}

function sendSaveRequest(task, objectType) {

    //пока что не асинхронно
    $('#mainSendForm').append("<input name='task' value='" + task + "'>")
        .append("<input name='objectType' value='" + objectType + "'>")
        .submit();

    //reset form
    //$('#mainSendForm').html("");
}

/*
пока что без асинхронности, а значит обратной реакции нет

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