function search() {
   let query = document.getElementById("searchText").value;
   let towns = Array.from(document.getElementById("towns").children);
   let resultElement = document.getElementById("result");

   let count = 0;
   for(let townElement of towns){
      let townName = townElement.textContent;
      if(townName.includes(query)){
         count++;
         townElement.style = "text-decoration: underline; font-weight: bold;"
      }else{
         townElement.style = "";
      }
   }

   resultElement.textContent = `${count} matches found`;
}
