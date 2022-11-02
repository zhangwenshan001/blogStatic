func canChange(start string, target string) bool {
    n := len(start)
    i, j := 0, 0
    for i < n && j < n {
        for j<n && target[j] == '_' {
            j++
        }
        
        for i<n && start[i] == '_' {
            i++
        }
        if i == n && j == n {
            return true
        } else if i == n || j == n {
            return false
        }
        
        if start[i] != target[j] {
            return false
        }
        if start[i] == 'L' && j > i {
            return false
        }
        if start[i] == 'R' && i > j {
            return false
        }
        i++
        j++
    }
    
    for ;i < n;i++ {
        if start[i] != '_' {
            return false
        }
    }
    
    for ;j<n;j++ {
        if target[j] != '_' {
            return false
        }
    }
    
    return true
}