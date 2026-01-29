# Algorithm Learning Project (Java)

This repository contains Java implementations of algorithms and data structures following a systematic learning approach. You can also refer to my blog:https://www.alexsuperman.cn/

---

## Project Overview

The goal of this project is to provide clean, well-documented Java implementations of common algorithms and data structures. Each implementation includes detailed explanations and complexity analysis.

---

## Contents

### 1. Sorting Algorithms
- **Bubble Sort** – O(n²) time, O(1) space  
- **Selection Sort** – O(n²) time, O(1) space  
- **Insertion Sort** – O(n²) time, O(1) space  
- **Merge Sort** – O(n log n) time, O(n) space  
- **Quick Sort** – O(n log n) time, O(log n) space  
- **Heap Sort** – O(n log n) time, O(1) space  

### 2. Searching Algorithms
- **Linear Search** – O(n) time, O(1) space  
- **Binary Search** – O(log n) time, O(1) space  
- **Interpolation Search** – O(log log n) average time  

### 3. Data Structures
- Arrays – Basic operations and manipulations  
- Linked Lists – Singly, Doubly, Circular  
- Stacks – Array and Linked List implementations  
- Queues – Simple, Circular, Priority  
- Hash Tables – Separate chaining, Open addressing  
- Trees – Binary Trees, BST, AVL, Heaps  
- Graphs – Adjacency Matrix/List representations  

### 4. Algorithm Techniques
- Recursion – Factorial, Fibonacci, Tower of Hanoi  
- Divide and Conquer – Merge Sort, Quick Sort  
- Dynamic Programming – Fibonacci, Knapsack, LCS  
- Greedy Algorithms – Dijkstra, Prim, Kruskal  
- Backtracking – N-Queens, Sudoku  
- Two Pointers – Pair sum, Container with most water  

---

## Project Structure

```text
src/main/java/com/algorithms/
├── sorting/
│   ├── BubbleSort.java
│   ├── SelectionSort.java
│   ├── InsertionSort.java
│   ├── MergeSort.java
│   ├── QuickSort.java
│   └── HeapSort.java
├── searching/
│   ├── LinearSearch.java
│   ├── BinarySearch.java
│   └── InterpolationSearch.java
├── datastructures/
│   ├── arrays/
│   ├── linkedlist/
│   ├── stack/
│   ├── queue/
│   ├── hashtable/
│   ├── tree/
│   └── graph/
├── techniques/
│   ├── recursion/
│   ├── divideandconquer/
│   ├── dynamicprogramming/
│   ├── greedy/
│   ├── backtracking/
│   └── twopointers/
└── utils/
    ├── ArrayUtils.java
    ├── SortUtils.java
    └── PrintUtils.java
```

---

## Binary Search Implementation Example

```java
public class BinarySearch {

    public static int binarySearchIterative(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;

        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}
```

---

## Quick Sort Implementation Example

```java
public class QuickSort {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
```

---

## Complexity Summary

| Algorithm      | Best | Average | Worst | Space |
|---------------|------|---------|-------|-------|
| Bubble Sort   | O(n) | O(n²)   | O(n²) | O(1)  |
| Quick Sort    | O(n log n) | O(n log n) | O(n²) | O(log n) |
| Merge Sort    | O(n log n) | O(n log n) | O(n log n) | O(n) |
| Binary Search | O(1) | O(log n) | O(log n) | O(1) |
| Linear Search | O(1) | O(n) | O(n) | O(1) |

---

## Usage Examples

```java
int[] sortedArray = {1, 3, 5, 7, 9};
int index = BinarySearch.binarySearchIterative(sortedArray, 7);

int[] arr = {64, 34, 25, 12};
QuickSort.quickSort(arr);
```

---

## Learning Resources

### Books
- Introduction to Algorithms (CLRS)
- Algorithms – Robert Sedgewick
- Cracking the Coding Interview

### Online Platforms
- LeetCode
- HackerRank
- GeeksforGeeks
- Program Creek

---

## Prerequisites
- Java 8+
- Basic data structures
- Recursion
- Big-O notation

---

## License
MIT License

> This project is for educational purposes. Implementations favor clarity over production-level optimization.
