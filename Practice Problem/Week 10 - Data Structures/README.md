# Week 10 — Data Structures

This folder contains all 10 coding problems from the Week 10 Category C PDF.

## Problems
1. Library catalog lookup — binary search
2. Warehouse bin grid scan — 2D traversal
3. Transaction duplicate check — hash set
4. Employee ID lookup — hash map
5. Pair with target sum (unsorted) — hash set
6. Best single trade profit — one-pass scan
7. Insert position in a sorted list — binary search
8. Spiral order traversal — boundary traversal
9. Pair sum in a sorted array — two pointers
10. Remove duplicates from a sorted array in-place — two pointers

## Run
Each file is a standalone Java program. Example:

```bash
javac 01_LibraryCatalogLookup.java
java LibraryCatalogLookup
```

Use the matching filename and class name for each problem. Input-based problems read from standard input; examples with fixed test data demonstrate the required method.

## Complexity summary
| Problem | Time | Extra space |
|---|---:|---:|
| 1. Binary search | O(log n) | O(1) |
| 2. Grid scan | O(m × n) | O(1) |
| 3. Duplicate check | O(n) average | O(n) |
| 4. Build map / lookup | O(n) build, O(1) average lookup | O(n) |
| 5. Target sum | O(n) average | O(n) |
| 6. Best trade | O(n) | O(1) |
| 7. Insert position | O(log n) | O(1) |
| 8. Spiral traversal | O(m × n) | O(m × n) output |
| 9. Sorted pair sum | O(n) | O(1) |
| 10. Remove duplicates | O(n) | O(1) |

Only Part A coding problems are included. Quiz and concept questions are not separate coding exercises.