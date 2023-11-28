function create(words) {
   let initialDiv = document.getElementById("content");


   for(let word of words){
      let divToAdd = document.createElement("div");
      let paragraphToAdd = document.createElement("p");
      paragraphToAdd.textContent = word;
      paragraphToAdd.style.display = "none";
      divToAdd.appendChild(paragraphToAdd);
      divToAdd.addEventListener("click", function() {
         paragraphToAdd.style.display = "block";
      });
      initialDiv.appendChild(divToAdd);
   }
}