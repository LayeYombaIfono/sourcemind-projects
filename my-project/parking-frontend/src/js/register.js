
document.getElementById("register-form").addEventListener("submit", function (event) {
    event.preventDefault();

    // Récupération des champs
    const fullname = document.getElementById("fullname");
    const email = document.getElementById("email");
    const password = document.getElementById("password");
    const confirmPassword = document.getElementById("confirm-password");

    const fullnameError = document.getElementById("fullname-error");
    const emailError = document.getElementById("email-error");
    const passwordError = document.getElementById("password-error");
    const confirmPasswordError = document.getElementById("confirm-password-error");
    const registerSuccess = document.getElementById("register-success");

    // Réinitialiser les erreurs
    fullnameError.classList.add("hidden");
    emailError.classList.add("hidden");
    passwordError.classList.add("hidden");
    confirmPasswordError.classList.add("hidden");
    registerSuccess.classList.add("hidden");

    let isValid = true;

    // Validation des champs
    if (!fullname.value.trim()) {
        fullnameError.classList.remove("hidden");
        isValid = false;
    }

    if (!email.value || !email.value.includes("@")) {
        emailError.classList.remove("hidden");
        isValid = false;
    }

    if (!password.value) {
        passwordError.classList.remove("hidden");
        isValid = false;
    }

    if (password.value !== confirmPassword.value) {
        confirmPasswordError.classList.remove("hidden");
        isValid = false;
    }

    if (!isValid) return;

    // Exemple de simulation d'inscription réussie
    registerSuccess.classList.remove("hidden");
    setTimeout(() => {
        window.location.href = "./login.html"; // Redirection après inscription
    }, 2000);
});
