class ThroneInheritance {
    // Map to store parent -> list of children (defines the tree)
    private final Map<String, List<String>> familyTree;
    // Set to keep track of dead family members
    private final Set<String> deadSet;
    private final String king;

    public ThroneInheritance(String kingName) {
        this.king = kingName;
        this.familyTree = new HashMap<>();
        this.deadSet = new HashSet<>();
        // Initialize the tree with the king
        this.familyTree.put(king, new ArrayList<>());
    }
    
    public void birth(String parentName, String childName) {
        // Ensure the parent exists in our map, then add the child
        this.familyTree.putIfAbsent(parentName, new ArrayList<>());
        this.familyTree.get(parentName).add(childName);
    }
    
    public void death(String name) {
        // Mark the person as dead
        this.deadSet.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        // Perform pre-order DFS starting from the king
        dfs(king, order);
        return order;
    }

    private void dfs(String current, List<String> order) {
        // If the current person is alive, add them to the inheritance list
        if (!deadSet.contains(current)) {
            order.add(current);
        }
        
        // Recursively visit all children in order of birth
        List<String> children = familyTree.get(current);
        if (children != null) {
            for (String child : children) {
                dfs(child, order);
            }
        }
    }
}