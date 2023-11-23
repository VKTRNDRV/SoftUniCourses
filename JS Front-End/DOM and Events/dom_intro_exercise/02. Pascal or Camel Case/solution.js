function solve() {
	let wordsToTransform = document.getElementById("text").value.split(/\s+/);
	let convention = document.getElementById("naming-convention").value;
	for(let i = 0; i < wordsToTransform.length; i++){
		let word = wordsToTransform[i].toLowerCase();
		let firstLetter = word.charAt(0).toUpperCase();
		wordsToTransform[i] = `${firstLetter}${word.substring(1)}`;
	}

	let output;

	switch(convention){
		case "Camel Case":
			let firstWord = wordsToTransform[0];
			let firstLetter = firstWord.charAt(0).toLowerCase();
			wordsToTransform[0] = `${firstLetter}${firstWord.substring(1)}`;
			output = wordsToTransform.join("");
			break;
		case "Pascal Case":
			output = wordsToTransform.join("");
			break;
		default:
			output = "Error!";
			break;
	}

	let outputElement = document.getElementById("result");
	outputElement.textContent = output;
}