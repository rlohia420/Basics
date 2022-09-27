Knapsack problem:
wt[] = {1, 2, 3}
v[] = {10, 15, 40}
wt = 6

   0   1   2   3   4   5   6

0  0   0   0   0   0   0   0

1  0  10  10  10  10  10  10

2  0  10  15  25  25  25  25

3  0  10  15  40  50  55  65


subsetSum problem :
set[]={3, 4, 5, 2}
target=6

    0    1    2    3    4    5    6

0   T    F    F    F    F    F    F

3   T    F    F    T    F    F    F
     
4   T    F    F    T    T    F    F   
      
5   T    F    F    T    T    T    F

2   T    F    T    T    T    T    T




String operations:
1.Permutation of string - i/p - abc , o/p - abc,acb,bca,bac,cab,cba
2.Arrangement asc - > i/p ={"hen","dog","cat","cat","hen","cat","rat","dog"}
 o/p - {"rat","dog","dog","hen","hen","cat","cat","cat"}
3. Arrangement Desc - i/p ->  {"hen","dog","cat","cat","hen","cat","rat","dog"}
o/p -> {"cat","cat","cat","dog","dog","hen","hen","rat"}
4. Count of anagram of all subsequences:
i/p: abc , o/p -> a,ab,abc,ac,acb,b,ba,bac,bc,bca,c,ca,cab,cb,cba







