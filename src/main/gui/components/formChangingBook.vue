<template>

    <div class="block">
        <p class="hint">Select book:</p>
        <select class="full-width" v-model="formChangingBook.selectedTitle" @change="onChangeSelectedBook">
            <option v-for="book in $root.$data.books">{{ book.title }}</option>
        </select>
        <p class="hint">Enter new name book[{{ formChangingBook.newTitle.length }}/200]:</p>
        <input type="text" class="full-width" v-model="formChangingBook.newTitle">
        <p class="hint">Enter new year of publishing:</p>
        <input type="number" class="full-width" v-model="formChangingBook.newYear">
        <p class="hint">Enter new authors separated by commas[{{ formChangingBook.newAuthors.length }}/1000]:</p>
        <input type="text" class="full-width"v-model="formChangingBook.newAuthors">
        <button class="full-width" @click="changeSelectedBook">Change book</button>
    </div>

</template>

<script>

    const axios = require('axios');

    module.exports = {

        data : function() {
            return {
                formChangingBook : {
                    selectedTitle : "",
                    newTitle : "",
                    newYear : "",
                    newAuthors : ""
                }
            }
        },
        methods : {

            onChangeSelectedBook : function () {
                const self = this.formChangingBook;
                this.$root.$data.books.forEach((book) => {
                    if (book.title === self.selectedTitle) {
                        self.newTitle = book.title;
                        self.newYear = book.year;
                        self.newAuthors = book.authors;
                    }
                })
            },

            changeSelectedBook : function () {
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

            isValidForm : function () {
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
                    alert("Book with title \"" + selfForm.newTitle + "\" already exist.")
                    return false;
                } else {
                    return true;
                }
            },

            isExistBook : function (title) {
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

            changeBookInTable : function () {
                const selfForm = this.formChangingBook;
                this.$root.$data.books.forEach((book) => {
                    if (book.title === selfForm.selectedTitle) {
                        book.title = selfForm.newTitle;
                        book.year = selfForm.newYear;
                        book.authors = selfForm.newAuthors;
                    }
                })
            }

        }

    }

</script>