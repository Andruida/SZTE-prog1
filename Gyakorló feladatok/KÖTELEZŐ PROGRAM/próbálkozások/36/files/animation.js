function collapseSection(element) {
    const sectionHeight = element.scrollHeight;
    var elementTransition = element.style.transition;
    element.style.transition = '';
    requestAnimationFrame(function() {
        element.style.height = sectionHeight + 'px';
        element.style.transition = elementTransition;

        requestAnimationFrame(function() {
            element.style.height = 0 + 'px';
        });
    });

    element.setAttribute('data-collapsed', 'true')
}

function expandSection(element) {
    var sectionHeight = element.scrollHeight;
    element.style.height = sectionHeight + 'px';

    element.addEventListener('transitionend', function(e) {
        element.removeEventListener('transitionend', arguments.callee);
        element.style.height = 'auto';
    });

    element.setAttribute('data-collapsed', 'false');
}


const accordion = document.getElementsByClassName('label');

for (let i = 0; i < accordion.length; i++) {
    accordion[i].addEventListener('click', function() {
        this.classList.toggle('active');

        const section = accordion[i].nextElementSibling;
        const isCollapsed = section.getAttribute('data-collapsed') !== 'false';

        if(isCollapsed) {
            expandSection(section)
            section.setAttribute('data-collapsed', 'false')
        } else {
            collapseSection(section)
        }
    });
}

const circles = document.getElementsByClassName('percentage');
for (let i = 0; i < circles.length; i++) {
    const percentage = circles[i].getAttribute("value");
    circles[i].getElementsByTagName("circle")[1].style.strokeDashoffset = (170 - (170 * percentage) / 100);
}