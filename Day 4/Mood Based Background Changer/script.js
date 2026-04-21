// We will create a function which will be called wherever a button is clicked!!!
function changeMood(mood){
    // 1. Create variables to find the parts of the page to change
    const body=document.body;
    const text=document.getElementById('status');
    // We will do the changes using if else conditions
    if (mood==='happy'){
        body.style.background="#FFDE59";  // Yellow
        body.style.color="black";  // Makes the text black
        text.textContent="Keep shining!!! ☀️";  // Updates h1
    }
    else if (mood==="relaxed") {
        body.style.background="#7091F5";  // Blue
        body.style.color="white";  // Makes the text white
        text.textContent="Take a deep breath... 🫁";  // Updates h1
    }
    else if (mood==="sad") {
        body.style.background="#2D3436";  // Dark
        body.style.color="white";  // Makes the text white
        text.textContent="It's okay to feel this way 🌊";  // Updates h1
    }
    else if (mood==="angry") {
        body.style.background="#D63031";  // Read
        body.style.color="white";  // Makes the text white
        text.textContent="Deep breaths... let it out. 🔥";  // Updates h1
    }
}