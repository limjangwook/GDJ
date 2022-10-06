

document.getElementById('btn_signin').onclick = function(event){
    var pw = document.getElementById('pw');
    var id = document.getElementById('id');
    if(id.value == '') {
        alert('ID를 입력하세요.');
        event.preventDefault();
        return;
    }
    if(id.value.length < 4) {
        alert('ID는 4자 이상 입력하세요.');
        event.preventDefault();
        return;
    }
    if(pw.value == '') {
        alert('비밀번호를 입력하세요.');
        event.preventDefault();
        return;
    }
    if(pw.value.length < 4) {
        alert('비밀번호를 4자 이상 입력하세요.');
        event.preventDefault();
        return;
    }
}
document.getElementById('id').onkeyup = function(event){
    var id = document.getElementById('id');
    var is_msg = document.getElementById('id_msg');
    if(id.value.length == 0) {
        id_msg.textContent = '';
    } else if(id.value.length < 4) {
        id_msg.textContent = '아이디는 4자 이상입니다.';
    } else if(id.value.length >= 4) {
        id_msg.textContent = '정상적인 아이디입니다.';
    }
}


