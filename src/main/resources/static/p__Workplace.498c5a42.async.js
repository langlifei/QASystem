(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[13],{"+lVK":function(t,e,n){t.exports={activitiesList:"antd-pro-pages-workplace-style-activitiesList",username:"antd-pro-pages-workplace-style-username",event:"antd-pro-pages-workplace-style-event",pageHeaderContent:"antd-pro-pages-workplace-style-pageHeaderContent",avatar:"antd-pro-pages-workplace-style-avatar",content:"antd-pro-pages-workplace-style-content",contentTitle:"antd-pro-pages-workplace-style-contentTitle",extraContent:"antd-pro-pages-workplace-style-extraContent",statItem:"antd-pro-pages-workplace-style-statItem",members:"antd-pro-pages-workplace-style-members",member:"antd-pro-pages-workplace-style-member",projectList:"antd-pro-pages-workplace-style-projectList",cardTitle:"antd-pro-pages-workplace-style-cardTitle",projectGrid:"antd-pro-pages-workplace-style-projectGrid",projectItemContent:"antd-pro-pages-workplace-style-projectItemContent",datetime:"antd-pro-pages-workplace-style-datetime",activeCard:"antd-pro-pages-workplace-style-activeCard"}},TlNt:function(t,e,n){"use strict";n.r(e);n("14J3");var r=n("BMrR"),o=(n("jCWc"),n("kPKH")),a=(n("IzEo"),n("bx4M")),c=(n("Mwp2"),n("VXEj")),i=n("fWQN"),u=n("mtLc"),l=n("yKVA"),s=n("Nsem"),f=n("oZsa"),p=(n("aHsQ"),n("sGsY")),y=(n("Telt"),n("Tckk")),m=(n("cIOH"),n("oIFs"),n("q1tI")),b=n.n(m),v=n("TSYQ"),d=n.n(v);function h(){return h=Object.assign||function(t){for(var e=1;e<arguments.length;e++){var n=arguments[e];for(var r in n)Object.prototype.hasOwnProperty.call(n,r)&&(t[r]=n[r])}return t},h.apply(this,arguments)}var g=function(t){var e=t.prefixCls,n=t.className,r=t.width,o=t.style;return m["createElement"]("h3",{className:d()(e,n),style:h({width:r},o)})},w=g;function k(t){return k="function"===typeof Symbol&&"symbol"===typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"===typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t},k(t)}function O(t){return P(t)||S(t)||E(t)||j()}function j(){throw new TypeError("Invalid attempt to spread non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}function E(t,e){if(t){if("string"===typeof t)return C(t,e);var n=Object.prototype.toString.call(t).slice(8,-1);return"Object"===n&&t.constructor&&(n=t.constructor.name),"Map"===n||"Set"===n?Array.from(n):"Arguments"===n||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)?C(t,e):void 0}}function S(t){if("undefined"!==typeof Symbol&&Symbol.iterator in Object(t))return Array.from(t)}function P(t){if(Array.isArray(t))return C(t)}function C(t,e){(null==e||e>t.length)&&(e=t.length);for(var n=0,r=new Array(e);n<e;n++)r[n]=t[n];return r}function _(t,e){if(!(t instanceof e))throw new TypeError("Cannot call a class as a function")}function x(t,e){for(var n=0;n<e.length;n++){var r=e[n];r.enumerable=r.enumerable||!1,r.configurable=!0,"value"in r&&(r.writable=!0),Object.defineProperty(t,r.key,r)}}function R(t,e,n){return e&&x(t.prototype,e),n&&x(t,n),t}function N(t){return function(){var e,n=D(t);if(I()){var r=D(this).constructor;e=Reflect.construct(n,arguments,r)}else e=n.apply(this,arguments);return T(this,e)}}function T(t,e){return!e||"object"!==k(e)&&"function"!==typeof e?A(t):e}function A(t){if(void 0===t)throw new ReferenceError("this hasn't been initialised - super() hasn't been called");return t}function I(){if("undefined"===typeof Reflect||!Reflect.construct)return!1;if(Reflect.construct.sham)return!1;if("function"===typeof Proxy)return!0;try{return Date.prototype.toString.call(Reflect.construct(Date,[],(function(){}))),!0}catch(t){return!1}}function D(t){return D=Object.setPrototypeOf?Object.getPrototypeOf:function(t){return t.__proto__||Object.getPrototypeOf(t)},D(t)}function L(t,e){if("function"!==typeof e&&null!==e)throw new TypeError("Super expression must either be null or a function");t.prototype=Object.create(e&&e.prototype,{constructor:{value:t,writable:!0,configurable:!0}}),e&&H(t,e)}function H(t,e){return H=Object.setPrototypeOf||function(t,e){return t.__proto__=e,t},H(t,e)}var U=function(t){L(n,t);var e=N(n);function n(){return _(this,n),e.apply(this,arguments)}return R(n,[{key:"getWidth",value:function(t){var e=this.props,n=e.width,r=e.rows,o=void 0===r?2:r;return Array.isArray(n)?n[t]:o-1===t?n:void 0}},{key:"render",value:function(){var t=this,e=this.props,n=e.prefixCls,r=e.className,o=e.style,a=e.rows,c=O(Array(a)).map((function(e,n){return m["createElement"]("li",{key:n,style:{width:t.getWidth(n)}})}));return m["createElement"]("ul",{className:d()(n,r),style:o},c)}}]),n}(m["Component"]),z=U,M=n("H84U");function B(t){return B="function"===typeof Symbol&&"symbol"===typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"===typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t},B(t)}function W(){return W=Object.assign||function(t){for(var e=1;e<arguments.length;e++){var n=arguments[e];for(var r in n)Object.prototype.hasOwnProperty.call(n,r)&&(t[r]=n[r])}return t},W.apply(this,arguments)}function q(t,e,n){return e in t?Object.defineProperty(t,e,{value:n,enumerable:!0,configurable:!0,writable:!0}):t[e]=n,t}function G(t,e){if(!(t instanceof e))throw new TypeError("Cannot call a class as a function")}function K(t,e){for(var n=0;n<e.length;n++){var r=e[n];r.enumerable=r.enumerable||!1,r.configurable=!0,"value"in r&&(r.writable=!0),Object.defineProperty(t,r.key,r)}}function V(t,e,n){return e&&K(t.prototype,e),n&&K(t,n),t}function J(t){return function(){var e,n=X(t);if(Y()){var r=X(this).constructor;e=Reflect.construct(n,arguments,r)}else e=n.apply(this,arguments);return Q(this,e)}}function Q(t,e){return!e||"object"!==B(e)&&"function"!==typeof e?F(t):e}function F(t){if(void 0===t)throw new ReferenceError("this hasn't been initialised - super() hasn't been called");return t}function Y(){if("undefined"===typeof Reflect||!Reflect.construct)return!1;if(Reflect.construct.sham)return!1;if("function"===typeof Proxy)return!0;try{return Date.prototype.toString.call(Reflect.construct(Date,[],(function(){}))),!0}catch(t){return!1}}function X(t){return X=Object.setPrototypeOf?Object.getPrototypeOf:function(t){return t.__proto__||Object.getPrototypeOf(t)},X(t)}function Z(t,e){if("function"!==typeof e&&null!==e)throw new TypeError("Super expression must either be null or a function");t.prototype=Object.create(e&&e.prototype,{constructor:{value:t,writable:!0,configurable:!0}}),e&&$(t,e)}function $(t,e){return $=Object.setPrototypeOf||function(t,e){return t.__proto__=e,t},$(t,e)}var tt=function(t){Z(n,t);var e=J(n);function n(){return G(this,n),e.apply(this,arguments)}return V(n,[{key:"render",value:function(){var t,e,n=this.props,r=n.prefixCls,o=n.className,a=n.style,c=n.size,i=n.shape,u=d()((t={},q(t,"".concat(r,"-lg"),"large"===c),q(t,"".concat(r,"-sm"),"small"===c),t)),l=d()((e={},q(e,"".concat(r,"-circle"),"circle"===i),q(e,"".concat(r,"-square"),"square"===i),q(e,"".concat(r,"-round"),"round"===i),e)),s="number"===typeof c?{width:c,height:c,lineHeight:"".concat(c,"px")}:{};return m["createElement"]("span",{className:d()(r,o,u,l),style:W(W({},s),a)})}}]),n}(m["Component"]),et=tt;function nt(t,e,n){return e in t?Object.defineProperty(t,e,{value:n,enumerable:!0,configurable:!0,writable:!0}):t[e]=n,t}function rt(){return rt=Object.assign||function(t){for(var e=1;e<arguments.length;e++){var n=arguments[e];for(var r in n)Object.prototype.hasOwnProperty.call(n,r)&&(t[r]=n[r])}return t},rt.apply(this,arguments)}function ot(t,e){if(!(t instanceof e))throw new TypeError("Cannot call a class as a function")}function at(t,e){for(var n=0;n<e.length;n++){var r=e[n];r.enumerable=r.enumerable||!1,r.configurable=!0,"value"in r&&(r.writable=!0),Object.defineProperty(t,r.key,r)}}function ct(t,e,n){return e&&at(t.prototype,e),n&&at(t,n),t}function it(t){return function(){var e,n=ft(t);if(st()){var r=ft(this).constructor;e=Reflect.construct(n,arguments,r)}else e=n.apply(this,arguments);return ut(this,e)}}function ut(t,e){return!e||"object"!==mt(e)&&"function"!==typeof e?lt(t):e}function lt(t){if(void 0===t)throw new ReferenceError("this hasn't been initialised - super() hasn't been called");return t}function st(){if("undefined"===typeof Reflect||!Reflect.construct)return!1;if(Reflect.construct.sham)return!1;if("function"===typeof Proxy)return!0;try{return Date.prototype.toString.call(Reflect.construct(Date,[],(function(){}))),!0}catch(t){return!1}}function ft(t){return ft=Object.setPrototypeOf?Object.getPrototypeOf:function(t){return t.__proto__||Object.getPrototypeOf(t)},ft(t)}function pt(t,e){if("function"!==typeof e&&null!==e)throw new TypeError("Super expression must either be null or a function");t.prototype=Object.create(e&&e.prototype,{constructor:{value:t,writable:!0,configurable:!0}}),e&&yt(t,e)}function yt(t,e){return yt=Object.setPrototypeOf||function(t,e){return t.__proto__=e,t},yt(t,e)}function mt(t){return mt="function"===typeof Symbol&&"symbol"===typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"===typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t},mt(t)}function bt(t){return t&&"object"===mt(t)?t:{}}function vt(t,e){return t&&!e?{size:"large",shape:"square"}:{size:"large",shape:"circle"}}function dt(t,e){return!t&&e?{width:"38%"}:t&&e?{width:"50%"}:{}}function ht(t,e){var n={};return t&&e||(n.width="61%"),n.rows=!t&&e?3:2,n}var gt=function(t){pt(n,t);var e=it(n);function n(){var t;return ot(this,n),t=e.apply(this,arguments),t.renderSkeleton=function(e){var n=e.getPrefixCls,r=e.direction,o=t.props,a=o.prefixCls,c=o.loading,i=o.className,u=o.children,l=o.avatar,s=o.title,f=o.paragraph,p=o.active,y=n("skeleton",a);if(c||!("loading"in t.props)){var b,v,h,g=!!l,k=!!s,O=!!f;if(g){var j=rt(rt({prefixCls:"".concat(y,"-avatar")},vt(k,O)),bt(l));v=m["createElement"]("div",{className:"".concat(y,"-header")},m["createElement"](et,j))}if(k||O){var E,S;if(k){var P=rt(rt({prefixCls:"".concat(y,"-title")},dt(g,O)),bt(s));E=m["createElement"](w,P)}if(O){var C=rt(rt({prefixCls:"".concat(y,"-paragraph")},ht(g,k)),bt(f));S=m["createElement"](z,C)}h=m["createElement"]("div",{className:"".concat(y,"-content")},E,S)}var _=d()(y,i,(b={},nt(b,"".concat(y,"-with-avatar"),g),nt(b,"".concat(y,"-active"),p),nt(b,"".concat(y,"-rtl"),"rtl"===r),b));return m["createElement"]("div",{className:_},v,h)}return u},t}return ct(n,[{key:"render",value:function(){return m["createElement"](M["a"],null,this.renderSkeleton)}}]),n}(m["Component"]);gt.defaultProps={avatar:!1,title:!0,paragraph:!0};var wt=gt,kt=n("BGR+");function Ot(t){return Ot="function"===typeof Symbol&&"symbol"===typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"===typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t},Ot(t)}function jt(){return jt=Object.assign||function(t){for(var e=1;e<arguments.length;e++){var n=arguments[e];for(var r in n)Object.prototype.hasOwnProperty.call(n,r)&&(t[r]=n[r])}return t},jt.apply(this,arguments)}function Et(t,e,n){return e in t?Object.defineProperty(t,e,{value:n,enumerable:!0,configurable:!0,writable:!0}):t[e]=n,t}function St(t,e){if(!(t instanceof e))throw new TypeError("Cannot call a class as a function")}function Pt(t,e){for(var n=0;n<e.length;n++){var r=e[n];r.enumerable=r.enumerable||!1,r.configurable=!0,"value"in r&&(r.writable=!0),Object.defineProperty(t,r.key,r)}}function Ct(t,e,n){return e&&Pt(t.prototype,e),n&&Pt(t,n),t}function _t(t){return function(){var e,n=Tt(t);if(Nt()){var r=Tt(this).constructor;e=Reflect.construct(n,arguments,r)}else e=n.apply(this,arguments);return xt(this,e)}}function xt(t,e){return!e||"object"!==Ot(e)&&"function"!==typeof e?Rt(t):e}function Rt(t){if(void 0===t)throw new ReferenceError("this hasn't been initialised - super() hasn't been called");return t}function Nt(){if("undefined"===typeof Reflect||!Reflect.construct)return!1;if(Reflect.construct.sham)return!1;if("function"===typeof Proxy)return!0;try{return Date.prototype.toString.call(Reflect.construct(Date,[],(function(){}))),!0}catch(t){return!1}}function Tt(t){return Tt=Object.setPrototypeOf?Object.getPrototypeOf:function(t){return t.__proto__||Object.getPrototypeOf(t)},Tt(t)}function At(t,e){if("function"!==typeof e&&null!==e)throw new TypeError("Super expression must either be null or a function");t.prototype=Object.create(e&&e.prototype,{constructor:{value:t,writable:!0,configurable:!0}}),e&&It(t,e)}function It(t,e){return It=Object.setPrototypeOf||function(t,e){return t.__proto__=e,t},It(t,e)}var Dt=function(t){At(n,t);var e=_t(n);function n(){var t;return St(this,n),t=e.apply(this,arguments),t.renderSkeletonButton=function(e){var n=e.getPrefixCls,r=t.props,o=r.prefixCls,a=r.className,c=r.active,i=n("skeleton",o),u=Object(kt["a"])(t.props,["prefixCls"]),l=d()(i,a,"".concat(i,"-element"),Et({},"".concat(i,"-active"),c));return m["createElement"]("div",{className:l},m["createElement"](et,jt({prefixCls:"".concat(i,"-button")},u)))},t}return Ct(n,[{key:"render",value:function(){return m["createElement"](M["a"],null,this.renderSkeletonButton)}}]),n}(m["Component"]);Dt.defaultProps={size:"default"};var Lt=Dt;function Ht(t){return Ht="function"===typeof Symbol&&"symbol"===typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"===typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t},Ht(t)}function Ut(){return Ut=Object.assign||function(t){for(var e=1;e<arguments.length;e++){var n=arguments[e];for(var r in n)Object.prototype.hasOwnProperty.call(n,r)&&(t[r]=n[r])}return t},Ut.apply(this,arguments)}function zt(t,e,n){return e in t?Object.defineProperty(t,e,{value:n,enumerable:!0,configurable:!0,writable:!0}):t[e]=n,t}function Mt(t,e){if(!(t instanceof e))throw new TypeError("Cannot call a class as a function")}function Bt(t,e){for(var n=0;n<e.length;n++){var r=e[n];r.enumerable=r.enumerable||!1,r.configurable=!0,"value"in r&&(r.writable=!0),Object.defineProperty(t,r.key,r)}}function Wt(t,e,n){return e&&Bt(t.prototype,e),n&&Bt(t,n),t}function qt(t){return function(){var e,n=Jt(t);if(Vt()){var r=Jt(this).constructor;e=Reflect.construct(n,arguments,r)}else e=n.apply(this,arguments);return Gt(this,e)}}function Gt(t,e){return!e||"object"!==Ht(e)&&"function"!==typeof e?Kt(t):e}function Kt(t){if(void 0===t)throw new ReferenceError("this hasn't been initialised - super() hasn't been called");return t}function Vt(){if("undefined"===typeof Reflect||!Reflect.construct)return!1;if(Reflect.construct.sham)return!1;if("function"===typeof Proxy)return!0;try{return Date.prototype.toString.call(Reflect.construct(Date,[],(function(){}))),!0}catch(t){return!1}}function Jt(t){return Jt=Object.setPrototypeOf?Object.getPrototypeOf:function(t){return t.__proto__||Object.getPrototypeOf(t)},Jt(t)}function Qt(t,e){if("function"!==typeof e&&null!==e)throw new TypeError("Super expression must either be null or a function");t.prototype=Object.create(e&&e.prototype,{constructor:{value:t,writable:!0,configurable:!0}}),e&&Ft(t,e)}function Ft(t,e){return Ft=Object.setPrototypeOf||function(t,e){return t.__proto__=e,t},Ft(t,e)}var Yt=function(t){Qt(n,t);var e=qt(n);function n(){var t;return Mt(this,n),t=e.apply(this,arguments),t.renderSkeletonAvatar=function(e){var n=e.getPrefixCls,r=t.props,o=r.prefixCls,a=r.className,c=r.active,i=n("skeleton",o),u=Object(kt["a"])(t.props,["prefixCls"]),l=d()(i,a,"".concat(i,"-element"),zt({},"".concat(i,"-active"),c));return m["createElement"]("div",{className:l},m["createElement"](et,Ut({prefixCls:"".concat(i,"-avatar")},u)))},t}return Wt(n,[{key:"render",value:function(){return m["createElement"](M["a"],null,this.renderSkeletonAvatar)}}]),n}(m["Component"]);Yt.defaultProps={size:"default",shape:"circle"};var Xt=Yt;function Zt(t){return Zt="function"===typeof Symbol&&"symbol"===typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"===typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t},Zt(t)}function $t(){return $t=Object.assign||function(t){for(var e=1;e<arguments.length;e++){var n=arguments[e];for(var r in n)Object.prototype.hasOwnProperty.call(n,r)&&(t[r]=n[r])}return t},$t.apply(this,arguments)}function te(t,e,n){return e in t?Object.defineProperty(t,e,{value:n,enumerable:!0,configurable:!0,writable:!0}):t[e]=n,t}function ee(t,e){if(!(t instanceof e))throw new TypeError("Cannot call a class as a function")}function ne(t,e){for(var n=0;n<e.length;n++){var r=e[n];r.enumerable=r.enumerable||!1,r.configurable=!0,"value"in r&&(r.writable=!0),Object.defineProperty(t,r.key,r)}}function re(t,e,n){return e&&ne(t.prototype,e),n&&ne(t,n),t}function oe(t){return function(){var e,n=ue(t);if(ie()){var r=ue(this).constructor;e=Reflect.construct(n,arguments,r)}else e=n.apply(this,arguments);return ae(this,e)}}function ae(t,e){return!e||"object"!==Zt(e)&&"function"!==typeof e?ce(t):e}function ce(t){if(void 0===t)throw new ReferenceError("this hasn't been initialised - super() hasn't been called");return t}function ie(){if("undefined"===typeof Reflect||!Reflect.construct)return!1;if(Reflect.construct.sham)return!1;if("function"===typeof Proxy)return!0;try{return Date.prototype.toString.call(Reflect.construct(Date,[],(function(){}))),!0}catch(t){return!1}}function ue(t){return ue=Object.setPrototypeOf?Object.getPrototypeOf:function(t){return t.__proto__||Object.getPrototypeOf(t)},ue(t)}function le(t,e){if("function"!==typeof e&&null!==e)throw new TypeError("Super expression must either be null or a function");t.prototype=Object.create(e&&e.prototype,{constructor:{value:t,writable:!0,configurable:!0}}),e&&se(t,e)}function se(t,e){return se=Object.setPrototypeOf||function(t,e){return t.__proto__=e,t},se(t,e)}var fe=function(t){le(n,t);var e=oe(n);function n(){var t;return ee(this,n),t=e.apply(this,arguments),t.renderSkeletonInput=function(e){var n=e.getPrefixCls,r=t.props,o=r.prefixCls,a=r.className,c=r.active,i=n("skeleton",o),u=Object(kt["a"])(t.props,["prefixCls"]),l=d()(i,a,"".concat(i,"-element"),te({},"".concat(i,"-active"),c));return m["createElement"]("div",{className:l},m["createElement"](et,$t({prefixCls:"".concat(i,"-input")},u)))},t}return re(n,[{key:"render",value:function(){return m["createElement"](M["a"],null,this.renderSkeletonInput)}}]),n}(m["Component"]);fe.defaultProps={size:"default"};var pe=fe;wt.Button=Lt,wt.Avatar=Xt,wt.Input=pe;var ye=wt,me=n("9kvl"),be=n("Hx5s"),ve=n("wd/R"),de=n.n(ve),he=n("+lVK"),ge=n.n(he);function we(t){return function(){var e,n=Object(f["a"])(t);if(ke()){var r=Object(f["a"])(this).constructor;e=Reflect.construct(n,arguments,r)}else e=n.apply(this,arguments);return Object(s["a"])(this,e)}}function ke(){if("undefined"===typeof Reflect||!Reflect.construct)return!1;if(Reflect.construct.sham)return!1;if("function"===typeof Proxy)return!0;try{return Date.prototype.toString.call(Reflect.construct(Date,[],(function(){}))),!0}catch(t){return!1}}var Oe=function(t){var e=t.currentUser,n=e&&Object.keys(e).length;return n?b.a.createElement("div",{className:ge.a.pageHeaderContent},b.a.createElement("div",{className:ge.a.avatar},b.a.createElement(y["a"],{size:"large",src:e.avatar})),b.a.createElement("div",{className:ge.a.content},b.a.createElement("div",{className:ge.a.contentTitle},"Hello\uff0c",e.name,"\uff0chappy day\uff01"))):b.a.createElement(ye,{avatar:!0,paragraph:{rows:1},active:!0})},je=function(){return b.a.createElement("div",{className:ge.a.extraContent},b.a.createElement("div",{className:ge.a.statItem},b.a.createElement(p["a"],{title:"\u8fdb\u884c\u4e2d",value:56})),b.a.createElement("div",{className:ge.a.statItem},b.a.createElement(p["a"],{title:"\u5df2\u5b8c\u6210",value:2223})))},Ee=function(t){Object(l["a"])(n,t);var e=we(n);function n(){var t;Object(i["a"])(this,n);for(var r=arguments.length,o=new Array(r),a=0;a<r;a++)o[a]=arguments[a];return t=e.call.apply(e,[this].concat(o)),t.renderActivities=function(t){var e=t.template.split(/@\{([^{}]*)\}/gi).map((function(e){return t[e]?b.a.createElement("a",{href:t[e].link,key:t[e].name},t[e].name):e}));return b.a.createElement(c["a"].Item,{key:t.id},b.a.createElement(c["a"].Item.Meta,{avatar:b.a.createElement(y["a"],{src:t.user.avatar}),title:b.a.createElement("span",null,b.a.createElement("a",{className:ge.a.username},t.user.name),"\xa0",b.a.createElement("span",{className:ge.a.event},e)),description:b.a.createElement("span",{className:ge.a.datetime,title:t.updatedAt},de()(t.updatedAt).fromNow())}))},t}return Object(u["a"])(n,[{key:"componentDidMount",value:function(){var t=this.props.dispatch;t({type:"workplace/init"})}},{key:"componentWillUnmount",value:function(){var t=this.props.dispatch;t({type:"workplace/clear"})}},{key:"render",value:function(){var t=this,e=this.props,n=e.currentUser,i=e.activities,u=e.activitiesLoading;return n&&n.userid?b.a.createElement(be["c"],{content:b.a.createElement(Oe,{currentUser:n}),extraContent:b.a.createElement(je,null)},b.a.createElement(r["a"],{gutter:24},b.a.createElement(o["a"],{xl:24,lg:24,md:24,sm:24,xs:24},b.a.createElement(a["a"],{bodyStyle:{padding:0},bordered:!1,className:ge.a.activeCard,title:"\u6700\u65b0\u52a8\u6001",loading:u},b.a.createElement(c["a"],{loading:u,renderItem:function(e){return t.renderActivities(e)},dataSource:i,className:ge.a.activitiesList,size:"large"}))))):null}}]),n}(m["Component"]);e["default"]=Object(me["b"])((function(t){var e=t.workplace,n=e.currentUser,r=e.projectNotice,o=e.activities,a=e.radarData,c=t.loading;return{currentUser:n,projectNotice:r,activities:o,radarData:a,currentUserLoading:c.effects["workplace/fetchUserCurrent"],projectLoading:c.effects["workplace/fetchProjectNotice"],activitiesLoading:c.effects["workplace/fetchActivitiesList"]}}))(Ee)},oIFs:function(t,e,n){t.exports={"ant-skeleton":"ant-skeleton","ant-skeleton-header":"ant-skeleton-header","ant-skeleton-avatar":"ant-skeleton-avatar","ant-skeleton-avatar-circle":"ant-skeleton-avatar-circle","ant-skeleton-avatar-lg":"ant-skeleton-avatar-lg","ant-skeleton-avatar-sm":"ant-skeleton-avatar-sm","ant-skeleton-content":"ant-skeleton-content","ant-skeleton-title":"ant-skeleton-title","ant-skeleton-paragraph":"ant-skeleton-paragraph","ant-skeleton-with-avatar":"ant-skeleton-with-avatar","ant-skeleton-active":"ant-skeleton-active","ant-skeleton-loading":"ant-skeleton-loading","ant-skeleton-button":"ant-skeleton-button","ant-skeleton-input":"ant-skeleton-input","ant-skeleton-element":"ant-skeleton-element","ant-skeleton-button-circle":"ant-skeleton-button-circle","ant-skeleton-button-round":"ant-skeleton-button-round","ant-skeleton-button-lg":"ant-skeleton-button-lg","ant-skeleton-button-sm":"ant-skeleton-button-sm","ant-skeleton-input-lg":"ant-skeleton-input-lg","ant-skeleton-input-sm":"ant-skeleton-input-sm","ant-skeleton-rtl":"ant-skeleton-rtl","ant-skeleton-loading-rtl":"ant-skeleton-loading-rtl"}}}]);