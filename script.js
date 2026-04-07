function login(event) {
    event.preventDefault();

    let username = document.getElementById("username").value;

    // Simple login simulation
    localStorage.setItem("user", username);

    window.location.href = "vote.html";
}

function vote(candidate) {
    let user = localStorage.getItem("user");

    fetch("http://localhost:8080/vote", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            username: user,
            candidate: candidate
        })
    })
    .then(res => res.text())
    .then(data => {
        alert(data);
    });
}

function viewResults() {
    fetch("http://localhost:8080/results")
    .then(res => res.json())
    .then(data => {
        document.getElementById("results").innerHTML =
            JSON.stringify(data);
    });
}