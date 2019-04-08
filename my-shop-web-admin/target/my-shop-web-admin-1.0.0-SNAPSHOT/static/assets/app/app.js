var App = function () {

    // ICheck
    var _masterCheckbox;
    var _checkbox;

    // 用户存放 ID 得数组
    var _idArray;

    /**
     * 私有方法
     */
    var handlerCheckbox = function () {
        // 激活
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass   : 'iradio_minimal-blue'
        });

        // 获取控制 Checkbox
        _masterCheckbox = $('input[type="checkbox\"].minimal.icheck_master');

        // 获取全部 Checkbox 集合
        _checkbox = $('input[type="checkbox\"].minimal');
    };

    /**
     *  checkbox 全选功能
     */
    var handlerCheckBoxAll = function () {
        _masterCheckbox.on("ifClicked", function (e) {
            // 返回 true 表示未选中
            if (e.target.checked){
                _checkbox.iCheck("uncheck");
            }

            // 选中状态
            else {
                _checkbox.iCheck("check");
            }
        });
    };

    /**
     * 批量删除
     */
    var handlerDeleteMulti = function (url) {
        _idArray = new Array();

        // 将选中元素得 ID 放入数组中
        _checkbox.each(function () {
            var _id = $(this).attr("id");
            if (_id != null && _id != "undefine" && $(this).is(":checked")) {
                _idArray.push(_id);
            }
        });

        if (_idArray.length === 0) {
            $("#modal-message").html("您还没有选中任何数据项, 请至少选中一项");
        } else {
            $("#modal-message").html("您确定删除数据项嘛?");
        }

        $("#modal-default").modal("show");

        $("#btnModalOK").bind("click", function () {
            del();
        });

        /**
         * 当前私有函数得私有函数, 删除数据
         */
        function del() {
            $("#modal-default").modal("hide");

            // 如果没有选择数据项得处理
            if (_idArray.length === 0) {
                //..
                // $("#modal-default").modal("hide");
            }

            // 否则, 删除操作
            else {
                setTimeout(function () {
                    $.ajax({
                        "url": url,
                        "type": "POST",
                        "data": {"ids" : _idArray.toString()},
                        "dataType": "JSON",
                        "success": function (data) {
                            // 删除成功
                            if (data.status === 200) {
                                window.location.reload();
                            }

                            // 删除失败
                            else {
                                $("#btnModalOK").unbind("click");
                                $("#btnModalOK").bind("click", function () {
                                    $("#modal-message").modal("hide");
                                });

                                $("#modal-message").html(data.message);
                                $("#modal-default").modal("show");
                            }
                        }
                    })
                }, 500);
            }
        }
    };

    return {
        init: function(){
            handlerCheckbox();
            handlerCheckBoxAll();
        },

        getCheckBox: function () {
            return _checkbox;
        },

        deleteMulti: function (url) {
            handlerDeleteMulti(url);
        }
    }
}();

$(document).ready(function () {
    App.init();
});