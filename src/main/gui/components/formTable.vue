<template>

    <div class="block">
        <input type="text" class="half-width " placeholder="Search by title..." v-model="searchBooks">
        <button @click="removeBooksByTitle">Remove books</button>
        <table class="table table-striped">
            <thead class="thead-inverse">
                <tr>
                    <th>#{{ $root.$data.books.length }}</th>
                    <th>Name book</th>
                    <th>Year</th>
                    <th>Authors</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="book in filteredBooks">
                    <td>
                        <input type="checkbox" v-model="selectedBooks" v-bind:value="book.title">
                    </td>
                    <td>{{ book.title }}</td>
                    <td>{{ book.year }}</td>
                    <td>{{ book.authors.toString() }}</td>
                </tr>
            </tbody>
        </table>
    </div>

</template>

<script>

    const axios = require('axios');

    module.exports = {

        data : function() {
            return {
                selectedBooks : [],
                searchBooks : ""
            }
        },
        methods : {

            removeBooksByTitle : function() {
                const self = this;
                if (this.selectedBooks.length === 0) {
                    alert("No books selected for deleting...");
                    return;
                }

                axios.delete('/library/deleteBook', { data : this.selectedBooks }).then(function (response) {
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

            removeBooksFromTable : function() {
                this.selectedBooks.forEach((selectedBook) => {
                    var index = this.$root.$data.books.map((task) => {
                        return task.title;
                    }).indexOf(selectedBook);
                    this.$root.$data.books.splice(index, 1);
                });
            }

        },
        computed : {

            filteredBooks : function() {
                var query = this.searchBooks;
                return this.$root.$data.books.filter(function (book) {
                    if(query === '') {
                        return true;
                    } else {
                        return book.title.indexOf(query) > -1;
                    }
                });
            }

        }

    }

</script>

<style lang="sass?indentedSyntax=true">

    .full-height
        height : 100%


    @media (max-width: 1010px)
        .full-height
            height : auto

</style>