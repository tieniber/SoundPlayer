/*
    SoundPlayer
    ========================

    @file      : SoundPlayer.js
    @version   : 0.1
    @author    : Eric Tieniber
    @date      : Wed, 09 Sep 2015 15:13:06 GMT
    @copyright : Mendix Technology BV
    @license   : Apache License, Version 2.0, January 2004

    Documentation
    ========================
    Describe your widget here.
*/

// Required module list. Remove unnecessary modules, you can always get them back from the boilerplate.
define([
    "dojo/_base/declare",
    "mxui/widget/_WidgetBase",
    "dijit/_TemplatedMixin",
    "mxui/dom",
    "dojo/dom",
    "dojo/dom-prop",
    "dojo/dom-geometry",
    "dojo/dom-class",
    "dojo/dom-style",
    "dojo/dom-construct",
    "dojo/_base/array",
    "dojo/_base/lang",
    "dojo/text",
    "dojo/html",
    "dojo/_base/event",
    "dojo/text!SoundPlayer/widget/template/SoundPlayer.html",
	"SoundPlayer/lib/soundmanager2-nodebug-jsmin"
], function (declare, _WidgetBase, _TemplatedMixin, dom, dojoDom, dojoProp, dojoGeometry, dojoClass, dojoStyle, dojoConstruct, dojoArray, dojoLang, dojoText, dojoHtml, dojoEvent, widgetTemplate, SoundManager) {
    "use strict";

    
    // Declare widget's prototype.
    return declare("SoundPlayer.widget.SoundPlayer", [ _WidgetBase, _TemplatedMixin ], {
        // _TemplatedMixin will create our dom node using this HTML template.
        templateString: widgetTemplate,

        // Parameters configured in the Modeler.
		dataSourceMf: "",
		attributeToListen: "",

        // Internal variables. Non-primitives created in the prototype are shared between all widget instances.
        _handles: null,
        _contextObj: null,
		_soundObj: null,

        // dojo.declare.constructor is called to construct the widget instance. Implement to initialize non-primitive properties.
        constructor: function() {
            this._handles = [];
        },

        // dijit._WidgetBase.postCreate is called after constructing the widget. Implement to do extra setup work.
        postCreate: function() {
            console.log(this.id + ".postCreate");
			

        },

        // mxui.widget._WidgetBase.update is called when context is changed or initialized. Implement to re-render and / or fetch data.
        update: function(obj, callback) {
            console.log(this.id + ".update");

			if (this._contextObj !== obj) {
				this._contextObj = obj;
				this._getSound();
				this._resetSubscriptions();
			}


            callback();
        },

        // mxui.widget._WidgetBase.enable is called when the widget should enable editing. Implement to enable editing if widget is input widget.
        enable: function() {},

        // mxui.widget._WidgetBase.enable is called when the widget should disable editing. Implement to disable editing if widget is input widget.
        disable: function() {},

        // mxui.widget._WidgetBase.resize is called when the page's layout is recalculated. Implement to do sizing calculations. Prefer using CSS instead.
        resize: function(box) {},

        // mxui.widget._WidgetBase.uninitialize is called when the widget is destroyed. Implement to do special tear-down work.
        uninitialize: function() {
            // Clean up listeners, helper objects, etc. There is no need to remove listeners added with this.connect / this.subscribe / this.own.
        },

		_getSound: function() {
			console.log(this.id + ".getSound");
			this._execMF(this._contextObj, this.dataSourceMf, dojoLang.hitch(this, this._setSound));
		},
		
		_setSound: function(obj) {
			console.log(this.id + ".setSound");
			this._soundObj = obj[0];
		},

        // Rerender the interface.
        _playSound: function() {
			console.log(this.id + ".playSound");
			if (this._soundObj && this._soundObj.getAttribute("HasContents") )  {
				if (this._contextObj && this._contextObj.getAttribute(this.attributeToListen) ) {
					var soundURL = this._getFileUrl();

					var swfLocation = dojo.moduleUrl("SoundPlayer") + "lib/swf/";

					soundManager.setup({
						url: swfLocation,
						onready: function() {
							var mySound = soundManager.createSound({
								id: 'aSound',
								url: soundURL
						});
						mySound.play();
					  },
					  ontimeout: function() {
						// Hrmm, SM2 could not start. Missing SWF? Flash blocked? Show an error, etc.?
					  }
					});	
				} else {
					console.log("Didn't play sound because attribute was false.");
				}
			} else {
				console.log("No sound file found to play.");
			}	
			
        },

		//Get the context entity URL
		_getFileUrl : function() {
			console.log(this.id + ".getURL");
			var url;
			if (this._soundObj !== null && this._soundObj.getAttribute("HasContents")) {
				url ="file?guid=" + this._soundObj.getGUID() + "&csrfToken=" + mx.session.getCSRFToken() + "&time=" + Date.now();
			} else {
				url = "";
			}
			return url;
		},
		
        // Reset subscriptions.
        _resetSubscriptions: function() {
            logger.debug(this.id + "._resetSubscriptions");
            // Release handles on previous object, if any.
            if (this._handles) {
                dojoArray.forEach(this._handles, function (handle) {
                    mx.data.unsubscribe(handle);
                });
                this._handles = [];
            }

            // When a mendix object exists create subscribtions.
            if (this._contextObj) {
                var attrHandle = this.subscribe({
                    guid: this._contextObj.getGuid(),
                    callback: dojoLang.hitch(this, function(guid) {
						this._playSound();
                    })
                });

                this._handles = [attrHandle];
            }
        },
		
		_execMF: function (obj, mf, cb) {
			if (mf) {
				var params = {
					applyto: "selection",
					actionname: mf,
					guids: []
				};
				if (obj) {
					params.guids = [obj.getGuid()];
				}
				mx.data.action({
					params: params,
					callback: function (objs) {
						if (cb) {
							cb(objs);
						}
					},
					error: function (error) {
						if (cb) {
							cb();
						}
						console.warn(error.description);
					}
				}, this);

			} else if (cb) {
				cb();
			}
		}
		
    });
});

require(["SoundPlayer/widget/SoundPlayer"], function() {
    "use strict";
});
