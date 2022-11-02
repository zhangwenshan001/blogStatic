func shortestAlternatingPaths(n int, redEdges [][]int, blueEdges [][]int) []int {
    redAdj := getAdj(n, redEdges)
    blueAdj := getAdj(n, blueEdges)
    
    return minDist(shortestPathsFrom(true, redAdj, blueAdj, n), shortestPathsFrom(false, redAdj, blueAdj, n))
}


func shortestPathsFrom(startFromRed bool, redAdj [][]int, blueAdj [][]int, n int) []int {
    distStartFromRed := make([]int, n)
    distStartFromBlue := make([]int, n)
    
    for i:=0;i<n;i++ {
        distStartFromRed[i] = -1
        distStartFromBlue[i] = -1
    }
    
    fromRedMarked := make([]bool, n)
    fromBlueMarked := make([]bool, n)

    var fromRedQueue []int
    var fromBlueQueue []int
    
    if startFromRed {
        distStartFromBlue[0] = 0
        fromBlueMarked[0] = true
        fromBlueQueue = append(fromBlueQueue, 0)
    } else {
        distStartFromRed[0] = 0
        fromRedMarked[0] =true
        fromRedQueue = append(fromRedQueue, 0)
    }  
    
    needRed := startFromRed
    for needRed && len(fromBlueQueue) > 0 || !needRed && len(fromRedQueue) > 0 {
        if needRed {
            cur := fromBlueQueue[0]
            for _,w := range redAdj[cur] {
                if !fromRedMarked[w] {
                    fromRedMarked[w] = true
                    fromRedQueue = append(fromRedQueue, w)
                    if distStartFromRed[w] < 0 {
                        distStartFromRed[w] = distStartFromBlue[cur] + 1
                    }
                }
            }
            fromBlueQueue = fromBlueQueue[1:]
            if len(fromBlueQueue) == 0 {
                needRed = !needRed
            }
        } else {
            cur := fromRedQueue[0]
            for _,w := range blueAdj[cur] {
                if !fromBlueMarked[w] {
                    fromBlueMarked[w] = true
                    fromBlueQueue = append(fromBlueQueue, w)
                    if distStartFromBlue[w] < 0 {
                        distStartFromBlue[w] =  distStartFromRed[cur] + 1
                    }
                }
            }
            fromRedQueue = fromRedQueue[1:]
            if len(fromRedQueue) == 0 {
                needRed = !needRed
            }
        }
        
    }
    
    return minDist(distStartFromRed, distStartFromBlue)
}

func minDist(dist1 []int, dist2 []int) []int {
    n := len(dist1)
    dist := make([]int, n)
    for i:=0;i<n;i++ {
        if dist1[i] < 0 && dist2[i] < 0 {
            dist[i] = -1
        } else if dist1[i] >= 0 && dist2[i] < 0{
            dist[i] = dist1[i]
        } else if dist1[i] < 0 && dist2[i] >=0 {
            dist[i] = dist2[i]
        } else {
            if dist1[i] <= dist2[i] {
                dist[i] = dist1[i]
            } else {
                dist[i] = dist2[i]
            }
        }
    }
    
    return dist
}

func getAdj(n int, edges [][]int) [][]int {
    adj := make([][]int, n)
    for _, edge := range edges {
        adj[edge[0]] = append(adj[edge[0]], edge[1])
    }
    
    return adj
}