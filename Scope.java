import java.util.HashMap;

class Scope {
    private HashMap<String, FullType> symbolTable;
    private Scope parentScope;

    public Scope() {
        this.parentScope = null;
        this.symbolTable = new HashMap<String, FullType>();
    }

    public Scope(Scope s) {
        this.parentScope = s;
        this.symbolTable = new HashMap<String, FullType>();
    }

    public boolean validKeyInScope(String key, Scope sc) {
        boolean isValid = true;
        if(sc.symbolTable.containsKey(key)) {
            return false;
        }
        if(sc.parentScope != null) {
            return validKeyInScope(key, sc.parentScope);
        }
        return isValid;
    }

    public void addToHash(String key, FullType ft) {
        this.symbolTable.put(key, ft);
    }

    public void moveUpScope(Scope sc) {
        if (sc.parentScope != null) {
            sc.parentScope = sc.parentScope.parentScope;
        }
    }
}