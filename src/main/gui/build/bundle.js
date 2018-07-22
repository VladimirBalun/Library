/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// identity function for calling harmony imports with the correct context
/******/ 	__webpack_require__.i = function(value) { return value; };
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, {
/******/ 				configurable: false,
/******/ 				enumerable: true,
/******/ 				get: getter
/******/ 			});
/******/ 		}
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "/build/";
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = 33);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */,
/* 1 */
/***/ (function(module, exports) {

throw new Error("Module build failed: Error: ENOENT: no such file or directory, open '/home/vova/Desktop/CRUD/CRUD/src/main/webapp/node_modules/axios/index.js'");

/***/ }),
/* 2 */,
/* 3 */,
/* 4 */,
/* 5 */,
/* 6 */,
/* 7 */,
/* 8 */,
/* 9 */
/***/ (function(module, exports) {

throw new Error("Module build failed: Error: ENOENT: no such file or directory, open '/home/vova/Desktop/CRUD/CRUD/src/main/webapp/node_modules/css-loader/lib/css-base.js'");

/***/ }),
/* 10 */,
/* 11 */,
/* 12 */
/***/ (function(module, exports, __webpack_require__) {

var __vue_exports__, __vue_options__
var __vue_styles__ = {}

/* script */
__vue_exports__ = __webpack_require__(34)

/* template */
var __vue_template__ = __webpack_require__(43)
__vue_options__ = __vue_exports__ = __vue_exports__ || {}
if (
  typeof __vue_exports__.default === "object" ||
  typeof __vue_exports__.default === "function"
) {
__vue_options__ = __vue_exports__ = __vue_exports__.default
}
if (typeof __vue_options__ === "function") {
  __vue_options__ = __vue_options__.options
}

__vue_options__.render = __vue_template__.render
__vue_options__.staticRenderFns = __vue_template__.staticRenderFns

module.exports = __vue_exports__


/***/ }),
/* 13 */
/***/ (function(module, exports, __webpack_require__) {

var __vue_exports__, __vue_options__
var __vue_styles__ = {}

/* script */
__vue_exports__ = __webpack_require__(35)

/* template */
var __vue_template__ = __webpack_require__(42)
__vue_options__ = __vue_exports__ = __vue_exports__ || {}
if (
  typeof __vue_exports__.default === "object" ||
  typeof __vue_exports__.default === "function"
) {
__vue_options__ = __vue_exports__ = __vue_exports__.default
}
if (typeof __vue_options__ === "function") {
  __vue_options__ = __vue_options__.options
}

__vue_options__.render = __vue_template__.render
__vue_options__.staticRenderFns = __vue_template__.staticRenderFns

module.exports = __vue_exports__


/***/ }),
/* 14 */
/***/ (function(module, exports, __webpack_require__) {

var __vue_exports__, __vue_options__
var __vue_styles__ = {}

/* styles */
__webpack_require__(45)

/* script */
__vue_exports__ = __webpack_require__(36)

/* template */
var __vue_template__ = __webpack_require__(41)
__vue_options__ = __vue_exports__ = __vue_exports__ || {}
if (
  typeof __vue_exports__.default === "object" ||
  typeof __vue_exports__.default === "function"
) {
__vue_options__ = __vue_exports__ = __vue_exports__.default
}
if (typeof __vue_options__ === "function") {
  __vue_options__ = __vue_options__.options
}

__vue_options__.render = __vue_template__.render
__vue_options__.staticRenderFns = __vue_template__.staticRenderFns

module.exports = __vue_exports__


/***/ }),
/* 15 */
/***/ (function(module, exports) {

throw new Error("Module build failed: Error: ENOENT: no such file or directory, open '/home/vova/Desktop/CRUD/CRUD/src/main/webapp/node_modules/vue/dist/vue.js'");

/***/ }),
/* 16 */,
/* 17 */,
/* 18 */,
/* 19 */,
/* 20 */,
/* 21 */,
/* 22 */,
/* 23 */,
/* 24 */,
/* 25 */,
/* 26 */,
/* 27 */,
/* 28 */,
/* 29 */,
/* 30 */,
/* 31 */,
/* 32 */,
/* 33 */
/***/ (function(module, exports, __webpack_require__) {

const axios = __webpack_require__(1);
const Vue = __webpack_require__(15);

const formTable = __webpack_require__(14);
const formAddingBook = __webpack_require__(12);
const formChangingBook = __webpack_require__(13);

new Vue({
    el: '#app',

    data: {
        books: []
    },

    components: {
        formTable: formTable,
        formAddingBook: formAddingBook,
        formChangingBook: formChangingBook
    },

    created: function () {
        const self = this;
        axios.get('/library/getAllBooks').then(function (booksFromDB) {
            booksFromDB.data.forEach(book => {
                self.books.push(book);
            });
        }).catch(function (error) {
            console.log(error);
        });
    }

});

/***/ }),
/* 34 */
/***/ (function(module, exports, __webpack_require__) {

//
//
//
//
//
//
//
//
//
//
//
//
//
//


const axios = __webpack_require__(1);

module.exports = {

    data: function () {
        return {
            formAddingBook: {
                title: "",
                year: "",
                authors: ""
            }
        };
    },
    methods: {

        addNewBook: function () {
            if (!this.isValidForm()) {
                return;
            }

            const self = this;
            const params = new URLSearchParams();
            params.append('title', this.formAddingBook.title);
            params.append('year', this.formAddingBook.year);
            params.append('authors[]', this.formAddingBook.authors);

            axios({
                method: 'post',
                url: '/library/addBook',
                data: params
            }).then(function (response) {
                if (response.data) {
                    self.addBookInTable();
                    alert("Book \"" + self.formAddingBook.title + "\" was added.");
                } else {
                    alert("Book \"" + self.formAddingBook.title + "\" wasn't added.");
                }
            }).catch(function (error) {
                console.log(error);
                alert("Book \"" + self.formAddingBook.title + "\" wasn't added.");
            });
        },

        isValidForm: function () {
            const selfForm = this.formAddingBook;
            if (selfForm.title === "") {
                alert("Title of the book is empty.");
                return false;
            } else if (selfForm.year === "") {
                alert("Year of publishing of the book is empty.");
                return false;
            } else if (selfForm.authors === "") {
                alert("Authors of the book are absent.");
                return false;
            } else if (this.isExistBook(selfForm.title)) {
                alert("Book with title \"" + selfForm.title + "\" already exist.");
                return false;
            } else {
                return true;
            }
        },

        isExistBook: function (title) {
            for (var i = 0; i < this.$root.$data.books.length; i++) {
                if (this.$root.$data.books[i].title === title) {
                    return true;
                }
            }
            return false;
        },

        addBookInTable: function () {
            const selfForm = this.formAddingBook;
            this.$root.$data.books.push({
                title: selfForm.title,
                year: selfForm.year,
                authors: new Array(selfForm.authors.split(','))
            });
        }

    }

};

/***/ }),
/* 35 */
/***/ (function(module, exports, __webpack_require__) {

//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//


const axios = __webpack_require__(1);

module.exports = {

    data: function () {
        return {
            formChangingBook: {
                selectedTitle: "",
                newTitle: "",
                newYear: "",
                newAuthors: ""
            }
        };
    },
    methods: {

        onChangeSelectedBook: function () {
            const self = this.formChangingBook;
            this.$root.$data.books.forEach(book => {
                if (book.title === self.selectedTitle) {
                    self.newTitle = book.title;
                    self.newYear = book.year;
                    self.newAuthors = book.authors;
                }
            });
        },

        changeSelectedBook: function () {
            if (!this.isValidForm()) {
                return;
            }

            const self = this;
            const params = new URLSearchParams();
            params.append('oldTitle', this.formChangingBook.selectedTitle);
            params.append('newTitle', this.formChangingBook.newTitle);
            params.append('newYear', this.formChangingBook.newYear);
            params.append('newAuthors[]', this.formChangingBook.newAuthors);

            axios({
                method: 'put',
                url: '/library/changeBook',
                data: params
            }).then(function (response) {
                if (response.data) {
                    self.changeBookInTable();
                    alert("Book \"" + self.formChangingBook.selectedTitle + "\" was changed.");
                } else {
                    alert("Book \"" + self.formChangingBook.selectedTitle + "\" was changed.");
                }
            }).catch(function (error) {
                console.log(error);
                alert("Book \"" + self.formChangingBook.selectedTitle + "\" wasn't changed.");
            });
        },

        isValidForm: function () {
            const selfForm = this.formChangingBook;
            if (selfForm.selectedTitle === "") {
                alert("Book doesn;t select.");
                return false;
            } else if (selfForm.newTitle === "") {
                alert("New title of the book is empty.");
                return false;
            } else if (selfForm.newYear === "") {
                alert("New year of publishing of the book is empty.");
                return false;
            } else if (selfForm.newAuthors === "") {
                alert("New authors of the book are absent.");
                return false;
            } else if (this.isExistBook(selfForm.newTitle)) {
                alert("Book with title \"" + selfForm.newTitle + "\" already exist.");
                return false;
            } else {
                return true;
            }
        },

        isExistBook: function (title) {
            const selfForm = this.formChangingBook;
            if (selfForm.selectedTitle === title) {
                return false;
            }

            for (var i = 0; i < this.$root.$data.books.length; i++) {
                if (this.$root.$data.books[i].title === title) {
                    return true;
                }
            }
            return false;
        },

        changeBookInTable: function () {
            const selfForm = this.formChangingBook;
            this.$root.$data.books.forEach(book => {
                if (book.title === selfForm.selectedTitle) {
                    book.title = selfForm.newTitle;
                    book.year = selfForm.newYear;
                    book.authors = selfForm.newAuthors;
                }
            });
        }

    }

};

/***/ }),
/* 36 */
/***/ (function(module, exports, __webpack_require__) {

//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//


const axios = __webpack_require__(1);

module.exports = {

    data: function () {
        return {
            selectedBooks: [],
            searchBooks: ""
        };
    },
    methods: {

        removeBooksByTitle: function () {
            const self = this;
            if (this.selectedBooks.length === 0) {
                alert("No books selected for deleting...");
                return;
            }

            axios.delete('/library/deleteBook', { data: this.selectedBooks }).then(function (response) {
                if (response.data) {
                    self.removeBooksFromTable();
                    alert("Books \"" + self.selectedBooks.toString() + "\" were deleted.");
                    self.selectedBooks = [];
                } else {
                    alert("Books \"" + self.selectedBooks.toString() + "\" weren't deleted.");
                }
            }).catch(function (error) {
                console.log(error);
                alert("Books \"" + self.selectedBooks.toString() + "\" weren't deleted.");
            });
        },

        removeBooksFromTable: function () {
            this.selectedBooks.forEach(selectedBook => {
                var index = this.$root.$data.books.map(task => {
                    return task.title;
                }).indexOf(selectedBook);
                this.$root.$data.books.splice(index, 1);
            });
        }

    },
    computed: {

        filteredBooks: function () {
            var query = this.searchBooks;
            return this.$root.$data.books.filter(function (book) {
                if (query === '') {
                    return true;
                } else {
                    return book.title.indexOf(query) > -1;
                }
            });
        }

    }

};

/***/ }),
/* 37 */
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__(9)();
// imports


// module
exports.push([module.i, "\n.full-height {\n  height: 100%;\n}\n@media (max-width: 1010px) {\n.full-height {\n    height: auto;\n}\n}\n", ""]);

// exports


/***/ }),
/* 38 */,
/* 39 */,
/* 40 */,
/* 41 */
/***/ (function(module, exports) {

module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;
  return _c('div', {
    staticClass: "block"
  }, [_c('input', {
    directives: [{
      name: "model",
      rawName: "v-model",
      value: (_vm.searchBooks),
      expression: "searchBooks"
    }],
    staticClass: "half-width ",
    attrs: {
      "type": "text",
      "placeholder": "Search by title..."
    },
    domProps: {
      "value": (_vm.searchBooks)
    },
    on: {
      "input": function($event) {
        if ($event.target.composing) { return; }
        _vm.searchBooks = $event.target.value
      }
    }
  }), _vm._v(" "), _c('button', {
    on: {
      "click": _vm.removeBooksByTitle
    }
  }, [_vm._v("Remove books")]), _vm._v(" "), _c('table', {
    staticClass: "table table-striped"
  }, [_c('thead', {
    staticClass: "thead-inverse"
  }, [_c('tr', [_c('th', [_vm._v("#" + _vm._s(_vm.$root.$data.books.length))]), _vm._v(" "), _c('th', [_vm._v("Name book")]), _vm._v(" "), _c('th', [_vm._v("Year")]), _vm._v(" "), _c('th', [_vm._v("Authors")])])]), _vm._v(" "), _c('tbody', _vm._l((_vm.filteredBooks), function(book) {
    return _c('tr', [_c('td', [_c('input', {
      directives: [{
        name: "model",
        rawName: "v-model",
        value: (_vm.selectedBooks),
        expression: "selectedBooks"
      }],
      attrs: {
        "type": "checkbox"
      },
      domProps: {
        "value": book.title,
        "checked": Array.isArray(_vm.selectedBooks) ? _vm._i(_vm.selectedBooks, book.title) > -1 : (_vm.selectedBooks)
      },
      on: {
        "change": function($event) {
          var $$a = _vm.selectedBooks,
            $$el = $event.target,
            $$c = $$el.checked ? (true) : (false);
          if (Array.isArray($$a)) {
            var $$v = book.title,
              $$i = _vm._i($$a, $$v);
            if ($$el.checked) {
              $$i < 0 && (_vm.selectedBooks = $$a.concat([$$v]))
            } else {
              $$i > -1 && (_vm.selectedBooks = $$a.slice(0, $$i).concat($$a.slice($$i + 1)))
            }
          } else {
            _vm.selectedBooks = $$c
          }
        }
      }
    })]), _vm._v(" "), _c('td', [_vm._v(_vm._s(book.title))]), _vm._v(" "), _c('td', [_vm._v(_vm._s(book.year))]), _vm._v(" "), _c('td', [_vm._v(_vm._s(book.authors.toString()))])])
  }))])])
},staticRenderFns: []}

