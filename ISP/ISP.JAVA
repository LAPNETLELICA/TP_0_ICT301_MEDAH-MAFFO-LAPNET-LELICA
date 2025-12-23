/**BEFRORE REFACTORIG**/
package ict301.solid.isp;

public interface Worker {
    void work();
    void eat();
}

class HumanWorker implements Worker {
    @Override
    public void work() {
        System.out.println("Les humains travaillent");
    }

    @Override
    public void eat() {
        System.out.println("Les humains mangent");
    }
}

class RobotWorker implements Worker {
    @Override
    public void work() {
        System.out.println("Les Robots travaillent sans fatigue");
    }

    @Override
    public void eat() {
        // Le robot n'a pas besoin de manger
        System.out.println("L'on ne doit pas faire manger un robot");
        throw new UnsupportedOperationException("Les Robots ne mangent pas");
    }
}

/**AFTER REFACTORING**/
package ict301.solid.isp;

// Interfaces spécifiques
interface Workable {
    void work();
}

interface Eatable extends Workable {
    void eat();
}

// Implémentations respectant ISP
class HumanWorker implements Eatable {
    @Override
    public void work() {
        System.out.println("Les humains travaillent");
    }

    @Override
    public void eat() {
        System.out.println("Les humains mangent");
    }
}

class RobotWorker implements Workable {
    @Override
    public void work() {
        System.out.println("Les Robots travaillent sans fatigue");
    }
}

// Utilisation
public class MainISP {
    public static void main(String[] args) {
        HumanWorker human = new HumanWorker();
        human.work();
        human.eat();

        RobotWorker robot = new RobotWorker();
        robot.work();
    }
}