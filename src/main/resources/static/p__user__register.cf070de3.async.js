(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[15],{a3w7:function(e,r,a){"use strict";a.r(r);a("+L6B");var s=a("2/Rp"),t=(a("Q9mQ"),a("diRs")),n=(a("MXD1"),a("CFYs")),i=a("k1fw"),l=(a("miYZ"),a("tsqr")),o=a("tJVT"),d=(a("5NDa"),a("5rEg")),u=(a("OaEy"),a("2fM7")),c=(a("y8nQ"),a("Vl3Y")),g=a("q1tI"),m=a.n(g),p=a("9kvl"),f=a("55Ip"),h=a("sYde"),E=a.n(h),w=c["a"].Item,b=u["a"].Option,v=d["a"].Group,y={ok:m.a.createElement("div",{className:E.a.success},m.a.createElement(p["a"],{id:"userandregister.strength.strong"})),pass:m.a.createElement("div",{className:E.a.warning},m.a.createElement(p["a"],{id:"userandregister.strength.medium"})),poor:m.a.createElement("div",{className:E.a.error},m.a.createElement(p["a"],{id:"userandregister.strength.short"}))},N={ok:"success",pass:"normal",poor:"exception"},j=function(e){var r,a=e.submitting,h=e.dispatch,j=e.userAndregister,O=Object(g["useState"])(!1),M=Object(o["a"])(O,2),F=M[0],k=M[1],q=Object(g["useState"])("86"),V=Object(o["a"])(q,2),z=V[0],A=V[1],C=Object(g["useState"])(!1),I=Object(o["a"])(C,2),Y=I[0],x=I[1],S=!1,J=c["a"].useForm(),P=Object(o["a"])(J,1),Q=P[0];Object(g["useEffect"])((function(){if(j){var e=Q.getFieldValue("userName");"ok"===j.status&&(l["a"].success("\u6ce8\u518c\u6210\u529f\uff01"),p["c"].push({pathname:"/user/register-result",state:{account:e}}))}}),[j]),Object(g["useEffect"])((function(){return function(){clearInterval(r)}}),[]);var R=function(){var e=Q.getFieldValue("password");return e&&e.length>9?"ok":e&&e.length>5?"pass":"poor"},T=function(e){h({type:"userAndregister/submit",payload:Object(i["a"])({},e,{prefix:z})})},D=Object(p["e"])(),B=function(e,r){var a=Promise;return r&&r!==Q.getFieldValue("password")?a.reject(D.formatMessage({id:"userandregister.password.twice"})):a.resolve()},G=function(e,r){var a=Promise;return r?(F||k(!!r),x(!Y),r.length<6?a.reject(""):(r&&S&&Q.validateFields(["confirm"]),a.resolve())):(k(!!r),a.reject(D.formatMessage({id:"userandregister.password.required"})))},L=function(e){A(e)},U=function(){var e=Q.getFieldValue("password"),r=R();return e&&e.length?m.a.createElement("div",{className:E.a["progress-".concat(r)]},m.a.createElement(n["a"],{status:N[r],className:E.a.progress,strokeWidth:6,percent:10*e.length>100?100:10*e.length,showInfo:!1})):null};return m.a.createElement("div",{className:E.a.main},m.a.createElement(c["a"],{form:Q,name:"UserRegister",onFinish:T},m.a.createElement(w,{name:"userName",rules:[{required:!0,message:D.formatMessage({id:"userandregister.userName.required"})}]},m.a.createElement(d["a"],{size:"large",placeholder:D.formatMessage({id:"userandregister.userName.placeholder"})})),m.a.createElement(t["a"],{getPopupContainer:function(e){return e&&e.parentNode?e.parentNode:e},content:F&&m.a.createElement("div",{style:{padding:"4px 0"}},y[R()],U(),m.a.createElement("div",{style:{marginTop:10}},m.a.createElement(p["a"],{id:"userandregister.strength.msg"}))),overlayStyle:{width:240},placement:"right",visible:F},m.a.createElement(w,{name:"password",className:Q.getFieldValue("password")&&Q.getFieldValue("password").length>0&&E.a.password,rules:[{validator:G}]},m.a.createElement(d["a"],{size:"large",type:"password",placeholder:D.formatMessage({id:"userandregister.password.placeholder"})}))),m.a.createElement(w,{name:"confirm",rules:[{required:!0,message:D.formatMessage({id:"userandregister.confirm-password.required"})},{validator:B}]},m.a.createElement(d["a"],{size:"large",type:"password",placeholder:D.formatMessage({id:"userandregister.confirm-password.placeholder"})})),m.a.createElement(v,{compact:!0},m.a.createElement(u["a"],{size:"large",value:z,onChange:L,style:{width:"20%"}},m.a.createElement(b,{value:"86"},"+86")),m.a.createElement(w,{style:{width:"80%"},name:"mobile",rules:[{required:!0,message:D.formatMessage({id:"userandregister.phone-number.required"})},{pattern:/^\d{11}$/,message:D.formatMessage({id:"userandregister.phone-number.wrong-format"})}]},m.a.createElement(d["a"],{size:"large",placeholder:D.formatMessage({id:"userandregister.phone-number.placeholder"})}))),m.a.createElement(w,null,m.a.createElement(s["a"],{size:"large",loading:a,className:E.a.submit,type:"primary",htmlType:"submit"},m.a.createElement(p["a"],{id:"userandregister.register.register"})),m.a.createElement(f["a"],{className:E.a.login,to:"/user/login"},m.a.createElement(p["a"],{id:"userandregister.register.sign-in"})))))};r["default"]=Object(p["b"])((function(e){var r=e.userAndregister,a=e.loading;return{userAndregister:r,submitting:a.effects["userAndregister/submit"]}}))(j)},sYde:function(e,r,a){e.exports={main:"antd-pro-pages-user-register-style-main",password:"antd-pro-pages-user-register-style-password",getCaptcha:"antd-pro-pages-user-register-style-getCaptcha",submit:"antd-pro-pages-user-register-style-submit",login:"antd-pro-pages-user-register-style-login",success:"antd-pro-pages-user-register-style-success",warning:"antd-pro-pages-user-register-style-warning",error:"antd-pro-pages-user-register-style-error","progress-pass":"antd-pro-pages-user-register-style-progress-pass",progress:"antd-pro-pages-user-register-style-progress"}}}]);