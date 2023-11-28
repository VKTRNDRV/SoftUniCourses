function solve() {
    document.querySelector('#btnSend').addEventListener('click', onClick);

    function onClick () {

        const groupStrings = document.getElementsByTagName("textarea")[0]
        .value
        .slice(1, -1)
        .split('", "');

        let restaurants = groupStrings.map(groupString => {
            let [restaurant, employeesStr] = groupString.split(' - ');
            let employees = employeesStr.split(', ').map(e => {
                let [name, value] = e.split(' ');
                return { name, value: parseInt(value, 10) };
            });
            return { name: restaurant, employees: employees };
        });

        let sortedRestaurants = restaurants.sort((r1, r2) => {return 0});

    }
}