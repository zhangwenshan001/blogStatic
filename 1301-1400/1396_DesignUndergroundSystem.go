type UndergroundSystem struct {
    CheckInRecords map[int](map[string]int)
    TotalTimeRecords map[string](map[string]int)
    CountRecords map[string](map[string]int)
}


func Constructor() UndergroundSystem {
    checkInRecords := make(map[int](map[string]int))
    totalTimeRecords := make(map[string](map[string]int))
    countRecords := make(map[string](map[string]int))
    return UndergroundSystem{CheckInRecords:checkInRecords, TotalTimeRecords:totalTimeRecords,CountRecords: countRecords}
}


func (this *UndergroundSystem) CheckIn(id int, stationName string, t int)  {
    this.CheckInRecords[id] = map[string]int{stationName : t}
}


func (this *UndergroundSystem) CheckOut(id int, stationName string, t int)  {
    if cits,ok := this.CheckInRecords[id];ok {
        for startStation, cit := range cits {
            if tsm,ok := this.TotalTimeRecords[startStation];ok {
                if _, ok := tsm[stationName];ok {
                    this.TotalTimeRecords[startStation][stationName] += t - cit
                    this.CountRecords[startStation][stationName] += 1   
                } else {
                    this.TotalTimeRecords[startStation][stationName] = t - cit
                    this.CountRecords[startStation][stationName] = 1
                }
            } else {
                this.TotalTimeRecords[startStation] = map[string]int{stationName : t - cit}
                this.CountRecords[startStation] = map[string]int {stationName: 1}
            }
            // fmt.Println(this.TotalTimeRecords, this.CountRecords)
        } 
    }
}

func (this *UndergroundSystem) GetAverageTime(startStation string, endStation string) float64 {
    // fmt.Println(this.TotalTimeRecords[startStation][endStation], this.CountRecords[startStation][endStation])
    if total, ok := this.TotalTimeRecords[startStation][endStation]; ok {
        return float64(total)/float64(this.CountRecords[startStation][endStation])
    }
    return 0
}


/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * obj := Constructor();
 * obj.CheckIn(id,stationName,t);
 * obj.CheckOut(id,stationName,t);
 * param_3 := obj.GetAverageTime(startStation,endStation);
 */