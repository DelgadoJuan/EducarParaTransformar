(function(){
    const listElements = document.querySelectorAll('.nav-item--show');
    const list = document.querySelector('.nav-list');
    const menu = document.querySelector('.ham');

    const addClick = ()=>{
        listElements.forEach(element =>{
            element.addEventListener('click',()=>{

                let subMenu = element.children[1]
                let height = 0;
                element.classList.toggle('menu-item--active');

                if(subMenu.clientHeight === 0){
                    height = subMenu.scrollHeight;
                }

                subMenu.style.height = `${height}px`;

            });
        });
    }


    const deleteStyleHeight = ()=>{
        listElements.forEach(element =>{
            if(element.children[1].getAttribute ('style')){
                element.children[1].removeAttribute ('style');
                element.classList.remove('menu-item--active');
            }
        })
    }

    window.addEventListener('resize',()=>{
        if(window.innerWidth > 1200) {
            deleteStyleHeight();
            if (list.classList.contains('nav-list--show')) {
                list.classList.remove('nav-list--show');
            }
    
        }else{
            addClick();
        }
    });

    if(window.innerWidth <= 1200) {
        addClick();
    }

    menu.addEventListener('click',()=>{
        list.classList.toggle('nav-list--show')
    })

})();  


//POPUP EMPLEO
document.querySelector(".close-btn").addEventListener('click',()=>{
    //document.querySelector(".popup-center").classList.add('hide-popup');
    //document.querySelector(".popup-background").classList.add('hide-popup');

    document.querySelector(".popup-center").classList.remove('show-popup');
    document.querySelector(".popup-background").classList.remove('show-popup');
})

document.querySelector(".btn-popup").addEventListener('click',()=>{
    //document.querySelector(".popup-center").classList.add('hide-popup');
    //document.querySelector(".popup-background").classList.add('hide-popup');

    document.querySelector(".popup-center").classList.remove('show-popup');
    document.querySelector(".popup-background").classList.remove('show-popup');
})

document.querySelector(".unete-btn").addEventListener('click',()=>{
    document.querySelector(".popup-center").classList.add('show-popup');
    document.querySelector(".popup-background").classList.add('show-popup');
})



//POPUP COMMENT
document.querySelector(".close-btn-cm").addEventListener('click',()=>{
    document.querySelector(".popup-center-cm").classList.remove('show-popup');
    document.querySelector(".popup-background").classList.remove('show-popup');
})

document.querySelector(".btn-popup-cm").addEventListener('click',()=>{
    document.querySelector(".popup-center-cm").classList.remove('show-popup');
    document.querySelector(".popup-background").classList.remove('show-popup');
})

document.querySelector(".cm-btn").addEventListener('click',()=>{
    document.querySelector(".popup-center-cm").classList.add('show-popup');
    document.querySelector(".popup-background").classList.add('show-popup');
})
