package edu.temple.audiobb_assignment10

class API {
    companion object url {
        fun getBookDataUrl(id: Int): String {
            return "https://kamorris.com/lab/cis3515/book.php?id=${id}"
        }
    }

}