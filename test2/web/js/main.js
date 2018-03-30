function showInfoAboutAbiturient(studId) {
    window.location = "http://" + document.location.host + document.location.pathname + "?currAbiturientId=" + studId;
}

function showInfoAboutSpeciality(specId) {
    window.location = "http://" + document.location.host + document.location.pathname + "?currSpecialityId=" + specId;
}

function showInfoAboutFaculty(facultyId) {
    window.location = "http://" + document.location.host + document.location.pathname + "?currFacultyId=" + facultyId;
}

function showInfoAboutSubject(subjectId) {
    window.location = "http://" + document.location.host + document.location.pathname + "?currSubjectId=" + subjectId;
}

function logout() {
    window.location = "http://" + document.location.host + "/login?logout=true"
}