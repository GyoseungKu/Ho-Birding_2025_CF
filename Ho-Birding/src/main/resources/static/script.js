document.addEventListener("DOMContentLoaded", function() {
    const text = `숲속에서 잠이든 당신,\n깨어나보니 몸이 가벼워진 것을 느꼈다.\n\n손을 내려다 봤더니\n깃털이 보인다\n과연 누구의 깃털일까?`;
    const typingText = document.getElementById("typing-text");
    let index = 0;

    function type() {
        if (index < text.length) {
            typingText.innerHTML += text.charAt(index);
            index++;
            setTimeout(type, 100);
        } else {
            setTimeout(() => {
                window.location.href = "question1";
            }, 2000);
        }
    }

    type();
});