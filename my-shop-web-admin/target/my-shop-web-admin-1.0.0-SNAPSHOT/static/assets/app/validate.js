/**
 * 函数对象
 */
var Validate = function () {

    /**
     * 初始化 jquery validation
     */
    var handlerInitValidate = function () {
        $.validator.addMethod("mobile", function(value, element) {
            var length = value.length;
            var mobile =  /^1([38]\d|5[0-35-9]|7[3678])\d{8}$/;
            return this.optional(element) || (length == 11 && mobile.test(value));
        }, "手机号码格式错误");

        $("#inputForm").validate({
            errorElement: 'span',
            errorClass: 'help-block',

            errorPlacement: function (error, element) {
                element.parent().parent().attr("class", "form-group has-error");
                error.insertAfter(element);
            }
        });
    };
    
    return {
        init: function () {
            handlerInitValidate();
        }
    }
}();

$(document).ready(function () {
   Validate.init();
});