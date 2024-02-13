$(function(){
    $('#btEnviar').click((e)=>{
        e.preventDefault();
        $('.erromsg').remove();
        validate();
    })

    $('#form input').change((e)=>{
        $('.erromsg').remove();
        validate();
    })
})

let erromsg = '<div class="erromsg"><span></span></div>'
let validateRequiredMsg =  "Campo de preenchimento obrigatorio.";
let validateTelMsg = "Formato de Telefone invalido.";
let validatePassWordLength = "Tamanho da senha invalido por gentileza informar um senha entre 4 e 8 caracteres."
let validateRpasswordIgual = "As senhas não são iguais."

function validate(){
    $('#form input').each(function(){
        if($(this).val() === ""){
            $(this).addClass('invalid');
            $(this).after(erromsg);
            $('.erromsg span').html(validateRequiredMsg);
            $(this).focus();
            return false;
        }else{
            $(this).removeClass('invalid');
            
        }

        if($(this).hasClass('tel')){
            let tel = new RegExp(/^(\(?[0-9]{2}\)?)\s?[0-9]{4,5}(-?)[0-9]{4}$/);
            if(!tel.test($.trim($.trim($(this).val())))){
                $(this).addClass('invalid');
                $(this).after(erromsg);
                $('.erromsg span').html(validateTelMsg);
                $(this).focus();
                return false;
            }else{
                $(this).removeClass('invalid');
            }
        }

        if($(this).hasClass('password')){
            if(($(this).val().length > 8)||($(this).val().length < 4)){
                $(this).addClass('invalid');
                $(this).after(erromsg);
                $('.erromsg span').html(validatePassWordLength);
                $(this).focus();
                return false;
            }else{
                $(this).removeClass('invalid');
            }
        }

        if($(this).hasClass('rpassword')){
            if($(this).val() != $('.password').val()){
                $(this).addClass('invalid');
                $(this).after(erromsg);
                $('.erromsg span').html(validateRpasswordIgual);
                $(this).focus();
                return false;
            }else{
                $(this).removeClass('invalid');
            }
        }
    })
}