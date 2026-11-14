import java.util.*;

/**
 * Week 10 — Data Structures and Algorithms Practice Problems
 * Compile: javac Week10DataStructures.java
 * Run:     java Week10DataStructures
 */
public class Week10DataStructures {
    static class Book {
        String isbn, title;
        Book(String isbn, String title) { this.isbn = isbn; this.title = title; }
    }

    // 1. Binary search on catalog sorted by ISBN: O(log n) time, O(1) extra space.
    static String findBook(Book[] catalog, String targetIsbn) {
        int low = 0, high = catalog.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = catalog[mid].isbn.compareTo(targetIsbn);
            if (cmp == 0) return catalog[mid].title;
            if (cmp < 0) low = mid + 1; else high = mid - 1;
        }
        return "Not Found";
    }

    // 2. One grid traversal: O(m*n) time, O(1) extra space.
    static void warehouseSummary(int[][] grid) {
        int total = 0, max = -1, maxRow = -1, maxCol = -1;
        for (int r = 0; r < grid.length; r++)
            for (int c = 0; c < grid[r].length; c++) {
                total += grid[r][c];
                if (grid[r][c] > max) {
                    max = grid[r][c]; maxRow = r; maxCol = c;
                }
            }
        System.out.println("total = " + total + ", maxCoordinate = (" + maxRow + ", " + maxCol + ")");
    }

    // 3. HashSet gives O(n) average time and O(n) space; sorting is O(n log n) time.
    static boolean hasDuplicate(String[] ids) {
        Set<String> seen = new HashSet<>();
        for (String id : ids) if (!seen.add(id)) return true;
        return false;
    }

    // 4. Build once, then average O(1) lookup; O(n) space.
    static Map<String, String> buildLookup(String[][] records) {
        Map<String, String> lookup = new HashMap<>();
        for (String[] record : records) lookup.put(record[0], record[1]);
        return lookup;
    }
    static String getDepartment(Map<String, String> lookup, String id) {
        return lookup.getOrDefault(id, "Unknown");
    }

    // 5. HashSet-based pair search: O(n) average time and O(n) space.
    static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int n : nums) {
            if (seen.contains(target - n)) return true;
            seen.add(n);
        }
        return false;
    }

    // 6. One pass: O(n) time, O(1) space.
    static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, best = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            best = Math.max(best, price - minPrice);
        }
        return best;
    }

    // 7. Binary search insertion point: O(log n) time, O(1) space.
    static int searchInsertPosition(int[] nums, int target) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) low = mid + 1; else high = mid;
        }
        return low;
    }

    // 8. Spiral traversal: O(m*n) time; O(m*n) for returned list.
    static List<Integer> spiralOrder(int[][] grid) {
        List<Integer> result = new ArrayList<>();
        if (grid.length == 0 || grid[0].length == 0) return result;
        int top = 0, bottom = grid.length - 1, left = 0, right = grid[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int c = left; c <= right; c++) result.add(grid[top][c]);
            top++;
            for (int r = top; r <= bottom; r++) result.add(grid[r][right]);
            right--;
            if (top <= bottom) {
                for (int c = right; c >= left; c--) result.add(grid[bottom][c]);
                bottom--;
            }
            if (left <= right) {
                for (int r = bottom; r >= top; r--) result.add(grid[r][left]);
                left++;
            }
        }
        return result;
    }

    // 9. Two pointers on sorted input: O(n) time, O(1) extra space.
    static String pairSumSorted(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) return "(" + nums[left] + ", " + nums[right] + ")";
            if (sum < target) left++; else right--;
        }
        return "Not Found";
    }

    // 10. In-place two-pointer compaction: O(n) time, O(1) extra space.
    static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int unique = 1;
        for (int i = 1; i < nums.length; i++)
            if (nums[i] != nums[unique - 1]) nums[unique++] = nums[i];
        return unique;
    }

    public static void main(String[] args) {
        Book[] books = {new Book("0001112223","Introduction to Algebra"),
                new Book("0002223334","Beginning Python"),
                new Book("0003334445","Classic Mythology")};
        System.out.println(findBook(books, "0003334445"));
        warehouseSummary(new int[][]{{4,9,2},{7,1,6},{3,12,5}});
        System.out.println(hasDuplicate(new String[]{"TXN1","TXN2","TXN1"}));
        Map<String,String> lookup = buildLookup(new String[][]{{"E245","Finance"},{"E110","Engineering"}});
        System.out.println(getDepartment(lookup, "E245"));
        System.out.println(hasPairWithSum(new int[]{2,7,11,15}, 9));
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(searchInsertPosition(new int[]{1,3,5,6}, 2));
        System.out.println(spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        System.out.println(pairSumSorted(new int[]{-4,-1,0,3,5,9}, 4));
        int[] values = {1,1,2,2,2,3,4,4,5};
        int k = removeDuplicates(values);
        System.out.println("length = " + k + ", nums[0.." + (k-1) + "] = " +
                Arrays.toString(Arrays.copyOf(values, k)));
    }
}
