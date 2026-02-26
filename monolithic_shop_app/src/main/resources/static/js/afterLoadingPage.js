const inputTable = document.querySelector(".table");
inputTable.addEventListener('click', event => {
	const rows = inputTable.querySelectorAll("tbody > tr");
	const index = Array.from(rows).indexOf(event.target.parentElement);
	selectedIndex = index;
	
	let editSpecificationInput = document.querySelector("#editSpecificationInput");
	let editDescriptionInput = document.querySelector("#editDescriptionInput");
	tds = rows[selectedIndex].querySelectorAll("td");
	editSpecificationInput.value = tds[0].innerHTML;
	editDescriptionInput.value = tds[1].innerHTML;
})

document.getElementById("loading").style.display = "none";

// Get the modal element
const successfulModalEl = document.getElementById('successfulSubmissionModal');
// Create a modal instance
const successfulModal = new bootstrap.Modal(successfulModalEl);
// Get the modal element
const failModalEl = document.getElementById('failSubmissionModal');
// Create a modal instance
const failModal = new bootstrap.Modal(failModalEl);