function printPalindromeCheck(nums){

    function isPalindrome(numToCheck){
        let numString = numToCheck.toString();
        let length = numString.length;
        let firstChar;
        let secondChar;
        for(let i = 0; i < length / 2; i++){
            firstChar = numString.charAt(i);
            secondChar = numString.charAt(length - (i + 1));

            if(firstChar != secondChar){
                return false;
            }
        }

        return true;
    }

    for(let number of nums){
        console.log(isPalindrome(number));
    }
}


printPalindromeCheck([123,323,421,121]);
printPalindromeCheck([32,2,232,1010]);