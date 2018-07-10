    var zTreeNodes;
    var setting = {
    	edit:{
    		enable: true,				//数据可修改
			showRemoveBtn: true,		//是否显示删除按钮
			showRenameBtn: true,		//是否显示修改按钮
    	},
        view: {
        	addHoverDom:true,			//用于当鼠标移动到节点上时，显示用户自定义控件
            showLine: false,			//设置 zTree 是否显示节点之间的连线
            showIcon: false,			//设置 zTree 是否显示节点的图标
            addDiyDom: addDiyDom,		//用于在节点上固定显示用户自定义控件
            
        },
        data: {
            simpleData: {
                enable: true
            }
        }
    };
    /**
     * 自定义DOM节点
     */
    function addDiyDom(treeId, treeNode) {
        var spaceWidth = 15;
        var liObj = $("#" + treeNode.tId);
        var aObj = $("#" + treeNode.tId + "_a");
        var switchObj = $("#" + treeNode.tId + "_switch");
        var icoObj = $("#" + treeNode.tId + "_ico");
        var spanObj = $("#" + treeNode.tId + "_span");
        aObj.attr('title', '');
        aObj.append('<div class="diy swich"></div>');
        var div = $(liObj).find('div').eq(0);
        switchObj.remove();
        spanObj.remove();
        icoObj.remove();
        div.append(switchObj);
        div.append(spanObj);
        var spaceStr = "<span style='height:1px;display: inline-block;width:" + (spaceWidth * treeNode.level) + "px'></span>";
        switchObj.before(spaceStr);
        var editStr = '';
        editStr += '<div class="diy">' + (treeNode.CONTACT_USER == null ? '&nbsp;' : treeNode.CONTACT_USER) + '</div>';
        var corpCat = '<div title="' + treeNode.CORP_CAT + '">' + treeNode.CORP_CAT + '</div>';
        editStr += '<div class="diy">' + (treeNode.CORP_CAT == '-' ? '&nbsp;' : corpCat ) + '</div>';
        editStr += '<div class="diy" '+treeNode.id+' >' + (treeNode.CONTACT_PHONE == null ? '&nbsp;' : treeNode.CONTACT_PHONE ) + '</div>';
      /*   editStr += '<div class="diy">' + formatHandle(treeNode) + '</div>'; */
        aObj.append(editStr);
    }
    /**
     * 查询数据
     */
    function query() {
    	
    	
        var data = [{"CONTACT_USER":"张三","CONTACT_PHONE":"18888888888","addFlag":true,"ORG_ID":1,"id":"o1","pId":"onull","open":true,"name":"单位1","modFlag":true,"CORP_CAT":"港口-天然液化气,港口-液化石油气","TYPE":"org","delFlag":true},
                    {"CONTACT_USER":1,"SECTOR_NAME":"部门1","addFlag":true,"CONTACT_PHONE":null,"SECTOR_ID":1,"ORG_ID":1,"id":"s1","pId":"o1","name":"部门1","modFlag":true,"PARENT_ID":null,"CORP_CAT":"港口-天然液化气","TYPE":"sector","delFlag":true},
                    {"CONTACT_USER":2,"SECTOR_NAME":"部门12","addFlag":true,"CONTACT_PHONE":"0","SECTOR_ID":2,"ORG_ID":1,"id":"s2","pId":"s1","name":"部门12","modFlag":true,"PARENT_ID":1,"CORP_CAT":"港口-集装箱","TYPE":"sector","delFlag":true},
                    {"CONTACT_USER":3,"SECTOR_NAME":"部门13","addFlag":true,"CONTACT_PHONE":"0","SECTOR_ID":3,"ORG_ID":1,"id":"s3","pId":"s1","name":"部门13","modFlag":true,"PARENT_ID":1,"CORP_CAT":"港口-集装箱","TYPE":"sector","delFlag":true},
                    {"CONTACT_USER":4,"SECTOR_NAME":"部门24","addFlag":true,"CONTACT_PHONE":"0","SECTOR_ID":4,"ORG_ID":1,"id":"s4","pId":"s2","name":"部门24","modFlag":true,"PARENT_ID":2,"CORP_CAT":"港口-集装箱","TYPE":"sector","delFlag":true},
                    {"CONTACT_USER":5,"SECTOR_NAME":"部门35","addFlag":true,"CONTACT_PHONE":"0","SECTOR_ID":5,"ORG_ID":1,"id":"s5","pId":"s3","name":"部门35","modFlag":true,"PARENT_ID":3,"CORP_CAT":"港口-集装箱","TYPE":"sector","delFlag":true},
                    {"CONTACT_USER":6,"SECTOR_NAME":"部门22","addFlag":true,"CONTACT_PHONE":"0","SECTOR_ID":8,"ORG_ID":1,"id":"s8","pId":"s2","name":"部门22","modFlag":true,"PARENT_ID":2,"CORP_CAT":"-","TYPE":"sector","delFlag":true},
                    {"CONTACT_USER":7,"SECTOR_NAME":"部门23","addFlag":true,"CONTACT_PHONE":"0","SECTOR_ID":9,"ORG_ID":1,"id":"s9","pId":"s2","name":"部门23","modFlag":true,"PARENT_ID":2,"CORP_CAT":"-","TYPE":"sector","delFlag":true},
                    {"CONTACT_USER":8,"SECTOR_NAME":"不爱的是分散","addFlag":true,"CONTACT_PHONE":"1231231","SECTOR_ID":21,"ORG_ID":1,"id":"s21","pId":"o1","name":"不爱的是分散","modFlag":true,"PARENT_ID":null,"CORP_CAT":"港口-天然液化气","TYPE":"sector","delFlag":true},
                    {"CONTACT_USER":9,"SECTOR_NAME":"test","addFlag":true,"CONTACT_PHONE":"222","SECTOR_ID":29,"ORG_ID":1,"id":"s29","pId":"s2","name":"test","modFlag":true,"PARENT_ID":2,"CORP_CAT":"港口-集装箱","TYPE":"sector","delFlag":true},
                    {"CONTACT_USER":10,"SECTOR_NAME":"22","addFlag":true,"CONTACT_PHONE":null,"SECTOR_ID":38,"ORG_ID":1,"id":"s38","pId":"o1","name":"22","modFlag":true,"PARENT_ID":null,"CORP_CAT":"-","TYPE":"sector","delFlag":true},
                    {"CONTACT_USER":11,"SECTOR_NAME":"部门9","addFlag":true,"CONTACT_PHONE":null,"SECTOR_ID":61,"ORG_ID":1,"id":"s61","pId":"o1","name":"部门9","modFlag":true,"PARENT_ID":null,"CORP_CAT":"港口-天然液化气","TYPE":"sector","delFlag":true},
                    {"CONTACT_USER":"sara","SECTOR_NAME":"流星雨","addFlag":true,"CONTACT_PHONE":"11111111111","SECTOR_ID":141,"ORG_ID":1,"id":"s141","pId":"s1","name":"流星雨","modFlag":true,"PARENT_ID":1,"CORP_CAT":"-","TYPE":"sector","delFlag":true},
                    {"CONTACT_USER":"流星","SECTOR_NAME":"1级部门","addFlag":true,"CONTACT_PHONE":"11111111111","SECTOR_ID":142,"ORG_ID":1,"id":"s142","pId":"o1","name":"1级部门","modFlag":true,"PARENT_ID":null,"CORP_CAT":"港口-天然液化气","TYPE":"sector","delFlag":true},
                    {"CONTACT_USER":"11","SECTOR_NAME":"11","addFlag":true,"CONTACT_PHONE":"11111111111","SECTOR_ID":145,"ORG_ID":1,"id":"s145","pId":"s1","name":"11","modFlag":true,"PARENT_ID":1,"CORP_CAT":"港口-集装箱","TYPE":"sector","delFlag":true},
                    {"CONTACT_USER":"ff","SECTOR_NAME":"fff","addFlag":true,"CONTACT_PHONE":"11","SECTOR_ID":146,"ORG_ID":1,"id":"s146","pId":"s1","name":"fff","modFlag":true,"PARENT_ID":1,"CORP_CAT":"港口-油码头","TYPE":"sector","delFlag":true},
                    {"CONTACT_USER":"1","SECTOR_NAME":"1","addFlag":true,"CONTACT_PHONE":"1","SECTOR_ID":161,"ORG_ID":1,"id":"s161","pId":"o1","name":"1","modFlag":true,"PARENT_ID":null,"CORP_CAT":"港口-天然液化气","TYPE":"sector","delFlag":true}];
        //初始化列表
        zTreeNodes = data;
        //初始化树
        $.fn.zTree.init($("#dataTree"), setting, zTreeNodes);
        //添加表头
        /* var li_head = ' <li class="head"><a><div class="diy">名称</div><div class="diy">联系人</div><div class="diy">主管行业</div>' +
            '<div class="diy">联系方式</div></a></li>';
        var rows = $("#dataTree").find('li');
        if (rows.length > 0) {
            rows.eq(0).before(li_head)
        } else {
            $("#dataTree").append(li_head);
            $("#dataTree").append('<li ><div style="text-align: center;line-height: 30px;" >无符合条件数据</div></li>')
        } */
    }
    
    /**
     * 根据权限展示功能按钮
     * @param treeNode
     * @returns {string}
     */
    function formatHandle(treeNode) {
        var htmlStr = '';
       /*  htmlStr += '<div class="icon_div"><a class="icon_view" title="查看"  href="javascript:view(\'' + treeNode.id + '\')"></a></div>';
        htmlStr += '<div class="icon_div"><a class="icon_edit" title="修改" href="javascript:edit(\'' + treeNode.id + '\')"></a></div>';
        htmlStr += '<div class="icon_div"><a class="icon_add" title="添加子部门" href="javascript:addSector(\'' + treeNode.id + '\')"></a></div>';
        htmlStr += '<div class="icon_div"><a class="icon_del" title="删除" href="javascript:del(\'' + treeNode.id + '\')"></a></div>'; */
        return htmlStr;
    }

    $(function () {
        //初始化数据
        query();
    })