function solve() {
   document.querySelector('#searchBtn').addEventListener('click', onClick);

   function onClick() {
      let searchFieldElement = document.getElementById("searchField");
      let query = searchFieldElement.value;
      searchFieldElement.value = "";
      let tableRows = Array.from(document.getElementsByTagName("tbody")[0].children);

      for(let row of tableRows){
         let cellsInRow = Array.from(row.children);
         let isFound = false;
         for(let cell of cellsInRow){
            if(cell.textContent.includes(query)){
               isFound = true;
               break;
            }
         }

         if(isFound){
            row.className = "select";
         }else{
            row.className = "";
         }
      }
   }
}