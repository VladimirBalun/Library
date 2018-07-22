<template>

    <div class="block">
        <p class="hint">Enter name book [{{ formAddingBook.title.length }}/200]:</p>
        <input maxlength="200" type="text" class="full-width" v-model="formAddingBook.title">
        <p class="hint">Enter year of publishing:</p>
        <input type="number" class="full-width" v-model="formAddingBook.year">
        <p class="hint">Enter authors separated by commas[{{ formAddingBook.authors.length }}/1000]:</p>
        <input type="text" class="full-width" v-model="formAddingBook.authors">
        <button class="full-width" @click="addNewBook">Add new book</button>
    </div>

</template>

<script>

    const axios = require('axios');

    module.exports = {

        data : function() {
            return {
                formAddingBook : {
                    title : "",
                    year : "",
                    authors : ""
                }
            }
        },
        methods : {

            addNewBook : function () {
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

            isValidForm : function () {
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

            isExistBook : function (title) {
                for (var i = 0; i < this.$root.$data.books.length; i++) {
                    if (this.$root.$data.books[i].title === title) {
                        return true;
                    }
                }
                return false;
            },

            addBookInTable : function () {
                const selfForm = this.formAddingBook;
                this.$root.$data.books.push({
                    title : selfForm.title,
                    year : selfForm.year,
                    authors : new Array(selfForm.authors.split(','))
                });
            }

        }

    }

</script>