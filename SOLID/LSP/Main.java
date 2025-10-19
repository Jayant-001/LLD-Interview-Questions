package SOLID.LSP;

/*
 *
 * Example of Liskov Substitution Principle Violation with Exceptions
 *  
 * Logic Exception
 *  - Invalid Argument Exception
 *  - Out Of Range Exception
 * 
 * RunTimeError
 *  - OutOfRange Error
 *  - Overflow Error
 *  - Underflow Error
 */

class LogicException extends Exception {
    public LogicException(String message) {
        super(message);
    }
}

class InvalidArgumentException extends LogicException {
    public InvalidArgumentException(String message) {
        super(message);
    }
}

class OutOfRangeException extends LogicException {
    public OutOfRangeException(String message) {
        super(message);
    }
}

class RunTimeError extends Exception {
    public RunTimeError(String message) {
        super(message);
    }
}

class OutOfRangeError extends RunTimeError {
    public OutOfRangeError(String message) {
        super(message);
    }
}

class OverflowError extends RunTimeError {
    public OverflowError(String message) {
        super(message);
    }
}

class Parent {
    public void doSomething() throws LogicException {
        throw new InvalidArgumentException("null argujment");
    }
}

class Child extends Parent {
    public void doSomething() throws OutOfRangeException {
        throw new OutOfRangeException("out of range");
    }
}

public class Main {
    
    public static void main(String []args) throws Exception{

        Parent parent = new Parent();
        Child child = new Child();
        try {
            child.doSomething();
            parent.doSomething();
        } catch (OutOfRangeException e) {
            System.out.println("OutOfRangeError: " + e.getMessage());
        } catch (LogicException e) {
            System.out.println("LogicException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } 
    }
}
