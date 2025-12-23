/**before refactoring**/
package ict301.solid.dip.old;

class MySQLDatabase {
    public void save(String data) {
        System.out.println("Saving to MySQL: " + data);
    }
}

public class OrderProcessor {
    private MySQLDatabase database;

    public OrderProcessor() {
        // Dependency is hard-coded here
        this.database = new MySQLDatabase();
    }

    public void processOrder(String order) {
        database.save(order);
    }
}

// Main class usage
public class Main {
    public static void main(String[] args) {
        OrderProcessor order = new OrderProcessor();
        order.processOrder("'Données à sauvegarder'");
    }
}


/**After refactoring**/
package ict301.solid.dip;

// Abstraction (Interface)
interface Database {
    void save(String data);
}

// Concrete implementation 1
class MySQLDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving to MySQL: " + data);
    }
}

// Concrete implementation 2
class MongoDBDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving to MongoDB: " + data);
    }
}

// High-level class depends on the interface
public class OrderProcessor {
    private Database database;

    // Dependency is injected via the constructor
    public OrderProcessor(Database database) {
        this.database = database;
    }

    public void processOrder(String order) {
        database.save(order);
    }
}

// Main class usage demonstrating flexibility
public class Main {
    public static void main(String[] args) {
        Database database;

        // Use MySQL
        database = new MySQLDatabase();
        OrderProcessor order = new OrderProcessor(database);
        order.processOrder("'Données à sauvegarder'");

        // Easily switch to MongoDB
        database = new MongoDBDatabase();
        OrderProcessor order1 = new OrderProcessor(database);
        order1.processOrder("'Données à sauvegarder'");
    }
}