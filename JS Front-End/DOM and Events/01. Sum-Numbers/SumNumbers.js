function calc() {
    let num1 = Number.parseFloat(document.getElementById("num1").value);
    let num2 = Number.parseFloat(document.getElementById("num2").value);

    let outputElement = document.getElementById("sum");
    outputElement.value = (num1 + num2);
}
