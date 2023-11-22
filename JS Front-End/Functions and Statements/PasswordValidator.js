function validatePassword(password){

    function isLengthValid(password){
        return (password.length >= 6 && password.length <= 10);
    }

    function areCharsValid(password){
        let currentChar;
        for(let i = 0; i < password.length; i++){
            currentChar = password.charAt(i);

            if(!currentChar.match(/[0-9A-Za-z]/i)){
                return false;
            }
        }

        return true;
    }

    function areTwoDigitsPresent(password){
        let digitCount = 0;
        for(let i = 0; i < password.length; i++){
            if(password.charAt(i).match(/[0-9]/)){
                digitCount++;
            }
        }

        return digitCount >= 2;
    }

    let isValid = true;

    if(!isLengthValid(password)){
        console.log("Password must be between 6 and 10 characters");
        isValid = false;
    }

    if(!areCharsValid(password)){
        console.log("Password must consist only of letters and digits");
        isValid = false;
    }

    if(!areTwoDigitsPresent(password)){
        console.log("Password must have at least 2 digits");
        isValid = false;
    }

    if(isValid){
        console.log("Password is valid");
    }
}

validatePassword('logIn');
console.log("---");
validatePassword('MyPass123');
console.log("---");
validatePassword('Pa$s$s');