/***/ }),
/* 42 */
/***/ (function(module, exports) {

module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;
  return _c('div', {
    staticClass: "block"
  }, [_c('p', {
    staticClass: "hint"
  }, [_vm._v("Select book:")]), _vm._v(" "), _c('select', {
    directives: [{
      name: "model",
      rawName: "v-model",
      value: (_vm.formChangingBook.selectedTitle),
      expression: "formChangingBook.selectedTitle"
    }],
    staticClass: "full-width",
    on: {
      "change": [function($event) {
        var $$selectedVal = Array.prototype.filter.call($event.target.options, function(o) {
          return o.selected
        }).map(function(o) {
          var val = "_value" in o ? o._value : o.value;
          return val
        });
        _vm.$set(_vm.formChangingBook, "selectedTitle", $event.target.multiple ? $$selectedVal : $$selectedVal[0])
      }, _vm.onChangeSelectedBook]
    }
  }, _vm._l((_vm.$root.$data.books), function(book) {
    return _c('option', [_vm._v(_vm._s(book.title))])
  })), _vm._v(" "), _c('p', {
    staticClass: "hint"
  }, [_vm._v("Enter new name book[" + _vm._s(_vm.formChangingBook.newTitle.length) + "/200]:")]), _vm._v(" "), _c('input', {
    directives: [{
      name: "model",
      rawName: "v-model",
      value: (_vm.formChangingBook.newTitle),
      expression: "formChangingBook.newTitle"
    }],
    staticClass: "full-width",
    attrs: {
      "type": "text"
    },
    domProps: {
      "value": (_vm.formChangingBook.newTitle)
    },
    on: {
      "input": function($event) {
        if ($event.target.composing) { return; }
        _vm.$set(_vm.formChangingBook, "newTitle", $event.target.value)
      }
    }
  }), _vm._v(" "), _c('p', {
    staticClass: "hint"
  }, [_vm._v("Enter new year of publishing:")]), _vm._v(" "), _c('input', {
    directives: [{
      name: "model",
      rawName: "v-model",
      value: (_vm.formChangingBook.newYear),
      expression: "formChangingBook.newYear"
    }],
    staticClass: "full-width",
    attrs: {
      "type": "number"
    },
    domProps: {
      "value": (_vm.formChangingBook.newYear)
    },
    on: {
      "input": function($event) {
        if ($event.target.composing) { return; }
        _vm.$set(_vm.formChangingBook, "newYear", $event.target.value)
      }
    }
  }), _vm._v(" "), _c('p', {
    staticClass: "hint"
  }, [_vm._v("Enter new authors separated by commas[" + _vm._s(_vm.formChangingBook.newAuthors.length) + "/1000]:")]), _vm._v(" "), _c('input', {
    directives: [{
      name: "model",
      rawName: "v-model",
      value: (_vm.formChangingBook.newAuthors),
      expression: "formChangingBook.newAuthors"
    }],
    staticClass: "full-width",
    attrs: {
      "type": "text"
    },
    domProps: {
      "value": (_vm.formChangingBook.newAuthors)
    },
    on: {
      "input": function($event) {
        if ($event.target.composing) { return; }
        _vm.$set(_vm.formChangingBook, "newAuthors", $event.target.value)
      }
    }
  }), _vm._v(" "), _c('button', {
    staticClass: "full-width",
    on: {
      "click": _vm.changeSelectedBook
    }
  }, [_vm._v("Change book")])])
},staticRenderFns: []}

