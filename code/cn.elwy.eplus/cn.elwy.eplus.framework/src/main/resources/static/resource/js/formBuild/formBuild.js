var leipiEditor = UE.getEditor('myFormDesign',{
            //allowDivTransToP: false,//阻止转换div 为p
            toolleipi:true,//是否显示，设计器的 toolbars
            textarea: 'design_content',   
            //这里可以选择自己需要的工具按钮名称,此处仅选择如下五个
           toolbars:[[
            'fullscreen', 'source', '|', 'undo', 'redo', '|','bold', 'italic', 'underline', 'fontborder', 'strikethrough',  'removeformat', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist','|', 'fontfamily', 'fontsize', '|', 'indent', '|', 'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|',  'link', 'unlink',  '|',  'horizontal',  'spechars',  'wordimage', '|', 'inserttable', 'deletetable',  'mergecells',  'splittocells']],
            //focus时自动清空初始化时的内容
            //autoClearinitialContent:true,
            //关闭字数统计
            wordCount:false,
            //关闭elementPath
            elementPathEnabled:false,
            //默认的编辑区域高度
            initialFrameHeight:300
            //,iframeCssUrl:"css/bootstrap/css/bootstrap.css" //引入自身 css使编辑器兼容你网站css
            //更多其他参数，请参考ueditor.config.js中的配置项
        });

 var leipiFormDesign = {
    /*执行控件*/
    exec : function (method) {
        leipiEditor.execCommand(method);
    },
    /*
        Javascript 解析表单
        template 表单设计器里的Html内容
        fields 字段总数
    */
   parse_form:function(template,fields)
    {
        //正则  radios|checkboxs|select 匹配的边界 |--|  因为当使用 {} 时js报错
        var preg =  /(\|-<span(((?!<span).)*leipiplugins=\"(radios|checkboxs|select)\".*?)>(.*?)<\/span>-\||<(img|input|textarea|select).*?(<\/select>|<\/textarea>|\/>))/gi,preg_attr =/(\w+)=\"(.?|.+?)\"/gi,preg_group =/<input.*?\/>/gi;
        if(!fields) fields = 0;

        var template_parse = template,template_data = new Array(),add_fields=new Object(),checkboxs=0;

        var pno = 0;
        template.replace(preg, function(plugin,p1,p2,p3,p4,p5,p6){
            var parse_attr = new Array(),attr_arr_all = new Object(),name = '', select_dot = '' , is_new=false;
            var p0 = plugin;
            var tag = p6 ? p6 : p4;
            //alert(tag + " \n- t1 - "+p1 +" \n-2- " +p2+" \n-3- " +p3+" \n-4- " +p4+" \n-5- " +p5+" \n-6- " +p6);

            if(tag == 'radios' || tag == 'checkboxs')
            {
                plugin = p2;
            }else if(tag == 'select')
            {
                plugin = plugin.replace('|-','');
                plugin = plugin.replace('-|','');
            }
            plugin.replace(preg_attr, function(str0,attr,val) {
                    if(attr=='name')
                    {
                        if(val=='leipiNewField')
                        {
                            is_new=true;
                            fields++;
                            val = 'data_'+fields;
                        }
                        name = val;
                    }
                    
                    if(tag=='select' && attr=='value')
                    {
                        if(!attr_arr_all[attr]) attr_arr_all[attr] = '';
                        attr_arr_all[attr] += select_dot + val;
                        select_dot = ',';
                    }else
                    {
                        attr_arr_all[attr] = val;
                    }
                    var oField = new Object();
                    oField[attr] = val;
                    parse_attr.push(oField);
            }) 
            /*alert(JSON.stringify(parse_attr));return;*/
             if(tag =='checkboxs') /*复选组  多个字段 */
             {
                plugin = p0;
                plugin = plugin.replace('|-','');
                plugin = plugin.replace('-|','');
                var name = 'checkboxs_'+checkboxs;
                attr_arr_all['parse_name'] = name;
                attr_arr_all['name'] = '';
                attr_arr_all['value'] = '';
                
                attr_arr_all['content'] = '<span leipiplugins="checkboxs"  title="'+attr_arr_all['title']+'">';
                var dot_name ='', dot_value = '';
                p5.replace(preg_group, function(parse_group) {
                    var is_new=false,option = new Object();
                    parse_group.replace(preg_attr, function(str0,k,val) {
                        if(k=='name')
                        {
                            if(val=='leipiNewField')
                            {
                                is_new=true;
                                fields++;
                                val = 'data_'+fields;
                            }

                            attr_arr_all['name'] += dot_name + val;
                            dot_name = ',';

                        }
                        else if(k=='value')
                        {
                            attr_arr_all['value'] += dot_value + val;
                            dot_value = ',';

                        }
                        option[k] = val;    
                    });
                    
                    if(!attr_arr_all['options']) attr_arr_all['options'] = new Array();
                    attr_arr_all['options'].push(option);
                    //if(!option['checked']) option['checked'] = '';
                    var checked = option['checked'] !=undefined ? 'checked="checked"' : '';
                    attr_arr_all['content'] +='<input type="checkbox" name="'+option['name']+'" value="'+option['value']+'"  '+checked+'/>'+option['value']+'&nbsp;';

                    if(is_new)
                    {
                        var arr = new Object();
                        arr['name'] = option['name'];
                        arr['leipiplugins'] = attr_arr_all['leipiplugins'];
                        add_fields[option['name']] = arr;

                    }

                });
                attr_arr_all['content'] += '</span>';

                //parse
                template = template.replace(plugin,attr_arr_all['content']);
                template_parse = template_parse.replace(plugin,'{'+name+'}');
                template_parse = template_parse.replace('{|-','');
                template_parse = template_parse.replace('-|}','');
                template_data[pno] = attr_arr_all;
                checkboxs++;

             }else if(name)
            {
                if(tag =='radios') /*单选组  一个字段*/
                {
                    plugin = p0;
                    plugin = plugin.replace('|-','');
                    plugin = plugin.replace('-|','');
                    attr_arr_all['value'] = '';
                    attr_arr_all['content'] = '<span leipiplugins="radios" name="'+attr_arr_all['name']+'" title="'+attr_arr_all['title']+'">';
                    var dot='';
                    p5.replace(preg_group, function(parse_group) {
                        var option = new Object();
                        parse_group.replace(preg_attr, function(str0,k,val) {
                            if(k=='value')
                            {
                                attr_arr_all['value'] += dot + val;
                                dot = ',';
                            }
                            option[k] = val;    
                        });
                        option['name'] = attr_arr_all['name'];
                        if(!attr_arr_all['options']) attr_arr_all['options'] = new Array();
                        attr_arr_all['options'].push(option);
                        //if(!option['checked']) option['checked'] = '';
                        var checked = option['checked'] !=undefined ? 'checked="checked"' : '';
                        attr_arr_all['content'] +='<input type="radio" name="'+attr_arr_all['name']+'" value="'+option['value']+'"  '+checked+'/>'+option['value']+'&nbsp;';

                    });
                    attr_arr_all['content'] += '</span>';

                }else
                {
                    attr_arr_all['content'] = is_new ? plugin.replace(/leipiNewField/,name) : plugin;
                }
                //attr_arr_all['itemid'] = fields;
                //attr_arr_all['tag'] = tag;
                template = template.replace(plugin,attr_arr_all['content']);
                template_parse = template_parse.replace(plugin,'{'+name+'}');
                template_parse = template_parse.replace('{|-','');
                template_parse = template_parse.replace('-|}','');
                if(is_new)
                {
                    var arr = new Object();
                    arr['name'] = name;
                    arr['leipiplugins'] = attr_arr_all['leipiplugins'];
                    add_fields[arr['name']] = arr;
                }
                template_data[pno] = attr_arr_all;

               
            }
            pno++;
        })
        var parse_form = new Object({
            'fields':fields,//总字段数
            'template':template,//完整html
            'parse':template_parse,//控件替换为{data_1}的html
            'data':template_data,//控件属性
            'add_fields':add_fields//新增控件
        });
        return JSON.stringify(parse_form);
    },
    /*type  =  save 保存设计 versions 保存版本  close关闭 */
    fnCheckForm : function ( type ) {
    	
    	
    	if(leipiEditor.queryCommandState( 'source' )){
    		 leipiEditor.execCommand('source');//切换到编辑模式才提交，否则有bug
    	}
    	if(leipiEditor.hasContents()){
    		leipiEditor.sync();/*同步内容*/
    		var type_value='';
    		var formeditor='';
    		fields=$("#fields").val();
        	if( typeof type!=='undefined' ){
        		type_value = type;
        	}
        	if(type_value == 'save'){
              //获取表单设计器里的内容
        		formeditor = leipiEditor.getContent();
        	}
//          //解析表单设计器控件
//          var parse_form = this.parse_form(formeditor,fields);
//          var content = "";
//          $.each(parse_form,function(i, value){
//        	  if(i == 'template'){
//        		  content = value;
//        	  }
//          });
//          //   var content = myObj[0].template;
//          //var reg=/aa/g;//正则匹配
//          var reg1 = new RegExp("{|-","g");//g,表示全部替换。
//          var reg2 = new RegExp("-|}","g");//g,表示全部替换。
//          content=content.replace(reg1,'');
//          content=content.replace(reg2,'');
//          console.info(content);
        	var data = Common.getFormData("#signupForm");
        	data['c_CONTENT'] = formeditor;
        	var parameter = {};
        	parameter.data = data;
        	parameter.operate = type_value;
        	$.ajax({
        		type : "post",
        		contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        		url : bundlePath + "/form", 
        		data : {
        			"parameter" : JSON.stringify(parameter)
        		}, // 这里是要传递的参数，格式为 data: "{paraNamearaValue}",下面将会看到
        		dataType : 'json',
        		success : function(result) { // 回调函数，result，返回值
        			if (result && !result.success) {
        				YssLayer.messageAlter("保存失败！！！", 2);
        				return false;
        			} else {
        				console.info("result.id:	"+result.id);
        				YssLayer.messageDialogOnRightDown("保存成功！！！", 2000);
        			}
        		}
        		
        	});
    	} else {
          alert('表单内容不能为空！')
          $('#submitbtn').button('reset');
          return false;
      }
    	
//        if(leipiEditor.queryCommandState( 'source' ))
//            leipiEditor.execCommand('source');//切换到编辑模式才提交，否则有bug
//            
//        if(leipiEditor.hasContents()){
//            leipiEditor.sync();/*同步内容*/
//            /* $.ajax({
//            	type : "post",
//            	url : "../user?operate=query"
//            	
//            }); */
//            /* alert("你点击了保存,这里可以异步提交，请自行处理...."); */
//           /*  return false; */
//            //--------------以下仅参考-----------------------------------------------------------------------------------------------------
//            var type_value='',formid=0,fields=$("#fields").val(),formeditor='';
//
//            if( typeof type!=='undefined' ){
//                type_value = type;
//            }
//            //获取表单设计器里的内容
//            formeditor=leipiEditor.getContent();
//            //解析表单设计器控件
//            var parse_form = this.parse_form(formeditor,fields);
//            //alert(parse_form);
//            
//             //异步提交数据
//             $.ajax({
//                type: 'POST',
//                url : '../user?operate=save',
//                //dataType : 'json',
//                data : {'type' : type_value,'formid':formid,'parse_form':parse_form},
//                success : function(data){
//                    if(confirm('查看js解析后，提交到服务器的数据，请临时允许弹窗'))
//                    {
//                        win_parse=window.open('','','width=800,height=600');
//                        //这里临时查看，所以替换一下，实际情况下不需要替换  
//                        data  = data.replace(/<\/+textarea/,'&lt;textarea');
//                        win_parse.document.write('<textarea style="width:100%;height:100%">'+data+'</textarea>');
//                        win_parse.focus();
//                    }
//                    
//                    /*
//                  if(data.success==1){
//                      alert('保存成功');
//                      $('#submitbtn').button('reset');
//                  }else{
//                      alert('保存失败！');
//                  }*/
//                }
//            });
//            
//        } else {
//            alert('表单内容不能为空！')
//            $('#submitbtn').button('reset');
//            return false;
//        }
    } ,
    /*预览表单*/
    fnReview : function (){
        if(leipiEditor.queryCommandState( 'source' ))
            leipiEditor.execCommand('source');/*切换到编辑模式才提交，否则部分浏览器有bug*/
            
        if(leipiEditor.hasContents()){
            leipiEditor.sync();       /*同步内容*/
            
             /* alert("你点击了预览,请自行处理....");
            return false; */
            //--------------以下仅参考-------------------------------------------------------------------

            /*设计form的target 然后提交至一个新的窗口进行预览*/
            document.saveform.target="mywin";
            window.open('','mywin',"menubar=0,toolbar=0,status=0,resizable=1,left=0,top=0,scrollbars=1,width=" +(screen.availWidth-10) + ",height=" + (screen.availHeight-50) + "\"");

            document.saveform.action="/index.php?s=/index/preview.html";
            document.saveform.submit(); //提交表单
        } else {
            alert('表单内容不能为空！');
            return false;
        }
    }
};
 	//input
	function textMD(){
		$("#textBox").html("<div><label>文本框</label><input class='form-control form-control-inline' name='text' style='text-align: left; width: 150px;height:18px;'  title='文本框' value='' name='leipiNewField' orgheight='' orgwidth='150' orgalign='left' orgfontsize='' orghide='0' leipiplugins='text' orgtype='text'/></div>");
	}
	function textDS(){
		$("#textBox").html("<i class='glyphicon glyphicon-list-alt'></i>文本框");
	}
	 function textMS(){
		$("#textBox").html("<i class='glyphicon glyphicon-list-alt'></i>文本框");
	} 
	//textarea
	 function textareaMD(){
		$("#textareaBox").html("<div><label>文本域</label><textarea title='文本域' class='form-control form-control-inline' name='leipiNewField' leipiplugins='textarea' value='' orgrich='0' orgfontsize='12' orgwidth='600' orgheight='80' style='font-size:12px;width:600px;height:80px;'></textarea></div>");
	}
	function textareaDS(){
		$("#textareaBox").html("<i class='glyphicon glyphicon-menu-hamburger'></i>文本域");
	}
	 function textareaMS(){
		$("#textareaBox").html("<i class='glyphicon glyphicon-menu-hamburger'></i>文本域");
	} 
	 //select
	 function selectMD(){
		$("#selectBox").html("<div id='www'  ><label>下拉框</label>{|-<span leipiplugins='select'><select name='leipiNewField' url='' class='form-control form-control-inline selectpicker' title='下拉菜单' leipiplugins='select' size='1' orgwidth='150' style='width: 150px;'><option value='下拉'> 下拉 </option> <option value='菜单'> 菜单</option></select>&nbsp;&nbsp;</span>-|}</div>");
	}
	function selectDS(){
		$("#selectBox").html("<i class='glyphicon glyphicon-hand-down'></i>下拉菜单");
	}
	 function selectMS(){
		$("#selectBox").html("<i class='glyphicon glyphicon-hand-down'></i>下拉菜单");
	} 
	 //date
	 function dateMD(){
		$("#dateBox").html("<div><label>时间</label><input id='d_BIRTH' name='d_BIRTH'  title='时间控件' value='' style='width: 150px;height:20px' class='laydate-icon form-control layer-date form-control-inline' leipiplugins='date' orgtype='date'></div>");
	}
	function dateDS(){
		$("#dateBox").html("<i class='glyphicon glyphicon-calendar'</i>时间控件");
	}
	 function dateMS(){
		$("#dateBox").html("<i class='glyphicon glyphicon-calendar'></i>时间控件");
	} 
	 //radios
	 function radiosMD(){
		 $("#radiosBox").html("<div><label>单选框</label>{|-<span leipiplugins='radios'  title='单选' name='leipiNewField'><input  value='单选1'   type='radio' checked='checked'/>单选1&nbsp; <input  value='单选2'  type='radio'/>单选2&nbsp; </span>-|}<div>");
	}
	function radiosDS(){
		$("#radiosBox").html("<i class='glyphicon glyphicon-record'></i>单选框");
	}
	 function radiosMS(){
		$("#radiosBox").html("<i class='glyphicon glyphicon-record'></i>单选框");
	} 
	 //checkboxs
	 function checkboxsMD(){
		$("#checkboxsBox").html("<div><label>复选框</label>{|-<span leipiplugins='checkboxs' title='复选' class='form-control form-control-inline'><input name='leipiNewField' value='复选1'  type='checkbox' checked='checked'/>复选1&nbsp;<input name='leipiNewField' value='复选2'  type='checkbox'   checked='checked'/>复选2&nbsp;<input name='leipiNewField' value='复选3'  type='checkbox'/>复选3&nbsp;</span>-|}</div>");
	}
	function checkboxsDS(){
		$("#checkboxsBox").html("<i class='glyphicon glyphicon-unchecked'></i>复选框");
	}
	 function checkboxsMS(){
		$("#checkboxsBox").html("<i class='glyphicon glyphicon-unchecked'></i>复选框");
	} 
	 //hidden
	 function hiddenMD(){
		$("#hiddenBox").html("<div><label>隐藏域</label><input class='form-control form-control-inline'  style='text-align: left; width: 150px;height:18px;'  title='文本框' value='' name='leipiNewField' orgheight='' orgwidth='150' orgalign='left' orgfontsize='' orghide='0' leipiplugins='hidden' orgtype='hidden'/></div>");
	}
	function hiddenDS(){
		$("#hiddenBox").html("<i class='glyphicon glyphicon-hd-video'></i>隐藏域框");
	}
	 function hiddenMS(){
		$("#hiddenBox").html("<i class='glyphicon glyphicon-hd-video'></i>隐藏域框");
	} 
	 //button
	 function buttonMD(){
		$("#buttonBox").html("<input type='button' class='btn-primary' style='text-align: left; width: 50px;height:30px;'  title='按钮' value='按钮' name='leipiNewField' orgheight='' orgwidth='150' orgalign='left' orgfontsize='' orghide='0' leipiplugins='button' orgtype='button'>");
	}
	function buttonDS(){
		$("#buttonBox").html("<i class='glyphicon glyphicon-sound-dolby'></i>按钮");
	}
	 function buttonMS(){
		$("#buttonBox").html("<i class='glyphicon glyphicon-sound-dolby'></i>按钮");
	} 
	 //FileUpload
	 function fileUploadMD(){
		$("#fileUploadBox").html("<input type='file' class='form-control form-control-inline' style='text-align: left; width: 300px;height:30px;'  title='按钮' value='按钮' name='leipiNewField' orgheight='' orgwidth='150' orgalign='left' orgfontsize='' orghide='0' leipiplugins='fileUpload' orgtype='fileUpload'>");
	}
	function fileUploadDS(){
		$("#fileUploadBox").html("<i class='glyphicon glyphicon-eject'></i>文件上传");
	}
	 function fileUploadMS(){
		$("#fileUploadBox").html("<i class='glyphicon glyphicon-eject'></i>文件上传");
	}
	 $(function(){ 
	 //这个方法需要在显示select之前调用。
	     var pid = $("#id").val();
	     console.log(pid);
	     $("select[name=leipiNewField]").empty();     //清空seletct的数据  
	     $.ajax({
	         type:"POST",                        //post请求
	         url:"url",                          //请求后台action 根据需求请求自己的后台数据
	         data:{"pid":pid},                   //传到后台的参数，后台需要编写get和set方法且和返回数据名相同。
	         dataType:"json",                    //预期服务器返回的数据类型
	         error:function(){                   //ajax错误的方法
	         },   
	         success:function(data){            //ajax成功的方法 在里卖弄给select的<option>标签赋值
	             //向select中append、option标签
	             var optionString = "<option grade=\'请选择一级属性\' selected = \'selected\'>--请选择一级属性--</option>";
	             var beanList = data;            //返回的json数据
	             if(beanList){                   //判断
	                 for(var i=0; i<beanList.length; i++){ //遍历，动态赋值
	                     optionString +="<option grade=\""+beanList[i].id+"\" value=\""+beanList[i].id+"\"";  //><option value='下拉'> 下拉 </option>
	                     optionString += ">"+beanList[i].name+"</option>";  //动态添加数据  
	                 }  $("select[name=leipiNewField]").append(optionString);  // 为当前name为asd的select添加数据。
	             }  
	         }  
	     });  
	 }); 
	 
		/*//日期控制
		var start = {
			   elem: '#d_BIRTH',
			   format: 'YYYY-MM-DD',
			   min: laydate.now(), //设定最小日期为当前日期
			   max: '2099-06-16', //最大日期
			   istime: true,
			   istoday: false,
			   choose: function(datas){
			      end.min = datas; //开始日选好后，重置结束日的最小日期
			      end.start = datas //将结束日的初始值设定为开始日
			   }
			 };
			 var end = {
			   elem: '#d_ON_JOB',
			   format: 'YYYY-MM-DD',
			   min: laydate.now(),
			   max: '2099-06-16',
			   istime: true,
			   istoday: false,
			   choose: function(datas){
			     start.max = datas; //结束日选好后，重置开始日的最大日期
			   }
			 };
			 laydate(start);
			 laydate(end);*/
	 