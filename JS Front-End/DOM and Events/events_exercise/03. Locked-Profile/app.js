function lockedProfile() {
    const profiles = Array.from(document.querySelectorAll('.profile'));
    profiles.forEach((profile, index) => {
        const lockRadio = profile.querySelector(
            `input[name="user${index + 1}Locked"][value="lock"]`);
        const unlockRadio = profile.querySelector(
            `input[name="user${index + 1}Locked"][value="unlock"]`);
        const hiddenFields = profile.querySelector(
            `#user${index + 1}HiddenFields`);
        const showMoreButton = profile.querySelector('button');

        showMoreButton.addEventListener('click', () => {
            if (!unlockRadio.checked) {
                return;
            }

            if(showMoreButton.textContent === "Show more"){
                hiddenFields.style.display = 'block';
                showMoreButton.textContent = "Hide it";

            }else if(showMoreButton.textContent === "Hide it"){
                hiddenFields.style.display = 'none';
                showMoreButton.textContent = "Show more";
            }
        });

        lockRadio.addEventListener('change', () => {
            hiddenFields.style.display = 'none';
            showMoreButton.textContent = "Show more";
        });
    });
}