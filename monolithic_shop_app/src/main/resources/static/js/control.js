let selectedIndex = -1;


function addTableRow() {
	let inputTable = document.getElementById("inputTable");
	let inputTableBody = inputTable.querySelector("tbody");
	let newRow = document.createElement("tr");
	newRow.setAttribute("data-bs-toggle", "modal");
	newRow.setAttribute("data-bs-target", "#editSpecificationModal");
	
	let newSpecification = document.createElement("td");
	let newSpecificationInput = document.querySelector("#newSpecificationInput");
	let newDescriptionInput = document.querySelector("#newDescriptionInput");
	newSpecification.innerHTML = newSpecificationInput.value;
	let newDescription = document.createElement("td");
	newDescription.innerHTML = newDescriptionInput.value;
	
	newRow.appendChild(newSpecification);
	newRow.appendChild(newDescription);
	inputTableBody.appendChild(newRow);
}

function modifyTableRow() {
	let editSpecificationInput = document.querySelector("#editSpecificationInput");
	let editDescriptionInput = document.querySelector("#editDescriptionInput");
	
	const inputTable = document.querySelector(".table");
	const rows = inputTable.querySelectorAll("tbody > tr");
	
	tds = rows[selectedIndex].querySelectorAll("td");
	tds[0].innerHTML = editSpecificationInput.value;
	tds[1].innerHTML = editDescriptionInput.value;
}

function deleteTableRow() {
	const inputTable = document.querySelector(".table");
	//function dom-table-deleteRow start at 1
	inputTable.deleteRow(selectedIndex+1);
}

function submitProductData() {
	
	var productName = document.getElementById("productNameInput").value;
	var productDescription = document.getElementById("productDescriptionInput").value;
	var productPrice = document.getElementById("productPriceInput").value;
	
	var product = {
		name: productName,
		description: productDescription
	}
				
	document.getElementById("loading").style.display = "flex";
	let loadUri = 'http://localhost:8080/api/v1/products';

	fetch(loadUri, {
	      method: 'POST',
	      headers: {
	        'Content-Type': 'application/json',
	      },
	      body: JSON.stringify(product),
	    })
	      .then(response => response.text())
	      .then(outputData => {
	    	  				//let products = JSON.parse(outputData);
	    	  				console.log("result is " + outputData);
							document.getElementById("loading").style.display = "none";
							if(outputData == '1') {
								successfulModal.show()
							}
							else {
								failModal.show();
							}
	    	  			});

}