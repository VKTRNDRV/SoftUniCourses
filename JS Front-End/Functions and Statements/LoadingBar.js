function printLoadingBar(percent){
    if(percent == 100){
        console.log("100% Complete!");
        console.log("[%%%%%%%%%%]");
        return;
    }

    console.log(`${percent}% [${'%'.repeat(percent/10)}${'.'.repeat(10 - percent/10)}]`);
    console.log("Still loading...");
}

printLoadingBar(30);
printLoadingBar(50);
printLoadingBar(100);
printLoadingBar(25);