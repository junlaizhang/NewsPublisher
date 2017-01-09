/**
 * Created by junlai on 2017/1/9.
 */
function startPost() {
    var nav_name=document.getElementById("nav_name").value;
    var nav_weight=document.getElementById("nav_weight").value;
    if(nav_name==""){
        document.getElementById("err_nav_name").innerHTML="<span class='err'>请输入类别名称</span>";
        return;
    }
    if(nav_weight==""){
        document.getElementById("err_nav_weight").innerHTML="<span class='err'>请输入类别排序权重，值越小越靠前</span>";
        return;
    }
    if(isNaN(parseInt(nav_weight))){
        document.getElementById("err_nav_weight").innerHTML="<span class='err'>类别排序必须是数字，值越小越靠前</span>";
        return;
    }
    document.getElementById("frm").submit();

}
