(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[2],{"2Fcx":function(e,t,a){e.exports={container:"antd-pro-components-header-dropdown-index-container"}},bsDN:function(e,t,a){e.exports={menu:"antd-pro-components-global-header-index-menu",right:"antd-pro-components-global-header-index-right",action:"antd-pro-components-global-header-index-action",search:"antd-pro-components-global-header-index-search",account:"antd-pro-components-global-header-index-account",avatar:"antd-pro-components-global-header-index-avatar",dark:"antd-pro-components-global-header-index-dark",name:"antd-pro-components-global-header-index-name"}},bx7e:function(e,t,a){"use strict";a.r(t);var n=a("0Owb"),r=a("oBTY"),c=a("CiB2"),o=a("k1fw"),l=(a("J+/v"),a("MoRW")),u=(a("+L6B"),a("2/Rp")),i=a("Hx5s"),s=a("q1tI"),m=a.n(s),d=a("oN5p"),p=a("55Ip"),h=a("9kvl"),f=a("eTk0"),b=(a("+BJd"),a("T2oS"),a("W9HT")),g=(a("Telt"),a("Tckk")),v=(a("lUTK"),a("BvKs")),y=a("fWQN"),E=a("mtLc"),k=a("yKVA"),x=a("Nsem"),O=a("oZsa"),j=a("cJ7L"),N=a("eFNv"),R=a("aIfO"),C=(a("qVdP"),a("jsC+")),T=a("PpiC"),w=a("TSYQ"),I=a.n(w),D=a("2Fcx"),L=a.n(D),z=function(e){var t=e.overlayClassName,a=Object(T["a"])(e,["overlayClassName"]);return m.a.createElement(C["a"],Object(n["a"])({overlayClassName:I()(L.a.container,t)},a))},B=z,J=a("bsDN"),U=a.n(J);function K(e){return function(){var t,a=Object(O["a"])(e);if(M()){var n=Object(O["a"])(this).constructor;t=Reflect.construct(a,arguments,n)}else t=a.apply(this,arguments);return Object(x["a"])(this,t)}}function M(){if("undefined"===typeof Reflect||!Reflect.construct)return!1;if(Reflect.construct.sham)return!1;if("function"===typeof Proxy)return!0;try{return Date.prototype.toString.call(Reflect.construct(Date,[],(function(){}))),!0}catch(e){return!1}}var S=function(e){Object(k["a"])(a,e);var t=K(a);function a(){var e;Object(y["a"])(this,a);for(var n=arguments.length,r=new Array(n),c=0;c<n;c++)r[c]=arguments[c];return e=t.call.apply(t,[this].concat(r)),e.onMenuClick=function(t){var a=t.key;if("logout"!==a)h["c"].push("/account/".concat(a));else{var n=e.props.dispatch;n&&n({type:"login/logout"})}},e}return Object(E["a"])(a,[{key:"render",value:function(){var e=this.props,t=e.currentUser,a=void 0===t?{avatar:"",name:""}:t,n=e.menu,r=m.a.createElement(v["a"],{className:U.a.menu,selectedKeys:[],onClick:this.onMenuClick},n&&m.a.createElement(v["a"].Item,{key:"center"},m.a.createElement(j["a"],null),"\u4e2a\u4eba\u4e2d\u5fc3"),n&&m.a.createElement(v["a"].Item,{key:"settings"},m.a.createElement(N["a"],null),"\u4e2a\u4eba\u8bbe\u7f6e"),n&&m.a.createElement(v["a"].Divider,null),m.a.createElement(v["a"].Item,{key:"logout"},m.a.createElement(R["a"],null),"\u9000\u51fa\u767b\u5f55"));return a&&a.name?m.a.createElement(B,{overlay:r},m.a.createElement("span",{className:"".concat(U.a.action," ").concat(U.a.account)},m.a.createElement(g["a"],{size:"small",className:U.a.avatar,src:a.avatar,alt:"avatar"}),m.a.createElement("span",{className:U.a.name},a.name))):m.a.createElement("span",{className:"".concat(U.a.action," ").concat(U.a.account)},m.a.createElement(b["a"],{size:"small",style:{marginLeft:8,marginRight:8}}))}}]),a}(m.a.Component),F=Object(h["b"])((function(e){var t=e.user;return{currentUser:t.currentUser}}))(S),H=function(e){var t=e.theme,a=e.layout,n=U.a.right;return"dark"===t&&"topmenu"===a&&(n="".concat(U.a.right,"  ").concat(U.a.dark)),m.a.createElement("div",{className:n},m.a.createElement(F,null),!1)},P=Object(h["b"])((function(e){var t=e.settings;return{theme:t.navTheme,layout:t.layout}}))(H),W=a("c+yx"),q=a("mxmt"),A=a.n(q),Q=m.a.createElement(l["a"],{status:403,title:"403",subTitle:"Sorry, you are not authorized to access this page.",extra:m.a.createElement(u["a"],{type:"primary"},m.a.createElement(p["a"],{to:"/user/login"},"Go Login"))}),V=function e(t){return t.map((function(t){var a=Object(o["a"])({},t,{children:t.children?e(t.children):[]});return f["a"].check(t.authority,a,null)}))},Y=m.a.createElement(i["a"],{copyright:"2020 \u4e2d\u5357\u8d22\u7ecf\u653f\u6cd5\u5927\u5b66\u4fe1\u606f\u4e0e\u5b89\u5168\u5de5\u7a0b\u5b66\u9662\u7248\u672c\u6240\u6709",links:[{key:"\u4e2d\u5357\u8d22\u7ecf\u653f\u6cd5\u5927\u5b66",title:"\u4e2d\u5357\u8d22\u7ecf\u653f\u6cd5\u5927\u5b66",href:"http://xagx.zuel.edu.cn/",blankTarget:!0},{key:"github",title:m.a.createElement(d["a"],null),href:"#",blankTarget:!1},{key:"\u4fe1\u606f\u4e0e\u5b89\u5168\u5de5\u7a0b\u5b66\u9662",title:"\u4fe1\u606f\u4e0e\u5b89\u5168\u5de5\u7a0b\u5b66\u9662",href:"http://xagx.zuel.edu.cn/",blankTarget:!0}]}),G=function(e){var t=e.dispatch,a=e.children,o=e.settings,l=e.location,u=void 0===l?{pathname:"/"}:l;Object(s["useEffect"])((function(){t&&t({type:"user/fetchCurrent"})}),[]);var d=function(e){t&&t({type:"global/changeLayoutCollapsed",payload:e})},b=Object(W["a"])(e.route.routes,u.pathname||"/")||{authority:void 0},g=Object(h["e"])();return Object(c["a"])(g),m.a.createElement(i["e"],Object(n["a"])({logo:A.a,menuHeaderRender:function(e,t){return m.a.createElement(p["a"],{to:"/"},e,t)},onCollapse:d,menuItemRender:function(e,t){return e.isUrl||e.children||!e.path?t:m.a.createElement(p["a"],{to:e.path},t)},breadcrumbRender:function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:[];return[{path:"/",breadcrumbName:"\u9996  \u9875"}].concat(Object(r["a"])(e))},itemRender:function(e,t,a,n){var r=0===a.indexOf(e);return r?m.a.createElement(p["a"],{to:n.join("/")},e.breadcrumbName):m.a.createElement("span",null,e.breadcrumbName)},footerRender:function(){return Y},menuDataRender:V,rightContentRender:function(){return m.a.createElement(P,null)}},e,o),m.a.createElement(f["a"],{authority:b.authority,noMatch:Q},a))};t["default"]=Object(h["b"])((function(e){var t=e.global,a=e.settings;return{collapsed:t.collapsed,settings:a}}))(G)}}]);