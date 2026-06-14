/*
# 🌊 2D Array Column-wise Wave Print

## Problem Statement
Given a 2D matrix/array `matrix` of dimensions `n x m`, traverse and print its elements in a continuous **Column-wise Wave (Zig-Zag)** form. 

The movement behaves like a vertical wave across the grid:
* Go **down** the first column (Index 0).
* Go **up** the second column (Index 1).
* Go **down** the third column (Index 2), and so on.

### The Indexing Logic
* For any **Even Column** (`j = 0, 2, 4, ...`), rows are traversed from top to bottom: index `0` to `n-1`.
* For any **Odd Column** (`j = 1, 3, 5, ...`), rows are traversed from bottom to top: index `n-1` to `0`.

---

## Input Format
* The first line contains two integers `n` (Rows) and `m` (Columns).
* The next `n` lines contain `m` space-separated integers representing the rows of the matrix.

## Output Format
* Print a single line of space-separated integers representing the complete wave traversal.

---

## Examples

### Example 1: Standard Square Matrix (3 x 3)
**Input:**
```text
3 3
1 2 3
4 5 6
7 8 9
*/

//     SOLUTION        //

void wave(int[][] arr) {
   for(int j = 0; j < arr[0].length; j++){
       if(j%2==0){
           for(int i = 0; i < arr.length; i++){
                  System.out.print(arr[i][j] + " ");
           }
              System.out.println();
      }
       else{
           for(int i = arr.length-1; i>=0; i--){
              System.out.print(arr[i][j] + " ");
           }
             System.out.println();
       }
   }
}
