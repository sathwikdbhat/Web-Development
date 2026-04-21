let slides=document.querySelectorAll(".slide");
let current=0; // Index of the visible image (0 = first image)
let timer;  // This will be the variable for auto-sliding
function showSlide(index){
    slides[current].classList.remove("active");  // Hide current image
    current=(index+slides.length) % slides.length;  // Not out of Bounds
    slides[current].classList.add("active");  // Show new image
}
function nextSlide(){
    showSlide(current + 1);
    resetTimer();
}
function prevSlide(){
    showSlide(current - 1);
    resetTimer;
}
function startAuto(){
    timer=setInterval(nextSlide,3000);
}
function stopAuto(){
    clearInterval(timer);
}
function resetTimer(){
    stopAuto();
    startAuto();
}
const sliderBox=document.querySelector(".slider");
sliderBox.addEventListener("mouseenter",stopAuto);
sliderBox.addEventListener("mouseleave",startAuto);