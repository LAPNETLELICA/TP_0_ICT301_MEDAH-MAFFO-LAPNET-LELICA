/**before refactoring**/

package ict301.solid.srp;

public class Book {
    private String title;
    private String author;
    private String content;

    public Book(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    // Responsabilité 1 : Gérer les données du livre
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getContent() { return content; }

    // Responsabilité 2 : Afficher le livre (présentation)
    public void printToScreen() {
        System.out.println("Titre: " + title);
        System.out.println("Auteur: " + author);
        System.out.println("Contenu: " + content);
    }

    // Responsabilité 3 : Sauvegarder le livre (persistance)
    public void saveToDatabase() {
        System.out.println("Sauvegarde du livre '" + title + "' en base de données...");
    }

    // Responsabilité 4 : (logique métier)
    public void emprunter(String lecteur) {
        System.out.println("Emprunt du livre '" + title + "' par " + lecteur);
    }
}
/**After refactoring**/
package ict301.solid.srp;

// 1. Gère les données du livre
public class BookSRP {
    private String title;
    private String author;
    private String content;

    public BookSRP(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getContent() { return content; }
}

// 2. Classe BookPrinter : présentation
class BookPrinter {
    public void printToScreen(BookSRP book) {
        System.out.println("===Print to Screen=== ");
        System.out.println("Titre: " + book.getTitle());
        System.out.println("Auteur: " + book.getAuthor());
        System.out.println("Contenu: " + book.getContent());
    }

    public void printToHTML(BookSRP book) {
        System.out.println("\n===Print to HTML=== ");
        System.out.println("<h1>" + book.getTitle() + "</h1>");
        System.out.println("<h2>Par " + book.getAuthor() + "</h2>");
        System.out.println("<p>" + book.getContent() + "</p>");
    }
}

// 3. Classe BookSaver : persistance
class BookSaver {
    public void saveToDatabase(BookSRP book) {
        System.out.println("\nSauvegarde de '" + book.getTitle() + "' en base de données...");
    }

    public void saveToFile(BookSRP book, String filename) {
        System.out.println("\nSauvegarde de '" + book.getTitle() + "' dans " + filename);
    }
}

// 4. Classe BookBusinessLogic : Logique métier
class BookBusinessLogic {
    public void emprunter(BookSRP book, String lecteur) {
        System.out.println("\nEmprunt du livre '" + book.getTitle() + "' par " + lecteur);
    }

    public void autreService(BookSRP book) {
        System.out.println("\nAutre logique métier sur le livre " + book.getTitle());
    }
}