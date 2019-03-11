package data;

import java.util.Objects;

public class Book extends Publication {

   private String author;
   private int pages;
   private String isbn;



    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Book(String title,String author,int year,int pages , String publisher, String isbn) {
        super(year, title, publisher);

        this.setAuthor(author);
        this.setPages(pages);
        this.setIsbn(isbn);

    }

    @Override
    public String toString() {
        return getTitle()+";"+getAuthor()+";"+getYear()+";"+
                getPages() +";"+getPublisher()+";"+getIsbn();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        Book book = (Book) o;
        return pages == book.pages &&
                Objects.equals(author, book.author) &&
                Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        final int prime= 31;
        int result=super.hashCode();
        result=prime*result+((author==null)?0: author.hashCode());
        result=prime*result+((isbn==null)?0: isbn.hashCode());
        result=prime*result+pages;
        return result;
    }
}
