function subtract() {
    let firstNum = document.getElementById("firstNumber").value;
    let secondNum = document.getElementById("secondNumber").value;

    let resultElement = document.getElementById("result");

    resultElement.textContent = `${firstNum - secondNum}`;
}