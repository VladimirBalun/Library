const axios = require('axios');
const Vue = require('vue');

const formTable = require('./components/formTable.vue');
const formAddingBook = require('./components/formAddingBook.vue');
const formChangingBook = require('./components/formChangingBook.vue');

new Vue({
    el : '#app',

    data : {
        books : []
    },

    components : {
        formTable : formTable,
        formAddingBook : formAddingBook,
        formChangingBook : formChangingBook
    },

    created : function () {
        const self = this;
        axios.get('/library/getAllBooks').then(function (booksFromDB) {
            booksFromDB.data.forEach((book) => {
               self.books.push(book);
            });
        }).catch(function (error) {
           console.log(error);
        });
    }

});