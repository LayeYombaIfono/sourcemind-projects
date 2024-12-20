document.getElementById("login-form").addEventListener("submit", function (event) {
    event.preventDefault();

    // Récupération des champs
    const email = document.getElementById("email");
    const password = document.getElementById("password");
    const emailError = document.getElementById("email-error");
    const passwordError = document.getElementById("password-error");
    const loginError = document.getElementById("login-error");

    // Réinitialiser les erreurs
    emailError.classList.add("hidden");
    passwordError.classList.add("hidden");
    loginError.classList.add("hidden");



    let isValid = true;

    // Validation des champs
    if (!email.value || !email.value.includes("@")) {
        emailError.classList.remove("hidden");
        isValid = false;
    }

    if (!password.value) {
        passwordError.classList.remove("hidden");
        isValid = false;
    }

    if (!isValid) return;

    // Exemple de simulation de validation
    if (email.value === "layeyomba02@gmail.com" && password.value === "admin123") {
        alert("Connexion réussie !");
        window.location.href = "./dashboard.html"; // Redirection
    } else {
        loginError.classList.remove("hidden");
    }
});