/***/ }),
/* 43 */
/***/ (function(module, exports) {

module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;
  return _c('div', {
    staticClass: "block"
  }, [_c('p', {
    staticClass: "hint"
  }, [_vm._v("Enter name book [" + _vm._s(_vm.formAddingBook.title.length) + "/200]:")]), _vm._v(" "), _c('input', {
    directives: [{
      name: "model",
      rawName: "v-model",
      value: (_vm.formAddingBook.title),
      expression: "formAddingBook.title"
    }],
    staticClass: "full-width",
    attrs: {
      "maxlength": "200",
      "type": "text"
    },
    domProps: {
      "value": (_vm.formAddingBook.title)
    },
    on: {
      "input": function($event) {
        if ($event.target.composing) { return; }
        _vm.$set(_vm.formAddingBook, "title", $event.target.value)
      }
    }
  }), _vm._v(" "), _c('p', {
    staticClass: "hint"
  }, [_vm._v("Enter year of publishing:")]), _vm._v(" "), _c('input', {
    directives: [{
      name: "model",
      rawName: "v-model",
      value: (_vm.formAddingBook.year),
      expression: "formAddingBook.year"
    }],
    staticClass: "full-width",
    attrs: {
      "type": "number"
    },
    domProps: {
      "value": (_vm.formAddingBook.year)
    },
    on: {
      "input": function($event) {
        if ($event.target.composing) { return; }
        _vm.$set(_vm.formAddingBook, "year", $event.target.value)
      }
    }
  }), _vm._v(" "), _c('p', {
    staticClass: "hint"
  }, [_vm._v("Enter authors separated by commas[" + _vm._s(_vm.formAddingBook.authors.length) + "/1000]:")]), _vm._v(" "), _c('input', {
    directives: [{
      name: "model",
      rawName: "v-model",
      value: (_vm.formAddingBook.authors),
      expression: "formAddingBook.authors"
    }],
    staticClass: "full-width",
    attrs: {
      "type": "text"
    },
    domProps: {
      "value": (_vm.formAddingBook.authors)
    },
    on: {
      "input": function($event) {
        if ($event.target.composing) { return; }
        _vm.$set(_vm.formAddingBook, "authors", $event.target.value)
      }
    }
  }), _vm._v(" "), _c('button', {
    staticClass: "full-width",
    on: {
      "click": _vm.addNewBook
    }
  }, [_vm._v("Add new book")])])
},staticRenderFns: []}

