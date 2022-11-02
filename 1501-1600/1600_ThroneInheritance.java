class ThroneInheritance {
    Person king;
    Map<String, Person> kingdom;
    List<String> res;
    
    public ThroneInheritance(String kingName) {
        king = new Person(kingName);
        kingdom = new HashMap<>();
        kingdom.put(kingName, king);
    }
    
    public void birth(String parentName, String childName) {
        Person parent = kingdom.get(parentName);
        Person child = new Person(childName);
        parent.addChild(child);
        kingdom.put(childName, child);
    }
    
    public void death(String name) {
        kingdom.get(name).death();
    }
    
    public List<String> getInheritanceOrder() {
        res = new ArrayList<>();
        dfs(king);
        
        return res;
    }
    public void dfs(Person p) {
        if (p.isAlive) {
            res.add(p.name);
        }
        
        if (p.children != null) {
            for (Person child : p.children) {
                dfs(child);
            }
        }
        
    }
}

class Person {
    String name;
    LinkedList<Person> children = null;
    boolean isAlive;
    
    public Person(String name) {
        this.name = name;
        isAlive = true;
    }
    public void death(){
        isAlive = false;
    }
    
    public void addChild(Person child) {
        if (children == null) {
            children = new LinkedList<>();
        } 
        children.add(child);
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */