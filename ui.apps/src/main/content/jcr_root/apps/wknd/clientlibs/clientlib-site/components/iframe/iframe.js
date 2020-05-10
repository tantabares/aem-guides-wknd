function resizeIframe(obj) {
    obj.contentWindow.document.querySelectorAll('.wknd-header')[0].parentElement.remove();
    obj.contentWindow.document.querySelectorAll('.cmp-layout-container--footer')[0].remove();
    obj.contentWindow.document.querySelectorAll('.root.responsivegrid')[0].classList.remove('root');
    obj.style.height = obj.contentWindow.document.documentElement.scrollHeight + 'px';
}