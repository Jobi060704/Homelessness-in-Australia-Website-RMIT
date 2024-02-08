let slideIndex = 1;


showSlides(slideIndex);

CodeStartup();

function CodeStartup()
{
let slidesx = document.getElementsByClassName("mySlides");
slidesx[0].style.display = "block";
slidesx[1].style.display = "none";
slidesx[2].style.display = "none";

}



// Next/previous controls
function plusSlides(n) {
  showSlides(slideIndex += n);
}

// Thumbnail image controls
function currentSlide(n) {
  
   
    
    
  if(n == 1 ){
    document.getElementById("hyper").href="shorturl.at/vDLOS";
    document.getElementById("spax").textContent = "shorturl.at/vDLOS";
  } else if(n == 2 ){
    document.getElementById("hyper").href="shorturl.at/oC467";
    document.getElementById("spax").textContent = "shorturl.at/oC467";
  } else if (n == 3 ){
    document.getElementById("hyper").href="shorturl.at/oDLQU";
    document.getElementById("spax").textContent = "shorturl.at/oDLQU";
  }
  showSlides(slideIndex = n);
  
}


function showSlides(n) {

    
    let i;
    let slides = document.getElementsByClassName("mySlides");
    let dots = document.getElementsByClassName("dot");
    if (n > slides.length) {slideIndex = 1}
    if (n < 1) {slideIndex = slides.length}
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    slides[slideIndex-1].style.display = "block";
    dots[slideIndex-1].className += " active";
    }
    

    