document.addEventListener("DOMContentLoaded", () => {
    const navbarPlaceholder = document.getElementById("navbar-placeholder");
    console.log(navbarPlaceholder);

    if (navbarPlaceholder) {
        fetch("../components/navbar.html")
            .then(response => response.text())
            .then(data => {
                navbarPlaceholder.innerHTML = data;
                // Initialize any necessary JavaScript for the navbar here
            })
            .catch(error => console.error("Error fetching navbar:", error));
    }



});