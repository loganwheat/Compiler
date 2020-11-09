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

    public void addToHash(String key, FullType ft) {
        this.symbolTable.put(key, ft);
    }
}