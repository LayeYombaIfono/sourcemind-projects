// Inclure la barre de navigation
document.addEventListener("DOMContentLoaded", () => {
    const navbarPlaceholder = document.getElementById("navbar-placeholder");
    if (navbarPlaceholder) {
        fetch("./navbar.html")
            .then(response => response.text())
            .then(data => {
                navbarPlaceholder.innerHTML = data;
            })
            .catch(error => console.error("Erreur lors du chargement de la barre de navigation:", error));
    }
});

// Gestion des champs obligatoires avec mise en évidence
document.getElementById("add-vehicle-form").addEventListener("submit", function (event) {
    event.preventDefault();

    const requiredFields = ["license-plate", "owner", "contact", "fuel-type"];
    let formValid = true;

    requiredFields.forEach(fieldId => {
        const field = document.getElementById(fieldId);
        if (!field.value.trim()) {
            field.classList.add("border-red-600");
            formValid = false;
        } else {
            field.classList.remove("border-red-600");
        }
    });

    // Vérifier au moins une checkbox pour le statut
    const statusChecked = document.querySelectorAll('input[name="status"]:checked').length > 0;
    if (!statusChecked) {
        alert("Veuillez sélectionner un statut.");
        formValid = false;
    }

    if (!formValid) {
        alert("Veuillez remplir tous les champs obligatoires.");
        return;
    }

    const licensePlate = document.getElementById("license-plate").value;
    const owner = document.getElementById("owner").value;
    const contact = document.getElementById("contact").value;
    const model = document.getElementById("model").value;
    const color = document.getElementById("color").value;
    const fuelType = document.getElementById("fuel-type").value;
    const status = Array.from(document.querySelectorAll('input[name="status"]:checked')).map(cb => cb.value).join(", ");

    const newRow = document.createElement("tr");
    newRow.classList.add("border-b");
    newRow.innerHTML = `
        <td class="py-3 px-4">${licensePlate}</td>
        <td class="py-3 px-4">${owner}</td>
        <td class="py-3 px-4">${contact}</td>
        <td class="py-3 px-4">${model}</td>
        <td class="py-3 px-4">${color}</td>
        <td class="py-3 px-4">${fuelType}</td>
        <td class="py-3 px-4 text-blue-600">${status}</td>
        <td class="py-3 px-4">
            <button class="bg-yellow-500 text-white py-1 px-2 rounded hover:bg-yellow-600 edit-btn">Modifier</button>
            <button class="bg-red-500 text-white py-1 px-2 rounded hover:bg-red-600 delete-btn">Supprimer</button>
        </td>
    `;

    document.getElementById("activity-log").appendChild(newRow);

    alert("Véhicule ajouté avec succès !");

    // Réinitialiser les champs du formulaire
    document.getElementById("add-vehicle-form").reset();

    // Ajouter des événements pour les boutons Modifier et Supprimer
    newRow.querySelector(".edit-btn").addEventListener("click", function () {
        const cells = newRow.querySelectorAll("td");
        document.getElementById("license-plate").value = cells[0].textContent;
        document.getElementById("owner").value = cells[1].textContent;
        document.getElementById("contact").value = cells[2].textContent;
        document.getElementById("model").value = cells[3].textContent;
        document.getElementById("color").value = cells[4].textContent;
        document.getElementById("fuel-type").value = cells[5].textContent;

        const statusValues = cells[6].textContent.split(", ");
        document.querySelectorAll("input[name='status']").forEach(checkbox => {
            checkbox.checked = statusValues.includes(checkbox.value);
        });

        newRow.remove();
    });

    newRow.querySelector(".delete-btn").addEventListener("click", function () {
        if (confirm("Êtes-vous sûr de vouloir supprimer ce véhicule ?")) {
            newRow.remove();
        }
    });
});