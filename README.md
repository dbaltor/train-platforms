# Number of platforms required in a train station

## Problem
You have a train station and a timetable for that train station (the arrivals and departures of trains)

The goal is to create a function that returns the minimum number of platforms needed to accommodate the timetable.

For example:
```
timetable: [(900, 1000), (815, 915), (955, 1005), (450, 1010)]

                     900_______________1000
          815____________915
                                     955_________1005
 450_________________________________________________1010

Required platforms:
0  1        2          3   2           3  2         1   0
```

## Examples
Timetable: `[(10, 11), (12, 13), (14, 15), (09, 20)]`

Expected answer: 2  

Timetable: `[(900, 1000), (815, 915), (955, 1005), (450, 1010)]`

Expected answer: 3  
