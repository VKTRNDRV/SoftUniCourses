function sumTable() {
    let table = document.querySelector("table");
    let rows = Array.from(table.getElementsByTagName("tr"));
    let sum = 0;
    for (let i = 1; i < rows.length - 1; i++) {
        let cells = rows[i].getElementsByTagName("td");
        let lastCell = cells[cells.length - 1];
        sum += Number.parseFloat(lastCell.textContent);
    }

    document.getElementById("sum").textContent = sum;
}



let rows = Array.from(table.getElementsByTagName("tr"));
