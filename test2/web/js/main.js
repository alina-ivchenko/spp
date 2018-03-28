function showInfoAboutAbiturient(studId) {
    window.location = "http://" + document.location.host + document.location.pathname + "?currAbiturientId=" + studId;
}

function logout() {
    window.location = "http://" + document.location.host + "/login?logout=true"
}