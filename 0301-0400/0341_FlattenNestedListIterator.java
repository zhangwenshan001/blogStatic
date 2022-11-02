/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<NestedInteger> nestedList;
    NestedIterator iterator = null;
    int idx = 0;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
    }

    @Override
    public Integer next() {
        if (iterator == null) {
            int res = nestedList.get(idx).getInteger();
            idx++;
            return res;
        }
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        if (iterator == null) { //if iterator not exists
            if (idx >= nestedList.size()){
                return false;
            }
            NestedInteger cur = nestedList.get(idx);
            if (cur.isInteger()) {
                return true;
            }
            
            List<NestedInteger> nextList = cur.getList();
            if (nextList.isEmpty()) {
                idx++;
                return this.hasNext();
            }
            
            iterator = new NestedIterator(nextList);
        }
        if (iterator.hasNext()) {
            return true;
        }
        
        iterator = null;
        idx++;
        return this.hasNext();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */