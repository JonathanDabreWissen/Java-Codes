
public class FactoryDesignPattern {
    
}

class Author {
    static int count = 0;

    private Author() {
        // Private constructor
    }

    public static Author getAuthor() {
        if (count <= 5) {
            count++;
            return new Author();
        }
        return null;
    }
}