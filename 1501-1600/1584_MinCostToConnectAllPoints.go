func minCostConnectPoints(points [][]int) int {
    n := len(points)
    res := 0
    
    marked := make([]bool, n) //check if point[i] is already in the set
    dist := make([]int, n) //save the dist from the set to the rest points
    
    marked[0] = true
    dist[0] = 0
    
    //init the distance
    for i:=1;i<n;i++ {
        dist[i] = distance(points, 0, i)
    } 
    
    for i:=0;i<n-1;i++ {
        //find the next point to be joined into the set
        next := -1
        for j:=0;j<n;j++ {
            if marked[j] {
                continue
            }
            if next == -1 || dist[j] < dist[next] {
                next = j
            }
        }
        
        marked[next] = true
        res = res + dist[next]
        
        //calculate the new dist for other points
        for j:=0;j<n;j++ {
            if !marked[j] {
                d:= distance(points, next, j)
                if d < dist[j] {
                    dist[j] = d
                }
            }
        }
    }
    
    return res
}

func distance(points [][]int, a int, b int) int {
    dx, dy := points[a][0] - points[b][0], points[a][1] - points[b][1]
    if dx < 0 {
        dx = -dx
    }
    
    if dy < 0 {
        dy = -dy
    }
    
    return dx + dy
}