/***/ }),
/* 44 */
/***/ (function(module, exports) {

throw new Error("Module build failed: Error: ENOENT: no such file or directory, open '/home/vova/Desktop/CRUD/CRUD/src/main/webapp/node_modules/vue-style-loader/addStyles.js'");

/***/ }),
/* 45 */
/***/ (function(module, exports, __webpack_require__) {

// style-loader: Adds some css to the DOM by adding a <style> tag

// load the styles
var content = __webpack_require__(37);
if(typeof content === 'string') content = [[module.i, content, '']];
// add the styles to the DOM
var update = __webpack_require__(44)(content, {});
if(content.locals) module.exports = content.locals;
// Hot Module Replacement
if(false) {
	// When the styles change, update the <style> tags
	if(!content.locals) {
		module.hot.accept("!!../node_modules/css-loader/index.js!../node_modules/vue-loader/lib/style-rewriter.js?id=data-v-2b0ee8e7!../node_modules/sass-loader/index.js?indentedSyntax=true!../node_modules/vue-loader/lib/selector.js?type=styles&index=0!./formTable.vue", function() {
			var newContent = require("!!../node_modules/css-loader/index.js!../node_modules/vue-loader/lib/style-rewriter.js?id=data-v-2b0ee8e7!../node_modules/sass-loader/index.js?indentedSyntax=true!../node_modules/vue-loader/lib/selector.js?type=styles&index=0!./formTable.vue");
			if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
			update(newContent);
		});
	}
	// When the module is disposed, remove the <style> tags
	module.hot.dispose(function() { update(); });
}

/***/ })
/******/ ]);