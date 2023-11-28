function solve() {

    const tableBody = document.querySelector('table tbody');
    const buyButton = document.querySelector('button:last-of-type');
    const generateButton = document.getElementsByTagName("button")[0];
    generateButton.addEventListener("click", generate);
    const resultTextarea = document.querySelector('textarea:last-of-type');

    function generate(){
        let furniture = JSON.parse(document
            .getElementsByTagName("textarea")[0].value);
    
        furniture.forEach((furniture, index) => {
            const row = document.createElement("tr");
            const imgCell = row.insertCell(0);
            const nameCell = row.insertCell(1);
            const priceCell = row.insertCell(2);
            const decFactorCell = row.insertCell(3);
            const markCell = row.insertCell(4);

            tableBody.appendChild(row);
    
            imgCell.innerHTML = `<img src="${furniture.img}">`;
            nameCell.innerHTML = `<p>${furniture.name}</p>`;
            priceCell.innerHTML = `<p>${furniture.price}</p>`;
            decFactorCell.innerHTML = `<p>${furniture.decFactor}</p>`;
            markCell.innerHTML = `<input type="checkbox">`;
        });
    }

    buyButton.addEventListener('click', () => {
        const selectedFurniture = [];
        let totalPrice = 0;
        let totalDecFactor = 0;
        const checkboxes = document.querySelectorAll('input[type="checkbox"]:checked');

        checkboxes.forEach((checkbox) => {
            const row = checkbox.parentNode.parentNode;
            const name = row.querySelector('td:nth-child(2) p').textContent;
            const price = parseFloat(row.querySelector('td:nth-child(3) p').textContent);
            const decFactor = parseFloat(row.querySelector('td:nth-child(4) p').textContent);

            selectedFurniture.push(name);
            totalPrice += price;
            totalDecFactor += decFactor;
        });

        const averageDecFactor = totalDecFactor / selectedFurniture.length;

        // Display the result in the textarea
        resultTextarea.value = `Bought furniture: ${selectedFurniture.join(', ')}\n`;
        resultTextarea.value += `Total price: ${totalPrice.toFixed(2)}\n`;
        resultTextarea.value += `Average decoration factor: ${averageDecFactor}`;
    });
}