import java.util.HashMap;

class Scope {
    private HashMap<String, FullType> symbolTable;
    private Scope parentScope;
    private String methodReturnType;

    public Scope() {
        this.parentScope = null;
        this.symbolTable = new HashMap<String, FullType>();
        this.methodReturnType = null;
    }

    public Scope(Scope s) {
        this.parentScope = s;
        this.symbolTable = new HashMap<String, FullType>();
        this.methodReturnType = null;
    }

    public Scope(Scope s, String mrt) {
        this.parentScope = s;
        this.symbolTable = new HashMap<String, FullType>();
        this.methodReturnType = mrt;
    }

    public String getReturnType(Scope s) {
        return s.methodReturnType;
    }

    public boolean validKeyInScope(String key, Scope sc) {
        boolean isValid = true;
        if(sc.symbolTable.containsKey(key)) {
            return false;
        }
        return isValid;
    }

    public boolean accessibleKeyInScope(String key, Scope sc) {
        boolean isAccess = false;
        if(sc.symbolTable.containsKey(key)) {
            return true;
        }
        if(sc.parentScope != null) {
            return accessibleKeyInScope(key, sc.parentScope);
        }
        return isAccess;
    }

    public boolean keyIsFinal(String key, Scope sc) {
        boolean isFinal = false;
        FullType ft;
        if(sc.symbolTable.containsKey(key)) {
            ft = sc.symbolTable.get(key);
            return ft.isFinal();
        }
        if(sc.parentScope != null) {
            return keyIsFinal(key, sc.parentScope);
        }
        return isFinal;
    }

    public boolean keyIsArray(String key, Scope sc) {
        boolean isArray = false;
        FullType ft;
        if(sc.symbolTable.containsKey(key)) {
            ft = sc.symbolTable.get(key);
            return ft.isArray();
        }
        if(sc.parentScope != null) {
            return keyIsArray(key, sc.parentScope);
        }
        return isArray;
    }

    public boolean keyIsFunction(String key, Scope sc) {
        boolean isFunction = false;
        FullType ft;
        if(sc.symbolTable.containsKey(key)) {
            ft = sc.symbolTable.get(key);
            return ft.isFunction();
        }
        if(sc.parentScope != null) {
            return keyIsFunction(key, sc.parentScope);
        }
        return isFunction;
    }

    public String getTypeFromKey(String key, Scope sc) {
        String kType = "unknown";
        FullType ft;
        if(sc.symbolTable.containsKey(key)) {
            ft = sc.symbolTable.get(key);
            return ft.getType();
        }
        if(sc.parentScope != null) {
            return getTypeFromKey(key, sc.parentScope);
        }
        return kType;
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