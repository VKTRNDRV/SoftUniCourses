function encodeAndDecodeMessages() {
    // Get elements from the HTML
    const messageInput = document.querySelector('textarea');
    const encodeButton = document.querySelector('button');
    const receiverTextarea = document.querySelectorAll('textarea')[1];
    const decodeButton = document.querySelectorAll('button')[1];

    // Event listener for Encode button
    encodeButton.addEventListener('click', () => {
        // Get the message from the sender textarea
        const message = messageInput.value;

        // Encode the message
        const encodedMessage = encodeMessage(message);

        // Clear sender textarea and add encoded message to receiver textarea
        messageInput.value = '';
        receiverTextarea.value = encodedMessage;
    });

    // Event listener for Decode button
    decodeButton.addEventListener('click', () => {
        // Get the encoded message from the receiver textarea
        const encodedMessage = receiverTextarea.value;

        // Decode the message
        const decodedMessage = decodeMessage(encodedMessage);

        // Replace the encoded message with the decoded message in the receiver textarea
        receiverTextarea.value = decodedMessage;
    });

    // Function to encode the message
    function encodeMessage(message) {
        return message.split('').map(char => String.fromCharCode(char.charCodeAt(0) + 1)).join('');
    }

    // Function to decode the message
    function decodeMessage(encodedMessage) {
        return encodedMessage.split('').map(char => String.fromCharCode(char.charCodeAt(0) - 1)).join('');
    }
}